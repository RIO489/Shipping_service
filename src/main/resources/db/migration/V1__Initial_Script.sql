USE shop_1;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
id BIGINT NOT NULL AUTO_INCREMENT,
email VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
user_role VARCHAR (20) NOT NULL,
is_active BOOLEAN NOT NULL DEFAULT true,
PRIMARY KEY (id)

) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS product;
CREATE TABLE product (
 id bigint NOT NULL AUTO_INCREMENT,
 name VARCHAR(50),
 description VARCHAR(50),
 price decimal(10,2),
 PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS holiday;
CREATE TABLE holiday(
id BIGINT NOT NULL AUTO_INCREMENT,
time_open TIMESTAMP NOT NULL ,
time_close TIMESTAMP NOT NULL,
title VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

drop table if exists shop;
create table shop(
  id bigint NOT NULL auto_increment,
  shop_name varchar(50),
  address varchar(50),
  shop_owner_id bigint ,
  time_open timestamp,
  time_close timestamp,
  holiday_id bigint,
  PRIMARY KEY (id),
  foreign key(shop_owner_id) references user(id) on delete cascade,
  foreign key(holiday_id) references Holiday(id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  courier_id BIGINT DEFAULT NULL,
  customer_id BIGINT DEFAULT NULL,
  shop_id BIGINT DEFAULT NULL,
  status VARCHAR(255) DEFAULT NULL,
  address VARCHAR(255) DEFAULT NULL,
  full_price decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT order_ibfk_1 FOREIGN KEY (courier_id) REFERENCES user (id) ON DELETE CASCADE,
  CONSTRAINT order_ibfk_2 FOREIGN KEY (customer_id) REFERENCES user (id) ON DELETE CASCADE,
  CONSTRAINT order_ibfk_3 FOREIGN KEY (shop_id) REFERENCES shop (id) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS storage;
CREATE TABLE storage(
id BIGINT NOT NULL AUTO_INCREMENT,
shop_id BIGINT,
product_id bigint,
available BOOLEAN,
PRIMARY KEY(id),
FOREIGN KEY(shop_id) references shop(id) on delete cascade,
FOREIGN KEY(product_id) references product(id) on delete cascade
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS orderDetails;
CREATE TABLE orderDetails(
product_id BIGINT NOT NULL ,
amount INT NOT NULL,
order_id BIGINT NOT NULL,
foreign key (product_id) references product(id) on delete cascade,
FOREIGN KEY (order_id) references `order`(id) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
