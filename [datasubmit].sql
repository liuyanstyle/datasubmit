CREATE DATABASE /*!32312 IF NOT EXISTS*/ `[datasubmit]` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `[datasubmit]`;

--
-- Table structure for table `cbhy_jz`
--

DROP TABLE IF EXISTS `cbhy_jz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbhy_jz` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `讲座/会议名称` varchar(100) NOT NULL,
  `承办时间` char(20) NOT NULL,
  `承办方` varchar(50) NOT NULL,
  `承办地点` char(20) NOT NULL,
  `参与人数` int(11) NOT NULL,
  `与会专家` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbhy_jz`
--

LOCK TABLES `cbhy_jz` WRITE;
/*!40000 ALTER TABLE `cbhy_jz` DISABLE KEYS */;
INSERT INTO `cbhy_jz` VALUES (1,'2018','1','2018-07-01','4','3',2,'5','2018-06-23');
/*!40000 ALTER TABLE `cbhy_jz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cjhy`
--

DROP TABLE IF EXISTS `cjhy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cjhy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `会议名称` varchar(100) NOT NULL,
  `举办时间` char(20) NOT NULL,
  `举办地点` char(20) NOT NULL,
  `参加人员` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cjhy`
--

LOCK TABLES `cjhy` WRITE;
/*!40000 ALTER TABLE `cjhy` DISABLE KEYS */;
INSERT INTO `cjhy` VALUES (2,'2018','1','2018-07-01','2','3','2018-06-23'),(3,'2018','1','2018-07-01','2','张三，赵四','2018-06-23');
/*!40000 ALTER TABLE `cjhy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dj_gh`
--

DROP TABLE IF EXISTS `dj_gh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dj_gh` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年度` char(10) DEFAULT NULL,
  `活动时间` char(10) NOT NULL,
  `活动主题` varchar(50) NOT NULL,
  `活动类型（党建/工会）` char(10) NOT NULL,
  `备注` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dj_gh`
--

LOCK TABLES `dj_gh` WRITE;
/*!40000 ALTER TABLE `dj_gh` DISABLE KEYS */;
INSERT INTO `dj_gh` VALUES (1,'2018','2018-06-01','1','党建','2','2018-06-23');
/*!40000 ALTER TABLE `dj_gh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dzjg`
--

DROP TABLE IF EXISTS `dzjg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dzjg` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `总荐购量` int(11) NOT NULL,
  `荐购满足量` int(11) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dzjg`
--

