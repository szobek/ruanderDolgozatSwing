create database oraSzalon;

use oraSzalon;

create table orak (
ID int auto_increment unique ,
name vachar(50) not null,
tipus varchar(10) not null,
ar int,
vizallo BOOLEAN default false
);