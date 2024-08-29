-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: big_event
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(30) NOT NULL COMMENT '文章标题',
  `content` varchar(10000) NOT NULL COMMENT '文章内容',
  `cover_img` varchar(128) NOT NULL COMMENT '文章封面',
  `state` varchar(3) DEFAULT '草稿' COMMENT '文章状态: 只能是[已发布] 或者 [草稿]',
  `category_id` int unsigned DEFAULT NULL COMMENT '文章分类ID',
  `create_user` int unsigned NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `fk_article_user` (`create_user`),
  KEY `article_category_id_fk` (`category_id`),
  CONSTRAINT `article_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_article_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

INSERT INTO `article` VALUES (6,'欢乐海滩','<p>暑期来临，快来海滩清凉一下吧？</p>','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/1f3c2502-9feb-43f5-b5b1-15755dfd12b2.webp','已发布',8,1,'2024-08-19 22:56:03','2024-08-20 22:03:39'),(7,'荀彧和荀攸的关系','<ul><li>荀彧和荀攸<u>是叔</u><strong><u>侄关系</u></strong><span class=\"ql-cursor\">﻿﻿</span></li></ul>','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/130d8871-0f77-4fa9-9d6a-85d6f429b0c6.png','已发布',6,1,'2024-08-19 22:59:18','2024-08-20 21:25:59'),(9,'快乐每一天','<p><span class=\"ql-cursor\">﻿﻿</span></p>','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/ca99bde3-0fff-46ef-b755-1cb97185810b.webp','已发布',19,1,'2024-08-20 21:30:42','2024-08-20 21:30:42'),(10,'国学怎么学？','<p>国学很难</p>','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/72c0ab38-00c6-4beb-b842-29874e325634.webp','草稿',6,1,'2024-08-20 21:32:54','2024-08-20 21:42:54'),(11,'影流之主','<p>影流之主，魔性舞蹈，等你一起<strong>跳</strong></p>','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/00d0f1cf-b558-4010-bb15-89be63fab9c1.jpg','已发布',4,2,'2024-08-21 16:34:25','2024-08-21 16:34:25');

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(32) NOT NULL COMMENT '分类名称',
  `category_alias` varchar(32) NOT NULL COMMENT '分类别名',
  `create_user` int unsigned NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `fk_category_user` (`create_user`),
  CONSTRAINT `fk_category_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

INSERT INTO `category` VALUES (2,'神佛','sf',2,'2024-08-04 22:20:43','2024-08-05 22:32:52'),(3,'编程','code',2,'2024-08-04 22:22:13','2024-08-04 22:50:36'),(4,'鬼畜','gc',2,'2024-08-04 22:56:38','2024-08-04 22:57:21'),(6,'人文','rw',1,'2024-08-16 13:49:06','2024-08-16 13:49:06'),(8,'海边','sea',1,'2024-08-16 14:05:12','2024-08-16 14:05:12'),(19,'快乐','joy',1,'2024-08-16 15:02:30','2024-08-16 15:02:37');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(10) DEFAULT '' COMMENT '昵称',
  `email` varchar(128) DEFAULT '' COMMENT '邮箱',
  `user_pic` varchar(128) DEFAULT '' COMMENT '头像',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (1,'3298232021','$2a$10$5UQLgdninLtIk6rTIzva0.DC1JKCN0R.lNEjMeNUrPMKUJ0aUGKjS','zank','3298232021@qq.com','https://bigeventforzank.oss-cn-hangzhou.aliyuncs.com/event/432461da-571a-4434-b348-c416581716f1.jpg','2024-08-03 22:57:08','2024-08-30 00:24:00'),(2,'3039847307','$2a$10$RzAkxDbBc3k8LtKo.0ycne0TmDPMT17BYKqHIW6tQ6x8kAoG84kOi','','','','2024-08-03 22:58:19','2024-08-03 22:58:19'),(3,'123456','$2a$10$JUGh06hdUtbJggzPz4HvcO1V6KPTsT/8KgYWuN5fiskpX5CaBElRy','','','','2024-08-12 22:07:11','2024-08-12 22:07:11'),(4,'20040902','$2a$10$7YJJv87eTJuH5YE/Y7nfFenb0/LcHAuGXGjD0MPB5Py3Gswe3/uZS','','','','2024-08-12 22:08:24','2024-08-12 22:08:24'),(5,'19170925725','$2a$10$hbtDB7izhT8P3o8C/43tPerAT/T0qEWvJp6OUPYAnzZkoUv4UI1yi','','','','2024-08-12 22:18:11','2024-08-12 22:18:11'),(6,'18942335076','$2a$10$rAxhwJYctHmLXRduqbriaOBzgyUW9Iera6cjTVGOHVBhWCGpF6D8W','','','','2024-08-12 22:22:47','2024-08-12 22:22:47'),(7,'111111','$2a$10$Lv.Uka3QX0RWxuRZYZ1lyO8.EMJVwsJOwggJ/M2bF3raglZ38q/wm','','','','2024-08-12 22:29:22','2024-08-12 22:29:22'),(8,'222222','$2a$10$YdzyNGPGTL5Detqxcwll1u4uUeYqcGVJvajYy/qNrfURhXAE1Xgm2','','','','2024-08-12 22:31:44','2024-08-12 22:31:44'),(9,'333333','$2a$10$T5ap4hriFpjVLgHyB4zDQu/lxofZUN5VroIFRfOiR79S6yn0FfgBG','','','','2024-08-12 22:34:54','2024-08-12 22:34:54'),(10,'204922','$2a$10$Yr0IGImaa3K2.BNrtrUD3eWKoTp65mlq0skkRr46jGq3CKrgZY4Aa','','','','2024-08-13 22:32:04','2024-08-13 22:32:04'),(11,'1233321','$2a$10$AMWU/IIPHyM7lEQmL6gucebu9wlCuvLj8X7RSbbsCzvgpoqP7tRj2','','','','2024-08-13 22:38:56','2024-08-13 22:38:56'),(12,'12345622','$2a$10$C0gqBYgypzWXen7BnHB.x.TxoYlUAoS6OWiU6pIwn2e0OUHZ0lMpa','','','','2024-08-13 22:45:51','2024-08-13 22:45:51'),(13,'15323412','$2a$10$dztS4TV8PoKFjZ1bFqWUv.w0xLl207pnzlg1jQnvooSkaGaCEwu/G','','','','2024-08-13 22:47:12','2024-08-13 22:47:12');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-30  0:31:51
