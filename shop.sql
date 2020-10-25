-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `goods_id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(500) NOT NULL COMMENT '商品名',
  `goods_sub_name` varchar(500) NOT NULL COMMENT '副标题',
  `goods_price` int NOT NULL COMMENT '价格',
  `goods_source` varchar(50) NOT NULL COMMENT '商品来源',
  `goods_picture` text COMMENT '图片',
  `goods_describe` text COMMENT '商品描述',
  `goods_type_id` int NOT NULL COMMENT '类型ID',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Coca-Cola 可乐瓶T恤','简约的纯色基调，宣扬自由轻松的休闲氛围。',1,'日本','SZFvXXaT1.jpg,SZFvXXaT2.jpg,SZFvXXaT3.jpg,SZFvXXaT4.jpg,SZFvXXaT5.jpg','![](TB11FXw1.jpg)![](TB11FXw2.jpg)(center,black,block,14)::重要说明(center,black,block,14)::可乐瓶的位置随着尺码不同而不同，其原因咨询过专柜店长，答复如下：(center,black,block,14)::此款商品的工艺是先印染，再裁剪。(center,black,block,14)::所以尺码越小，瓶子月接近底部边线，甚至会有平底缺失（如S码无平底，M码平底压线）(center,black,block,14)::尺码越大，瓶子底部越远离底部边线，达到官方概念图的效果（如L码，和 XL码）(center,black,block,14)::并且每件衣服裁剪的程度不同也会存在同一尺码瓶子位置有偏差。(center,black,block,14)::综上，介意的亲慎重考虑后再下单，切勿因此产生不必要的麻烦，。![](TB11FXw3.jpg)![](TB11FXw4.jpg)![](TB11FXw5.jpg)![](TB11FXw6.jpg)![](TB11FXw7.jpg)![](TB11FXw8.jpg)![](TB11FXw9.jpg)![](TB11FXw10.jpg)(center,#e6232b,block,16)::Coca-Cola（コカ�9�9コーラ グッズ） ユニセックス Tシャツ ストローinボトル チャコール',107),(2,'熙薇 浅口复古奶奶鞋','方头设计，演绎出英伦风。',1,'广东广州','O1CN01.jpg,O1CN02.jpg,O1CN03.jpg,O1CN04.jpg,O1CN05.jpg','![](1OaFGEj1.jpg)![](1OaFGEj2.jpg)![](1OaFGEj3.jpg)![](1OaFGEj4.jpg)![](1OaFGEj5.jpg)![](1OaFGEj6.jpg)![](1OaFGEj7.jpg)![](1OaFGEj8.jpg)![](1OaFGEj9.jpg)![](1OaFGEj10.jpg)![](1OaFGEj11.jpg)![](1OaFGEj12.jpg)![](1OaFGEj13.jpg)![](1OaFGEj14.jpg)![](1OaFGEj15.jpg)![](1OaFGEj16.jpg)',130),(3,'萌系卡通咖啡杯','创意立体可爱萌系动物陶瓷杯子马克杯带盖勺牛奶杯情侣茶水咖啡杯',1,'广东深圳','TB2jfzp.webp,TB2jfzp2.jpg,TB2jfzp3.jpg,TB2jfzp4.jpg,TB2jfzp5.jpg','![](Vbv61vpi1.jpg)![](Vbv61vpi2.jpg)![](Vbv61vpi3.jpg)![](Vbv61vpi4.jpg)![](Vbv61vpi5.jpg)![](Vbv61vpi6.jpg)![](Vbv61vpi7.jpg)![](Vbv61vpi8.jpg)![](Vbv61vpi9.jpg)![](Vbv61vpi10.jpg)![](Vbv61vpi11.jpg)![](Vbv61vpi12.jpg)![](Vbv61vpi13.jpg)![](Vbv61vpi14.jpg)![](Vbv61vpi15.jpg)![](Vbv61vpi16.jpg)![](Vbv61vpi17.jpg)',132),(4,'大豆家 方头奶奶鞋','软底单鞋女2020新款韩版复古豆豆鞋百搭网红一脚蹬仙女气质奶奶鞋',1,'广东佛山','TB2TF0.jpg,TB2TF01.jpg,TB2TF03.jpg,TB2TF03.jpg,TB2TF04.jpg','![](Ar2DlI9dd1.jpg)![](Ar2DlI9dd2.jpg)![](Ar2DlI9dd3.jpg)![](Ar2DlI9dd4.jpg)![](Ar2DlI9dd5.jpg)![](Ar2DlI9dd6.jpg)![](Ar2DlI9dd7.jpg)![](Ar2DlI9dd8.jpg)![](Ar2DlI9dd9.jpg)![](Ar2DlI9dd10.jpg)![](Ar2DlI9dd11.jpg)![](Ar2DlI9dd12.jpg)![](Ar2DlI9dd13.jpg)![](Ar2DlI9dd14.jpg)![](Ar2DlI9dd15.jpg)![](Ar2DlI9dd16.jpg)![](Ar2DlI9dd17.jpg)![](Ar2DlI9dd18.jpg)![](Ar2DlI9dd19.jpg)![](Ar2DlI9dd20.jpg)![](Ar2DlI9dd21.jpg)![](Ar2DlI9dd22.jpg)![](Ar2DlI9dd23.jpg)![](Ar2DlI9dd24.jpg)![](Ar2DlI9dd25.jpg)',130),(5,'抱枕选的好，家的颜值大提升','北欧现代简约风格沙发靠垫办公室抱枕床头靠枕汽车靠包大靠背腰枕',1,'广东揭阳','TB2YJV.webp,TB2YJV1.jpg,TB2YJV2.jpg,TB2YJV3.jpg,TB2YJV4.jpg','![](Fl0FeXXcJ.jpg)',131),(6,'没有脚的信凳 独特得不可思议','吱音原创 信凳创意北欧设计水曲柳全实木矮凳子家具个性板凳',1,'广东东莞','TB2ASA.webp,TB2ASA1.jpg,TB2ASA2.jpg,TB2ASA3.jpg,TB2ASA4.jpg','![](AJ1t8YLrUE1.jpg)![](AJ1t8YLrUE2.jpg)![](AJ1t8YLrUE3.jpg)![](AJ1t8YLrUE4.jpg)![](AJ1t8YLrUE5.jpg)![](AJ1t8YLrUE6.jpg)![](AJ1t8YLrUE7.jpg)![](AJ1t8YLrUE8.jpg)![](AJ1t8YLrUE9.jpg)![](AJ1t8YLrUE10.jpg)![](AJ1t8YLrUE11.jpg)![](AJ1t8YLrUE12.jpg)',133),(7,'甜美学院风连衣裙','很仙的情侣装夏装连衣裙海军领甜美学院风短袖上衣学生套装班服潮',1,'江西南昌','O1CN01NS.jpg,O1CN01NS1.jpg,O1CN01NS2.jpg,O1CN01NS3.jpg,O1CN01NS4.jpg','![](1pwM8751.jpg)![](1pwM8752.jpg)![](1pwM8753.jpg)![](1pwM8754.jpg)![](1pwM8755.jpg)![](1pwM8756.jpg)![](1pwM8757.jpg)![](1pwM8758.jpg)![](1pwM8759.jpg)![](1pwM87510.jpg)![](1pwM87511.jpg)![](1pwM87512.jpg)![](1pwM87513.jpg)![](1pwM87514.jpg)![](1pwM87515.jpg)![](1pwM87516.jpg)![](1pwM87517.jpg)![](1pwM87518.jpg)![](1pwM87519.jpg)![](1pwM87520.jpg)![](1pwM87521.jpg)',120),(8,'很仙的两件连衣裙','很仙的法式情侣装一裙一衣两件夏季同色系露肩连衣裙2020新款裙子',1,'湖南长沙','O1CN01k.jpg,O1CN01k1.jpg,O1CN01k2.jpg,O1CN01k3.jpg,O1CN01k4.jpg','![](1JJ4LNR4h1.jpg)![](1JJ4LNR4h2.jpg)![](1JJ4LNR4h3.jpg)![](1JJ4LNR4h4.jpg)![](1JJ4LNR4h5.jpg)![](1JJ4LNR4h6.jpg)![](1JJ4LNR4h7.jpg)![](1JJ4LNR4h8.jpg)![](1JJ4LNR4h9.jpg)![](1JJ4LNR4h10.jpg)![](1JJ4LNR4h11.jpg)![](1JJ4LNR4h12.jpg)![](1JJ4LNR4h13.jpg)![](1JJ4LNR4h14.jpg)![](1JJ4LNR4h15.jpg)![](1JJ4LNR4h16.jpg)',120),(9,'简洁的桌面 给你一整天的舒畅','书立文件夹收纳盒办公桌书本收纳资料桌面文件框学生宿舍神器',1,'福建厦门','TB21yFr.webp,TB21yFr1.jpg,TB21yFr2.jpg,TB21yFr3.jpg,TB21yFr4.jpg','![](wlfwijvvw1.jpg)![](wlfwijvvw2.jpg)![](wlfwijvvw3.jpg)![](wlfwijvvw4.jpg)',132),(10,'软皮奶奶鞋','方头单鞋女2020春新款平底浅口软皮奶奶鞋',1,'广西南宁','O1CN01j.webp,O1CN01j1.png,O1CN01j2.png,O1CN01j3.png,O1CN01j4.png','![](kjfowjf1.png)![](kjfowjf2.jpg)![](kjfowjf3.jpg)(center,#b22222,block,48)::软趴趴~![](kjfowjf4.gif)(center,#b22222,block,48)::Q弹~![](kjfowjf5.gif)(center,#b22222,block,48)::超防滑~![](kjfowjf6.gif)![](kjfowjf7.png)![](kjfowjf8.png)![](kjfowjf9.png)![](kjfowjf10.png)![](kjfowjf11.png)![](kjfowjf12.png)![](kjfowjf13.png)![](kjfowjf14.png)',130),(11,'让我们来保护您的MacBook','macbookpro13苹果2020笔记本11电脑air13.3外壳12配件15保护壳mac',1,'广西柳州','TB1G7G.webp,TB1G7G1.jpg,TB1G7G2.jpg,TB1G7G3.jpg,TB1G7G4.jpg','![](FjppbXXXa1.jpg)![](FjppbXXXa2.jpg)![](FjppbXXXa3.jpg)![](FjppbXXXa4.jpg)![](FjppbXXXa5.jpg)![](FjppbXXXa7.jpg)![](FjppbXXXa8.jpg)![](FjppbXXXa9.jpg)![](FjppbXXXa10.jpg)![](FjppbXXXa11.jpg)![](FjppbXXXa12.jpg)![](FjppbXXXa13.jpg)![](FjppbXXXa14.jpg)![](FjppbXXXa15.jpg)![](FjppbXXXa16.jpg)',29),(12,'儿童房也是颜值大担当','阿楹 飘窗小置物架玄关抽屉柜 ins实木北欧儿童房整理桌面收纳盒',1,'浙江温州','TB2Mk2.webp,TB2Mk21.jpg,TB2Mk23.jpg,TB2Mk23.jpg,TB2Mk24.jpg','![](iMmsyUHM1.jpg)![](iMmsyUHM2.jpg)![](iMmsyUHM3.jpg)![](iMmsyUHM4.jpg)![](iMmsyUHM5.jpg)![](iMmsyUHM6.jpg)![](iMmsyUHM7.jpg)![](iMmsyUHM8.jpg)![](iMmsyUHM9.jpg)![](iMmsyUHM10.jpg)![](iMmsyUHM11.jpg)![](iMmsyUHM12.jpg)![](iMmsyUHM13.jpg)![](iMmsyUHM14.jpg)![](iMmsyUHM15.jpg)![](iMmsyUHM16.jpg)![](iMmsyUHM17.jpg)![](iMmsyUHM18.jpg)![](iMmsyUHM19.jpg)![](iMmsyUHM20.jpg)![](iMmsyUHM21.jpg)![](iMmsyUHM22.jpg)![](iMmsyUHM23.jpg)![](iMmsyUHM24.jpg)![](iMmsyUHM25.jpg)![](iMmsyUHM26.jpg)',132);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_data`
