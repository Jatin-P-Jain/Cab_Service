drop database if exists infycab_db;
create database infycab_db;
use  infycab_db;

create table Booking(
	booking_id int primary key auto_increment,
	user_mobile BIGINT(10),
	source varchar(15),
	destination varchar(10),
	fare float(9,2),
	travel_date DATE,
	status CHAR NOT NULL
);


create table Fare(
	fare_id int primary key,
	source varchar(15),
	destination varchar(15),
	fare float(9,2)
);

insert into Fare values(1,'San Jose','Los Angles',340);
insert into Fare values(2,'San Francisco','San Jose',48);
insert into Fare values(3,'Los Angles','San Diego',120);
insert into Fare values(4,'Pheonix','Tucson',114);

insert into Booking values(1,9877766756,'San Jose','Los Angles',340,sysdate()+2,'B');
insert into Booking values(2,8898766766,'San Francisco','San Jose',48,sysdate()+4,'B');

commit;

select * from Fare;
select * from Booking;

