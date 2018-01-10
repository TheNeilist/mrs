-- CREATE SCHEMA `mrs` ;

DROP TABLE IF EXISTS `attendee_availability`;
DROP TABLE IF EXISTS `meeting_attendee`;
DROP TABLE IF EXISTS `meeting`;
DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host` boolean NOT NULL,
  `volunteer` boolean NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL UNIQUE,
  `phone` varchar(255) DEFAULT NULL,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  `travel_range` int NOT NULL,
  `sobriety_date` varchar(255) DEFAULT NULL,
  `auth_token` varchar(255) DEFAULT NULL,
  `auth_expiration` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendee_availability` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attendee_user_id` bigint DEFAULT NULL,
  `day_of_week` varchar(255) NOT NULL,
  `start_time` time,
  `end_time` time,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_attendee_availability_attendee_user_id` FOREIGN KEY (`attendee_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `host_user_id` bigint DEFAULT NULL,
  `date_time` datetime,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_meeting_host_user_id` FOREIGN KEY (`host_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting_attendee` (
  `meeting_id` bigint NOT NULL,
  `attendee_user_id` bigint NOT NULL,
  PRIMARY KEY (`meeting_id`, `attendee_user_id`),
  CONSTRAINT `fk_meeting_attendee_meeting_id` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`id`),
  CONSTRAINT `fk_meeting_attendee_attendee_user_id` FOREIGN KEY (`attendee_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
