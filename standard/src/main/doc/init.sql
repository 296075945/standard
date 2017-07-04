/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2017-07-04 13:33:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `standard`
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`parent_id`  int(11) NULL DEFAULT NULL ,
`title`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`text`  varchar(4069) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of standard
-- ----------------------------
BEGIN;
INSERT INTO `standard` VALUES ('1', null, '123', '123'), ('2', '1', '123', '123'), ('3', '1', '123', '123'), ('4', '2', '123', '123');
COMMIT;

-- ----------------------------
-- Auto increment value for `standard`
-- ----------------------------
ALTER TABLE `standard` AUTO_INCREMENT=5;
