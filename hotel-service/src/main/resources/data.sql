DROP TABLE IF EXISTS hotel;

CREATE TABLE `hotel` (
  `hotel_id` int NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(100) NOT NULL,
  `hotel_address` varchar(100) NOT NULL,
  PRIMARY KEY (`hotel_id`)
);


INSERT INTO `hotel` (`hotel_name`, `hotel_address`)
 VALUES ('Hotel Ibis', 'Santiago Oriente 342');
 
 INSERT INTO `hotel` (`hotel_name`, `hotel_address`)
 VALUES ('Hotel Transilvania', 'Calle transilvania 444');