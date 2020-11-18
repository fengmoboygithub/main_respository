/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : mydata

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-12-21 09:10:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for handle_file_tab
-- ----------------------------
DROP TABLE IF EXISTS `handle_file_tab`;
CREATE TABLE `handle_file_tab` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zip_id` int(20) DEFAULT NULL COMMENT '压缩包主键',
  `zip_file_name` varchar(100) DEFAULT NULL COMMENT '压缩包文件名',
  `file_name` varchar(100) DEFAULT NULL COMMENT '文件名',
  `hash_file_entity` varchar(50) DEFAULT NULL COMMENT '文件内容哈希值',
  `file_creater_code` varchar(10) DEFAULT NULL COMMENT '文件创建人代码',
  `file_receiver_code` varchar(10) DEFAULT NULL COMMENT '文件接收人代码',
  `interface_id` varchar(10) DEFAULT NULL COMMENT '接口标识',
  `submission_date` varchar(10) DEFAULT NULL COMMENT '报送日期',
  `file_num` varchar(10) DEFAULT NULL COMMENT '文件序号',
  `operation_id` varchar(2) DEFAULT NULL COMMENT '操作标识',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `local_error` varchar(2000) DEFAULT NULL COMMENT '本地校验错误',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=442 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of handle_file_tab
-- ----------------------------
