/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : blcampoc

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-11-01 16:11:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `CREATED_BY` bigint(20) DEFAULT NULL,
  `CREATED_ON` bigint(20) DEFAULT NULL,
  `DOB` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL DEFAULT '0',
  `IS_DELETED` tinyint(1) NOT NULL DEFAULT '0',
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `PROFILE_IMG` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES ('1', 'Lahore', 'Lahore', 'Pakistan', '1', '1495686965860', '09-20-2017', 'Irfan', 'Male', '1', '0', 'Nasim', '35464645465', null, 'Punjab');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'USER');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `IS_ACTIVE` tinyint(1) NOT NULL DEFAULT '1',
  `PASSWORD` varchar(255) NOT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `contact_ID` bigint(20) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKdwb2roasgpmjm9fclg3xi9t8n` (`contact_ID`),
  KEY `FK51nwvvirf4n67e3gdds36mbgq` (`ROLE_ID`),
  CONSTRAINT `FK51nwvvirf4n67e3gdds36mbgq` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FKdwb2roasgpmjm9fclg3xi9t8n` FOREIGN KEY (`contact_ID`) REFERENCES `contact` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'irfan@yopmail.com', '1', '$2a$10$CUX/MPtKydOdboB3gBjBlOBQQVmQbFNhFfV2iJDR9P.AcwRyQztVy', 'irfannasim', '1', '1');
