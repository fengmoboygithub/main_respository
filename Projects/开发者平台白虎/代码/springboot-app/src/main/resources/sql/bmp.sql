/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : bmp

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-09-23 20:49:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `key` varchar(150) NOT NULL COMMENT 'Key',
  `value` varchar(150) DEFAULT NULL COMMENT '值',
  `description` text COMMENT '描述',
  `isDelete` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `createUser` bigint(20) DEFAULT NULL COMMENT '创建人',
  `updateTime` datetime DEFAULT NULL COMMENT '最近修改人',
  `updateUser` bigint(20) DEFAULT NULL COMMENT '最近修改时间',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='网站配置';

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('zzjs_cms_model', 'local', '服务模式', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_cms_rows', '5', '每页显示条数', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_cms_source_address_local', 'http://localhost:8090/static-file-plate/', '资源项目访问地址', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_cms_source_address_test', 'http://172.17.33.10:8090/static-file-plate/', '资源项目访问地址', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_cms_source_real_address_local', 'D:/apache-tomcat-8/apache-tomcat-8.0.32/webapps/static-file-plate/', '资源项目真实地址', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_cms_source_real_address_test', '/opt/tomcat7/webapps/static-file-plate/', '资源项目真实地址', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_component_dir', 'js/component/', '输出JS文件目录', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_js_template_file', 'componentJs.ftl', '输出JS模板文件', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_seo_description', '中证技术CMS描述', '网站描述', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_seo_title', '中证技术CMS', '网站名称', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_site_folder', 'D:/output/', '站点导出目录', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_template', 'output', '输出模板', null, null, null, null, null);
INSERT INTO `config` VALUES ('zzjs_template_file', 'output.ftl', '输出模板文件', null, null, null, null, null);

-- ----------------------------
-- Table structure for `data_source_tab`
-- ----------------------------
DROP TABLE IF EXISTS `data_source_tab`;
CREATE TABLE `data_source_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `SERVICE_NAME` varchar(50) DEFAULT NULL COMMENT '库名称',
  `SERVICE_IP` varchar(30) DEFAULT NULL COMMENT 'IP',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `DRIVER` varchar(80) DEFAULT NULL COMMENT '驱动',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_source_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `dept_tab`
-- ----------------------------
DROP TABLE IF EXISTS `dept_tab`;
CREATE TABLE `dept_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '部门名称',
  `DESCRIBE` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父功能ID',
  `INS_ID` bigint(20) DEFAULT NULL COMMENT '所属机构ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
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
-- Table structure for `function_tab`
-- ----------------------------
DROP TABLE IF EXISTS `function_tab`;
CREATE TABLE `function_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '功能名称',
  `PARENT_ID` bigint(20) DEFAULT NULL COMMENT '父功能ID',
  `CLASSIFY` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '分类 ‘0’为菜单，‘1’为页面，‘2’为功能按钮',
  `IS_MAIN` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '主页面标识 0为非主页面，1为主页面',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of function_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `ins_tab`
-- ----------------------------
DROP TABLE IF EXISTS `ins_tab`;
CREATE TABLE `ins_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '机构名称',
  `SHORTNAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '机构简称',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
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
-- Table structure for `modular_tab`
-- ----------------------------
DROP TABLE IF EXISTS `modular_tab`;
CREATE TABLE `modular_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `NAMESPACE` varchar(50) DEFAULT NULL COMMENT '命名空间 例如：用户模块为UserTab',
  `MAPING` varchar(50) DEFAULT NULL COMMENT '映射表名 例如：用户模块为user_tab',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '所属菜单',
  `DATA_SOURCE_ID` bigint(20) DEFAULT NULL COMMENT '所属数据源',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modular_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `resource_tab`
-- ----------------------------
DROP TABLE IF EXISTS `resource_tab`;
CREATE TABLE `resource_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `URI` varchar(50) DEFAULT NULL COMMENT '资源地址',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '所属模块',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_tab
-- ----------------------------
INSERT INTO `resource_tab` VALUES ('1', '/api/UserTab/get', '1', '1', null, null, null, null);
INSERT INTO `resource_tab` VALUES ('2', '/api/UserTab/getListByPage', '1', '1', null, null, null, null);
INSERT INTO `resource_tab` VALUES ('3', '/api/UserTab/getList', '1', '1', null, null, null, null);
INSERT INTO `resource_tab` VALUES ('4', '/api/UserTab/add', '1', '1', null, null, null, null);
INSERT INTO `resource_tab` VALUES ('5', '/api/UserTab/update', '1', '1', null, null, null, null);
INSERT INTO `resource_tab` VALUES ('6', '/api/UserTab/del', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `role_function_tab`
-- ----------------------------
DROP TABLE IF EXISTS `role_function_tab`;
CREATE TABLE `role_function_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `FUNCTION_ID` bigint(20) DEFAULT NULL COMMENT '功能ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_function_tab
-- ----------------------------

-- ----------------------------
-- Table structure for `role_resource_tab`
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_tab`;
CREATE TABLE `role_resource_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `RESOURCE_ID` bigint(20) DEFAULT NULL COMMENT '资源ID',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource_tab
-- ----------------------------
INSERT INTO `role_resource_tab` VALUES ('1', '1', '1', '1', null, null, null, null);
INSERT INTO `role_resource_tab` VALUES ('2', '1', '2', '1', null, null, null, null);
INSERT INTO `role_resource_tab` VALUES ('3', '1', '3', '1', null, null, null, null);
INSERT INTO `role_resource_tab` VALUES ('4', '2', '4', '1', null, null, null, null);
INSERT INTO `role_resource_tab` VALUES ('5', '3', '5', '1', null, null, null, null);
INSERT INTO `role_resource_tab` VALUES ('6', '4', '6', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `role_tab`
-- ----------------------------
DROP TABLE IF EXISTS `role_tab`;
CREATE TABLE `role_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
  `FLAG` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色标识',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_tab
-- ----------------------------
INSERT INTO `role_tab` VALUES ('1', '用户_查询', 'ROLE_UserTab_QUERY', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('2', '用户_添加', 'ROLE_UserTab_ADD', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('3', '用户_编辑', 'ROLE_UserTab_EDIT', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('4', '用户_删除', 'ROLE_UserTab_DELETE', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('5', '用户_导入', 'ROLE_UserTab_IMPORT', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('6', '用户_导出', 'ROLE_UserTab_EXPORT', '1', null, null, null, null);
INSERT INTO `role_tab` VALUES ('7', '用户_上传', 'ROLE_UserTab_UPLOAD', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `user_role_tab`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_tab`;
CREATE TABLE `user_role_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role_tab
-- ----------------------------
INSERT INTO `user_role_tab` VALUES ('1', '1', '1', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('2', '1', '2', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('3', '1', '3', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('4', '1', '4', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('5', '1', '5', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('6', '1', '6', '1', null, null, null, null);
INSERT INTO `user_role_tab` VALUES ('7', '1', '7', '1', null, null, null, null);

-- ----------------------------
-- Table structure for `user_tab`
-- ----------------------------
DROP TABLE IF EXISTS `user_tab`;
CREATE TABLE `user_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名称',
  `ACCOUNT` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录账户',
  `MOBILE` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `PASSWORD` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `LAST_PASSWORD_RESET_DATE` datetime DEFAULT NULL COMMENT '最后重设密码时间',
  `IS_DELETE` varchar(1) CHARACTER SET utf8 DEFAULT NULL COMMENT '‘0’为注销，‘1’为正常',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_tab
-- ----------------------------
INSERT INTO `user_tab` VALUES ('1', '杨延超', 'yangyanchao1990', '1812610697', 'yangyanchao1990@163.com', '$2a$10$UElm3t3OHhdI53dmJXBLaeAg3/54RKEhbXl2aYC2p3/.xL5hL7ixC', '2018-09-19 14:59:31', '1', '2018-09-08 16:38:35', '1', null, null);
INSERT INTO `user_tab` VALUES ('2', '吴梦晓', 'wumengxiao1992', '15932135009', 'wumengxiao@163.com', '$2a$10$UElm3t3OHhdI53dmJXBLaeAg3/54RKEhbXl2aYC2p3/.xL5hL7ixC', '2018-09-19 14:59:35', '1', '2018-09-08 16:39:29', '1', null, null);
