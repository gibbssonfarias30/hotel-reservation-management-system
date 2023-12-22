DROP TABLE IF EXISTS room;

CREATE TABLE `room` (
  `room_id` int NOT NULL AUTO_INCREMENT,
  `hotel_id` int NOT NULL,
  `room_name` varchar(100) NOT NULL,
  `room_available` varchar(100) NOT NULL,
  PRIMARY KEY (`room_id`)
);


INSERT INTO `room` (`hotel_id`,`room_name`, `room_available`)
 VALUES (1, 'Pieza 201', 'Si');
 
 INSERT INTO `room` (`hotel_id`,`room_name`, `room_available`)
 VALUES (1, 'Pieza 301', 'Si');
 
  INSERT INTO `room` (`hotel_id`,`room_name`, `room_available`)
 VALUES (2, 'Pieza 101', 'No');