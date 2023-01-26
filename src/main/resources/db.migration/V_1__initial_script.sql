DROP DATABASE IF EXISTS shop;
CREATE DATABASE shop;

USE shop;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
userID BIGINT NOT NULL AUTO_INCREMENT,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL, 
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50) NOT NULL,
userRole VARCHAR (20) NOT NULL, 
isActive BOOLEAN NOT NULL DEFAULT true,
PRIMARY KEY (userID)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS product;
CREATE TABLE product (
 productID bigint NOT NULL AUTO_INCREMENT,
 name VARCHAR(50),
 description VARCHAR(50),
 price decimal(10,2),
 PRIMARY KEY (productID)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS holiday;
CREATE TABLE holiday(
holidayID BIGINT NOT NULL AUTO_INCREMENT,
timeOpen TIMESTAMP NOT NULL ,
timeClose TIMESTAMP NOT NULL, 
title VARCHAR(50) NOT NULL,
PRIMARY KEY(holidayID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table if exists shop;
create table shop(
  shopID bigint NOT NULL auto_increment,
  shopName varchar(50),
  address varchar(50),
  shopOwnerID bigint ,
  timeOpen timestamp,
  timeClose timestamp,
  holidayID bigint,
  PRIMARY KEY (shopID),
  foreign key(shopOwnerID) references user(userID) on delete cascade,
  foreign key(holidayID) references Holiday(holidayID) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  orderID BIGINT NOT NULL AUTO_INCREMENT,
  courierID BIGINT DEFAULT NULL,
  customerID BIGINT DEFAULT NULL,
  shopID BIGINT DEFAULT NULL,
  status VARCHAR(255) DEFAULT NULL,
  address VARCHAR(255) DEFAULT NULL,
  fullprice decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (orderID),
  KEY courierID (courierID),
  KEY customerID (customerID),
  KEY shopID (shopID),
  CONSTRAINT order_ibfk_1 FOREIGN KEY (courierID) REFERENCES User (userID) ON DELETE CASCADE,
  CONSTRAINT order_ibfk_2 FOREIGN KEY (customerID) REFERENCES User (userID) ON DELETE CASCADE,
  CONSTRAINT order_ibfk_3 FOREIGN KEY (shopID) REFERENCES Shop (ShopID) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS storage;
CREATE TABLE storage(
storageID BIGINT NOT NULL AUTO_INCREMENT,
shopID BIGINT,
productID bigint,
available BOOLEAN,
PRIMARY KEY(storageID),
FOREIGN KEY(shopID) references shop(shopID) on delete cascade,
FOREIGN KEY(productID) references product(productID) on delete cascade
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS orderDetails;
CREATE TABLE orderDetails(
productID BIGINT NOT NULL ,
amount INT NOT NULL,
orderID BIGINT NOT NULL,
foreign key (productID) references product(productID) on delete cascade,
FOREIGN KEY (orderID) references `order`(orderID) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
