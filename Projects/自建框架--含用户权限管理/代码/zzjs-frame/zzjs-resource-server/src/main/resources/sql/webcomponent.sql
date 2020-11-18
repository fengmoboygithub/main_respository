/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : webcomponent

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-11-30 13:56:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `component_import_rela`
-- ----------------------------
DROP TABLE IF EXISTS `component_import_rela`;
CREATE TABLE `component_import_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `COMPONENT_ID` bigint(20) DEFAULT NULL COMMENT '组件ID',
  `IMPORT_ID` bigint(20) DEFAULT NULL COMMENT '导入组件ID',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_import_rela
-- ----------------------------

-- ----------------------------
-- Table structure for `component_instance_tab`
-- ----------------------------
DROP TABLE IF EXISTS `component_instance_tab`;
CREATE TABLE `component_instance_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `COMPONENT_ID` bigint(20) DEFAULT NULL COMMENT '组件ID',
  `FILE_ID` bigint(20) DEFAULT NULL COMMENT '页面ID',
  `SOURCE_CODE` mediumtext COMMENT '源代码',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_instance_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `component_tab`
-- ----------------------------
DROP TABLE IF EXISTS `component_tab`;
CREATE TABLE `component_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `TYPE_ID` bigint(20) DEFAULT NULL COMMENT '类型ID',
  `CLASS_NAME` varchar(50) DEFAULT NULL COMMENT '组件Class名称',
  `SOURCE_CODE` mediumtext COMMENT '源代码',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `component_template_tab`
-- ----------------------------
DROP TABLE IF EXISTS `component_template_tab`;
CREATE TABLE `component_template_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `COMPONENT_ID` bigint(20) DEFAULT NULL COMMENT '组件ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `IS_DEFAULT` varchar(1) DEFAULT NULL COMMENT '默认标识',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_template_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `component_type_tab`
-- ----------------------------
DROP TABLE IF EXISTS `component_type_tab`;
CREATE TABLE `component_type_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `TIP_MSG` varchar(200) DEFAULT NULL COMMENT '提示信息',
  `TYPE_FLAG` varchar(20) DEFAULT NULL COMMENT '分类标识',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_type_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `data_json_instance_tab`
-- ----------------------------
DROP TABLE IF EXISTS `data_json_instance_tab`;
CREATE TABLE `data_json_instance_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `INSTANCE_ID` bigint(20) DEFAULT NULL COMMENT '组件实例ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `EN_NAME` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `SOURCE_CODE` mediumtext COMMENT '源代码',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_json_instance_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `data_json_template_tab`
-- ----------------------------
DROP TABLE IF EXISTS `data_json_template_tab`;
CREATE TABLE `data_json_template_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `TEMPLATE_ID` bigint(20) DEFAULT NULL COMMENT '模板ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '名称',
  `EN_NAME` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `SOURCE_CODE` mediumtext COMMENT '源代码',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_json_template_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `dictionary_tab`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_tab`;
CREATE TABLE `dictionary_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DIC_KEY` varchar(200) DEFAULT NULL COMMENT '关键字',
  `DIC_VALUE` varchar(200) DEFAULT NULL COMMENT '值',
  `DIC_DESC` varchar(200) DEFAULT NULL COMMENT '描述',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `file_tab`
-- ----------------------------
DROP TABLE IF EXISTS `file_tab`;
CREATE TABLE `file_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `EN_NAME` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `PATH` varchar(200) DEFAULT NULL COMMENT '路径',
  `FILE_TYPE` enum('') DEFAULT NULL COMMENT '文件类型',
  `FILE_VERSION` bigint(20) DEFAULT NULL COMMENT '文件版本号',
  `SOURCE_CODE` mediumtext COMMENT '源代码',
  `HTML_CODE` mediumtext COMMENT 'html代码',
  `SITE_ID` bigint(20) DEFAULT NULL COMMENT '站点ID',
  `FOLDER_ID` bigint(20) DEFAULT NULL COMMENT '目录ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `folder_tab`
-- ----------------------------
DROP TABLE IF EXISTS `folder_tab`;
CREATE TABLE `folder_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `EN_NAME` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `FATHER_ID` bigint(20) DEFAULT NULL COMMENT '父ID',
  `PATH` varchar(200) DEFAULT NULL COMMENT '路径',
  `FOLDER_TYPE` varchar(100) DEFAULT NULL COMMENT '目录类型',
  `LEVEL` int(4) DEFAULT NULL COMMENT '层级',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `SITE_ID` bigint(20) DEFAULT NULL COMMENT '站点ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of folder_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `media_file_rela`
-- ----------------------------
DROP TABLE IF EXISTS `media_file_rela`;
CREATE TABLE `media_file_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MEDIA_ID` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `FILE_ID` bigint(20) DEFAULT NULL COMMENT '页面ID',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media_file_rela
-- ----------------------------

-- ----------------------------
-- Table structure for `media_folder_rela`
-- ----------------------------
DROP TABLE IF EXISTS `media_folder_rela`;
CREATE TABLE `media_folder_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MEDIA_ID` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `FOLDER_ID` bigint(20) DEFAULT NULL COMMENT '目录ID',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media_folder_rela
-- ----------------------------

-- ----------------------------
-- Table structure for `media_tab`
-- ----------------------------
DROP TABLE IF EXISTS `media_tab`;
CREATE TABLE `media_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(200) DEFAULT NULL COMMENT '名称',
  `PATH` varchar(200) DEFAULT NULL COMMENT '路径',
  `SIZE` int(11) DEFAULT NULL COMMENT '大小',
  `SUFFIX` varchar(50) DEFAULT NULL COMMENT '后缀名',
  `MEDIA_TYPE` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `SITE_ID` bigint(20) DEFAULT NULL COMMENT '站点ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of media_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `site_tab`
-- ----------------------------
DROP TABLE IF EXISTS `site_tab`;
CREATE TABLE `site_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `EN_NAME` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `ADDRESS` varchar(70) DEFAULT NULL COMMENT '地址URL',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `user_site_rela`
-- ----------------------------
DROP TABLE IF EXISTS `user_site_rela`;
CREATE TABLE `user_site_rela` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `SITE_ID` bigint(20) DEFAULT NULL COMMENT '站点ID',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `SORT` int(4) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_site_rela
-- ----------------------------
