create table stock (
	id int not null auto_increment primary key,
	extra_data json
);



select * from stock;



insert into stock(extra_data) values
('{"name": "Apple", "total_price": 25, "details": {"quantity": 5, "discounted_price": 5}}'),
('{"name": "Orange", "total_price": 10, "details": {"quantity": 2, "old_price": 5}}'),
('{"name": "Nail", "total_price": 4, "details": {"quantity": 3, "order": 2}}');




select extra_data->>'$.name' from stock where extra_data->>'$.details.quantity'  > 2;