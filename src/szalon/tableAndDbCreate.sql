create database orabolt;

use orabolt;

create table orak (
ID int auto_increment unique ,
name varchar(50) not null,
tipus varchar(20) not null,
ar int,
vizallo BOOLEAN default false
);

INSERT INTO `orak` (`ID`, `name`, `tipus`, `ar`, `vizallo`) VALUES (NULL, 'Festina', 'kar�ra', '110000', '1');
INSERT INTO `orak` (`ID`, `name`, `tipus`, `ar`, `vizallo`) VALUES (NULL, 'Casio', 'kar�ra', '34000', '1');
INSERT INTO `orak` (`ID`, `name`, `tipus`, `ar`, `vizallo`) VALUES (NULL, 'Rolex', 'kar�ra', '1000000', '1');
INSERT INTO `orak` (`ID`, `name`, `tipus`, `ar`, `vizallo`) VALUES (NULL, 'Hama', '�breszt��ra', '4400', '0');