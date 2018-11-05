CREATE DATABASE `jooqtest`;

CREATE TABLE `AUTHOR` (
  `ID` int not null,
  `FIRST_NAME` varchar(255) default null,
  `LAST_NAME` varchar(255) default null,
  PRIMARY KEY (`ID`)
);