--

DROP TABLE IF EXISTS `goods_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_data` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int NOT NULL COMMENT '商品ID',
  `goods_configuration` varchar(500) NOT NULL COMMENT '商品配置',
  `goods_price` double(5,2) NOT NULL COMMENT '商品价格',
  `goods_inventory` int NOT NULL COMMENT '商品库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_data`
--

LOCK TABLES `goods_data` WRITE;
/*!40000 ALTER TABLE `goods_data` DISABLE KEYS */;
INSERT INTO `goods_data` VALUES (1,1,'{1:1,2:4}',340.00,30),(2,1,'{1:2,2:4}',342.00,34),(3,1,'{1:3,2:4}',344.00,38),(4,1,'{1:1,2:5}',345.00,39),(5,1,'{1:2,2:5}',348.00,32),(6,1,'{1:3,2:5}',349.00,37),(7,1,'{1:1,2:6}',352.00,33),(8,1,'{1:2,2:6}',356.00,36),(9,2,'{3:7,4:16}',126.00,68),(10,2,'{3:8,4:16}',123.00,69),(12,2,'{3:9,4:16}',124.00,67),(13,2,'{3:10,4:16}',156.00,66),(14,2,'{3:11,4:16}',176.00,65),(15,2,'{3:12,4:16}',196.00,64),(16,2,'{3:13,4:16}',166.00,63),(18,2,'{3:14,4:16}',186.00,62),(19,2,'{3:15,4:16}',127.00,61),(21,2,'{3:7,4:17}',122.00,60),(22,2,'{3:8,4:17}',121.00,59),(23,2,'{3:9,4:17}',189.00,58),(24,2,'{3:10,4:17}',192.00,57),(25,2,'{3:11,4:17}',137.00,56),(26,2,'{3:12,4:17}',146.00,55),(27,2,'{3:13,4:17}',156.00,54),(28,2,'{3:14,4:17}',143.00,53),(29,2,'{3:15,4:17}',145.00,52),(30,2,'{3:7,4:18}',141.00,51),(31,2,'{3:8,4:18}',131.00,50),(32,2,'{3:9,4:18}',139.00,49),(33,2,'{3:10,4:18}',134.00,48),(34,2,'{3:11,4:18}',176.00,47),(35,2,'{3:12,4:18}',177.00,46),(36,2,'{3:13,4:18}',173.00,45),(37,2,'{3:14,4:18}',174.00,44),(38,2,'{3:15,4:18}',171.00,43),(39,2,'{3:7,4:19}',170.00,42),(40,2,'{3:8,4:19}',130.00,41),(41,2,'{3:9,4:19}',140.00,40),(42,2,'{3:10,4:19}',146.00,39),(43,2,'{3:11,4:19}',150.00,38),(44,2,'{3:12,4:19}',151.00,37),(45,2,'{3:13,4:19}',155.00,36),(46,2,'{3:14,4:19}',165.00,35),(47,2,'{3:15,4:19}',175.00,34),(48,3,'{5:20}',35.00,84),(49,3,'{5:21}',37.00,14),(50,3,'{5:22}',28.00,94),(51,4,'{6:23,7:29}',128.00,94),(52,4,'{6:24,7:29}',125.00,95),(53,4,'{6:25,7:29}',123.00,96),(54,4,'{6:26,7:29}',124.00,97),(55,4,'{6:27,7:29}',129.00,98),(56,4,'{6:28,7:29}',120.00,99),(57,4,'{6:23,7:30}',121.00,81),(58,4,'{6:24,7:30}',122.00,82),(59,4,'{6:25,7:30}',138.00,83),(60,4,'{6:26,7:30}',139.00,84),(61,4,'{6:27,7:30}',137.00,85),(62,4,'{6:28,7:30}',136.00,86),(63,5,'{8:31,9:35}',135.00,87),(64,5,'{8:32,9:35}',134.00,88),(65,5,'{8:33,9:35}',133.00,89),(66,5,'{8:34,9:35}',132.00,74),(67,5,'{8:31,9:36}',131.00,73),(68,5,'{8:32,9:36}',130.00,72),(69,5,'{8:33,9:36}',118.00,71),(70,5,'{8:34,9:36}',117.00,70),(71,5,'{8:31,9:37}',119.00,75),(72,5,'{8:32,9:37}',114.00,76),(73,5,'{8:33,9:37}',115.00,77),(74,5,'{8:34,9:37}',113.00,78),(75,5,'{8:31,9:38}',112.00,79),(76,5,'{8:32,9:38}',121.00,64),(77,5,'{8:33,9:38}',127.00,65),(78,5,'{8:34,9:38}',140.00,69),(79,6,'{10:39}',28.00,94),(80,6,'{10:40}',27.00,84),(81,6,'{10:41}',29.00,24),(82,7,'{11:42,12:48}',228.00,92),(83,7,'{11:43,12:48}',221.00,93),(84,7,'{11:44,12:48}',222.00,94),(85,7,'{11:45,12:48}',223.00,95),(86,7,'{11:46,12:48}',224.00,96),(87,7,'{11:47,12:48}',225.00,97),(88,7,'{11:42,12:49}',226.00,98),(89,7,'{11:43,12:49}',227.00,99),(90,7,'{11:44,12:49}',229.00,91),(91,7,'{11:45,12:49}',231.00,90),(92,7,'{11:46,12:49}',232.00,82),(93,7,'{11:47,12:49}',233.00,83),(94,7,'{11:47,12:49}',234.00,85),(95,7,'{11:42,12:50}',235.00,85),(96,7,'{11:43,12:50}',236.00,86),(97,7,'{11:44,12:50}',237.00,88),(98,7,'{11:45,12:50}',238.00,89),(99,7,'{11:46,12:50}',241.00,80),(100,7,'{11:47,12:50}',242.00,81),(101,7,'{11:42,12:51}',243.00,71),(102,7,'{11:43,12:51}',244.00,72),(103,7,'{11:44,12:51}',245.00,73),(104,7,'{11:45,12:51}',246.00,74),(105,7,'{11:46,12:51}',247.00,75),(106,7,'{11:47,12:51}',249.00,76),(107,8,'{13:52,14:58}',328.00,91),(108,8,'{13:53,14:58}',329.00,92),(109,8,'{13:54,14:58}',327.00,93),(110,8,'{13:55,14:58}',326.00,94),(111,8,'{13:56,14:58}',325.00,95),(112,8,'{13:57,14:58}',324.00,96),(113,8,'{13:52,14:59}',323.00,97),(114,8,'{13:53,14:59}',322.00,98),(115,8,'{13:54,14:59}',321.00,99),(116,8,'{13:55,14:59}',320.00,81),(117,8,'{13:56,14:59}',331.00,82),(118,8,'{13:57,14:59}',332.00,83),(119,8,'{13:52,14:60}',333.00,84),(120,8,'{13:53,14:60}',334.00,85),(121,8,'{13:54,14:60}',335.00,86),(122,8,'{13:55,14:60}',336.00,87),(123,8,'{13:56,14:60}',337.00,88),(124,8,'{13:57,14:60}',338.00,89),(125,9,'{15:61}',28.00,91),(126,9,'{15:62}',23.00,92),(127,9,'{15:63}',22.00,93),(128,10,'{16:64,17:71}',58.00,91),(129,10,'{16:65,17:71}',57.00,92),(130,10,'{16:66,17:71}',56.00,93),(131,10,'{16:67,17:71}',55.00,94),(132,10,'{16:68,17:71}',54.00,95),(133,10,'{16:69,17:71}',53.00,96),(134,10,'{16:70,17:71}',52.00,97),(135,10,'{16:64,17:72}',51.00,98),(136,10,'{16:65,17:72}',50.00,99),(137,10,'{16:66,17:72}',59.00,81),(138,10,'{16:67,17:72}',68.00,82),(139,10,'{16:68,17:72}',67.00,83),(140,10,'{16:69,17:72}',66.00,84),(141,10,'{16:70,17:72}',65.00,85),(142,11,'{18:73}',48.00,94),(143,11,'{18:74}',43.00,94),(144,11,'{18:75}',42.00,94),(145,11,'{18:76}',41.00,94),(146,11,'{18:77}',40.00,94),(147,12,'{19:78}',88.00,94),(148,12,'{19:79}',89.00,94),(149,12,'{19:80}',87.00,94);
/*!40000 ALTER TABLE `goods_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_main_type`
--

DROP TABLE IF EXISTS `goods_main_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_main_type` (
  `goods_main_type_id` int NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `goods_main_type_name` varchar(50) NOT NULL COMMENT '商品类型',
  `goods_main_type_picture` varchar(800) DEFAULT NULL COMMENT '商品类型图片',
  PRIMARY KEY (`goods_main_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_main_type`
--

LOCK TABLES `goods_main_type` WRITE;
/*!40000 ALTER TABLE `goods_main_type` DISABLE KEYS */;
INSERT INTO `goods_main_type` VALUES (1,'手机数码',NULL),(2,'电脑办公',NULL),(3,'家具用品',NULL),(4,'计生情趣',NULL),(5,'美妆护肤',NULL),(6,'个护清洗',NULL),(7,'汽车生活',NULL),(8,'男装',NULL),(9,'女装',NULL);
/*!40000 ALTER TABLE `goods_main_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_parameter`
--

DROP TABLE IF EXISTS `goods_parameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_parameter` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int NOT NULL COMMENT '商品ID',
  `goods_parameter` varchar(500) NOT NULL COMMENT '商品参数',
  `goods_optional` int NOT NULL COMMENT '参数是否是必须的，0=必须，1=可选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_parameter`
--

LOCK TABLES `goods_parameter` WRITE;
/*!40000 ALTER TABLE `goods_parameter` DISABLE KEYS */;
INSERT INTO `goods_parameter` VALUES (1,1,'尺码',0),(2,1,'颜色',0),(3,2,'尺码',0),(4,2,'颜色',0),(5,3,'颜色',0),(6,4,'尺码',0),(7,4,'颜色',0),(8,5,'尺寸',0),(9,5,'颜色',0),(10,6,'颜色',0),(11,7,'尺码',0),(12,7,'颜色',0),(13,8,'尺码',0),(14,8,'颜色',0),(15,9,'颜色',0),(16,10,'尺寸',0),(17,10,'颜色',0),(18,11,'颜色',0),(19,12,'颜色',0);
/*!40000 ALTER TABLE `goods_parameter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_parameter_option`
--

DROP TABLE IF EXISTS `goods_parameter_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_parameter_option` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_parameter_id` int NOT NULL COMMENT '商品参数ID',
  `goods_option` varchar(500) NOT NULL COMMENT '参数选项',
  `goods_picture` varchar(500) DEFAULT NULL COMMENT '参数选项图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_parameter_option`
--

LOCK TABLES `goods_parameter_option` WRITE;
/*!40000 ALTER TABLE `goods_parameter_option` DISABLE KEYS */;
INSERT INTO `goods_parameter_option` VALUES (1,1,'S',NULL),(2,1,'M',NULL),(3,1,'XL',NULL),(4,2,'深灰色','TB1Ysu.jpg'),(5,2,'白色','TB1HrbB.jpg'),(6,2,'米色','TB1kqD.jpg'),(7,3,'33',NULL),(8,3,'34',NULL),(9,3,'35',NULL),(10,3,'36',NULL),(11,3,'37',NULL),(12,3,'38',NULL),(13,3,'39',NULL),(14,3,'40',NULL),(15,3,'41',NULL),(16,4,'杏色','NaPheNy1.jpg'),(17,4,'黑色','NaPheNy2.jpg'),(18,4,'棕色','NaPheNy3.jpg'),(19,4,'米白色','NaPheNy4.jpg'),(20,5,'齿轮杯-斑马','jwojfj291.jpg'),(21,5,'齿轮杯-免子','jwojfj292.jpg'),(22,5,'齿轮杯-小狗','jwojfj293.jpg'),(23,6,'35',NULL),(24,6,'36',NULL),(25,6,'37',NULL),(26,6,'38',NULL),(27,6,'39',NULL),(28,6,'40',NULL),(29,7,'黑色','O1CN01iM1.jpg'),(30,7,'咖色','O1CN01iM2.jpg'),(31,8,'45x45',NULL),(32,8,'40x60',NULL),(33,8,'35x70',NULL),(34,8,'50x50',NULL),(35,9,'绿色格子','BScXlwf1.jpg'),(36,9,'浅灰色','BScXlwf2.jpg'),(37,9,'黄色格式','BScXlwf3.jpg'),(38,9,'长腰枕','BScXlwf4.jpg'),(39,10,'木原色','doqpwnHSd1.jpg'),(40,10,'茶棕色','doqpwnHSd2.jpg'),(41,10,'墨灰色','doqpwnHSd3.jpg'),(42,11,'S',NULL),(43,11,'M',NULL),(44,11,'L',NULL),(45,11,'XL',NULL),(46,11,'2XL',NULL),(47,11,'3XL',NULL),(48,12,'女裙',NULL),(49,12,'男T',NULL),(50,12,'男装套装',NULL),(51,12,'情侣套装',NULL),(52,13,'S',NULL),(53,13,'M',NULL),(54,13,'L',NULL),(55,13,'XL',NULL),(56,13,'2XL',NULL),(57,13,'3XL',NULL),(58,14,'女连衣裙','joqjOrw1.jpg'),(59,14,'男T恤','joqjOrw2.jpg'),(60,14,'男九分裤','joqjOrw3.jpg'),(61,15,'白色','wofjWrO1.jpg'),(62,15,'灰色','wofjWrO2.jpg'),(63,15,'灰+白色','wofjWrO3.jpg'),(64,16,'34',NULL),(65,16,'35',NULL),(66,16,'36',NULL),(67,16,'37',NULL),(68,16,'38',NULL),(69,16,'39',NULL),(70,16,'40',NULL),(71,17,'杏色',NULL),(72,17,'米白色',NULL),(73,18,'沙滩酒红','OwjrNSlPw1.jpg'),(74,18,'沙滩粉红','OwjrNSlPw2.jpg'),(75,18,'沙滩黑色','OwjrNSlPw3.jpg'),(76,18,'沙滩棕色','OwjrNSlPw4.jpg'),(77,18,'沙滩天青色','OwjrNSlPw5.jpg'),(78,19,'童话绘本装套','WovJoPw1.jpg'),(79,19,'海边积云','WovJoPw2.jpg'),(80,19,'童话绘本','WovJoPw3.jpg');
/*!40000 ALTER TABLE `goods_parameter_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_sub_type`
--

DROP TABLE IF EXISTS `goods_sub_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_sub_type` (
  `goods_sub_type_id` int NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `goods_sub_type_name` varchar(50) NOT NULL COMMENT '商品类型',
  `goods_sub_type_picture` varchar(800) NOT NULL COMMENT '商品类型图片',
  PRIMARY KEY (`goods_sub_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_sub_type`
--

LOCK TABLES `goods_sub_type` WRITE;
/*!40000 ALTER TABLE `goods_sub_type` DISABLE KEYS */;
INSERT INTO `goods_sub_type` VALUES (1,'小米','5a64b4.png'),(2,'华为','6e136.jpg'),(3,'荣耀','92jfwnf.jpg'),(4,'Apple','e73077.jpg'),(5,'vivo','f0179e0.png'),(6,'OPPO','bbbd9fb.png'),(7,'魅族','eca33c.jpg'),(8,'三星','6dfd03.png'),(9,'一加','14307e.jpg'),(10,'360','ac7677e.jpg'),(11,'锤子','af0738.jpg'),(12,'努比亚','d36d47.jpg'),(13,'轻薄本','8b9f3d4.png'),(14,'游戏本','561fea.png'),(15,'机械键盘','406a15.jpg'),(16,'组装电脑','07b12f0c.jpg'),(17,'移动硬盘','740c051.jpg'),(18,'显卡','79b4e4.jpg'),(19,'游戏台式机','1b7264.jpg'),(20,'家用打印机','f6ffa5e.jpg'),(21,'吃鸡装备','2f87411.jpg'),(22,'曲屏显示器','c95373.jpg'),(23,'投影机','a74bc3.jpg'),(24,'日本文具','c6ce6f5.jpg'),(25,'笔记本电脑','ab8a3a6.jpg'),(26,'平板电脑','85e503.jpg'),(27,'一体机','a93f7a9.jpg'),(28,'台式机','a3bed32.jpg'),(29,'笔记本配件','25c264a.jpg'),(30,'游戏台式机','f6918c9e.jpg'),(31,'商用台式机','820f6506.jpg'),(32,'游戏本','14214c4f.jpg'),(33,'平板电脑配件','0418625.jpg'),(34,'轻薄本','Nf77d9f6c.jpg'),(35,'二台一平板','N89330bb3.jpg'),(36,'服务器/工作站','1Nf71bb1a4.jpg'),(37,'电水壶/热水器','078d5e6.jpg'),(38,'电压力锅','N905aaf4c.jpg'),(39,'电饭煲','Nea1d3f59.jpg'),(40,'电磁炉','N56abbe6e.jpg'),(41,'微波炉','N50016f64.jpg'),(42,'电饼铛','Nf7957b34.jpg'),(43,'豆浆机','Nc4c681fb.jpg'),(44,'多用途锅','cN019c7fda.jpg'),(45,'料理机','Nb9978251.jpg'),(46,'榨汁机/原汗机','N9756f6e5.jpg'),(47,'电烤箱','N9c125c81.jpg'),(48,'养生壶/煎药壶','Nd140f4e3.jpg'),(49,'电炖锅','Nf7647558.jpg'),(50,'电烧烤炉','N8a775fab.jpg'),(51,'面包机','aNde6af185.jpg'),(52,'咖啡机','N6ea88eba.jpg'),(53,'煮蛋器','Nbb40dec0.jpg'),(54,'电热饭盒','b5ea6a23.jpg'),(55,'面条机','N052e26a3.jpg'),(56,'酸奶机','N2f022a90.jpg'),(57,'空气炸锅','Nc9df1b71.jpg'),(58,'蔬果解毒机','N26b23a3a.jpg'),(59,'情趣内衣','dN8c2a767c.jpg'),(60,'避孕套','N13635e0b.jpg'),(61,'振动棒','N73ba4e26.jpg'),(62,'缩阴球','Neba3a5aa.jpg'),(63,'充气娃娃','eN06ceb604.jpg'),(64,'丝袜','N44b9f566.jpg'),(65,'吊带','Nb358db45.jpg'),(66,'连体衣','fN91da46b1.jpg'),(67,'角色扮演','Nc1e88220.jpg'),(68,'美白','4a24b521.jpg'),(69,'防晒','da08084.jpg'),(70,'控油','N3add85ae.jpg'),(71,'明星同款面膜','48fa2317.jpg'),(72,'显白口红','5b10669e.jpg'),(73,'敏感肌','958dc424a.jpg'),(74,'卸妆','d1ac3072.jpg'),(75,'洁面','897f65d0.jpg'),(76,'爽肤水/化妆水','3d8b4c9.jpg'),(77,'眼霜','78b48547.jpg'),(78,'润唇膏','03fe5e9ef.jpg'),(79,'抗痘','d0e71275.jpg'),(80,'去黑头','Nc3b46f7b.jpg'),(81,'精华','N21358b6a.jpg'),(82,'卫生棉条','N2fc58c3e.jpg'),(83,'湿厕纸','a342fa77.jpg'),(84,'走珠/止汗露','Nfd44dcdd.jpg'),(85,'花露水','7ed9c341.jpg'),(86,'驱蚊用品','N9f7271c7.jpg'),(87,'本色纸','N18ed0cd5.jpg'),(88,'免洗洗手液','43e80da5.jpg'),(89,'进口卫生巾','N72fa8f49.jpg'),(90,'卫生护垫','Na79b47b4.jpg'),(91,'洗衣液','N5db3a834.jpg'),(92,'除菌液','N699a9345.jpg'),(93,'油污净','a1183476.jpg'),(94,'洁厕剂','Na5eec222.jpg'),(95,'机油','7d4de465.jpg'),(96,'汽车坐垫','806b102c.jpg'),(97,'洗车水枪','62861b9b.jpg'),(98,'行车记录仪','Nb81047cc.jpg'),(99,'轮胎','e8ebee02.jpg'),(100,'应急救援','6N59344f7a.png'),(101,'汽车香水','2103e1ad.jpg'),(102,'挂件','14672d9f.jpg'),(103,'车贴','bf8afd0d.jpg'),(104,'功能小件','aNc332a72c.jpg'),(105,'车衣','N98fe0b9b.jpg'),(106,'底盘装甲','9101722c.jpg'),(107,'T恤','N52823c3e.jpg'),(108,'针织衫','48dc86e1.jpg'),(109,'衬衫','N48c68336.jpg'),(110,'卫衣','695a7262.jpg'),(111,'风衣','N63e76af2.jpg'),(112,'年仔裤','Nff658599.jpg'),(113,'体闲裤','N7374a31d.jpg'),(114,'夹克','ecd5bd0e.jpg'),(115,'单西','N0e69037f.jpg'),(116,'真皮外套','a5bdc629.jpg'),(117,'七分裤','84bc1bed.jpg'),(118,'阔腿裤','Nf537d6b0.jpg'),(119,'外套','Nb9312b61.jpg'),(120,'连衣裙','N37c4848f.jpg'),(121,'衬衫','3834e3c9.jpg'),(122,'T恤','Ne1ec9fe8.jpg'),(123,'卫衣','25c9ddd.jpg'),(124,'短外套','c891be87.jpg'),(125,'雪纺衫','N205f4cc7.jpg'),(126,'字母T恤','cc01c1b5.jpg'),(127,'连帽卫衣','N8a66a14c.jpg'),(128,'半身裙','Nf3df9f87.jpg'),(129,'背带裙','Nca4b1172.jpg'),(130,'豆豆鞋','971579bf.jpg'),(131,'沙发垫套','bc8654fc.jpg'),(132,'储物/置物架','9c80acb.jpg'),(133,'椅子','e6cb765.jpg');
/*!40000 ALTER TABLE `goods_sub_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods_type_main_with_sub_relationship`
--

DROP TABLE IF EXISTS `goods_type_main_with_sub_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods_type_main_with_sub_relationship` (
  `goods_type_main_with_sub_relationship_id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_type_main_with_sub_relationship_main_id` int NOT NULL COMMENT '主商品类型ID',
  `goods_type_main_with_sub_relationship_sub_id` int NOT NULL COMMENT '子商品类型ID',
  PRIMARY KEY (`goods_type_main_with_sub_relationship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods_type_main_with_sub_relationship`
--

LOCK TABLES `goods_type_main_with_sub_relationship` WRITE;
/*!40000 ALTER TABLE `goods_type_main_with_sub_relationship` DISABLE KEYS */;
INSERT INTO `goods_type_main_with_sub_relationship` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,12),(13,2,13),(14,2,14),(15,2,16),(16,2,17),(17,2,18),(18,2,19),(19,2,20),(20,2,21),(21,2,22),(22,2,23),(23,2,24),(24,2,25),(25,2,26),(26,2,27),(27,2,28),(28,2,29),(29,2,30),(30,2,31),(31,2,32),(32,2,33),(33,2,34),(34,2,35),(35,2,36),(36,2,15),(37,3,37),(38,3,38),(39,3,39),(40,3,40),(41,3,41),(42,3,42),(43,3,43),(44,3,44),(45,3,45),(46,3,46),(47,3,47),(48,3,48),(49,3,49),(50,3,50),(51,3,51),(52,3,52),(53,3,53),(54,3,54),(55,3,55),(56,3,56),(57,3,57),(58,3,58),(59,4,59),(60,4,60),(61,4,61),(62,4,62),(63,4,63),(64,4,64),(65,4,65),(66,4,66),(67,4,67),(68,5,68),(69,5,69),(70,5,70),(71,5,71),(72,5,72),(73,5,73),(74,5,74),(75,5,75),(76,5,76),(77,5,77),(78,5,79),(79,5,80),(80,5,81),(81,5,78),(82,6,82),(83,6,83),(84,6,84),(85,6,85),(86,6,86),(87,6,87),(88,6,88),(89,6,89),(90,6,90),(91,6,91),(92,6,92),(93,6,93),(94,6,94),(95,7,95),(96,7,96),(97,7,97),(98,7,98),(99,7,99),(100,7,100),(101,7,101),(102,7,102),(103,7,103),(104,7,104),(105,7,105),(106,7,106),(107,8,107),(108,8,108),(109,8,109),(110,8,110),(111,8,111),(112,8,112),(113,8,113),(114,8,114),(115,8,115),(116,8,116),(117,8,117),(118,8,118),(119,8,119),(120,9,120),(121,9,121),(122,9,122),(123,9,123),(124,9,124),(125,9,125),(126,9,126),(127,9,127),(128,9,128),(129,9,129),(130,9,130),(131,3,131),(132,3,132),(133,3,133);
/*!40000 ALTER TABLE `goods_type_main_with_sub_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `goods_id` int NOT NULL COMMENT '商品ID',
  `goods_data_id` int NOT NULL COMMENT '商品信息',
  `order_status` int NOT NULL COMMENT '状态,0=取消交易,1=待付款,2=待发货,3=待收货,4=待评论,5=完成交易',
  `user_contact_id` int NOT NULL COMMENT '用户联系方式',
  `shopping_num` int NOT NULL COMMENT '购买数量',
  `create_time` datetime NOT NULL COMMENT '下单时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,1,1,1,1,3,'2020-06-01 14:06:16'),(2,1,1,2,2,1,5,'2020-06-01 14:06:16'),(3,1,2,2,3,1,5,'2020-06-01 14:06:16'),(4,1,3,6,4,1,2,'2020-06-01 14:06:16'),(5,1,4,8,5,1,8,'2020-06-01 14:06:16'),(6,1,5,9,3,1,3,'2020-06-01 14:06:17'),(7,1,2,9,1,1,1,'2020-06-03 02:12:37'),(8,1,2,23,1,1,1,'2020-06-03 02:13:10'),(9,1,1,1,1,1,1,'2020-06-05 00:27:07'),(10,1,3,49,1,1,1,'2020-06-05 01:02:29');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping`
--

DROP TABLE IF EXISTS `shopping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping` (
  `shopping_id` int NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `users_id` int NOT NULL COMMENT '用户ID',
  `goods_id` int NOT NULL COMMENT '商品ID',
  `goods_data_id` int NOT NULL COMMENT '商品详情信息',
  `shopping_num` int NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`shopping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping`
--

LOCK TABLES `shopping` WRITE;
/*!40000 ALTER TABLE `shopping` DISABLE KEYS */;
INSERT INTO `shopping` VALUES (1,1,1,1,3),(2,1,1,2,4),(3,1,7,89,1);
/*!40000 ALTER TABLE `shopping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(500) NOT NULL COMMENT '用户名',
  `user_nickname` varchar(500) NOT NULL COMMENT '用户昵称',
  `user_password` varchar(500) NOT NULL COMMENT '用户密码',
  `user_picture` varchar(500) NOT NULL COMMENT '用户图片',
  `create_time` datetime NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'hari','托马斯小小买家','1231','users-hari.jpg','2020-05-31 03:08:02'),(2,'calvin','葛东琪的小毛驴','1232','users-calvin.jpg','2020-05-31 03:08:02'),(3,'jon','旺仔小乔','1233','users-jon.png','2020-05-31 03:08:02'),(4,'kenda','毛病陈同学','1234','users-kenda.jpg','2020-05-31 03:08:02'),(5,'lost','三哈小杜','1235','users-lost.jpg','2020-05-31 03:08:02');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_contact`
--

DROP TABLE IF EXISTS `users_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_contact` (
  `user_contact_id` int NOT NULL AUTO_INCREMENT COMMENT '用户地址ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `user_actual_name` varchar(50) NOT NULL COMMENT '用户收件人',
  `user_phone` varchar(50) NOT NULL COMMENT '用户电话',
  `user_email` varchar(50) NOT NULL COMMENT '用户邮箱',
  `user_address` varchar(500) NOT NULL COMMENT '用户详情地址',
  `create_time` datetime NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_contact`
--

LOCK TABLES `users_contact` WRITE;
/*!40000 ALTER TABLE `users_contact` DISABLE KEYS */;
INSERT INTO `users_contact` VALUES (1,1,'隔小哈','17679391061','yovelas@163.com','广东省广州市天河区珠吉路','2020-06-02 03:41:59'),(2,1,'孟小婉','12479301861','wovelss@163.com','广东省佛山市南沙区南沙路文艺街','2020-06-02 03:41:59'),(3,1,'壁病杜','1699791061','povelrs@163.com','广东省珠海市香港州区情侣海滩北街','2020-06-02 03:41:59');
/*!40000 ALTER TABLE `users_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_track`
--

DROP TABLE IF EXISTS `users_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_track` (
  `user_track_id` int NOT NULL AUTO_INCREMENT COMMENT '用户足迹ID',
  `user_id` int NOT NULL COMMENT '用户ID',
  `goods_id` int NOT NULL COMMENT '浏览的商品',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_track_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_track`
--

LOCK TABLES `users_track` WRITE;
/*!40000 ALTER TABLE `users_track` DISABLE KEYS */;
INSERT INTO `users_track` VALUES (1,1,1,'2020-05-29 14:36:33'),(2,1,2,'2020-05-29 14:38:32');
/*!40000 ALTER TABLE `users_track` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-16 19:23:31