LOCK TABLES `dzjg` WRITE;
/*!40000 ALTER TABLE `dzjg` DISABLE KEYS */;
/*!40000 ALTER TABLE `dzjg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dzzyfw`
--

DROP TABLE IF EXISTS `dzzyfw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dzzyfw` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `电子资源名称` varchar(50) NOT NULL,
  `访问量` bigint(20) NOT NULL,
  `下载量` bigint(20) NOT NULL,
  `电子资源类型` char(20) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dzzyfw`
--

LOCK TABLES `dzzyfw` WRITE;
/*!40000 ALTER TABLE `dzzyfw` DISABLE KEYS */;
INSERT INTO `dzzyfw` VALUES (1,'2018','1',2,3,'外文全文库','2018-06-23');
/*!40000 ALTER TABLE `dzzyfw` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fljy-`
--

DROP TABLE IF EXISTS `fljy-`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fljy-` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `图书类别` char(10) NOT NULL,
  `借阅册数` bigint(20) NOT NULL,
  `本科生借阅册数` bigint(20) NOT NULL,
  `研究所借阅册数` bigint(20) NOT NULL,
  `教职工借阅册数` bigint(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fljy-`
--

LOCK TABLES `fljy-` WRITE;
/*!40000 ALTER TABLE `fljy-` DISABLE KEYS */;
/*!40000 ALTER TABLE `fljy-` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grdgtop100`
--

DROP TABLE IF EXISTS `grdgtop100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grdgtop100` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `学工号` char(20) NOT NULL,
  `姓名` varchar(30) NOT NULL,
  `读者单位` varchar(50) NOT NULL,
  `到馆次数` bigint(20) NOT NULL,
  `电话` char(15) DEFAULT NULL,
  `读者类别` char(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grdgtop100`
--

LOCK TABLES `grdgtop100` WRITE;
/*!40000 ALTER TABLE `grdgtop100` DISABLE KEYS */;
/*!40000 ALTER TABLE `grdgtop100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grjytop100`
--

DROP TABLE IF EXISTS `grjytop100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grjytop100` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `学工号` char(10) NOT NULL,
  `姓名` varchar(20) NOT NULL,
  `读者单位` char(100) NOT NULL,
  `借阅次数` int(11) NOT NULL,
  `电话` char(20) NOT NULL,
  `读者类别` char(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grjytop100`
--

LOCK TABLES `grjytop100` WRITE;
/*!40000 ALTER TABLE `grjytop100` DISABLE KEYS */;
/*!40000 ALTER TABLE `grjytop100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjqk`
--

DROP TABLE IF EXISTS `hjqk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjqk` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `奖项类别` char(10) NOT NULL,
  `获奖级别` char(30) NOT NULL,
  `奖项名称` varchar(100) NOT NULL,
  `获奖人员` varchar(50) NOT NULL,
  `获奖时间` date NOT NULL,
  `颁奖单位` varchar(50) NOT NULL,
  `备注` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjqk`
--

LOCK TABLES `hjqk` WRITE;
/*!40000 ALTER TABLE `hjqk` DISABLE KEYS */;
INSERT INTO `hjqk` VALUES (1,'2018','集体','国家级','1','3','2018-07-01','2','4','2018-06-23');
/*!40000 ALTER TABLE `hjqk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hzjl`
--

DROP TABLE IF EXISTS `hzjl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hzjl` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `单位名称` char(30) NOT NULL,
  `交流时间` char(10) NOT NULL,
  `参加人数` int(11) NOT NULL,
  `参与人员` longtext NOT NULL,
  `交流类型（调研/走访）` char(10) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hzjl`
--

LOCK TABLES `hzjl` WRITE;
/*!40000 ALTER TABLE `hzjl` DISABLE KEYS */;
INSERT INTO `hzjl` VALUES (3,'2018','1','2018-07-02',2,'3','来访','2018-06-23');
/*!40000 ALTER TABLE `hzjl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjcxcscy`
--

DROP TABLE IF EXISTS `kjcxcscy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjcxcscy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `国内外查新量` int(11) NOT NULL,
  `国内查新量` int(11) NOT NULL,
  `查收查引量` int(11) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjcxcscy`
--

LOCK TABLES `kjcxcscy` WRITE;
/*!40000 ALTER TABLE `kjcxcscy` DISABLE KEYS */;
/*!40000 ALTER TABLE `kjcxcscy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kjsy`
--

DROP TABLE IF EXISTS `kjsy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kjsy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `空间类别` char(10) NOT NULL,
  `空间名称` char(30) NOT NULL,
  `所在校区` char(10) NOT NULL,
  `可容纳人数` int(11) NOT NULL,
  `预约次数` bigint(20) DEFAULT NULL,
  `预约时长` bigint(20) DEFAULT NULL,
  `使用次数` bigint(20) DEFAULT NULL,
  `使用时长` bigint(20) DEFAULT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kjsy`
--

LOCK TABLES `kjsy` WRITE;
/*!40000 ALTER TABLE `kjsy` DISABLE KEYS */;
INSERT INTO `kjsy` VALUES (2,'2018下半年','会议室','XH_02/徐汇10202','奉贤',1,2,3,4,5,'2018-06-11');
/*!40000 ALTER TABLE `kjsy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kycg`
--

DROP TABLE IF EXISTS `kycg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kycg` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `成果名称` varchar(100) NOT NULL,
  `成果级别` char(10) DEFAULT NULL,
  `第一作者` char(10) NOT NULL,
  `其他作者` varchar(50) DEFAULT NULL,
  `成果来源` varchar(50) NOT NULL,
  `成果形式` varchar(50) NOT NULL,
  `发表范围` varchar(50) NOT NULL,
  `是否译成外文` char(10) NOT NULL,
  `研究类别` varchar(50) NOT NULL,
  `应用情况` varchar(50) NOT NULL,
  `学科门类` varchar(50) NOT NULL,
  `出版单位` varchar(50) NOT NULL,
  `出版日期` date NOT NULL,
  `ISBN/ISSN号` char(30) NOT NULL,
  `字数` int(10) DEFAULT NULL,
  `论文期刊类别` char(20) NOT NULL,
  `备注` longtext,
  `提交日期` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kycg`
--

LOCK TABLES `kycg` WRITE;
/*!40000 ALTER TABLE `kycg` DISABLE KEYS */;
INSERT INTO `kycg` VALUES (1,'2018','1','省市级','2','14','3','4','5','6','7','8','9','10','2018-06-01','11',12,'13','15','2018-06-23');
/*!40000 ALTER TABLE `kycg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qwcd`
--

DROP TABLE IF EXISTS `qwcd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qwcd` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `完成量` int(11) NOT NULL,
  `退回量` int(11) NOT NULL,
  `费用` int(11) NOT NULL,
  `平台名称` char(10) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qwcd`
--

LOCK TABLES `qwcd` WRITE;
/*!40000 ALTER TABLE `qwcd` DISABLE KEYS */;
INSERT INTO `qwcd` VALUES (2,'2017下半年',1,2,3,'研发','2018-06-23');
/*!40000 ALTER TABLE `qwcd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rcdwjs`
--

DROP TABLE IF EXISTS `rcdwjs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rcdwjs` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `部门名称` char(30) NOT NULL,
  `总人数` int(11) NOT NULL,
  `博士数` int(11) NOT NULL,
  `硕士数` int(11) NOT NULL,
  `本科数` int(11) NOT NULL,
  `其他学历人数` int(11) NOT NULL,
  `正高职称人数` int(11) NOT NULL,
  `副高职称人数` int(11) NOT NULL,
  `中级职称人数` int(11) NOT NULL,
  `其他职称人数` int(11) NOT NULL,
  `56-65岁人数` int(11) NOT NULL,
  `46-55岁人数` int(11) NOT NULL,
  `36-45岁人数` int(11) NOT NULL,
  `25-35岁人数` int(11) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rcdwjs`
--

LOCK TABLES `rcdwjs` WRITE;
/*!40000 ALTER TABLE `rcdwjs` DISABLE KEYS */;
INSERT INTO `rcdwjs` VALUES (1,'2018','办公室',1,2,4,3,5,6,7,8,9,10,11,12,13,'2018-06-23');
/*!40000 ALTER TABLE `rcdwjs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tsjytop100`
--

DROP TABLE IF EXISTS `tsjytop100`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsjytop100` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `书目题名` varchar(50) NOT NULL,
  `学科分类` char(10) NOT NULL,
  `借阅次数` bigint(20) NOT NULL,
  `图书类别（中/西文）` char(10) NOT NULL,
  `是否人文类` char(10) DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsjytop100`
--

LOCK TABLES `tsjytop100` WRITE;
/*!40000 ALTER TABLE `tsjytop100` DISABLE KEYS */;
/*!40000 ALTER TABLE `tsjytop100` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tsyy`
--

DROP TABLE IF EXISTS `tsyy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tsyy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `预约量` int(11) NOT NULL,
  `预约成功（S）` int(11) NOT NULL,
  `预约取消（C）` int(11) NOT NULL,
  `预约处理中（YDP）` char(10) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsyy`
--

LOCK TABLES `tsyy` WRITE;
/*!40000 ALTER TABLE `tsyy` DISABLE KEYS */;
/*!40000 ALTER TABLE `tsyy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webvisit`
--

DROP TABLE IF EXISTS `webvisit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `webvisit` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `网站名称` char(10) NOT NULL,
  `PV访问量` bigint(20) NOT NULL,
  `uv访问量` bigint(20) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webvisit`
--

LOCK TABLES `webvisit` WRITE;
/*!40000 ALTER TABLE `webvisit` DISABLE KEYS */;
INSERT INTO `webvisit` VALUES (1,'2018上半年','老版',1,2,'2018-06-23');
/*!40000 ALTER TABLE `webvisit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wechatyy`
--

DROP TABLE IF EXISTS `wechatyy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wechatyy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `新增粉丝` int(11) NOT NULL,
  `推送微信（次）` int(11) NOT NULL,
  `原创素材（篇）` int(11) NOT NULL,
  `消息发送（次）` int(11) NOT NULL,
  `消息分享转发（次）` int(11) NOT NULL,
  `累积粉丝数` int(11) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wechatyy`
--

LOCK TABLES `wechatyy` WRITE;
/*!40000 ALTER TABLE `wechatyy` DISABLE KEYS */;
INSERT INTO `wechatyy` VALUES (1,'2018上半年',2,3,4,5,6,1,'2018-06-23');
/*!40000 ALTER TABLE `wechatyy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xkfw`
--

DROP TABLE IF EXISTS `xkfw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xkfw` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `学科馆员人数` int(11) NOT NULL,
  `学科服务次数` int(11) NOT NULL,
  `学科服务主题` varchar(50) NOT NULL,
  `决策支持次数` int(11) NOT NULL,
  `决策支持主题` varchar(50) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xkfw`
--

LOCK TABLES `xkfw` WRITE;
/*!40000 ALTER TABLE `xkfw` DISABLE KEYS */;
INSERT INTO `xkfw` VALUES (8,'2018上半年',1,2,'4',3,'5','2018-06-23');
/*!40000 ALTER TABLE `xkfw` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xmqk`
--

DROP TABLE IF EXISTS `xmqk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xmqk` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `部门单位` char(10) NOT NULL,
  `项目名称` varchar(100) NOT NULL,
  `负责人` char(10) NOT NULL,
  `项目成员` varchar(50) DEFAULT NULL,
  `立项单位` varchar(50) NOT NULL,
  `立项时间` date NOT NULL,
  `项目级别` char(30) NOT NULL,
  `结题时间` date DEFAULT NULL,
  `备注` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xmqk`
--

LOCK TABLES `xmqk` WRITE;
/*!40000 ALTER TABLE `xmqk` DISABLE KEYS */;
INSERT INTO `xmqk` VALUES (1,'2017','3','1','2','5','4','2018-07-01','省市级','2018-09-01','6','2018-06-23');
/*!40000 ALTER TABLE `xmqk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xxsyjy`
--

DROP TABLE IF EXISTS `xxsyjy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xxsyjy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `课程/竞赛名称` char(50) NOT NULL,
  `面向对象` char(10) NOT NULL,
  `班级数` int(11) NOT NULL,
  `学生数` int(11) NOT NULL,
  `类别（课程/竞赛）` char(10) NOT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xxsyjy`
--

LOCK TABLES `xxsyjy` WRITE;
/*!40000 ALTER TABLE `xxsyjy` DISABLE KEYS */;
INSERT INTO `xxsyjy` VALUES (3,'2018','1','2',3,0,'竞赛','2018-06-23'),(4,'2018','1','2',3,4,'竞赛','2018-06-23');
/*!40000 ALTER TABLE `xxsyjy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xydg`
--

DROP TABLE IF EXISTS `xydg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xydg` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `学院名称` char(30) NOT NULL,
  `到馆人次` bigint(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xydg`
--

LOCK TABLES `xydg` WRITE;
/*!40000 ALTER TABLE `xydg` DISABLE KEYS */;
/*!40000 ALTER TABLE `xydg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xyjy`
--

DROP TABLE IF EXISTS `xyjy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xyjy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `学院名称` varchar(50) NOT NULL,
  `借阅册数` bigint(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xyjy`
--

LOCK TABLES `xyjy` WRITE;
/*!40000 ALTER TABLE `xyjy` DISABLE KEYS */;
/*!40000 ALTER TABLE `xyjy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zlwhhd`
--

DROP TABLE IF EXISTS `zlwhhd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zlwhhd` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年度` char(10) DEFAULT NULL,
  `举办时间` date NOT NULL,
  `活动类型（展览/文化活动）` char(10) NOT NULL,
  `活动主题` varchar(50) NOT NULL,
  `所属品牌` char(10) DEFAULT NULL,
  `所属期次` int(11) DEFAULT NULL,
  `参与人数` int(11) DEFAULT NULL,
  `备注` longtext,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlwhhd`
--

LOCK TABLES `zlwhhd` WRITE;
/*!40000 ALTER TABLE `zlwhhd` DISABLE KEYS */;
INSERT INTO `zlwhhd` VALUES (2,'2017下半年','2018-07-01','文化活动','1','2',3,4,'5','2018-06-23');
/*!40000 ALTER TABLE `zlwhhd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ztdg`
--

DROP TABLE IF EXISTS `ztdg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ztdg` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `月份` int(11) NOT NULL,
  `徐汇到馆人次` bigint(20) NOT NULL,
  `奉贤到馆人次` bigint(20) NOT NULL,
  `到馆总人次` bigint(20) NOT NULL,
  `备注` longtext,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ztdg`
--

LOCK TABLES `ztdg` WRITE;
/*!40000 ALTER TABLE `ztdg` DISABLE KEYS */;
/*!40000 ALTER TABLE `ztdg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ztjy`
--

DROP TABLE IF EXISTS `ztjy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ztjy` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `月份` char(10) NOT NULL,
  `借阅人数` bigint(20) NOT NULL,
  `借阅册数` bigint(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ztjy`
--

LOCK TABLES `ztjy` WRITE;
/*!40000 ALTER TABLE `ztjy` DISABLE KEYS */;
/*!40000 ALTER TABLE `ztjy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zwxz`
--

DROP TABLE IF EXISTS `zwxz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zwxz` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) NOT NULL,
  `阅览室名称` char(20) NOT NULL,
  `所在校区` char(10) NOT NULL,
  `座位数` int(11) NOT NULL,
  `选座量` bigint(20) NOT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zwxz`
--

LOCK TABLES `zwxz` WRITE;
/*!40000 ALTER TABLE `zwxz` DISABLE KEYS */;
/*!40000 ALTER TABLE `zwxz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zyjs`
--

DROP TABLE IF EXISTS `zyjs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zyjs` (
  `序号` int(11) NOT NULL AUTO_INCREMENT,
  `年份` char(10) DEFAULT NULL,
  `文献种类` char(10) DEFAULT NULL,
  `文献类型` char(10) DEFAULT NULL,
  `购置种数` int(11) DEFAULT NULL,
  `购置册数` int(11) DEFAULT NULL,
  `使用经费（万元）` char(10) DEFAULT NULL,
  `当年新增` int(11) DEFAULT NULL,
  `当年续订` int(11) DEFAULT NULL,
  `当年注销` int(11) DEFAULT NULL,
  `往年总量（万册）` char(10) DEFAULT NULL,
  `累积总量（万册）` char(10) DEFAULT NULL,
  `提交时间` date DEFAULT NULL,
  PRIMARY KEY (`序号`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zyjs`
--

LOCK TABLES `zyjs` WRITE;
/*!40000 ALTER TABLE `zyjs` DISABLE KEYS */;
INSERT INTO `zyjs` VALUES (4,'2017','图书','中文',1,2,'3',4,5,7,'6','8','2018-06-23');
/*!40000 ALTER TABLE `zyjs` ENABLE KEYS */;
UNLOCK TABLES;
