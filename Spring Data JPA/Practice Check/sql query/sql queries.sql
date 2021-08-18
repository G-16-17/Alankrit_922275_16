CREATE DATABASE truyum;
use truyum;

CREATE TABLE `menu_item` (
  `mi_id` int NOT NULL AUTO_INCREMENT,
  `mi_name` varchar(100) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `mi_active` tinyint(1) NOT NULL,
  `mi_date_of_launch` date DEFAULT NULL,
  `mi_category` varchar(45) DEFAULT NULL,
  `mi_free_delivery` tinyint(1) NOT NULL,
  PRIMARY KEY (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `user` (
  `us_id` int NOT NULL AUTO_INCREMENT,
  `us_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `cart` (
  `ct_id` int NOT NULL AUTO_INCREMENT,
  `ct_us_id` int DEFAULT NULL,
  `ct_pr_id` int DEFAULT NULL,
  PRIMARY KEY (`ct_id`),
  KEY `ct_us_id` (`ct_us_id`),
  KEY `ct_pr_id` (`ct_pr_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`ct_us_id`) REFERENCES `user` (`us_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`ct_pr_id`) REFERENCES `menu_item` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci