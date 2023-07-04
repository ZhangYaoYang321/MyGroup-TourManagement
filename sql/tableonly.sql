/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.10-log : Database - tourmgtsys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tourmgtsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tourmgtsys`;

/*Table structure for table `self_hotel_orders` */

DROP TABLE IF EXISTS `self_hotel_orders`;

CREATE TABLE `self_hotel_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `cn_id` varchar(255) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `start_day` varchar(10) DEFAULT NULL,
  `end_day` varchar(10) DEFAULT NULL,
  `type_room` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `self_hotel_orders_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COMMENT='酒店订单表';

/*Data for the table `self_hotel_orders` */

insert  into `self_hotel_orders`(`id`,`order_id`,`cn_id`,`room_id`,`start_day`,`end_day`,`type_room`) values (60,2023062816380514,'11223344556',104,'2023-06-04','2023-06-12','标准间'),(61,2023062820005612,'123456',120,'2023-06-04','2023-06-07','家庭套房');

/*Table structure for table `self_hotel_rooms` */

DROP TABLE IF EXISTS `self_hotel_rooms`;

CREATE TABLE `self_hotel_rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `type_room` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `state_room` varchar(4) CHARACTER SET utf8 DEFAULT NULL,
  `room_date` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `self_hotel_rooms_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COMMENT='房间表';

/*Data for the table `self_hotel_rooms` */

insert  into `self_hotel_rooms`(`id`,`room_id`,`type_room`,`order_id`,`state_room`,`room_date`) values (144,104,'标准间',2023062816380514,'已预约','2023-6-4'),(145,104,'标准间',2023062816380514,'已预约','2023-6-5'),(146,104,'标准间',2023062816380514,'已预约','2023-6-6'),(147,104,'标准间',2023062816380514,'已预约','2023-6-7'),(148,104,'标准间',2023062816380514,'已预约','2023-6-8'),(149,104,'标准间',2023062816380514,'已预约','2023-6-9'),(150,104,'标准间',2023062816380514,'已预约','2023-6-10'),(151,104,'标准间',2023062816380514,'已预约','2023-6-11'),(152,104,'标准间',2023062816380514,'已预约','2023-6-12'),(153,120,'家庭套房',2023062820005612,'已预约','2023-6-4'),(154,120,'家庭套房',2023062820005612,'已预约','2023-6-5'),(155,120,'家庭套房',2023062820005612,'已预约','2023-6-6'),(156,120,'家庭套房',2023062820005612,'已预约','2023-6-7');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
