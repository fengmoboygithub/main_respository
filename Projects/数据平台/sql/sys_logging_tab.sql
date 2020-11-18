/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : mydata

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-12-21 09:11:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_logging_tab
-- ----------------------------
DROP TABLE IF EXISTS `sys_logging_tab`;
CREATE TABLE `sys_logging_tab` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zip_id` int(20) DEFAULT NULL COMMENT '处理压缩包表id',
  `file_id` int(20) DEFAULT NULL COMMENT '处理文件表id',
  `logging_type` int(2) DEFAULT NULL COMMENT '日志类型 10:自己 11:校验库 12:报告库',
  `error_code` varchar(10) DEFAULT NULL COMMENT '错误码',
  `error_msg` varchar(2000) DEFAULT NULL COMMENT '错误信息',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_logging_tab
-- ----------------------------
