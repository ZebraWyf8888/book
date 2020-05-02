/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 02/05/2020 16:44:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `publish` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `store` tinyint(4) NOT NULL,
  `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `num` int(4) NOT NULL,
  `money` int(4) NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2022 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2001, '活着', '人民大学出版社', 2, '余华', 33, 36);
INSERT INTO `book` VALUES (2002, 'JavaWeb程序设计语言', '人民电邮出版社', 2, '梁永先', 68, 58);
INSERT INTO `book` VALUES (2003, '精通SpringMVC', '电子工业大学出版社', 2, '瓦林', 69, 68);
INSERT INTO `book` VALUES (2004, '汇编语言', '清华大学出版社', 2, '王爽', 66, 12);
INSERT INTO `book` VALUES (2005, '软件工程', '高等教育出版社', 2, '史济民', 96, 55);
INSERT INTO `book` VALUES (2006, '算法设计与分析', '清华大学出版社', 2, '王梅红', 44, 56);
INSERT INTO `book` VALUES (2007, '数据结构与算法', '中国农业大学出版社', 2, '冯大春', 84, 50);
INSERT INTO `book` VALUES (2008, '大型关系型数据库Oracle', '中国农业大学出版社', 2, '何超波', 84, 50);
INSERT INTO `book` VALUES (2009, 'C语言程序设计', '中国农业大学出版社', 1, ' 闫大顺', 84, 50);
INSERT INTO `book` VALUES (2010, '考研英语词汇', '科普出版社', 1, '朱伟', 66, 69);
INSERT INTO `book` VALUES (2011, '人生第三版', '人民日报出版社', 1, '路遥', 66, 38);
INSERT INTO `book` VALUES (2012, '操作系统概论', '高等教育出版社', 1, '费翔林', 88, 48);
INSERT INTO `book` VALUES (2013, '猫', '科普出版社', 1, '老舍', 66, 69);
INSERT INTO `book` VALUES (2014, 'Java疯狂讲义', '电子工业出版社', 2, '李刚', 10, 70);
INSERT INTO `book` VALUES (2015, '骆驼祥子', '北京大学出版社', 2, '老舍', 55, 55);
INSERT INTO `book` VALUES (2016, '追风筝的人', '人民大学出版社', 2, '卡勒德·胡赛尼', 50, 55);
INSERT INTO `book` VALUES (2017, '人性的弱点', '天津人民出版社', 2, '戴尔·卡耐基', 66, 66);
INSERT INTO `book` VALUES (2018, '第一行Java代码', '人民大学出版社', 2, '李兴华', 55, 66);
INSERT INTO `book` VALUES (2020, '你的名字', '中国邮电出版社', 2, '新海诚', 64, 55);
INSERT INTO `book` VALUES (2021, 'JavaEE互联网轻量级框架整合开发', '电子工业出版社', 2, '杨开振', 66, 66);

-- ----------------------------
-- Table structure for bookuser
-- ----------------------------
DROP TABLE IF EXISTS `bookuser`;
CREATE TABLE `bookuser`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `upassword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bookuser
-- ----------------------------
INSERT INTO `bookuser` VALUES (1, 'user1', '123');
INSERT INTO `bookuser` VALUES (2, 'user2', '123');
INSERT INTO `bookuser` VALUES (3, 'user3', '123');
INSERT INTO `bookuser` VALUES (4, 'user4', '123');
INSERT INTO `bookuser` VALUES (5, 'user5', '123');

-- ----------------------------
-- Table structure for caritem
-- ----------------------------
DROP TABLE IF EXISTS `caritem`;
CREATE TABLE `caritem`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `bid` int(11) NULL DEFAULT NULL,
  `num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `mid` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `musername` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mpassword` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `is_deleted` tinyint(5) NOT NULL COMMENT '假删除(0-正常 1-已删除)',
  `store` int(4) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` int(1) NOT NULL COMMENT '1男0女',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '谢杰锋', 'Andrew', '123456', 0, 2, 'xiejiefeng@163.com', 1, '18922100438');
INSERT INTO `manager` VALUES (2, '李梓烽', 'Wind', '123123', 0, 1, 'lizifeng@qq.com', 1, '15838804208');
INSERT INTO `manager` VALUES (3, '林楚蓉', 'Lu2han', '654321', 0, 2, 'linchurong@qq.com', 0, '13628804208');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oid` int(4) NOT NULL AUTO_INCREMENT,
  `uid` int(4) NOT NULL,
  `count` int(4) NOT NULL,
  `address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` int(11) NOT NULL,
  `tel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `ooid` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `oid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`ooid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
