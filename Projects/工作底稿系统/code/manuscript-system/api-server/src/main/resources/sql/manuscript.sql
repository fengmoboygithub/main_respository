/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : 127.0.0.1:3306
Source Database       : manuscript

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2020-01-07 15:51:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dictionary_tab
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_tab`;
CREATE TABLE `dictionary_tab` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_group_id` bigint(20) DEFAULT NULL COMMENT '组id',
  `dic_key` varchar(200) DEFAULT NULL COMMENT '字典编码',
  `dic_value` varchar(200) DEFAULT NULL COMMENT '字典值',
  `dic_sort` int(3) DEFAULT NULL COMMENT '排序',
  `dic_desc` varchar(200) DEFAULT NULL COMMENT '字典描述',
  `is_delete` varchar(1) DEFAULT NULL COMMENT '注销',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(6) DEFAULT NULL COMMENT '最近修改时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '最近修改人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary_tab
-- ----------------------------
INSERT INTO `dictionary_tab` VALUES ('1', '-1', 'zzjs_cms_model', 'local', '1', '服务模式', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('2', '-1', 'zzjs_cms_rows', '5', '2', '每页显示条数', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('3', '-1', 'zzjs_cms_source_address_local', 'http://localhost:8091/static-file-plate/', '3', '资源项目访问地址(本地)', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('4', '-1', 'zzjs_cms_source_address_test', 'http://172.17.33.10:8091/static-file-plate/', '4', '资源项目访问地址(测试)', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('5', '-1', 'zzjs_cms_source_real_address_local', 'D:/static-project/static-file-plate/', '5', '资源项目真实地址(本地)', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('6', '-1', 'zzjs_cms_source_real_address_test', '/opt/static-project/static-file-plate/', '6', '资源项目真实地址(测试)', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('7', '-1', 'zzjs_component_dir', 'js/component/', '7', '输出JS文件目录', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('8', '-1', 'zzjs_js_template_file', 'componentJs.ftl', '8', '输出JS模板文件', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('9', '-1', 'zzjs_seo_description', 'Manuscript Platform|投行底稿管理系统', '9', '网站描述', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('10', '-1', 'zzjs_seo_title', '投行底稿管理系统', '10', '网站名称', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('11', '-1', 'zzjs_site_folder', 'D:/output/', '11', '站点导出目录', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('12', '-1', 'zzjs_template', 'output', '12', '输出模板', '0', null, null, null, null);
INSERT INTO `dictionary_tab` VALUES ('13', '-1', 'zzjs_template_file', 'output.ftl', '13', '输出模板文件', '0', null, null, null, null);

-- ----------------------------
-- Table structure for user_tab
-- ----------------------------
DROP TABLE IF EXISTS `user_tab`;
CREATE TABLE `user_tab` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `user_sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `user_mobile` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_acc` varchar(50) DEFAULT NULL COMMENT '账户',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '账户密码',
  `is_delete` varchar(1) DEFAULT NULL COMMENT '注销',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(6) DEFAULT NULL COMMENT '最近修改时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '最近修改人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_tab
-- ----------------------------
INSERT INTO `user_tab` VALUES ('2', '杨延超', '1', '18612610697', 'yangyanchao@otc-tech.cn', 'admin', '0192023a7bbd73250516f069df18b500', '0', '2016-08-24 16:51:44.000000', '2', null, null);
