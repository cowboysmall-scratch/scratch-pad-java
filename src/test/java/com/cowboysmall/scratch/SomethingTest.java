package com.cowboysmall.scratch;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SomethingTest {

    @Test
    public void testSomething() throws Exception {

        SparkSession spark =
                SparkSession.builder()
                        .appName("Test App")
                        .master("local[*]")
                        .getOrCreate();

        try (JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext())) {

            StructType schema =
                    DataTypes.createStructType(
                            new StructField[]{
                                    DataTypes.createStructField("id", DataTypes.StringType, true),
                                    DataTypes.createStructField("name", DataTypes.StringType, true),
                                    DataTypes.createStructField("year", DataTypes.StringType, true),
                                    DataTypes.createStructField("score", DataTypes.IntegerType, true)
                            }
                    );

            List<Object[]> data = new ArrayList<>();
            data.add(new Object[]{"1", "First", "2020", 175});
            data.add(new Object[]{"2", "Second", "2021", 100});
            data.add(new Object[]{"3", "Third", "2021", 225});
            data.add(new Object[]{"4", null, "2022", 100});
            data.add(new Object[]{"5", "Second", "2021", 150});
            data.add(new Object[]{"6", "Third", null, 100});
            data.add(new Object[]{"7", "Fourth", "2020", 250});
            data.add(new Object[]{"8", null, null, 100});
            data.add(new Object[]{"9", "First", "2020", 200});
            data.add(new Object[]{"10", "Second", "2021", 250});

            JavaRDD<Row> rows =
                    sparkContext
                            .parallelize(data)
                            .map(RowFactory::create);



            Dataset<Row> dataset =
                    spark.sqlContext().createDataFrame(rows, schema).toDF();

            assertThat(dataset.count(), equalTo(10L));


            Dataset<Row> cleaned =
                    dataset.na().drop("any");

            assertThat(cleaned.count(), equalTo(7L));
            cleaned.show();


            Dataset<Row> filtered =
                    cleaned.filter(cleaned.col("score").gt(150));

            assertThat(filtered.count(), equalTo(5L));
            filtered.show();


            Dataset<Row> grouped =
                    filtered.groupBy("name", "year").max("score");

            assertThat(grouped.count(), equalTo(4L));
            grouped.show();
        }
    }
}
