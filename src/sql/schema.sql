-- CREATE SCHEMA `mrs` ;

DROP TABLE IF EXISTS `volunteer_availability`;
DROP TABLE IF EXISTS `meeting_volunteer`;
DROP TABLE IF EXISTS `meeting`;
DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host` boolean NOT NULL,
  `volunteer` boolean NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `travel_range` int DEFAULT NULL,
  `sobriety_date` varchar(255) DEFAULT NULL,
  `active` boolean NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volunteer_availability` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `volunteer_user_id` bigint DEFAULT NULL,
  `day_of_week` int NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_volunteer_availability_volunteer_user_id` FOREIGN KEY (`volunteer_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_user_id` bigint NOT NULL,
  `date_time` datetime NOT NULL,
  `minute_of_day` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_meeting_host_user_id` FOREIGN KEY (`host_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting_volunteer` (
  `meeting_id` bigint NOT NULL,
  `volunteer_user_id` bigint NOT NULL,
  PRIMARY KEY (`meeting_id`, `volunteer_user_id`),
  CONSTRAINT `fk_meeting_volunteer_meeting_id` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`),
  CONSTRAINT `fk_meeting_volunteer_volunteer_user_id` FOREIGN KEY (`volunteer_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipcode_point` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `zipcode` char(5) NOT NULL,
  `point` point NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
