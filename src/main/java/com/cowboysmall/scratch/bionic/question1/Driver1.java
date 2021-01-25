package com.cowboysmall.scratch.bionic.question1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/*
  In the LoggerAOP class, using Spring AOP, intercept all calls to the
  public methods annotated with the LogExecution annotation, and call
  the log method on the logger field with the intercepted method's name
  as the data argument.
 */

public class Driver1 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();

        NameRepository repository = config.getBean(NameRepository.class);
        System.out.println(repository.getNames());
    }
}
