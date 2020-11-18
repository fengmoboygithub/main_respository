/*
Navicat MySQL Data Transfer

Source Server         : 中证cms
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : modulemanagement

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-11-30 13:56:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dictionaries_tab`
-- ----------------------------
DROP TABLE IF EXISTS `dictionaries_tab`;
CREATE TABLE `dictionaries_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '组名',
  `KEY` varchar(150) NOT NULL COMMENT '唯一标识',
  `VALUE` varchar(150) DEFAULT NULL COMMENT '所属值',
  `SORT_NUM` int(9) DEFAULT NULL COMMENT '排序',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionaries_tab
-- ----------------------------
INSERT INTO `dictionaries_tab` VALUES ('1', 'rulesType', 'requiredType', '必填验证', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('2', 'rulesType', 'lengthType', '长度验证', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('3', 'rulesType', 'formatType', '格式验证', '3', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('4', 'rulesType', 'validatorType', '自定义验证', '4', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('5', 'requiredType#trigger', 'blur', '失去焦点事件', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('6', 'requiredType#trigger', 'change', '变更事件', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('7', 'formatType#type', 'string', '字符格式', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('8', 'formatType#type', 'number', '数字格式', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('9', 'formatType#type', 'integer', '正整数格式', '3', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('10', 'formatType#type', 'float', '浮点数格式', '4', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('11', 'formatType#type', 'date', '日期格式', '5', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('12', 'formatType#type', 'url', '链接格式', '6', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('13', 'formatType#type', 'email', '邮箱格式', '7', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('14', 'validatorType#validator', 'eval#checkMobile', '验证手机号码', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('15', 'validatorType#validator', 'eval#checkNumPot2', '验证数字保留2位小数', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('16', 'validatorType#validator', 'eval#checkIdNum', '验证身份证', '3', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('17', 'elementType', 'FormInput', '文本输入框', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('18', 'elementType', 'FormTextArea', '文本域', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('19', 'elementType', 'FormSelector', '选择器', '3', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('20', 'elementType', 'FormRadio', '单选框', '4', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('21', 'elementType', 'FormCheckbox', '多选框', '5', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('22', 'elementType', 'FormDatePicker', '日期选择器', '6', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('23', 'elementType', 'FormTimePicker', '时间选择器', '7', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('24', 'elementType', 'FormDateTimePicker', '日期时间选择器', '8', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('25', 'elementType', 'FormSwitch', '开关选择器', '9', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('26', 'connectorName', 'and', '和', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('27', 'connectorName', 'or', '或', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('28', 'comparisonRule', 'IsNull', '为空', '1', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('29', 'comparisonRule', 'IsNotNull', '不为空', '2', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('30', 'comparisonRule', 'EqualTo', '等于', '3', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('31', 'comparisonRule', 'NotEqualTo', '不等于', '4', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('32', 'comparisonRule', 'GreaterThan', '大于', '5', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('33', 'comparisonRule', 'GreaterThanOrEqualTo', '大于等于', '6', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('34', 'comparisonRule', 'LessThan', '小于', '7', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('35', 'comparisonRule', 'LessThanOrEqualTo', '小于等于', '8', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('36', 'comparisonRule', 'Like', '模糊', '9', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('37', 'comparisonRule', 'NotLike', '不模糊', '10', '', '0000-00-00 00:00:00', null, '0000-00-00 00:00:00', null);
INSERT INTO `dictionaries_tab` VALUES ('38', 'dataType', '0', '无参数', '1', null, null, null, null, null);
INSERT INTO `dictionaries_tab` VALUES ('39', 'dataType', '1', '数字类型', '2', null, null, null, null, null);
INSERT INTO `dictionaries_tab` VALUES ('40', 'dataType', '2', '长数字类型', '3', null, null, null, null, null);
INSERT INTO `dictionaries_tab` VALUES ('41', 'dataType', '3', '日期类型', '4', null, null, null, null, null);
INSERT INTO `dictionaries_tab` VALUES ('42', 'dataType', '4', '字符串类型', '5', null, null, null, null, null);
INSERT INTO `dictionaries_tab` VALUES ('43', 'dataType', '5', '浮点精度类型', '6', null, null, null, null, null);

-- ----------------------------
-- Table structure for `element_tab`
-- ----------------------------
DROP TABLE IF EXISTS `element_tab`;
CREATE TABLE `element_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FORM_ITEM_ID` bigint(20) DEFAULT NULL COMMENT '表单项ID',
  `QUERY_CRITERIA_ITEM_ID` bigint(20) DEFAULT NULL COMMENT '查询条件项ID',
  `ELEMENT_TYPE` varchar(150) DEFAULT NULL COMMENT '元素类型',
  `ELEMENT_TYPE_NAME` varchar(150) DEFAULT NULL COMMENT '元素类型名称',
  `MODEL_NAME` varchar(50) DEFAULT NULL COMMENT '模型名称',
  `STYLE_NAME` varchar(50) DEFAULT NULL COMMENT '样式风格',
  `PLACEHOLDER` varchar(50) DEFAULT NULL COMMENT '背景文字',
  `MULTIPLE` varchar(6) DEFAULT NULL COMMENT '多选标识',
  `FILTERABLE` varchar(6) DEFAULT NULL COMMENT '过滤标识',
  `OPTIONS` varchar(150) DEFAULT NULL COMMENT '选项集',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of element_tab
-- ----------------------------
INSERT INTO `element_tab` VALUES ('1', null, '1', 'FormInput', '文本输入框', 'andPropLike', 'width: 200px', '属性名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('2', null, '2', 'FormInput', '文本输入框', 'andLabelLike', 'width: 200px', '标签名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('3', null, '3', 'FormInput', '文本输入框', 'andSortableLike', 'width: 200px', '排序标识', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('4', null, '4', 'FormInput', '文本输入框', 'andMinWidthLike', 'width: 200px', '最小宽度', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('5', null, '5', 'FormInput', '文本输入框', 'andPropLike', 'width: 200px', '属性名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('6', null, '6', 'FormInput', '文本输入框', 'andLabelLike', 'width: 200px', '标签名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('7', null, '7', 'FormInput', '文本输入框', 'andSortableLike', 'width: 200px', '排序标识', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('8', null, '8', 'FormInput', '文本输入框', 'andMinWidthLike', 'width: 200px', '最小宽度', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('9', null, '9', 'FormInput', '文本输入框', 'andModularIdLike', 'width: 200px', '模块ID', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('18', '9', null, 'FormInput', '文本输入框', 'modularId', 'width: 200px', '输入模块ID', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('19', '10', null, 'FormInput', '文本输入框', 'fieldId', 'width: 200px', '输入模块字段ID', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('20', '11', null, 'FormInput', '文本输入框', 'prop', 'width: 200px', '输入属性名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('21', '12', null, 'FormInput', '文本输入框', 'label', 'width: 200px', '输入标签名称', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('22', '13', null, 'FormInput', '文本输入框', 'sortable', 'width: 200px', '输入排序标识', null, null, null, null, null, null, null, null);
INSERT INTO `element_tab` VALUES ('23', '14', null, 'FormInput', '文本输入框', 'minWidth', 'width: 200px', '输入最小宽度', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `form_item_tab`
-- ----------------------------
DROP TABLE IF EXISTS `form_item_tab`;
CREATE TABLE `form_item_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '模块ID',
  `FIELD_ID` bigint(20) DEFAULT NULL COMMENT '模块字段ID',
  `PROP` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `LABEL` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of form_item_tab
-- ----------------------------
INSERT INTO `form_item_tab` VALUES ('9', '34', '1', 'modularId', '模块ID', null, null, null, null, null);
INSERT INTO `form_item_tab` VALUES ('10', '34', '2', 'fieldId', '模块字段ID', null, null, null, null, null);
INSERT INTO `form_item_tab` VALUES ('11', '34', '3', 'prop', '属性名称', null, null, null, null, null);
INSERT INTO `form_item_tab` VALUES ('12', '34', '4', 'label', '标签名称', null, null, null, null, null);
INSERT INTO `form_item_tab` VALUES ('13', '34', '5', 'sortable', '排序标识', null, null, null, null, null);
INSERT INTO `form_item_tab` VALUES ('14', '34', '6', 'minWidth', '最小宽度', null, null, null, null, null);

-- ----------------------------
-- Table structure for `modular_field_tab`
-- ----------------------------
DROP TABLE IF EXISTS `modular_field_tab`;
CREATE TABLE `modular_field_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '模块ID',
  `COLUMN_NAME` varchar(50) DEFAULT NULL COMMENT '列名',
  `PROP` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `COLUMN_COMMENT` varchar(200) DEFAULT NULL COMMENT '列注释',
  `LABEL` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modular_field_tab
-- ----------------------------
INSERT INTO `modular_field_tab` VALUES ('1', '34', 'modular_id', 'modularId', '模块ID', '模块ID', null, null, null, null, null);
INSERT INTO `modular_field_tab` VALUES ('2', '34', 'field_id', 'fieldId', '模块字段ID', '模块字段ID', null, null, null, null, null);
INSERT INTO `modular_field_tab` VALUES ('3', '34', 'prop', 'prop', '属性名称', '属性名称', null, null, null, null, null);
INSERT INTO `modular_field_tab` VALUES ('4', '34', 'label', 'label', '标签名称', '标签名称', null, null, null, null, null);
INSERT INTO `modular_field_tab` VALUES ('5', '34', 'sortable', 'sortable', '排序标识', '排序标识', null, null, null, null, null);
INSERT INTO `modular_field_tab` VALUES ('6', '34', 'min_width', 'minWidth', '最小宽度', '最小宽度', null, null, null, null, null);

-- ----------------------------
-- Table structure for `modular_tab`
-- ----------------------------
DROP TABLE IF EXISTS `modular_tab`;
CREATE TABLE `modular_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `NAMESPACE` varchar(50) DEFAULT NULL COMMENT '命名空间',
  `MAPING` varchar(50) DEFAULT NULL COMMENT '映射表名',
  `SCHEMA_NAME` varchar(100) DEFAULT NULL COMMENT '实例名',
  `MENU_ID` bigint(20) DEFAULT NULL COMMENT '所属菜单',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of modular_tab
-- ----------------------------
INSERT INTO `modular_tab` VALUES ('1', '仪表盘_模块', 'Index', 'index', 'bmp', '1', '1', '2018-10-17 09:09:59', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('2', '岗位_模块', 'PostTab', 'post_tab', 'bmp', '3', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('3', '用户岗位_模块', 'UserPostRela', 'user_post_rela', 'bmp', '5', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('4', '用户_模块', 'UserTab', 'user_tab', 'bmp', '7', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('5', '部门_模块', 'DeptTab', 'dept_tab', 'bmp', '3', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('6', '机构_模块', 'InsTab', 'ins_tab', 'bmp', '3', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('7', '角色_模块', 'RoleTab', 'role_tab', 'bmp', '7', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('8', '岗位角色_模块', 'PostRoleRela', 'post_role_rela', 'bmp', '5', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('9', '角色权限_模块', 'RoleAuthorityRela', 'role_authority_rela', 'bmp', '5', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('10', '接口资源_模块', 'ResourceTab', 'resource_tab', 'bmp', '7', '1', '2018-10-17 09:10:00', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('11', '权限_模块', 'AuthorityTab', 'authority_tab', 'bmp', '7', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('13', '权限页面_模块', 'AuthorityPageRela', 'authority_page_rela', 'bmp', '5', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('14', '用户角色_模块', 'UserRoleRela', 'user_role_rela', 'bmp', '5', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('15', '权限资源_模块', 'AuthorityResourceRela', 'authority_resource_rela', 'bmp', '5', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('16', '菜单页面_模块', 'PageTab', 'page_tab', 'bmp', '7', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('17', '配置_模块', 'ConfigTab', 'config_tab', 'bmp', '7', '1', '2018-10-17 09:10:01', '16', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('18', '站点_模块', 'SiteTab', 'site_tab', 'webcomponent', '22', '1', '2018-11-06 16:42:17', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('19', '用户站点关系_模块', 'ComponentImportRela', 'component_import_rela', 'webcomponent', '24', '1', '2018-11-06 16:42:17', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('20', '数据字典_模块', 'DictionaryTab', 'dictionary_tab', 'webcomponent', '26', '1', '2018-11-06 16:42:17', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('21', '资源_模块', 'MediaTab', 'media_tab', 'webcomponent', '22', '1', '2018-11-06 16:42:17', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('22', '数据参数模板_模块', 'DataJsonTemplateTab', 'data_json_template_tab', 'webcomponent', '29', '1', '2018-11-06 16:42:17', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('23', '组件实例_模块', 'ComponentInstanceTab', 'component_instance_tab', 'webcomponent', '31', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('24', '组件类型_模块', 'ComponentTypeTab', 'component_type_tab', 'webcomponent', '33', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('25', '页面_模块', 'FileTab', 'file_tab', 'webcomponent', '22', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('26', '组件_模块', 'ComponentTab', 'component_tab', 'webcomponent', '33', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('27', '资源目录关系_模块', 'MediaFolderRela', 'media_folder_rela', 'webcomponent', '24', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('28', '资源页面关系_模块', 'MediaFileRela', 'media_file_rela', 'webcomponent', '24', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('29', '组件模板_模块', 'ComponentTemplateTab', 'component_template_tab', 'webcomponent', '29', '1', '2018-11-06 16:42:18', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('30', '数据参数实例_模块', 'DataJsonInstanceTab', 'data_json_instance_tab', 'webcomponent', '31', '1', '2018-11-06 16:42:19', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('31', '目录_模块', 'FolderTab', 'folder_tab', 'webcomponent', '22', '1', '2018-11-06 16:42:19', '18', '0000-00-00 00:00:00', null);
INSERT INTO `modular_tab` VALUES ('32', '模块_模块', 'ModularTab', 'modular_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `modular_tab` VALUES ('33', '模块字段_模块', 'ModularFieldTab', 'modular_field_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:52', '23', null, null);
INSERT INTO `modular_tab` VALUES ('34', '表格项_模块', 'TableItemTab', 'table_item_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `modular_tab` VALUES ('35', '数据字典_模块', 'DictionariesTab', 'dictionaries_tab', 'modulemanagement', '26', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `modular_tab` VALUES ('36', '元素_模块', 'ElementTab', 'element_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `modular_tab` VALUES ('37', '查询条件项_模块', 'QueryCriteriaItemTab', 'query_criteria_item_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:53', '23', null, null);
INSERT INTO `modular_tab` VALUES ('38', '验证规则_模块', 'RulesTab', 'rules_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:54', '23', null, null);
INSERT INTO `modular_tab` VALUES ('39', '表单项_模块', 'FormItemTab', 'form_item_tab', 'modulemanagement', '42', '1', '2018-11-25 14:01:54', '23', null, null);

-- ----------------------------
-- Table structure for `query_criteria_item_tab`
-- ----------------------------
DROP TABLE IF EXISTS `query_criteria_item_tab`;
CREATE TABLE `query_criteria_item_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '模块ID',
  `FIELD_ID` bigint(20) DEFAULT NULL COMMENT '模块字段ID',
  `CONNECTOR_NAME` varchar(50) DEFAULT NULL COMMENT '连接符',
  `COMPARISON_RULE` varchar(50) DEFAULT NULL COMMENT '比较规则',
  `DATA_TYPE` int(1) DEFAULT NULL COMMENT '数据类型',
  `PROP` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `LABEL` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of query_criteria_item_tab
-- ----------------------------
INSERT INTO `query_criteria_item_tab` VALUES ('5', '34', '3', 'and', 'Like', '4', 'andPropLike', '属性名称', null, null, null, null, null);
INSERT INTO `query_criteria_item_tab` VALUES ('6', '34', '4', 'and', 'Like', '4', 'andLabelLike', '标签名称', null, null, null, null, null);
INSERT INTO `query_criteria_item_tab` VALUES ('7', '34', '5', 'and', 'Like', '4', 'andSortableLike', '排序标识', null, null, null, null, null);
INSERT INTO `query_criteria_item_tab` VALUES ('8', '34', '6', 'and', 'Like', '4', 'andMinWidthLike', '最小宽度', null, null, null, null, null);
INSERT INTO `query_criteria_item_tab` VALUES ('9', '34', '1', 'and', 'Like', '4', 'andModularIdLike', '模块ID', null, null, null, null, null);

-- ----------------------------
-- Table structure for `rules_tab`
-- ----------------------------
DROP TABLE IF EXISTS `rules_tab`;
CREATE TABLE `rules_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FORM_ITEM_ID` bigint(20) DEFAULT NULL COMMENT '表单项ID',
  `RULES_TYPE` varchar(150) DEFAULT NULL COMMENT '验证规则类型',
  `RULES_TYPE_NAME` varchar(150) DEFAULT NULL COMMENT '验证规则类型名称',
  `REQUIRED` varchar(6) DEFAULT NULL COMMENT '必填标识',
  `MESSAGE` varchar(150) DEFAULT NULL COMMENT '验证信息',
  `TRIGGER_NAME` varchar(150) DEFAULT NULL COMMENT '触发方式',
  `TYPE_ID` varchar(10) DEFAULT NULL COMMENT '验证格式类型',
  `MIN` int(6) DEFAULT NULL COMMENT '最小值',
  `MAX` int(6) DEFAULT NULL COMMENT '最大值',
  `LEN` int(6) DEFAULT NULL COMMENT '长度相等值',
  `VALIDATOR` varchar(50) DEFAULT NULL COMMENT '自定义验证函数',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rules_tab
-- ----------------------------
INSERT INTO `rules_tab` VALUES ('7', '9', 'requiredType', '必填验证', 'true', '请输入模块ID', 'blur', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `rules_tab` VALUES ('8', '10', 'requiredType', '必填验证', 'true', '请输入模块字段ID', 'blur', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `rules_tab` VALUES ('9', '11', 'requiredType', '必填验证', 'true', '请输入属性名称', 'blur', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `rules_tab` VALUES ('10', '12', 'requiredType', '必填验证', 'true', '请输入标签名称', 'blur', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `rules_tab` VALUES ('11', '13', 'requiredType', '必填验证', 'true', '请输入排序标识', 'blur', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `rules_tab` VALUES ('12', '14', 'requiredType', '必填验证', 'true', '请输入最小宽度', 'blur', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `table_item_tab`
-- ----------------------------
DROP TABLE IF EXISTS `table_item_tab`;
CREATE TABLE `table_item_tab` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MODULAR_ID` bigint(20) DEFAULT NULL COMMENT '模块ID',
  `FIELD_ID` bigint(20) DEFAULT NULL COMMENT '模块字段ID',
  `PROP` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `LABEL` varchar(50) DEFAULT NULL COMMENT '标签名称',
  `SORTABLE` varchar(6) DEFAULT NULL COMMENT '排序标识',
  `MIN_WIDTH` varchar(50) DEFAULT NULL COMMENT '最小宽度',
  `IS_DELETE` varchar(1) DEFAULT NULL COMMENT '注销标识',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` bigint(20) DEFAULT NULL COMMENT '最近修改人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of table_item_tab
-- ----------------------------
INSERT INTO `table_item_tab` VALUES ('1', '34', '1', 'modularId', '模块ID', 'true', '150px', null, null, null, null, null);
INSERT INTO `table_item_tab` VALUES ('2', '34', '3', 'prop', '属性名称', 'true', '150px', null, null, null, null, null);
INSERT INTO `table_item_tab` VALUES ('3', '34', '4', 'label', '标签名称', 'true', '150px', null, null, null, null, null);
INSERT INTO `table_item_tab` VALUES ('4', '34', '5', 'sortable', '排序标识', 'true', '150px', null, null, null, null, null);
INSERT INTO `table_item_tab` VALUES ('5', '34', '6', 'minWidth', '最小宽度', 'true', '150px', null, null, null, null, null);
