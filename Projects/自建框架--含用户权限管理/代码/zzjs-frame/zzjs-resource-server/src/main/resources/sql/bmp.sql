/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : bmp

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-02-12 10:38:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority_page_rela
-- ----------------------------
DROP TABLE IF EXISTS `authority_page_rela`;
CREATE TABLE `authority_page_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AUTHORITY_ID` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `PAGE_ID` bigint(20) DEFAULT NULL COMMENT '菜单页面ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of authority_page_rela
-- ----------------------------
INSERT INTO `authority_page_rela` VALUES ('1', '1', '2', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('2', '1', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('3', '10', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('4', '10', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('5', '17', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('6', '17', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('7', '24', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('8', '24', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('9', '31', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('10', '31', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('11', '38', '10', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('12', '38', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('13', '45', '11', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('14', '45', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('15', '52', '12', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('16', '52', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('17', '59', '13', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('18', '59', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('19', '66', '14', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('20', '66', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('21', '73', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('22', '73', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('25', '87', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('26', '87', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('27', '94', '18', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('28', '94', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('29', '101', '19', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('30', '101', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('31', '108', '20', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('32', '108', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('33', '115', '21', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('34', '115', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_page_rela` VALUES ('35', '122', '23', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('36', '122', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('37', '129', '25', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('38', '129', '24', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('39', '142', '27', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('40', '142', '26', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('41', '149', '28', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('42', '149', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('43', '156', '30', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('44', '156', '29', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('45', '163', '32', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('46', '163', '31', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('47', '170', '34', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('48', '170', '33', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('49', '177', '35', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('50', '177', '22', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('51', '184', '36', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('52', '184', '33', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('53', '191', '37', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('54', '191', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('55', '198', '38', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('56', '198', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('57', '205', '39', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('58', '205', '29', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('59', '212', '40', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('60', '212', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('61', '219', '41', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('62', '219', '22', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_page_rela` VALUES ('63', '80', '43', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('64', '80', '42', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('65', '226', '44', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('66', '226', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('67', '233', '45', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('68', '233', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('69', '240', '46', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('70', '240', '26', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('71', '247', '47', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('72', '247', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('73', '254', '48', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('74', '254', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('75', '261', '49', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('76', '261', '42', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('77', '268', '50', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_page_rela` VALUES ('78', '268', '42', '1', '2018-11-25 14:01:54', '23', null, null);

-- ----------------------------
-- Table structure for authority_resource_rela
-- ----------------------------
DROP TABLE IF EXISTS `authority_resource_rela`;
CREATE TABLE `authority_resource_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AUTHORITY_ID` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `RESOURCE_ID` bigint(20) DEFAULT NULL COMMENT '接口资源ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of authority_resource_rela
-- ----------------------------
INSERT INTO `authority_resource_rela` VALUES ('1', '2', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('2', '3', '2', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('3', '4', '3', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('4', '5', '4', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('5', '6', '5', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('6', '7', '6', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('7', '8', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('8', '9', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('9', '11', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('10', '12', '10', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('11', '13', '11', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('12', '14', '12', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('13', '15', '13', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('14', '16', '14', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('15', '18', '15', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('16', '19', '16', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('17', '20', '17', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('18', '21', '18', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('19', '22', '19', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('20', '23', '20', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('21', '25', '21', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('22', '26', '22', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('23', '27', '23', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('24', '28', '24', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('25', '29', '25', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('26', '30', '26', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('27', '32', '27', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('28', '33', '28', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('29', '34', '29', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('30', '35', '30', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('31', '36', '31', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('32', '37', '32', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('33', '39', '33', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('34', '40', '34', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('35', '41', '35', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('36', '42', '36', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('37', '43', '37', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('38', '44', '38', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('39', '46', '39', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('40', '47', '40', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('41', '48', '41', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('42', '49', '42', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('43', '50', '43', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('44', '51', '44', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('45', '53', '45', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('46', '54', '46', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('47', '55', '47', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('48', '56', '48', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('49', '57', '49', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('50', '58', '50', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('51', '60', '51', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('52', '61', '52', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('53', '62', '53', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('54', '63', '54', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('55', '64', '55', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('56', '65', '56', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('57', '67', '57', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('58', '68', '58', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('59', '69', '59', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('60', '70', '60', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('61', '71', '61', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('62', '72', '62', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('63', '74', '63', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('64', '75', '64', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('65', '76', '65', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('66', '77', '66', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('67', '78', '67', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('68', '79', '68', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('69', '81', '69', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('70', '82', '70', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('71', '83', '71', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('72', '84', '72', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('73', '85', '73', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('74', '86', '74', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('75', '88', '75', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('76', '89', '76', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('77', '90', '77', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('78', '91', '78', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('79', '92', '79', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('80', '93', '80', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('81', '95', '81', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('82', '96', '82', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('83', '97', '83', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('84', '98', '84', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('85', '99', '85', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('86', '100', '86', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('87', '102', '87', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('88', '103', '88', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('89', '104', '89', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('90', '105', '90', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('91', '106', '91', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('92', '107', '92', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('93', '109', '93', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('94', '110', '94', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('95', '111', '95', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('96', '112', '96', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('97', '113', '97', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('98', '114', '98', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('99', '116', '99', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('100', '117', '100', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('101', '118', '101', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('102', '119', '102', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('103', '120', '103', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('104', '121', '104', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_resource_rela` VALUES ('105', '123', '105', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('106', '124', '106', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('107', '125', '107', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('108', '126', '108', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('109', '127', '109', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('110', '128', '110', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('111', '130', '111', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('112', '131', '112', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('113', '132', '113', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('114', '133', '114', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('115', '134', '115', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('116', '135', '116', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('117', '136', '117', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('118', '137', '118', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('119', '138', '119', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('120', '139', '120', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('121', '140', '121', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('122', '141', '122', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('123', '143', '123', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('124', '144', '124', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('125', '145', '125', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('126', '146', '126', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('127', '147', '127', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('128', '148', '128', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('129', '150', '129', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('130', '151', '130', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('131', '152', '131', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('132', '153', '132', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('133', '154', '133', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('134', '155', '134', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('135', '157', '135', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('136', '158', '136', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('137', '159', '137', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('138', '160', '138', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('139', '161', '139', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('140', '162', '140', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('141', '164', '141', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('142', '165', '142', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('143', '166', '143', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('144', '167', '144', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('145', '168', '145', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('146', '169', '146', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('147', '171', '147', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('148', '172', '148', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('149', '173', '149', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('150', '174', '150', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('151', '175', '151', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('152', '176', '152', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('153', '178', '153', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('154', '179', '154', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('155', '180', '155', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('156', '181', '156', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('157', '182', '157', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('158', '183', '158', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('159', '185', '159', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('160', '186', '160', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('161', '187', '161', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('162', '188', '162', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('163', '189', '163', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('164', '190', '164', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('165', '192', '165', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('166', '193', '166', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('167', '194', '167', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('168', '195', '168', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('169', '196', '169', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('170', '197', '170', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('171', '199', '171', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('172', '200', '172', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('173', '201', '173', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('174', '202', '174', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('175', '203', '175', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('176', '204', '176', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('177', '206', '177', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('178', '207', '178', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('179', '208', '179', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('180', '209', '180', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('181', '210', '181', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('182', '211', '182', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('183', '213', '183', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('184', '214', '184', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('185', '215', '185', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('186', '216', '186', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('187', '217', '187', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('188', '218', '188', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('189', '220', '189', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('190', '221', '190', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('191', '222', '191', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('192', '223', '192', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('193', '224', '193', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('194', '225', '194', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_resource_rela` VALUES ('195', '227', '195', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('196', '228', '196', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('197', '229', '197', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('198', '230', '198', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('199', '231', '199', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('200', '232', '200', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('201', '234', '201', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('202', '235', '202', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('203', '236', '203', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('204', '237', '204', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('205', '238', '205', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('206', '239', '206', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('207', '241', '207', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('208', '242', '208', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('209', '243', '209', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('210', '244', '210', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('211', '245', '211', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('212', '246', '212', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('213', '248', '213', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('214', '249', '214', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('215', '250', '215', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('216', '251', '216', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('217', '252', '217', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('218', '253', '218', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('219', '255', '219', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('220', '256', '220', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('221', '257', '221', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('222', '258', '222', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('223', '259', '223', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('224', '260', '224', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('225', '262', '225', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('226', '263', '226', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('227', '264', '227', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('228', '265', '228', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('229', '266', '229', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('230', '267', '230', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('231', '269', '231', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('232', '270', '232', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('233', '271', '233', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('234', '272', '234', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('235', '273', '235', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('236', '274', '236', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('237', '275', '237', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('238', '276', '238', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('239', '277', '239', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('240', '278', '240', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('241', '279', '241', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('242', '280', '242', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('243', '281', '243', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('244', '282', '244', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_resource_rela` VALUES ('245', '283', '245', '1', '2018-11-28 10:39:00', '23', null, null);

-- ----------------------------
-- Table structure for authority_tab
-- ----------------------------
DROP TABLE IF EXISTS `authority_tab`;
CREATE TABLE `authority_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `FLAG` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '标识',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of authority_tab
-- ----------------------------
INSERT INTO `authority_tab` VALUES ('1', '仪表盘_页面', 'ROLE_Index_PAGE', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('2', '仪表盘_查询_用户信息', 'ROLE_Index_QUERY_USERINFO', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('3', '仪表盘_查询_角色列表', 'ROLE_Index_QUERY_ROLELIST', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('4', '仪表盘_编辑_用户信息', 'ROLE_Index_EDIT_USERINFO', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('5', '仪表盘_查询_权限列表', 'ROLE_Index_QUERY_AUTHORITYLIST', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('6', '仪表盘_查询_接口资源列表', 'ROLE_Index_QUERY_RESOURCELIST', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('7', '仪表盘_查询_菜单页面列表', 'ROLE_Index_QUERY_PAGELIST', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('8', '仪表盘_查询_模块列表', 'ROLE_Index_QUERY_MODULARLIST', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `authority_tab` VALUES ('9', '仪表盘_查询_菜单信息', 'ROLE_Index_QUERY_MENUINFO', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('10', '岗位_页面', 'ROLE_PostTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('11', '岗位_添加', 'ROLE_PostTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('12', '岗位_查询_详情', 'ROLE_PostTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('13', '岗位_编辑', 'ROLE_PostTab_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('14', '岗位_删除', 'ROLE_PostTab_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('15', '岗位_查询_分页', 'ROLE_PostTab_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('16', '岗位_查询_列表', 'ROLE_PostTab_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('17', '用户岗位_页面', 'ROLE_UserPostRela_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('18', '用户岗位_添加', 'ROLE_UserPostRela_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('19', '用户岗位_查询_详情', 'ROLE_UserPostRela_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('20', '用户岗位_编辑', 'ROLE_UserPostRela_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('21', '用户岗位_删除', 'ROLE_UserPostRela_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('22', '用户岗位_查询_分页', 'ROLE_UserPostRela_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('23', '用户岗位_查询_列表', 'ROLE_UserPostRela_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('24', '用户_页面', 'ROLE_UserTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('25', '用户_添加', 'ROLE_UserTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('26', '用户_查询_详情', 'ROLE_UserTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('27', '用户_编辑', 'ROLE_UserTab_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('28', '用户_删除', 'ROLE_UserTab_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('29', '用户_查询_分页', 'ROLE_UserTab_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('30', '用户_查询_列表', 'ROLE_UserTab_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('31', '部门_页面', 'ROLE_DeptTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('32', '部门_添加', 'ROLE_DeptTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('33', '部门_查询_详情', 'ROLE_DeptTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('34', '部门_编辑', 'ROLE_DeptTab_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('35', '部门_删除', 'ROLE_DeptTab_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('36', '部门_查询_分页', 'ROLE_DeptTab_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('37', '部门_查询_列表', 'ROLE_DeptTab_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('38', '机构_页面', 'ROLE_InsTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('39', '机构_添加', 'ROLE_InsTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('40', '机构_查询_详情', 'ROLE_InsTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('41', '机构_编辑', 'ROLE_InsTab_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('42', '机构_删除', 'ROLE_InsTab_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('43', '机构_查询_分页', 'ROLE_InsTab_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('44', '机构_查询_列表', 'ROLE_InsTab_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('45', '角色_页面', 'ROLE_RoleTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('46', '角色_添加', 'ROLE_RoleTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('47', '角色_查询_详情', 'ROLE_RoleTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('48', '角色_编辑', 'ROLE_RoleTab_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('49', '角色_删除', 'ROLE_RoleTab_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('50', '角色_查询_分页', 'ROLE_RoleTab_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('51', '角色_查询_列表', 'ROLE_RoleTab_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('52', '岗位角色_页面', 'ROLE_PostRoleRela_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('53', '岗位角色_添加', 'ROLE_PostRoleRela_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('54', '岗位角色_查询_详情', 'ROLE_PostRoleRela_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('55', '岗位角色_编辑', 'ROLE_PostRoleRela_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('56', '岗位角色_删除', 'ROLE_PostRoleRela_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('57', '岗位角色_查询_分页', 'ROLE_PostRoleRela_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('58', '岗位角色_查询_列表', 'ROLE_PostRoleRela_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('59', '角色权限_页面', 'ROLE_RoleAuthorityRela_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('60', '角色权限_添加', 'ROLE_RoleAuthorityRela_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('61', '角色权限_查询_详情', 'ROLE_RoleAuthorityRela_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('62', '角色权限_编辑', 'ROLE_RoleAuthorityRela_EDIT', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('63', '角色权限_删除', 'ROLE_RoleAuthorityRela_DELETE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('64', '角色权限_查询_分页', 'ROLE_RoleAuthorityRela_QUERY_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('65', '角色权限_查询_列表', 'ROLE_RoleAuthorityRela_QUERY_LIST', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('66', '接口资源_页面', 'ROLE_ResourceTab_PAGE', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('67', '接口资源_添加', 'ROLE_ResourceTab_ADD', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('68', '接口资源_查询_详情', 'ROLE_ResourceTab_QUERY_DETAIL', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `authority_tab` VALUES ('69', '接口资源_编辑', 'ROLE_ResourceTab_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('70', '接口资源_删除', 'ROLE_ResourceTab_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('71', '接口资源_查询_分页', 'ROLE_ResourceTab_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('72', '接口资源_查询_列表', 'ROLE_ResourceTab_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('73', '权限_页面', 'ROLE_AuthorityTab_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('74', '权限_添加', 'ROLE_AuthorityTab_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('75', '权限_查询_详情', 'ROLE_AuthorityTab_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('76', '权限_编辑', 'ROLE_AuthorityTab_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('77', '权限_删除', 'ROLE_AuthorityTab_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('78', '权限_查询_分页', 'ROLE_AuthorityTab_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('79', '权限_查询_列表', 'ROLE_AuthorityTab_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('80', '模块_页面', 'ROLE_ModularTab_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('81', '模块_添加', 'ROLE_ModularTab_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('82', '模块_查询_详情', 'ROLE_ModularTab_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('83', '模块_编辑', 'ROLE_ModularTab_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('84', '模块_删除', 'ROLE_ModularTab_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('85', '模块_查询_分页', 'ROLE_ModularTab_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('86', '模块_查询_列表', 'ROLE_ModularTab_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('87', '权限页面_页面', 'ROLE_AuthorityPageRela_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('88', '权限页面_添加', 'ROLE_AuthorityPageRela_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('89', '权限页面_查询_详情', 'ROLE_AuthorityPageRela_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('90', '权限页面_编辑', 'ROLE_AuthorityPageRela_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('91', '权限页面_删除', 'ROLE_AuthorityPageRela_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('92', '权限页面_查询_分页', 'ROLE_AuthorityPageRela_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('93', '权限页面_查询_列表', 'ROLE_AuthorityPageRela_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('94', '用户角色_页面', 'ROLE_UserRoleRela_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('95', '用户角色_添加', 'ROLE_UserRoleRela_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('96', '用户角色_查询_详情', 'ROLE_UserRoleRela_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('97', '用户角色_编辑', 'ROLE_UserRoleRela_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('98', '用户角色_删除', 'ROLE_UserRoleRela_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('99', '用户角色_查询_分页', 'ROLE_UserRoleRela_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('100', '用户角色_查询_列表', 'ROLE_UserRoleRela_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('101', '权限资源_页面', 'ROLE_AuthorityResourceRela_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('102', '权限资源_添加', 'ROLE_AuthorityResourceRela_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('103', '权限资源_查询_详情', 'ROLE_AuthorityResourceRela_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('104', '权限资源_编辑', 'ROLE_AuthorityResourceRela_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('105', '权限资源_删除', 'ROLE_AuthorityResourceRela_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('106', '权限资源_查询_分页', 'ROLE_AuthorityResourceRela_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('107', '权限资源_查询_列表', 'ROLE_AuthorityResourceRela_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('108', '菜单页面_页面', 'ROLE_PageTab_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('109', '菜单页面_添加', 'ROLE_PageTab_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('110', '菜单页面_查询_详情', 'ROLE_PageTab_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('111', '菜单页面_编辑', 'ROLE_PageTab_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('112', '菜单页面_删除', 'ROLE_PageTab_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('113', '菜单页面_查询_分页', 'ROLE_PageTab_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('114', '菜单页面_查询_列表', 'ROLE_PageTab_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('115', '配置_页面', 'ROLE_ConfigTab_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('116', '配置_添加', 'ROLE_ConfigTab_ADD', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('117', '配置_查询_详情', 'ROLE_ConfigTab_QUERY_DETAIL', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('118', '配置_编辑', 'ROLE_ConfigTab_EDIT', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('119', '配置_删除', 'ROLE_ConfigTab_DELETE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('120', '配置_查询_分页', 'ROLE_ConfigTab_QUERY_PAGE', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('121', '配置_查询_列表', 'ROLE_ConfigTab_QUERY_LIST', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `authority_tab` VALUES ('122', '站点_页面', 'ROLE_SiteTab_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('123', '站点_添加', 'ROLE_SiteTab_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('124', '站点_查询_详情', 'ROLE_SiteTab_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('125', '站点_编辑', 'ROLE_SiteTab_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('126', '站点_查询_分页', 'ROLE_SiteTab_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('127', '站点_查询_列表', 'ROLE_SiteTab_QUERY_LIST', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('128', '站点_删除', 'ROLE_SiteTab_DELETE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('129', '用户站点关系_页面', 'ROLE_ComponentImportRela_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('130', '用户站点关系_添加', 'ROLE_ComponentImportRela_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('131', '用户站点关系_查询_详情', 'ROLE_ComponentImportRela_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('132', '用户站点关系_编辑', 'ROLE_ComponentImportRela_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('133', '用户站点关系_查询_分页', 'ROLE_ComponentImportRela_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('134', '用户站点关系_查询_列表', 'ROLE_ComponentImportRela_QUERY_LIST', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('135', '用户站点关系_删除', 'ROLE_ComponentImportRela_DELETE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('136', '用户站点关系_添加', 'ROLE_UserSiteRela_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('137', '用户站点关系_查询_详情', 'ROLE_UserSiteRela_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('138', '用户站点关系_编辑', 'ROLE_UserSiteRela_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('139', '用户站点关系_查询_分页', 'ROLE_UserSiteRela_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('140', '用户站点关系_查询_列表', 'ROLE_UserSiteRela_QUERY_LIST', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('141', '用户站点关系_删除', 'ROLE_UserSiteRela_DELETE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('142', '数据字典_页面', 'ROLE_DictionaryTab_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('143', '数据字典_添加', 'ROLE_DictionaryTab_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('144', '数据字典_查询_详情', 'ROLE_DictionaryTab_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('145', '数据字典_编辑', 'ROLE_DictionaryTab_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('146', '数据字典_查询_分页', 'ROLE_DictionaryTab_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('147', '数据字典_查询_列表', 'ROLE_DictionaryTab_QUERY_LIST', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('148', '数据字典_删除', 'ROLE_DictionaryTab_DELETE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('149', '资源_页面', 'ROLE_MediaTab_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('150', '资源_添加', 'ROLE_MediaTab_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('151', '资源_查询_详情', 'ROLE_MediaTab_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('152', '资源_编辑', 'ROLE_MediaTab_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('153', '资源_查询_分页', 'ROLE_MediaTab_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('154', '资源_查询_列表', 'ROLE_MediaTab_QUERY_LIST', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('155', '资源_删除', 'ROLE_MediaTab_DELETE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('156', '数据参数模板_页面', 'ROLE_DataJsonTemplateTab_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('157', '数据参数模板_添加', 'ROLE_DataJsonTemplateTab_ADD', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('158', '数据参数模板_查询_详情', 'ROLE_DataJsonTemplateTab_QUERY_DETAIL', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('159', '数据参数模板_编辑', 'ROLE_DataJsonTemplateTab_EDIT', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('160', '数据参数模板_查询_分页', 'ROLE_DataJsonTemplateTab_QUERY_PAGE', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `authority_tab` VALUES ('161', '数据参数模板_查询_列表', 'ROLE_DataJsonTemplateTab_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('162', '数据参数模板_删除', 'ROLE_DataJsonTemplateTab_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('163', '组件实例_页面', 'ROLE_ComponentInstanceTab_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('164', '组件实例_添加', 'ROLE_ComponentInstanceTab_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('165', '组件实例_查询_详情', 'ROLE_ComponentInstanceTab_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('166', '组件实例_编辑', 'ROLE_ComponentInstanceTab_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('167', '组件实例_查询_分页', 'ROLE_ComponentInstanceTab_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('168', '组件实例_查询_列表', 'ROLE_ComponentInstanceTab_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('169', '组件实例_删除', 'ROLE_ComponentInstanceTab_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('170', '组件类型_页面', 'ROLE_ComponentTypeTab_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('171', '组件类型_添加', 'ROLE_ComponentTypeTab_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('172', '组件类型_查询_详情', 'ROLE_ComponentTypeTab_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('173', '组件类型_编辑', 'ROLE_ComponentTypeTab_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('174', '组件类型_查询_分页', 'ROLE_ComponentTypeTab_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('175', '组件类型_查询_列表', 'ROLE_ComponentTypeTab_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('176', '组件类型_删除', 'ROLE_ComponentTypeTab_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('177', '页面_页面', 'ROLE_FileTab_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('178', '页面_添加', 'ROLE_FileTab_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('179', '页面_查询_详情', 'ROLE_FileTab_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('180', '页面_编辑', 'ROLE_FileTab_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('181', '页面_查询_分页', 'ROLE_FileTab_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('182', '页面_查询_列表', 'ROLE_FileTab_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('183', '页面_删除', 'ROLE_FileTab_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('184', '组件_页面', 'ROLE_ComponentTab_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('185', '组件_添加', 'ROLE_ComponentTab_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('186', '组件_查询_详情', 'ROLE_ComponentTab_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('187', '组件_编辑', 'ROLE_ComponentTab_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('188', '组件_查询_分页', 'ROLE_ComponentTab_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('189', '组件_查询_列表', 'ROLE_ComponentTab_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('190', '组件_删除', 'ROLE_ComponentTab_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('191', '资源目录关系_页面', 'ROLE_MediaFolderRela_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('192', '资源目录关系_添加', 'ROLE_MediaFolderRela_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('193', '资源目录关系_查询_详情', 'ROLE_MediaFolderRela_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('194', '资源目录关系_编辑', 'ROLE_MediaFolderRela_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('195', '资源目录关系_查询_分页', 'ROLE_MediaFolderRela_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('196', '资源目录关系_查询_列表', 'ROLE_MediaFolderRela_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('197', '资源目录关系_删除', 'ROLE_MediaFolderRela_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('198', '资源页面关系_页面', 'ROLE_MediaFileRela_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('199', '资源页面关系_添加', 'ROLE_MediaFileRela_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('200', '资源页面关系_查询_详情', 'ROLE_MediaFileRela_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('201', '资源页面关系_编辑', 'ROLE_MediaFileRela_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('202', '资源页面关系_查询_分页', 'ROLE_MediaFileRela_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('203', '资源页面关系_查询_列表', 'ROLE_MediaFileRela_QUERY_LIST', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('204', '资源页面关系_删除', 'ROLE_MediaFileRela_DELETE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('205', '组件模板_页面', 'ROLE_ComponentTemplateTab_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('206', '组件模板_添加', 'ROLE_ComponentTemplateTab_ADD', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('207', '组件模板_查询_详情', 'ROLE_ComponentTemplateTab_QUERY_DETAIL', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('208', '组件模板_编辑', 'ROLE_ComponentTemplateTab_EDIT', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('209', '组件模板_查询_分页', 'ROLE_ComponentTemplateTab_QUERY_PAGE', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `authority_tab` VALUES ('210', '组件模板_查询_列表', 'ROLE_ComponentTemplateTab_QUERY_LIST', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('211', '组件模板_删除', 'ROLE_ComponentTemplateTab_DELETE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('212', '数据参数实例_页面', 'ROLE_DataJsonInstanceTab_PAGE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('213', '数据参数实例_添加', 'ROLE_DataJsonInstanceTab_ADD', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('214', '数据参数实例_查询_详情', 'ROLE_DataJsonInstanceTab_QUERY_DETAIL', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('215', '数据参数实例_编辑', 'ROLE_DataJsonInstanceTab_EDIT', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('216', '数据参数实例_查询_分页', 'ROLE_DataJsonInstanceTab_QUERY_PAGE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('217', '数据参数实例_查询_列表', 'ROLE_DataJsonInstanceTab_QUERY_LIST', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('218', '数据参数实例_删除', 'ROLE_DataJsonInstanceTab_DELETE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('219', '目录_页面', 'ROLE_FolderTab_PAGE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('220', '目录_添加', 'ROLE_FolderTab_ADD', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('221', '目录_查询_详情', 'ROLE_FolderTab_QUERY_DETAIL', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('222', '目录_编辑', 'ROLE_FolderTab_EDIT', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('223', '目录_查询_分页', 'ROLE_FolderTab_QUERY_PAGE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('224', '目录_查询_列表', 'ROLE_FolderTab_QUERY_LIST', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('225', '目录_删除', 'ROLE_FolderTab_DELETE', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `authority_tab` VALUES ('226', '模块字段_页面', 'ROLE_ModularFieldTab_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('227', '模块字段_添加', 'ROLE_ModularFieldTab_ADD', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('228', '模块字段_查询_详情', 'ROLE_ModularFieldTab_QUERY_DETAIL', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('229', '模块字段_编辑', 'ROLE_ModularFieldTab_EDIT', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('230', '模块字段_查询_列表', 'ROLE_ModularFieldTab_QUERY_LIST', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('231', '模块字段_查询_分页', 'ROLE_ModularFieldTab_QUERY_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('232', '模块字段_删除', 'ROLE_ModularFieldTab_DELETE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('233', '表格项_页面', 'ROLE_TableItemTab_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('234', '表格项_添加', 'ROLE_TableItemTab_ADD', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('235', '表格项_查询_详情', 'ROLE_TableItemTab_QUERY_DETAIL', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('236', '表格项_编辑', 'ROLE_TableItemTab_EDIT', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('237', '表格项_查询_列表', 'ROLE_TableItemTab_QUERY_LIST', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('238', '表格项_查询_分页', 'ROLE_TableItemTab_QUERY_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('239', '表格项_删除', 'ROLE_TableItemTab_DELETE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('240', '数据字典_页面', 'ROLE_DictionariesTab_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('241', '数据字典_添加', 'ROLE_DictionariesTab_ADD', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('242', '数据字典_查询_详情', 'ROLE_DictionariesTab_QUERY_DETAIL', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('243', '数据字典_编辑', 'ROLE_DictionariesTab_EDIT', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('244', '数据字典_查询_列表', 'ROLE_DictionariesTab_QUERY_LIST', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('245', '数据字典_查询_分页', 'ROLE_DictionariesTab_QUERY_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('246', '数据字典_删除', 'ROLE_DictionariesTab_DELETE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('247', '元素_页面', 'ROLE_ElementTab_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('248', '元素_添加', 'ROLE_ElementTab_ADD', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('249', '元素_查询_详情', 'ROLE_ElementTab_QUERY_DETAIL', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('250', '元素_编辑', 'ROLE_ElementTab_EDIT', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('251', '元素_查询_列表', 'ROLE_ElementTab_QUERY_LIST', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('252', '元素_查询_分页', 'ROLE_ElementTab_QUERY_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('253', '元素_删除', 'ROLE_ElementTab_DELETE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('254', '查询条件项_页面', 'ROLE_QueryCriteriaItemTab_PAGE', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('255', '查询条件项_添加', 'ROLE_QueryCriteriaItemTab_ADD', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('256', '查询条件项_查询_详情', 'ROLE_QueryCriteriaItemTab_QUERY_DETAIL', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('257', '查询条件项_编辑', 'ROLE_QueryCriteriaItemTab_EDIT', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('258', '查询条件项_查询_列表', 'ROLE_QueryCriteriaItemTab_QUERY_LIST', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `authority_tab` VALUES ('259', '查询条件项_查询_分页', 'ROLE_QueryCriteriaItemTab_QUERY_PAGE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('260', '查询条件项_删除', 'ROLE_QueryCriteriaItemTab_DELETE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('261', '验证规则_页面', 'ROLE_RulesTab_PAGE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('262', '验证规则_添加', 'ROLE_RulesTab_ADD', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('263', '验证规则_查询_详情', 'ROLE_RulesTab_QUERY_DETAIL', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('264', '验证规则_编辑', 'ROLE_RulesTab_EDIT', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('265', '验证规则_查询_列表', 'ROLE_RulesTab_QUERY_LIST', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('266', '验证规则_查询_分页', 'ROLE_RulesTab_QUERY_PAGE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('267', '验证规则_删除', 'ROLE_RulesTab_DELETE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('268', '表单项_页面', 'ROLE_FormItemTab_PAGE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('269', '表单项_添加', 'ROLE_FormItemTab_ADD', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('270', '表单项_查询_详情', 'ROLE_FormItemTab_QUERY_DETAIL', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('271', '表单项_编辑', 'ROLE_FormItemTab_EDIT', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('272', '表单项_查询_列表', 'ROLE_FormItemTab_QUERY_LIST', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('273', '表单项_查询_分页', 'ROLE_FormItemTab_QUERY_PAGE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('274', '表单项_删除', 'ROLE_FormItemTab_DELETE', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `authority_tab` VALUES ('275', '模块_查询_模块字段信息', 'ROLE_ModularTab_QUERY_FieldInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('276', '模块_保存_模块字段信息', 'ROLE_ModularTab_SAVE_FieldInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('277', '模块_查询_表单项信息', 'ROLE_ModularTab_QUERY_FormItemInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('278', '模块_保存_表单项信息', 'ROLE_ModularTab_SAVE_FormItemInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('279', '模块_查询_查询条件信息', 'ROLE_ModularTab_QUERY_QueryCriteriaInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('280', '模块_保存_查询条件信息', 'ROLE_ModularTab_SAVE_QueryCriteriaInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('281', '模块_查询_表格项信息', 'ROLE_ModularTab_QUERY_TableItemInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('282', '模块_保存_表格项信息', 'ROLE_ModularTab_SAVE_TableItemInfo', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `authority_tab` VALUES ('283', '模块_查询_模块信息', 'ROLE_ModularTab_QUERY_ModularTabInfo', '1', '2018-11-28 10:39:00', '23', null, null);

-- ----------------------------
-- Table structure for config_tab
-- ----------------------------
DROP TABLE IF EXISTS `config_tab`;
CREATE TABLE `config_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '组名',
  `KEY` varchar(150) NOT NULL COMMENT 'Key',
  `VALUE` varchar(150) DEFAULT NULL COMMENT '值',
  `SORT_NUM` int(9) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='网站配置';

-- ----------------------------
-- Records of config_tab
-- ----------------------------
INSERT INTO `config_tab` VALUES ('1', 'rulesType', 'requiredType', '必填验证', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('2', 'rulesType', 'lengthType', '长度验证', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('3', 'rulesType', 'formatType', '格式验证', '3', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('4', 'rulesType', 'validatorType', '自定义验证', '4', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('5', 'requiredType#trigger', 'blur', '失去焦点事件', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('6', 'requiredType#trigger', 'change', '变更事件', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('7', 'formatType#type', 'string', '字符格式', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('8', 'formatType#type', 'number', '数字格式', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('9', 'formatType#type', 'integer', '正整数格式', '3', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('10', 'formatType#type', 'float', '浮点数格式', '4', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('11', 'formatType#type', 'date', '日期格式', '5', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('12', 'formatType#type', 'url', '链接格式', '6', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('13', 'formatType#type', 'email', '邮箱格式', '7', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('14', 'validatorType#validator', 'eval#checkMobile', '验证手机号码', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('15', 'validatorType#validator', 'eval#checkNumPot2', '验证数字保留2位小数', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('16', 'validatorType#validator', 'eval#checkIdNum', '验证身份证', '3', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('17', 'elementType', 'FormInput', '文本输入框', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('18', 'elementType', 'FormTextArea', '文本域', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('19', 'elementType', 'FormSelector', '选择器', '3', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('20', 'elementType', 'FormRadio', '单选框', '4', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('21', 'elementType', 'FormCheckbox', '多选框', '5', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('22', 'elementType', 'FormDatePicker', '日期选择器', '6', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('23', 'elementType', 'FormTimePicker', '时间选择器', '7', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('24', 'elementType', 'FormDateTimePicker', '日期时间选择器', '8', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('25', 'elementType', 'FormSwitch', '开关选择器', '9', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('26', 'connectorName', 'and', '和', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('27', 'connectorName', 'or', '或', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('28', 'comparisonRule', 'IsNull', '为空', '1', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('29', 'comparisonRule', 'IsNotNull', '不为空', '2', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('30', 'comparisonRule', 'EqualTo', '等于', '3', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('31', 'comparisonRule', 'NotEqualTo', '不等于', '4', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('32', 'comparisonRule', 'GreaterThan', '大于', '5', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('33', 'comparisonRule', 'GreaterThanOrEqualTo', '大于等于', '6', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('34', 'comparisonRule', 'LessThan', '小于', '7', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('35', 'comparisonRule', 'LessThanOrEqualTo', '小于等于', '8', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('36', 'comparisonRule', 'Like', '模糊', '9', null, null, null, null, null);
INSERT INTO `config_tab` VALUES ('37', 'comparisonRule', 'NotLike', '不模糊', '10', null, null, null, null, null);

-- ----------------------------
-- Table structure for dept_tab
-- ----------------------------
DROP TABLE IF EXISTS `dept_tab`;
CREATE TABLE `dept_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门名称',
  `DESCRIBE` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父功能ID',
  `INS_ID` bigint(20) DEFAULT NULL COMMENT '所属机构ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dept_tab
-- ----------------------------

-- ----------------------------
-- Table structure for ins_tab
-- ----------------------------
DROP TABLE IF EXISTS `ins_tab`;
CREATE TABLE `ins_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '机构名称',
  `SHORTNAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '机构简称',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ins_tab
-- ----------------------------

-- ----------------------------
-- Table structure for modular_tab
-- ----------------------------
DROP TABLE IF EXISTS `modular_tab`;
CREATE TABLE `modular_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `NAMESPACE` varchar(50) DEFAULT NULL COMMENT '命名空间 例如：用户模块为UserTab',
  `MAPING` varchar(50) DEFAULT NULL COMMENT '映射表名 例如：用户模块为user_tab',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '所属菜单',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modular_tab
-- ----------------------------
INSERT INTO `modular_tab` VALUES ('1', '仪表盘_模块', 'Index', 'index', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `modular_tab` VALUES ('2', '岗位_模块', 'PostTab', 'post_tab', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('3', '用户岗位_模块', 'UserPostRela', 'user_post_rela', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('4', '用户_模块', 'UserTab', 'user_tab', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('5', '部门_模块', 'DeptTab', 'dept_tab', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('6', '机构_模块', 'InsTab', 'ins_tab', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('7', '角色_模块', 'RoleTab', 'role_tab', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('8', '岗位角色_模块', 'PostRoleRela', 'post_role_rela', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('9', '角色权限_模块', 'RoleAuthorityRela', 'role_authority_rela', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('10', '接口资源_模块', 'ResourceTab', 'resource_tab', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `modular_tab` VALUES ('11', '权限_模块', 'AuthorityTab', 'authority_tab', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('13', '权限页面_模块', 'AuthorityPageRela', 'authority_page_rela', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('14', '用户角色_模块', 'UserRoleRela', 'user_role_rela', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('15', '权限资源_模块', 'AuthorityResourceRela', 'authority_resource_rela', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('16', '菜单页面_模块', 'PageTab', 'page_tab', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('17', '配置_模块', 'ConfigTab', 'config_tab', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `modular_tab` VALUES ('18', '站点_模块', 'SiteTab', 'site_tab', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `modular_tab` VALUES ('19', '用户站点关系_模块', 'ComponentImportRela', 'component_import_rela', '24', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `modular_tab` VALUES ('20', '数据字典_模块', 'DictionaryTab', 'dictionary_tab', '26', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `modular_tab` VALUES ('21', '资源_模块', 'MediaTab', 'media_tab', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `modular_tab` VALUES ('22', '数据参数模板_模块', 'DataJsonTemplateTab', 'data_json_template_tab', '29', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `modular_tab` VALUES ('23', '组件实例_模块', 'ComponentInstanceTab', 'component_instance_tab', '31', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('24', '组件类型_模块', 'ComponentTypeTab', 'component_type_tab', '33', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('25', '页面_模块', 'FileTab', 'file_tab', '22', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('26', '组件_模块', 'ComponentTab', 'component_tab', '33', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('27', '资源目录关系_模块', 'MediaFolderRela', 'media_folder_rela', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('28', '资源页面关系_模块', 'MediaFileRela', 'media_file_rela', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('29', '组件模板_模块', 'ComponentTemplateTab', 'component_template_tab', '29', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `modular_tab` VALUES ('30', '数据参数实例_模块', 'DataJsonInstanceTab', 'data_json_instance_tab', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `modular_tab` VALUES ('31', '目录_模块', 'FolderTab', 'folder_tab', '22', '1', '2018-11-06 16:42:19', '18', null, null);

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL COMMENT '客户端唯一标识',
  `resource_ids` varchar(128) DEFAULT NULL COMMENT '资源编号',
  `client_secret` varchar(128) DEFAULT NULL COMMENT '客户端密码',
  `scope` varchar(128) DEFAULT NULL COMMENT '权限范围',
  `authorized_grant_types` varchar(128) DEFAULT NULL COMMENT '授权类型',
  `web_server_redirect_uri` varchar(128) DEFAULT NULL COMMENT '重定向uri',
  `authorities` varchar(128) DEFAULT NULL COMMENT '权限列表',
  `access_token_validity` int(11) DEFAULT NULL COMMENT '访问令牌有效期',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '刷新令牌有效期',
  `additional_information` varchar(128) DEFAULT NULL COMMENT '额外信息',
  `autoapprove` varchar(128) DEFAULT NULL COMMENT '是否用户授权',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('client', null, '{bcrypt}$2a$10$A.vKhM0rPUlfXLBX79qWYOcP2Ftg7IhxMUs5sK6BgiOS.z32MNvlO', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, 'true');
INSERT INTO `oauth_client_details` VALUES ('client1', null, '{bcrypt}$2a$10$A.vKhM0rPUlfXLBX79qWYOcP2Ftg7IhxMUs5sK6BgiOS.z32MNvlO', 'all', 'password,authorization_code,refresh_token,implicit,client_credentials', null, null, null, null, null, 'true');

-- ----------------------------
-- Table structure for page_tab
-- ----------------------------
DROP TABLE IF EXISTS `page_tab`;
CREATE TABLE `page_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父ID',
  `CLASSIFY` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '分类 ‘0’为菜单，‘1’为页面',
  `PAGE_URI` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '页面路径',
  `SORT` bigint(10) DEFAULT NULL COMMENT '排序字段',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of page_tab
-- ----------------------------
INSERT INTO `page_tab` VALUES ('1', '仪表盘', null, '0', null, '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `page_tab` VALUES ('2', '仪表盘_页面', '1', '1', '/dashboard', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `page_tab` VALUES ('3', '组织结构管理', null, '0', null, '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('4', '岗位_页面', '3', '1', '/pages/PostTab', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('5', '关系信息管理', null, '0', null, '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('6', '用户岗位_页面', '5', '1', '/pages/UserPostRela', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('7', '基础信息管理', null, '0', null, '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('8', '用户_页面', '7', '1', '/pages/UserTab', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('9', '部门_页面', '3', '1', '/pages/DeptTab', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('10', '机构_页面', '3', '1', '/pages/InsTab', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('11', '角色_页面', '7', '1', '/pages/RoleTab', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('12', '岗位角色_页面', '5', '1', '/pages/PostRoleRela', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('13', '角色权限_页面', '5', '1', '/pages/RoleAuthorityRela', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('14', '接口资源_页面', '7', '1', '/pages/ResourceTab', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `page_tab` VALUES ('15', '权限_页面', '7', '1', '/pages/AuthorityTab', '3', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('16', '模块_页面', '7', '1', '/pages/ModularTab', '6', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('17', '权限页面_页面', '5', '1', '/pages/AuthorityPageRela', '5', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('18', '用户角色_页面', '5', '1', '/pages/UserRoleRela', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('19', '权限资源_页面', '5', '1', '/pages/AuthorityResourceRela', '6', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('20', '菜单页面_页面', '7', '1', '/pages/PageTab', '4', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('21', '配置_页面', '7', '1', '/pages/ConfigTab', '7', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `page_tab` VALUES ('22', '站点管理', null, '0', null, '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('23', '站点_页面', '22', '1', '/pages/SiteTab', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('24', '关系管理', null, '0', null, '6', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('25', '用户站点关系_页面', '24', '1', '/pages/ComponentImportRela', '4', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('26', '配置管理', null, '0', null, '5', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('27', '数据字典_页面', '26', '1', '/pages/DictionaryTab', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('28', '资源_页面', '22', '1', '/pages/MediaTab', '4', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('29', '组件模板管理', null, '0', null, '4', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('30', '数据参数模板_页面', '29', '1', '/pages/DataJsonTemplateTab', '2', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `page_tab` VALUES ('31', '组件实例管理', null, '0', null, '3', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('32', '组件实例_页面', '31', '1', '/pages/ComponentInstanceTab', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('33', '组件管理', null, '0', null, '2', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('34', '组件类型_页面', '33', '1', '/pages/ComponentTypeTab', '2', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('35', '页面_页面', '22', '1', '/pages/FileTab', '2', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('36', '组件_页面', '33', '1', '/pages/ComponentTab', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('37', '资源目录关系_页面', '24', '1', '/pages/MediaFolderRela', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('38', '资源页面关系_页面', '24', '1', '/pages/MediaFileRela', '2', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('39', '组件模板_页面', '29', '1', '/pages/ComponentTemplateTab', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `page_tab` VALUES ('40', '数据参数实例_页面', '31', '1', '/pages/DataJsonInstanceTab', '2', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `page_tab` VALUES ('41', '目录_页面', '22', '1', '/pages/FolderTab', '3', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `page_tab` VALUES ('42', '模块管理', null, '0', null, '1', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `page_tab` VALUES ('43', '模块_页面', '42', '1', '/pages/ModularTab', '1', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `page_tab` VALUES ('44', '模块字段_页面', '42', '1', '/pages/ModularFieldTab', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `page_tab` VALUES ('45', '表格项_页面', '42', '1', '/pages/TableItemTab', '3', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `page_tab` VALUES ('46', '数据字典_页面', '26', '1', '/pages/DictionariesTab', '1', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `page_tab` VALUES ('47', '元素_页面', '42', '1', '/pages/ElementTab', '7', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `page_tab` VALUES ('48', '查询条件项_页面', '42', '1', '/pages/QueryCriteriaItemTab', '4', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `page_tab` VALUES ('49', '验证规则_页面', '42', '1', '/pages/RulesTab', '6', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `page_tab` VALUES ('50', '表单项_页面', '42', '1', '/pages/FormItemTab', '5', '1', '2018-11-25 14:01:54', '23', null, null);

-- ----------------------------
-- Table structure for post_role_rela
-- ----------------------------
DROP TABLE IF EXISTS `post_role_rela`;
CREATE TABLE `post_role_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `POST_ID` bigint(20) DEFAULT NULL COMMENT '岗位ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_role_rela
-- ----------------------------

-- ----------------------------
-- Table structure for post_tab
-- ----------------------------
DROP TABLE IF EXISTS `post_tab`;
CREATE TABLE `post_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(80) DEFAULT NULL COMMENT '名称',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_tab
-- ----------------------------

-- ----------------------------
-- Table structure for resource_tab
-- ----------------------------
DROP TABLE IF EXISTS `resource_tab`;
CREATE TABLE `resource_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `URI` varchar(50) DEFAULT NULL COMMENT '资源地址',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '所属模块',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_tab
-- ----------------------------
INSERT INTO `resource_tab` VALUES ('1', '/api/Index/getUserInfo', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('2', '/api/Index/getRoleList', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('3', '/api/Index/perfectInfo', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('4', '/api/Index/getAuthorityList', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('5', '/api/Index/getResourceList', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('6', '/api/Index/getPageList', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `resource_tab` VALUES ('7', '/api/Index/getModularList', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('8', '/api/Index/getMenuListByToken', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('9', '/api/PostTab/add', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('10', '/api/PostTab/get', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('11', '/api/PostTab/update', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('12', '/api/PostTab/del', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('13', '/api/PostTab/getListByPage', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('14', '/api/PostTab/getList', '2', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('15', '/api/UserPostRela/add', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('16', '/api/UserPostRela/get', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('17', '/api/UserPostRela/update', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('18', '/api/UserPostRela/del', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('19', '/api/UserPostRela/getListByPage', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('20', '/api/UserPostRela/getList', '3', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('21', '/api/UserTab/add', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('22', '/api/UserTab/get', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('23', '/api/UserTab/update', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('24', '/api/UserTab/del', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('25', '/api/UserTab/getListByPage', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('26', '/api/UserTab/getList', '4', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('27', '/api/DeptTab/add', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('28', '/api/DeptTab/get', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('29', '/api/DeptTab/update', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('30', '/api/DeptTab/del', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('31', '/api/DeptTab/getListByPage', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('32', '/api/DeptTab/getList', '5', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('33', '/api/InsTab/add', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('34', '/api/InsTab/get', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('35', '/api/InsTab/update', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('36', '/api/InsTab/del', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('37', '/api/InsTab/getListByPage', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('38', '/api/InsTab/getList', '6', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('39', '/api/RoleTab/add', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('40', '/api/RoleTab/get', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('41', '/api/RoleTab/update', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('42', '/api/RoleTab/del', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('43', '/api/RoleTab/getListByPage', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('44', '/api/RoleTab/getList', '7', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('45', '/api/PostRoleRela/add', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('46', '/api/PostRoleRela/get', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('47', '/api/PostRoleRela/update', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('48', '/api/PostRoleRela/del', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('49', '/api/PostRoleRela/getListByPage', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('50', '/api/PostRoleRela/getList', '8', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('51', '/api/RoleAuthorityRela/add', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('52', '/api/RoleAuthorityRela/get', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('53', '/api/RoleAuthorityRela/update', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('54', '/api/RoleAuthorityRela/del', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('55', '/api/RoleAuthorityRela/getListByPage', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('56', '/api/RoleAuthorityRela/getList', '9', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('57', '/api/ResourceTab/add', '10', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `resource_tab` VALUES ('58', '/api/ResourceTab/get', '10', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('59', '/api/ResourceTab/update', '10', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('60', '/api/ResourceTab/del', '10', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('61', '/api/ResourceTab/getListByPage', '10', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('62', '/api/ResourceTab/getList', '10', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('63', '/api/AuthorityTab/add', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('64', '/api/AuthorityTab/get', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('65', '/api/AuthorityTab/update', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('66', '/api/AuthorityTab/del', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('67', '/api/AuthorityTab/getListByPage', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('68', '/api/AuthorityTab/getList', '11', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('69', '/api/ModularTab/add', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('70', '/api/ModularTab/get', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('71', '/api/ModularTab/update', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('72', '/api/ModularTab/del', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('73', '/api/ModularTab/getListByPage', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('74', '/api/ModularTab/getList', '12', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('75', '/api/AuthorityPageRela/add', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('76', '/api/AuthorityPageRela/get', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('77', '/api/AuthorityPageRela/update', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('78', '/api/AuthorityPageRela/del', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('79', '/api/AuthorityPageRela/getListByPage', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('80', '/api/AuthorityPageRela/getList', '13', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('81', '/api/UserRoleRela/add', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('82', '/api/UserRoleRela/get', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('83', '/api/UserRoleRela/update', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('84', '/api/UserRoleRela/del', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('85', '/api/UserRoleRela/getListByPage', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('86', '/api/UserRoleRela/getList', '14', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('87', '/api/AuthorityResourceRela/add', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('88', '/api/AuthorityResourceRela/get', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('89', '/api/AuthorityResourceRela/update', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('90', '/api/AuthorityResourceRela/del', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('91', '/api/AuthorityResourceRela/getListByPage', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('92', '/api/AuthorityResourceRela/getList', '15', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('93', '/api/PageTab/add', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('94', '/api/PageTab/get', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('95', '/api/PageTab/update', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('96', '/api/PageTab/del', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('97', '/api/PageTab/getListByPage', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('98', '/api/PageTab/getList', '16', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('99', '/api/ConfigTab/add', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('100', '/api/ConfigTab/get', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('101', '/api/ConfigTab/update', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('102', '/api/ConfigTab/del', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('103', '/api/ConfigTab/getListByPage', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('104', '/api/ConfigTab/getList', '17', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `resource_tab` VALUES ('105', '/api/SiteTab/add', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('106', '/api/SiteTab/get', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('107', '/api/SiteTab/update', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('108', '/api/SiteTab/getListByPage', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('109', '/api/SiteTab/getList', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('110', '/api/SiteTab/del', '18', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('111', '/api/ComponentImportRela/add', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('112', '/api/ComponentImportRela/get', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('113', '/api/ComponentImportRela/update', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('114', '/api/ComponentImportRela/getListByPage', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('115', '/api/ComponentImportRela/getList', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('116', '/api/ComponentImportRela/del', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('117', '/api/UserSiteRela/add', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('118', '/api/UserSiteRela/get', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('119', '/api/UserSiteRela/update', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('120', '/api/UserSiteRela/getListByPage', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('121', '/api/UserSiteRela/getList', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('122', '/api/UserSiteRela/del', '19', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('123', '/api/DictionaryTab/add', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('124', '/api/DictionaryTab/get', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('125', '/api/DictionaryTab/update', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('126', '/api/DictionaryTab/getListByPage', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('127', '/api/DictionaryTab/getList', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('128', '/api/DictionaryTab/del', '20', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('129', '/api/MediaTab/add', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('130', '/api/MediaTab/get', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('131', '/api/MediaTab/update', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('132', '/api/MediaTab/getListByPage', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('133', '/api/MediaTab/getList', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('134', '/api/MediaTab/del', '21', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('135', '/api/DataJsonTemplateTab/add', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('136', '/api/DataJsonTemplateTab/get', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('137', '/api/DataJsonTemplateTab/update', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('138', '/api/DataJsonTemplateTab/getListByPage', '22', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `resource_tab` VALUES ('139', '/api/DataJsonTemplateTab/getList', '22', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('140', '/api/DataJsonTemplateTab/del', '22', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('141', '/api/ComponentInstanceTab/add', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('142', '/api/ComponentInstanceTab/get', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('143', '/api/ComponentInstanceTab/update', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('144', '/api/ComponentInstanceTab/getListByPage', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('145', '/api/ComponentInstanceTab/getList', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('146', '/api/ComponentInstanceTab/del', '23', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('147', '/api/ComponentTypeTab/add', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('148', '/api/ComponentTypeTab/get', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('149', '/api/ComponentTypeTab/update', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('150', '/api/ComponentTypeTab/getListByPage', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('151', '/api/ComponentTypeTab/getList', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('152', '/api/ComponentTypeTab/del', '24', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('153', '/api/FileTab/add', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('154', '/api/FileTab/get', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('155', '/api/FileTab/update', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('156', '/api/FileTab/getListByPage', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('157', '/api/FileTab/getList', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('158', '/api/FileTab/del', '25', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('159', '/api/ComponentTab/add', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('160', '/api/ComponentTab/get', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('161', '/api/ComponentTab/update', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('162', '/api/ComponentTab/getListByPage', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('163', '/api/ComponentTab/getList', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('164', '/api/ComponentTab/del', '26', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('165', '/api/MediaFolderRela/add', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('166', '/api/MediaFolderRela/get', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('167', '/api/MediaFolderRela/update', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('168', '/api/MediaFolderRela/getListByPage', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('169', '/api/MediaFolderRela/getList', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('170', '/api/MediaFolderRela/del', '27', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('171', '/api/MediaFileRela/add', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('172', '/api/MediaFileRela/get', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('173', '/api/MediaFileRela/update', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('174', '/api/MediaFileRela/getListByPage', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('175', '/api/MediaFileRela/getList', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('176', '/api/MediaFileRela/del', '28', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('177', '/api/ComponentTemplateTab/add', '29', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('178', '/api/ComponentTemplateTab/get', '29', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('179', '/api/ComponentTemplateTab/update', '29', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `resource_tab` VALUES ('180', '/api/ComponentTemplateTab/getListByPage', '29', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('181', '/api/ComponentTemplateTab/getList', '29', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('182', '/api/ComponentTemplateTab/del', '29', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('183', '/api/DataJsonInstanceTab/add', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('184', '/api/DataJsonInstanceTab/get', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('185', '/api/DataJsonInstanceTab/update', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('186', '/api/DataJsonInstanceTab/getListByPage', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('187', '/api/DataJsonInstanceTab/getList', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('188', '/api/DataJsonInstanceTab/del', '30', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('189', '/api/FolderTab/add', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('190', '/api/FolderTab/get', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('191', '/api/FolderTab/update', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('192', '/api/FolderTab/getListByPage', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('193', '/api/FolderTab/getList', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('194', '/api/FolderTab/del', '31', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `resource_tab` VALUES ('195', '/api/ModularFieldTab/add', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('196', '/api/ModularFieldTab/get', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('197', '/api/ModularFieldTab/update', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('198', '/api/ModularFieldTab/getList', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('199', '/api/ModularFieldTab/getListByPage', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('200', '/api/ModularFieldTab/del', '33', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('201', '/api/TableItemTab/add', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('202', '/api/TableItemTab/get', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('203', '/api/TableItemTab/update', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('204', '/api/TableItemTab/getList', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('205', '/api/TableItemTab/getListByPage', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('206', '/api/TableItemTab/del', '34', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('207', '/api/DictionariesTab/add', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('208', '/api/DictionariesTab/get', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('209', '/api/DictionariesTab/update', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('210', '/api/DictionariesTab/getList', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('211', '/api/DictionariesTab/getListByPage', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('212', '/api/DictionariesTab/del', '35', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('213', '/api/ElementTab/add', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('214', '/api/ElementTab/get', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('215', '/api/ElementTab/update', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('216', '/api/ElementTab/getList', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('217', '/api/ElementTab/getListByPage', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('218', '/api/ElementTab/del', '36', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('219', '/api/QueryCriteriaItemTab/add', '37', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('220', '/api/QueryCriteriaItemTab/get', '37', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('221', '/api/QueryCriteriaItemTab/update', '37', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('222', '/api/QueryCriteriaItemTab/getList', '37', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `resource_tab` VALUES ('223', '/api/QueryCriteriaItemTab/getListByPage', '37', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('224', '/api/QueryCriteriaItemTab/del', '37', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('225', '/api/RulesTab/add', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('226', '/api/RulesTab/get', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('227', '/api/RulesTab/update', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('228', '/api/RulesTab/getList', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('229', '/api/RulesTab/getListByPage', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('230', '/api/RulesTab/del', '38', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('231', '/api/FormItemTab/add', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('232', '/api/FormItemTab/get', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('233', '/api/FormItemTab/update', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('234', '/api/FormItemTab/getList', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('235', '/api/FormItemTab/getListByPage', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('236', '/api/FormItemTab/del', '39', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `resource_tab` VALUES ('237', '/api/ModularTab/getFieldsById', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('238', '/api/ModularTab/saveFieldInfo', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('239', '/api/ModularTab/getFormItemsById', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('240', '/api/ModularTab/saveFormItemInfo', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('241', '/api/ModularTab/getQueryCriteriasById', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('242', '/api/ModularTab/saveQueryCriteriaInfo', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('243', '/api/ModularTab/getTableItemsById', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('244', '/api/ModularTab/saveTableItemInfo', '32', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `resource_tab` VALUES ('245', '/api/ModularTab/getModularInfo', '32', '1', '2018-11-28 10:39:00', '23', null, null);

-- ----------------------------
-- Table structure for role_authority_rela
-- ----------------------------
DROP TABLE IF EXISTS `role_authority_rela`;
CREATE TABLE `role_authority_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AUTHORITY_ID` bigint(20) DEFAULT NULL COMMENT '权限ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1136 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_authority_rela
-- ----------------------------
INSERT INTO `role_authority_rela` VALUES ('1', '1', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('2', '2', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('3', '3', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('4', '4', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('5', '5', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('6', '6', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('7', '7', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('8', '8', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('9', '9', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('10', '10', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('11', '11', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('12', '12', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('13', '13', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('14', '14', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('15', '15', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('16', '16', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('17', '17', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('18', '18', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('19', '19', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('20', '20', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('21', '21', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('22', '22', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('23', '23', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('24', '24', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('25', '25', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('26', '26', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('27', '27', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('28', '28', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('29', '29', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('30', '30', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('31', '31', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('32', '32', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('33', '33', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('34', '34', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('35', '35', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('36', '36', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('37', '37', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('38', '38', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('39', '39', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('40', '40', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('41', '41', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('42', '42', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('43', '43', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('44', '44', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('45', '45', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('46', '46', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('47', '47', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('48', '48', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('49', '49', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('50', '50', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('51', '51', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('52', '52', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('53', '53', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('54', '54', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('55', '55', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('56', '56', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('57', '57', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('58', '58', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('59', '59', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('60', '60', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('61', '61', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('62', '62', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('63', '63', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('64', '64', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('65', '65', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('66', '66', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('67', '67', '1', '1', '2018-10-17 09:10:00', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('68', '68', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('69', '69', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('70', '70', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('71', '71', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('72', '72', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('73', '73', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('74', '74', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('75', '75', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('76', '76', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('77', '77', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('78', '78', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('79', '79', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('80', '80', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('81', '81', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('82', '82', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('83', '83', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('84', '84', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('85', '85', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('86', '86', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('87', '87', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('88', '88', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('89', '89', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('90', '90', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('91', '91', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('92', '92', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('93', '93', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('94', '94', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('95', '95', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('96', '96', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('97', '97', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('98', '98', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('99', '99', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('100', '100', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('101', '101', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('102', '102', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('103', '103', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('104', '104', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('105', '105', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('106', '106', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('107', '107', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('108', '108', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('109', '109', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('110', '110', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('111', '111', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('112', '112', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('113', '113', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('114', '114', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('115', '115', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('116', '116', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('117', '117', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('118', '118', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('119', '119', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('120', '120', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('121', '121', '1', '1', '2018-10-17 09:10:01', '16', null, null);
INSERT INTO `role_authority_rela` VALUES ('122', '122', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('123', '123', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('124', '124', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('125', '125', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('126', '126', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('127', '127', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('128', '128', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('129', '129', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('130', '130', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('131', '131', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('132', '132', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('133', '133', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('134', '134', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('135', '135', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('136', '136', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('137', '137', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('138', '138', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('139', '139', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('140', '140', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('141', '141', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('142', '142', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('143', '143', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('144', '144', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('145', '145', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('146', '146', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('147', '147', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('148', '148', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('149', '149', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('150', '150', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('151', '151', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('152', '152', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('153', '153', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('154', '154', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('155', '155', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('156', '156', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('157', '157', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('158', '158', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('159', '159', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('160', '160', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('161', '161', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('162', '162', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('163', '163', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('164', '164', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('165', '165', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('166', '166', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('167', '167', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('168', '168', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('169', '169', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('170', '170', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('171', '171', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('172', '172', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('173', '173', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('174', '174', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('175', '175', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('176', '176', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('177', '177', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('178', '178', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('179', '179', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('180', '180', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('181', '181', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('182', '182', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('183', '183', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('184', '184', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('185', '185', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('186', '186', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('187', '187', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('188', '188', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('189', '189', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('190', '190', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('191', '191', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('192', '192', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('193', '193', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('194', '194', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('195', '195', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('196', '196', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('197', '197', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('198', '198', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('199', '199', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('200', '200', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('201', '201', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('202', '202', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('203', '203', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('204', '204', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('205', '205', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('206', '206', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('207', '207', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('208', '208', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('209', '209', '1', '1', '2018-11-06 16:42:18', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('210', '210', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('211', '211', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('212', '212', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('213', '213', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('214', '214', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('215', '215', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('216', '216', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('217', '217', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('218', '218', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('219', '219', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('220', '220', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('221', '221', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('222', '222', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('223', '223', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('224', '224', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('225', '225', '1', '1', '2018-11-06 16:42:19', '18', null, null);
INSERT INTO `role_authority_rela` VALUES ('226', '80', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('227', '81', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('228', '82', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('229', '83', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('230', '86', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('231', '85', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('232', '84', '2', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('233', '226', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('234', '227', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('235', '228', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('236', '229', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('237', '230', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('238', '231', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('239', '232', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('240', '233', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('241', '234', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('242', '235', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('243', '236', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('244', '237', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('245', '238', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('246', '239', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('247', '240', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('248', '241', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('249', '242', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('250', '243', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('251', '244', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('252', '245', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('253', '246', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('254', '247', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('255', '248', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('256', '249', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('257', '250', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('258', '251', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('259', '252', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('260', '253', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('261', '254', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('262', '255', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('263', '256', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('264', '257', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('265', '258', '2', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('266', '259', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('267', '260', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('268', '261', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('269', '262', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('270', '263', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('271', '264', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('272', '265', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('273', '266', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('274', '267', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('275', '268', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('276', '269', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('277', '270', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('278', '271', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('279', '272', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('280', '273', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('281', '274', '2', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('282', '1', '2', '1', '2018-11-25 14:15:57', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('283', '2', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('284', '9', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('285', '3', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('286', '6', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('287', '7', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('288', '5', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('289', '4', '2', '1', '2018-11-25 14:15:58', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('562', '275', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('563', '276', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('564', '277', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('565', '278', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('566', '279', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('567', '280', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('568', '281', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('569', '282', '2', '1', '2018-11-27 11:22:36', '23', null, null);
INSERT INTO `role_authority_rela` VALUES ('989', '283', '2', '1', '2018-11-28 10:43:16', '23', null, null);

-- ----------------------------
-- Table structure for role_tab
-- ----------------------------
DROP TABLE IF EXISTS `role_tab`;
CREATE TABLE `role_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(80) DEFAULT NULL COMMENT '名称',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_tab
-- ----------------------------
INSERT INTO `role_tab` VALUES ('1', '系统管理员', '1', '2018-10-17 09:09:59', '0', null, null);
INSERT INTO `role_tab` VALUES ('2', '模块信息管理员', '1', '2018-11-25 14:01:52', '0', null, null);

-- ----------------------------
-- Table structure for user_post_rela
-- ----------------------------
DROP TABLE IF EXISTS `user_post_rela`;
CREATE TABLE `user_post_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `POST_ID` bigint(20) DEFAULT NULL COMMENT '岗位ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_post_rela
-- ----------------------------

-- ----------------------------
-- Table structure for user_role_rela
-- ----------------------------
DROP TABLE IF EXISTS `user_role_rela`;
CREATE TABLE `user_role_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role_rela
-- ----------------------------
INSERT INTO `user_role_rela` VALUES ('1', '16', '1', '1', '2018-10-17 09:09:59', '16', null, null);
INSERT INTO `user_role_rela` VALUES ('2', '18', '1', '1', '2018-11-06 16:42:17', '18', null, null);
INSERT INTO `user_role_rela` VALUES ('3', '23', '2', '1', '2018-11-25 14:01:52', '23', null, null);

-- ----------------------------
-- Table structure for user_tab
-- ----------------------------
DROP TABLE IF EXISTS `user_tab`;
CREATE TABLE `user_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名称',
  `ACCOUNT` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录账户',
  `MOBILE` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `SEX` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `PASSWORD` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `LAST_PASSWORD_RESET_DATE` datetime DEFAULT NULL COMMENT '最后重设密码时间',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_tab
-- ----------------------------
INSERT INTO `user_tab` VALUES ('16', '系统管理员', 'admin', '18612610697', 'admin321@163.com', '2', '{bcrypt}$2a$10$A.vKhM0rPUlfXLBX79qWYOcP2Ftg7IhxMUs5sK6BgiOS.z32MNvlO', null, '2018-10-31 20:43:40', '1', null, null, '2018-10-31 20:43:40', '0');
INSERT INTO `user_tab` VALUES ('18', '系统管理员', 'adminComp', null, 'admin@163.com', '1', '{bcrypt}$2a$10$A.vKhM0rPUlfXLBX79qWYOcP2Ftg7IhxMUs5sK6BgiOS.z32MNvlO', null, '2018-11-06 16:42:16', '1', '2018-11-06 16:42:16', '0', null, null);
INSERT INTO `user_tab` VALUES ('19', '杨延丽', 'lili', '18612610697', 'yanyanli@163.com', '2', null, null, null, null, null, null, null, null);
INSERT INTO `user_tab` VALUES ('20', '吴梦晓', 'wumengxiao', '15632135009', 'wumengxiao@163.com', '2', null, null, null, null, null, null, null, null);
INSERT INTO `user_tab` VALUES ('22', '测试1', 'test1', '18612610697', 'test1@163.com', '2', null, null, null, null, null, null, null, null);
INSERT INTO `user_tab` VALUES ('23', '模块系统管理员', 'adminModular', null, null, null, '{bcrypt}$2a$10$A.vKhM0rPUlfXLBX79qWYOcP2Ftg7IhxMUs5sK6BgiOS.z32MNvlO', null, '2018-11-25 14:01:52', '1', '2018-11-25 14:01:52', '0', null, null);
