/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : mydata

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-12-21 09:11:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for handle_compress_package_tab
-- ----------------------------
DROP TABLE IF EXISTS `handle_compress_package_tab`;
CREATE TABLE `handle_compress_package_tab` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zip_file_name` varchar(100) DEFAULT NULL COMMENT '压缩包文件名',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of handle_compress_package_tab
-- ----------------------------
