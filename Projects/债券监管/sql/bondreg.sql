/*
Navicat MySQL Data Transfer

Source Server         : 债券监管
Source Server Version : 50722
Source Host           : 172.16.101.136:3306
Source Database       : bondreg

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-11 10:34:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for abs_base_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_base_info`;
CREATE TABLE `abs_base_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abs_name` varchar(600) DEFAULT NULL,
  `abs_type` varchar(600) DEFAULT NULL,
  `abs_code` varchar(600) DEFAULT NULL,
  `abs_short_name` varchar(600) DEFAULT NULL,
  `trem` varchar(600) DEFAULT NULL,
  `trem_remark` varchar(600) DEFAULT NULL,
  `bond_rating` varchar(600) DEFAULT NULL,
  `credit_measures` varchar(2000) DEFAULT NULL,
  `trading_location` varchar(600) DEFAULT NULL,
  `current_bond_rating` varchar(600) DEFAULT NULL,
  `issue_rate` varchar(600) DEFAULT NULL,
  `issue_time` datetime DEFAULT NULL,
  `interest_time` datetime DEFAULT NULL,
  `debt_account` int(11) DEFAULT NULL,
  `individual_investor_account` int(11) DEFAULT NULL,
  `personal_debt_rate` varchar(600) DEFAULT NULL,
  `current_rate` varchar(600) DEFAULT NULL,
  `due_time` datetime DEFAULT NULL,
  `proper_management` varchar(600) DEFAULT NULL,
  `proper_management_time` datetime DEFAULT NULL,
  `original_owner_name` varchar(600) DEFAULT NULL,
  `original_owner_srb` varchar(600) DEFAULT NULL COMMENT '原始权益人所属证监局',
  `registered_place` varchar(400) DEFAULT NULL,
  `registration_place` varchar(100) DEFAULT NULL,
  `industry` varchar(600) DEFAULT NULL,
  `business_scope` varchar(600) DEFAULT NULL,
  `nature` varchar(600) DEFAULT NULL,
  `main_business` varchar(600) DEFAULT NULL,
  `if_belongs_financial` varchar(600) DEFAULT NULL,
  `main_rating` varchar(600) DEFAULT NULL,
  `relate_srb` varchar(600) DEFAULT NULL,
  `manager_name` varchar(600) DEFAULT NULL,
  `manager_disclosure_specialist` varchar(600) DEFAULT NULL,
  `specialist_contact_way` varchar(40) DEFAULT NULL,
  `manager_charger` varchar(40) DEFAULT NULL,
  `manager_contact_way` varchar(40) DEFAULT NULL,
  `manager_registered_place` varchar(40) DEFAULT NULL,
  `manager_srb` varchar(40) DEFAULT NULL,
  `accounting_name` varchar(40) DEFAULT NULL,
  `accounting_signature` varchar(40) DEFAULT NULL,
  `law_name` varchar(40) DEFAULT NULL,
  `law_signature` varchar(40) DEFAULT NULL,
  `rating_agency_name` varchar(40) DEFAULT NULL,
  `rating_agency_contact_way` varchar(40) DEFAULT NULL,
  `rating_agency_charge` varchar(40) DEFAULT NULL,
  `asset_appraisal_agency` varchar(1000) DEFAULT NULL,
  `asset_appraisal_agency_charge` varchar(1000) DEFAULT NULL,
  `security_rate` varchar(1000) DEFAULT NULL,
  `JUR_SRB` varchar(1000) DEFAULT NULL,
  `edit_state` int(11) DEFAULT NULL,
  `no_action_letter_time` datetime DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `other_rating_agency_name` longtext COMMENT '其他资信评估机构名称',
  `child_code` varchar(50) DEFAULT NULL COMMENT '关联子产品代码',
  `Custodian` varchar(100) DEFAULT NULL COMMENT '托管机构名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_base_info
-- ----------------------------
INSERT INTO `abs_base_info` VALUES ('78', null, null, 'S1111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, '111', null, null, null);
INSERT INTO `abs_base_info` VALUES ('79', '', '', 'S1111', '', '', '', null, '', '', null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, '', '', null, '', '', null, '', null, null, '', null, null, '天津证监局', '', '', '', '', '', null, '', '', '', null, null, '1', null, '111', null, null, null);
INSERT INTO `abs_base_info` VALUES ('80', null, null, '12121', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, '212121', null, null, null);
INSERT INTO `abs_base_info` VALUES ('81', '1', '租赁债权', '1', '乱箭123', '11', '11', null, '11', '报价系统', null, null, '2019-08-14 00:00:00', '2019-08-14 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭321', null, null, null, null, '11', '中央国企', '11', '是', 'AAA', null, '11', null, null, '11', '', null, null, '11', '11', '11', '11', '11', '', '11', '11', '11', null, null, '1', '2019-08-26 00:00:00', '1', null, null, '11');
INSERT INTO `abs_base_info` VALUES ('82', '11', '', 'S10086', '', '', '', null, '', '', null, null, null, null, null, null, null, null, null, null, null, '', null, ',天津证监局,北京证监局,辽宁证监局', null, null, '', '', null, '', '', null, '', null, null, '', null, null, '北京证监局,天津证监局,河北证监局', '', '', '', '', '', null, '', '', '', null, null, '1', null, '1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('83', null, null, '10086', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, '1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('84', null, null, '10086', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('85', '资产支持证券名称', '租赁债权', '100', '测试章鱼123', '1', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-05 00:00:00', '2039-01-07 00:00:00', null, null, null, null, '2019-01-26 00:00:00', null, null, '章鱼测试123', null, '北京证监局,天津证监局,河北证监局    ', null, null, '原始权益人名称', '中央国企', '原始权益人名称', '是', 'CCC', '北京证监局,天津证监局,河北证监局', '管理人名称', null, null, '管理人名称', '监管联系人', null, null, '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '监管联系人', '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-09-01 00:00:00', '100', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('86', '资产支持证券名称', '租赁债权', '101', '资产支持证券名称', '3', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2029-08-26 00:00:00', '2039-08-26 00:00:00', null, null, null, null, '2030-08-26 00:00:00', null, null, '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '101', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('87', '资产支持证券名称', '租赁债权', '102', '资产支持证券名称', '5', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '102', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('88', '资产支持证券名称', '租赁债权', '103', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭', null, ',北京证监局  ', null, null, '原始权益人名称', '中央国企', '', '是', 'CCC', '海南证监局,辽宁证监局,北京证监局', '管理人名称', null, null, '管理人名称', '', null, null, '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '', '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '103', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('89', '资产支持证券名称', '租赁债权', '104', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '104', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('90', '资产支持证券名称', '租赁债权', '105', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭测试', null, ',北京证监局  ', null, null, '原始权益人名称', '中央国企', '', '是', 'CCC', null, '管理人名称', null, null, '管理人名称', '', null, null, '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '', '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '105', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('91', '资产支持证券名称', '租赁债权', '106', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '106', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('92', '资产支持证券名称', '租赁债权', '107', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '107', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('93', '资产支持证券名称', '租赁债权', '108', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '108', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('94', '资产支持证券名称', '租赁债权', '109', '资产支持证券名称', '6年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2010-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭123', null, ',北京证监局  ', null, null, '原始权益人名称', '中央国企', '', '是', 'CCC', null, '管理人名称', null, null, '管理人名称', '', null, null, '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '', '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '109', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('95', '乱箭123', '租赁债权', '110', '乱箭321', '111', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭1234', null, ',北京证监局,天津证监局,河北证监局', null, ',农、林、牧、渔业', '111', '中央国企', null, '是', 'CCC', null, '乱箭4321', null, null, '111', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '110', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('96', '资产支持证券名称', '租赁债权', '111', '321', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '321', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '111', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('97', '资产支持证券名称', '租赁债权', '112', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '112', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('98', '资产支持证券名称', '租赁债权', '113', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',采矿业,制造业,电力、热力、燃气及水生产和供应业,建筑业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '113', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('99', '资产支持证券名称', '租赁债权', '114', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '114', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('100', '资产支持证券名称', '租赁债权', '115', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '115', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('101', '资产支持证券名称', '租赁债权', '116', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',电力、热力、燃气及水生产和供应业,批发和零售业,交通运输、仓库和邮政业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '116', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('102', '资产支持证券名称', '租赁债权', '117', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '117', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('103', '资产支持证券名称', '租赁债权', '118', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '118', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('104', '资产支持证券名称', '租赁债权', '119', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '119', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('105', '资产支持证券名称', '租赁债权', '120', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',制造业,电力、热力、燃气及水生产和供应业,建筑业,批发和零售业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '120', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('106', '资产支持证券名称', '租赁债权', '121', '章鱼测试', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2018-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '测试章鱼', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '121', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('107', '2', '租赁债权', '122', '2', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '122', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('108', '资产支持证券名称', '租赁债权', '123', '乱箭123', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '乱箭321', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '123', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('109', '资产支持证券名称', '租赁债权', '124', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '124', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('110', '资产支持证券名称', '租赁债权', '125', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '125', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('111', '资产支持证券名称', '租赁债权', '126', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '126', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('112', '资产支持证券名称', '租赁债权', '127', '资产支持证券名称', '1年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '127', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('113', '资产支持证券名称', '租赁债权', '128', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '128', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('114', '资产支持证券名称', '租赁债权', '129', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '129', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('115', '资产支持证券名称', '租赁债权', '130', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '130', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('116', '资产支持证券名称', '租赁债权', '131', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '131', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('117', '资产支持证券名称', '租赁债权', '132', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '132', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('118', '资产支持证券名称', '租赁债权', '133', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '133', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('119', '资产支持证券名称', '租赁债权', '134', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '134', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('120', '资产支持证券名称', '租赁债权', '135', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '135', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('121', '资产支持证券名称', '租赁债权', '136', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2012-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, '2019-08-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-08-26 00:00:00', '136', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('133', '资产支持证券名称', '租赁债权', null, '资产支持证券名称', '1年', '无异议函编号', null, '无异议函编号', null, null, null, null, null, null, null, null, null, null, null, null, '乱箭123', null, '北京证监局', '北京', '建筑业,教育,卫生和社会工作,文化、体育和娱乐业,综合', '无异议函编号', '中央国企', null, '是', 'AAA', null, '无异议函编号', null, null, '无异议函编号', '13433332222', null, '辽宁证监局', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', null, null, null, '系统管理员', null, '2019-08-26 00:00:00', '100', null, null, null);
INSERT INTO `abs_base_info` VALUES ('134', '2', '租赁债权', null, null, '1年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', null, null, '1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('135', null, '普通公司债', '222222', '222222', '1年', null, null, '', '', null, null, null, null, null, null, null, null, null, null, null, '', null, '  ', null, null, null, '', '', null, null, null, '乱箭', null, null, null, '', null, null, null, null, null, null, '', '', null, null, null, null, null, '1', null, '222222', null, null, null);
INSERT INTO `abs_base_info` VALUES ('136', 'CODE110', '', 'CODE110', 'CODE110', '1年', '', null, '', '', null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, '', '', '', '', '', null, '', null, null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, '1', null, 'CODE110', null, null, null);
INSERT INTO `abs_base_info` VALUES ('137', null, null, 'CODE1101', null, '1年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, 'CODE1101', null, null, null);
INSERT INTO `abs_base_info` VALUES ('138', null, null, 'LSDDDDDDDDDDDDDD', null, '1年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'LSDDDDDDDDDDDDDD', null, null, null);
INSERT INTO `abs_base_info` VALUES ('139', null, null, 'LSDDDDDDDDDDDDDD1', null, '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, 'LSDDDDDDDDDDDDDD1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('140', null, null, 'LSDDDDDDDDDDDDDD12', null, '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, 'LSDDDDDDDDDDDDDD12', null, null, null);
INSERT INTO `abs_base_info` VALUES ('141', null, null, null, null, '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', '1', null, 'KKKKKKKKKKKKK', null, null, null);
INSERT INTO `abs_base_info` VALUES ('142', null, null, null, null, '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', '1', null, 'KKKKKKKKKKKKK1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('143', 'KKKKKKKKKKKKK1', '租赁债权', null, null, '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', null, null, 'KKKKKKKKKKKKK1', null, null, null);
INSERT INTO `abs_base_info` VALUES ('144', 'KKKKKKKKKKKKK12', '租赁债权', null, 'KKKKKKKKKKKKK12', '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', '1', null, 'KKKKKKKKKKKKK12', null, null, null);
INSERT INTO `abs_base_info` VALUES ('145', 'KKKKKKKKKKKKK1223', null, null, 'KKKKKKKKKKKKK1223', '2年', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '系统管理员', '1', null, 'KKKKKKKKKKKKK123', null, null, null);
INSERT INTO `abs_base_info` VALUES ('146', '资产支持证券名称', '租赁债权', '114', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '114', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('147', '资产支持证券名称', '租赁债权', '115', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '115', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('148', '资产支持证券名称', '租赁债权', '116', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '116', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('149', '资产支持证券名称', '租赁债权', '117', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '117', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('150', '资产支持证券名称', '租赁债权', '118', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '118', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('151', '资产支持证券名称', '租赁债权', '119', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '119', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('152', '资产支持证券名称', '租赁债权', '120', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '120', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('153', '资产支持证券名称', '租赁债权', '121', '章鱼测试', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-07-26 00:00:00', null, null, null, null, '2019-07-26 00:00:00', null, null, '测试章鱼', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-07-26 00:00:00', '121', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('154', '资产支持证券名称', '租赁债权', '114', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '114', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('155', '资产支持证券名称', '租赁债权', '115', '资产支持证券名称', '3年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '115', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('156', '资产支持证券名称', '租赁债权', '116', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '116', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('157', '资产支持证券名称', '租赁债权', '117', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '117', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('158', '资产支持证券名称', '租赁债权', '118', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '118', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('159', '资产支持证券名称', '租赁债权', '119', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2013-07-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '119', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('160', '资产支持证券名称', '租赁债权', '120', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-02-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '原始权益人名称', null, ',北京证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '120', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('161', '资产支持证券名称', '租赁债权', '121', '章鱼测试', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-02-26 00:00:00', '2019-02-26 00:00:00', null, null, null, null, '2019-02-26 00:00:00', null, null, '测试章鱼', null, '北京证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '北京证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-02-26 00:00:00', '121', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('162', '资产支持证券名称', '租赁债权', '111', '321', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '321', null, '四川证监局,天津证监局,河北证监局', null, null, '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局,河北证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '111', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('163', '资产支持证券名称', '租赁债权', '112', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '112', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('164', '资产支持证券名称', '租赁债权', '113', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '113', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('165', '资产支持证券名称', '租赁债权', '114', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '114', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('166', '资产支持证券名称', '租赁债权', '115', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '115', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('167', '资产支持证券名称', '租赁债权', '116', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '116', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('168', '资产支持证券名称', '租赁债权', '117', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '117', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('169', '资产支持证券名称', '租赁债权', '118', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '118', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('170', '资产支持证券名称', '租赁债权', '119', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '119', null, null, '管理人名称');
INSERT INTO `abs_base_info` VALUES ('171', '资产支持证券名称', '租赁债权', '120', '资产支持证券名称', '5年', '资产支持证券名称1', null, '资产支持证券名称', '报价系统', null, null, '2019-05-26 00:00:00', '2019-05-26 00:00:00', null, null, null, null, '2019-05-26 00:00:00', null, null, '原始权益人名称', null, ',四川证监局', null, ',农、林、牧、渔业', '原始权益人名称', '中央国企', null, '是', 'CCC', null, '管理人名称', null, null, '管理人名称', null, null, '四川证监局,天津证监局', '管理人名称', '管理人名称', '管理人名称', '管理人名称', '管理人名称', null, '管理人名称', '管理人名称', '管理人名称', null, null, '1', '2019-05-26 00:00:00', '120', null, null, '管理人名称');

-- ----------------------------
-- Table structure for abs_base_info_child
-- ----------------------------
DROP TABLE IF EXISTS `abs_base_info_child`;
CREATE TABLE `abs_base_info_child` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `code_num` varchar(200) DEFAULT NULL,
  `code_name` varchar(200) DEFAULT NULL,
  `bond_rating` varchar(200) DEFAULT NULL,
  `current_bond_rating` varchar(200) DEFAULT NULL,
  `self_scale` varchar(500) DEFAULT NULL,
  `scale_rate` varchar(200) DEFAULT NULL,
  `trem` varchar(500) DEFAULT NULL,
  `trem_remark` varchar(500) DEFAULT NULL,
  `issue_rate` varchar(500) DEFAULT NULL,
  `corpus_profit_arrange` varchar(2000) DEFAULT NULL,
  `pay_interest_plan` varchar(500) DEFAULT NULL,
  `corpus_profit_cash_details` varchar(500) DEFAULT NULL,
  `file_path` varchar(500) DEFAULT NULL,
  `upload_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_base_info_child
-- ----------------------------
INSERT INTO `abs_base_info_child` VALUES ('188', '79', '11', '11', 'AAA', 'AAA', '1', '1', '2019-08-06', '1', '1', '1', '1', null, null, null);
INSERT INTO `abs_base_info_child` VALUES ('189', '82', 'T0001', '测试001', 'AA-', 'BB', '100', '100', '2019-08-28', null, '1', '1', '1', null, null, null);
INSERT INTO `abs_base_info_child` VALUES ('190', '82', 'T0002', '测试002', 'AAA', 'B-', '200', '200', '2019-08-17', '测试', '2', '2', '2', null, null, null);

-- ----------------------------
-- Table structure for abs_bottom_debtor
-- ----------------------------
DROP TABLE IF EXISTS `abs_bottom_debtor`;
CREATE TABLE `abs_bottom_debtor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abs_id` int(11) DEFAULT NULL,
  `trial_id` int(11) DEFAULT NULL,
  `bottom_debtor` varchar(60) DEFAULT NULL,
  `contract_amount` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_bottom_debtor
-- ----------------------------
INSERT INTO `abs_bottom_debtor` VALUES ('31', '82', null, '北京测试股份有限公司', '10000');
INSERT INTO `abs_bottom_debtor` VALUES ('32', '82', null, '北京再测试股份有限公司', '20000');
INSERT INTO `abs_bottom_debtor` VALUES ('33', '82', null, '北京三测试股份有限公司', '30000');
INSERT INTO `abs_bottom_debtor` VALUES ('34', null, '73', '测试', '11');

-- ----------------------------
-- Table structure for abs_issue_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_issue_info`;
CREATE TABLE `abs_issue_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `actual_issue_amount` varchar(100) DEFAULT NULL,
  `approved_issue_amount` varchar(100) DEFAULT NULL,
  `listing_time` datetime DEFAULT NULL,
  `trustee` varchar(40) DEFAULT NULL,
  `trustee_contact_way` varchar(40) DEFAULT NULL,
  `regulatory_agency` varchar(40) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_issue_info
-- ----------------------------
INSERT INTO `abs_issue_info` VALUES ('72', '79', '', '', null, '', null, null, '1', '2019-08-20 14:38:39', '2019-08-26 14:52:21', '1', null);
INSERT INTO `abs_issue_info` VALUES ('73', '80', '', '', null, '', null, null, '3', '2019-08-20 15:57:11', '2019-08-20 15:57:11', '1', null);
INSERT INTO `abs_issue_info` VALUES ('75', '81', '1', '1', '2019-09-03 00:00:00', '11', null, null, '1', '2019-08-26 13:37:29', '2019-08-26 14:44:16', '1', null);
INSERT INTO `abs_issue_info` VALUES ('76', '82', '', '', null, '', null, null, '1', '2019-08-26 14:14:56', '2019-08-26 14:51:37', '1', null);
INSERT INTO `abs_issue_info` VALUES ('79', '84', '', '', null, '', null, null, '1', '2019-08-26 14:23:13', '2019-08-26 14:23:30', '1', null);
INSERT INTO `abs_issue_info` VALUES ('81', '85', '100', '100', '2019-08-16 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('82', '86', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('83', '87', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('84', '88', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('85', '89', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('86', '90', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('87', '91', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('88', '92', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('89', '93', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('90', '94', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('91', '95', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-28 16:06:58', '1', null);
INSERT INTO `abs_issue_info` VALUES ('92', '96', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('93', '97', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('94', '98', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-09-09 14:33:03', '1', null);
INSERT INTO `abs_issue_info` VALUES ('95', '99', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('96', '100', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('97', '101', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-09-09 14:33:11', '1', null);
INSERT INTO `abs_issue_info` VALUES ('98', '102', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('99', '103', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('100', '104', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('101', '105', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('102', '106', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('103', '107', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('104', '108', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('105', '109', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('106', '110', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('107', '111', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('108', '112', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('109', '113', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('110', '114', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('111', '115', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('112', '116', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('113', '117', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('114', '118', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('115', '119', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('116', '120', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('117', '121', '100', '100', '2019-08-26 00:00:00', '管理人名称', null, null, '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('120', '135', '', '', null, '', null, null, '1', '2019-08-28 11:02:34', '2019-08-28 13:40:01', '1', null);
INSERT INTO `abs_issue_info` VALUES ('122', '136', '', '', null, '', null, null, '1', '2019-08-28 14:56:51', '2019-08-28 18:23:25', '1', null);
INSERT INTO `abs_issue_info` VALUES ('124', '137', '', '', null, '', null, null, '3', '2019-08-28 14:59:32', '2019-08-28 14:59:32', '1', null);
INSERT INTO `abs_issue_info` VALUES ('127', '138', '', '', null, '', null, null, '5', '2019-08-28 18:17:58', '2019-08-28 18:18:34', '1', null);
INSERT INTO `abs_issue_info` VALUES ('128', '140', '', '', null, '', null, null, '2', '2019-08-28 18:18:20', '2019-08-28 18:20:07', '1', null);
INSERT INTO `abs_issue_info` VALUES ('130', '146', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('131', '147', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('132', '148', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('133', '149', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('134', '150', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('135', '151', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('136', '152', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-09-09 14:32:54', '1', null);
INSERT INTO `abs_issue_info` VALUES ('137', '153', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('138', '154', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('139', '155', '100', '100', '2019-02-26 00:00:00', '管理人名称', null, null, '1', '2019-02-26 14:58:35', '2019-02-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('140', null, null, null, null, null, null, null, '-10', null, null, null, null);
INSERT INTO `abs_issue_info` VALUES ('141', '162', '100', '100', '2019-05-16 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('142', '163', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('143', '164', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('144', '165', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('145', '166', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('146', '167', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('147', '168', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('148', '169', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('149', '170', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);
INSERT INTO `abs_issue_info` VALUES ('150', '171', '100', '100', '2019-05-26 00:00:00', '管理人名称', null, null, '1', '2019-05-26 14:58:35', '2019-05-26 14:58:35', '1', null);

-- ----------------------------
-- Table structure for abs_risk_breach_cause
-- ----------------------------
DROP TABLE IF EXISTS `abs_risk_breach_cause`;
CREATE TABLE `abs_risk_breach_cause` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `breach_cause` varchar(40) DEFAULT NULL COMMENT '违约原因',
  `breach_bature` varchar(40) DEFAULT NULL COMMENT '违约性质',
  `risk_progress_situation` varchar(40) DEFAULT NULL COMMENT '风险发生及处置进展情况',
  `breach_time` datetime DEFAULT NULL COMMENT '违约日期',
  `paid_amount` varchar(20) DEFAULT NULL COMMENT '已偿金额',
  `unpaid_amount` varchar(20) DEFAULT NULL COMMENT '未偿金额',
  `all_paid_time` datetime DEFAULT NULL COMMENT '全部清偿日期或风险化解日期',
  `supervision_situation` varchar(40) DEFAULT NULL COMMENT '监管情况（主要针对违法违规',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `operator` varchar(40) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_risk_breach_cause
-- ----------------------------
INSERT INTO `abs_risk_breach_cause` VALUES ('6', '18', '1', '测试1', '主动违约', '测试', '2019-07-29 00:00:00', '11', '22', '2019-08-07 00:00:00', '1', '2019-08-28 09:41:17', '2019-08-28 09:41:17', '系统管理员', '1');
INSERT INTO `abs_risk_breach_cause` VALUES ('7', '18', '1', '测试2', '被动违约', '测试', '2019-08-20 00:00:00', '22', '33', '2019-08-14 00:00:00', '2', '2019-08-28 09:41:30', '2019-08-28 09:41:30', '系统管理员', '2');
INSERT INTO `abs_risk_breach_cause` VALUES ('8', '18', '1', '测试3', '主动违约', '测试', '2019-08-06 00:00:00', '33', '44', '2019-08-20 00:00:00', '3', '2019-08-28 09:41:43', '2019-08-28 09:41:43', '系统管理员', '3');
INSERT INTO `abs_risk_breach_cause` VALUES ('9', '20', '1', '测试5', '主动违约', '测试5', '2019-08-06 00:00:00', '111', '1', '2019-08-13 00:00:00', '1', '2019-08-28 09:42:37', '2019-08-28 09:42:37', '系统管理员', '1');

-- ----------------------------
-- Table structure for abs_risk_breach_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_risk_breach_info`;
CREATE TABLE `abs_risk_breach_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `risk_state` varchar(40) DEFAULT NULL COMMENT '风险状态',
  `issue_way` varchar(40) DEFAULT NULL,
  `abs_balance` varchar(20) DEFAULT NULL,
  `resale_time` datetime DEFAULT NULL,
  `issue_amount` varchar(20) DEFAULT NULL,
  `trade_state` varchar(40) DEFAULT NULL COMMENT '交易状态',
  `pledge_buy_back` varchar(40) DEFAULT NULL COMMENT '是否属于质押式回购可质押债券',
  `conversion_rate` varchar(14) DEFAULT NULL COMMENT '当前折算率',
  `supervision_contact_otc` varchar(40) DEFAULT NULL,
  `supervision_contact_srb` varchar(40) DEFAULT NULL,
  `underwriter_contact_way` varchar(40) DEFAULT NULL,
  `guarantor` varchar(40) DEFAULT NULL,
  `guarantor_contact_way` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_risk_breach_info
-- ----------------------------
INSERT INTO `abs_risk_breach_info` VALUES ('16', '85', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-28 00:00:00', '2019-08-28 15:33:29', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('17', '86', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('18', '87', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('19', '88', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-27 00:00:00', '2019-08-27 18:22:27', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('20', '89', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('21', '90', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-28 00:00:00', '2019-08-28 19:11:19', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('22', '91', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('23', '92', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('24', '93', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('25', '94', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-28 00:00:00', '2019-08-28 19:11:32', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('26', '95', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('27', '96', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('28', '97', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('29', '98', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('30', '99', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('31', '100', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('32', '101', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('33', '102', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('34', '103', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('35', '104', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('36', '105', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('37', '106', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('38', '107', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('39', '108', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('40', '109', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('41', '110', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('42', '111', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('43', '112', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('44', '113', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('45', '114', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('46', '115', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('47', '116', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('48', '117', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('49', '118', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('50', '119', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('51', '120', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('52', '121', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('53', '122', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('54', '123', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('55', '124', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('56', '125', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('57', '126', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('58', '127', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('59', '128', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('60', '129', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('61', '130', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('62', '131', '1', '违约', '私募', '', '2019-08-26 00:00:00', '100', '未成交', '是', null, '监管联系人', '监管联系人', null, '监管联系人', '监管联系人', '2019-08-26 15:27:47', '2019-08-26 15:27:47', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('63', '136', '1', '', '', '', null, '', '', '', null, '', '', null, '', '', '2019-08-28 14:57:23', '2019-09-04 10:50:54', '2');
INSERT INTO `abs_risk_breach_info` VALUES ('64', '81', '1', '', '', '', null, '1', '', '', null, '', '', null, '', '', '2019-08-28 15:34:09', '2019-08-28 15:34:09', '1');
INSERT INTO `abs_risk_breach_info` VALUES ('65', '135', '1', '', '', '', null, '', '', '', null, '', '', null, '', '', '2019-08-30 00:00:00', '2019-09-04 10:50:54', '2');

-- ----------------------------
-- Table structure for abs_risklevel_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_risklevel_info`;
CREATE TABLE `abs_risklevel_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `abs_balance` bigint(20) DEFAULT NULL,
  `issue_way` varchar(40) DEFAULT NULL,
  `resale_time` datetime DEFAULT NULL,
  `risk_reasons` varchar(40) DEFAULT NULL,
  `pledge` varchar(40) DEFAULT NULL,
  `guarantor` varchar(40) DEFAULT NULL,
  `guarantor_contact_way` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_risklevel_info
-- ----------------------------

-- ----------------------------
-- Table structure for abs_sup_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_sup_info`;
CREATE TABLE `abs_sup_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `base_id` int(11) DEFAULT NULL COMMENT 'baseId',
  `publisher` varchar(255) DEFAULT NULL COMMENT '发布方',
  `supervision_file` varchar(255) DEFAULT NULL COMMENT '监管文件名称',
  `publish_time` datetime DEFAULT NULL COMMENT '发布日期',
  `state` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `intermediary_agency` varchar(255) DEFAULT NULL COMMENT '中介机构名称',
  `intermediary_agency_srb` varchar(1000) DEFAULT NULL COMMENT '中介机构所属证监局',
  `abs_short_name` varchar(255) DEFAULT NULL,
  `original_owner_name` varchar(255) DEFAULT NULL,
  `original_owner_srb` varchar(1000) DEFAULT NULL,
  `registered_place` varchar(255) DEFAULT NULL COMMENT '原始权益人所属证监局',
  `manager_name` varchar(255) DEFAULT NULL,
  `manager_srb` varchar(1000) DEFAULT NULL COMMENT '管理人所属证监局',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_sup_info
-- ----------------------------
INSERT INTO `abs_sup_info` VALUES ('173', '85', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('174', '86', '--请选择--', null, null, '1', null, '2019-08-28 15:05:52', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('175', '87', '--请选择--', null, null, '1', null, '2019-08-28 15:06:33', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('176', '88', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('177', '89', '--请选择--', null, null, '1', null, '2019-08-28 15:21:22', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '111', '111', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('178', '90', '--请选择--', null, null, '1', null, '2019-08-28 15:19:39', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持1', '原始权益1', null, '辽宁证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('179', '91', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('180', '92', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('181', '93', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('182', '94', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('183', '95', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('184', '96', '--请选择--', null, null, '1', null, '2019-08-28 15:22:39', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '3333', '3333', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('185', '97', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('186', '98', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('187', '99', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('188', '100', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('189', '101', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('190', '102', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('191', '103', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('192', '104', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('193', '105', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('194', '106', '--请选择--', null, null, '1', null, '2019-08-28 15:28:35', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '章鱼测试123', '测试章鱼123', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('195', '107', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('196', '108', '--请选择--', null, null, '1', null, '2019-08-28 15:24:54', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '乱箭123', '乱箭321', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('197', '109', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('198', '110', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('199', '111', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('200', '112', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('201', '113', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('202', '114', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('203', '115', '--请选择--', null, null, '1', null, '2019-08-26 15:33:20', '1', null, '中介机构名称', '北京证监局,天津证监局,山西证监局', '资产支持证券名称', '原始权益人名称', null, '北京证监局,天津证监局,河北证监局', '管理人名称', '北京证监局,天津证监局,河北证监局');
INSERT INTO `abs_sup_info` VALUES ('205', '136', '--请选择--', null, null, '1', null, '2019-08-28 14:58:52', '1', null, '', null, 'CODE110', '', null, null, '', null);
INSERT INTO `abs_sup_info` VALUES ('213', '135', '--请选择--', null, null, '1', null, '2019-08-28 18:26:06', '1', null, '', null, '222222', '', null, null, '', null);

-- ----------------------------
-- Table structure for abs_trail_audit_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_trail_audit_info`;
CREATE TABLE `abs_trail_audit_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `audit_opinion` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `abs_trail_id` int(11) DEFAULT NULL COMMENT 'abs在审项目信息id',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `user_id` int(11) DEFAULT NULL COMMENT '操作用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_type` varchar(255) DEFAULT NULL COMMENT '操作类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_trail_audit_info
-- ----------------------------
INSERT INTO `abs_trail_audit_info` VALUES ('145', '提交', '144', '2019-08-27 18:13:38', '1', '2019-08-27 18:13:38', '提交');
INSERT INTO `abs_trail_audit_info` VALUES ('146', '', '144', '2019-08-28 13:40:17', '143', '2019-08-28 13:40:17', '审核通过');
INSERT INTO `abs_trail_audit_info` VALUES ('147', '提交', '146', '2019-08-28 18:21:07', '1', '2019-08-28 18:21:07', '提交');
INSERT INTO `abs_trail_audit_info` VALUES ('148', '提交', '147', '2019-08-28 18:21:16', '1', '2019-08-28 18:21:16', '提交');
INSERT INTO `abs_trail_audit_info` VALUES ('149', '', '147', '2019-08-28 18:21:23', '1', '2019-08-28 18:21:23', '审核通过');
INSERT INTO `abs_trail_audit_info` VALUES ('150', '', '146', '2019-08-28 18:21:28', '1', '2019-08-28 18:21:28', '退回补正');

-- ----------------------------
-- Table structure for abs_trial_info
-- ----------------------------
DROP TABLE IF EXISTS `abs_trial_info`;
CREATE TABLE `abs_trial_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `abs_id` int(11) DEFAULT NULL,
  `basic_asset_other_type` varchar(255) DEFAULT NULL COMMENT '基础资产其他类型',
  `pre_audit_scale` varchar(255) DEFAULT NULL COMMENT '预审核规模（亿元）',
  `trial_state` varchar(255) DEFAULT NULL COMMENT '(在审)状态',
  `apply_material_receive_time` datetime DEFAULT NULL COMMENT '申请材料接收时间',
  `accept_or_not_time` datetime DEFAULT NULL COMMENT '受理决定或不予受理决定时间',
  `first_feedback_time` datetime DEFAULT NULL COMMENT '第一次反馈意见时间',
  `receive_first_feedback_time` datetime DEFAULT NULL COMMENT '接收第一次反馈材料时间',
  `second_feedback_time` datetime DEFAULT NULL COMMENT '第二次反馈意见时间',
  `receive_second_feedback_time` datetime DEFAULT NULL COMMENT '接收第二次反馈材料时间',
  `no_action_letter_time` datetime DEFAULT NULL COMMENT '出具预审核意见/出具无异议函时间',
  `no_action_letter` varchar(255) DEFAULT NULL,
  `original_owner_name` varchar(600) DEFAULT NULL COMMENT '原始权益人名称',
  `registered_place` varchar(255) DEFAULT NULL COMMENT '原始权益人注册地',
  `industry` varchar(600) DEFAULT NULL COMMENT '所属行业',
  `business_scope` varchar(600) DEFAULT NULL COMMENT '公司经营范围',
  `nature` varchar(255) DEFAULT NULL COMMENT '企业性质',
  `if_belongs_financial` varchar(255) DEFAULT NULL COMMENT '是否属于金融行业',
  `main_rating` varchar(255) DEFAULT NULL COMMENT '主体评级',
  `manager_name` varchar(255) DEFAULT NULL COMMENT '管理人',
  `manager_disclosure_specialist` varchar(255) DEFAULT NULL COMMENT '管理人信息披露专员',
  `specialist_contact_way` varchar(255) DEFAULT NULL COMMENT '专员联系方式',
  `manager_charger` varchar(255) DEFAULT NULL COMMENT '管理人项目负责人（签字人）',
  `manager_contact_way` varchar(255) DEFAULT NULL COMMENT '管理人联系手机',
  `manager_registered_place` varchar(255) DEFAULT NULL COMMENT '管理人注册地',
  `accounting_name` varchar(255) DEFAULT NULL COMMENT '会计师事务所名称',
  `accounting_signature` varchar(255) DEFAULT NULL COMMENT '签字会计师',
  `law_name` varchar(255) DEFAULT NULL COMMENT '律师事务所名称',
  `law_signature` varchar(255) DEFAULT NULL COMMENT '签字律师',
  `rating_agency_name` varchar(255) DEFAULT NULL COMMENT '资信评级机构名称',
  `other_rating_agency_name` varchar(255) DEFAULT NULL COMMENT '其他资信评估机构名称',
  `rating_agency_charge` varchar(255) DEFAULT NULL COMMENT '资信评级机构项目负责人',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `check_state` varchar(255) DEFAULT NULL COMMENT '审核状态1通过，2不通过',
  `property_assess_org` varchar(255) DEFAULT NULL,
  `property_assess_person` varchar(255) DEFAULT NULL,
  `guarantor` varchar(255) DEFAULT NULL,
  `guarantor_contact_info` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abs_trial_info
-- ----------------------------
INSERT INTO `abs_trial_info` VALUES ('1', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('71', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('72', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('73', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '乱箭123', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-27 17:23:18', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('74', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('75', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('76', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('77', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('78', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('79', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('80', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('81', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('82', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('83', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('84', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('85', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('86', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('87', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('88', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('89', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('90', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '乱箭123', '北京证监局', '建筑业,教育,卫生和社会工作,文化、体育和娱乐业,综合', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-09-09 14:33:56', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('91', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('92', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('93', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('94', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('95', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('96', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('97', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('98', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('99', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('100', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('101', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('102', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('103', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('104', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('105', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('106', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('107', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('108', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('109', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('110', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('111', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('112', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('113', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('114', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('115', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('116', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('117', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('118', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('119', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('120', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('121', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('122', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('123', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('124', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('125', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('126', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('127', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('128', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('129', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('130', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('131', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('132', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('133', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('134', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('135', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('136', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('137', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('138', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('139', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('140', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('141', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('142', '133', null, '100.000', null, '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '无异议函编号', '无异议函编号', '北京证监局', '农、林、牧、渔业', '无异议函编号', '中央国企', '是', 'AAA', '无异议函编号', null, null, '无异议函编号', '13433332222', null, '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', '无异议函编号', null, '无异议函编号', '1', null, '2019-08-26 15:24:31', '1', '无异议函编号', '8', null, null, '无异议函编号', '无异议函编号', '100');
INSERT INTO `abs_trial_info` VALUES ('143', '134', null, '1.000', null, null, null, null, null, null, null, null, '1', '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', '', '', null, '', '3', '2019-08-27 18:13:31', '2019-08-27 18:13:31', '1', '1', '4', null, null, '', '', '1');
INSERT INTO `abs_trial_info` VALUES ('144', '107', null, '1.000', null, null, null, null, null, null, null, null, '1', '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', '', '', null, '', '1', '2019-08-27 18:13:38', '2019-08-27 18:13:38', '1', '1', '', null, null, '', '', null);
INSERT INTO `abs_trial_info` VALUES ('145', '143', null, '', null, null, null, null, null, null, null, null, '', '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', '', '', null, '', '3', '2019-08-28 18:21:03', '2019-08-28 18:21:03', '1', '', '4', null, null, '', '', 'KKKKKKKKKKKKK1');
INSERT INTO `abs_trial_info` VALUES ('146', '144', null, '', null, null, null, null, null, null, null, null, '', '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', '', '', null, '', '5', '2019-08-28 18:21:07', '2019-08-28 18:21:07', '1', '', '', null, null, '', '', null);
INSERT INTO `abs_trial_info` VALUES ('147', '145', null, '', null, null, null, null, null, null, null, null, '', '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', '', '', null, '', '2', '2019-08-28 18:21:16', '2019-08-28 18:22:13', '1', '', '', null, null, '', '', null);

-- ----------------------------
-- Table structure for audit_abs_issue_info
-- ----------------------------
DROP TABLE IF EXISTS `audit_abs_issue_info`;
CREATE TABLE `audit_abs_issue_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ABS_id` int(11) DEFAULT NULL,
  `operation_user` varchar(40) DEFAULT NULL,
  `audit_opinion` varchar(40) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `operation_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audit_abs_issue_info
-- ----------------------------
INSERT INTO `audit_abs_issue_info` VALUES ('1', '72', 'admin', null, '2019-08-20 14:38:39', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('2', '72', 'admin', '111', '2019-08-20 14:38:58', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('3', '75', 'admin', null, '2019-08-26 13:37:29', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('4', '75', 'admin', null, '2019-08-26 13:37:41', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('5', '76', 'admin', null, '2019-08-26 14:14:56', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('6', '79', 'admin', null, '2019-08-26 14:23:13', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('7', '79', 'admin', null, '2019-08-26 14:23:30', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('8', '76', 'admin', null, '2019-08-26 14:23:36', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('9', '81', 'admin', null, '2019-08-26 14:58:35', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('10', '120', 'admin', null, '2019-08-28 11:02:34', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('11', '120', 'shenhe', null, '2019-08-28 13:40:01', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('12', '122', 'admin', null, '2019-08-28 14:56:51', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('13', '122', 'admin', '1', '2019-08-28 14:56:57', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('14', '127', 'admin', null, '2019-08-28 18:17:58', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('15', '128', 'admin', null, '2019-08-28 18:18:21', '提交');
INSERT INTO `audit_abs_issue_info` VALUES ('16', '128', 'admin', null, '2019-08-28 18:18:28', '审核通过');
INSERT INTO `audit_abs_issue_info` VALUES ('17', '127', 'admin', null, '2019-08-28 18:18:34', '退回补正');

-- ----------------------------
-- Table structure for bond_audit_base_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_audit_base_info`;
CREATE TABLE `bond_audit_base_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bond_id` int(11) DEFAULT NULL,
  `operation_user` varchar(40) DEFAULT NULL,
  `audit_opinion` varchar(40) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `operation_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_audit_base_info
-- ----------------------------
INSERT INTO `bond_audit_base_info` VALUES ('61', '694', 'admin', null, '2019-08-20 14:09:41', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('62', '695', 'admin', null, '2019-08-20 14:10:50', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('63', '696', 'admin', null, '2019-08-20 14:13:14', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('64', '694', 'admin', null, '2019-08-20 14:39:44', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('65', '697', 'admin', null, '2019-08-20 14:41:20', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('66', '697', 'admin', null, '2019-08-20 14:41:31', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('67', '698', 'admin', null, '2019-08-20 14:42:00', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('68', '698', 'admin', null, '2019-08-20 14:42:11', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('69', '699', 'admin', null, '2019-08-20 15:29:59', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('70', '699', 'admin', '1', '2019-08-20 15:30:31', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('71', '696', 'admin', null, '2019-08-20 15:46:53', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('72', '695', 'admin', null, '2019-08-20 15:46:59', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('73', '700', 'admin', null, '2019-08-20 15:49:02', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('74', '700', 'admin', '11', '2019-08-20 15:49:12', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('75', '701', 'admin', null, '2019-08-20 15:52:08', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('76', '701', 'admin', null, '2019-08-20 15:52:19', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('77', '703', 'admin', null, '2019-08-20 16:37:06', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('78', '703', 'admin', null, '2019-08-20 16:37:17', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('79', '704', 'admin', null, '2019-08-20 16:41:08', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('80', '705', 'admin', null, '2019-08-20 16:41:37', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('81', '714', 'admin', null, '2019-08-21 16:41:17', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('82', '714', 'admin', null, '2019-08-26 13:37:47', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('83', '717', 'admin', null, '2019-08-26 13:44:04', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('84', '718', 'admin', null, '2019-08-26 13:44:33', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('85', '721', 'admin', null, '2019-08-26 13:48:56', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('86', '808', 'admin', null, '2019-08-28 10:52:07', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('87', '809', 'admin', null, '2019-08-28 10:52:29', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('88', '810', 'admin', null, '2019-08-28 10:53:14', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('89', '812', 'admin', null, '2019-08-28 11:02:12', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('90', '812', 'shenhe', null, '2019-08-28 13:40:04', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('91', '810', 'shenhe', null, '2019-08-28 13:40:07', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('92', '809', 'shenhe', null, '2019-08-28 13:40:11', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('93', '808', 'shenhe', null, '2019-08-28 13:40:14', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('94', '705', 'shenhe', null, '2019-08-28 13:40:26', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('95', '704', 'shenhe', null, '2019-08-28 13:40:32', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('96', '718', 'shenhe', null, '2019-08-28 13:41:00', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('97', '717', 'shenhe', null, '2019-08-28 13:41:09', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('98', '818', 'ceshi', null, '2019-08-28 13:47:10', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('99', '818', 'shenhe', null, '2019-08-28 13:48:09', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('100', '822', 'ceshi', null, '2019-08-28 13:54:00', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('101', '822', 'shenhe', '1', '2019-08-28 13:54:14', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('102', '823', 'admin', null, '2019-08-28 15:12:06', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('103', '823', 'admin', null, '2019-08-28 15:12:12', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('104', '824', 'admin', null, '2019-08-28 15:50:21', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('105', '824', 'admin', null, '2019-08-28 15:50:41', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('106', '825', 'admin', null, '2019-08-28 16:09:04', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('107', '826', 'admin', null, '2019-08-28 16:41:45', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('108', '826', 'admin', null, '2019-08-28 16:42:16', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('109', '827', 'admin', null, '2019-08-28 17:01:22', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('110', '827', 'admin', null, '2019-08-28 17:01:34', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('111', '825', 'admin', null, '2019-08-28 17:03:00', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('112', '825', 'admin', null, '2019-08-28 17:03:10', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('113', '828', 'admin', null, '2019-08-28 17:06:41', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('114', '828', 'admin', null, '2019-08-28 17:07:08', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('115', '829', 'admin', null, '2019-08-28 17:14:27', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('116', '829', 'admin', null, '2019-08-28 17:14:36', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('117', '830', 'admin', null, '2019-08-28 17:20:51', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('118', '830', 'admin', null, '2019-08-28 17:21:05', '审核通过');
INSERT INTO `bond_audit_base_info` VALUES ('119', '831', 'admin', null, '2019-08-28 18:03:04', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('120', '831', 'admin', null, '2019-08-28 18:03:13', '退回补正');
INSERT INTO `bond_audit_base_info` VALUES ('121', '835', 'admin', null, '2019-08-28 18:09:07', '提交');
INSERT INTO `bond_audit_base_info` VALUES ('122', '835', 'admin', null, '2019-08-28 18:09:20', '审核通过');

-- ----------------------------
-- Table structure for bond_base_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_base_info`;
CREATE TABLE `bond_base_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `bond_code` varchar(255) DEFAULT NULL,
  `bond_name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  `bond_type` varchar(255) DEFAULT NULL,
  `trading_location` varchar(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `initial_rating` varchar(255) DEFAULT NULL,
  `current_rating` varchar(255) DEFAULT NULL,
  `stock_code` varchar(255) DEFAULT NULL,
  `credit_measures` varchar(600) DEFAULT NULL,
  `issue_way` varchar(255) DEFAULT NULL,
  `be_issue_amount` varchar(255) DEFAULT NULL,
  `real_issue_amount` varchar(255) DEFAULT NULL,
  `trusteeship` varchar(255) DEFAULT NULL,
  `trem` varchar(255) DEFAULT NULL,
  `trem_remark` varchar(255) DEFAULT NULL,
  `issue_rate` varchar(255) DEFAULT NULL,
  `issue_time` datetime DEFAULT NULL,
  `list_time` datetime DEFAULT NULL,
  `approval_time` datetime DEFAULT NULL,
  `interest_time` datetime DEFAULT NULL,
  `due_time` datetime DEFAULT NULL,
  `resale_time` datetime DEFAULT NULL,
  `relate_srb` varchar(255) DEFAULT NULL,
  `debt_account` int(11) DEFAULT NULL,
  `individual_investor_account` int(11) DEFAULT NULL,
  `personal_debt_rate` varchar(14) DEFAULT NULL,
  `current_rate` varchar(14) DEFAULT NULL,
  `proper_management` varchar(255) DEFAULT NULL,
  `proper_management_time` datetime DEFAULT NULL,
  `issuer_name` varchar(255) DEFAULT NULL,
  `other_issuer_name` varchar(600) DEFAULT NULL COMMENT '其他发行人',
  `issuer_industry` varchar(255) DEFAULT NULL,
  `issuer_province` varchar(255) DEFAULT NULL,
  `issuer_city` varchar(255) DEFAULT NULL,
  `issuer_srb` varchar(255) DEFAULT NULL,
  `issuer_business` varchar(600) DEFAULT NULL,
  `issuer_nature` varchar(255) DEFAULT NULL,
  `issuer_financial` varchar(255) DEFAULT NULL,
  `issuer_rating` varchar(255) DEFAULT NULL,
  `com_initial_rating` varchar(255) DEFAULT NULL,
  `com_current_rating` varchar(255) DEFAULT NULL,
  `issuer_contact_way` varchar(255) DEFAULT NULL,
  `underwriter_name` varchar(255) DEFAULT NULL,
  `underwriter_charge` varchar(255) DEFAULT NULL,
  `underwriter_srb` varchar(255) DEFAULT NULL,
  `accounting_name` varchar(255) DEFAULT NULL,
  `accounting_signatory` varchar(255) DEFAULT NULL,
  `law_name` varchar(255) DEFAULT NULL,
  `law_signatory` varchar(255) DEFAULT NULL,
  `rating_agency_name` varchar(255) DEFAULT NULL,
  `other_rating_agency_name` varchar(600) DEFAULT NULL COMMENT '其他资信评级机构名称',
  `rating_agency_charge` varchar(255) DEFAULT NULL,
  `rating_agency_srb` varchar(255) DEFAULT NULL,
  `trustee_name` varchar(255) DEFAULT NULL,
  `trustee_charge` varchar(255) DEFAULT NULL,
  `trustee_charge_contact_way` varchar(255) DEFAULT NULL,
  `trustee_srb` varchar(255) DEFAULT NULL,
  `issuer_id` int(11) DEFAULT NULL,
  `underwriter_id` int(11) DEFAULT NULL,
  `law_firm_id` int(11) DEFAULT NULL,
  `accounting_firm_id` int(11) DEFAULT NULL,
  `guarantor_id` int(11) DEFAULT NULL,
  `credit_rating_agency_id` int(11) DEFAULT NULL,
  `trustee_id` int(11) DEFAULT NULL,
  `intermediary_agency_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `jur_srb` varchar(255) DEFAULT NULL,
  `audit_state` int(1) DEFAULT NULL,
  `edit_state` int(11) DEFAULT NULL,
  `serial_number` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `bondbaseinfo_bondcode` (`bond_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=849 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_base_info
-- ----------------------------
INSERT INTO `bond_base_info` VALUES ('694', 'S10086', '', 'zyc', '', '', 'AAA', 'AAA', '', '888', '', '私募', '', '', '11', '', '', '', null, null, null, null, null, null, null, null, null, '', '', '', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-20 14:09:41', '2019-08-22 17:18:54', '', '1', null, null, '1', '11111111111111111111');
INSERT INTO `bond_base_info` VALUES ('695', 'S123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2019-08-20 14:10:50', '2019-08-20 17:08:32', null, '1', null, null, '1', '111');
INSERT INTO `bond_base_info` VALUES ('696', '111111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2019-08-20 14:13:14', '2019-08-20 17:08:49', null, '1', null, null, '1', '11111');
INSERT INTO `bond_base_info` VALUES ('697', '1', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2019-08-20 14:41:20', '2019-08-20 17:08:49', null, '1', null, null, '1', '1');
INSERT INTO `bond_base_info` VALUES ('698', '2', null, 'zyc1', null, '报价系统', null, 'AAA', 'AAA', '11', '11', null, null, '11', null, null, null, '11', '2019-08-02 00:00:00', null, null, '2019-08-15 00:00:00', '2019-08-14 00:00:00', '2019-08-14 00:00:00', null, null, null, '111', '', '否', '2019-08-21 00:00:00', '1', null, null, '北京', null, '北京证监局', '11', '中央国企', null, null, 'AAA', 'AAA', '11', '11', null, null, null, null, null, null, '11', null, null, '云南证监局', '11', null, '11', '河北证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', null, '1', null, null, '1', '1');
INSERT INTO `bond_base_info` VALUES ('699', '3', '', '33', null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '133', '', '', '', '', '天津证监局,河北证监局', '', '', '', '', null, null, '', '111', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:42:41', '2019-08-26 13:42:41', '', '1', null, null, '1', '1');
INSERT INTO `bond_base_info` VALUES ('700', '10086', '1111', 'zyc', null, '报价系统', 'AAA', 'AAA', '', '1111', '11', '私募', '11', '11', '11', '11', '11', '11', '2019-08-13 00:00:00', '2019-08-13 00:00:00', '2019-08-20 00:00:00', '2019-08-20 00:00:00', '2019-08-22 00:00:00', null, null, null, null, '', '', '', null, '11', '11', '农、林、牧、渔业', '', '朝阳区', '北京证监局', '11', '中央国企', '是', 'AAA', '', '', '111', '11', '11', '北京证监局', '11', '11', '11', '11', '11', '11', '11', '北京证监局', '11', '11', '11', '北京证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:43:31', '2019-08-26 13:43:31', '11', '1', null, null, '1', '1111');
INSERT INTO `bond_base_info` VALUES ('701', 'qq', '', 'qq', '普通公司债', '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-20 15:52:08', '2019-08-20 15:56:22', '', '1', null, null, '1', 'qq');
INSERT INTO `bond_base_info` VALUES ('702', '32323232', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-20 15:57:40', '2019-08-20 15:57:40', null, '1', null, null, '1', '323232');
INSERT INTO `bond_base_info` VALUES ('703', 'ceshi', '', 'fsd', '用于并购重组用途的债券', '', '', null, null, 'fa', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-20 16:37:06', '2019-08-20 17:08:12', '', '1', null, null, '1', '134');
INSERT INTO `bond_base_info` VALUES ('704', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-20 16:41:08', '2019-08-28 13:40:32', null, '1', null, null, '1', '111');
INSERT INTO `bond_base_info` VALUES ('705', '111111111', '', '2121212121', null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-20 16:41:37', '2019-08-28 13:45:54', '', '142', null, null, '1', '111');
INSERT INTO `bond_base_info` VALUES ('706', null, null, 'zyc', null, null, 'AAA', null, null, '11', null, ' ', null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '11', null, '农、林、牧、渔业', null, null, null, '11', '地方国企', '是', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-20 19:11:32', '2019-08-20 19:11:32', '1', null, '系统管理员', null, null, '1');
INSERT INTO `bond_base_info` VALUES ('707', null, null, 'zyc', null, null, 'AAA', null, null, '11', '11', '私募', '11', null, null, '11', null, null, null, null, '2019-08-08 00:00:00', null, null, null, null, null, null, null, null, null, null, '11', null, '农、林、牧、渔业', '北京', '朝阳区', '北京证监局', '11', '中央国企', '是', 'AAA', null, null, '11', '11', '11', null, '11', '11', '11', '11', '11', null, '11', null, '11', null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-20 19:17:46', '2019-08-20 19:17:46', '11', null, '系统管理员', null, null, '2');
INSERT INTO `bond_base_info` VALUES ('708', null, null, 'zyc', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'AAA', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-20 19:18:35', '2019-08-20 19:18:35', null, null, '系统管理员', null, null, '3');
INSERT INTO `bond_base_info` VALUES ('709', null, null, '1', null, null, null, null, null, '11', null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-20 19:19:56', '2019-08-20 19:19:56', null, null, '系统管理员', null, null, '4');
INSERT INTO `bond_base_info` VALUES ('710', '21212121', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-21 16:33:36', '2019-08-21 16:33:36', null, '1', null, null, '1', '2233333');
INSERT INTO `bond_base_info` VALUES ('711', '21212121', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-21 16:33:44', '2019-08-21 16:33:44', null, '1', null, null, '1', '2233333');
INSERT INTO `bond_base_info` VALUES ('712', '44444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-21 16:40:41', '2019-08-21 16:40:41', null, '1', null, null, '1', '545454');
INSERT INTO `bond_base_info` VALUES ('713', '5556565', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-21 16:40:47', '2019-08-21 16:40:47', null, '1', null, null, '1', '545454');
INSERT INTO `bond_base_info` VALUES ('714', '5556565', '', '2019年8月28日', null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-21 16:41:17', '2019-08-28 13:41:53', '', '1', null, null, '1', '545454');
INSERT INTO `bond_base_info` VALUES ('715', 'v2233333', '2233333', '2233333', ',普通公司债', '报价系统', 'AA+', null, null, '2233333', '22333332233333', '私募', '2233333', '2233333', '2233333', '2233333', '2233333', '2233333', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', null, null, null, null, null, null, null, null, '2233333', null, null, null, null, null, null, null, null, null, null, null, null, '2233333', null, null, '2233333', null, '2233333', null, '2233333', null, null, null, '2233333', null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-21 16:46:54', '2019-08-21 16:46:54', '2233333', '1', null, null, '1', '2233333');
INSERT INTO `bond_base_info` VALUES ('716', 'v224443', '224433', '2233333', ',普通公司债', '报价系统', 'AA+', null, null, '2233333', '22333332233333', '私募', '2233333', '2233333', '2233333', '2233333', '2233333', '2233333', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', null, null, null, null, null, null, null, null, '2233333', null, null, null, null, null, null, null, null, null, null, null, null, '2233333', null, null, '2233333', null, '2233333', null, '2233333', null, null, null, '2233333', null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-21 16:46:54', '2019-08-21 16:46:54', '2233333', '1', null, null, '1', '2233333');
INSERT INTO `bond_base_info` VALUES ('717', 'code', '债券全称', '债券简称', null, '报价系统', 'AAA', null, null, 'SN234455', null, '私募', '300', '300', '200', '2', null, '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:44:04', '2019-08-28 13:41:09', null, '1', null, null, '1', '12345678');
INSERT INTO `bond_base_info` VALUES ('718', '1234567890', '', '2019年8月28日 13:41:35', null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:44:33', '2019-08-28 13:41:39', '', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('719', '1234567890', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-26 13:48:15', '2019-08-26 13:48:15', null, '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('720', '1234567890', '1234567890', '1234567890', '普通公司债', null, 'AAA', null, null, null, '1234567890', '私募', null, null, null, null, null, null, null, null, '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, '1234567890', null, null, null, null, null, null, null, null, null, null, null, null, '1234567890', null, null, '1234567890', null, '1234567890', null, '1234567890', null, null, null, '1234567890', null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-26 13:48:42', '2019-08-26 13:48:42', null, '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('721', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('722', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('723', '12345678902', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('724', '12345678903', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('725', '12345678904', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('726', '12345678905', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('727', '12345678906', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('728', '12345678907', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('729', '12345678908', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('730', '12345678909', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('731', '12345678910', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('732', '12345678911', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('733', '12345678912', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('734', '12345678913', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('735', '12345678914', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('736', '12345678915', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('737', '12345678916', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('738', '12345678917', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '1年', '期限备注', '0.45', '2018-01-01 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('739', '12345678918', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('740', '12345678919', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('741', '12345678920', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('742', '12345678921', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('743', '12345678922', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('744', '12345678923', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('745', '12345678924', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2012-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('746', '12345678925', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2012-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('747', '12345678926', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2012-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('748', '12345678927', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2012-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('749', '12345678928', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2012-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('750', '12345678929', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2010-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('751', '12345678930', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '2年', '期限备注', '0.45', '2010-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('752', '12345678931', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('753', '12345678932', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('754', '12345678933', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('755', '12345678934', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2014-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('756', '12345678935', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('757', '12345678936', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('758', '12345678937', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('759', '12345678938', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('760', '12345678939', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('761', '12345678940', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('762', '12345678941', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('763', '12345678942', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('764', '12345678943', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('765', '12345678944', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '3年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('766', '12345678945', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('767', '12345678946', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('768', '12345678947', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', 'AAA', 'AAA', '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', '2019-08-26 00:00:00', '北京证监局', '2', '2', '200', '0.45', '是', '2019-08-26 00:00:00', '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', 'B-', 'CC', '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '河北证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '山西证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 15:45:14', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('769', '12345678948', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('770', '12345678949', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('771', '12345678950', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('772', '12345678951', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('773', '12345678952', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('774', '12345678953', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('775', '12345678954', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('776', '12345678955', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('777', '12345678956', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('778', '12345678957', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('779', '12345678958', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', '', '', '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, '', '', '', null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', 'AAA', 'AAA', '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 15:43:35', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('780', '12345678959', '1234567890', 'AAAAAAAAAAA', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-29 09:03:02', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('781', '12345678960', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '4年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('782', '12345678961', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('783', '12345678962', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('784', '12345678963', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('785', '12345678964', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('786', '12345678965', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('787', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('788', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('789', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2010-02-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('790', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('791', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('792', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('793', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('794', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-27 00:00:00', '2019-08-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:48:56', '2019-08-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('795', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('796', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('797', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('798', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '5年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('799', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('800', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('801', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('802', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('803', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('804', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('805', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '6年', '期限备注', '0.45', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-26 00:00:00', '2019-05-27 00:00:00', '2019-05-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-05-26 13:48:56', '2019-05-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('806', null, null, '债券简称', null, null, 'AAA', null, null, '股票代码', '增信措施增信措施增信措施', '私募', '200', null, null, '6年', null, null, null, null, '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, '发行人名称', null, '农、林、牧、渔业', '北京', '朝阳区', '北京证监局', '	主营业务', '中央国企', '是', 'AAA', null, null, '发行人联系方式', '主承销商名称', '主承销商项目负责人', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-26 13:57:29', '2019-08-26 13:57:29', '备注', null, '系统管理员', '2', null, '1234567890');
INSERT INTO `bond_base_info` VALUES ('807', null, null, '债券简称111', null, null, 'AAA', null, null, '股票代码', '增信措施增信措施增信措施', '私募', '200', null, null, '6年', null, null, null, null, '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, '发行人名称', null, '批发和零售业', '辽宁', '锦州市', '河北证监局', '	主营业务', '中央国企', '是', 'AAA', null, null, '发行人联系方式', '主承销商名称', '主承销商项目负责人', null, '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', null, '律师事务所名称', null, '律师事务所名称', null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:57:39', '2019-09-09 14:51:04', '备注', null, '系统管理员', null, null, '12345678901');
INSERT INTO `bond_base_info` VALUES ('808', '123456789012', null, '债券简称', null, null, 'AAA', null, null, '股票代码', '增信措施增信措施增信措施', '私募', '200', null, null, '6年', null, null, null, null, '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, '发行人名称', null, '农、林、牧、渔业', '北京', '朝阳区', '北京证监局', '	主营业务', '中央国企', '是', 'AAA', null, null, '发行人联系方式', '主承销商名称', '主承销商项目负责人', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 10:52:07', '2019-08-28 13:40:14', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('809', 'AAAA', null, '债券简称', null, null, 'AAA', null, null, '股票代码', '增信措施增信措施增信措施', '私募', '200', null, null, '6年', null, null, null, null, '2019-08-26 00:00:00', null, null, null, null, null, null, null, null, null, null, '发行人名称', null, '农、林、牧、渔业', '北京', '朝阳区', '北京证监局', '	主营业务', '中央国企', '是', 'AAA', null, null, '发行人联系方式', '主承销商名称', '主承销商项目负责人', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 10:52:29', '2019-08-28 13:40:11', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('810', '123456789011', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2019-08-28 10:53:14', '2019-08-28 17:48:55', null, '1', null, null, '1', '123456789011');
INSERT INTO `bond_base_info` VALUES ('811', '22222', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-28 11:01:54', '2019-08-28 11:01:54', null, '1', null, null, '1', '111111');
INSERT INTO `bond_base_info` VALUES ('812', '22222', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', '2019-08-28 11:02:12', '2019-08-28 17:49:06', null, '1', null, null, '1', '111111');
INSERT INTO `bond_base_info` VALUES ('813', null, null, '32323232', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 11:03:03', '2019-08-28 11:03:03', null, null, '系统管理员', null, null, '232323233333');
INSERT INTO `bond_base_info` VALUES ('814', null, null, '2222', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 11:06:08', '2019-08-28 11:06:08', null, null, '系统管理员', null, null, '2121');
INSERT INTO `bond_base_info` VALUES ('815', null, null, '新增加的2019年8月28日', null, null, '', null, null, '', '', ' ', '', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, '', '', '', '', '', '', '', '', null, null, '', '', '', null, '', '', '', '', '', null, '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 13:42:08', '2019-08-28 13:42:33', '', null, '系统管理员', null, null, '123334445555');
INSERT INTO `bond_base_info` VALUES ('816', null, null, '1111111', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-28 13:42:59', '2019-08-28 13:42:59', null, null, '系统管理员', '2', null, '1111');
INSERT INTO `bond_base_info` VALUES ('817', '2121212121', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-28 13:44:31', '2019-08-28 13:44:31', null, '142', null, null, '1', '22232323232');
INSERT INTO `bond_base_info` VALUES ('818', 'CODE123', '', 'CODE123', null, '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-28 13:47:10', '2019-08-28 13:50:52', '', '142', null, null, '1', 'CODE123');
INSERT INTO `bond_base_info` VALUES ('819', null, null, 'CODE123', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-28 13:47:16', '2019-08-28 13:47:16', null, null, '121', '2', null, 'CODE123');
INSERT INTO `bond_base_info` VALUES ('820', null, null, 'CODE123', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 13:47:31', '2019-08-28 13:47:31', null, null, '121', null, null, 'CODE1231');
INSERT INTO `bond_base_info` VALUES ('821', null, null, 'CODE123123', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 13:51:51', '2019-08-28 13:51:51', null, null, '121', null, null, 'CODE123123');
INSERT INTO `bond_base_info` VALUES ('822', 'CODE123123', null, 'CODE123123', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 13:55:20', '2019-08-28 13:55:20', null, '142', null, null, '1', 'CODE123123');
INSERT INTO `bond_base_info` VALUES ('823', 'CODE223344', '', 'CODE223344', '普通公司债', '', '', null, null, '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-28 15:12:06', '2019-08-28 15:12:25', '', '1', null, null, '1', 'CODE223344');
INSERT INTO `bond_base_info` VALUES ('824', 'CODE223344556', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 15:50:20', '2019-08-28 15:50:41', null, '1', null, null, '1', 'CODE223344556');
INSERT INTO `bond_base_info` VALUES ('825', 'CODE112233', null, 'CODE112233', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 16:09:02', '2019-08-28 17:03:10', null, '1', null, null, '1', 'CODE112233');
INSERT INTO `bond_base_info` VALUES ('826', 'LSH11', null, 'LSH11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 16:40:27', '2019-08-28 16:42:16', null, '1', null, null, '1', 'LSH11');
INSERT INTO `bond_base_info` VALUES ('827', 'LS88888888', null, 'LS88888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 17:01:22', '2019-08-28 17:01:34', null, '1', null, null, '1', 'LS88888888');
INSERT INTO `bond_base_info` VALUES ('828', 'DDDDDDD', null, 'DDDDDDD', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 17:06:41', '2019-08-28 17:07:08', null, '1', null, null, '1', 'DDDDDDD');
INSERT INTO `bond_base_info` VALUES ('829', 'DDDDFFFFF', null, null, ',普通公司债', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 17:14:27', '2019-08-28 17:14:36', null, '1', null, null, '1', 'DDDDFFFFF');
INSERT INTO `bond_base_info` VALUES ('830', '22222222', null, null, ',普通公司债,证券公司次级债', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 17:20:51', '2019-08-28 17:21:05', null, '1', null, null, '1', '22222222');
INSERT INTO `bond_base_info` VALUES ('831', 'FFFFF', null, 'FFFFF', ',普通公司债', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '5', '2019-08-28 18:03:04', '2019-08-28 18:03:13', null, '1', null, null, '1', 'FFFFF');
INSERT INTO `bond_base_info` VALUES ('832', null, null, '1', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', '2019-08-28 18:06:46', '2019-08-28 18:06:46', null, null, '系统管理员', '2', null, '1');
INSERT INTO `bond_base_info` VALUES ('833', null, null, '22222222222222222', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 18:06:54', '2019-08-28 18:06:54', null, null, '系统管理员', null, null, '22222222222222222');
INSERT INTO `bond_base_info` VALUES ('834', null, null, '33333333333333333333', null, null, null, null, null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2019-08-28 18:07:06', '2019-08-28 18:07:06', null, null, '系统管理员', null, null, '3333333333333333333');
INSERT INTO `bond_base_info` VALUES ('835', 'AAAAAAAAAAAAAAAA', null, '', '', '', null, '', '', '', '', null, null, '', null, null, null, '', null, null, null, null, null, null, null, null, null, '', '', '', null, '', null, null, '', null, '', '', '', null, null, '', '', '', '', null, null, null, null, null, null, '', null, null, '', '', null, '', '', null, null, null, null, null, null, null, null, null, '1', '2019-08-28 18:15:10', '2019-08-28 18:15:10', null, '1', null, null, '1', 'AAAAAAAAAAAAAAAA');
INSERT INTO `bond_base_info` VALUES ('836', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '文化、体育和娱乐业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:57:39', '2019-09-09 14:51:56', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('837', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-02-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('838', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '综合', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:57:39', '2019-09-09 14:51:46', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('839', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '水利、环境和公共设施管理业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:57:39', '2019-09-09 14:51:36', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('840', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '建筑业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-09-09 14:50:42', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('841', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-02-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('842', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '电力、热力、燃气及水生产和供应业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-09-09 14:50:28', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('843', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '采矿业', '河北', '保定市', '山西证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:57:39', '2019-09-09 14:48:44', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('844', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '制造业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-09-09 14:50:11', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('845', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-02-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('846', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '农、林、牧、渔业', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-02-26 13:51:27', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('847', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '400', '200', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-08-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '教育', '北京', '宣武区', '北京证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-08-26 13:57:39', '2019-09-09 14:52:08', '备注', '1', null, null, '1', '1234567890');
INSERT INTO `bond_base_info` VALUES ('848', '12345678901', '1234567890', '1234567890', '普通公司债', '报价系统', 'AAA', null, null, '1234567890', '1234567890增信措施增信措施增信措施增信措施增信措施', '私募', '40', '40', '200', '7年', '期限备注', '0.45', '2019-01-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-27 00:00:00', '2019-02-27 00:00:00', null, null, null, null, null, null, null, null, '1234567890', '其他发行人名称', '交通运输、仓库和邮政业', '河南', '开封市', '内蒙古证监局', '主营业务', '中央国企', '是', 'AAA', null, null, '1350000000', '1234567890', '主承销商项目负责人', '北京证监局', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '其他资信评级机构名称', '资信评级机构项目负责人', '云南证监局', '1234567890', '受托管理人负责人', '受托管理人负责人联系方式', '内蒙古证监局', null, null, null, null, null, null, null, null, null, '1', '2019-02-26 13:48:56', '2019-09-09 14:49:37', '备注', '1', null, null, '1', '1234567890');

-- ----------------------------
-- Table structure for bond_company_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_company_info`;
CREATE TABLE `bond_company_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `industry` varchar(40) DEFAULT NULL,
  `contact_way` varchar(40) DEFAULT NULL,
  `province` varchar(40) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `belong_srb` varchar(40) DEFAULT NULL,
  `main_business` varchar(100) DEFAULT NULL,
  `nature` varchar(40) DEFAULT NULL,
  `financial_industry` varchar(40) DEFAULT NULL,
  `com_rating` varchar(40) DEFAULT NULL,
  `com_initial_rating` varchar(40) DEFAULT NULL,
  `com_current_rating` varchar(40) DEFAULT NULL,
  `charge` varchar(40) DEFAULT NULL,
  `signatory` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_company_info
-- ----------------------------

-- ----------------------------
-- Table structure for bond_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_info`;
CREATE TABLE `bond_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BASE_ID` int(11) DEFAULT NULL,
  `trem_remark` varchar(100) DEFAULT NULL,
  `trusteeship` bigint(20) DEFAULT NULL,
  `list_time` datetime DEFAULT NULL,
  `approval_time` datetime DEFAULT NULL,
  `issuer_name` varchar(40) DEFAULT NULL,
  `issuer_industry` varchar(40) DEFAULT NULL,
  `issuer_province` varchar(40) DEFAULT NULL,
  `issuer_city` varchar(40) DEFAULT NULL,
  `issuer_srb` varchar(40) DEFAULT NULL,
  `issuer_business` varchar(40) DEFAULT NULL,
  `issuer_nature` varchar(40) DEFAULT NULL,
  `issuer_financial` varchar(40) DEFAULT NULL,
  `issuer_rating` varchar(40) DEFAULT NULL,
  `issuer_contact_way` varchar(40) DEFAULT NULL,
  `underwriter_name` varchar(40) DEFAULT NULL,
  `underwriter_charge` varchar(40) DEFAULT NULL,
  `underwriter_srb` varchar(40) DEFAULT NULL,
  `accounting_name` varchar(40) DEFAULT NULL,
  `accounting_signatory` varchar(40) DEFAULT NULL,
  `law_name` varchar(40) DEFAULT NULL,
  `law_signatory` varchar(40) DEFAULT NULL,
  `rating_agency_name` varchar(40) DEFAULT NULL,
  `rating_agency_charge` varchar(40) DEFAULT NULL,
  `rating_agency_srb` varchar(40) DEFAULT NULL,
  `trustee_name` varchar(40) DEFAULT NULL,
  `trustee_charge` varchar(40) DEFAULT NULL,
  `trustee_charge_contact_way` varchar(40) DEFAULT NULL,
  `trustee_srb` varchar(40) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_info
-- ----------------------------

-- ----------------------------
-- Table structure for bond_per_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_per_info`;
CREATE TABLE `bond_per_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) DEFAULT NULL,
  `CARD_TYPE` varchar(40) DEFAULT NULL,
  `CARD_NUM` varchar(40) DEFAULT NULL,
  `CONTACT_WAY` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_per_info
-- ----------------------------

-- ----------------------------
-- Table structure for bond_risk_breach_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_risk_breach_info`;
CREATE TABLE `bond_risk_breach_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `risk_state` varchar(40) DEFAULT NULL COMMENT '风险状态',
  `risk_level` varchar(40) DEFAULT NULL,
  `trade_state` varchar(40) DEFAULT NULL COMMENT '交易状态',
  `bond_balance` varchar(20) DEFAULT NULL,
  `pledge_buy_back` varchar(40) DEFAULT NULL COMMENT '是否属于质押式回购可质押债券',
  `conversion_rate` varchar(14) DEFAULT NULL COMMENT '当前折算率',
  `trust_compensation` varchar(40) DEFAULT NULL COMMENT '增信代偿情况',
  `supervision_contact_otc` varchar(40) DEFAULT NULL,
  `supervision_contact_srb` varchar(40) DEFAULT NULL,
  `underwriter_contact_way` varchar(40) DEFAULT NULL,
  `rating_agency_contact_way` varchar(40) DEFAULT NULL,
  `guarantor` varchar(40) DEFAULT NULL,
  `guarantor_contact_way` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_risk_breach_info
-- ----------------------------
INSERT INTO `bond_risk_breach_info` VALUES ('28', '698', '1', '违约', '11', '未成交', '11', '是', '11', '11', '11', '11', '11', '11', '11', '11', '2019-08-21 19:43:29', '2019-08-21 19:43:29', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('31', '700', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-22 17:18:32', '2019-08-22 17:18:32', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('32', '694', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-22 17:18:54', '2019-08-22 17:18:54', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('33', '768', '1', '违约', '22', '未成交', '22123', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-09-04 10:29:08', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('173', '825', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('181', '826', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('182', '769', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('183', '770', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('184', '771', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('185', '772', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('186', '773', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('187', '774', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('188', '775', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('189', '776', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('190', '777', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('191', '778', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('192', '779', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '11', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 15:43:35', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('193', '780', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('194', '781', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('195', '782', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('196', '783', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('197', '784', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('198', '785', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('199', '786', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('200', '787', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:30', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('201', '788', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('202', '789', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('203', '790', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('204', '791', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('205', '792', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('206', '793', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('207', '794', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('208', '795', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('209', '796', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:40:54', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('210', '797', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('211', '798', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('212', '799', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('213', '800', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('214', '801', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('215', '802', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('216', '803', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('217', '804', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('218', '805', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:41:18', '2');
INSERT INTO `bond_risk_breach_info` VALUES ('219', '806', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('220', '807', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('221', '808', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('222', '809', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('223', '810', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('224', '811', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('225', '812', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('226', '813', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('227', '814', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('228', '815', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('229', '816', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('230', '817', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('231', '818', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('232', '819', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('233', '820', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('234', '821', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('235', '822', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('236', '823', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('237', '824', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('238', '825', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('239', '826', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('240', '827', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('241', '828', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('242', '829', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('243', '830', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('244', '831', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('245', '832', '1', '违约', '22', '未成交', '22', '是', '2', '增信代偿情况', '监管联系人', '监管联系人(证监局)', '承销商联系方式', '', '担保人', '	担保人联系方式', '2019-08-26 14:12:48', '2019-08-26 14:12:48', '1');
INSERT INTO `bond_risk_breach_info` VALUES ('246', '835', '1', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 18:10:14', '2019-08-28 18:12:40', '2');

-- ----------------------------
-- Table structure for bond_risklevel_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_risklevel_info`;
CREATE TABLE `bond_risklevel_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `risk_level` varchar(40) DEFAULT NULL,
  `bond_balance` bigint(20) DEFAULT NULL,
  `risk_cause_development` varchar(1000) DEFAULT NULL,
  `pledge` varchar(40) DEFAULT NULL,
  `rating_agency_contact_way` varchar(40) DEFAULT NULL,
  `guarantor` varchar(40) DEFAULT NULL,
  `guarantor_contact_way` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_risklevel_info
-- ----------------------------

-- ----------------------------
-- Table structure for bond_sup_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_sup_info`;
CREATE TABLE `bond_sup_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(40) DEFAULT NULL COMMENT 'base表中的ID',
  `obj_type` varchar(40) DEFAULT NULL,
  `file_name` varchar(40) DEFAULT NULL,
  `letter_type` varchar(40) DEFAULT NULL,
  `issue_time` datetime DEFAULT NULL,
  `publisher` varchar(40) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `intermediary_agency` varchar(255) DEFAULT NULL COMMENT '中介机构名称',
  `intermediary_agency_srb` varchar(1000) DEFAULT NULL COMMENT '中介机构所属证监局',
  `issuer_srb` varchar(1000) DEFAULT NULL COMMENT '发行人所属证监局',
  `short_name` varchar(255) DEFAULT NULL COMMENT '债券简称',
  `issuer_name` varchar(255) DEFAULT NULL COMMENT '发行人名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=371362211 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_sup_info
-- ----------------------------
INSERT INTO `bond_sup_info` VALUES ('371362145', '699', null, null, null, null, null, null, '1', '2019-08-26 13:42:41', '2019-08-26 13:42:41', '1', '333', '北京证监局,河北证监局', '天津证监局,河北证监局', '33', '133');
INSERT INTO `bond_sup_info` VALUES ('371362146', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', 'zyc1', '1');
INSERT INTO `bond_sup_info` VALUES ('371362148', '700', null, null, null, null, null, null, '1', '2019-08-26 13:43:31', '2019-08-26 13:43:31', '1', '11', '北京证监局', '北京证监局', 'zyc', '11');
INSERT INTO `bond_sup_info` VALUES ('371362149', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362150', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362151', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362152', '698', null, null, null, null, '', '', '1', null, '2019-08-28 11:21:57', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362153', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362154', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362155', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362156', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362157', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362158', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362159', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362160', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362161', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362162', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362163', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362164', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362165', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362166', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362167', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362168', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362169', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362170', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362171', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362172', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362173', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362174', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362175', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362176', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362177', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362178', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362179', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362180', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362181', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362182', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362183', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362184', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362185', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362186', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362187', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362188', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362189', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362190', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362191', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362192', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362193', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362194', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362195', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362196', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362197', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362198', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362199', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362200', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362201', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362202', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362203', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362204', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362205', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362206', '698', null, null, null, null, null, null, '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50', '1', '333', '北京证监局,河北证监局', '北京证监局', '债券简称', '1');
INSERT INTO `bond_sup_info` VALUES ('371362209', '822', null, null, null, null, null, null, '1', '2019-08-28 13:55:20', '2019-08-28 13:55:20', '142', '', null, null, 'CODE123123', '');
INSERT INTO `bond_sup_info` VALUES ('371362210', '835', null, null, null, null, null, null, '2', '2019-08-28 18:15:10', '2019-08-28 18:15:57', '1', '', null, null, '', '');

-- ----------------------------
-- Table structure for bond_trail_audit_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_trail_audit_info`;
CREATE TABLE `bond_trail_audit_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `audit_opinion` varchar(255) DEFAULT NULL COMMENT '审核意见',
  `bond_trail_id` int(11) DEFAULT NULL COMMENT '在审项目信息id',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `user_id` int(11) DEFAULT NULL COMMENT '操作用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operate_type` varchar(255) DEFAULT NULL COMMENT '操作类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_trail_audit_info
-- ----------------------------
INSERT INTO `bond_trail_audit_info` VALUES ('154', '提交', '2652', '2019-08-20 19:11:32', '1', '2019-08-20 19:11:32', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('155', '', '2652', '2019-08-20 19:11:46', '1', '2019-08-20 19:11:46', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('156', '提交', '2653', '2019-08-20 19:17:46', '1', '2019-08-20 19:17:46', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('157', '提交', '2654', '2019-08-20 19:18:35', '1', '2019-08-20 19:18:35', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('158', '', '2653', '2019-08-20 19:18:46', '1', '2019-08-20 19:18:46', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('159', '', '2654', '2019-08-20 19:18:52', '1', '2019-08-20 19:18:52', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('160', '提交', '2655', '2019-08-20 19:19:56', '1', '2019-08-20 19:19:56', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('161', '', '2655', '2019-08-20 19:20:08', '1', '2019-08-20 19:20:08', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('162', '提交', '2657', '2019-08-26 13:57:39', '1', '2019-08-26 13:57:39', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('163', '提交', '2746', '2019-08-28 11:03:03', '1', '2019-08-28 11:03:03', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('164', '提交', '2747', '2019-08-28 11:06:08', '1', '2019-08-28 11:06:08', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('165', '', '2747', '2019-08-28 13:39:53', '143', '2019-08-28 13:39:53', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('166', '', '2746', '2019-08-28 13:39:57', '143', '2019-08-28 13:39:57', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('167', '提交', '2748', '2019-08-28 13:42:08', '1', '2019-08-28 13:42:08', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('168', '', '2748', '2019-08-28 13:42:16', '1', '2019-08-28 13:42:16', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('169', '提交', '2751', '2019-08-28 13:47:31', '142', '2019-08-28 13:47:31', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('170', '', '2751', '2019-08-28 13:47:59', '143', '2019-08-28 13:47:59', '审核通过');
INSERT INTO `bond_trail_audit_info` VALUES ('171', '提交', '2752', '2019-08-28 13:51:51', '142', '2019-08-28 13:51:51', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('172', '', '2752', '2019-08-28 13:52:19', '143', '2019-08-28 13:52:19', '退回补正');
INSERT INTO `bond_trail_audit_info` VALUES ('173', '提交', '2754', '2019-08-28 18:06:54', '1', '2019-08-28 18:06:54', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('174', '提交', '2755', '2019-08-28 18:07:06', '1', '2019-08-28 18:07:06', '提交');
INSERT INTO `bond_trail_audit_info` VALUES ('175', '', '2755', '2019-08-28 18:07:16', '1', '2019-08-28 18:07:16', '退回补正');
INSERT INTO `bond_trail_audit_info` VALUES ('176', '', '2754', '2019-08-28 18:07:22', '1', '2019-08-28 18:07:22', '审核通过');

-- ----------------------------
-- Table structure for bond_trial_info
-- ----------------------------
DROP TABLE IF EXISTS `bond_trial_info`;
CREATE TABLE `bond_trial_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `base_id` int(11) DEFAULT NULL COMMENT '债券基本信息id',
  `bond_code` varchar(255) DEFAULT NULL COMMENT '债券编码',
  `issue_amount` varchar(255) DEFAULT NULL,
  `approval_num` varchar(255) DEFAULT NULL,
  `approval_time` datetime DEFAULT NULL,
  `check_state` varchar(10) DEFAULT NULL,
  `accept_time` datetime DEFAULT NULL,
  `first_feedback_time` datetime DEFAULT NULL,
  `first_replay_time` datetime DEFAULT NULL,
  `second_feedback_time` datetime DEFAULT NULL,
  `second_replay_time` datetime DEFAULT NULL,
  `expert_time` datetime DEFAULT NULL,
  `pre_audit_time` datetime DEFAULT NULL,
  `issuer_name` varchar(255) DEFAULT NULL,
  `issuer_industry` varchar(255) DEFAULT NULL,
  `issuer_province` varchar(255) DEFAULT NULL,
  `issuer_city` varchar(255) DEFAULT NULL,
  `issuer_business` varchar(600) DEFAULT NULL,
  `issuer_nature` varchar(255) DEFAULT NULL,
  `issuer_financial` varchar(255) DEFAULT NULL,
  `issuer_contact_way` varchar(255) DEFAULT NULL,
  `accounting_name` varchar(255) DEFAULT NULL,
  `accounting_signatory` varchar(255) DEFAULT NULL,
  `law_name` varchar(255) DEFAULT NULL,
  `law_signatory` varchar(255) DEFAULT NULL,
  `rating_agency_name` varchar(255) DEFAULT NULL,
  `rating_agency_charge` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `underwriter_name` varchar(255) DEFAULT NULL,
  `underwriter_charge` varchar(255) DEFAULT NULL,
  `trustee_name` varchar(255) DEFAULT NULL,
  `issuer_rating` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `trailinfo_baseId_index` (`base_id`) USING BTREE,
  KEY `trailinfo_bondcode` (`bond_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2777 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bond_trial_info
-- ----------------------------
INSERT INTO `bond_trial_info` VALUES ('2652', '706', null, '1', '1', null, '', '2019-08-20 00:00:00', '2019-08-16 00:00:00', '2019-08-20 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', '2019-08-21 00:00:00', null, '11', '农、林、牧、渔业', '', '', '11', '地方国企', '是', '', '', '', '', '', '', '', '1', '', '', '', '', '2019-08-20 19:11:32', '2019-08-20 19:11:32', '1', '1', '1');
INSERT INTO `bond_trial_info` VALUES ('2653', '707', null, '1', '1', '2019-08-08 00:00:00', '8', '2019-08-07 00:00:00', '2019-08-05 00:00:00', '2019-08-08 00:00:00', '2019-08-15 00:00:00', '2019-08-08 00:00:00', '2019-08-09 00:00:00', '2019-08-15 00:00:00', '11', '农、林、牧、渔业', '北京', '朝阳区', '11', '中央国企', '是', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', 'AAA', '2019-08-20 19:17:46', '2019-08-20 19:17:46', '1', '1', '2');
INSERT INTO `bond_trial_info` VALUES ('2654', '708', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'AAA', '2019-08-20 19:18:35', '2019-08-20 19:18:35', '1', '1', '3');
INSERT INTO `bond_trial_info` VALUES ('2655', '709', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-20 19:19:56', '2019-08-20 19:19:56', '1', '1', '4');
INSERT INTO `bond_trial_info` VALUES ('2656', '806', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '', '', '', '', '', '', '备注', '主承销商名称', '主承销商项目负责人', '', 'AAA', '2019-08-26 13:57:29', '2019-08-26 13:57:29', '1', '3', '1234567890');
INSERT INTO `bond_trial_info` VALUES ('2657', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 15:16:18', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2658', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2659', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2660', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2661', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2662', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2663', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2664', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2665', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '批发和零售业', '辽宁', '锦州市', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-09-09 14:51:04', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2666', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2667', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2668', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2669', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-29 09:02:38', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2670', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2671', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2672', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2673', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2674', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2675', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2676', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2677', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2678', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2679', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2680', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2681', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2682', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2683', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '辽宁', '锦州市', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-09-09 14:44:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2684', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2685', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2686', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2687', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2688', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2689', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2690', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2691', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2692', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2693', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2694', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2695', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2696', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2697', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2698', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2699', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2700', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2701', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2702', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2703', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2704', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2705', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2706', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2707', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2708', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2709', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2710', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2711', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2712', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2713', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2714', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2715', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2716', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2717', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2718', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2719', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2720', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2721', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2722', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2723', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2724', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2725', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2726', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2727', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2728', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2729', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2730', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2731', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2732', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2733', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2734', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2735', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2736', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2737', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2738', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2739', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2740', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2741', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2742', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2743', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2744', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2745', '807', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2746', '813', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 11:03:03', '2019-08-28 11:03:03', '1', '1', '232323233333');
INSERT INTO `bond_trial_info` VALUES ('2747', '814', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 11:06:08', '2019-08-28 11:06:08', '1', '1', '2121');
INSERT INTO `bond_trial_info` VALUES ('2748', '815', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 13:42:08', '2019-08-28 13:42:33', '1', '1', '123334445555');
INSERT INTO `bond_trial_info` VALUES ('2749', '816', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 13:42:59', '2019-08-28 13:42:59', '1', '3', '1111');
INSERT INTO `bond_trial_info` VALUES ('2750', '819', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 13:47:16', '2019-08-28 13:47:16', '142', '3', 'CODE123');
INSERT INTO `bond_trial_info` VALUES ('2751', '820', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 13:47:31', '2019-08-28 13:47:31', '142', '1', 'CODE1231');
INSERT INTO `bond_trial_info` VALUES ('2752', '821', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 13:51:51', '2019-08-28 13:51:51', '142', '5', 'CODE123123');
INSERT INTO `bond_trial_info` VALUES ('2753', '832', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 18:06:46', '2019-08-28 18:06:46', '1', '3', '1');
INSERT INTO `bond_trial_info` VALUES ('2754', '833', null, '2', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 18:06:54', '2019-08-28 18:08:10', '1', '2', '22222222222222222');
INSERT INTO `bond_trial_info` VALUES ('2755', '834', null, '', '', null, '', null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '2019-08-28 18:07:06', '2019-08-28 18:07:06', '1', '5', '3333333333333333333');
INSERT INTO `bond_trial_info` VALUES ('2756', '836', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2757', '837', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2758', '838', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2759', '839', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2760', '840', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2761', '841', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2762', '842', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2763', '843', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2764', '844', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-29 09:02:38', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2765', '845', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2766', '846', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2767', '847', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '1234567890', '教育', '北京', '宣武区', '主营业务', '中央国企', '是', '1350000000', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '资信评级机构项目负责人', '备注', '1234567890', '主承销商项目负责人', '1234567890', 'AAA', '2019-08-26 13:57:39', '2019-09-09 14:52:08', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2768', '848', null, '200', '证监会核准文号', '2019-08-26 00:00:00', '8', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '2019-08-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-08-26 13:57:39', '2019-08-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2769', '836', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '1234567890', '文化、体育和娱乐业', '北京', '宣武区', '主营业务', '中央国企', '是', '1350000000', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '资信评级机构项目负责人', '备注', '1234567890', '主承销商项目负责人', '1234567890', 'AAA', '2019-02-26 13:57:39', '2019-09-09 14:51:56', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2770', '837', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-02-26 13:57:39', '2019-02-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2771', '838', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '1234567890', '综合', '北京', '宣武区', '主营业务', '中央国企', '是', '1350000000', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '资信评级机构项目负责人', '备注', '1234567890', '主承销商项目负责人', '1234567890', 'AAA', '2019-02-26 13:57:39', '2019-09-09 14:51:46', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2772', '839', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '1234567890', '水利、环境和公共设施管理业', '北京', '宣武区', '主营业务', '中央国企', '是', '1350000000', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '资信评级机构项目负责人', '备注', '1234567890', '主承销商项目负责人', '1234567890', 'AAA', '2019-02-26 13:57:39', '2019-09-09 14:51:36', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2773', '840', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-02-26 13:57:39', '2019-02-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2774', '841', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-02-26 13:57:39', '2019-02-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2775', '842', null, '200', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '发行人名称', '农、林、牧、渔业', '北京', '朝阳区', '主营业务', '中央国企', '是', '发行人联系方式', '会计师事务所名称', '会计师事务所签字会计师', '律师事务所名称', '律师事务所名称', '律师事务所名称', '律师事务所名称', '备注', '主承销商名称', '主承销商项目负责人', '律师事务所名称', 'AAA', '2019-02-26 13:57:39', '2019-02-26 14:05:59', '1', '1', '12345678901');
INSERT INTO `bond_trial_info` VALUES ('2776', '843', null, '3344444', '证监会核准文号', '2019-02-26 00:00:00', '8', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '2019-02-26 00:00:00', '1234567890', '采矿业', '河北', '保定市', '主营业务', '中央国企', '是', '1350000000', '1234567890', '会计师事务所签字会计师', '1234567890', '律师事务所签字律师', '1234567890', '资信评级机构项目负责人', '备注', '1234567890', '主承销商项目负责人', '1234567890', 'AAA', '2019-02-26 13:57:39', '2019-09-09 14:48:44', '1', '1', '12345678901');

-- ----------------------------
-- Table structure for e_menu
-- ----------------------------
DROP TABLE IF EXISTS `e_menu`;
CREATE TABLE `e_menu` (
  `ModId` int(3) NOT NULL AUTO_INCREMENT,
  `Moduelcode` varchar(50) DEFAULT NULL,
  `ModuelName` varchar(50) DEFAULT NULL,
  `ParentCode` varchar(50) DEFAULT NULL,
  `ModuelUrl` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ModId`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_menu
-- ----------------------------
INSERT INTO `e_menu` VALUES ('1', 'ZQJBQKGL', '债券管理', null, null, '');
INSERT INTO `e_menu` VALUES ('2', 'ZQJBQK', '债券基本信息', 'ZQJBQKGL', 'bondInfo/ZQJBQK', '');
INSERT INTO `e_menu` VALUES ('18', 'ZSXMXX', '在审项目信息', 'ZQJBQKGL', 'bondTrialInfo/ZSXMXX', '');
INSERT INTO `e_menu` VALUES ('20', 'GFXWY', '风险监测信息', 'ZQJBQKGL', 'bondRiskBreachInfo/GFXWY', '');
INSERT INTO `e_menu` VALUES ('21', 'ZQJGXX', '债券监管信息', 'ZQJBQKGL', 'bondSupInfo/GetZQJGMsg', '');
INSERT INTO `e_menu` VALUES ('22', 'TJXX', '债券统计信息', 'ZQJBQKGL', 'bondTjxxInfo/TJXX', '');
INSERT INTO `e_menu` VALUES ('23', 'XTGL', '系统管理', null, null, '');
INSERT INTO `e_menu` VALUES ('24', 'YHXX', '用户信息', 'XTGL', 'SYS/YHXX', '');
INSERT INTO `e_menu` VALUES ('25', 'JSXX', '角色信息', 'XTGL', 'SYS/JSXX', '');
INSERT INTO `e_menu` VALUES ('26', 'QXXX', '权限信息', 'XTGL', 'SYS/QXXX', '');
INSERT INTO `e_menu` VALUES ('31', 'ABSGL', 'ABS管理', null, null, '');
INSERT INTO `e_menu` VALUES ('32', 'ABSZQJBQK', 'ABS基本信息', 'ABSGL', 'ABSIssueInfo/ABSZQJBQK', '');
INSERT INTO `e_menu` VALUES ('35', 'ABSZSXMXX', 'ABS在审项目信息', 'ABSGL', 'ABSTrailInfo/ABSTrailInfo', '');
INSERT INTO `e_menu` VALUES ('37', 'ABSGFXWY', 'ABS风险监测信息', 'ABSGL', 'abs_riskBreachInfo/ABSGFXWY', '');
INSERT INTO `e_menu` VALUES ('38', 'ABSZQJGXX', 'ABS监管信息', 'ABSGL', 'ABSSupInfo/GetJGMsg', '');
INSERT INTO `e_menu` VALUES ('39', 'ABSTJXX', 'ABS统计信息', 'ABSGL', 'ABSTjxxInfo/ABSTjxx', '');
INSERT INTO `e_menu` VALUES ('40', 'SYSLOG', '日志管理', 'XTGL', 'SYS/toListSysLog', '');
INSERT INTO `e_menu` VALUES ('41', 'DICT', '数据字典', 'XTGL', 'dict/searchDict', '');
INSERT INTO `e_menu` VALUES ('42', 'INFOMANAGE', '信息管理', 'XTGL', 'informationManagement/XXGL', '');

-- ----------------------------
-- Table structure for e_menu_privileges
-- ----------------------------
DROP TABLE IF EXISTS `e_menu_privileges`;
CREATE TABLE `e_menu_privileges` (
  `MPID` int(3) NOT NULL,
  `Moduelcode` varchar(50) DEFAULT NULL,
  `PRICODE` varchar(50) DEFAULT NULL,
  `Parentcode` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_menu_privileges
-- ----------------------------
INSERT INTO `e_menu_privileges` VALUES ('1', 'ZQJBQK', 'PRI_ZQJBQK', null, '债券基本情况');
INSERT INTO `e_menu_privileges` VALUES ('2', 'ZSXMXX', 'PRI_ZSXMXX', null, '在审项目信息');
INSERT INTO `e_menu_privileges` VALUES ('4', 'GFXWY', 'PRI_GFXWY', null, '风险监测');
INSERT INTO `e_menu_privileges` VALUES ('5', 'ZQJGXX', 'PRI_ZQJGXX', null, '债券监管信息');
INSERT INTO `e_menu_privileges` VALUES ('6', 'TJXX', 'PRI_TJXX', null, '债券统计信息');
INSERT INTO `e_menu_privileges` VALUES ('7', 'ABSZQJBQK', 'PRI_ABSZQJBQK', null, 'ABS基本情况');
INSERT INTO `e_menu_privileges` VALUES ('9', 'YHXX', 'PRI_YHXX', null, '用户信息');
INSERT INTO `e_menu_privileges` VALUES ('10', 'JSXX', 'PRI_JSXX', null, '角色信息');
INSERT INTO `e_menu_privileges` VALUES ('11', 'QXXX', 'PRI_QXXX', null, '权限信息');
INSERT INTO `e_menu_privileges` VALUES ('201', 'ZQJBQK_DELETE', 'PRI_DELETE', 'ZQJBQK', '债券基本情况-删除');
INSERT INTO `e_menu_privileges` VALUES ('202', 'ZQJBQK_EDIT', 'PRI_EDIT', 'ZQJBQK', '债券基本情况-修改');
INSERT INTO `e_menu_privileges` VALUES ('203', 'ZQJBQK_QUERY', 'PRI_QUERY', 'ZQJBQK', '债券基本情况-查询');
INSERT INTO `e_menu_privileges` VALUES ('204', 'ZSXMXX_ADD', 'PRI_ADD', 'ZSXMXX', '在审项目信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('205', 'ZSXMXX_DELETE', 'PRI_DELETE', 'ZSXMXX', '在审项目信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('206', 'ZSXMXX_EDIT', 'PRI_EDIT', 'ZSXMXX', '在审项目信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('207', 'ZSXMXX_QUERY', 'PRI_QUERY', 'ZSXMXX', '在审项目信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('212', 'GFXWY_ADD', 'PRI_ADD', 'GFXWY', '风险监测-新增');
INSERT INTO `e_menu_privileges` VALUES ('213', 'GFXWY_DELETE', 'PRI_DELETE', 'GFXWY', '风险监测-删除');
INSERT INTO `e_menu_privileges` VALUES ('214', 'GFXWY_EDIT', 'PRI_EDIT', 'GFXWY', '风险监测-修改');
INSERT INTO `e_menu_privileges` VALUES ('215', 'GFXWY_QUERY', 'PRI_QUERY', 'GFXWY', '风险监测-查询');
INSERT INTO `e_menu_privileges` VALUES ('216', 'ZQJGXX_ADD', 'PRI_ADD', 'ZQJGXX', '债券监管信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('217', 'ZQJGXX_DELETE', 'PRI_DELETE', 'ZQJGXX', '债券监管信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('218', 'ZQJGXX_EDIT', 'PRI_EDIT', 'ZQJGXX', '债券监管信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('219', 'ZQJGXX_QUERY', 'PRI_QUERY', 'ZQJGXX', '债券监管信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('220', 'TJXX_ADD', 'PRI_ADD', 'TJXX', '债券统计信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('221', 'TJXX_DELETE', 'PRI_DELETE', 'TJXX', '债券统计信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('222', 'TJXX_EDIT', 'PRI_EDIT', 'TJXX', '债券统计信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('223', 'TJXX_QUERY', 'PRI_QUERY', 'TJXX', '债券统计信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('224', 'ABSZQJBQK_ADD', 'PRI_ADD', 'ABSZQJBQK', 'ABS基本信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('225', 'ABSZQJBQK_DELETE', 'PRI_DELETE', 'ABSZQJBQK', 'ABS基本信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('226', 'ABSZQJBQK_EDIT', 'PRI_EDIT', 'ABSZQJBQK', 'ABS基本信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('227', 'ABSZQJBQK_QUERY', 'PRI_QUERY', 'ABSZQJBQK', 'ABS基本信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('200', 'ZQJBQK_ADD', 'PRI_ADD', 'ZQJBQK', '债券基本情况-新增');
INSERT INTO `e_menu_privileges` VALUES ('15', 'ABSZSXMXX', 'PRI_ABSZSXMXX', null, 'ABS在审项目信息');
INSERT INTO `e_menu_privileges` VALUES ('17', 'ABSGFXWY', 'PRI_ABSGFXWY', null, 'ABS风险监测');
INSERT INTO `e_menu_privileges` VALUES ('18', 'ABSZQJGXX', 'PRI_ABSZQJGXX', null, 'ABS监管信息');
INSERT INTO `e_menu_privileges` VALUES ('19', 'ABSTJXX', 'PRI_ABSTJXX', null, 'ABS统计信息');
INSERT INTO `e_menu_privileges` VALUES ('231', 'ABSZSXMXX_QUERY', 'PRI_QUERY', 'ABSZSXMXX', 'ABS在审项目信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('229', 'ABSZSXMXX_DELETE', 'PRI_DELETE', 'ABSZSXMXX', 'ABS在审项目信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('230', 'ABSZSXMXX_EDIT', 'PRI_EDIT', 'ABSZSXMXX', 'ABS在审项目信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('228', 'ABSZSXMXX_ADD', 'PRI_ADD', 'ABSZSXMXX', 'ABS在审项目信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('236', 'ABSGFXWY_ADD', 'PRI_DELETE', 'ABSGFXWY', 'ABS风险监测-新增');
INSERT INTO `e_menu_privileges` VALUES ('237', 'ABSGFXWY_DELETE', 'PRI_EDIT', 'ABSGFXWY', 'ABS风险监测-删除');
INSERT INTO `e_menu_privileges` VALUES ('239', 'ABSGFXWY_QUERY', 'PRI_ADD', 'ABSGFXWY', 'ABS风险监测-查询');
INSERT INTO `e_menu_privileges` VALUES ('238', 'ABSGFXWY_EDIT', 'PRI_QUERY', 'ABSGFXWY', 'ABS风险监测-修改');
INSERT INTO `e_menu_privileges` VALUES ('241', 'ABSZQJGXX_DELETE', 'PRI_DELETE', 'ABSZQJGXX', 'ABS监管信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('243', 'ABSZQJGXX_QUERY', 'PRI_QUERY', 'ABSZQJGXX', 'ABS监管信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('240', 'ABSZQJGXX_ADD', 'PRI_ADD', 'ABSZQJGXX', 'ABS监管信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('247', 'ABSTJXX_ADD', 'PRI_ADD', 'ABSTJXX', 'ABS统计信息-新增');
INSERT INTO `e_menu_privileges` VALUES ('246', 'ABSTJXX_DELETE', 'PRI_DELETE', 'ABSTJXX', 'ABS统计信息-删除');
INSERT INTO `e_menu_privileges` VALUES ('245', 'ABSTJXX_EDIT', 'PRI_EDIT', 'ABSTJXX', 'ABS统计信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('244', 'ABSTJXX_QUERY', 'PRI_QUERY', 'ABSTJXX', 'ABS统计信息-查询');
INSERT INTO `e_menu_privileges` VALUES ('242', 'ABSZQJGXX_EDIT', 'PRI_EDIT', 'ABSZQJGXX', 'ABS监管信息-修改');
INSERT INTO `e_menu_privileges` VALUES ('14', 'SYSLOG', 'PRI_SYSLOG', null, '日志管理');
INSERT INTO `e_menu_privileges` VALUES ('12', 'DICT', 'PRI_DICT', null, '数据字典');
INSERT INTO `e_menu_privileges` VALUES ('13', 'INFOMANAGE', 'PRI_PRI_INFOMANAGE', null, '信息管理');
INSERT INTO `e_menu_privileges` VALUES ('248', 'ZQJGXX_FILE_DELETE', 'PRI_FILEDELETE', 'ZQJGXX', '债券监管-文件删除');
INSERT INTO `e_menu_privileges` VALUES ('249', 'YHXX_ADD', 'PRI_ADD', 'YHXX', '用户-新增');
INSERT INTO `e_menu_privileges` VALUES ('250', 'YHXX_DELETE', 'PRI_DELETE', 'YHXX', '用户-删除');
INSERT INTO `e_menu_privileges` VALUES ('251', 'YHXX_EDIT', 'PRI_EDIT', 'YHXX', '用户-修改');
INSERT INTO `e_menu_privileges` VALUES ('252', 'YHXX_QUERY', 'PRI_QUERY', 'YHXX', '用户-查询');
INSERT INTO `e_menu_privileges` VALUES ('253', 'JSXX_ADD', 'PRI_ADD', 'JSXX', '角色-新增');
INSERT INTO `e_menu_privileges` VALUES ('254', 'JSXX_DELETE', 'PRI_DELETE', 'JSXX', '角色-删除');
INSERT INTO `e_menu_privileges` VALUES ('255', 'JSXX_EDIT', 'PRI_EDIT', 'JSXX', '角色-修改');
INSERT INTO `e_menu_privileges` VALUES ('256', 'JSXX_QUERY', 'PRI_QUERY', 'JSXX', '角色-查询');
INSERT INTO `e_menu_privileges` VALUES ('257', 'QXXX_ADD', 'PRI_ADD', 'QXXX', '权限-新增');
INSERT INTO `e_menu_privileges` VALUES ('258', 'QXXX_DELETE', 'PRI_DELETE', 'QXXX', '权限-删除');
INSERT INTO `e_menu_privileges` VALUES ('259', 'QXXX_EDIT', 'PRI_EDIT', 'QXXX', '权限-修改');
INSERT INTO `e_menu_privileges` VALUES ('260', 'QXXX_QUERY', 'PRI_QUERY', 'QXXX', '权限-查询');
INSERT INTO `e_menu_privileges` VALUES ('261', 'YHXX_UROLE', 'PRI_YHXX_UROLE', 'YHXX', '用户-角色配置');
INSERT INTO `e_menu_privileges` VALUES ('262', 'YHXX_REST_PASS', 'PRI_REST_PASS', 'YHXX', '用户-重置密码');
INSERT INTO `e_menu_privileges` VALUES ('263', 'YHXX_PASS_MAINTAIN', 'PRI_PASS_MAINTAIN', 'YHXX', '用户-密码维护');
INSERT INTO `e_menu_privileges` VALUES ('264', 'JSXX_PRIMISSION', 'PRI_JSXX_PRIMISSION', 'JSXX', '角色-权限配置');
INSERT INTO `e_menu_privileges` VALUES ('265', 'INFO_SHENHE', 'PRI_SHENHE', '', '信息-审核');
INSERT INTO `e_menu_privileges` VALUES ('266', 'SERIAL_NUMBER', 'PRI_SERIAL', null, '权限-流水号');
INSERT INTO `e_menu_privileges` VALUES ('267', 'ABSZQJGFile_DELETE', 'PRI_ZQJGFile_DELETE', 'ABSZQJGXX', 'ABS监管文件-删除');
INSERT INTO `e_menu_privileges` VALUES ('268', 'EARNING_PRINCIPAL', 'PRI_EARNING', null, '权限-收益分配本金兑付时间');

-- ----------------------------
-- Table structure for e_organization
-- ----------------------------
DROP TABLE IF EXISTS `e_organization`;
CREATE TABLE `e_organization` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `organizationId` varchar(50) DEFAULT NULL,
  `organizationame` varchar(50) DEFAULT NULL,
  `organizationtype` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_organization
-- ----------------------------
INSERT INTO `e_organization` VALUES ('1', 'M11038', '中山证券有限责任公司', '证券公司', null, null);
INSERT INTO `e_organization` VALUES ('2', 'M80086', '华宝证券有限责任公司', '证券公司', null, null);
INSERT INTO `e_organization` VALUES ('3', '122113', '恒泰长财证券有限责任公司', '证券公司', null, null);
INSERT INTO `e_organization` VALUES ('4', '143115', '财富证券有限责任公司', '证券公司', '湖南', null);
INSERT INTO `e_organization` VALUES ('5', '132028', '华泰证券股份有限公司', '证券公司', '江苏', null);
INSERT INTO `e_organization` VALUES ('6', '142045', '长江证券股份有限公司', '证券公司', '湖北', null);
INSERT INTO `e_organization` VALUES ('7', '185052', '中国中投证券有限责任公司', '证券公司', '深圳', null);

-- ----------------------------
-- Table structure for e_privileges
-- ----------------------------
DROP TABLE IF EXISTS `e_privileges`;
CREATE TABLE `e_privileges` (
  `pid` int(3) NOT NULL AUTO_INCREMENT,
  `permissionName` varchar(50) DEFAULT NULL,
  `permissiontype` varchar(50) DEFAULT NULL,
  `permissioncode` varchar(50) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_privileges
-- ----------------------------
INSERT INTO `e_privileges` VALUES ('5', '债券基本情况', '可操作模块-导航', 'PRI_ZQJBQK', '菜单');
INSERT INTO `e_privileges` VALUES ('8', '在审项目信息', '可操作模块-导航', 'PRI_ZSXMXX', '菜单');
INSERT INTO `e_privileges` VALUES ('10', '债券风险等级', '可操作模块-导航', 'PRI_FXDJ', '菜单');
INSERT INTO `e_privileges` VALUES ('11', '高风险及违约债券', '可操作模块-导航', 'PRI_GFXWY', '菜单');
INSERT INTO `e_privileges` VALUES ('12', '债券监管信息', '可操作模块-导航', 'PRI_ZQJGXX', '菜单');
INSERT INTO `e_privileges` VALUES ('13', '统计信息', '可操作模块-导航', 'PRI_TJXX', '菜单');
INSERT INTO `e_privileges` VALUES ('14', '用户信息', '用户体系-菜单', 'PRI_YHXX', '菜单');
INSERT INTO `e_privileges` VALUES ('15', '角色信息', '用户体系-菜单', 'PRI_JSXX', '菜单');
INSERT INTO `e_privileges` VALUES ('16', '权限信息', '用户体系-菜单', 'PRI_QXXX', '菜单');
INSERT INTO `e_privileges` VALUES ('19', '数据字典', '用户体系-菜单', 'PRI_DICT', '菜单');
INSERT INTO `e_privileges` VALUES ('20', 'ABS基本情况', '可操作模块-导航', 'PRI_ABSZQJBQK', '菜单');
INSERT INTO `e_privileges` VALUES ('21', 'ABS在审项目信息', '可操作模块-导航', 'PRI_ABSZSXMXX', '菜单');
INSERT INTO `e_privileges` VALUES ('22', 'ABS债券风险等级', '可操作模块-导航', 'PRI_ABSFXDJ', '菜单');
INSERT INTO `e_privileges` VALUES ('23', 'ABS高风险及违约债券', '可操作模块-导航', 'PRI_ABSGFXWY', '菜单');
INSERT INTO `e_privileges` VALUES ('24', 'ABS债券监管信息', '可操作模块-导航', 'PRI_ABSZQJGXX', '菜单');
INSERT INTO `e_privileges` VALUES ('25', 'ABS统计信息', '可操作模块-导航', 'PRI_ABSTJXX', '菜单');
INSERT INTO `e_privileges` VALUES ('36', '信息管理', '可操作模块-导航', 'PRI_INFOMANAGE', '菜单');
INSERT INTO `e_privileges` VALUES ('37', '日志管理', '可操作模块-导航', 'PRI_SYSLOG', '菜单');

-- ----------------------------
-- Table structure for e_role
-- ----------------------------
DROP TABLE IF EXISTS `e_role`;
CREATE TABLE `e_role` (
  `rolenum` int(20) NOT NULL AUTO_INCREMENT,
  `rolecode` varchar(20) DEFAULT NULL,
  `rolename` varchar(50) DEFAULT NULL,
  `remarks` longtext,
  PRIMARY KEY (`rolenum`),
  KEY `roleNum` (`rolenum`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_role
-- ----------------------------
INSERT INTO `e_role` VALUES ('15', 'admin', '系统管理员', '系统管理员');
INSERT INTO `e_role` VALUES ('16', 'QuotationSystem', '报价系统', '1.债券基本信息：【全部可见】\r\n2.申报项目基本信息【全部可见，】\r\n3.债券监管信息【全部可见，对本方提交的内容可维护】\r\n4.债券风险等级名单信息【全部可见】\r\n5.高风险及违约债券名单信息【全部可见】\r\n6.统计信息【全部可见】');
INSERT INTO `e_role` VALUES ('18', 'SecuritiesIndustryAs', '证券业协会', '\r\n1.债券基本信息：【全部可见】\r\n2.申报项目基本信息【全部可见，】\r\n3.债券监管信息【全部可见，对本方提交的内容可维护】\r\n4.债券风险等级名单信息【全部可见】\r\n5.高风险及违约债券名单信息【全部可见】\r\n6.统计信息【全部可见】');
INSERT INTO `e_role` VALUES ('19', 'BondDepartment', '证监会债券部', '1.债券基本信息：【全部可见】\r\n2.申报项目基本信息【全部可见，】\r\n3.债券监管信息【全部可见，对本方提交的内容可维护】\r\n4.债券风险等级名单信息【全部可见】\r\n5.高风险及违约债券名单信息【全部可见】\r\n6.统计信息【全部可见】');
INSERT INTO `e_role` VALUES ('35', 'shenhe', '审核', '审核');
INSERT INTO `e_role` VALUES ('38', 'shangjiaosuo', '上交所', '上交所');
INSERT INTO `e_role` VALUES ('39', 'shenjiaosuo', '深交所', '深交所');
INSERT INTO `e_role` VALUES ('40', 'beijing', '北京证监局', '北京证监局');
INSERT INTO `e_role` VALUES ('42', 'dalian', '大连证监局', '');
INSERT INTO `e_role` VALUES ('43', 'jiangsu', '江苏证监局', '');
INSERT INTO `e_role` VALUES ('44', 'zyc', '111', '111');
INSERT INTO `e_role` VALUES ('45', 'zyc1', '111', '222');
INSERT INTO `e_role` VALUES ('46', 'zyvv', '11', '111');

-- ----------------------------
-- Table structure for e_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `e_role_menu`;
CREATE TABLE `e_role_menu` (
  `RPID` int(3) NOT NULL AUTO_INCREMENT,
  `ROLECODE` varchar(50) DEFAULT NULL,
  `MPID` int(3) DEFAULT NULL,
  PRIMARY KEY (`RPID`),
  KEY `pid` (`RPID`) USING BTREE,
  KEY `role_id` (`ROLECODE`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1941 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_role_menu
-- ----------------------------
INSERT INTO `e_role_menu` VALUES ('962', 'admin', '2000');
INSERT INTO `e_role_menu` VALUES ('963', 'admin', '1');
INSERT INTO `e_role_menu` VALUES ('964', 'admin', '201');
INSERT INTO `e_role_menu` VALUES ('965', 'admin', '202');
INSERT INTO `e_role_menu` VALUES ('966', 'admin', '203');
INSERT INTO `e_role_menu` VALUES ('968', 'admin', '2');
INSERT INTO `e_role_menu` VALUES ('969', 'admin', '204');
INSERT INTO `e_role_menu` VALUES ('970', 'admin', '205');
INSERT INTO `e_role_menu` VALUES ('971', 'admin', '206');
INSERT INTO `e_role_menu` VALUES ('972', 'admin', '207');
INSERT INTO `e_role_menu` VALUES ('973', 'admin', '3');
INSERT INTO `e_role_menu` VALUES ('974', 'admin', '208');
INSERT INTO `e_role_menu` VALUES ('975', 'admin', '209');
INSERT INTO `e_role_menu` VALUES ('976', 'admin', '210');
INSERT INTO `e_role_menu` VALUES ('977', 'admin', '211');
INSERT INTO `e_role_menu` VALUES ('978', 'admin', '4');
INSERT INTO `e_role_menu` VALUES ('979', 'admin', '212');
INSERT INTO `e_role_menu` VALUES ('980', 'admin', '213');
INSERT INTO `e_role_menu` VALUES ('981', 'admin', '214');
INSERT INTO `e_role_menu` VALUES ('982', 'admin', '215');
INSERT INTO `e_role_menu` VALUES ('983', 'admin', '5');
INSERT INTO `e_role_menu` VALUES ('984', 'admin', '216');
INSERT INTO `e_role_menu` VALUES ('985', 'admin', '217');
INSERT INTO `e_role_menu` VALUES ('986', 'admin', '218');
INSERT INTO `e_role_menu` VALUES ('987', 'admin', '219');
INSERT INTO `e_role_menu` VALUES ('988', 'admin', '248');
INSERT INTO `e_role_menu` VALUES ('989', 'admin', '6');
INSERT INTO `e_role_menu` VALUES ('990', 'admin', '220');
INSERT INTO `e_role_menu` VALUES ('991', 'admin', '221');
INSERT INTO `e_role_menu` VALUES ('992', 'admin', '222');
INSERT INTO `e_role_menu` VALUES ('993', 'admin', '223');
INSERT INTO `e_role_menu` VALUES ('994', 'admin', '7');
INSERT INTO `e_role_menu` VALUES ('995', 'admin', '224');
INSERT INTO `e_role_menu` VALUES ('996', 'admin', '225');
INSERT INTO `e_role_menu` VALUES ('997', 'admin', '226');
INSERT INTO `e_role_menu` VALUES ('998', 'admin', '227');
INSERT INTO `e_role_menu` VALUES ('999', 'admin', '9');
INSERT INTO `e_role_menu` VALUES ('1000', 'admin', '249');
INSERT INTO `e_role_menu` VALUES ('1001', 'admin', '250');
INSERT INTO `e_role_menu` VALUES ('1002', 'admin', '251');
INSERT INTO `e_role_menu` VALUES ('1003', 'admin', '252');
INSERT INTO `e_role_menu` VALUES ('1004', 'admin', '261');
INSERT INTO `e_role_menu` VALUES ('1005', 'admin', '262');
INSERT INTO `e_role_menu` VALUES ('1006', 'admin', '263');
INSERT INTO `e_role_menu` VALUES ('1007', 'admin', '10');
INSERT INTO `e_role_menu` VALUES ('1008', 'admin', '253');
INSERT INTO `e_role_menu` VALUES ('1009', 'admin', '254');
INSERT INTO `e_role_menu` VALUES ('1010', 'admin', '255');
INSERT INTO `e_role_menu` VALUES ('1011', 'admin', '256');
INSERT INTO `e_role_menu` VALUES ('1012', 'admin', '264');
INSERT INTO `e_role_menu` VALUES ('1013', 'admin', '11');
INSERT INTO `e_role_menu` VALUES ('1017', 'admin', '260');
INSERT INTO `e_role_menu` VALUES ('1018', 'admin', '15');
INSERT INTO `e_role_menu` VALUES ('1019', 'admin', '231');
INSERT INTO `e_role_menu` VALUES ('1020', 'admin', '229');
INSERT INTO `e_role_menu` VALUES ('1021', 'admin', '230');
INSERT INTO `e_role_menu` VALUES ('1022', 'admin', '228');
INSERT INTO `e_role_menu` VALUES ('1023', 'admin', '16');
INSERT INTO `e_role_menu` VALUES ('1024', 'admin', '232');
INSERT INTO `e_role_menu` VALUES ('1025', 'admin', '233');
INSERT INTO `e_role_menu` VALUES ('1026', 'admin', '234');
INSERT INTO `e_role_menu` VALUES ('1027', 'admin', '235');
INSERT INTO `e_role_menu` VALUES ('1028', 'admin', '17');
INSERT INTO `e_role_menu` VALUES ('1029', 'admin', '236');
INSERT INTO `e_role_menu` VALUES ('1030', 'admin', '237');
INSERT INTO `e_role_menu` VALUES ('1031', 'admin', '239');
INSERT INTO `e_role_menu` VALUES ('1032', 'admin', '238');
INSERT INTO `e_role_menu` VALUES ('1033', 'admin', '18');
INSERT INTO `e_role_menu` VALUES ('1034', 'admin', '241');
INSERT INTO `e_role_menu` VALUES ('1035', 'admin', '243');
INSERT INTO `e_role_menu` VALUES ('1036', 'admin', '240');
INSERT INTO `e_role_menu` VALUES ('1037', 'admin', '242');
INSERT INTO `e_role_menu` VALUES ('1038', 'admin', '19');
INSERT INTO `e_role_menu` VALUES ('1039', 'admin', '247');
INSERT INTO `e_role_menu` VALUES ('1040', 'admin', '246');
INSERT INTO `e_role_menu` VALUES ('1041', 'admin', '245');
INSERT INTO `e_role_menu` VALUES ('1042', 'admin', '244');
INSERT INTO `e_role_menu` VALUES ('1043', 'admin', '14');
INSERT INTO `e_role_menu` VALUES ('1044', 'admin', '12');
INSERT INTO `e_role_menu` VALUES ('1045', 'admin', '13');
INSERT INTO `e_role_menu` VALUES ('1046', 'QuotationSystem', '2000');
INSERT INTO `e_role_menu` VALUES ('1048', 'SecuritiesIndustryAs', '2000');
INSERT INTO `e_role_menu` VALUES ('1050', 'QuotationSystem', '1');
INSERT INTO `e_role_menu` VALUES ('1051', 'QuotationSystem', '201');
INSERT INTO `e_role_menu` VALUES ('1052', 'QuotationSystem', '202');
INSERT INTO `e_role_menu` VALUES ('1053', 'QuotationSystem', '203');
INSERT INTO `e_role_menu` VALUES ('1054', 'QuotationSystem', '200');
INSERT INTO `e_role_menu` VALUES ('1055', 'QuotationSystem', '2');
INSERT INTO `e_role_menu` VALUES ('1056', 'QuotationSystem', '204');
INSERT INTO `e_role_menu` VALUES ('1057', 'QuotationSystem', '205');
INSERT INTO `e_role_menu` VALUES ('1058', 'QuotationSystem', '206');
INSERT INTO `e_role_menu` VALUES ('1059', 'QuotationSystem', '207');
INSERT INTO `e_role_menu` VALUES ('1060', 'QuotationSystem', '3');
INSERT INTO `e_role_menu` VALUES ('1061', 'QuotationSystem', '208');
INSERT INTO `e_role_menu` VALUES ('1062', 'QuotationSystem', '209');
INSERT INTO `e_role_menu` VALUES ('1063', 'QuotationSystem', '210');
INSERT INTO `e_role_menu` VALUES ('1064', 'QuotationSystem', '211');
INSERT INTO `e_role_menu` VALUES ('1065', 'QuotationSystem', '4');
INSERT INTO `e_role_menu` VALUES ('1066', 'QuotationSystem', '212');
INSERT INTO `e_role_menu` VALUES ('1067', 'QuotationSystem', '213');
INSERT INTO `e_role_menu` VALUES ('1068', 'QuotationSystem', '214');
INSERT INTO `e_role_menu` VALUES ('1069', 'QuotationSystem', '215');
INSERT INTO `e_role_menu` VALUES ('1070', 'QuotationSystem', '5');
INSERT INTO `e_role_menu` VALUES ('1071', 'QuotationSystem', '216');
INSERT INTO `e_role_menu` VALUES ('1072', 'QuotationSystem', '217');
INSERT INTO `e_role_menu` VALUES ('1073', 'QuotationSystem', '218');
INSERT INTO `e_role_menu` VALUES ('1074', 'QuotationSystem', '219');
INSERT INTO `e_role_menu` VALUES ('1075', 'QuotationSystem', '248');
INSERT INTO `e_role_menu` VALUES ('1076', 'QuotationSystem', '6');
INSERT INTO `e_role_menu` VALUES ('1077', 'QuotationSystem', '220');
INSERT INTO `e_role_menu` VALUES ('1078', 'QuotationSystem', '221');
INSERT INTO `e_role_menu` VALUES ('1079', 'QuotationSystem', '222');
INSERT INTO `e_role_menu` VALUES ('1080', 'QuotationSystem', '223');
INSERT INTO `e_role_menu` VALUES ('1081', 'QuotationSystem', '7');
INSERT INTO `e_role_menu` VALUES ('1082', 'QuotationSystem', '224');
INSERT INTO `e_role_menu` VALUES ('1083', 'QuotationSystem', '225');
INSERT INTO `e_role_menu` VALUES ('1084', 'QuotationSystem', '226');
INSERT INTO `e_role_menu` VALUES ('1085', 'QuotationSystem', '227');
INSERT INTO `e_role_menu` VALUES ('1086', 'QuotationSystem', '9');
INSERT INTO `e_role_menu` VALUES ('1087', 'QuotationSystem', '252');
INSERT INTO `e_role_menu` VALUES ('1088', 'QuotationSystem', '261');
INSERT INTO `e_role_menu` VALUES ('1089', 'QuotationSystem', '262');
INSERT INTO `e_role_menu` VALUES ('1090', 'QuotationSystem', '263');
INSERT INTO `e_role_menu` VALUES ('1091', 'QuotationSystem', '10');
INSERT INTO `e_role_menu` VALUES ('1092', 'QuotationSystem', '253');
INSERT INTO `e_role_menu` VALUES ('1093', 'QuotationSystem', '254');
INSERT INTO `e_role_menu` VALUES ('1094', 'QuotationSystem', '255');
INSERT INTO `e_role_menu` VALUES ('1095', 'QuotationSystem', '256');
INSERT INTO `e_role_menu` VALUES ('1096', 'QuotationSystem', '264');
INSERT INTO `e_role_menu` VALUES ('1097', 'QuotationSystem', '11');
INSERT INTO `e_role_menu` VALUES ('1098', 'QuotationSystem', '260');
INSERT INTO `e_role_menu` VALUES ('1099', 'QuotationSystem', '15');
INSERT INTO `e_role_menu` VALUES ('1100', 'QuotationSystem', '231');
INSERT INTO `e_role_menu` VALUES ('1101', 'QuotationSystem', '229');
INSERT INTO `e_role_menu` VALUES ('1102', 'QuotationSystem', '230');
INSERT INTO `e_role_menu` VALUES ('1103', 'QuotationSystem', '228');
INSERT INTO `e_role_menu` VALUES ('1104', 'QuotationSystem', '16');
INSERT INTO `e_role_menu` VALUES ('1105', 'QuotationSystem', '232');
INSERT INTO `e_role_menu` VALUES ('1106', 'QuotationSystem', '233');
INSERT INTO `e_role_menu` VALUES ('1107', 'QuotationSystem', '234');
INSERT INTO `e_role_menu` VALUES ('1108', 'QuotationSystem', '235');
INSERT INTO `e_role_menu` VALUES ('1109', 'QuotationSystem', '17');
INSERT INTO `e_role_menu` VALUES ('1110', 'QuotationSystem', '236');
INSERT INTO `e_role_menu` VALUES ('1111', 'QuotationSystem', '237');
INSERT INTO `e_role_menu` VALUES ('1112', 'QuotationSystem', '239');
INSERT INTO `e_role_menu` VALUES ('1113', 'QuotationSystem', '238');
INSERT INTO `e_role_menu` VALUES ('1114', 'QuotationSystem', '18');
INSERT INTO `e_role_menu` VALUES ('1115', 'QuotationSystem', '241');
INSERT INTO `e_role_menu` VALUES ('1116', 'QuotationSystem', '243');
INSERT INTO `e_role_menu` VALUES ('1117', 'QuotationSystem', '240');
INSERT INTO `e_role_menu` VALUES ('1118', 'QuotationSystem', '242');
INSERT INTO `e_role_menu` VALUES ('1119', 'QuotationSystem', '19');
INSERT INTO `e_role_menu` VALUES ('1120', 'QuotationSystem', '247');
INSERT INTO `e_role_menu` VALUES ('1121', 'QuotationSystem', '246');
INSERT INTO `e_role_menu` VALUES ('1122', 'QuotationSystem', '245');
INSERT INTO `e_role_menu` VALUES ('1123', 'QuotationSystem', '244');
INSERT INTO `e_role_menu` VALUES ('1124', 'QuotationSystem', '14');
INSERT INTO `e_role_menu` VALUES ('1125', 'QuotationSystem', '12');
INSERT INTO `e_role_menu` VALUES ('1126', 'QuotationSystem', '13');
INSERT INTO `e_role_menu` VALUES ('1204', 'QuotationSystem', '250');
INSERT INTO `e_role_menu` VALUES ('1205', 'QuotationSystem', '251');
INSERT INTO `e_role_menu` VALUES ('1206', 'SecuritiesIndustryAs', '1');
INSERT INTO `e_role_menu` VALUES ('1209', 'SecuritiesIndustryAs', '203');
INSERT INTO `e_role_menu` VALUES ('1211', 'SecuritiesIndustryAs', '2');
INSERT INTO `e_role_menu` VALUES ('1215', 'SecuritiesIndustryAs', '207');
INSERT INTO `e_role_menu` VALUES ('1216', 'SecuritiesIndustryAs', '3');
INSERT INTO `e_role_menu` VALUES ('1217', 'SecuritiesIndustryAs', '208');
INSERT INTO `e_role_menu` VALUES ('1218', 'SecuritiesIndustryAs', '209');
INSERT INTO `e_role_menu` VALUES ('1219', 'SecuritiesIndustryAs', '210');
INSERT INTO `e_role_menu` VALUES ('1220', 'SecuritiesIndustryAs', '211');
INSERT INTO `e_role_menu` VALUES ('1221', 'SecuritiesIndustryAs', '4');
INSERT INTO `e_role_menu` VALUES ('1225', 'SecuritiesIndustryAs', '215');
INSERT INTO `e_role_menu` VALUES ('1226', 'SecuritiesIndustryAs', '5');
INSERT INTO `e_role_menu` VALUES ('1230', 'SecuritiesIndustryAs', '219');
INSERT INTO `e_role_menu` VALUES ('1232', 'SecuritiesIndustryAs', '6');
INSERT INTO `e_role_menu` VALUES ('1233', 'SecuritiesIndustryAs', '220');
INSERT INTO `e_role_menu` VALUES ('1234', 'SecuritiesIndustryAs', '221');
INSERT INTO `e_role_menu` VALUES ('1235', 'SecuritiesIndustryAs', '222');
INSERT INTO `e_role_menu` VALUES ('1236', 'SecuritiesIndustryAs', '223');
INSERT INTO `e_role_menu` VALUES ('1237', 'SecuritiesIndustryAs', '7');
INSERT INTO `e_role_menu` VALUES ('1241', 'SecuritiesIndustryAs', '227');
INSERT INTO `e_role_menu` VALUES ('1258', 'SecuritiesIndustryAs', '15');
INSERT INTO `e_role_menu` VALUES ('1259', 'SecuritiesIndustryAs', '231');
INSERT INTO `e_role_menu` VALUES ('1263', 'SecuritiesIndustryAs', '16');
INSERT INTO `e_role_menu` VALUES ('1264', 'SecuritiesIndustryAs', '232');
INSERT INTO `e_role_menu` VALUES ('1265', 'SecuritiesIndustryAs', '233');
INSERT INTO `e_role_menu` VALUES ('1266', 'SecuritiesIndustryAs', '234');
INSERT INTO `e_role_menu` VALUES ('1267', 'SecuritiesIndustryAs', '235');
INSERT INTO `e_role_menu` VALUES ('1268', 'SecuritiesIndustryAs', '18');
INSERT INTO `e_role_menu` VALUES ('1270', 'SecuritiesIndustryAs', '243');
INSERT INTO `e_role_menu` VALUES ('1273', 'SecuritiesIndustryAs', '19');
INSERT INTO `e_role_menu` VALUES ('1274', 'SecuritiesIndustryAs', '247');
INSERT INTO `e_role_menu` VALUES ('1275', 'SecuritiesIndustryAs', '246');
INSERT INTO `e_role_menu` VALUES ('1276', 'SecuritiesIndustryAs', '245');
INSERT INTO `e_role_menu` VALUES ('1277', 'SecuritiesIndustryAs', '244');
INSERT INTO `e_role_menu` VALUES ('1497', 'admin', '200');
INSERT INTO `e_role_menu` VALUES ('1500', 'shenhe', '3000');
INSERT INTO `e_role_menu` VALUES ('1501', 'shenhe', '13');
INSERT INTO `e_role_menu` VALUES ('1503', 'admin', '265');
INSERT INTO `e_role_menu` VALUES ('1509', 'QuotationSystem', '266');
INSERT INTO `e_role_menu` VALUES ('1510', 'shenhe', '265');
INSERT INTO `e_role_menu` VALUES ('1544', 'admin', '266');
INSERT INTO `e_role_menu` VALUES ('1545', 'QuotationSystem', '268');
INSERT INTO `e_role_menu` VALUES ('1546', 'admin', '268');
INSERT INTO `e_role_menu` VALUES ('1547', 'SecuritiesIndustryAs', '17');
INSERT INTO `e_role_menu` VALUES ('1550', 'SecuritiesIndustryAs', '239');
INSERT INTO `e_role_menu` VALUES ('1552', 'SecuritiesIndustryAs', '214');
INSERT INTO `e_role_menu` VALUES ('1553', 'SecuritiesIndustryAs', '216');
INSERT INTO `e_role_menu` VALUES ('1554', 'SecuritiesIndustryAs', '218');
INSERT INTO `e_role_menu` VALUES ('1555', 'SecuritiesIndustryAs', '238');
INSERT INTO `e_role_menu` VALUES ('1556', 'SecuritiesIndustryAs', '240');
INSERT INTO `e_role_menu` VALUES ('1557', 'SecuritiesIndustryAs', '242');
INSERT INTO `e_role_menu` VALUES ('1558', 'SecuritiesIndustryAs', '248');
INSERT INTO `e_role_menu` VALUES ('1559', 'SecuritiesIndustryAs', '267');
INSERT INTO `e_role_menu` VALUES ('1560', 'shangjiaosuo', '2000');
INSERT INTO `e_role_menu` VALUES ('1561', 'shangjiaosuo', '1');
INSERT INTO `e_role_menu` VALUES ('1562', 'shangjiaosuo', '203');
INSERT INTO `e_role_menu` VALUES ('1563', 'shangjiaosuo', '2');
INSERT INTO `e_role_menu` VALUES ('1564', 'shangjiaosuo', '207');
INSERT INTO `e_role_menu` VALUES ('1565', 'shangjiaosuo', '4');
INSERT INTO `e_role_menu` VALUES ('1566', 'shangjiaosuo', '214');
INSERT INTO `e_role_menu` VALUES ('1567', 'shangjiaosuo', '215');
INSERT INTO `e_role_menu` VALUES ('1568', 'shangjiaosuo', '5');
INSERT INTO `e_role_menu` VALUES ('1569', 'shangjiaosuo', '216');
INSERT INTO `e_role_menu` VALUES ('1570', 'shangjiaosuo', '218');
INSERT INTO `e_role_menu` VALUES ('1571', 'shangjiaosuo', '219');
INSERT INTO `e_role_menu` VALUES ('1572', 'shangjiaosuo', '6');
INSERT INTO `e_role_menu` VALUES ('1573', 'shangjiaosuo', '220');
INSERT INTO `e_role_menu` VALUES ('1574', 'shangjiaosuo', '221');
INSERT INTO `e_role_menu` VALUES ('1575', 'shangjiaosuo', '222');
INSERT INTO `e_role_menu` VALUES ('1576', 'shangjiaosuo', '223');
INSERT INTO `e_role_menu` VALUES ('1577', 'shangjiaosuo', '7');
INSERT INTO `e_role_menu` VALUES ('1578', 'shangjiaosuo', '227');
INSERT INTO `e_role_menu` VALUES ('1579', 'shangjiaosuo', '15');
INSERT INTO `e_role_menu` VALUES ('1580', 'shangjiaosuo', '231');
INSERT INTO `e_role_menu` VALUES ('1581', 'shangjiaosuo', '17');
INSERT INTO `e_role_menu` VALUES ('1582', 'shangjiaosuo', '239');
INSERT INTO `e_role_menu` VALUES ('1583', 'shangjiaosuo', '238');
INSERT INTO `e_role_menu` VALUES ('1584', 'shangjiaosuo', '18');
INSERT INTO `e_role_menu` VALUES ('1585', 'shangjiaosuo', '243');
INSERT INTO `e_role_menu` VALUES ('1586', 'shangjiaosuo', '240');
INSERT INTO `e_role_menu` VALUES ('1587', 'shangjiaosuo', '242');
INSERT INTO `e_role_menu` VALUES ('1588', 'shangjiaosuo', '19');
INSERT INTO `e_role_menu` VALUES ('1589', 'shangjiaosuo', '247');
INSERT INTO `e_role_menu` VALUES ('1590', 'shangjiaosuo', '246');
INSERT INTO `e_role_menu` VALUES ('1591', 'shangjiaosuo', '245');
INSERT INTO `e_role_menu` VALUES ('1592', 'shangjiaosuo', '244');
INSERT INTO `e_role_menu` VALUES ('1593', 'shenjiaosuo', '2000');
INSERT INTO `e_role_menu` VALUES ('1594', 'shenjiaosuo', '1');
INSERT INTO `e_role_menu` VALUES ('1595', 'shenjiaosuo', '203');
INSERT INTO `e_role_menu` VALUES ('1596', 'shenjiaosuo', '2');
INSERT INTO `e_role_menu` VALUES ('1597', 'shenjiaosuo', '207');
INSERT INTO `e_role_menu` VALUES ('1598', 'shenjiaosuo', '4');
INSERT INTO `e_role_menu` VALUES ('1599', 'shenjiaosuo', '214');
INSERT INTO `e_role_menu` VALUES ('1600', 'shenjiaosuo', '215');
INSERT INTO `e_role_menu` VALUES ('1601', 'shenjiaosuo', '5');
INSERT INTO `e_role_menu` VALUES ('1602', 'shenjiaosuo', '216');
INSERT INTO `e_role_menu` VALUES ('1603', 'shenjiaosuo', '218');
INSERT INTO `e_role_menu` VALUES ('1604', 'shenjiaosuo', '219');
INSERT INTO `e_role_menu` VALUES ('1605', 'shenjiaosuo', '6');
INSERT INTO `e_role_menu` VALUES ('1606', 'shenjiaosuo', '220');
INSERT INTO `e_role_menu` VALUES ('1607', 'shenjiaosuo', '221');
INSERT INTO `e_role_menu` VALUES ('1608', 'shenjiaosuo', '222');
INSERT INTO `e_role_menu` VALUES ('1609', 'shenjiaosuo', '223');
INSERT INTO `e_role_menu` VALUES ('1610', 'shenjiaosuo', '7');
INSERT INTO `e_role_menu` VALUES ('1611', 'shenjiaosuo', '227');
INSERT INTO `e_role_menu` VALUES ('1612', 'shenjiaosuo', '15');
INSERT INTO `e_role_menu` VALUES ('1613', 'shenjiaosuo', '231');
INSERT INTO `e_role_menu` VALUES ('1614', 'shenjiaosuo', '17');
INSERT INTO `e_role_menu` VALUES ('1615', 'shenjiaosuo', '239');
INSERT INTO `e_role_menu` VALUES ('1616', 'shenjiaosuo', '238');
INSERT INTO `e_role_menu` VALUES ('1617', 'shenjiaosuo', '18');
INSERT INTO `e_role_menu` VALUES ('1618', 'shenjiaosuo', '243');
INSERT INTO `e_role_menu` VALUES ('1619', 'shenjiaosuo', '240');
INSERT INTO `e_role_menu` VALUES ('1620', 'shenjiaosuo', '242');
INSERT INTO `e_role_menu` VALUES ('1621', 'shenjiaosuo', '19');
INSERT INTO `e_role_menu` VALUES ('1622', 'shenjiaosuo', '247');
INSERT INTO `e_role_menu` VALUES ('1623', 'shenjiaosuo', '246');
INSERT INTO `e_role_menu` VALUES ('1624', 'shenjiaosuo', '245');
INSERT INTO `e_role_menu` VALUES ('1625', 'shenjiaosuo', '244');
INSERT INTO `e_role_menu` VALUES ('1626', 'beijing', '2001');
INSERT INTO `e_role_menu` VALUES ('1627', 'beijing', '1');
INSERT INTO `e_role_menu` VALUES ('1628', 'beijing', '203');
INSERT INTO `e_role_menu` VALUES ('1629', 'beijing', '2');
INSERT INTO `e_role_menu` VALUES ('1630', 'beijing', '207');
INSERT INTO `e_role_menu` VALUES ('1631', 'beijing', '4');
INSERT INTO `e_role_menu` VALUES ('1632', 'beijing', '214');
INSERT INTO `e_role_menu` VALUES ('1633', 'beijing', '215');
INSERT INTO `e_role_menu` VALUES ('1634', 'beijing', '5');
INSERT INTO `e_role_menu` VALUES ('1635', 'beijing', '216');
INSERT INTO `e_role_menu` VALUES ('1636', 'beijing', '218');
INSERT INTO `e_role_menu` VALUES ('1637', 'beijing', '219');
INSERT INTO `e_role_menu` VALUES ('1638', 'beijing', '6');
INSERT INTO `e_role_menu` VALUES ('1639', 'beijing', '220');
INSERT INTO `e_role_menu` VALUES ('1640', 'beijing', '221');
INSERT INTO `e_role_menu` VALUES ('1641', 'beijing', '222');
INSERT INTO `e_role_menu` VALUES ('1642', 'beijing', '223');
INSERT INTO `e_role_menu` VALUES ('1643', 'beijing', '7');
INSERT INTO `e_role_menu` VALUES ('1644', 'beijing', '227');
INSERT INTO `e_role_menu` VALUES ('1645', 'beijing', '15');
INSERT INTO `e_role_menu` VALUES ('1646', 'beijing', '231');
INSERT INTO `e_role_menu` VALUES ('1647', 'beijing', '17');
INSERT INTO `e_role_menu` VALUES ('1648', 'beijing', '239');
INSERT INTO `e_role_menu` VALUES ('1649', 'beijing', '238');
INSERT INTO `e_role_menu` VALUES ('1650', 'beijing', '18');
INSERT INTO `e_role_menu` VALUES ('1651', 'beijing', '243');
INSERT INTO `e_role_menu` VALUES ('1652', 'beijing', '240');
INSERT INTO `e_role_menu` VALUES ('1653', 'beijing', '242');
INSERT INTO `e_role_menu` VALUES ('1654', 'beijing', '19');
INSERT INTO `e_role_menu` VALUES ('1655', 'beijing', '247');
INSERT INTO `e_role_menu` VALUES ('1656', 'beijing', '246');
INSERT INTO `e_role_menu` VALUES ('1657', 'beijing', '245');
INSERT INTO `e_role_menu` VALUES ('1658', 'beijing', '244');
INSERT INTO `e_role_menu` VALUES ('1659', 'shangjiaosuo', '217');
INSERT INTO `e_role_menu` VALUES ('1660', 'shangjiaosuo', '248');
INSERT INTO `e_role_menu` VALUES ('1661', 'shangjiaosuo', '236');
INSERT INTO `e_role_menu` VALUES ('1662', 'shangjiaosuo', '237');
INSERT INTO `e_role_menu` VALUES ('1663', 'shangjiaosuo', '241');
INSERT INTO `e_role_menu` VALUES ('1664', 'shangjiaosuo', '267');
INSERT INTO `e_role_menu` VALUES ('1672', 'SecuritiesIndustryAs', '212');
INSERT INTO `e_role_menu` VALUES ('1673', 'SecuritiesIndustryAs', '213');
INSERT INTO `e_role_menu` VALUES ('1674', 'SecuritiesIndustryAs', '217');
INSERT INTO `e_role_menu` VALUES ('1675', 'SecuritiesIndustryAs', '236');
INSERT INTO `e_role_menu` VALUES ('1676', 'SecuritiesIndustryAs', '237');
INSERT INTO `e_role_menu` VALUES ('1677', 'SecuritiesIndustryAs', '241');
INSERT INTO `e_role_menu` VALUES ('1678', 'shenjiaosuo', '212');
INSERT INTO `e_role_menu` VALUES ('1679', 'shenjiaosuo', '213');
INSERT INTO `e_role_menu` VALUES ('1680', 'shenjiaosuo', '217');
INSERT INTO `e_role_menu` VALUES ('1681', 'shenjiaosuo', '248');
INSERT INTO `e_role_menu` VALUES ('1682', 'shenjiaosuo', '236');
INSERT INTO `e_role_menu` VALUES ('1683', 'shenjiaosuo', '237');
INSERT INTO `e_role_menu` VALUES ('1684', 'shenjiaosuo', '267');
INSERT INTO `e_role_menu` VALUES ('1774', 'dalian', '2011');
INSERT INTO `e_role_menu` VALUES ('1775', 'dalian', '1');
INSERT INTO `e_role_menu` VALUES ('1776', 'dalian', '203');
INSERT INTO `e_role_menu` VALUES ('1777', 'dalian', '2');
INSERT INTO `e_role_menu` VALUES ('1778', 'dalian', '207');
INSERT INTO `e_role_menu` VALUES ('1779', 'dalian', '4');
INSERT INTO `e_role_menu` VALUES ('1780', 'dalian', '214');
INSERT INTO `e_role_menu` VALUES ('1781', 'dalian', '215');
INSERT INTO `e_role_menu` VALUES ('1782', 'dalian', '5');
INSERT INTO `e_role_menu` VALUES ('1783', 'dalian', '216');
INSERT INTO `e_role_menu` VALUES ('1784', 'dalian', '218');
INSERT INTO `e_role_menu` VALUES ('1785', 'dalian', '219');
INSERT INTO `e_role_menu` VALUES ('1786', 'dalian', '6');
INSERT INTO `e_role_menu` VALUES ('1787', 'dalian', '220');
INSERT INTO `e_role_menu` VALUES ('1788', 'dalian', '221');
INSERT INTO `e_role_menu` VALUES ('1789', 'dalian', '222');
INSERT INTO `e_role_menu` VALUES ('1790', 'dalian', '223');
INSERT INTO `e_role_menu` VALUES ('1791', 'dalian', '7');
INSERT INTO `e_role_menu` VALUES ('1792', 'dalian', '227');
INSERT INTO `e_role_menu` VALUES ('1793', 'dalian', '15');
INSERT INTO `e_role_menu` VALUES ('1794', 'dalian', '231');
INSERT INTO `e_role_menu` VALUES ('1795', 'dalian', '17');
INSERT INTO `e_role_menu` VALUES ('1796', 'dalian', '239');
INSERT INTO `e_role_menu` VALUES ('1797', 'dalian', '238');
INSERT INTO `e_role_menu` VALUES ('1798', 'dalian', '18');
INSERT INTO `e_role_menu` VALUES ('1799', 'dalian', '243');
INSERT INTO `e_role_menu` VALUES ('1800', 'dalian', '240');
INSERT INTO `e_role_menu` VALUES ('1801', 'dalian', '242');
INSERT INTO `e_role_menu` VALUES ('1802', 'dalian', '19');
INSERT INTO `e_role_menu` VALUES ('1803', 'dalian', '247');
INSERT INTO `e_role_menu` VALUES ('1804', 'dalian', '246');
INSERT INTO `e_role_menu` VALUES ('1805', 'dalian', '245');
INSERT INTO `e_role_menu` VALUES ('1806', 'dalian', '244');
INSERT INTO `e_role_menu` VALUES ('1807', 'BondDepartment', '2000');
INSERT INTO `e_role_menu` VALUES ('1808', 'BondDepartment', '1');
INSERT INTO `e_role_menu` VALUES ('1809', 'BondDepartment', '203');
INSERT INTO `e_role_menu` VALUES ('1810', 'BondDepartment', '2');
INSERT INTO `e_role_menu` VALUES ('1811', 'BondDepartment', '207');
INSERT INTO `e_role_menu` VALUES ('1812', 'BondDepartment', '4');
INSERT INTO `e_role_menu` VALUES ('1813', 'BondDepartment', '212');
INSERT INTO `e_role_menu` VALUES ('1814', 'BondDepartment', '213');
INSERT INTO `e_role_menu` VALUES ('1815', 'BondDepartment', '214');
INSERT INTO `e_role_menu` VALUES ('1816', 'BondDepartment', '215');
INSERT INTO `e_role_menu` VALUES ('1817', 'BondDepartment', '5');
INSERT INTO `e_role_menu` VALUES ('1818', 'BondDepartment', '216');
INSERT INTO `e_role_menu` VALUES ('1819', 'BondDepartment', '217');
INSERT INTO `e_role_menu` VALUES ('1820', 'BondDepartment', '218');
INSERT INTO `e_role_menu` VALUES ('1821', 'BondDepartment', '219');
INSERT INTO `e_role_menu` VALUES ('1822', 'BondDepartment', '248');
INSERT INTO `e_role_menu` VALUES ('1823', 'BondDepartment', '6');
INSERT INTO `e_role_menu` VALUES ('1824', 'BondDepartment', '220');
INSERT INTO `e_role_menu` VALUES ('1825', 'BondDepartment', '221');
INSERT INTO `e_role_menu` VALUES ('1826', 'BondDepartment', '222');
INSERT INTO `e_role_menu` VALUES ('1827', 'BondDepartment', '223');
INSERT INTO `e_role_menu` VALUES ('1828', 'BondDepartment', '7');
INSERT INTO `e_role_menu` VALUES ('1829', 'BondDepartment', '227');
INSERT INTO `e_role_menu` VALUES ('1830', 'BondDepartment', '15');
INSERT INTO `e_role_menu` VALUES ('1831', 'BondDepartment', '231');
INSERT INTO `e_role_menu` VALUES ('1832', 'BondDepartment', '17');
INSERT INTO `e_role_menu` VALUES ('1833', 'BondDepartment', '236');
INSERT INTO `e_role_menu` VALUES ('1834', 'BondDepartment', '237');
INSERT INTO `e_role_menu` VALUES ('1835', 'BondDepartment', '239');
INSERT INTO `e_role_menu` VALUES ('1836', 'BondDepartment', '238');
INSERT INTO `e_role_menu` VALUES ('1837', 'BondDepartment', '18');
INSERT INTO `e_role_menu` VALUES ('1838', 'BondDepartment', '241');
INSERT INTO `e_role_menu` VALUES ('1839', 'BondDepartment', '243');
INSERT INTO `e_role_menu` VALUES ('1840', 'BondDepartment', '240');
INSERT INTO `e_role_menu` VALUES ('1841', 'BondDepartment', '242');
INSERT INTO `e_role_menu` VALUES ('1842', 'BondDepartment', '267');
INSERT INTO `e_role_menu` VALUES ('1843', 'BondDepartment', '19');
INSERT INTO `e_role_menu` VALUES ('1844', 'BondDepartment', '247');
INSERT INTO `e_role_menu` VALUES ('1845', 'BondDepartment', '246');
INSERT INTO `e_role_menu` VALUES ('1846', 'BondDepartment', '245');
INSERT INTO `e_role_menu` VALUES ('1847', 'BondDepartment', '244');
INSERT INTO `e_role_menu` VALUES ('1849', 'jiangsu', '2019');
INSERT INTO `e_role_menu` VALUES ('1850', 'jiangsu', '1');
INSERT INTO `e_role_menu` VALUES ('1851', 'jiangsu', '203');
INSERT INTO `e_role_menu` VALUES ('1852', 'jiangsu', '2');
INSERT INTO `e_role_menu` VALUES ('1853', 'jiangsu', '207');
INSERT INTO `e_role_menu` VALUES ('1854', 'jiangsu', '4');
INSERT INTO `e_role_menu` VALUES ('1855', 'jiangsu', '214');
INSERT INTO `e_role_menu` VALUES ('1856', 'jiangsu', '215');
INSERT INTO `e_role_menu` VALUES ('1857', 'jiangsu', '5');
INSERT INTO `e_role_menu` VALUES ('1858', 'jiangsu', '216');
INSERT INTO `e_role_menu` VALUES ('1859', 'jiangsu', '218');
INSERT INTO `e_role_menu` VALUES ('1860', 'jiangsu', '219');
INSERT INTO `e_role_menu` VALUES ('1861', 'jiangsu', '6');
INSERT INTO `e_role_menu` VALUES ('1862', 'jiangsu', '223');
INSERT INTO `e_role_menu` VALUES ('1863', 'jiangsu', '7');
INSERT INTO `e_role_menu` VALUES ('1864', 'jiangsu', '227');
INSERT INTO `e_role_menu` VALUES ('1865', 'jiangsu', '15');
INSERT INTO `e_role_menu` VALUES ('1866', 'jiangsu', '231');
INSERT INTO `e_role_menu` VALUES ('1867', 'jiangsu', '17');
INSERT INTO `e_role_menu` VALUES ('1868', 'jiangsu', '239');
INSERT INTO `e_role_menu` VALUES ('1869', 'jiangsu', '238');
INSERT INTO `e_role_menu` VALUES ('1870', 'jiangsu', '18');
INSERT INTO `e_role_menu` VALUES ('1871', 'jiangsu', '243');
INSERT INTO `e_role_menu` VALUES ('1872', 'jiangsu', '240');
INSERT INTO `e_role_menu` VALUES ('1873', 'jiangsu', '242');
INSERT INTO `e_role_menu` VALUES ('1874', 'jiangsu', '19');
INSERT INTO `e_role_menu` VALUES ('1875', 'jiangsu', '244');
INSERT INTO `e_role_menu` VALUES ('1877', 'zyc1', '2000');
INSERT INTO `e_role_menu` VALUES ('1895', 'zyc', '2000');
INSERT INTO `e_role_menu` VALUES ('1896', 'zyc', '1');
INSERT INTO `e_role_menu` VALUES ('1897', 'zyc', '201');
INSERT INTO `e_role_menu` VALUES ('1898', 'zyc', '202');
INSERT INTO `e_role_menu` VALUES ('1899', 'zyc', '203');
INSERT INTO `e_role_menu` VALUES ('1900', 'zyc', '200');
INSERT INTO `e_role_menu` VALUES ('1901', 'zyc', '2');
INSERT INTO `e_role_menu` VALUES ('1902', 'zyc', '204');
INSERT INTO `e_role_menu` VALUES ('1903', 'zyc', '205');
INSERT INTO `e_role_menu` VALUES ('1904', 'zyc', '206');
INSERT INTO `e_role_menu` VALUES ('1905', 'zyc', '207');
INSERT INTO `e_role_menu` VALUES ('1906', 'zyc', '4');
INSERT INTO `e_role_menu` VALUES ('1907', 'zyc', '212');
INSERT INTO `e_role_menu` VALUES ('1908', 'zyc', '213');
INSERT INTO `e_role_menu` VALUES ('1909', 'zyc', '214');
INSERT INTO `e_role_menu` VALUES ('1910', 'zyc', '215');
INSERT INTO `e_role_menu` VALUES ('1930', 'zyvv', '2000');
INSERT INTO `e_role_menu` VALUES ('1931', 'zyvv', '1');
INSERT INTO `e_role_menu` VALUES ('1932', 'zyvv', '201');

-- ----------------------------
-- Table structure for e_user
-- ----------------------------
DROP TABLE IF EXISTS `e_user`;
CREATE TABLE `e_user` (
  `usernum` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `emil` varchar(50) DEFAULT NULL,
  `organizationame` varchar(50) DEFAULT NULL,
  `organizationtype` varchar(50) DEFAULT NULL,
  `usertype` varchar(50) DEFAULT NULL,
  `userstate` varchar(20) DEFAULT NULL,
  `registime` datetime DEFAULT NULL,
  `endlogintime` datetime DEFAULT NULL,
  PRIMARY KEY (`usernum`),
  KEY `userNum` (`usernum`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user
-- ----------------------------
INSERT INTO `e_user` VALUES ('1', 'admin', 'q1w2e3r4', '', '系统管理员', '中证报价', '系统管理员', '有效用户', null, null);
INSERT INTO `e_user` VALUES ('31', 'G10001B01', 'q1w2e3r4', '', '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('32', 'G10001B02', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('33', 'G10001B03', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('34', 'G10001B04', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('35', 'G10001B05', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('36', 'G10001B06', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('37', 'G10001B07', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('38', 'G10001B08', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('39', 'G10001B09', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('40', 'G10001B10', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('41', 'G10001B11', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('42', 'G10001B12', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('43', 'G10001B13', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('44', 'G10001B14', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('45', 'G10001B15', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('46', 'G10001B16', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('47', 'G10001B17', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('48', 'G10001B18', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('49', 'G10001B19', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('50', 'G10001B20', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('51', 'G10001B21', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('52', 'G10001B22', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('53', 'G10001B23', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('54', 'G10001B24', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('55', 'G10001B25', '111111', null, '债券部', '证监会债券部', null, null, null, null);
INSERT INTO `e_user` VALUES ('56', 'G10002B01', '111111', '', '协会', '证券业协会', null, null, null, null);
INSERT INTO `e_user` VALUES ('57', 'G10002B02', '111111', '', '协会', '证券业协会', null, null, null, null);
INSERT INTO `e_user` VALUES ('60', 'G10003B01', '111111', null, '基金业协会', '证券业协会', null, null, null, null);
INSERT INTO `e_user` VALUES ('61', 'G10003B02', '111111', null, '基金业协会', '证券业协会', null, null, null, null);
INSERT INTO `e_user` VALUES ('62', 'G11001B01', '111111', null, '北京证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('63', 'G11001B02', '111111', null, '北京证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('64', 'G11002B01', '111111', null, '天津证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('65', 'G11002B02', '111111', null, '天津证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('66', 'G11003B01', '111111', null, '河北证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('67', 'G11003B02', '111111', null, '河北证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('68', 'G11004B01', '111111', null, '山西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('69', 'G11004B02', '111111', null, '山西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('70', 'G11005B01', '111111', null, '内蒙古证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('71', 'G11005B02', '111111', null, '内蒙古证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('72', 'G11006B01', '111111', null, '辽宁证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('73', 'G11006B02', '111111', null, '辽宁证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('74', 'G11007B01', '111111', null, '吉林证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('75', 'G11007B02', '111111', null, '吉林证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('76', 'G11008B01', '111111', null, '黑龙江证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('77', 'G11008B02', '111111', null, '黑龙江证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('78', 'G11009B01', '111111', null, '上海证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('79', 'G11009B02', '111111', null, '上海证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('80', 'G11010B01', '111111', null, '江苏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('81', 'G11010B02', '111111', null, '江苏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('82', 'G11011B01', '111111', null, '浙江证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('83', 'G11011B02', '111111', null, '浙江证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('84', 'G11012B01', '111111', null, '安徽证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('85', 'G11012B02', '111111', null, '安徽证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('86', 'G11013B01', '111111', null, '福建证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('87', 'G11013B02', '111111', null, '福建证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('88', 'G11014B01', '111111', null, '江西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('89', 'G11014B02', '111111', null, '江西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('90', 'G11015B01', '111111', null, '山东证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('91', 'G11015B02', '111111', null, '山东证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('92', 'G11016B01', '111111', null, '河南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('93', 'G11016B02', '111111', null, '河南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('94', 'G11017B01', '111111', null, '湖北证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('95', 'G11017B02', '111111', null, '湖北证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('96', 'G11018B01', '111111', null, '湖南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('97', 'G11018B02', '111111', null, '湖南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('98', 'G11019B01', '111111', null, '广东证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('99', 'G11019B02', '111111', null, '广东证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('100', 'G11020B01', '111111', null, '广西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('101', 'G11020B02', '111111', null, '广西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('102', 'G11021B01', '111111', null, '海南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('103', 'G11021B02', '111111', null, '海南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('104', 'G11022B01', '111111', null, '重庆证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('105', 'G11022B02', '111111', null, '重庆证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('106', 'G11023B01', '111111', null, '四川证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('107', 'G11023B02', '111111', null, '四川证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('108', 'G11024B01', '111111', null, '贵州证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('109', 'G11024B02', '111111', null, '贵州证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('110', 'G11025B01', '111111', null, '云南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('111', 'G11025B02', '111111', null, '云南证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('112', 'G11026B01', '111111', null, '西藏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('113', 'G11026B02', '111111', null, '西藏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('114', 'G11027B01', '111111', null, '陕西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('115', 'G11027B02', '111111', null, '陕西证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('116', 'G11028B01', '111111', null, '甘肃证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('117', 'G11028B02', '111111', null, '甘肃证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('118', 'G11029B01', '111111', null, '青海证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('119', 'G11029B02', '111111', null, '青海证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('120', 'G11030B01', '111111', null, '宁夏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('121', 'G11030B02', '111111', null, '宁夏证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('122', 'G11031B01', '111111', null, '新疆证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('123', 'G11031B02', '111111', null, '新疆证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('124', 'G11032B01', '111111', null, '深圳证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('125', 'G11032B02', '111111', null, '深圳证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('126', 'G11033B01', '111111', null, '大连证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('127', 'G11033B02', '111111', null, '大连证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('128', 'G11034B01', '111111', null, '宁波证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('129', 'G11034B02', '111111', null, '宁波证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('130', 'G11035B01', '111111', null, '厦门证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('131', 'G11035B02', '111111', null, '厦门证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('132', 'G11036B01', '111111', null, '青岛证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('133', 'G11036B02', '111111', null, '青岛证监局', '证监局', null, null, null, null);
INSERT INTO `e_user` VALUES ('134', 'G11037B01', '111111', null, '上海证券交易所', '交易所', null, null, null, null);
INSERT INTO `e_user` VALUES ('135', 'G11037B02', '111111', null, '上海证券交易所', '交易所', null, null, null, null);
INSERT INTO `e_user` VALUES ('136', 'G11038B02', '111111', null, '深圳证券交易所', '交易所', null, null, null, null);
INSERT INTO `e_user` VALUES ('137', 'G11038B01', '111111', null, '深圳证券交易所', '交易所', null, null, null, null);
INSERT INTO `e_user` VALUES ('138', 'G11039B01', '111111', null, '中国证券登记结算', '中国结算', null, null, null, null);
INSERT INTO `e_user` VALUES ('139', 'G11039B02', '111111', null, '中国证券登记结算', '中国结算', null, null, null, null);
INSERT INTO `e_user` VALUES ('140', 'zyc1', '111111', '111', 'ceshi', '中证报价', null, null, null, null);
INSERT INTO `e_user` VALUES ('141', '1111', '111111', '1', '1', '中证报价', null, null, null, null);
INSERT INTO `e_user` VALUES ('142', 'ceshi', 'q1w2e3r4', '1', '121', '中证报价', null, null, null, null);
INSERT INTO `e_user` VALUES ('143', 'shenhe', 'q1w2e3r4', '1@1.com', '审核', '中证报价', null, null, null, null);

-- ----------------------------
-- Table structure for e_user_role
-- ----------------------------
DROP TABLE IF EXISTS `e_user_role`;
CREATE TABLE `e_user_role` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `uid` int(10) DEFAULT NULL,
  `roleid` int(10) DEFAULT NULL,
  `roleCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`) USING BTREE,
  KEY `roleid` (`roleid`) USING BTREE,
  CONSTRAINT `e_user_role_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `e_role` (`rolenum`),
  CONSTRAINT `e_user_role_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `e_user` (`usernum`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=387 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user_role
-- ----------------------------
INSERT INTO `e_user_role` VALUES ('240', '1', '15', null);
INSERT INTO `e_user_role` VALUES ('275', '32', '19', null);
INSERT INTO `e_user_role` VALUES ('276', '31', '19', null);
INSERT INTO `e_user_role` VALUES ('277', '34', '19', null);
INSERT INTO `e_user_role` VALUES ('278', '33', '19', null);
INSERT INTO `e_user_role` VALUES ('279', '35', '19', null);
INSERT INTO `e_user_role` VALUES ('280', '36', '19', null);
INSERT INTO `e_user_role` VALUES ('281', '37', '19', null);
INSERT INTO `e_user_role` VALUES ('282', '38', '19', null);
INSERT INTO `e_user_role` VALUES ('283', '39', '19', null);
INSERT INTO `e_user_role` VALUES ('284', '40', '19', null);
INSERT INTO `e_user_role` VALUES ('285', '41', '19', null);
INSERT INTO `e_user_role` VALUES ('286', '42', '19', null);
INSERT INTO `e_user_role` VALUES ('287', '43', '19', null);
INSERT INTO `e_user_role` VALUES ('288', '44', '19', null);
INSERT INTO `e_user_role` VALUES ('289', '45', '19', null);
INSERT INTO `e_user_role` VALUES ('290', '46', '19', null);
INSERT INTO `e_user_role` VALUES ('291', '47', '19', null);
INSERT INTO `e_user_role` VALUES ('292', '48', '19', null);
INSERT INTO `e_user_role` VALUES ('293', '49', '19', null);
INSERT INTO `e_user_role` VALUES ('294', '50', '19', null);
INSERT INTO `e_user_role` VALUES ('295', '51', '19', null);
INSERT INTO `e_user_role` VALUES ('296', '52', '19', null);
INSERT INTO `e_user_role` VALUES ('297', '53', '19', null);
INSERT INTO `e_user_role` VALUES ('298', '54', '19', null);
INSERT INTO `e_user_role` VALUES ('299', '55', '19', null);
INSERT INTO `e_user_role` VALUES ('300', '56', '18', null);
INSERT INTO `e_user_role` VALUES ('301', '57', '18', null);
INSERT INTO `e_user_role` VALUES ('302', '62', '40', null);
INSERT INTO `e_user_role` VALUES ('303', '63', '40', null);
INSERT INTO `e_user_role` VALUES ('304', '64', '40', null);
INSERT INTO `e_user_role` VALUES ('305', '65', '40', null);
INSERT INTO `e_user_role` VALUES ('306', '66', '40', null);
INSERT INTO `e_user_role` VALUES ('307', '67', '40', null);
INSERT INTO `e_user_role` VALUES ('308', '68', '40', null);
INSERT INTO `e_user_role` VALUES ('309', '69', '40', null);
INSERT INTO `e_user_role` VALUES ('310', '70', '40', null);
INSERT INTO `e_user_role` VALUES ('311', '71', '40', null);
INSERT INTO `e_user_role` VALUES ('312', '72', '40', null);
INSERT INTO `e_user_role` VALUES ('313', '73', '40', null);
INSERT INTO `e_user_role` VALUES ('314', '74', '40', null);
INSERT INTO `e_user_role` VALUES ('315', '75', '40', null);
INSERT INTO `e_user_role` VALUES ('316', '76', '40', null);
INSERT INTO `e_user_role` VALUES ('317', '77', '40', null);
INSERT INTO `e_user_role` VALUES ('318', '78', '40', null);
INSERT INTO `e_user_role` VALUES ('319', '79', '40', null);
INSERT INTO `e_user_role` VALUES ('320', '80', '40', null);
INSERT INTO `e_user_role` VALUES ('321', '81', '40', null);
INSERT INTO `e_user_role` VALUES ('322', '82', '40', null);
INSERT INTO `e_user_role` VALUES ('323', '83', '40', null);
INSERT INTO `e_user_role` VALUES ('324', '84', '40', null);
INSERT INTO `e_user_role` VALUES ('325', '85', '40', null);
INSERT INTO `e_user_role` VALUES ('326', '86', '40', null);
INSERT INTO `e_user_role` VALUES ('327', '87', '40', null);
INSERT INTO `e_user_role` VALUES ('328', '88', '40', null);
INSERT INTO `e_user_role` VALUES ('329', '89', '40', null);
INSERT INTO `e_user_role` VALUES ('330', '90', '40', null);
INSERT INTO `e_user_role` VALUES ('331', '81', '40', null);
INSERT INTO `e_user_role` VALUES ('332', '92', '40', null);
INSERT INTO `e_user_role` VALUES ('333', '93', '40', null);
INSERT INTO `e_user_role` VALUES ('334', '94', '40', null);
INSERT INTO `e_user_role` VALUES ('335', '95', '40', null);
INSERT INTO `e_user_role` VALUES ('336', '96', '40', null);
INSERT INTO `e_user_role` VALUES ('337', '97', '40', null);
INSERT INTO `e_user_role` VALUES ('338', '98', '40', null);
INSERT INTO `e_user_role` VALUES ('339', '99', '40', null);
INSERT INTO `e_user_role` VALUES ('340', '100', '40', null);
INSERT INTO `e_user_role` VALUES ('341', '101', '40', null);
INSERT INTO `e_user_role` VALUES ('342', '102', '40', null);
INSERT INTO `e_user_role` VALUES ('343', '103', '40', null);
INSERT INTO `e_user_role` VALUES ('344', '104', '40', null);
INSERT INTO `e_user_role` VALUES ('345', '105', '40', null);
INSERT INTO `e_user_role` VALUES ('346', '106', '40', null);
INSERT INTO `e_user_role` VALUES ('347', '107', '40', null);
INSERT INTO `e_user_role` VALUES ('348', '108', '40', null);
INSERT INTO `e_user_role` VALUES ('349', '109', '40', null);
INSERT INTO `e_user_role` VALUES ('350', '110', '40', null);
INSERT INTO `e_user_role` VALUES ('351', '111', '40', null);
INSERT INTO `e_user_role` VALUES ('352', '112', '40', null);
INSERT INTO `e_user_role` VALUES ('353', '113', '40', null);
INSERT INTO `e_user_role` VALUES ('354', '114', '40', null);
INSERT INTO `e_user_role` VALUES ('355', '115', '40', null);
INSERT INTO `e_user_role` VALUES ('356', '116', '40', null);
INSERT INTO `e_user_role` VALUES ('357', '117', '40', null);
INSERT INTO `e_user_role` VALUES ('358', '118', '40', null);
INSERT INTO `e_user_role` VALUES ('359', '119', '40', null);
INSERT INTO `e_user_role` VALUES ('360', '120', '40', null);
INSERT INTO `e_user_role` VALUES ('361', '121', '40', null);
INSERT INTO `e_user_role` VALUES ('362', '122', '40', null);
INSERT INTO `e_user_role` VALUES ('363', '123', '40', null);
INSERT INTO `e_user_role` VALUES ('364', '124', '40', null);
INSERT INTO `e_user_role` VALUES ('365', '125', '40', null);
INSERT INTO `e_user_role` VALUES ('366', '126', '40', null);
INSERT INTO `e_user_role` VALUES ('367', '127', '40', null);
INSERT INTO `e_user_role` VALUES ('368', '128', '40', null);
INSERT INTO `e_user_role` VALUES ('369', '129', '40', null);
INSERT INTO `e_user_role` VALUES ('370', '130', '40', null);
INSERT INTO `e_user_role` VALUES ('371', '131', '40', null);
INSERT INTO `e_user_role` VALUES ('372', '132', '40', null);
INSERT INTO `e_user_role` VALUES ('373', '133', '40', null);
INSERT INTO `e_user_role` VALUES ('374', '134', '38', null);
INSERT INTO `e_user_role` VALUES ('375', '135', '38', null);
INSERT INTO `e_user_role` VALUES ('376', '136', '39', null);
INSERT INTO `e_user_role` VALUES ('377', '137', '39', null);
INSERT INTO `e_user_role` VALUES ('378', '138', null, null);
INSERT INTO `e_user_role` VALUES ('379', '139', null, null);
INSERT INTO `e_user_role` VALUES ('380', '56', '18', null);
INSERT INTO `e_user_role` VALUES ('381', '57', '18', null);
INSERT INTO `e_user_role` VALUES ('382', '60', '18', null);
INSERT INTO `e_user_role` VALUES ('383', '61', '18', null);
INSERT INTO `e_user_role` VALUES ('384', '140', '15', null);
INSERT INTO `e_user_role` VALUES ('385', '143', '35', null);
INSERT INTO `e_user_role` VALUES ('386', '142', '16', null);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `fild` int(50) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `filepath` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `id` int(50) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `orgname` varchar(255) DEFAULT NULL COMMENT '机构名称',
  `fname` varchar(255) DEFAULT NULL COMMENT '不带时间戳的文件名称',
  `module` varchar(100) DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`fild`)
) ENGINE=InnoDB AUTO_INCREMENT=734 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('100', '萨摩20161215111554.jpg', 'D:/upload/20161215\\萨摩20161215111554.jpg', '2016-12-15 11:15:54', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('101', '小男孩20161215112019.jpeg', 'D:/upload/20161215\\小男孩20161215112019.jpeg', '2016-12-15 11:20:19', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('102', '小男孩20161215112020.jpeg', 'D:/upload/20161215\\小男孩20161215112020.jpeg', '2016-12-15 11:20:20', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('103', '小男孩20161215112155.jpeg', 'D:/upload/20161215\\小男孩20161215112155.jpeg', '2016-12-15 11:21:55', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('104', '小男孩20161215112158.jpeg', 'D:/upload/20161215\\小男孩20161215112158.jpeg', '2016-12-15 11:21:58', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('105', '小男孩20161215112211.jpeg', 'D:/upload/20161215\\小男孩20161215112211.jpeg', '2016-12-15 11:22:11', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('106', '小男孩20161215112433.jpeg', 'D:/upload/20161215\\小男孩20161215112433.jpeg', '2016-12-15 11:24:33', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('107', '小男孩20161215112617.jpeg', 'D:/upload/20161215\\小男孩20161215112617.jpeg', '2016-12-15 11:26:17', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('108', '小男孩20161215112627.jpeg', 'D:/upload/20161215\\小男孩20161215112627.jpeg', '2016-12-15 11:26:27', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('109', '小男孩20161215112635.jpeg', 'D:/upload/20161215\\小男孩20161215112635.jpeg', '2016-12-15 11:26:35', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('114', '卡通20161221101033.jpeg', 'D:/upload/20161221\\卡通20161221101033.jpeg', '2016-12-21 10:10:33', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('115', '喵星人20161221102103.jpg', 'D:/upload/20161221\\喵星人20161221102103.jpg', '2016-12-21 10:21:03', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('116', '狗狗20161221102421.jpg', 'D:/upload/20161221\\狗狗20161221102421.jpg', '2016-12-21 10:24:21', '上传成功', '371361137', null, null, null, null, null);
INSERT INTO `file` VALUES ('117', 'è¨æ©20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-21 14:44:31', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('118', '萨摩20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-21 14:47:12', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('119', '萨摩20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-21 14:47:12', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('120', '萨摩20161215111554.jpg', 'D://upload//20161215//萨摩20161215111554.jpg', '2016-12-21 14:50:14', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('121', '萨摩20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-21 15:13:22', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('122', '萨摩20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-21 15:15:35', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('123', '萨摩20161215111554.jpg', '', '2016-12-21 15:18:22', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('124', '小男孩20161215112019.jpeg', 'D:/upload/20161215\\小男孩20161215112019.jpeg', '2016-12-21 17:31:29', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('125', '小男孩20161215112020.jpeg', 'D:/upload/20161215\\小男孩20161215112020.jpeg', '2016-12-22 08:46:46', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('126', 'è¨æ©20161215111554.jpg', 'D://upload//20161215//小男孩20161215112617.jpeg', '2016-12-22 09:26:13', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('127', '喵星人20161221102103.jpg', 'D:/upload/20161221\\喵星人20161221102103.jpg', '2016-12-22 09:26:13', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('128', '卡通20161221101033.jpeg', 'D:/upload/20161221\\卡通20161221101033.jpeg', '2016-12-22 09:26:13', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('129', '卡通20161221101033.jpeg', 'D:/upload/20161221\\卡通20161221101033.jpeg', '2016-12-22 09:26:13', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('130', '喵星人20161222100748.jpg', 'D:/upload/20161222\\喵星人20161222100748.jpg', '2016-12-22 10:07:48', '上传成功', '371361170', null, null, null, null, null);
INSERT INTO `file` VALUES ('131', '狗狗20161222101154.jpg', 'D:/upload/20161222\\狗狗20161222101154.jpg', '2016-12-22 10:11:54', '上传成功', '371361172', null, null, null, null, null);
INSERT INTO `file` VALUES ('132', '喵星人20161222101307.jpg', 'D:/upload/20161222\\喵星人20161222101307.jpg', '2016-12-22 10:13:07', '上传成功', '371361174', null, null, null, null, null);
INSERT INTO `file` VALUES ('133', '萨摩20161223135254.jpg', 'D:/upload/20161223\\萨摩20161223135254.jpg', '2016-12-23 13:52:54', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('134', '喵星人20161223135313.jpg', 'D:/upload/20161223\\喵星人20161223135313.jpg', '2016-12-23 13:53:13', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('135', '小男孩20161226183246.jpeg', 'D:/upload/20161226\\小男孩20161226183246.jpeg', '2016-12-26 18:32:46', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('136', '调整之后20161226183151.zip', 'D:/upload/20161226\\调整之后20161226183151.zip', '2016-12-26 18:31:51', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('137', '调整之后20161226183304.zip', 'D:/upload/20161226\\调整之后20161226183304.zip', '2016-12-26 18:33:04', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('138', '调整之后20161226183151.zip', 'D:/upload/20161226\\调整之后20161226183151.zip', '2016-12-26 18:31:51', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('139', '小男孩20161226185221.jpeg', 'D:/upload/20161226\\小男孩20161226185221.jpeg', '2016-12-26 18:52:21', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('140', '调整之后20161226185131.zip', 'D:/upload/20161226\\调整之后20161226185131.zip', '2016-12-26 18:51:31', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('141', '调整之后20161226185131.zip', 'D:/upload/20161226\\调整之后20161226185131.zip', '2016-12-26 18:51:31', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('142', '暴风截图201631693925020161226185426.jpg', 'D:/upload/20161226\\暴风截图201631693925020161226185426.jpg', '2016-12-26 18:54:26', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('143', '小男孩20161226185753.jpeg', 'D:/upload/20161226\\小男孩20161226185753.jpeg', '2016-12-26 18:57:53', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('144', 'DSC_040120161226185815.jpg', 'D:/upload/20161226\\DSC_040120161226185815.jpg', '2016-12-26 18:58:15', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('145', 'DSC_040120161226185835.jpg', 'D:/upload/20161226\\DSC_040120161226185835.jpg', '2016-12-26 18:58:35', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('146', 'DSC_042220161227135509.jpg', 'D:/upload/20161227\\DSC_042220161227135509.jpg', '2016-12-27 13:55:09', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('147', 'DSC_042120161227141557.jpg', 'D:/upload/20161227\\DSC_042120161227141557.jpg', '2016-12-27 14:15:57', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('148', 'DSC_041120161227141936.jpg', 'D:/upload/20161227\\DSC_041120161227141936.jpg', '2016-12-27 14:19:36', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('149', 'DSC_042120161227143638.jpg', 'D:/upload/20161227\\DSC_042120161227143638.jpg', '2016-12-27 14:36:38', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('150', 'DSC_041920161227151224.jpg', 'D:/upload/20161227\\DSC_041920161227151224.jpg', '2016-12-27 15:12:24', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('151', 'DSC_043720161227151303.jpg', 'D:/upload/20161227\\DSC_043720161227151303.jpg', '2016-12-27 15:13:03', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('152', 'DSC_041820161227151400.jpg', 'D:/upload/20161227\\DSC_041820161227151400.jpg', '2016-12-27 15:14:00', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('153', 'DSC_043420161227152217.jpg', 'D:/upload/20161227\\DSC_043420161227152217.jpg', '2016-12-27 15:22:17', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('154', 'DSC_043420161227152218.jpg', 'D:/upload/20161227\\DSC_043420161227152218.jpg', '2016-12-27 15:22:18', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('155', 'DSC_043420161227152219.jpg', 'D:/upload/20161227\\DSC_043420161227152219.jpg', '2016-12-27 15:22:19', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('156', 'DSC_043420161227152219.jpg', 'D:/upload/20161227\\DSC_043420161227152219.jpg', '2016-12-27 15:22:19', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('157', 'DSC_043420161227152219.jpg', 'D:/upload/20161227\\DSC_043420161227152219.jpg', '2016-12-27 15:22:19', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('158', 'DSC_043420161227152226.jpg', 'D:/upload/20161227\\DSC_043420161227152226.jpg', '2016-12-27 15:22:26', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('159', 'DSC_041820161227152329.jpg', 'D:/upload/20161227\\DSC_041820161227152329.jpg', '2016-12-27 15:23:29', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('160', 'DSC_041820161227152330.jpg', 'D:/upload/20161227\\DSC_041820161227152330.jpg', '2016-12-27 15:23:30', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('161', 'DSC_041920161227152515.jpg', 'D:/upload/20161227\\DSC_041920161227152515.jpg', '2016-12-27 15:25:15', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('162', 'DSC_042120161227152607.jpg', 'D:/upload/20161227\\DSC_042120161227152607.jpg', '2016-12-27 15:26:07', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('163', 'DSC_042020161227152637.jpg', 'D:/upload/20161227\\DSC_042020161227152637.jpg', '2016-12-27 15:26:37', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('164', 'DSC_041920161227153109.jpg', 'D:/upload/20161227\\DSC_041920161227153109.jpg', '2016-12-27 15:31:09', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('165', 'DSC_042020161227155034.jpg', 'D:/upload/20161227\\DSC_042020161227155034.jpg', '2016-12-27 15:50:34', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('166', 'DSC_042020161227155036.jpg', 'D:/upload/20161227\\DSC_042020161227155036.jpg', '2016-12-27 15:50:36', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('167', 'DSC_042020161227155037.jpg', 'D:/upload/20161227\\DSC_042020161227155037.jpg', '2016-12-27 15:50:37', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('168', 'DSC_042020161227155038.jpg', 'D:/upload/20161227\\DSC_042020161227155038.jpg', '2016-12-27 15:50:38', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('169', 'DSC_042020161227155038.jpg', 'D:/upload/20161227\\DSC_042020161227155038.jpg', '2016-12-27 15:50:38', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('170', 'DSC_042020161227155038.jpg', 'D:/upload/20161227\\DSC_042020161227155038.jpg', '2016-12-27 15:50:38', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('171', 'DSC_042020161227155108.jpg', 'D:/upload/20161227\\DSC_042020161227155108.jpg', '2016-12-27 15:51:08', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('172', 'DSC_042020161227155442.jpg', 'D:/upload/20161227\\DSC_042020161227155442.jpg', '2016-12-27 15:54:42', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('173', 'DSC_042020161227155507.jpg', 'D:/upload/20161227\\DSC_042020161227155507.jpg', '2016-12-27 15:55:07', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('174', 'DSC_041920161227155646.jpg', 'D:/upload/20161227\\DSC_041920161227155646.jpg', '2016-12-27 15:56:46', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('175', 'DSC_041920161227170332.jpg', 'D:/upload/20161227\\DSC_041920161227170332.jpg', '2016-12-27 17:03:32', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('176', 'DSC_042020161227171821.jpg', 'D:/upload/20161227\\DSC_042020161227171821.jpg', '2016-12-27 17:18:21', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('177', 'DSC_041920161227171825.jpg', 'D:/upload/20161227\\DSC_041920161227171825.jpg', '2016-12-27 17:18:25', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('178', 'DSC_045220161227172052.jpg', 'D:/upload/20161227\\DSC_045220161227172052.jpg', '2016-12-27 17:20:52', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('179', 'DSC_046620161228090643.jpg', 'D:/upload/20161228\\DSC_046620161228090643.jpg', '2016-12-28 09:06:43', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('180', 'DSC_041920161228090809.jpg', 'D:/upload/20161228\\DSC_041920161228090809.jpg', '2016-12-28 09:08:09', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('181', 'DSC_041920161228151453.jpg', 'D:/upload/20161228\\DSC_041920161228151453.jpg', '2016-12-28 15:14:53', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('182', 'DSC_041920161228151650.jpg', 'D:/upload/20161228\\DSC_041920161228151650.jpg', '2016-12-28 15:16:50', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('183', 'DSC_057420161228151956.jpg', 'D:/upload/20161228\\DSC_057420161228151956.jpg', '2016-12-28 15:19:56', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('184', 'DSC_039620161228152659.jpg', 'D:/upload/20161228\\DSC_039620161228152659.jpg', '2016-12-28 15:26:59', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('185', '陌生人20161228181022.mp3', 'D:/upload/20161228\\陌生人20161228181022.mp3', '2016-12-28 18:10:22', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('186', '120161228182046.jpg', 'D:/upload/20161228\\120161228182046.jpg', '2016-12-28 18:20:46', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('187', '120161228182055.jpg', 'D:/upload/20161228\\120161228182055.jpg', '2016-12-28 18:20:55', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('188', '120161228182055.jpg', 'D:/upload/20161228\\120161228182055.jpg', '2016-12-28 18:20:55', '上传成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('189', 'a20161228182103.gif', 'D:/upload/20161228\\a20161228182103.gif', '2016-12-28 18:21:03', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('190', 'tabsicons20161228182115.png', 'D:/upload/20161228\\tabsicons20161228182115.png', '2016-12-28 18:21:15', '上传成功', '371361198', null, null, null, null, null);
INSERT INTO `file` VALUES ('191', 'backups20161229091857.sh', 'D:/upload/20161229\\backups20161229091857.sh', '2016-12-29 09:18:57', '上传成功', '371361199', null, null, null, null, null);
INSERT INTO `file` VALUES ('192', 'restore20161229094401.sh', 'D:/upload/20161229\\restore20161229094401.sh', '2016-12-29 09:44:01', '上传成功', '371361202', null, null, null, null, null);
INSERT INTO `file` VALUES ('193', '陌生人20161229095710.mp3', 'D:/upload/20161229\\陌生人20161229095710.mp3', '2016-12-29 09:57:10', '上传成功', '371361203', null, null, null, null, null);
INSERT INTO `file` VALUES ('194', '陌生人20161229095803.mp3', 'D:/upload/20161229\\陌生人20161229095803.mp3', '2016-12-29 09:58:03', '上传成功', '371361203', null, null, null, null, null);
INSERT INTO `file` VALUES ('195', '陌生人20161229095920.mp3', 'D:/upload/20161229\\陌生人20161229095920.mp3', '2016-12-29 09:59:20', '上传成功', '371361203', null, null, null, null, null);
INSERT INTO `file` VALUES ('196', 'DSC_048620161229103231.jpg', 'D:/upload/20161229\\DSC_048620161229103231.jpg', '2016-12-29 10:32:31', '上传成功', '371361204', null, null, null, null, null);
INSERT INTO `file` VALUES ('197', 'DSC_041920161229150327.jpg', 'D:/upload/20161229\\DSC_041920161229150327.jpg', '2016-12-29 15:03:27', '上传成功', '371361225', null, null, null, null, null);
INSERT INTO `file` VALUES ('198', '卡通20161229150458.jpeg', 'D:/upload/20161229\\卡通20161229150458.jpeg', '2016-12-29 15:04:58', '上传成功', '371361226', null, null, null, null, null);
INSERT INTO `file` VALUES ('199', '卡通20161229150519.jpeg', 'D:/upload/20161229\\卡通20161229150519.jpeg', '2016-12-29 15:05:19', '上传成功', '371361226', null, null, null, null, null);
INSERT INTO `file` VALUES ('200', '卡通20161229151545.jpeg', 'D:/upload/20161229\\卡通20161229151545.jpeg', '2016-12-29 15:15:45', '上传成功', '371361228', null, null, null, null, null);
INSERT INTO `file` VALUES ('201', 'test20170103143726.txt', 'D:/upload/20170103\\test20170103143726.txt', '2017-01-03 14:37:26', '上传成功', '371361283', null, null, null, null, null);
INSERT INTO `file` VALUES ('202', 'test20170103143726.txt', 'D:/upload/20170103\\test20170103143726.txt', '2017-01-03 13:56:26', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('203', '卡通20170103155109.jpeg', 'D:/upload/20170103\\卡通20170103155109.jpeg', '2017-01-03 15:51:09', '上传成功', '371361306', null, null, null, null, null);
INSERT INTO `file` VALUES ('204', '卡通20170103155110.jpeg', 'D:/upload/20170103\\卡通20170103155110.jpeg', '2017-01-03 15:51:10', '上传成功', '371361306', null, null, null, null, null);
INSERT INTO `file` VALUES ('205', '卡通20170103155201.jpeg', 'D:/upload/20170103\\卡通20170103155201.jpeg', '2017-01-03 15:52:01', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('206', '卡通20170103155202.jpeg', 'D:/upload/20170103\\卡通20170103155202.jpeg', '2017-01-03 15:52:02', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('207', '卡通20170103155203.jpeg', 'D:/upload/20170103\\卡通20170103155203.jpeg', '2017-01-03 15:52:03', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('208', '卡通20170103155203.jpeg', 'D:/upload/20170103\\卡通20170103155203.jpeg', '2017-01-03 15:52:03', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('209', '卡通20170103155203.jpeg', 'D:/upload/20170103\\卡通20170103155203.jpeg', '2017-01-03 15:52:03', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('210', '卡通20170103155203.jpeg', 'D:/upload/20170103\\卡通20170103155203.jpeg', '2017-01-03 15:52:03', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('211', '卡通20170103155203.jpeg', 'D:/upload/20170103\\卡通20170103155203.jpeg', '2017-01-03 15:52:03', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('212', '卡通20170103155204.jpeg', 'D:/upload/20170103\\卡通20170103155204.jpeg', '2017-01-03 15:52:04', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('213', '卡通20170103155204.jpeg', 'D:/upload/20170103\\卡通20170103155204.jpeg', '2017-01-03 15:52:04', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('214', '卡通20170103155204.jpeg', 'D:/upload/20170103\\卡通20170103155204.jpeg', '2017-01-03 15:52:04', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('215', '卡通20170103155204.jpeg', 'D:/upload/20170103\\卡通20170103155204.jpeg', '2017-01-03 15:52:04', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('216', '卡通20170103155204.jpeg', 'D:/upload/20170103\\卡通20170103155204.jpeg', '2017-01-03 15:52:04', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('217', '卡通20170103155205.jpeg', 'D:/upload/20170103\\卡通20170103155205.jpeg', '2017-01-03 15:52:05', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('218', '卡通20170103155206.jpeg', 'D:/upload/20170103\\卡通20170103155206.jpeg', '2017-01-03 15:52:06', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('219', '卡通20170103155206.jpeg', 'D:/upload/20170103\\卡通20170103155206.jpeg', '2017-01-03 15:52:06', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('220', '卡通20170103155206.jpeg', 'D:/upload/20170103\\卡通20170103155206.jpeg', '2017-01-03 15:52:06', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('221', '卡通20170103155207.jpeg', 'D:/upload/20170103\\卡通20170103155207.jpeg', '2017-01-03 15:52:07', '上传成功', '371361307', null, null, null, null, null);
INSERT INTO `file` VALUES ('222', '喵星人20170103155458.jpg', 'D:/upload/20170103\\喵星人20170103155458.jpg', '2017-01-03 15:54:58', '上传成功', '371361308', null, null, null, null, null);
INSERT INTO `file` VALUES ('223', '喵星人20170103155500.jpg', 'D:/upload/20170103\\喵星人20170103155500.jpg', '2017-01-03 15:55:00', '上传成功', '371361308', null, null, null, null, null);
INSERT INTO `file` VALUES ('224', '喵星人20170103155501.jpg', 'D:/upload/20170103\\喵星人20170103155501.jpg', '2017-01-03 15:55:01', '上传成功', '371361308', null, null, null, null, null);
INSERT INTO `file` VALUES ('225', '卡通20170103155636.jpeg', 'D:/upload/20170103\\卡通20170103155636.jpeg', '2017-01-03 15:56:36', '上传成功', '371361309', null, null, null, null, null);
INSERT INTO `file` VALUES ('226', '喵星人20170103155718.jpg', 'D:/upload/20170103\\喵星人20170103155718.jpg', '2017-01-03 15:57:18', '上传成功', '371361310', null, null, null, null, null);
INSERT INTO `file` VALUES ('227', '卡通20170103160002.jpeg', 'D:/upload/20170103\\卡通20170103160002.jpeg', '2017-01-03 16:00:02', '上传成功', '371361313', null, null, null, null, null);
INSERT INTO `file` VALUES ('228', '卡通20170103160003.jpeg', 'D:/upload/20170103\\卡通20170103160003.jpeg', '2017-01-03 16:00:03', '上传成功', '371361313', null, null, null, null, null);
INSERT INTO `file` VALUES ('229', '卡通20170103160003.jpeg', 'D:/upload/20170103\\卡通20170103160003.jpeg', '2017-01-03 15:51:35', '下载成功', null, null, null, null, null, null);
INSERT INTO `file` VALUES ('230', '小男孩20170103161333.jpeg', 'D:/upload/20170103\\小男孩20170103161333.jpeg', '2017-01-03 16:13:33', '上传成功', '371361314', null, null, null, null, null);
INSERT INTO `file` VALUES ('231', '喵星人20170103164015.jpg', 'D:/upload/20170103\\喵星人20170103164015.jpg', '2017-01-03 16:40:15', '上传成功', '371361316', null, null, null, null, null);
INSERT INTO `file` VALUES ('232', '喵星人20170103164331.jpg', 'D:/upload/20170103\\喵星人20170103164331.jpg', '2017-01-03 16:43:31', '上传成功', '371361317', null, null, null, null, null);
INSERT INTO `file` VALUES ('233', '喵星人20170103164434.jpg', 'D:/upload/20170103\\喵星人20170103164434.jpg', '2017-01-03 16:44:34', '上传成功', '371361318', null, null, null, null, null);
INSERT INTO `file` VALUES ('234', '卡通20170103164607.jpeg', 'D:/upload/20170103\\卡通20170103164607.jpeg', '2017-01-03 16:46:07', '上传成功', '371361319', null, null, null, null, null);
INSERT INTO `file` VALUES ('235', '喵星人20170103164823.jpg', 'D:/upload/20170103\\喵星人20170103164823.jpg', '2017-01-03 16:48:23', '上传成功', '371361320', null, null, null, null, null);
INSERT INTO `file` VALUES ('236', '调整之后20170103164837.zip', 'D:/upload/20170103\\调整之后20170103164837.zip', '2017-01-03 16:48:37', '上传成功', '371361320', null, null, null, null, null);
INSERT INTO `file` VALUES ('237', '调整之后20170103164837.zip', 'D:/upload/20170103\\调整之后20170103164837.zip', '2017-01-03 16:48:37', '上传成功', '371361320', null, null, null, null, null);
INSERT INTO `file` VALUES ('238', '问题20170103164921.txt', 'D:/upload/20170103\\问题20170103164921.txt', '2017-01-03 16:49:21', '上传成功', '371361321', null, null, null, null, null);
INSERT INTO `file` VALUES ('239', 'eclipse20170103164931.exe', 'D:/upload/20170103\\eclipse20170103164931.exe', '2017-01-03 16:49:31', '上传成功', '371361321', null, null, null, null, null);
INSERT INTO `file` VALUES ('240', 'eclipse20170103164952.ini', 'D:/upload/20170103\\eclipse20170103164952.ini', '2017-01-03 16:49:52', '上传成功', '371361321', null, null, null, null, null);
INSERT INTO `file` VALUES ('241', 'BondSupInfoController20170103165008.java', 'D:/upload/20170103\\BondSupInfoController20170103165008.java', '2017-01-03 16:50:08', '上传成功', '371361321', null, null, null, null, null);
INSERT INTO `file` VALUES ('242', 'BondSupInfoController20170103174055.java', 'D:/upload/20170103\\BondSupInfoController20170103174055.java', '2017-01-03 17:40:55', '上传成功', '371361323', null, null, null, null, null);
INSERT INTO `file` VALUES ('243', 'DSC_042220170103174325.jpg', 'D:/upload/20170103\\DSC_042220170103174325.jpg', '2017-01-03 17:43:25', '上传成功', '371361324', null, null, null, null, null);
INSERT INTO `file` VALUES ('244', 'DSC_040620170103174953.jpg', 'D:/upload/20170103\\DSC_040620170103174953.jpg', '2017-01-03 17:49:53', '上传成功', '371361322', null, null, null, null, null);
INSERT INTO `file` VALUES ('245', 'DSC_041820170104100729.jpg', 'D:/upload/20170104\\DSC_041820170104100729.jpg', '2017-01-04 10:07:29', '上传成功', '371361338', null, null, null, null, null);
INSERT INTO `file` VALUES ('246', 'DSC_045120170104100918.jpg', 'D:/upload/20170104\\DSC_045120170104100918.jpg', '2017-01-04 10:09:18', '上传成功', '371361339', null, null, null, null, null);
INSERT INTO `file` VALUES ('247', 'DSC_040620170104101120.jpg', 'D:/upload/20170104\\DSC_040620170104101120.jpg', '2017-01-04 10:11:20', '上传成功', '371361340', null, null, null, null, null);
INSERT INTO `file` VALUES ('248', 'DSC_041920170104101236.jpg', 'D:/upload/20170104\\DSC_041920170104101236.jpg', '2017-01-04 10:12:36', '上传成功', '371361341', null, null, null, null, null);
INSERT INTO `file` VALUES ('249', 'DSC_041820170104101539.jpg', 'D:/upload/20170104\\DSC_041820170104101539.jpg', '2017-01-04 10:15:39', '上传成功', '371361342', null, null, null, null, null);
INSERT INTO `file` VALUES ('250', 'DSC_041820170104134833.jpg', 'D:/upload/20170104\\DSC_041820170104134833.jpg', '2017-01-04 13:48:33', '上传成功', '371361348', null, null, null, null, null);
INSERT INTO `file` VALUES ('251', 'DSC_040620170104145531.jpg', 'D:/upload/20170104\\DSC_040620170104145531.jpg', '2017-01-04 14:55:31', '2', '371361349', null, null, null, null, null);
INSERT INTO `file` VALUES ('252', 'DSC_039620170104151537.jpg', 'D:/upload/20170104\\DSC_039620170104151537.jpg', '2017-01-04 15:15:37', '2', '371361350', null, null, null, null, null);
INSERT INTO `file` VALUES ('253', 'DSC_041920170104152132.jpg', 'D:/upload/20170104\\DSC_041920170104152132.jpg', '2017-01-04 15:21:32', '2', '371361351', null, null, null, null, null);
INSERT INTO `file` VALUES ('254', 'DSC_040020170104152611.jpg', 'D:/upload/20170104\\DSC_040020170104152611.jpg', '2017-01-04 15:26:11', '2', '371361352', null, null, null, null, null);
INSERT INTO `file` VALUES ('255', '喵星人20170104152755.jpg', 'D:/upload/20170104\\喵星人20170104152755.jpg', '2017-01-04 15:27:55', '2', '371361352', null, null, null, null, null);
INSERT INTO `file` VALUES ('256', '狗狗20170104152931.jpg', 'D:/upload/20170104\\狗狗20170104152931.jpg', '2017-01-04 15:29:31', '2', '371361355', null, null, null, null, null);
INSERT INTO `file` VALUES ('257', '狗狗20170104153436.jpg', 'D:/upload/20170104\\狗狗20170104153436.jpg', '2017-01-04 15:34:36', '2', '371361356', null, null, null, null, null);
INSERT INTO `file` VALUES ('258', '卡通20170104153509.jpeg', 'D:/upload/20170104\\卡通20170104153509.jpeg', '2017-01-04 15:35:09', '2', '371361357', null, null, null, null, null);
INSERT INTO `file` VALUES ('259', '萨摩20170104153813.jpg', 'D:/upload/20170104\\萨摩20170104153813.jpg', '2017-01-04 15:38:13', '3', '371361358', null, null, null, null, null);
INSERT INTO `file` VALUES ('260', '狗狗20170104164554.jpg', 'D:/upload/20170104\\狗狗20170104164554.jpg', '2017-01-04 16:45:54', '2', '371361361', null, null, null, null, null);
INSERT INTO `file` VALUES ('261', '狗狗20170104164555.jpg', 'D:/upload/20170104\\狗狗20170104164555.jpg', '2017-01-04 16:45:55', '3', '371361361', null, null, null, null, null);
INSERT INTO `file` VALUES ('262', '狗狗20170104164611.jpg', 'D:/upload/20170104\\狗狗20170104164611.jpg', '2017-01-04 16:46:11', '3', '371361362', null, null, null, null, null);
INSERT INTO `file` VALUES ('263', '喵星人20170105092751.jpg', 'D:/upload/20170105\\喵星人20170105092751.jpg', '2017-01-05 09:27:51', '3', '371361367', null, null, null, null, null);
INSERT INTO `file` VALUES ('264', '狗狗20170105092915.jpg', 'D:/upload/20170105\\狗狗20170105092915.jpg', '2017-01-05 09:29:15', '3', '371361369', null, null, null, null, null);
INSERT INTO `file` VALUES ('265', '卡通20170105092931.jpeg', 'D:/upload/20170105\\卡通20170105092931.jpeg', '2017-01-05 09:29:31', '2', '371361370', null, null, null, null, null);
INSERT INTO `file` VALUES ('266', '小男孩20170105092959.jpeg', 'D:/upload/20170105\\小男孩20170105092959.jpeg', '2017-01-05 09:29:59', '3', '371361371', null, null, null, null, null);
INSERT INTO `file` VALUES ('267', '小男孩20170105093013.jpeg', 'D:/upload/20170105\\小男孩20170105093013.jpeg', '2017-01-05 09:30:13', '3', '371361372', null, null, null, null, null);
INSERT INTO `file` VALUES ('268', '萨摩20170105093212.jpg', 'D:/upload/20170105\\萨摩20170105093212.jpg', '2017-01-05 09:32:12', '2', '371361372', null, null, null, null, null);
INSERT INTO `file` VALUES ('269', '狗狗20170105093307.jpg', 'D:/upload/20170105\\狗狗20170105093307.jpg', '2017-01-05 09:33:07', '2', '371361373', null, null, null, null, null);
INSERT INTO `file` VALUES ('270', '狗狗20170105093725.jpg', 'D:/upload/20170105\\狗狗20170105093725.jpg', '2017-01-05 09:37:25', '2', '371361373', null, null, null, null, null);
INSERT INTO `file` VALUES ('271', '狗狗20170105094028.jpg', 'D:/upload/20170105\\狗狗20170105094028.jpg', '2017-01-05 09:40:28', '2', '371361374', null, null, null, null, null);
INSERT INTO `file` VALUES ('272', '狗狗20170105094501.jpg', 'D:/upload/20170105\\狗狗20170105094501.jpg', '2017-01-05 09:45:01', '3', '371361375', null, null, null, null, null);
INSERT INTO `file` VALUES ('273', '狗狗20170105094606.jpg', 'D:/upload/20170105\\狗狗20170105094606.jpg', '2017-01-05 09:46:06', '3', '371361377', null, null, null, null, null);
INSERT INTO `file` VALUES ('274', '狗狗20170105094725.jpg', 'D:/upload/20170105\\狗狗20170105094725.jpg', '2017-01-05 09:47:25', '2', '371361378', null, null, null, null, null);
INSERT INTO `file` VALUES ('275', '狗狗20170105094754.jpg', 'D:/upload/20170105\\狗狗20170105094754.jpg', '2017-01-05 09:47:54', '2', '371361379', null, null, null, null, null);
INSERT INTO `file` VALUES ('276', '狗狗20170105094836.jpg', 'D:/upload/20170105\\狗狗20170105094836.jpg', '2017-01-05 09:48:36', '3', '371361380', null, null, null, null, null);
INSERT INTO `file` VALUES ('277', '狗狗20170105094933.jpg', 'D:/upload/20170105\\狗狗20170105094933.jpg', '2017-01-05 09:49:33', '3', '371361382', null, null, null, null, null);
INSERT INTO `file` VALUES ('278', '卡通20170105095107.jpeg', 'D:/upload/20170105\\卡通20170105095107.jpeg', '2017-01-05 09:51:07', '3', '371361383', null, null, null, null, null);
INSERT INTO `file` VALUES ('279', '喵星人20170105095210.jpg', 'D:/upload/20170105\\喵星人20170105095210.jpg', '2017-01-05 09:52:10', '3', '371361384', null, null, null, null, null);
INSERT INTO `file` VALUES ('280', '狗狗20170105095356.jpg', 'D:/upload/20170105\\狗狗20170105095356.jpg', '2017-01-05 09:53:56', '3', '371361385', null, null, null, null, null);
INSERT INTO `file` VALUES ('281', '萨摩20170105095404.jpg', 'D:/upload/20170105\\萨摩20170105095404.jpg', '2017-01-05 09:54:04', '3', '371361385', null, null, null, null, null);
INSERT INTO `file` VALUES ('282', '狗狗20170105095408.jpg', 'D:/upload/20170105\\狗狗20170105095408.jpg', '2017-01-05 09:54:08', '2', '371361385', null, null, null, null, null);
INSERT INTO `file` VALUES ('283', '陌生人20170105155747.mp3', 'D:/upload/20170105\\陌生人20170105155747.mp3', '2017-01-05 15:57:47', '2', '371361399', null, null, null, null, null);
INSERT INTO `file` VALUES ('284', '陌生人20170105162604.mp3', 'D:/upload/20170105\\陌生人20170105162604.mp3', '2017-01-05 16:26:04', '2', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('285', '狗狗20170106100944.jpg', 'D:/upload/20170106\\狗狗20170106100944.jpg', '2017-01-06 10:09:44', '3', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('286', '卡通20170106102435.jpeg', 'D:/upload/20170106\\卡通20170106102435.jpeg', '2017-01-06 10:24:35', '3', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('287', '狗狗20170106111937.jpg', 'D:/upload/20170106\\狗狗20170106111937.jpg', '2017-01-06 11:19:37', '3', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('288', 'DSC_207020170106161951.jpg', 'D:/upload/20170106\\DSC_207020170106161951.jpg', '2017-01-06 16:19:51', '3', '371361435', null, null, null, null, null);
INSERT INTO `file` VALUES ('289', '62820170106164732.jpg', 'D:/upload/20170106\\62820170106164732.jpg', '2017-01-06 16:47:32', '2', '371361437', null, null, null, null, null);
INSERT INTO `file` VALUES ('290', '暴风截图201631693925020170106164741.jpg', 'D:/upload/20170106\\暴风截图201631693925020170106164741.jpg', '2017-01-06 16:47:41', '2', '371361437', null, null, null, null, null);
INSERT INTO `file` VALUES ('291', '喵星人20170106164747.jpg', 'D:/upload/20170106\\喵星人20170106164747.jpg', '2017-01-06 16:47:47', '2', '371361437', null, null, null, null, null);
INSERT INTO `file` VALUES ('298', 'DSC_041820170106172653.jpg', 'D:/upload/20170106\\DSC_041820170106172653.jpg', '2017-01-06 17:26:53', '3', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('299', 'DSC_041820170106172658.jpg', 'D:/upload/20170106\\DSC_041820170106172658.jpg', '2017-01-06 17:26:58', '2', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('300', '肥肥20170107094924.jpg', 'D:/upload/20170107\\肥肥20170107094924.jpg', '2017-01-07 09:49:24', '3', '371361116', null, null, null, null, null);
INSERT INTO `file` VALUES ('301', '二次元_020170107094929.jpeg', 'D:/upload/20170107\\二次元_020170107094929.jpeg', '2017-01-07 09:49:29', '2', '371361116', null, null, null, null, null);
INSERT INTO `file` VALUES ('302', 'DSC_207020170107135033.jpg', 'D:/upload/20170107\\DSC_207020170107135033.jpg', '2017-01-07 13:50:33', '3', '371361474', null, null, null, null, null);
INSERT INTO `file` VALUES ('303', 'DSC_207020170107135844.jpg', 'D:/upload/20170107\\DSC_207020170107135844.jpg', '2017-01-07 13:58:44', '2', '371361476', null, null, null, null, null);
INSERT INTO `file` VALUES ('304', '暴风截图201631693925020170107140025.jpg', 'D:/upload/20170107\\暴风截图201631693925020170107140025.jpg', '2017-01-07 14:00:25', '2', '371361477', null, null, null, null, null);
INSERT INTO `file` VALUES ('305', '肥肥20170107140034.jpg', 'D:/upload/20170107\\肥肥20170107140034.jpg', '2017-01-07 14:00:34', '2', '371361477', null, null, null, null, null);
INSERT INTO `file` VALUES ('306', '肥肥20170107140034.jpg', 'D:/upload/20170107\\肥肥20170107140034.jpg', '2017-01-07 14:00:34', '2', '371361477', null, null, null, null, null);
INSERT INTO `file` VALUES ('339', '二次元_020170107160955.jpeg', 'D:/upload/20170107\\二次元_020170107160955.jpeg', '2017-01-07 16:09:55', '2', '371361487', null, null, null, null, null);
INSERT INTO `file` VALUES ('340', '二次元_020170107161003.jpeg', 'D:/upload/20170107\\二次元_020170107161003.jpeg', '2017-01-07 16:10:03', '2', '371361487', null, null, null, null, null);
INSERT INTO `file` VALUES ('341', '二次元_020170107161004.jpeg', 'D:/upload/20170107\\二次元_020170107161004.jpeg', '2017-01-07 16:10:04', '2', '371361487', null, null, null, null, null);
INSERT INTO `file` VALUES ('342', 'DSC_207020170107161014.jpg', 'D:/upload/20170107\\DSC_207020170107161014.jpg', '2017-01-07 16:10:14', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('343', 'DSC_207020170107161014.jpg', 'D:/upload/20170107\\DSC_207020170107161014.jpg', '2017-01-07 16:10:14', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('344', 'DSC_207020170107161014.jpg', 'D:/upload/20170107\\DSC_207020170107161014.jpg', '2017-01-07 16:10:14', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('345', 'DSC_207020170107161015.jpg', 'D:/upload/20170107\\DSC_207020170107161015.jpg', '2017-01-07 16:10:15', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('346', 'DSC_207020170107161015.jpg', 'D:/upload/20170107\\DSC_207020170107161015.jpg', '2017-01-07 16:10:15', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('347', 'DSC_207020170107161015.jpg', 'D:/upload/20170107\\DSC_207020170107161015.jpg', '2017-01-07 16:10:15', '2', '371361488', null, null, null, null, null);
INSERT INTO `file` VALUES ('348', '机器猫20170107161234.jpg', 'D:/upload/20170107\\机器猫20170107161234.jpg', '2017-01-07 16:12:34', '2', '371361282', null, null, null, null, null);
INSERT INTO `file` VALUES ('349', '星空C20170107163304.jpg', 'D:/upload/20170107\\星空C20170107163304.jpg', '2017-01-07 16:33:04', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('350', '雷电20170107164436.jpg', 'D:/upload/20170107\\雷电20170107164436.jpg', '2017-01-07 16:44:36', '3', '371361495', null, null, null, null, null);
INSERT INTO `file` VALUES ('351', '雷电20170107164516.jpg', 'D:/upload/20170107\\雷电20170107164516.jpg', '2017-01-07 16:45:16', '3', '371361495', null, null, null, null, null);
INSERT INTO `file` VALUES ('352', '星空C20170107164520.jpg', 'D:/upload/20170107\\星空C20170107164520.jpg', '2017-01-07 16:45:20', '3', '371361495', null, null, null, null, null);
INSERT INTO `file` VALUES ('353', '雷电20170107165804.jpg', 'D:/upload/20170107\\雷电20170107165804.jpg', '2017-01-07 16:58:04', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('354', '雷电20170107165809.jpg', 'D:/upload/20170107\\雷电20170107165809.jpg', '2017-01-07 16:58:09', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('355', '雷电20170107165811.jpg', 'D:/upload/20170107\\雷电20170107165811.jpg', '2017-01-07 16:58:11', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('356', '雷电20170107165812.jpg', 'D:/upload/20170107\\雷电20170107165812.jpg', '2017-01-07 16:58:12', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('357', '雷电20170107165813.jpg', 'D:/upload/20170107\\雷电20170107165813.jpg', '2017-01-07 16:58:13', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('358', '雷电20170107165813.jpg', 'D:/upload/20170107\\雷电20170107165813.jpg', '2017-01-07 16:58:13', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('359', '雷电20170107165814.jpg', 'D:/upload/20170107\\雷电20170107165814.jpg', '2017-01-07 16:58:14', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('360', '雷电20170107165815.jpg', 'D:/upload/20170107\\雷电20170107165815.jpg', '2017-01-07 16:58:15', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('361', '雷电20170107165816.jpg', 'D:/upload/20170107\\雷电20170107165816.jpg', '2017-01-07 16:58:16', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('362', '雷电20170107165817.jpg', 'D:/upload/20170107\\雷电20170107165817.jpg', '2017-01-07 16:58:17', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('363', '雷电20170107165818.jpg', 'D:/upload/20170107\\雷电20170107165818.jpg', '2017-01-07 16:58:18', '2', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('364', '雷电20170107165819.jpg', 'D:/upload/20170107\\雷电20170107165819.jpg', '2017-01-07 16:58:19', '2', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('365', '雷电20170107165820.jpg', 'D:/upload/20170107\\雷电20170107165820.jpg', '2017-01-07 16:58:20', '2', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('366', '雷电20170107165821.jpg', 'D:/upload/20170107\\雷电20170107165821.jpg', '2017-01-07 16:58:21', '2', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('367', '雷电20170107165822.jpg', 'D:/upload/20170107\\雷电20170107165822.jpg', '2017-01-07 16:58:22', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('368', '雷电20170107165823.jpg', 'D:/upload/20170107\\雷电20170107165823.jpg', '2017-01-07 16:58:23', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('369', '雷电20170107165824.jpg', 'D:/upload/20170107\\雷电20170107165824.jpg', '2017-01-07 16:58:24', '3', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('370', '星空C20170107170220.jpg', 'D:/upload/20170107\\星空C20170107170220.jpg', '2017-01-07 17:02:20', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('371', '星空C20170107170221.jpg', 'D:/upload/20170107\\星空C20170107170221.jpg', '2017-01-07 17:02:21', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('372', '星空C20170107170222.jpg', 'D:/upload/20170107\\星空C20170107170222.jpg', '2017-01-07 17:02:22', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('373', '星空C20170107170223.jpg', 'D:/upload/20170107\\星空C20170107170223.jpg', '2017-01-07 17:02:23', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('374', '星空C20170107170224.jpg', 'D:/upload/20170107\\星空C20170107170224.jpg', '2017-01-07 17:02:24', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('375', '星空C20170107170224.jpg', 'D:/upload/20170107\\星空C20170107170224.jpg', '2017-01-07 17:02:24', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('376', '星空C20170107170225.jpg', 'D:/upload/20170107\\星空C20170107170225.jpg', '2017-01-07 17:02:25', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('377', '星空C20170107170226.jpg', 'D:/upload/20170107\\星空C20170107170226.jpg', '2017-01-07 17:02:26', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('378', '星空C20170107170227.jpg', 'D:/upload/20170107\\星空C20170107170227.jpg', '2017-01-07 17:02:27', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('379', '星空C20170107170228.jpg', 'D:/upload/20170107\\星空C20170107170228.jpg', '2017-01-07 17:02:28', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('380', '星空C20170107170229.jpg', 'D:/upload/20170107\\星空C20170107170229.jpg', '2017-01-07 17:02:29', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('381', '星空C20170107170230.jpg', 'D:/upload/20170107\\星空C20170107170230.jpg', '2017-01-07 17:02:30', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('382', '星空C20170107170231.jpg', 'D:/upload/20170107\\星空C20170107170231.jpg', '2017-01-07 17:02:31', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('383', '星空C20170107170232.jpg', 'D:/upload/20170107\\星空C20170107170232.jpg', '2017-01-07 17:02:32', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('384', '星空C20170107170233.jpg', 'D:/upload/20170107\\星空C20170107170233.jpg', '2017-01-07 17:02:33', '2', '371361497', null, null, null, null, null);
INSERT INTO `file` VALUES ('385', '雷电20170107173644.jpg', 'D:/upload/20170107\\雷电20170107173644.jpg', '2017-01-07 17:36:44', '2', '371361494', null, null, null, null, null);
INSERT INTO `file` VALUES ('386', 'DSC_207020170109152236.jpg', 'D:/upload/20170109\\DSC_207020170109152236.jpg', '2017-01-09 15:22:36', '2', '371361500', null, null, null, null, null);
INSERT INTO `file` VALUES ('387', '肥肥20170109153707.jpg', 'D:/upload/20170109\\肥肥20170109153707.jpg', '2017-01-09 15:37:07', '3', '3', null, null, null, null, null);
INSERT INTO `file` VALUES ('388', '二次元_020170109161225.jpeg', 'D:/upload/20170109\\二次元_020170109161225.jpeg', '2017-01-09 16:12:26', '2', '371361504', null, null, null, null, null);
INSERT INTO `file` VALUES ('389', '二次元_020170109161331.jpeg', 'D:/upload/20170109\\二次元_020170109161331.jpeg', '2017-01-09 16:13:31', '2', '371361504', null, null, null, null, null);
INSERT INTO `file` VALUES ('390', '二次元_020170109161731.jpeg', 'D:/upload/20170109\\二次元_020170109161731.jpeg', '2017-01-09 16:17:31', '2', '371361505', '1', null, null, null, null);
INSERT INTO `file` VALUES ('391', '机器猫20170109161748.jpg', 'D:/upload/20170109\\机器猫20170109161748.jpg', '2017-01-09 16:17:48', '2', '371361505', '1', null, null, null, null);
INSERT INTO `file` VALUES ('392', '天安门20170109162341.jpg', 'D:/upload/20170109\\天安门20170109162341.jpg', '2017-01-09 16:23:41', '2', '371361506', '1', null, null, null, null);
INSERT INTO `file` VALUES ('398', '二次元_020170111145847.jpeg', 'D:/upload/20170111\\二次元_020170111145847.jpeg', '2017-01-11 14:58:47', '2', '371361549', '1', null, null, null, null);
INSERT INTO `file` VALUES ('399', '天安门20170111150612.jpg', 'D:/upload/20170111\\天安门20170111150612.jpg', '2017-01-11 15:06:12', '2', '371361551', '1', null, null, null, null);
INSERT INTO `file` VALUES ('400', '暴风截图201631693925020170111151824.jpg', 'D:/upload/20170111\\暴风截图201631693925020170111151824.jpg', '2017-01-11 15:18:24', '2', '371361554', '1', null, null, null, null);
INSERT INTO `file` VALUES ('401', 'DSC_207020170111152848.jpg', 'D:/upload/20170111\\DSC_207020170111152848.jpg', '2017-01-11 15:28:48', '2', '371361555', '1', null, null, null, null);
INSERT INTO `file` VALUES ('402', '上海20170112091040.jpg', 'D:/upload/20170112\\上海20170112091040.jpg', '2017-01-12 09:10:40', '2', '371361567', '1', null, null, null, null);
INSERT INTO `file` VALUES ('403', '狗狗20170112102816.jpg', 'D:/upload/20170112\\狗狗20170112102816.jpg', '2017-01-12 10:28:16', '2', '371361546', '1', null, null, null, null);
INSERT INTO `file` VALUES ('404', '故宫20170112103501.jpg', 'D:/upload/20170112\\故宫20170112103501.jpg', '2017-01-12 10:35:01', '2', '371361573', '1', null, null, null, null);
INSERT INTO `file` VALUES ('405', '肥肥20170112144232.jpg', 'D:/upload/20170112\\肥肥20170112144232.jpg', '2017-01-12 14:42:32', '2', '371361546', '1', null, null, null, null);
INSERT INTO `file` VALUES ('406', '壶口瀑布20170113093616.jpg', 'D:/upload/20170113\\壶口瀑布20170113093616.jpg', '2017-01-13 09:36:16', '2', null, '1', null, null, null, null);
INSERT INTO `file` VALUES ('407', '地图20170113094918.jpg', 'D:/upload/20170113\\地图20170113094918.jpg', '2017-01-13 09:49:18', '2', '371361116', '1', null, null, null, null);
INSERT INTO `file` VALUES ('408', '地图20170113094919.jpg', 'D:/upload/20170113\\地图20170113094919.jpg', '2017-01-13 09:49:19', '3', '371361116', '1', null, null, null, null);
INSERT INTO `file` VALUES ('409', '地图20170113141932.jpg', 'D:/upload/20170113\\地图20170113141932.jpg', '2017-01-13 14:19:32', '2', '371361116', '1', null, null, null, null);
INSERT INTO `file` VALUES ('410', '壶口瀑布20170113152248.jpg', 'D:/upload/20170113\\壶口瀑布20170113152248.jpg', '2017-01-13 15:22:48', '2', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('411', 'hismap20170114165142.js', 'D:/upload/20170114\\hismap20170114165142.js', '2017-01-14 16:51:42', '3', '371361618', '1', null, null, null, null);
INSERT INTO `file` VALUES ('412', '暴风截图201631693925020170118095022.jpg', 'D:/upload/20170118/暴风截图201631693925020170118095022.jpg', '2017-01-18 09:50:22', '3', '371361619', '1', null, null, null, null);
INSERT INTO `file` VALUES ('413', 'DSC_207020170119150636.jpg', 'D:/upload/20170119\\DSC_207020170119150636.jpg', '2017-01-19 15:06:36', '2', '5', '1', null, null, null, null);
INSERT INTO `file` VALUES ('414', 'DSC_207020170119150637.jpg', 'D:/upload/20170119\\DSC_207020170119150637.jpg', '2017-01-19 15:06:37', '2', '5', '1', null, null, null, null);
INSERT INTO `file` VALUES ('415', 'DSC_207020170119150639.jpg', 'D:/upload/20170119\\DSC_207020170119150639.jpg', '2017-01-19 15:06:39', '3', '5', '1', null, null, null, null);
INSERT INTO `file` VALUES ('416', 'DSC_207020170119150640.jpg', 'D:/upload/20170119\\DSC_207020170119150640.jpg', '2017-01-19 15:06:40', '3', '5', '1', null, null, null, null);
INSERT INTO `file` VALUES ('417', '壶口瀑布20170119150647.jpg', 'D:/upload/20170119\\壶口瀑布20170119150647.jpg', '2017-01-19 15:06:47', '2', '5', '1', null, null, null, null);
INSERT INTO `file` VALUES ('418', '14192973420170206161414.jpg', 'D:/upload/20170206\\14192973420170206161414.jpg', '2017-02-06 16:14:14', '3', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('419', '6-2统计信息（地域）20170206161519.jpg', 'D:/upload/20170206\\6-2统计信息（地域）20170206161519.jpg', '2017-02-06 16:15:19', '2', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('420', '6-1统计信息（时间）20170206161545.jpg', 'D:/upload/20170206\\6-1统计信息（时间）20170206161545.jpg', '2017-02-06 16:15:45', '3', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('421', '路演实施文档及使用教程20170206161630.docx', 'D:/upload/20170206\\路演实施文档及使用教程20170206161630.docx', '2017-02-06 16:16:30', '3', '371361547', '1', null, null, null, null);
INSERT INTO `file` VALUES ('422', 'Shiro教程20170206161657.pdf', 'D:/upload/20170206\\Shiro教程20170206161657.pdf', '2017-02-06 16:16:57', '2', '371361547', '1', null, null, null, null);
INSERT INTO `file` VALUES ('423', '1624214Y5-020170206181302.gif', '/home/zyb/upload/20170206/1624214Y5-020170206181302.gif', '2017-02-06 18:13:02', '2', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('424', '120170206181314.jpg', '/home/zyb/upload/20170206/120170206181314.jpg', '2017-02-06 18:13:14', '3', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('425', '120170206181314.jpg', '/home/zyb/upload/20170206/120170206181314.jpg', '2017-02-06 18:13:14', '3', '371361612', '1', null, null, null, null);
INSERT INTO `file` VALUES ('426', '附件1：报价系统公司债券监管信息系统需求说明书20170207091115.doc', '/home/zyb/upload/20170207/附件1：报价系统公司债券监管信息系统需求说明书20170207091115.doc', '2017-02-07 09:11:15', '2', '371361625', '1', null, null, null, null);
INSERT INTO `file` VALUES ('427', '雷电20170207091510.jpg', 'D:/upload/20170207\\雷电20170207091510.jpg', '2017-02-07 09:15:10', '2', '46', '1', null, null, null, null);
INSERT INTO `file` VALUES ('428', '附件1：报价系统公司债券监管信息系统需求说明书20170207093357.doc', '/home/zyb/upload/20170207/附件1：报价系统公司债券监管信息系统需求说明书20170207093357.doc', '2017-02-07 09:33:57', '2', '371361643', '1', null, null, null, null);
INSERT INTO `file` VALUES ('429', '附件1：报价系统公司债券监管信息系统需求说明书20170207122204.doc', '/home/zyb/upload/20170207/附件1：报价系统公司债券监管信息系统需求说明书20170207122204.doc', '2017-02-07 12:22:04', '2', '371361644', '1', null, null, null, null);
INSERT INTO `file` VALUES ('430', 'ABS示例20170207122257.jpg', '/home/zyb/upload/20170207/ABS示例20170207122257.jpg', '2017-02-07 12:22:57', '3', '371361645', '1', null, null, null, null);
INSERT INTO `file` VALUES ('431', 'ABS示例20170207122300.jpg', '/home/zyb/upload/20170207/ABS示例20170207122300.jpg', '2017-02-07 12:23:00', '2', '371361645', '1', null, null, null, null);
INSERT INTO `file` VALUES ('432', '报价系统公司债券监管信息系统需求说明书-债券20170207150417.doc', '/home/zyb/upload/20170207/报价系统公司债券监管信息系统需求说明书-债券20170207150417.doc', '2017-02-07 15:04:17', '2', '371361612', '1', '解决', null, null, null);
INSERT INTO `file` VALUES ('433', '星空C20170208093139.jpg', 'D:/upload/20170208\\星空C20170208093139.jpg', '2017-02-08 09:31:39', '2', '371361649', '1', null, null, null, null);
INSERT INTO `file` VALUES ('434', '沛县20170208093348.jpg', 'D:/upload/20170208\\沛县20170208093348.jpg', '2017-02-08 09:33:48', '2', '371361648', '1', null, null, null, null);
INSERT INTO `file` VALUES ('435', '沛县20170208093351.jpg', 'D:/upload/20170208\\沛县20170208093351.jpg', '2017-02-08 09:33:51', '2', '371361648', '1', null, null, null, null);
INSERT INTO `file` VALUES ('436', '张家界20170208093401.jpg', 'D:/upload/20170208\\张家界20170208093401.jpg', '2017-02-08 09:34:01', '2', '371361648', '1', null, null, null, null);
INSERT INTO `file` VALUES ('437', '故宫20170208094114.jpg', 'D:/upload/20170208\\故宫20170208094114.jpg', '2017-02-08 09:41:14', '2', '371361659', '1', null, null, null, null);
INSERT INTO `file` VALUES ('438', '张家界20170208095905.jpg', 'D:/upload/20170208\\张家界20170208095905.jpg', '2017-02-08 09:59:05', '2', '47', '1', null, null, null, null);
INSERT INTO `file` VALUES ('439', '壶口瀑布20170209155354.jpg', 'D:/upload/20170209\\壶口瀑布20170209155354.jpg', '2017-02-09 15:53:54', '2', '371361708', '1', null, null, null, null);
INSERT INTO `file` VALUES ('440', '机器猫20170209160640.jpg', 'D:/upload/20170209\\机器猫20170209160640.jpg', '2017-02-09 16:06:40', '2', '371361723', '1', null, null, null, null);
INSERT INTO `file` VALUES ('441', '天安门20170209162751.jpg', 'D:/upload/20170209\\天安门20170209162751.jpg', '2017-02-09 16:27:51', '2', '371361728', '1', null, null, null, null);
INSERT INTO `file` VALUES ('442', '壶口瀑布20170210090557.jpg', 'D:/upload/20170210\\壶口瀑布20170210090557.jpg', '2017-02-10 09:05:57', '2', '371361733', '1', '户口瀑布', '中证报价', null, null);
INSERT INTO `file` VALUES ('443', '壶口瀑布20170210090612.jpg', 'D:/upload/20170210\\壶口瀑布20170210090612.jpg', '2017-02-10 09:06:12', '3', '371361733', '1', '户口瀑布', '中证报价', null, null);
INSERT INTO `file` VALUES ('444', '壶口瀑布20170210090613.jpg', 'D:/upload/20170210\\壶口瀑布20170210090613.jpg', '2017-02-10 09:06:13', '2', '371361733', '1', '户口瀑布', '中证报价', null, null);
INSERT INTO `file` VALUES ('445', '大山20170210110651.jpg', 'D:/upload/20170210\\大山20170210110651.jpg', '2017-02-10 11:06:51', '2', '371361736', '1', '哈哈大山', '中证报价', null, null);
INSERT INTO `file` VALUES ('446', '喵星人20170210111708.jpg', 'D:/upload/20170210\\喵星人20170210111708.jpg', '2017-02-10 11:17:08', '2', '371361737', '1', '猫猫', '中证报价', null, null);
INSERT INTO `file` VALUES ('447', 'back20170210112015.jpg', 'D:/upload/20170210\\back20170210112015.jpg', '2017-02-10 11:20:15', '2', '371361670', '1', null, null, null, null);
INSERT INTO `file` VALUES ('448', '二次元_020170210135138.jpeg', 'D:/upload/20170210\\二次元_020170210135138.jpeg', '2017-02-10 13:51:38', '2', '371361738', '1', '萝莉', '中证报价', null, null);
INSERT INTO `file` VALUES ('449', '沛县20170210140832.jpg', 'D:/upload/20170210\\沛县20170210140832.jpg', '2017-02-10 14:08:32', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('450', '沛县20170210140834.jpg', 'D:/upload/20170210\\沛县20170210140834.jpg', '2017-02-10 14:08:34', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('451', '沛县20170210140835.jpg', 'D:/upload/20170210\\沛县20170210140835.jpg', '2017-02-10 14:08:35', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('452', '沛县20170210140935.jpg', 'D:/upload/20170210\\沛县20170210140935.jpg', '2017-02-10 14:09:35', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('453', '沛县20170210140936.jpg', 'D:/upload/20170210\\沛县20170210140936.jpg', '2017-02-10 14:09:36', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('454', '沛县20170210140936.jpg', 'D:/upload/20170210\\沛县20170210140936.jpg', '2017-02-10 14:09:36', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('455', '沛县20170210140936.jpg', 'D:/upload/20170210\\沛县20170210140936.jpg', '2017-02-10 14:09:36', '2', '371361739', '1', '啪啪嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('456', '壶口瀑布20170210140948.jpg', 'D:/upload/20170210\\壶口瀑布20170210140948.jpg', '2017-02-10 14:09:48', '2', '371361739', '1', '啪啪嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('457', '壶口瀑布20170210141008.jpg', 'D:/upload/20170210\\壶口瀑布20170210141008.jpg', '2017-02-10 14:10:08', '2', '371361740', '1', '', '中证报价', null, null);
INSERT INTO `file` VALUES ('458', '壶口瀑布20170210141014.jpg', 'D:/upload/20170210\\壶口瀑布20170210141014.jpg', '2017-02-10 14:10:14', '2', '371361740', '1', '‘’啦啦啦', '中证报价', null, null);
INSERT INTO `file` VALUES ('459', '地图20170210143330.jpg', 'D:/upload/20170210\\地图20170210143330.jpg', '2017-02-10 14:33:30', '2', '371361741', '1', ' 坎坎坷坷扩', '中证报价', null, null);
INSERT INTO `file` VALUES ('460', '壶口瀑布20170210145001.jpg', 'D:/upload/20170210\\壶口瀑布20170210145001.jpg', '2017-02-10 14:50:01', '2', '371361748', '1', '灌灌灌灌灌', '中证报价', null, null);
INSERT INTO `file` VALUES ('461', '地图20170210145031.jpg', 'D:/upload/20170210\\地图20170210145031.jpg', '2017-02-10 14:50:31', '2', '371361749', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('462', '二次元_020170210145220.jpeg', 'D:/upload/20170210\\二次元_020170210145220.jpeg', '2017-02-10 14:52:20', '2', '371361750', '1', '发vvvvvvv', '中证报价', null, null);
INSERT INTO `file` VALUES ('463', '二次元_020170210145331.jpeg', 'D:/upload/20170210\\二次元_020170210145331.jpeg', '2017-02-10 14:53:31', '2', '371361751', '1', '啦啦啦啦啦', '中证报价', null, null);
INSERT INTO `file` VALUES ('464', '二次元_020170210145436.jpeg', 'D:/upload/20170210\\二次元_020170210145436.jpeg', '2017-02-10 14:54:36', '2', '371361751', '1', '啦啦啦啦啦', '中证报价', null, null);
INSERT INTO `file` VALUES ('465', '壶口瀑布20170210145446.jpg', 'D:/upload/20170210\\壶口瀑布20170210145446.jpg', '2017-02-10 14:54:46', '2', '371361752', '1', '福福福福福福福福福', '中证报价', null, null);
INSERT INTO `file` VALUES ('466', '小男孩20170210145558.jpeg', 'D:/upload/20170210\\小男孩20170210145558.jpeg', '2017-02-10 14:55:58', '2', '371361753', '1', '嘎嘎嘎嘎嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('467', '壶口瀑布20170210150211.jpg', 'D:/upload/20170210\\壶口瀑布20170210150211.jpg', '2017-02-10 15:02:11', '2', '371361754', '1', '广告嘎嘎嘎过古古怪怪', '中证报价', null, null);
INSERT INTO `file` VALUES ('468', '机器猫20170210150317.jpg', 'D:/upload/20170210\\机器猫20170210150317.jpg', '2017-02-10 15:03:17', '2', '371361755', '1', '叫姐姐', '中证报价', null, null);
INSERT INTO `file` VALUES ('469', '机器猫20170210150353.jpg', 'D:/upload/20170210\\机器猫20170210150353.jpg', '2017-02-10 15:03:53', '2', '371361756', '1', '大的断电', '中证报价', null, null);
INSERT INTO `file` VALUES ('470', '62820170210150719.jpg', 'D:/upload/20170210\\62820170210150719.jpg', '2017-02-10 15:07:19', '3', '371361757', '1', '哈哈哈哈哈哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('471', '62820170210150729.jpg', 'D:/upload/20170210\\62820170210150729.jpg', '2017-02-10 15:07:29', '2', '371361757', '1', '哈哈哈哈哈哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('472', '故宫20170210151000.jpg', 'D:/upload/20170210\\故宫20170210151000.jpg', '2017-02-10 15:10:00', '2', '371361759', '1', '啊啊啊', '中证报价', null, null);
INSERT INTO `file` VALUES ('473', '壶口瀑布20170210151148.jpg', 'D:/upload/20170210\\壶口瀑布20170210151148.jpg', '2017-02-10 15:11:48', '2', '371361760', '1', '坎坎坷坷', '中证报价', null, null);
INSERT INTO `file` VALUES ('474', '沛县20170210152922.jpg', 'D:/upload/20170210\\沛县20170210152922.jpg', '2017-02-10 15:29:22', '2', '371361761', '1', '，模块，。、', '中证报价', null, null);
INSERT INTO `file` VALUES ('475', '地图20170210154638.jpg', 'D:/upload/20170210\\地图20170210154638.jpg', '2017-02-10 15:46:38', '2', '371361761', '1', '福福福福福福福福福到底', '中证报价', null, null);
INSERT INTO `file` VALUES ('476', '地图20170210160056.jpg', 'D:/upload/20170210\\地图20170210160056.jpg', '2017-02-10 16:00:56', '2', '371361762', '1', '中证', '中证报价', null, null);
INSERT INTO `file` VALUES ('477', '大山20170210160158.jpg', 'D:/upload/20170210\\大山20170210160158.jpg', '2017-02-10 16:01:58', '2', '371361763', '1', '发反反复复', '中证报价', null, null);
INSERT INTO `file` VALUES ('478', '壶口瀑布20170210160226.jpg', 'D:/upload/20170210\\壶口瀑布20170210160226.jpg', '2017-02-10 16:02:26', '2', '371361764', '1', '广告嘎嘎嘎过古古怪怪过', '中证报价', null, null);
INSERT INTO `file` VALUES ('479', '壶口瀑布20170210160226.jpg', 'D:/upload/20170210\\壶口瀑布20170210160226.jpg', '2017-02-10 16:02:26', '2', '371361764', '1', '广告嘎嘎嘎过古古怪怪过', '中证报价', null, null);
INSERT INTO `file` VALUES ('480', '地图20170210160659.jpg', 'D:/upload/20170210\\地图20170210160659.jpg', '2017-02-10 16:06:59', '2', '371361765', '1', 'sad', '中证报价', null, null);
INSERT INTO `file` VALUES ('481', '大山20170210160759.jpg', 'D:/upload/20170210\\大山20170210160759.jpg', '2017-02-10 16:07:59', '2', '371361766', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('482', '地图20170210160951.jpg', 'D:/upload/20170210\\地图20170210160951.jpg', '2017-02-10 16:09:51', '2', '371361767', '1', '大', '中证报价', null, null);
INSERT INTO `file` VALUES ('483', '地图20170210161330.jpg', 'D:/upload/20170210\\地图20170210161330.jpg', '2017-02-10 16:13:30', '2', '371361768', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('484', '地图20170210161449.jpg', 'D:/upload/20170210\\地图20170210161449.jpg', '2017-02-10 16:14:49', '2', '371361770', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('485', '二次元_020170210161537.jpeg', 'D:/upload/20170210\\二次元_020170210161537.jpeg', '2017-02-10 16:15:37', '2', '371361771', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('486', '二次元_020170210162000.jpeg', 'D:/upload/20170210\\二次元_020170210162000.jpeg', '2017-02-10 16:20:00', '2', '371361772', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('487', '二次元_020170210162147.jpeg', 'D:/upload/20170210\\二次元_020170210162147.jpeg', '2017-02-10 16:21:47', '2', '371361773', '1', '三大', '中证报价', null, null);
INSERT INTO `file` VALUES ('488', '二次元_020170210162221.jpeg', 'D:/upload/20170210\\二次元_020170210162221.jpeg', '2017-02-10 16:22:21', '2', '371361774', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('489', '二次元_020170210162251.jpeg', 'D:/upload/20170210\\二次元_020170210162251.jpeg', '2017-02-10 16:22:51', '2', '371361774', '1', '大神', '中证报价', null, null);
INSERT INTO `file` VALUES ('490', '二次元_020170210162354.jpeg', 'D:/upload/20170210\\二次元_020170210162354.jpeg', '2017-02-10 16:23:54', '2', '371361775', '1', 'das ', '中证报价', null, null);
INSERT INTO `file` VALUES ('491', '二次元_020170210163426.jpeg', 'D:/upload/20170210\\二次元_020170210163426.jpeg', '2017-02-10 16:34:26', '2', '371361775', '1', 'das fgfff', '中证报价', null, null);
INSERT INTO `file` VALUES ('492', '大山20170210165450.jpg', 'D:/upload/20170210\\大山20170210165450.jpg', '2017-02-10 16:54:50', '2', '371361777', '1', 'ggg', '中证报价', null, null);
INSERT INTO `file` VALUES ('493', '二次元_020170210165751.jpeg', 'D:/upload/20170210\\二次元_020170210165751.jpeg', '2017-02-10 16:57:51', '2', '371361778', '1', 'vvvvvvv', '中证报价', null, null);
INSERT INTO `file` VALUES ('494', '地图20170210170335.jpg', 'D:/upload/20170210\\地图20170210170335.jpg', '2017-02-10 17:03:35', '2', '371361781', '1', 'vfbn', '中证报价', null, null);
INSERT INTO `file` VALUES ('495', '二次元_020170210170511.jpeg', 'D:/upload/20170210\\二次元_020170210170511.jpeg', '2017-02-10 17:05:11', '2', '371361782', '1', 'nnn', '中证报价', null, null);
INSERT INTO `file` VALUES ('496', '二次元_020170210170726.jpeg', 'D:/upload/20170210\\二次元_020170210170726.jpeg', '2017-02-10 17:07:26', '2', '371361783', '1', 'ffffffff', '中证报价', null, null);
INSERT INTO `file` VALUES ('497', '二次元_020170210170754.jpeg', 'D:/upload/20170210\\二次元_020170210170754.jpeg', '2017-02-10 17:07:54', '2', '371361784', '1', 'fghgfh', '中证报价', null, null);
INSERT INTO `file` VALUES ('498', '地图20170210170927.jpg', 'D:/upload/20170210\\地图20170210170927.jpg', '2017-02-10 17:09:27', '2', '371361785', '1', '6213', '中证报价', null, null);
INSERT INTO `file` VALUES ('499', '二次元_020170210171414.jpeg', 'D:/upload/20170210\\二次元_020170210171414.jpeg', '2017-02-10 17:14:14', '2', '371361786', '1', '11', '中证报价', null, null);
INSERT INTO `file` VALUES ('500', '二次元_020170210171424.jpeg', 'D:/upload/20170210\\二次元_020170210171424.jpeg', '2017-02-10 17:14:24', '2', '371361786', '1', '324324', '中证报价', null, null);
INSERT INTO `file` VALUES ('501', '二次元_020170210171717.jpeg', 'D:/upload/20170210\\二次元_020170210171717.jpeg', '2017-02-10 17:17:17', '2', '371361787', '1', 'fd', '中证报价', null, null);
INSERT INTO `file` VALUES ('502', '二次元_020170210171902.jpeg', 'D:/upload/20170210\\二次元_020170210171902.jpeg', '2017-02-10 17:19:02', '2', '371361788', '1', '3242', '中证报价', null, null);
INSERT INTO `file` VALUES ('503', '二次元_020170210171906.jpeg', 'D:/upload/20170210\\二次元_020170210171906.jpeg', '2017-02-10 17:19:06', '2', '371361788', '1', '3242', '中证报价', null, null);
INSERT INTO `file` VALUES ('504', '二次元_020170210171908.jpeg', 'D:/upload/20170210\\二次元_020170210171908.jpeg', '2017-02-10 17:19:08', '2', '371361788', '1', '3242', '中证报价', null, null);
INSERT INTO `file` VALUES ('505', '二次元_020170210171931.jpeg', 'D:/upload/20170210\\二次元_020170210171931.jpeg', '2017-02-10 17:19:31', '2', '371361788', '1', '3242', '中证报价', null, null);
INSERT INTO `file` VALUES ('506', '机器猫20170210172111.jpg', 'D:/upload/20170210\\机器猫20170210172111.jpg', '2017-02-10 17:21:11', '2', '371361789', '1', 'sdfsf', '中证报价', null, null);
INSERT INTO `file` VALUES ('507', '沛县20170210172242.jpg', 'D:/upload/20170210\\沛县20170210172242.jpg', '2017-02-10 17:22:42', '3', '371361790', '1', '来了来了里', '中证报价', null, null);
INSERT INTO `file` VALUES ('508', '二次元_020170210172334.jpeg', 'D:/upload/20170210\\二次元_020170210172334.jpeg', '2017-02-10 17:23:34', '3', '371361791', '1', '1212', '中证报价', null, null);
INSERT INTO `file` VALUES ('509', '二次元_020170210172745.jpeg', 'D:/upload/20170210\\二次元_020170210172745.jpeg', '2017-02-10 17:27:45', '3', '371361792', '1', '324324', '中证报价', null, null);
INSERT INTO `file` VALUES ('510', '地图20170213090509.jpg', 'D:/upload/20170213\\地图20170213090509.jpg', '2017-02-13 09:05:09', '3', '371361793', '1', '仿佛', '中证报价', null, null);
INSERT INTO `file` VALUES ('511', '天安门20170213091316.jpg', 'D:/upload/20170213\\天安门20170213091316.jpg', '2017-02-13 09:13:16', '3', '371361794', '1', '我奥比就', '中证报价', null, null);
INSERT INTO `file` VALUES ('512', '地图20170213091347.jpg', 'D:/upload/20170213\\地图20170213091347.jpg', '2017-02-13 09:13:47', '2', '371361794', '1', '我奥比就哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('513', '芦芽山20170213091914.jpg', 'D:/upload/20170213\\芦芽山20170213091914.jpg', '2017-02-13 09:19:14', '3', '371361795', '1', '芦芽山那你', '中证报价', null, null);
INSERT INTO `file` VALUES ('514', '大山20170213092001.jpg', 'D:/upload/20170213\\大山20170213092001.jpg', '2017-02-13 09:20:01', '2', '371361796', '1', '水水水水', '中证报价', null, null);
INSERT INTO `file` VALUES ('515', '壶口瀑布20170213092147.jpg', 'D:/upload/20170213\\壶口瀑布20170213092147.jpg', '2017-02-13 09:21:47', '2', '371361797', '1', '哈哈哈哈哈哈哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('516', '壶口瀑布20170213092242.jpg', 'D:/upload/20170213\\壶口瀑布20170213092242.jpg', '2017-02-13 09:22:42', '2', '371361798', '1', '', '中证报价', null, null);
INSERT INTO `file` VALUES ('517', '壶口瀑布20170213092249.jpg', 'D:/upload/20170213\\壶口瀑布20170213092249.jpg', '2017-02-13 09:22:49', '3', '371361798', '1', '打断点', '中证报价', null, null);
INSERT INTO `file` VALUES ('518', '沛县20170213092652.jpg', 'D:/upload/20170213\\沛县20170213092652.jpg', '2017-02-13 09:26:52', '2', '371361798', '1', '京津冀', '中证报价', null, null);
INSERT INTO `file` VALUES ('519', '壶口瀑布20170213094419.jpg', 'D:/upload/20170213\\壶口瀑布20170213094419.jpg', '2017-02-13 09:44:19', '3', '371361799', '1', '嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('520', '壶口瀑布20170213094746.jpg', 'D:/upload/20170213\\壶口瀑布20170213094746.jpg', '2017-02-13 09:47:46', '2', '371361799', '1', '嘎嘎嘎类里面', '中证报价', null, null);
INSERT INTO `file` VALUES ('521', '卡通20170213094934.jpeg', 'D:/upload/20170213\\卡通20170213094934.jpeg', '2017-02-13 09:49:34', '3', '371361800', '1', '灌灌灌灌灌', '中证报价', null, null);
INSERT INTO `file` VALUES ('522', '卡通20170213095038.jpeg', 'D:/upload/20170213\\卡通20170213095038.jpeg', '2017-02-13 09:50:38', '2', '371361800', '1', '灌灌灌灌灌哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('523', '卡通20170213095210.jpeg', 'D:/upload/20170213\\卡通20170213095210.jpeg', '2017-02-13 09:52:10', '2', '371361800', '1', '灌灌', '中证报价', null, null);
INSERT INTO `file` VALUES ('524', '二次元_020170213095325.jpeg', 'D:/upload/20170213\\二次元_020170213095325.jpeg', '2017-02-13 09:53:25', '3', '371361801', '1', '高规格', '中证报价', null, null);
INSERT INTO `file` VALUES ('525', '壶口瀑布20170213100123.jpg', 'D:/upload/20170213\\壶口瀑布20170213100123.jpg', '2017-02-13 10:01:23', '3', '371361803', '1', 'uuuu', '中证报价', null, null);
INSERT INTO `file` VALUES ('526', '壶口瀑布20170213100308.jpg', 'D:/upload/20170213\\壶口瀑布20170213100308.jpg', '2017-02-13 10:03:08', '2', '371361803', '1', 'uuuu规范', '中证报价', null, null);
INSERT INTO `file` VALUES ('527', '壶口瀑布20170213100329.jpg', 'D:/upload/20170213\\壶口瀑布20170213100329.jpg', '2017-02-13 10:03:29', '2', '371361804', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('528', '二次元_020170213101039.jpeg', 'D:/upload/20170213\\二次元_020170213101039.jpeg', '2017-02-13 10:10:39', '2', '371361809', '1', '豆腐干', '中证报价', null, null);
INSERT INTO `file` VALUES ('529', '地图20170213101321.jpg', 'D:/upload/20170213\\地图20170213101321.jpg', '2017-02-13 10:13:21', '2', '371361810', '1', '显示', '中证报价', null, null);
INSERT INTO `file` VALUES ('530', '二次元_020170213102057.jpeg', 'D:/upload/20170213\\二次元_020170213102057.jpeg', '2017-02-13 10:20:57', '3', '371361811', '1', '55256', '中证报价', null, null);
INSERT INTO `file` VALUES ('531', '二次元_020170213102435.jpeg', 'D:/upload/20170213\\二次元_020170213102435.jpeg', '2017-02-13 10:24:35', '2', '371361811', '1', '55256', '中证报价', null, null);
INSERT INTO `file` VALUES ('532', '地图20170213102542.jpg', 'D:/upload/20170213\\地图20170213102542.jpg', '2017-02-13 10:25:42', '3', '371361812', '1', '53131', '中证报价', null, null);
INSERT INTO `file` VALUES ('533', '地图20170213102546.jpg', 'D:/upload/20170213\\地图20170213102546.jpg', '2017-02-13 10:25:46', '3', '371361812', '1', '53131', '中证报价', null, null);
INSERT INTO `file` VALUES ('534', '地图20170213104000.jpg', 'D:/upload/20170213\\地图20170213104000.jpg', '2017-02-13 10:40:00', '3', '371361812', '1', '53131', '中证报价', null, null);
INSERT INTO `file` VALUES ('535', '地图20170213104005.jpg', 'D:/upload/20170213\\地图20170213104005.jpg', '2017-02-13 10:40:05', '3', '371361812', '1', '53131仿佛', '中证报价', null, null);
INSERT INTO `file` VALUES ('536', '天安门20170213104422.jpg', 'D:/upload/20170213\\天安门20170213104422.jpg', '2017-02-13 10:44:22', '3', '371361812', '1', '佛', '中证报价', null, null);
INSERT INTO `file` VALUES ('537', '天安门20170213104649.jpg', 'D:/upload/20170213\\天安门20170213104649.jpg', '2017-02-13 10:46:49', '3', '371361812', '1', '啊那啊', '中证报价', null, null);
INSERT INTO `file` VALUES ('538', '壶口瀑布20170213105051.jpg', 'D:/upload/20170213\\壶口瀑布20170213105051.jpg', '2017-02-13 10:50:51', '3', '371361813', '1', '就', '中证报价', null, null);
INSERT INTO `file` VALUES ('539', '壶口瀑布20170213105102.jpg', 'D:/upload/20170213\\壶口瀑布20170213105102.jpg', '2017-02-13 10:51:02', '3', '371361813', '1', '就地方', '中证报价', null, null);
INSERT INTO `file` VALUES ('540', '机器猫20170213105109.jpg', 'D:/upload/20170213\\机器猫20170213105109.jpg', '2017-02-13 10:51:09', '2', '371361813', '1', '地方仿佛', '中证报价', null, null);
INSERT INTO `file` VALUES ('541', '壶口瀑布20170213105325.jpg', 'D:/upload/20170213\\壶口瀑布20170213105325.jpg', '2017-02-13 10:53:25', '3', '371361814', '1', '，，', '中证报价', null, null);
INSERT INTO `file` VALUES ('542', '大山20170213105333.jpg', 'D:/upload/20170213\\大山20170213105333.jpg', '2017-02-13 10:53:33', '2', '371361814', '1', '，解决', '中证报价', null, null);
INSERT INTO `file` VALUES ('543', '大山20170213111026.jpg', 'D:/upload/20170213\\大山20170213111026.jpg', '2017-02-13 11:10:26', '3', '371361814', '1', '，解决', '中证报价', null, null);
INSERT INTO `file` VALUES ('544', '大山20170213111644.jpg', 'D:/upload/20170213\\大山20170213111644.jpg', '2017-02-13 11:16:44', '2', '71', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('545', '地图20170213111648.jpg', 'D:/upload/20170213\\地图20170213111648.jpg', '2017-02-13 11:16:48', '3', '71', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('546', '地图20170213111649.jpg', 'D:/upload/20170213\\地图20170213111649.jpg', '2017-02-13 11:16:49', '2', '71', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('547', '大山20170213112239.jpg', 'D:/upload/20170213\\大山20170213112239.jpg', '2017-02-13 11:22:39', '2', '371361814', '1', '，解决', '中证报价', null, null);
INSERT INTO `file` VALUES ('548', '壶口瀑布20170213112245.jpg', 'D:/upload/20170213\\壶口瀑布20170213112245.jpg', '2017-02-13 11:22:45', '2', '371361814', '1', '，解决vdx', '中证报价', null, null);
INSERT INTO `file` VALUES ('549', '喵星人20170213135953.jpg', 'D:/upload/20170213\\喵星人20170213135953.jpg', '2017-02-13 13:59:53', '2', '371361819', '1', '来了来了', '中证报价', null, null);
INSERT INTO `file` VALUES ('550', '壶口瀑布20170213150555.jpg', 'D:/upload/20170213\\壶口瀑布20170213150555.jpg', '2017-02-13 15:05:55', '2', '371361820', '1', '高规格高规格', '中证报价', null, null);
INSERT INTO `file` VALUES ('551', '壶口瀑布20170213151131.jpg', 'D:/upload/20170213\\壶口瀑布20170213151131.jpg', '2017-02-13 15:11:31', '2', '371361821', '1', '京津冀急急急', '中证报价', null, null);
INSERT INTO `file` VALUES ('552', '沛县20170213151211.jpg', 'D:/upload/20170213\\沛县20170213151211.jpg', '2017-02-13 15:12:11', '2', '371361822', '1', '沛县好美', '中证报价', null, null);
INSERT INTO `file` VALUES ('553', '小男孩20170213153357.jpeg', 'D:/upload/20170213\\小男孩20170213153357.jpeg', '2017-02-13 15:33:57', '2', '371361825', '1', '二三', '中证报价', null, null);
INSERT INTO `file` VALUES ('554', '壶口瀑布20170213164628.jpg', 'D:/upload/20170213\\壶口瀑布20170213164628.jpg', '2017-02-13 16:46:28', '2', '371361831', '1', '经济', '中证报价', null, null);
INSERT INTO `file` VALUES ('555', '壶口瀑布20170213165442.jpg', 'D:/upload/20170213\\壶口瀑布20170213165442.jpg', '2017-02-13 16:54:42', '2', '371361832', '1', '高规格高规格', '中证报价', null, null);
INSERT INTO `file` VALUES ('556', '二次元_020170213165609.jpeg', 'D:/upload/20170213\\二次元_020170213165609.jpeg', '2017-02-13 16:56:09', '2', '371361833', '1', '哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('557', '壶口瀑布20170213165703.jpg', 'D:/upload/20170213\\壶口瀑布20170213165703.jpg', '2017-02-13 16:57:03', '2', '371361834', '1', '那你', '中证报价', null, null);
INSERT INTO `file` VALUES ('558', '壶口瀑布20170214093647.jpg', 'D:/upload/20170214\\壶口瀑布20170214093647.jpg', '2017-02-14 09:36:47', '2', '371361835', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('559', '大山20170214095351.jpg', 'D:/upload/20170214\\大山20170214095351.jpg', '2017-02-14 09:53:51', '2', '371361836', '1', '各个', '中证报价', null, null);
INSERT INTO `file` VALUES ('560', '故宫20170214095446.jpg', 'D:/upload/20170214\\故宫20170214095446.jpg', '2017-02-14 09:54:46', '2', '371361837', '1', '高规格', '中证报价', null, null);
INSERT INTO `file` VALUES ('561', '卡通20170214095554.jpeg', 'D:/upload/20170214\\卡通20170214095554.jpeg', '2017-02-14 09:55:54', '2', '371361838', '1', '高规格各个', '中证报价', null, null);
INSERT INTO `file` VALUES ('562', '卡通20170214100149.jpeg', 'D:/upload/20170214\\卡通20170214100149.jpeg', '2017-02-14 10:01:49', '2', '371361839', '1', '飞飞飞', '中证报价', null, null);
INSERT INTO `file` VALUES ('563', '机器猫20170214100222.jpg', 'D:/upload/20170214\\机器猫20170214100222.jpg', '2017-02-14 10:02:22', '2', '371361839', '1', '飞飞飞集合飞飞', '中证报价', null, null);
INSERT INTO `file` VALUES ('564', '备忘20170214100655.txt', 'D:/upload/20170214\\备忘20170214100655.txt', '2017-02-14 10:06:55', '2', '371361839', '1', '方法', '中证报价', null, null);
INSERT INTO `file` VALUES ('565', 'Shiro教程20170214102233.pdf', 'D:/upload/20170214\\Shiro教程20170214102233.pdf', '2017-02-14 10:22:33', '2', '72', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('566', '二次元_020170214102639.jpeg', 'D:/upload/20170214\\二次元_020170214102639.jpeg', '2017-02-14 10:26:39', '2', '371361840', '1', '；', '中证报价', null, null);
INSERT INTO `file` VALUES ('567', '备份20170214102849.txt', 'D:/upload/20170214\\备份20170214102849.txt', '2017-02-14 10:28:49', '2', '371361841', '1', ' 闭包', '中证报价', null, null);
INSERT INTO `file` VALUES ('568', '备份20170214102852.txt', 'D:/upload/20170214\\备份20170214102852.txt', '2017-02-14 10:28:52', '2', '371361841', '1', ' 闭包', '中证报价', null, null);
INSERT INTO `file` VALUES ('569', '备份20170214102854.txt', 'D:/upload/20170214\\备份20170214102854.txt', '2017-02-14 10:28:54', '2', '371361841', '1', ' 闭包', '中证报价', null, null);
INSERT INTO `file` VALUES ('570', 'IMG_20161112_14283220170214103018.jpg', 'D:/upload/20170214\\IMG_20161112_14283220170214103018.jpg', '2017-02-14 10:30:18', '2', '371361841', '1', ' 闭，，', '中证报价', null, null);
INSERT INTO `file` VALUES ('571', 'IMG_20161112_14283220170214103200.jpg', 'D:/upload/20170214\\IMG_20161112_14283220170214103200.jpg', '2017-02-14 10:32:00', '2', '371361841', '1', ' 闭，，', '中证报价', null, null);
INSERT INTO `file` VALUES ('572', '地图20170214103222.jpg', 'D:/upload/20170214\\地图20170214103222.jpg', '2017-02-14 10:32:22', '2', '371361842', '1', '看', '中证报价', null, null);
INSERT INTO `file` VALUES ('573', '地图20170214103429.jpg', 'D:/upload/20170214\\地图20170214103429.jpg', '2017-02-14 10:34:29', '2', '371361842', '1', '看', '中证报价', null, null);
INSERT INTO `file` VALUES ('574', '大山20170214103442.jpg', 'D:/upload/20170214\\大山20170214103442.jpg', '2017-02-14 10:34:42', '2', '371361843', '1', '好', '中证报价', null, null);
INSERT INTO `file` VALUES ('575', '卡通20170214103754.jpeg', 'D:/upload/20170214\\卡通20170214103754.jpeg', '2017-02-14 10:37:54', '2', '371361844', '1', '方', '中证报价', null, null);
INSERT INTO `file` VALUES ('576', '卡通20170214103919.jpeg', 'D:/upload/20170214\\卡通20170214103919.jpeg', '2017-02-14 10:39:19', '2', '371361845', '1', 'v', '中证报价', null, null);
INSERT INTO `file` VALUES ('577', '狗狗20170214103951.jpg', 'D:/upload/20170214\\狗狗20170214103951.jpg', '2017-02-14 10:39:51', '2', '371361846', '1', '个', '中证报价', null, null);
INSERT INTO `file` VALUES ('578', '萨摩20170214104841.jpg', 'D:/upload/20170214\\萨摩20170214104841.jpg', '2017-02-14 10:48:41', '2', '371361847', '1', '萨玛发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('579', '卡通20170214105538.jpeg', 'D:/upload/20170214\\卡通20170214105538.jpeg', '2017-02-14 10:55:38', '2', '371361848', '1', '各个方', '中证报价', null, null);
INSERT INTO `file` VALUES ('580', '卡通20170214144930.jpeg', 'D:/upload/20170214\\卡通20170214144930.jpeg', '2017-02-14 14:49:30', '3', '371361849', '1', '闭包哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('581', '卡通20170214144945.jpeg', 'D:/upload/20170214\\卡通20170214144945.jpeg', '2017-02-14 14:49:45', '2', '371361849', '1', '闭包哈哈好', '中证报价', null, null);
INSERT INTO `file` VALUES ('582', '卡通20170214145440.jpeg', 'D:/upload/20170214\\卡通20170214145440.jpeg', '2017-02-14 14:54:40', '2', '371361850', '1', '加好友看见呼呼呼', '中证报价', null, null);
INSERT INTO `file` VALUES ('583', '故宫20170214150057.jpg', 'D:/upload/20170214\\故宫20170214150057.jpg', '2017-02-14 15:00:57', '2', '371361851', '1', '', '中证报价', null, null);
INSERT INTO `file` VALUES ('584', '故宫20170214150101.jpg', 'D:/upload/20170214\\故宫20170214150101.jpg', '2017-02-14 15:01:01', '2', '371361851', '1', '方法方法', '中证报价', null, null);
INSERT INTO `file` VALUES ('585', '卡通20170214150154.jpeg', 'D:/upload/20170214\\卡通20170214150154.jpeg', '2017-02-14 15:01:54', '2', '371361852', '1', '发发发方法2121222', '中证报价', null, null);
INSERT INTO `file` VALUES ('586', '故宫20170214150255.jpg', 'D:/upload/20170214\\故宫20170214150255.jpg', '2017-02-14 15:02:55', '2', '371361854', '1', 'd77777', '中证报价', null, null);
INSERT INTO `file` VALUES ('587', '故宫20170214150256.jpg', 'D:/upload/20170214\\故宫20170214150256.jpg', '2017-02-14 15:02:56', '2', '371361854', '1', 'd7', '中证报价', null, null);
INSERT INTO `file` VALUES ('588', '卡通20170214152107.jpeg', 'D:/upload/20170214\\卡通20170214152107.jpeg', '2017-02-14 15:21:07', '3', '371361855', '1', '各个发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('589', '卡通20170214152431.jpeg', 'D:/upload/20170214\\卡通20170214152431.jpeg', '2017-02-14 15:24:31', '2', '371361855', '1', '各个', '中证报价', null, null);
INSERT INTO `file` VALUES ('590', '萨摩20170214152441.jpg', 'D:/upload/20170214\\萨摩20170214152441.jpg', '2017-02-14 15:24:41', '2', '371361855', '1', '好', '中证报价', null, null);
INSERT INTO `file` VALUES ('591', '张家界20170214152535.jpg', 'D:/upload/20170214\\张家界20170214152535.jpg', '2017-02-14 15:25:35', '2', '371361857', '1', '哥哥哥哥哥哥', '中证报价', null, null);
INSERT INTO `file` VALUES ('592', '张家界20170214152606.jpg', 'D:/upload/20170214\\张家界20170214152606.jpg', '2017-02-14 15:26:06', '2', '371361857', '1', '哥哥哥', '中证报价', null, null);
INSERT INTO `file` VALUES ('593', '卡通20170214152643.jpeg', 'D:/upload/20170214\\卡通20170214152643.jpeg', '2017-02-14 15:26:43', '2', '371361859', '1', '方法方法发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('594', '卡通20170214154508.jpeg', 'D:/upload/20170214\\卡通20170214154508.jpeg', '2017-02-14 15:45:08', '3', '371361860', '1', '那你各个', '中证报价', null, null);
INSERT INTO `file` VALUES ('595', '卡通20170214155722.jpeg', 'D:/upload/20170214\\卡通20170214155722.jpeg', '2017-02-14 15:57:22', '2', '371361860', '1', '那你急急急', '中证报价', null, null);
INSERT INTO `file` VALUES ('596', 'menu_hover20170214191709.jpg', 'D:/upload/20170214\\menu_hover20170214191709.jpg', '2017-02-14 19:17:09', '2', '371361861', '1', '是是', '中证报价', null, null);
INSERT INTO `file` VALUES ('597', 'menu_heng20170214191929.gif', 'D:/upload/20170214\\menu_heng20170214191929.gif', '2017-02-14 19:19:29', '2', '371361812', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('598', 'nav_bg20170214191944.jpg', 'D:/upload/20170214\\nav_bg20170214191944.jpg', '2017-02-14 19:19:44', '2', '371361863', '1', '建行卡', '中证报价', null, null);
INSERT INTO `file` VALUES ('599', 'nav_bg20170214192159.jpg', 'D:/upload/20170214\\nav_bg20170214192159.jpg', '2017-02-14 19:21:59', '2', '371361863', '1', '建行卡', '中证报价', null, null);
INSERT INTO `file` VALUES ('600', '狗狗20170215094100.jpg', 'D:/upload/20170215\\狗狗20170215094100.jpg', '2017-02-15 09:41:00', '3', '371361864', '1', 'GG', '中证报价', null, null);
INSERT INTO `file` VALUES ('601', '狗狗20170215094116.jpg', 'D:/upload/20170215\\狗狗20170215094116.jpg', '2017-02-15 09:41:16', '2', '371361864', '1', 'GG', '中证报价', null, null);
INSERT INTO `file` VALUES ('602', '活动20170215094845.jpg', 'D:/upload/20170215\\活动20170215094845.jpg', '2017-02-15 09:48:45', '2', '371361855', '1', null, '中证报价', null, null);
INSERT INTO `file` VALUES ('603', '卡通20170215102959.jpeg', 'D:/upload/20170215\\卡通20170215102959.jpeg', '2017-02-15 10:29:59', '2', '371361812', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('604', '机器猫20170215143522.jpg', 'D:/upload/20170215\\机器猫20170215143522.jpg', '2017-02-15 14:35:22', '3', '77', '1', '哎哎哎', '中证报价', null, null);
INSERT INTO `file` VALUES ('605', '机器猫20170215143539.jpg', 'D:/upload/20170215\\机器猫20170215143539.jpg', '2017-02-15 14:35:39', '2', '77', '1', '哎哎哎解决', '中证报价', null, null);
INSERT INTO `file` VALUES ('606', '肥肥20170215143711.jpg', 'D:/upload/20170215\\肥肥20170215143711.jpg', '2017-02-15 14:37:11', '2', '78', '1', '秒  广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('607', '卡通20170215145249.jpeg', 'D:/upload/20170215\\卡通20170215145249.jpeg', '2017-02-15 14:52:49', '2', '2', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('608', '肥肥20170215153042.jpg', 'D:/upload/20170215\\肥肥20170215153042.jpg', '2017-02-15 15:30:42', '2', '3', '1', '伊贝尔', '中证报价', null, null);
INSERT INTO `file` VALUES ('609', '肥肥20170216093938.jpg', 'D:/upload/20170216\\肥肥20170216093938.jpg', '2017-02-16 09:39:38', '2', '371361874', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('610', '上海20170216094012.jpg', 'D:/upload/20170216\\上海20170216094012.jpg', '2017-02-16 09:40:12', '2', '371361874', '1', '发发发反反复复', '中证报价', null, null);
INSERT INTO `file` VALUES ('611', '卡通20170216094952.jpeg', 'D:/upload/20170216\\卡通20170216094952.jpeg', '2017-02-16 09:49:52', '2', '371361875', '1', '刚刚灌灌灌灌灌灌灌灌灌灌过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '中证报价', null, null);
INSERT INTO `file` VALUES ('612', '卡通20170216095409.jpeg', 'D:/upload/20170216\\卡通20170216095409.jpeg', '2017-02-16 09:54:09', '2', '371361881', '1', '发发发', '中证报价', null, null);
INSERT INTO `file` VALUES ('613', '卡通20170216101451.jpeg', 'D:/upload/20170216\\卡通20170216101451.jpeg', '2017-02-16 10:14:51', '2', '371361889', '1', '此处', '中证报价', null, null);
INSERT INTO `file` VALUES ('614', '卡通20170216102033.jpeg', 'D:/upload/20170216\\卡通20170216102033.jpeg', '2017-02-16 10:20:33', '2', '371361891', '1', 'hhhhhhhhhhg哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈或或或或或或或或或', '中证报价', null, null);
INSERT INTO `file` VALUES ('615', '故宫20170216103408.jpg', 'D:/upload/20170216\\故宫20170216103408.jpg', '2017-02-16 10:34:08', '2', '371361892', '1', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '中证报价', null, null);
INSERT INTO `file` VALUES ('616', '故宫20170216110543.jpg', 'D:/upload/20170216\\故宫20170216110543.jpg', '2017-02-16 11:05:43', '2', '371361892', '1', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '中证报价', null, null);
INSERT INTO `file` VALUES ('617', '机器猫20170216111340.jpg', 'D:/upload/20170216\\机器猫20170216111340.jpg', '2017-02-16 11:13:40', '2', '371361893', '1', '和骨', '中证报价', null, null);
INSERT INTO `file` VALUES ('618', '狗狗20170216111451.jpg', 'D:/upload/20170216\\狗狗20170216111451.jpg', '2017-02-16 11:14:51', '2', '371361894', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('619', '狗狗20170216111522.jpg', 'D:/upload/20170216\\狗狗20170216111522.jpg', '2017-02-16 11:15:22', '2', '371361894', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('620', '狗狗20170216111530.jpg', 'D:/upload/20170216\\狗狗20170216111530.jpg', '2017-02-16 11:15:30', '2', '371361894', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('621', '芦芽山20170216111550.jpg', 'D:/upload/20170216\\芦芽山20170216111550.jpg', '2017-02-16 11:15:50', '2', '371361895', '1', '嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('622', '机器猫20170216111717.jpg', 'D:/upload/20170216\\机器猫20170216111717.jpg', '2017-02-16 11:17:17', '2', '371361896', '1', '了', '中证报价', null, null);
INSERT INTO `file` VALUES ('623', '卡通20170216111850.jpeg', 'D:/upload/20170216\\卡通20170216111850.jpeg', '2017-02-16 11:18:50', '2', '371361897', '1', '灌灌灌灌', '中证报价', null, null);
INSERT INTO `file` VALUES ('624', '芦芽山20170216111930.jpg', 'D:/upload/20170216\\芦芽山20170216111930.jpg', '2017-02-16 11:19:30', '2', '371361898', '1', '嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('625', '芦芽山20170216111940.jpg', 'D:/upload/20170216\\芦芽山20170216111940.jpg', '2017-02-16 11:19:40', '2', '371361898', '1', '嘎嘎嘎【】', '中证报价', null, null);
INSERT INTO `file` VALUES ('626', '狗狗20170216112131.jpg', 'D:/upload/20170216\\狗狗20170216112131.jpg', '2017-02-16 11:21:31', '2', '371361899', '1', '尴尬', '中证报价', null, null);
INSERT INTO `file` VALUES ('627', '狗狗20170216112331.jpg', 'D:/upload/20170216\\狗狗20170216112331.jpg', '2017-02-16 11:23:31', '2', '371361900', '1', '‘了离开’', '中证报价', null, null);
INSERT INTO `file` VALUES ('628', '卡通20170216142613.jpeg', 'D:/upload/20170216\\卡通20170216142613.jpeg', '2017-02-16 14:26:13', '2', '371361901', '1', '嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('629', '卡通20170216142808.jpeg', 'D:/upload/20170216\\卡通20170216142808.jpeg', '2017-02-16 14:28:08', '2', '371361902', '1', '嘎嘎嘎个', '中证报价', null, null);
INSERT INTO `file` VALUES ('630', '狗狗20170216143115.jpg', 'D:/upload/20170216\\狗狗20170216143115.jpg', '2017-02-16 14:31:15', '2', '371361903', '1', '', '中证报价', null, null);
INSERT INTO `file` VALUES ('631', '卡通20170216143705.jpeg', 'D:/upload/20170216\\卡通20170216143705.jpeg', '2017-02-16 14:37:05', '2', '371361904', '1', '他', '中证报价', null, null);
INSERT INTO `file` VALUES ('632', '卡通20170216143807.jpeg', 'D:/upload/20170216\\卡通20170216143807.jpeg', '2017-02-16 14:38:07', '2', '371361905', '1', '就', '中证报价', null, null);
INSERT INTO `file` VALUES ('633', '卡通20170216144535.jpeg', 'D:/upload/20170216\\卡通20170216144535.jpeg', '2017-02-16 14:45:35', '2', '371361906', '1', '灌灌灌灌', '中证报价', null, null);
INSERT INTO `file` VALUES ('634', '卡通20170216144737.jpeg', 'D:/upload/20170216\\卡通20170216144737.jpeg', '2017-02-16 14:47:37', '2', '371361907', '1', '灌灌灌灌灌刚刚灌灌灌灌灌灌灌灌灌灌过过过过过过过过过过过过过过过过过过过过过', '中证报价', null, null);
INSERT INTO `file` VALUES ('635', '卡通20170216144936.jpeg', 'D:/upload/20170216\\卡通20170216144936.jpeg', '2017-02-16 14:49:36', '2', '371361908', '1', '方法', '中证报价', null, null);
INSERT INTO `file` VALUES ('636', '卡通20170216145955.jpeg', 'D:/upload/20170216\\卡通20170216145955.jpeg', '2017-02-16 14:59:55', '2', '371361909', '1', '来了', '中证报价', null, null);
INSERT INTO `file` VALUES ('637', '萨摩20170216150013.jpg', 'D:/upload/20170216\\萨摩20170216150013.jpg', '2017-02-16 15:00:13', '2', '371361909', '1', '啦啦啦啦啦啦啦绿绿绿绿绿', '中证报价', null, null);
INSERT INTO `file` VALUES ('638', '卡通20170216154434.jpeg', 'D:/upload/20170216\\卡通20170216154434.jpeg', '2017-02-16 15:44:34', '2', '371361912', '1', '', '中证报价', null, null);
INSERT INTO `file` VALUES ('639', '大山大山你好大好大好大好大好大好大好大好大好大20170217112340.jpg', 'D:/upload/20170217\\大山大山你好大好大好大好大好大好大好大好大好大20170217112340.jpg', '2017-02-17 11:23:40', '2', '371361987', '1', '发发发反反复复方法反反复复反复反复反复反复反复付付付付付付付付付付付付付付付付方', '中证报价', null, null);
INSERT INTO `file` VALUES ('640', '狗狗20170217140753.jpg', 'D:/upload/20170217\\狗狗20170217140753.jpg', '2017-02-17 14:07:53', '2', '371361991', '1', '嘎嘎嘎', '中证报价', null, null);
INSERT INTO `file` VALUES ('641', '狗狗20170217140958.jpg', 'D:/upload/20170217\\狗狗20170217140958.jpg', '2017-02-17 14:09:58', '2', '371361992', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('642', '地图20170217141233.jpg', 'D:/upload/20170217\\地图20170217141233.jpg', '2017-02-17 14:12:33', '2', '371361993', '1', '中华人民嘎嘎嘎刚刚灌灌灌灌灌灌灌灌灌灌过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '中证报价', null, null);
INSERT INTO `file` VALUES ('643', '活动20170217141313.jpg', 'D:/upload/20170217\\活动20170217141313.jpg', '2017-02-17 14:13:13', '2', '371361994', '1', '嘎嘎嘎古古怪怪', '中证报价', null, null);
INSERT INTO `file` VALUES ('644', '张家界20170217141621.jpg', 'D:/upload/20170217\\张家界20170217141621.jpg', '2017-02-17 14:16:21', '2', '107', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('645', '狗狗20170217141730.jpg', 'D:/upload/20170217\\狗狗20170217141730.jpg', '2017-02-17 14:17:30', '2', '108', '1', '刚刚灌灌灌灌灌灌灌灌灌灌过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过过', '中证报价', null, null);
INSERT INTO `file` VALUES ('646', '萨摩20170217141807.jpg', 'D:/upload/20170217\\萨摩20170217141807.jpg', '2017-02-17 14:18:07', '2', '109', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('647', '卡通20170217145134.jpeg', 'D:/upload/20170217\\卡通20170217145134.jpeg', '2017-02-17 14:51:34', '2', '371362005', '1', '广告', '中证报价', null, null);
INSERT INTO `file` VALUES ('648', '卡通20170217145232.jpeg', 'D:/upload/20170217\\卡通20170217145232.jpeg', '2017-02-17 14:52:32', '2', '371362006', '1', '方法', '中证报价', null, null);
INSERT INTO `file` VALUES ('649', '卡通20170217150245.jpeg', 'D:/upload/20170217\\卡通20170217150245.jpeg', '2017-02-17 15:02:45', '2', '371362008', '1', '来了', '中证报价', null, null);
INSERT INTO `file` VALUES ('650', '卡通20170217150556.jpeg', 'D:/upload/20170217\\卡通20170217150556.jpeg', '2017-02-17 15:05:56', '2', '122', '1', '哈哈', '中证报价', null, null);
INSERT INTO `file` VALUES ('651', '卡通20170220093245.jpeg', 'D:/upload/20170220\\卡通20170220093245.jpeg', '2017-02-20 09:32:45', '2', '371362012', '1', '反反复复方法反反复复反复反复反复反复反复付付付付付付付付付付付付付付付反反复复方法反反复复反复反复反复反复反复付付', '系统管理员', null, null);
INSERT INTO `file` VALUES ('652', '卡通20170220104707.jpeg', 'D:/upload/20170220\\卡通20170220104707.jpeg', '2017-02-20 10:47:07', '2', '371362014', '1', '会计', '系统管理员', null, null);
INSERT INTO `file` VALUES ('653', '卡通20170220134528.jpeg', 'D:/upload/20170220\\卡通20170220134528.jpeg', '2017-02-20 13:45:28', '2', '371362016', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('654', '狗狗20170220145913.jpg', 'D:/upload/20170220\\狗狗20170220145913.jpg', '2017-02-20 14:59:13', '2', '123', '1', '发发发打断点', '系统管理员', null, null);
INSERT INTO `file` VALUES ('655', '卡通20170220154555.jpeg', 'D:/upload/20170220\\卡通20170220154555.jpeg', '2017-02-20 15:45:55', '2', '371362020', '1', '个', '系统管理员', null, null);
INSERT INTO `file` VALUES ('656', '狗狗20170220154809.jpg', 'D:/upload/20170220\\狗狗20170220154809.jpg', '2017-02-20 15:48:09', '2', '371362021', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('657', '狗狗20170220154844.jpg', 'D:/upload/20170220\\狗狗20170220154844.jpg', '2017-02-20 15:48:44', '2', '371362022', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('658', '狗狗20170222141425.jpg', 'D:/upload/20170222\\狗狗20170222141425.jpg', '2017-02-22 14:14:25', '3', '371362027', '1', '的点点滴滴', '系统管理员', null, null);
INSERT INTO `file` VALUES ('659', '狗狗20170222141432.jpg', 'D:/upload/20170222\\狗狗20170222141432.jpg', '2017-02-22 14:14:32', '3', '371362027', '1', '的点点滴滴', '系统管理员', null, null);
INSERT INTO `file` VALUES ('660', '卡通20170222141451.jpeg', 'D:/upload/20170222\\卡通20170222141451.jpeg', '2017-02-22 14:14:51', '2', '371362028', '1', '方法', '系统管理员', null, null);
INSERT INTO `file` VALUES ('661', '卡通20170222142150.jpeg', 'D:/upload/20170222\\卡通20170222142150.jpeg', '2017-02-22 14:21:50', '2', '371362035', '1', '看了看', '系统管理员', null, null);
INSERT INTO `file` VALUES ('662', '肥肥20170223093934.jpg', 'D:/upload/20170223\\肥肥20170223093934.jpg', '2017-02-23 09:39:34', '2', '371361567', '14', '嘎嘎嘎', '北京证监局', null, null);
INSERT INTO `file` VALUES ('663', '肥肥20170223093935.jpg', 'D:/upload/20170223\\肥肥20170223093935.jpg', '2017-02-23 09:39:35', '2', '371361567', '14', '嘎嘎嘎', '北京证监局', null, null);
INSERT INTO `file` VALUES ('664', '狗狗20170223103759.jpg', 'D:/upload/20170223\\狗狗20170223103759.jpg', '2017-02-23 10:37:59', '2', '371361670', '1', '个', '系统管理员', null, null);
INSERT INTO `file` VALUES ('665', '21178524288802231020170310160202.jpg', '/home/zyb/upload/20170310/21178524288802231020170310160202.jpg', '2017-03-10 16:02:02', '3', '371362060', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('666', '测试word20170314152157.doc', '/home/zyb/upload/20170314/测试word20170314152157.doc', '2017-03-14 15:21:57', '3', '371362072', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('667', '测试excel20170314153443.pdf', '/home/zyb/upload/20170314/测试excel20170314153443.pdf', '2017-03-14 15:34:43', '3', '371362075', '1', '', '系统管理员', null, null);
INSERT INTO `file` VALUES ('668', '狗狗20170322110023.jpg', 'D:/upload/20170322\\狗狗20170322110023.jpg', '2017-03-22 11:00:23', '3', '135', '1', 's55272文件', '系统管理员', null, null);
INSERT INTO `file` VALUES ('669', '狗狗20170322110026.jpg', 'D:/upload/20170322\\狗狗20170322110026.jpg', '2017-03-22 11:00:26', '3', '135', '1', 's55272文件', '系统管理员', null, null);
INSERT INTO `file` VALUES ('670', '狗狗20170322165751.jpg', 'D:/upload/20170322\\狗狗20170322165751.jpg', '2017-03-22 16:57:51', '2', '371362080', '1', '狗狗狗狗', '系统管理员', null, null);
INSERT INTO `file` VALUES ('671', '狗狗20170322170109.jpg', 'D:/upload/20170322\\狗狗20170322170109.jpg', '2017-03-22 17:01:09', '2', '371362081', '1', '福福福福福福福福福', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('672', '狗狗20170323083551.jpg', 'D:/upload/20170323\\狗狗20170323083551.jpg', '2017-03-23 08:35:51', '2', '371362083', '1', '好', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('673', '芦芽山20170323084355.jpg', 'D:/upload/20170323\\芦芽山20170323084355.jpg', '2017-03-23 08:43:55', '2', '371362084', '1', '解决', '系统管理员', '芦芽山.jpg', null);
INSERT INTO `file` VALUES ('674', '肥肥20170323084602.jpg', 'D:/upload/20170323\\肥肥20170323084602.jpg', '2017-03-23 08:46:02', '3', '371362075', '1', '古古怪怪', '系统管理员', '肥肥.jpg', null);
INSERT INTO `file` VALUES ('675', '狗狗20170323084659.jpg', 'D:/upload/20170323\\狗狗20170323084659.jpg', '2017-03-23 08:46:59', '3', '135', '1', '应用', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('676', '沛县20170323090041.jpg', 'D:/upload/20170323\\沛县20170323090041.jpg', '2017-03-23 09:00:41', '2', '371362072', '1', 'ppp', '系统管理员', '沛县.jpg', null);
INSERT INTO `file` VALUES ('677', '卡通20170323093008.jpeg', 'D:/upload/20170323\\卡通20170323093008.jpeg', '2017-03-23 09:30:08', '2', '139', '1', '', '系统管理员', '卡通.jpeg', null);
INSERT INTO `file` VALUES ('678', '卡通20170323093010.jpeg', 'D:/upload/20170323\\卡通20170323093010.jpeg', '2017-03-23 09:30:10', '2', '139', '1', '', '系统管理员', '卡通.jpeg', null);
INSERT INTO `file` VALUES ('679', '卡通20170323094724.jpeg', 'D:/upload/20170323\\卡通20170323094724.jpeg', '2017-03-23 09:47:24', '2', '371362088', '1', '了', '系统管理员', '卡通.jpeg', null);
INSERT INTO `file` VALUES ('680', '故宫20170323102346.jpg', 'D:/upload/20170323\\故宫20170323102346.jpg', '2017-03-23 10:23:46', '2', '140', '1', '个', '系统管理员', '故宫.jpg', null);
INSERT INTO `file` VALUES ('681', '120170327164223.jpg', '/home/zyb/upload/20170327/120170327164223.jpg', '2017-03-27 16:42:23', '3', '371362075', '1', '1', '系统管理员', '1.jpg', null);
INSERT INTO `file` VALUES ('682', '120170327164223.jpg', '/home/zyb/upload/20170327/120170327164223.jpg', '2017-03-27 16:42:23', '3', '371362075', '1', '1', '系统管理员', '1.jpg', null);
INSERT INTO `file` VALUES ('683', '肥肥20170327165534.jpg', '/home/zyb/upload/20170327/肥肥20170327165534.jpg', '2017-03-27 16:55:34', '2', '371362091', '1', '发发发', '系统管理员', '肥肥.jpg', null);
INSERT INTO `file` VALUES ('684', '狗狗20170328090551.jpg', 'D:/upload/20170328\\狗狗20170328090551.jpg', '2017-03-28 09:05:51', '2', '142', '1', 'javascript:void(0)', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('685', '狗狗20170330153106.jpg', 'D:/upload/20170330\\狗狗20170330153106.jpg', '2017-03-30 15:31:06', '2', '371362103', '1', '反反复复', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('686', '狗狗20170330153111.jpg', 'D:/upload/20170330\\狗狗20170330153111.jpg', '2017-03-30 15:31:11', '2', '371362103', '1', '反反复复', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('687', '张家界20170330153133.jpg', 'D:/upload/20170330\\张家界20170330153133.jpg', '2017-03-30 15:31:33', '2', '371362103', '1', '框架', '系统管理员', '张家界.jpg', null);
INSERT INTO `file` VALUES ('688', '狗狗20170330153234.jpg', 'D:/upload/20170330\\狗狗20170330153234.jpg', '2017-03-30 15:32:34', '2', '371362105', '1', '看', '系统管理员', '狗狗.jpg', null);
INSERT INTO `file` VALUES ('689', '二次元_020170331141736.jpeg', 'D:/upload/20170331\\二次元_020170331141736.jpeg', '2017-03-31 14:17:36', '2', '371362111', '1', '方法烦烦烦烦烦烦烦烦烦烦烦付付', '系统管理员', '二次元_0.jpeg', null);
INSERT INTO `file` VALUES ('690', '上海20170331141758.jpg', 'D:/upload/20170331\\上海20170331141758.jpg', '2017-03-31 14:17:58', '2', '371362111', '1', '方法嘎嘎嘎 个', '系统管理员', '上海.jpg', null);
INSERT INTO `file` VALUES ('691', '测试word20170407165832.doc', '/home/zyb/upload/20170407/测试word20170407165832.doc', '2017-04-07 16:58:32', '2', '371362112', '1', '', '系统管理员', '测试word.doc', null);
INSERT INTO `file` VALUES ('692', '新建文本文档20170504101756.txt', '/home/zyb/upload/20170504/新建文本文档20170504101756.txt', '2017-05-04 10:17:56', '2', '371362118', '1', '', '系统管理员', '新建文本文档.txt', 'SupInfo');
INSERT INTO `file` VALUES ('693', '测试word20170508143439.doc', '/home/zyb/upload/20170508/测试word20170508143439.doc', '2017-05-08 14:34:39', '2', '135', '1', '', '系统管理员', '测试word.doc', 'ABSSupInfo');
INSERT INTO `file` VALUES ('694', '测试word20170509162423.doc', '/home/zyb/upload/20170509/测试word20170509162423.doc', '2017-05-09 16:24:23', '2', '371362112', '1', '', '系统管理员', '测试word.doc', 'SupInfo');
INSERT INTO `file` VALUES ('695', 'wpp20170511102913.exe', '/home/zyb/upload/20170511/wpp20170511102913.exe', '2017-05-11 10:29:13', '3', '371362112', '1', '；；；', '系统管理员', 'wpp.exe', 'SupInfo');
INSERT INTO `file` VALUES ('696', 'etul20170511105139.dll', '/home/zyb/upload/20170511/etul20170511105139.dll', '2017-05-11 10:51:39', '3', '155', '1', '00011', '系统管理员', 'etul.dll', 'ABSSupInfo');
INSERT INTO `file` VALUES ('697', '测试word20170515145253.doc', '/home/zyb/upload/20170515/测试word20170515145253.doc', '2017-05-15 14:52:53', '2', '371362075', '1', '', '系统管理员', '测试word.doc', 'SupInfo');
INSERT INTO `file` VALUES ('698', '测试word20170515145342.doc', '/home/zyb/upload/20170515/测试word20170515145342.doc', '2017-05-15 14:53:42', '2', '371362072', '1', '', '系统管理员', '测试word.doc', 'SupInfo');
INSERT INTO `file` VALUES ('699', '测试word20170525155110.doc', '/home/zyb/upload/20170525/测试word20170525155110.doc', '2017-05-25 15:51:10', '2', '159', '1', '', '系统管理员', '测试word.doc', 'ABSSupInfo');
INSERT INTO `file` VALUES ('700', '测试word20170525155156.doc', '/home/zyb/upload/20170525/测试word20170525155156.doc', '2017-05-25 15:51:56', '2', '160', '1', '', '系统管理员', '测试word.doc', 'ABSSupInfo');
INSERT INTO `file` VALUES ('701', '测试word20170525155927.doc', '/home/zyb/upload/20170525/测试word20170525155927.doc', '2017-05-25 15:59:27', '2', '371362125', '1', '', '系统管理员', '测试word.doc', 'SupInfo');
INSERT INTO `file` VALUES ('702', '测试word20170605161629.doc', '/home/zyb/upload/20170605/测试word20170605161629.doc', '2017-06-05 16:16:29', '2', '162', '1', '', '系统管理员', '测试word.doc', 'ABSSupInfo');
INSERT INTO `file` VALUES ('703', '0513监管函20170609171825.doc', '/home/zyb/upload/20170609/0513监管函20170609171825.doc', '2017-06-09 17:18:25', '2', '164', '1', '', '系统管理员', '0513监管函.doc', 'ABSSupInfo');
INSERT INTO `file` VALUES ('704', '现场约谈纪要-建湖国投债20170628092637.pdf', '/home/zyb/upload/20170628/现场约谈纪要-建湖国投债20170628092637.pdf', '2017-06-28 09:26:37', '2', '371362126', '1', '', '系统管理员', '现场约谈纪要-建湖国投债.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('705', '现场约谈纪要-建湖国投债20170628092914.pdf', '/home/zyb/upload/20170628/现场约谈纪要-建湖国投债20170628092914.pdf', '2017-06-28 09:29:14', '2', '371362128', '1', '', '系统管理员', '现场约谈纪要-建湖国投债.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('706', '建湖国投120170704153129.jpg', '/home/zyb/upload/20170704/建湖国投120170704153129.jpg', '2017-07-04 15:31:29', '3', '371362134', '1', '', '系统管理员', '建湖国投1.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('707', '中信建投监管关注函20170704155607.jpg', '/home/zyb/upload/20170704/中信建投监管关注函20170704155607.jpg', '2017-07-04 15:56:07', '2', '371362134', '1', '', '系统管理员', '中信建投监管关注函.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('708', '中信建投监管关注函0220170704155708.jpg', '/home/zyb/upload/20170704/中信建投监管关注函0220170704155708.jpg', '2017-07-04 15:57:08', '3', '371362134', '1', '', '系统管理员', '中信建投监管关注函02.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('709', '中信建投监管关注函0320170704155724.jpg', '/home/zyb/upload/20170704/中信建投监管关注函0320170704155724.jpg', '2017-07-04 15:57:24', '3', '371362134', '1', '', '系统管理员', '中信建投监管关注函03.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('710', '中信建投监管关注函0420170704155733.jpg', '/home/zyb/upload/20170704/中信建投监管关注函0420170704155733.jpg', '2017-07-04 15:57:33', '3', '371362134', '1', '', '系统管理员', '中信建投监管关注函04.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('711', 'u=937108995,861668265&fm=26&gp=020170704170419.jpg', '/home/zyb/upload/20170704/u=937108995,861668265&fm=26&gp=020170704170419.jpg', '2017-07-04 17:04:19', '2', '371362136', '1', '', '系统管理员', 'u=937108995,861668265&fm=26&gp=0.jpg', 'SupInfo');
INSERT INTO `file` VALUES ('712', 'u=937108995,861668265&fm=26&gp=020170704170625.jpg', '/home/zyb/upload/20170704/u=937108995,861668265&fm=26&gp=020170704170625.jpg', '2017-07-04 17:06:25', '2', '167', '1', '', '系统管理员', 'u=937108995,861668265&fm=26&gp=0.jpg', 'ABSSupInfo');
INSERT INTO `file` VALUES ('713', '1010场外证券业务报告系统公测问题反馈表20190110152155.xlsx', '/home/zyb/upload/1010场外证券业务报告系统公测问题反馈表20190110152155.xlsx', '2019-01-10 15:21:55', '2', '371362139', '1', '', '系统管理员', '1010场外证券业务报告系统公测问题反馈表.xlsx', 'SupInfo');
INSERT INTO `file` VALUES ('714', '1120190111101552.pdf', '/home/zyb/upload/1120190111101552.pdf', '2019-01-11 10:15:52', '2', '169', '1', '', '系统管理员', '11.pdf', 'ABSSupInfo');
INSERT INTO `file` VALUES ('715', '1120190111102742.pdf', '/home/zyb/upload/1120190111102742.pdf', '2019-01-11 10:27:42', '2', '371362141', '1', '1', '系统管理员', '11.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('716', '1120190111103110.pdf', '/home/zyb/upload/1120190111103110.pdf', '2019-01-11 10:31:10', '2', '170', '1', '', '系统管理员', '11.pdf', 'ABSSupInfo');
INSERT INTO `file` VALUES ('717', '附件2：个人所得税专项附加扣除政策指引一览表20190821194437.pdf', '/home/zyb/upload/附件2：个人所得税专项附加扣除政策指引一览表20190821194437.pdf', '2019-08-21 19:44:37', '2', '371362145', '1', '111', '系统管理员', '附件2：个人所得税专项附加扣除政策指引一览表.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('718', '附件1：个人所得税预扣率表及计算举例20190822171646.pptx', '/home/zyb/upload/附件1：个人所得税预扣率表及计算举例20190822171646.pptx', '2019-08-22 17:16:46', '2', '371362146', '1', '111', '系统管理员', '附件1：个人所得税预扣率表及计算举例.pptx', 'SupInfo');
INSERT INTO `file` VALUES ('719', '附件1：个人所得税预扣率表及计算举例20190826134234.pptx', '/home/zyb/upload/附件1：个人所得税预扣率表及计算举例20190826134234.pptx', '2019-08-26 13:42:34', '2', '371362145', '1', '', '系统管理员', '附件1：个人所得税预扣率表及计算举例.pptx', 'SupInfo');
INSERT INTO `file` VALUES ('720', '附件1：个人所得税预扣率表及计算举例20190826134327.pptx', '/home/zyb/upload/附件1：个人所得税预扣率表及计算举例20190826134327.pptx', '2019-08-26 13:43:27', '2', '371362148', '1', '11', '系统管理员', '附件1：个人所得税预扣率表及计算举例.pptx', 'SupInfo');
INSERT INTO `file` VALUES ('721', 'reportsys_slf4j_172.31.0.3_4591_2019080720190826153317.log', '/home/zyb/upload/reportsys_slf4j_172.31.0.3_4591_2019080720190826153317.log', '2019-08-26 15:33:17', '2', '173', '1', '', '系统管理员', 'reportsys_slf4j_172.31.0.3_4591_20190807.log', 'ABSSupInfo');
INSERT INTO `file` VALUES ('722', '201909fuxiyy20190828112155.doc', '/home/zyb/upload/201909fuxiyy20190828112155.doc', '2019-08-28 11:21:55', '2', '371362152', '1', '', '系统管理员', '201909fuxiyy.doc', 'SupInfo');
INSERT INTO `file` VALUES ('723', '关于公司2018年员工健康体检的通知20190828135518.pdf', '/home/zyb/upload/关于公司2018年员工健康体检的通知20190828135518.pdf', '2019-08-28 13:55:18', '2', '371362209', '142', '', '121', '关于公司2018年员工健康体检的通知.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('724', '关于公司2018年员工健康体检的通知20190828145849.pdf', '/home/zyb/upload/关于公司2018年员工健康体检的通知20190828145849.pdf', '2019-08-28 14:58:49', '2', '205', '1', '', '系统管理员', '关于公司2018年员工健康体检的通知.pdf', 'ABSSupInfo');
INSERT INTO `file` VALUES ('725', '附件1：个人所得税预扣率表及计算举例20190828150548.pptx', '/home/zyb/upload/附件1：个人所得税预扣率表及计算举例20190828150548.pptx', '2019-08-28 15:05:48', '2', '174', '1', '111', '系统管理员', '附件1：个人所得税预扣率表及计算举例.pptx', 'ABSSupInfo');
INSERT INTO `file` VALUES ('726', '附件2：个人所得税专项附加扣除政策指引一览表20190828150632.pdf', '/home/zyb/upload/附件2：个人所得税专项附加扣除政策指引一览表20190828150632.pdf', '2019-08-28 15:06:32', '2', '175', '1', '', '系统管理员', '附件2：个人所得税专项附加扣除政策指引一览表.pdf', 'ABSSupInfo');
INSERT INTO `file` VALUES ('727', '附件2：六项专项附加扣除和扣缴申报操作指引20190828151936.ppt', '/home/zyb/upload/附件2：六项专项附加扣除和扣缴申报操作指引20190828151936.ppt', '2019-08-28 15:19:36', '2', '178', '1', '21', '系统管理员', '附件2：六项专项附加扣除和扣缴申报操作指引.ppt', 'ABSSupInfo');
INSERT INTO `file` VALUES ('728', '附件2：六项专项附加扣除和扣缴申报操作指引20190828152120.ppt', '/home/zyb/upload/附件2：六项专项附加扣除和扣缴申报操作指引20190828152120.ppt', '2019-08-28 15:21:20', '2', '177', '1', '111', '系统管理员', '附件2：六项专项附加扣除和扣缴申报操作指引.ppt', 'ABSSupInfo');
INSERT INTO `file` VALUES ('729', '“党的十九大精神教育培训”网络专题课程完成情况反馈表20190828152211.xlsx', '/home/zyb/upload/“党的十九大精神教育培训”网络专题课程完成情况反馈表20190828152211.xlsx', '2019-08-28 15:22:11', '2', '184', '1', '', '系统管理员', '“党的十九大精神教育培训”网络专题课程完成情况反馈表.xlsx', 'ABSSupInfo');
INSERT INTO `file` VALUES ('730', '附件1：国务院关于印发个人所得税专项附加扣除暂行办法的通知20190828152400.pdf', '/home/zyb/upload/附件1：国务院关于印发个人所得税专项附加扣除暂行办法的通知20190828152400.pdf', '2019-08-28 15:24:00', '2', '196', '1', '111', '系统管理员', '附件1：国务院关于印发个人所得税专项附加扣除暂行办法的通知.pdf', 'ABSSupInfo');
INSERT INTO `file` VALUES ('731', '附件1：个人所得税预扣率表及计算举例20190828152807.pptx', '/home/zyb/upload/附件1：个人所得税预扣率表及计算举例20190828152807.pptx', '2019-08-28 15:28:07', '2', '194', '1', '1111', '系统管理员', '附件1：个人所得税预扣率表及计算举例.pptx', 'ABSSupInfo');
INSERT INTO `file` VALUES ('732', '关于公司2018年员工健康体检的通知20190828181400.pdf', '/home/zyb/upload/关于公司2018年员工健康体检的通知20190828181400.pdf', '2019-08-28 18:14:00', '2', '371362210', '1', '', '系统管理员', '关于公司2018年员工健康体检的通知.pdf', 'SupInfo');
INSERT INTO `file` VALUES ('733', '关于公司2018年员工健康体检的通知20190828182604.pdf', '/home/zyb/upload/关于公司2018年员工健康体检的通知20190828182604.pdf', '2019-08-28 18:26:04', '2', '213', '1', '', '系统管理员', '关于公司2018年员工健康体检的通知.pdf', 'ABSSupInfo');

-- ----------------------------
-- Table structure for fx_data
-- ----------------------------
DROP TABLE IF EXISTS `fx_data`;
CREATE TABLE `fx_data` (
  `procode` varchar(255) DEFAULT NULL,
  `blobs` blob,
  `insertTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of fx_data
-- ----------------------------

-- ----------------------------
-- Table structure for intermediary_info
-- ----------------------------
DROP TABLE IF EXISTS `intermediary_info`;
CREATE TABLE `intermediary_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sup_id` int(11) DEFAULT NULL COMMENT '监管信息id',
  `intermediary_agency` varchar(500) DEFAULT NULL COMMENT '中介机构名称',
  `intermediary_agency_srb` varchar(500) DEFAULT NULL COMMENT '中介机构所属证监局',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL COMMENT '模块名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of intermediary_info
-- ----------------------------

-- ----------------------------
-- Table structure for raw_data_abs_base
-- ----------------------------
DROP TABLE IF EXISTS `raw_data_abs_base`;
CREATE TABLE `raw_data_abs_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qspp_SerialNumber` varchar(400) DEFAULT NULL,
  `qspp_ProductCode` varchar(100) DEFAULT NULL,
  `qspp_FullName` varchar(100) DEFAULT NULL,
  `qspp_ProductShortName` varchar(100) DEFAULT NULL,
  `qspp_UnderlyingAssetTypes` varchar(100) DEFAULT NULL,
  `qspp_InitialRatingOfAssetBackedSecurities` varchar(100) DEFAULT NULL,
  `qspp_TargetDistributionTotalScale` varchar(100) DEFAULT NULL,
  `qspp_StartDateOfTransfer` varchar(100) DEFAULT NULL,
  `qspp_DalueDate` varchar(100) DEFAULT NULL,
  `qspp_ExpectedAnnualizedYield` varchar(100) DEFAULT NULL,
  `qspp_AssetBackedSecuritiesPaymentDate` varchar(100) DEFAULT NULL,
  `qspp_TradingPlaces` varchar(100) DEFAULT NULL,
  `qspp_DueDate` varchar(100) DEFAULT NULL,
  `qspp_MeasuresToIncreaseTrust` varchar(100) DEFAULT NULL,
  `qspp_OriginalRightsAndInterestsOfPeople` varchar(100) DEFAULT NULL,
  `qspp_IndustryBelongedLevelOne` varchar(100) DEFAULT NULL,
  `qspp_RegisteredAddressOne` varchar(100) DEFAULT NULL,
  `qspp_EnterpriseBusinessArea` varchar(100) DEFAULT NULL,
  `qspp_EnterpriseOwnership` varchar(100) DEFAULT NULL,
  `qspp_IsFinancialInstitutionsOrNot` varchar(100) DEFAULT NULL,
  `qspp_MainRating` varchar(100) DEFAULT NULL,
  `qspp_Manager` varchar(100) DEFAULT NULL,
  `qspp_RegulatoryAgenciesProjectManager` varchar(100) DEFAULT NULL,
  `qspp_ManagerRegulatoryBureauUnderJurisdiction` varchar(100) DEFAULT NULL,
  `qspp_CertifiedPublicAccountants` varchar(100) DEFAULT NULL,
  `qspp_SignatureAccountants` varchar(100) DEFAULT NULL,
  `qspp_LawFirm` varchar(100) DEFAULT NULL,
  `qspp_SignatureLawyer` varchar(100) DEFAULT NULL,
  `qspp_MainRatingAgency` varchar(100) DEFAULT NULL,
  `qspp_RatingAgencyProjectManager` varchar(100) DEFAULT NULL,
  `qspp_AssetEvaluationAgenciesName` varchar(100) DEFAULT NULL,
  `qspp_AssetEvaluationAgencyProjectLeader` varchar(100) DEFAULT NULL,
  `qspp_Custodian` varchar(100) DEFAULT NULL,
  `qspp_LevelOfProductSize` varchar(400) DEFAULT NULL,
  `qspp_CurrentPrincipalAndIncomeDistributionArrangement` varchar(400) DEFAULT NULL,
  `qspp_ProductCorrespondsToCurrentParentProductCode` varchar(400) DEFAULT NULL,
  `qspp_ParentFullName` varchar(400) DEFAULT NULL,
  `qspp_ParentProductShortName` varchar(400) DEFAULT NULL,
  `qspp_PaymentProgram` varchar(400) DEFAULT NULL,
  `qspp_ProductSizeAccountingPeriod` varchar(400) DEFAULT NULL,
  `insertTime` datetime DEFAULT NULL,
  `qspp_UnderlyingDebtorCorrespondsToContractAmount` varchar(400) DEFAULT NULL,
  `qspp_UnderlyingDebtor` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of raw_data_abs_base
-- ----------------------------

-- ----------------------------
-- Table structure for raw_data_abs_trial
-- ----------------------------
DROP TABLE IF EXISTS `raw_data_abs_trial`;
CREATE TABLE `raw_data_abs_trial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qspp_SerialNumber` varchar(400) DEFAULT NULL,
  `qspp_FullName` varchar(400) DEFAULT NULL,
  `qspp_UnderlyingAssetTypes` varchar(400) DEFAULT NULL,
  `qspp_TargetDistributionTotalScale` varchar(400) DEFAULT NULL,
  `qspp_MaterialsReceivedTime` varchar(400) DEFAULT NULL,
  `qspp_ProcessingTime` varchar(400) DEFAULT NULL,
  `qspp_FirstSynthesizeFeedback` varchar(400) DEFAULT NULL,
  `qspp_FirstReceiveFeedback` varchar(400) DEFAULT NULL,
  `qspp_SecondSynthesizeFeedback` varchar(400) DEFAULT NULL,
  `qspp_SecondReceiveFeedback` varchar(400) DEFAULT NULL,
  `qspp_OriginalRightsAndInterestsOfPeople` varchar(400) DEFAULT NULL,
  `qspp_IndustryBelongedLevelOne` varchar(400) DEFAULT NULL,
  `qspp_RegisteredAddressOne` varchar(400) DEFAULT NULL,
  `qspp_EnterpriseBusinessArea` varchar(400) DEFAULT NULL,
  `qspp_EnterpriseOwnership` varchar(400) DEFAULT NULL,
  `qspp_IsFinancialInstitutionsOrNot` varchar(400) DEFAULT NULL,
  `qspp_MainRating` varchar(400) DEFAULT NULL,
  `qspp_Manager` varchar(400) DEFAULT NULL,
  `qspp_RegulatoryAgenciesProjectManager` varchar(400) DEFAULT NULL,
  `qspp_RegulatoryAgenciesProjectManagerPhone` varchar(400) DEFAULT NULL,
  `qspp_ManagerRegulatoryBureauUnderJurisdiction` varchar(400) DEFAULT NULL,
  `qspp_CertifiedPublicAccountants` varchar(400) DEFAULT NULL,
  `qspp_SignatureAccountants` varchar(400) DEFAULT NULL,
  `qspp_LawFirm` varchar(400) DEFAULT NULL,
  `qspp_SignatureLawyer` varchar(400) DEFAULT NULL,
  `qspp_MainRatingAgency` varchar(400) DEFAULT NULL,
  `qspp_RatingAgencyProjectManager` varchar(400) DEFAULT NULL,
  `qspp_ProcessStatus` varchar(400) DEFAULT NULL,
  `qspp_ActualFinancier` varchar(400) DEFAULT NULL,
  `qspp_MeasuresToIncreaseTrust` varchar(1000) DEFAULT NULL,
  `qspp_Guarantor` varchar(400) DEFAULT NULL,
  `qspp_GuarantorContactInformation` varchar(400) DEFAULT NULL,
  `insertTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of raw_data_abs_trial
-- ----------------------------

-- ----------------------------
-- Table structure for raw_data_bond_base
-- ----------------------------
DROP TABLE IF EXISTS `raw_data_bond_base`;
CREATE TABLE `raw_data_bond_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qspp_SerialNumber` varchar(400) DEFAULT NULL,
  `qspp_ProductCode` varchar(400) DEFAULT NULL,
  `qspp_ProductShortName` varchar(400) DEFAULT NULL,
  `qspp_BondType` varchar(400) DEFAULT NULL,
  `qspp_BondCreditRating` varchar(400) DEFAULT NULL,
  `qspp_FullName` varchar(400) DEFAULT NULL,
  `qspp_BondCurrentIssueAmount` varchar(400) DEFAULT NULL,
  `qspp_BondCouponRate` varchar(400) DEFAULT NULL,
  `qspp_DalueDate` varchar(400) DEFAULT NULL,
  `qspp_StartDateOfTransfer` varchar(400) DEFAULT NULL,
  `qspp_TermOfBond` varchar(400) DEFAULT NULL,
  `qspp_IncreaseTrustPolicy` varchar(1000) DEFAULT NULL,
  `qspp_IssuerFullName` varchar(400) DEFAULT NULL,
  `qspp_IndustryBelongedLevelOne` varchar(400) DEFAULT NULL,
  `qspp_MainRating` varchar(400) DEFAULT NULL,
  `qspp_RegisteredAddressOne` varchar(400) DEFAULT NULL,
  `qspp_RegisteredAddressTwo` varchar(400) DEFAULT NULL,
  `qspp_UnderwritingAgency` varchar(400) DEFAULT NULL,
  `qspp_CertifiedPublicAccountants` varchar(400) DEFAULT NULL,
  `qspp_SignatureAccountants` varchar(400) DEFAULT NULL,
  `qspp_LawFirm` varchar(400) DEFAULT NULL,
  `qspp_SignatureLawyer` varchar(400) DEFAULT NULL,
  `qspp_CreditRatingAgency` varchar(400) DEFAULT NULL,
  `qspp_CreditRatingAgencyProjectLeader` varchar(400) DEFAULT NULL,
  `qspp_CustodianAgency` varchar(400) DEFAULT NULL,
  `qspp_RegisterContact` varchar(400) DEFAULT NULL,
  `qspp_RegistrantContactInformation` varchar(400) DEFAULT NULL,
  `qspp_DueDate` varchar(400) DEFAULT NULL,
  `insertTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of raw_data_bond_base
-- ----------------------------

-- ----------------------------
-- Table structure for record_checkstate
-- ----------------------------
DROP TABLE IF EXISTS `record_checkstate`;
CREATE TABLE `record_checkstate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_item_id` int(11) DEFAULT NULL,
  `module_code` varchar(255) DEFAULT NULL,
  `check_state` int(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `operate_type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=735 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_checkstate
-- ----------------------------
INSERT INTO `record_checkstate` VALUES ('665', '28', 'RiskBreach', '1', '2019-08-26 14:56:46', '2019-08-21 19:43:29', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('666', '371362145', 'SupInfo', '1', '2019-08-23 11:10:15', '2019-08-21 19:44:55', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('667', '371362146', 'SupInfo', '1', '2019-08-23 11:10:08', '2019-08-22 17:16:50', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('668', '31', 'RiskBreach', '1', '2019-08-26 14:42:56', '2019-08-22 17:18:32', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('669', '32', 'RiskBreach', '1', '2019-08-26 14:16:06', '2019-08-22 17:18:54', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('670', '371362145', 'SupInfo', '2', null, '2019-08-26 13:42:41', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('671', '371362148', 'SupInfo', '1', '2019-08-26 14:42:56', '2019-08-26 13:43:31', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('672', '33', 'RiskBreach', '1', '2019-08-28 11:20:24', '2019-08-26 14:12:48', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('673', '193', 'RiskBreach', '1', '2019-08-26 14:39:36', '2019-08-26 14:39:36', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('674', '192', 'RiskBreach', '1', '2019-08-26 15:44:43', '2019-08-26 14:39:39', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('675', '194', 'RiskBreach', '1', '2019-08-26 14:39:49', '2019-08-26 14:39:49', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('676', '195', 'RiskBreach', '1', '2019-08-26 14:39:51', '2019-08-26 14:39:51', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('677', '196', 'RiskBreach', '1', '2019-08-26 14:39:52', '2019-08-26 14:39:52', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('678', '197', 'RiskBreach', '1', '2019-08-26 14:39:54', '2019-08-26 14:39:54', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('679', '198', 'RiskBreach', '1', '2019-08-26 14:39:56', '2019-08-26 14:39:56', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('680', '199', 'RiskBreach', '1', '2019-08-26 14:40:11', '2019-08-26 14:39:58', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('681', '182', 'RiskBreach', '1', '2019-08-28 11:20:34', '2019-08-26 14:41:25', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('682', '183', 'RiskBreach', '1', null, '2019-08-26 14:41:29', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('683', '184', 'RiskBreach', '1', '2019-08-26 14:41:31', '2019-08-26 14:41:31', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('684', '185', 'RiskBreach', '1', '2019-08-26 14:41:33', '2019-08-26 14:41:33', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('685', '186', 'RiskBreach', '1', '2019-08-26 14:41:35', '2019-08-26 14:41:35', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('686', '187', 'RiskBreach', '1', '2019-08-26 14:41:37', '2019-08-26 14:41:37', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('687', '188', 'RiskBreach', '1', '2019-08-26 14:41:38', '2019-08-26 14:41:38', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('688', '189', 'RiskBreach', '1', '2019-08-26 14:41:41', '2019-08-26 14:41:41', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('689', '190', 'RiskBreach', '1', '2019-08-26 14:41:43', '2019-08-26 14:41:43', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('690', '191', 'RiskBreach', '1', '2019-08-26 14:41:46', '2019-08-26 14:41:46', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('691', '371362149', 'SupInfo', '1', '2019-08-26 14:49:32', '2019-08-26 14:49:32', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('692', '371362165', 'SupInfo', '1', null, '2019-08-26 14:55:26', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('693', '371362157', 'SupInfo', '1', '2019-08-26 14:56:31', '2019-08-26 14:55:26', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('694', '371362154', 'SupInfo', '1', '2019-08-26 14:56:46', '2019-08-26 14:55:26', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('695', '371362153', 'SupInfo', '1', '2019-08-26 14:56:31', '2019-08-26 14:55:28', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('696', '371362156', 'SupInfo', '1', '2019-08-26 14:56:22', '2019-08-26 14:55:42', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('697', '16', 'ABSRiskBreach', '2', '2019-08-28 15:33:29', '2019-08-26 15:27:47', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('698', '17', 'ABSRiskBreach', '1', '2019-09-10 16:15:10', '2019-08-26 15:29:16', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('699', '18', 'ABSRiskBreach', '1', '2019-08-28 15:06:50', '2019-08-26 15:31:31', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('700', '19', 'ABSRiskBreach', '1', '2019-08-28 15:25:13', '2019-08-26 15:31:33', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('701', '173', 'ABSSupInfo', '1', '2019-08-28 15:33:04', '2019-08-26 15:33:20', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('702', '174', 'ABSSupInfo', '1', '2019-09-10 16:15:10', '2019-08-26 15:35:12', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('703', '175', 'ABSSupInfo', '1', '2019-08-28 15:06:50', '2019-08-26 15:35:17', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('704', '176', 'ABSSupInfo', '1', '2019-08-28 15:25:13', '2019-08-26 15:35:25', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('705', '20', 'ABSRiskBreach', '1', '2019-08-28 09:42:18', '2019-08-26 15:35:28', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('706', '177', 'ABSSupInfo', '2', '2019-08-28 15:21:22', '2019-08-26 15:35:28', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('707', '178', 'ABSSupInfo', '1', '2019-08-28 15:20:18', '2019-08-28 09:36:38', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('708', '21', 'ABSRiskBreach', '2', '2019-08-28 19:11:19', '2019-08-28 09:36:38', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('709', '371362152', 'SupInfo', '2', '2019-08-28 11:21:57', '2019-08-28 11:21:35', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('710', '235', 'RiskBreach', '1', '2019-08-28 13:55:24', '2019-08-28 13:54:47', '142', null, null);
INSERT INTO `record_checkstate` VALUES ('711', '371362209', 'SupInfo', '1', '2019-08-28 13:55:24', '2019-08-28 13:55:20', '142', null, null);
INSERT INTO `record_checkstate` VALUES ('712', '63', 'ABSRiskBreach', '2', null, '2019-08-28 14:57:23', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('713', '205', 'ABSSupInfo', '2', null, '2019-08-28 14:58:52', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('714', '174', 'ABSSupInfo', '1', '2019-09-10 16:15:10', '2019-08-28 15:05:52', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('715', '175', 'ABSSupInfo', '1', '2019-08-28 15:06:50', '2019-08-28 15:06:33', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('716', '184', 'ABSSupInfo', '1', '2019-08-28 15:26:30', '2019-08-28 15:22:13', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('717', '196', 'ABSSupInfo', '1', '2019-08-30 17:18:09', '2019-08-28 15:24:54', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('718', '27', 'ABSRiskBreach', '1', '2019-08-28 15:26:30', '2019-08-28 15:26:30', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('719', '194', 'ABSSupInfo', '1', '2019-08-30 17:17:48', '2019-08-28 15:28:11', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('720', '37', 'ABSRiskBreach', '1', '2019-08-30 17:17:48', '2019-08-28 15:28:26', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('721', '64', 'ABSRiskBreach', '2', null, '2019-08-28 15:34:09', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('722', '237', 'RiskBreach', '1', '2019-08-28 15:50:52', '2019-08-28 15:50:52', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('723', '237', 'RiskBreach', '1', '2019-08-28 15:50:52', '2019-08-28 15:50:52', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('724', '26', 'ABSRiskBreach', '1', '2019-08-30 17:18:13', '2019-08-28 16:03:44', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('725', '183', 'ABSSupInfo', '1', '2019-08-30 17:18:13', '2019-08-28 16:03:44', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('726', '246', 'RiskBreach', '2', null, '2019-08-28 18:10:14', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('727', '371362210', 'SupInfo', '2', null, '2019-08-28 18:15:10', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('728', '65', 'ABSRiskBreach', '2', '2019-08-30 15:06:30', '2019-08-28 18:24:09', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('729', '213', 'ABSSupInfo', '2', null, '2019-08-28 18:26:06', '1', 'add', null);
INSERT INTO `record_checkstate` VALUES ('730', '25', 'ABSRiskBreach', '2', '2019-08-28 19:11:32', '2019-08-28 19:11:25', '1', 'update', null);
INSERT INTO `record_checkstate` VALUES ('731', '221', 'RiskBreach', '1', null, '2019-08-30 13:39:11', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('732', '222', 'RiskBreach', '1', '2019-08-30 13:39:17', '2019-08-30 13:39:17', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('733', '231', 'RiskBreach', '1', '2019-08-30 13:39:21', '2019-08-30 13:39:21', '1', null, null);
INSERT INTO `record_checkstate` VALUES ('734', '39', 'ABSRiskBreach', '1', '2019-08-30 17:18:09', '2019-08-30 17:17:00', '1', null, null);

-- ----------------------------
-- Table structure for record_earnings_principal
-- ----------------------------
DROP TABLE IF EXISTS `record_earnings_principal`;
CREATE TABLE `record_earnings_principal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_item_id` int(11) DEFAULT NULL COMMENT '模块id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `product_short_name` varchar(255) DEFAULT NULL,
  `allocation_time` datetime DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_earnings_principal
-- ----------------------------

-- ----------------------------
-- Table structure for record_earnings_principal_time
-- ----------------------------
DROP TABLE IF EXISTS `record_earnings_principal_time`;
CREATE TABLE `record_earnings_principal_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `module_item_id` int(11) DEFAULT NULL COMMENT '模块id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `product_html` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record_earnings_principal_time
-- ----------------------------

-- ----------------------------
-- Table structure for risk_breach_cause
-- ----------------------------
DROP TABLE IF EXISTS `risk_breach_cause`;
CREATE TABLE `risk_breach_cause` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `breach_cause` varchar(40) DEFAULT NULL COMMENT '违约原因',
  `breach_bature` varchar(40) DEFAULT NULL COMMENT '违约性质',
  `risk_progress_situation` varchar(40) DEFAULT NULL COMMENT '风险发生及处置进展情况',
  `breach_time` datetime DEFAULT NULL COMMENT '违约日期',
  `paid_amount` varchar(20) DEFAULT NULL COMMENT '已偿金额',
  `unpaid_amount` varchar(20) DEFAULT NULL COMMENT '未偿金额',
  `all_paid_time` datetime DEFAULT NULL COMMENT '全部清偿日期或风险化解日期',
  `supervision_situation` varchar(40) DEFAULT NULL COMMENT '监管情况（主要针对违法违规',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `operator` varchar(40) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of risk_breach_cause
-- ----------------------------
INSERT INTO `risk_breach_cause` VALUES ('8', '27', '1', '1', '主动违约', '1', '2019-08-14 00:00:00', '1', '1', '2019-08-22 00:00:00', '1', '2019-08-21 16:00:43', '2019-08-21 16:00:43', null, '系统管理员', '1');
INSERT INTO `risk_breach_cause` VALUES ('9', '28', '1', '11', '被动违约', '11', '2019-08-28 00:00:00', '11', '111', '2019-08-21 00:00:00', '11', '2019-08-21 19:43:24', '2019-08-21 19:43:24', null, '系统管理员', '11');
INSERT INTO `risk_breach_cause` VALUES ('10', '33', '1', '风险或违约原因', '主动违约', '风险或违约原因', '2019-08-26 00:00:00', '222', '222', '2019-08-26 00:00:00', '222', '2019-08-26 14:12:45', '2019-08-26 14:12:45', null, '系统管理员', '222');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DICT_CODE` varchar(40) DEFAULT NULL,
  `DICT_NAME` varchar(40) DEFAULT NULL,
  `DICT_ORDER` int(11) DEFAULT NULL,
  `DICT_MEMO` varchar(40) DEFAULT NULL,
  `DICT_STATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', 'BOND_TYPE', '债券类型', '1', '债券基本类型', '1');
INSERT INTO `sys_dict` VALUES ('9', 'organtypeArr', '机构类型', '0', '用户界面-机构类型', '1');
INSERT INTO `sys_dict` VALUES ('10', 'usertypeArr', '用户类型', null, '用户界面-用户类型', '1');
INSERT INTO `sys_dict` VALUES ('11', 'userstate', '用户状态', null, '用户界面-用户状态', '1');
INSERT INTO `sys_dict` VALUES ('15', 'NATURE', '企业性质', null, '企业性质类型', '1');
INSERT INTO `sys_dict` VALUES ('16', 'COM_RATING', '主体评级', null, '主体等级', '1');
INSERT INTO `sys_dict` VALUES ('17', 'INDUSTRY', '行业', null, '公司行业类型', '1');
INSERT INTO `sys_dict` VALUES ('18', 'RATING', '债项评级', null, '债项评级', '1');
INSERT INTO `sys_dict` VALUES ('19', 'ISSUE_WAY', '发行方式', null, '发行方式类型', '1');
INSERT INTO `sys_dict` VALUES ('20', 'TRADING_LOCATION', '交易场所', null, '交易场所类型', '1');
INSERT INTO `sys_dict` VALUES ('22', 'RISK_STATE', '风险状态', null, '高风险及违约债券模块', '1');
INSERT INTO `sys_dict` VALUES ('23', 'PROPER_MANAGEMENT', '是否实行投资者适当性管理', null, '是否实行投资者适当性管理', '1');
INSERT INTO `sys_dict` VALUES ('24', 'PLEDGE_BUYBACK', '是否属于质押式回购可质押债券', null, '是否属于质押式回购可质押债券', '1');
INSERT INTO `sys_dict` VALUES ('25', 'INITIAL_RATING', '债项初始评级', null, '高风险-债项初始评级', '1');
INSERT INTO `sys_dict` VALUES ('27', 'CURRENT_RATING', '债项当前评级', null, '高风险-债项当前评级', '1');
INSERT INTO `sys_dict` VALUES ('28', 'TRADE_STATE', '交易状态', null, '高风险-交易状态', '1');
INSERT INTO `sys_dict` VALUES ('29', 'PLEDGE', '是否在质押库', null, '风险等级-是否在质押库', '1');
INSERT INTO `sys_dict` VALUES ('32', 'LETTER_TYPE', '函件类型', '0', '函件类型', '1');
INSERT INTO `sys_dict` VALUES ('34', 'queryuserstate', '查询-用户状态', null, '用户页面查询参数', '1');
INSERT INTO `sys_dict` VALUES ('35', 'queryorgantypeArr', '查询-机构类型', null, '用户界面查询参数', '1');
INSERT INTO `sys_dict` VALUES ('36', 'EXAMINE_VERIFY_STATE', '审核状态', null, '在审项目-描述审核是否通过', '1');
INSERT INTO `sys_dict` VALUES ('39', 'CORPORATE_CREDIT_RATING', '主体评级', null, '在审项目-主体评级', '1');
INSERT INTO `sys_dict` VALUES ('40', 'OPERATE_MODULE', '日志-操作模块', null, '日志-操作模块', '1');
INSERT INTO `sys_dict` VALUES ('41', 'ISSUER_PROVINCE', '发行人注册地', null, '风险等级-注册地', '1');
INSERT INTO `sys_dict` VALUES ('43', 'OBJ_TYPE', '监管对象类型', null, '监管对象类型', '1');
INSERT INTO `sys_dict` VALUES ('46', 'COM_CURRENT_RATING', '主体当前评级', null, '风险-高风险', '1');
INSERT INTO `sys_dict` VALUES ('47', 'COM_INITIAL_RATING', '主体初始评级', null, '风险-高风险', '1');
INSERT INTO `sys_dict` VALUES ('48', 'STATE', '状态', null, '状态', '1');
INSERT INTO `sys_dict` VALUES ('49', 'percode', '权限类型', null, '权限信息-新增-权限类型', '1');
INSERT INTO `sys_dict` VALUES ('50', 'menucode', '导航菜单', null, '导航父级菜单', '1');
INSERT INTO `sys_dict` VALUES ('51', 'menuicon', '导航菜单图标', null, '左侧菜单icon', '1');
INSERT INTO `sys_dict` VALUES ('52', 'SRB', '证监局', '0', '用户新增-机构名称', '1');
INSERT INTO `sys_dict` VALUES ('53', 'FINANCIAL', '是否为金融行业', null, '是否为金融行业', '1');
INSERT INTO `sys_dict` VALUES ('54', 'MODULAR_NAME', '模块名称', null, '模块名称', '1');
INSERT INTO `sys_dict` VALUES ('55', 'AUDIT_STATE', '审核状态', null, '审核状态', '1');
INSERT INTO `sys_dict` VALUES ('56', 'BREACH_BATURE', '违约性质', null, '风险或违约原因-高风险', '1');
INSERT INTO `sys_dict` VALUES ('57', 'ABSType', '资产支持证券类型', null, '资产支持证券类型', '1');
INSERT INTO `sys_dict` VALUES ('58', 'ISSUER_FINANCIAL', '是否金融行业', null, 'ISSUER_FINANCIAL', '1');
INSERT INTO `sys_dict` VALUES ('59', 'prov', '省', null, '省', '1');
INSERT INTO `sys_dict` VALUES ('64', '北京', '北京', null, '北京', '1');
INSERT INTO `sys_dict` VALUES ('65', '上海', '上海', null, '上海', '1');
INSERT INTO `sys_dict` VALUES ('66', '天津', '天津', null, '天津', '1');
INSERT INTO `sys_dict` VALUES ('67', '重庆', '重庆', null, '重庆', '1');
INSERT INTO `sys_dict` VALUES ('68', '河北', '河北', null, '河北', '1');
INSERT INTO `sys_dict` VALUES ('69', '山西', '山西', null, '山西', '1');
INSERT INTO `sys_dict` VALUES ('70', '河南', '河南', null, '河南', '1');
INSERT INTO `sys_dict` VALUES ('71', '辽宁', '辽宁', null, '辽宁', '1');
INSERT INTO `sys_dict` VALUES ('72', '吉林', '吉林', null, '吉林', '1');
INSERT INTO `sys_dict` VALUES ('73', '黑龙江', '黑龙江', null, '黑龙江', '1');
INSERT INTO `sys_dict` VALUES ('74', '内蒙古', '内蒙古', null, '内蒙古', '1');
INSERT INTO `sys_dict` VALUES ('75', '江苏', '江苏', null, '江苏', '1');
INSERT INTO `sys_dict` VALUES ('76', '山东', '山东', null, '山东', '1');
INSERT INTO `sys_dict` VALUES ('77', '安徽', '安徽', null, '安徽', '1');
INSERT INTO `sys_dict` VALUES ('78', '浙江', '浙江', null, '浙江', '1');
INSERT INTO `sys_dict` VALUES ('79', '福建', '福建', null, '福建', '1');
INSERT INTO `sys_dict` VALUES ('80', '湖北', '湖北', null, '湖北', '1');
INSERT INTO `sys_dict` VALUES ('81', '湖南', '湖南', null, '湖南', '1');
INSERT INTO `sys_dict` VALUES ('82', '广东', '广东', null, '广东', '1');
INSERT INTO `sys_dict` VALUES ('83', '广西', '广西', null, '广西', '1');
INSERT INTO `sys_dict` VALUES ('84', '江西', '江西', null, '江西', '1');
INSERT INTO `sys_dict` VALUES ('85', '四川', '四川', null, '四川', '1');
INSERT INTO `sys_dict` VALUES ('86', '海南', '海南', null, '海南', '1');
INSERT INTO `sys_dict` VALUES ('87', '贵州', '贵州', null, '贵州', '1');
INSERT INTO `sys_dict` VALUES ('88', '云南', '云南', null, '云南', '1');
INSERT INTO `sys_dict` VALUES ('89', '西藏', '西藏', null, '西藏', '1');
INSERT INTO `sys_dict` VALUES ('90', '陕西', '陕西', null, '陕西', '1');
INSERT INTO `sys_dict` VALUES ('91', '甘肃', '甘肃', null, '甘肃', '1');
INSERT INTO `sys_dict` VALUES ('92', '青海', '青海', null, '青海', '1');
INSERT INTO `sys_dict` VALUES ('93', '宁夏', '宁夏', null, '宁夏', '1');
INSERT INTO `sys_dict` VALUES ('94', '新疆', '新疆', null, '新疆', '1');
INSERT INTO `sys_dict` VALUES ('95', '台湾', '台湾', null, '台湾', '1');
INSERT INTO `sys_dict` VALUES ('96', '香港', '香港', null, '香港', '1');
INSERT INTO `sys_dict` VALUES ('97', '澳门', '澳门', null, '澳门', '1');
INSERT INTO `sys_dict` VALUES ('204', 'SHUJU_PRI', '数据权限', null, '数据权限', '1');

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DICT_PID` varchar(40) DEFAULT NULL,
  `DICT_KEY` varchar(40) DEFAULT NULL,
  `DICT_VAL` varchar(40) DEFAULT NULL,
  `DICT_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=897 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_item
-- ----------------------------
INSERT INTO `sys_dict_item` VALUES ('1', '1', '普通公司债', '普通公司债', '0');
INSERT INTO `sys_dict_item` VALUES ('5', '1', '证券公司次级债', '证券公司次级债', '0');
INSERT INTO `sys_dict_item` VALUES ('6', '1', '可交换债券', '可交换债券', '0');
INSERT INTO `sys_dict_item` VALUES ('7', '1', '可转换债券', '可转换债券', '0');
INSERT INTO `sys_dict_item` VALUES ('15', '9', '中证报价', '中证报价', '0');
INSERT INTO `sys_dict_item` VALUES ('16', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('17', '9', '证监局', '证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('18', '9', '证券公司', '证券公司', '0');
INSERT INTO `sys_dict_item` VALUES ('19', '10', '证监局用户', '证监局用户', '0');
INSERT INTO `sys_dict_item` VALUES ('20', '10', '中证报价用户', '中证报价用户', '0');
INSERT INTO `sys_dict_item` VALUES ('21', '10', '协会用户', '协会用户', '0');
INSERT INTO `sys_dict_item` VALUES ('22', '10', '主用户', '主用户', '0');
INSERT INTO `sys_dict_item` VALUES ('23', '10', '系统管理员', '系统管理员', '0');
INSERT INTO `sys_dict_item` VALUES ('24', '11', '有效用户', '有效用户', '0');
INSERT INTO `sys_dict_item` VALUES ('25', '11', '无效用户', '无效用户', '0');
INSERT INTO `sys_dict_item` VALUES ('26', '11', '信息待完善', '信息待完善', '0');
INSERT INTO `sys_dict_item` VALUES ('29', '15', '中央国企', '中央国企', null);
INSERT INTO `sys_dict_item` VALUES ('30', '15', '地方国企', '地方国企', null);
INSERT INTO `sys_dict_item` VALUES ('31', '15', '外商独资', '外商独资', null);
INSERT INTO `sys_dict_item` VALUES ('32', '15', '民企', '民企', null);
INSERT INTO `sys_dict_item` VALUES ('33', '16', 'AAA', 'AAA', '0');
INSERT INTO `sys_dict_item` VALUES ('34', '16', 'AA+', 'AA+', '0');
INSERT INTO `sys_dict_item` VALUES ('35', '17', '农、林、牧、渔业', '农、林、牧、渔业', '0');
INSERT INTO `sys_dict_item` VALUES ('36', '17', '采矿业', '采矿业', '0');
INSERT INTO `sys_dict_item` VALUES ('37', '18', 'AAA', 'AAA', '0');
INSERT INTO `sys_dict_item` VALUES ('38', '18', 'AA+', 'AA+', '0');
INSERT INTO `sys_dict_item` VALUES ('40', '19', '私募', '私募', null);
INSERT INTO `sys_dict_item` VALUES ('41', '20', '报价系统', '报价系统', null);
INSERT INTO `sys_dict_item` VALUES ('44', '22', '违约', '违约', '0');
INSERT INTO `sys_dict_item` VALUES ('45', '22', '高风险', '高风险', '0');
INSERT INTO `sys_dict_item` VALUES ('46', '23', '是', '是', '0');
INSERT INTO `sys_dict_item` VALUES ('47', '23', '否', '否', '0');
INSERT INTO `sys_dict_item` VALUES ('48', '24', '是', '是', '0');
INSERT INTO `sys_dict_item` VALUES ('49', '24', '否', '否', '0');
INSERT INTO `sys_dict_item` VALUES ('50', '25', '一级', '一级', '0');
INSERT INTO `sys_dict_item` VALUES ('51', '25', '二级', '二级', '0');
INSERT INTO `sys_dict_item` VALUES ('52', '27', '一级', '一级', '0');
INSERT INTO `sys_dict_item` VALUES ('53', '27', '二级', '二级', '0');
INSERT INTO `sys_dict_item` VALUES ('55', '28', '未成交', '未成交', '0');
INSERT INTO `sys_dict_item` VALUES ('56', '28', '已成交', '已成交', '0');
INSERT INTO `sys_dict_item` VALUES ('58', '29', '是', '是', '0');
INSERT INTO `sys_dict_item` VALUES ('59', '29', '否', '否', '0');
INSERT INTO `sys_dict_item` VALUES ('63', '32', '报价系统函', '报价系统函', null);
INSERT INTO `sys_dict_item` VALUES ('64', '32', '证监会函', '证监会函', null);
INSERT INTO `sys_dict_item` VALUES ('65', '32', '证监局函', '证监局函', null);
INSERT INTO `sys_dict_item` VALUES ('66', '32', '回函', '回函', null);
INSERT INTO `sys_dict_item` VALUES ('67', '32', '其它', '其它', null);
INSERT INTO `sys_dict_item` VALUES ('68', '34', '全部', '全部', null);
INSERT INTO `sys_dict_item` VALUES ('69', '34', '有效用户', '有效用户', null);
INSERT INTO `sys_dict_item` VALUES ('70', '34', '无效用户', '无效用户', null);
INSERT INTO `sys_dict_item` VALUES ('71', '34', '信息待完善', '信息待完善', null);
INSERT INTO `sys_dict_item` VALUES ('72', '35', '全部', '全部', '0');
INSERT INTO `sys_dict_item` VALUES ('73', '35', '中证报价', '中证报价', null);
INSERT INTO `sys_dict_item` VALUES ('74', '35', '证监局', '证监局', null);
INSERT INTO `sys_dict_item` VALUES ('75', '35', '证券公司', '证券公司', null);
INSERT INTO `sys_dict_item` VALUES ('76', '9', '证监会债券部', '证监会债券部', null);
INSERT INTO `sys_dict_item` VALUES ('77', null, '中证报价', '中证报价', null);
INSERT INTO `sys_dict_item` VALUES ('78', null, '中证报价', '中证报价', null);
INSERT INTO `sys_dict_item` VALUES ('79', '9', '中国结算', '中国结算', null);
INSERT INTO `sys_dict_item` VALUES ('80', '9', '证券业协会', '证券业协会', null);
INSERT INTO `sys_dict_item` VALUES ('81', null, '中证报价', '中证报价', null);
INSERT INTO `sys_dict_item` VALUES ('82', '35', '证监会债券部', '证监会债券部', null);
INSERT INTO `sys_dict_item` VALUES ('83', '35', '中国结算', '中国结算', null);
INSERT INTO `sys_dict_item` VALUES ('84', '35', '证券业协会', '证券业协会', null);
INSERT INTO `sys_dict_item` VALUES ('85', '36', '未通过', '未通过', null);
INSERT INTO `sys_dict_item` VALUES ('86', '36', '通过', '通过', null);
INSERT INTO `sys_dict_item` VALUES ('87', '39', 'AAA', 'AAA', null);
INSERT INTO `sys_dict_item` VALUES ('88', '39', 'AA', 'AA', null);
INSERT INTO `sys_dict_item` VALUES ('89', '39', 'A', 'A', null);
INSERT INTO `sys_dict_item` VALUES ('90', '39', 'BBB', 'BBB', null);
INSERT INTO `sys_dict_item` VALUES ('91', '39', 'BB', 'BB', null);
INSERT INTO `sys_dict_item` VALUES ('92', '39', 'B', 'B', null);
INSERT INTO `sys_dict_item` VALUES ('93', '39', 'CCC', 'CCC', null);
INSERT INTO `sys_dict_item` VALUES ('94', '39', 'CC', 'CC', null);
INSERT INTO `sys_dict_item` VALUES ('95', '39', 'C', 'C', null);
INSERT INTO `sys_dict_item` VALUES ('96', '40', '--------全部-------', '', '0');
INSERT INTO `sys_dict_item` VALUES ('97', '40', '在审项目信息', '在审项目信息', null);
INSERT INTO `sys_dict_item` VALUES ('98', '40', '债券风险等级', '债券风险等级', null);
INSERT INTO `sys_dict_item` VALUES ('99', '40', '高风险及违约债券', '高风险及违约债券', null);
INSERT INTO `sys_dict_item` VALUES ('100', '40', '债券监管信息', '债券监管信息', null);
INSERT INTO `sys_dict_item` VALUES ('101', '40', '债券基本情况', '债券基本情况', '0');
INSERT INTO `sys_dict_item` VALUES ('112', '41', '北京', '北京', null);
INSERT INTO `sys_dict_item` VALUES ('113', '41', '上海', '上海', null);
INSERT INTO `sys_dict_item` VALUES ('114', '41', '深圳', '深圳', null);
INSERT INTO `sys_dict_item` VALUES ('115', '43', '发行人', '发行人', null);
INSERT INTO `sys_dict_item` VALUES ('116', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('117', '43', '中介机构', '中介机构', null);
INSERT INTO `sys_dict_item` VALUES ('118', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('119', '31', '一级', '一级', null);
INSERT INTO `sys_dict_item` VALUES ('122', '46', '一级', '一级', null);
INSERT INTO `sys_dict_item` VALUES ('123', '46', '二级', '二级', null);
INSERT INTO `sys_dict_item` VALUES ('127', '47', '一级', '一级', null);
INSERT INTO `sys_dict_item` VALUES ('128', '47', '二级', '二级', null);
INSERT INTO `sys_dict_item` VALUES ('130', '48', '审核通过', '1', '0');
INSERT INTO `sys_dict_item` VALUES ('131', '48', '已删除', '2', '0');
INSERT INTO `sys_dict_item` VALUES ('132', '48', '草稿', '3', '0');
INSERT INTO `sys_dict_item` VALUES ('133', '49', '可操作模块-导航', '可操作模块-导航', null);
INSERT INTO `sys_dict_item` VALUES ('134', '49', '用户体系-菜单', '用户体系-菜单', null);
INSERT INTO `sys_dict_item` VALUES ('135', '50', 'ZQJBQKGL', '债券管理', '0');
INSERT INTO `sys_dict_item` VALUES ('136', '50', 'ABSGL', 'ABS管理', '0');
INSERT INTO `sys_dict_item` VALUES ('137', '50', 'XTGL', '系统管理', '0');
INSERT INTO `sys_dict_item` VALUES ('149', '52', '北京证监局', '北京证监局', null);
INSERT INTO `sys_dict_item` VALUES ('150', '52', '天津证监局', '天津证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('151', '52', '河北证监局', '河北证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('152', '52', '山西证监局', '山西证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('153', '52', '内蒙古证监局', '内蒙古证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('154', '52', '辽宁证监局', '辽宁证监局', '0');
INSERT INTO `sys_dict_item` VALUES ('155', '52', '云南证监局', '云南证监局', null);
INSERT INTO `sys_dict_item` VALUES ('156', '52', '海南证监局', '海南证监局', null);
INSERT INTO `sys_dict_item` VALUES ('157', '52', '四川证监局', '四川证监局', null);
INSERT INTO `sys_dict_item` VALUES ('158', '52', '贵州证监局', '贵州证监局', null);
INSERT INTO `sys_dict_item` VALUES ('159', '52', '大连证监局', '大连证监局', null);
INSERT INTO `sys_dict_item` VALUES ('160', '52', '青岛证监局', '青岛证监局', null);
INSERT INTO `sys_dict_item` VALUES ('161', '52', '青海证监局', '青海证监局', null);
INSERT INTO `sys_dict_item` VALUES ('162', '52', '河南证监局', '河南证监局', null);
INSERT INTO `sys_dict_item` VALUES ('163', '52', '山东证监局', '山东证监局', null);
INSERT INTO `sys_dict_item` VALUES ('164', null, '北京证监局', '北京证监局', null);
INSERT INTO `sys_dict_item` VALUES ('166', '53', '是', '是', null);
INSERT INTO `sys_dict_item` VALUES ('167', '53', '否', '否', null);
INSERT INTO `sys_dict_item` VALUES ('168', '54', '债券基本信息', '债券基本信息', null);
INSERT INTO `sys_dict_item` VALUES ('169', '54', '在审项目信息', '在审项目信息', null);
INSERT INTO `sys_dict_item` VALUES ('170', '54', '风险监测信息', '风险监测信息', '0');
INSERT INTO `sys_dict_item` VALUES ('172', '54', '监管信息', '监管信息', null);
INSERT INTO `sys_dict_item` VALUES ('177', '56', '主动违约', '主动违约', '0');
INSERT INTO `sys_dict_item` VALUES ('178', '56', '被动违约', '被动违约', null);
INSERT INTO `sys_dict_item` VALUES ('179', null, '主动违约', '主动违约', null);
INSERT INTO `sys_dict_item` VALUES ('186', '1', '用于并购重组用途的债券', '用于并购重组用途的债券', null);
INSERT INTO `sys_dict_item` VALUES ('187', null, '可转换债券', '可转换债券', null);
INSERT INTO `sys_dict_item` VALUES ('188', null, '可转换债券', '可转换债券', null);
INSERT INTO `sys_dict_item` VALUES ('189', '1', '中小企业私募债', '中小企业私募债', null);
INSERT INTO `sys_dict_item` VALUES ('190', '1', '永续债', '永续债', null);
INSERT INTO `sys_dict_item` VALUES ('191', null, '可转换债券', '可转换债券', null);
INSERT INTO `sys_dict_item` VALUES ('192', '18', 'AA', 'AA', null);
INSERT INTO `sys_dict_item` VALUES ('193', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('194', '18', 'AA-', 'AA-', null);
INSERT INTO `sys_dict_item` VALUES ('195', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('196', '18', 'A+', 'A+', null);
INSERT INTO `sys_dict_item` VALUES ('197', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('198', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('199', '18', 'A', 'A', null);
INSERT INTO `sys_dict_item` VALUES ('200', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('201', '18', 'A-', 'A-', null);
INSERT INTO `sys_dict_item` VALUES ('202', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('203', '18', 'BBB', 'BBB', null);
INSERT INTO `sys_dict_item` VALUES ('204', '18', 'BB+', 'BB+', null);
INSERT INTO `sys_dict_item` VALUES ('205', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('206', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('207', '18', 'BB', 'BB', null);
INSERT INTO `sys_dict_item` VALUES ('208', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('209', '18', 'BB-', 'BB-', null);
INSERT INTO `sys_dict_item` VALUES ('210', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('211', '18', 'B+', 'B+', null);
INSERT INTO `sys_dict_item` VALUES ('212', '18', 'B', 'B', null);
INSERT INTO `sys_dict_item` VALUES ('213', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('214', '18', 'B-', 'B-', null);
INSERT INTO `sys_dict_item` VALUES ('215', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('216', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('217', '18', 'CCC', 'CCC', null);
INSERT INTO `sys_dict_item` VALUES ('218', '18', 'CC', 'CC', null);
INSERT INTO `sys_dict_item` VALUES ('219', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('220', '18', 'C', 'C', null);
INSERT INTO `sys_dict_item` VALUES ('221', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('222', '17', '制造业', '制造业', null);
INSERT INTO `sys_dict_item` VALUES ('223', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('224', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('225', '17', '电力、热力、燃气及水生产和供应业', '电力、热力、燃气及水生产和供应业', null);
INSERT INTO `sys_dict_item` VALUES ('226', '17', '建筑业', '建筑业', null);
INSERT INTO `sys_dict_item` VALUES ('227', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('228', '17', '批发和零售业', '批发和零售业', null);
INSERT INTO `sys_dict_item` VALUES ('229', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('230', '17', '交通运输、仓库和邮政业', '交通运输、仓库和邮政业', null);
INSERT INTO `sys_dict_item` VALUES ('231', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('232', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('233', '17', '住宿和餐饮业', '住宿和餐饮业', null);
INSERT INTO `sys_dict_item` VALUES ('234', '17', '信息传输、软件和信息技术服务业', '信息传输、软件和信息技术服务业', null);
INSERT INTO `sys_dict_item` VALUES ('235', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('236', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('237', '17', '金融业', '金融业', null);
INSERT INTO `sys_dict_item` VALUES ('238', '17', '房地产业', '房地产业', null);
INSERT INTO `sys_dict_item` VALUES ('239', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('240', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('241', '17', '租赁和商务服务业', '租赁和商务服务业', null);
INSERT INTO `sys_dict_item` VALUES ('242', '17', '科学研究和技术服务业', '科学研究和技术服务业', null);
INSERT INTO `sys_dict_item` VALUES ('243', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('244', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('245', '17', '水利、环境和公共设施管理业', '水利、环境和公共设施管理业', null);
INSERT INTO `sys_dict_item` VALUES ('246', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('247', '17', '教育', '教育', null);
INSERT INTO `sys_dict_item` VALUES ('248', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('249', '17', '卫生和社会工作', '卫生和社会工作', null);
INSERT INTO `sys_dict_item` VALUES ('250', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('251', '17', '文化、体育和娱乐业', '文化、体育和娱乐业', null);
INSERT INTO `sys_dict_item` VALUES ('252', '17', '综合', '综合', null);
INSERT INTO `sys_dict_item` VALUES ('253', null, '采矿业', '采矿业', null);
INSERT INTO `sys_dict_item` VALUES ('254', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('255', '16', 'AA', 'AA', null);
INSERT INTO `sys_dict_item` VALUES ('256', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('257', '16', 'AA-', 'AA-', null);
INSERT INTO `sys_dict_item` VALUES ('258', '16', 'A+', 'A+', null);
INSERT INTO `sys_dict_item` VALUES ('259', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('260', '16', 'A', 'A', null);
INSERT INTO `sys_dict_item` VALUES ('261', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('262', '16', 'A-', 'A-', null);
INSERT INTO `sys_dict_item` VALUES ('263', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('264', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('265', '16', 'BBB', 'BBB', null);
INSERT INTO `sys_dict_item` VALUES ('266', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('267', '16', 'BB+', 'BB+', null);
INSERT INTO `sys_dict_item` VALUES ('268', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('269', '16', 'BB', 'BB', null);
INSERT INTO `sys_dict_item` VALUES ('270', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('271', '16', 'BB-', 'BB-', null);
INSERT INTO `sys_dict_item` VALUES ('272', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('273', '16', 'B+', 'B+', null);
INSERT INTO `sys_dict_item` VALUES ('274', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('275', '16', 'B', 'B', null);
INSERT INTO `sys_dict_item` VALUES ('276', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('277', '16', 'B-', 'B-', null);
INSERT INTO `sys_dict_item` VALUES ('278', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('279', '16', 'CCC', 'CCC', null);
INSERT INTO `sys_dict_item` VALUES ('280', '16', 'CC', 'CC', null);
INSERT INTO `sys_dict_item` VALUES ('281', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('282', null, 'AA+', 'AA+', null);
INSERT INTO `sys_dict_item` VALUES ('283', '16', 'C', 'C', null);
INSERT INTO `sys_dict_item` VALUES ('284', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('285', '52', '吉林证监局', '吉林证监局', null);
INSERT INTO `sys_dict_item` VALUES ('286', '52', '黑龙江证监局', '黑龙江证监局', null);
INSERT INTO `sys_dict_item` VALUES ('287', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('288', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('289', '52', '上海证监局', '上海证监局', null);
INSERT INTO `sys_dict_item` VALUES ('290', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('291', '52', '江苏证监局', '江苏证监局', null);
INSERT INTO `sys_dict_item` VALUES ('292', '52', '浙江证监局', '浙江证监局', null);
INSERT INTO `sys_dict_item` VALUES ('293', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('294', '52', '安徽证监局', '安徽证监局', null);
INSERT INTO `sys_dict_item` VALUES ('295', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('296', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('297', '52', '福建证监局', '福建证监局', null);
INSERT INTO `sys_dict_item` VALUES ('298', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('299', '52', '江西证监局', '江西证监局', null);
INSERT INTO `sys_dict_item` VALUES ('300', '52', '湖北证监局', '湖北证监局', null);
INSERT INTO `sys_dict_item` VALUES ('301', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('302', '52', '湖南证监局', '湖南证监局', null);
INSERT INTO `sys_dict_item` VALUES ('303', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('304', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('305', '52', '广东证监局', '广东证监局', null);
INSERT INTO `sys_dict_item` VALUES ('306', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('307', '52', '广西证监局', '广西证监局', null);
INSERT INTO `sys_dict_item` VALUES ('308', '52', '重庆证监局', '重庆证监局', null);
INSERT INTO `sys_dict_item` VALUES ('309', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('310', '52', '西藏证监局', '西藏证监局', null);
INSERT INTO `sys_dict_item` VALUES ('311', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('312', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('313', '52', '陕西证监局', '陕西证监局', null);
INSERT INTO `sys_dict_item` VALUES ('314', '52', '甘肃证监局', '甘肃证监局', null);
INSERT INTO `sys_dict_item` VALUES ('315', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('316', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('317', '52', '宁夏证监局', '宁夏证监局', null);
INSERT INTO `sys_dict_item` VALUES ('318', '52', '新疆证监局', '新疆证监局', null);
INSERT INTO `sys_dict_item` VALUES ('319', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('320', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('321', '52', '深圳证监局', '深圳证监局', null);
INSERT INTO `sys_dict_item` VALUES ('322', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('323', '52', '宁波证监局', '宁波证监局', null);
INSERT INTO `sys_dict_item` VALUES ('324', '52', '厦门证监局', '厦门证监局', null);
INSERT INTO `sys_dict_item` VALUES ('325', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('326', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('327', '15', '中外合资', '中外合资', null);
INSERT INTO `sys_dict_item` VALUES ('328', null, '辽宁证监局', '辽宁证监局', null);
INSERT INTO `sys_dict_item` VALUES ('329', '15', '中外合作', '中外合作', null);
INSERT INTO `sys_dict_item` VALUES ('330', '54', 'ABS基本信息', 'ABS基本信息', '0');
INSERT INTO `sys_dict_item` VALUES ('331', '54', 'ABS在审项目信息', 'ABS在审项目信息', null);
INSERT INTO `sys_dict_item` VALUES ('332', '54', 'ABS风险监测信息', 'ABS风险监测信息', '0');
INSERT INTO `sys_dict_item` VALUES ('334', '54', 'ABS监管信息', 'ABS监管信息', null);
INSERT INTO `sys_dict_item` VALUES ('335', '48', '待审核', '4', null);
INSERT INTO `sys_dict_item` VALUES ('336', null, '草稿', '3', null);
INSERT INTO `sys_dict_item` VALUES ('337', '48', '退回补正', '5', null);
INSERT INTO `sys_dict_item` VALUES ('338', null, '草稿', '3', null);
INSERT INTO `sys_dict_item` VALUES ('339', '55', '待受理', '1', null);
INSERT INTO `sys_dict_item` VALUES ('340', '55', '未受理', '2', null);
INSERT INTO `sys_dict_item` VALUES ('341', '55', '已受理', '3', null);
INSERT INTO `sys_dict_item` VALUES ('342', '55', '已反馈', '4', null);
INSERT INTO `sys_dict_item` VALUES ('343', '55', '已接收反馈意见', '5', null);
INSERT INTO `sys_dict_item` VALUES ('344', '55', '不通过', '6', null);
INSERT INTO `sys_dict_item` VALUES ('345', '55', '终止', '7', null);
INSERT INTO `sys_dict_item` VALUES ('346', '55', '通过', '8', null);
INSERT INTO `sys_dict_item` VALUES ('347', '58', '是', '是', null);
INSERT INTO `sys_dict_item` VALUES ('348', '58', '否', '否', null);
INSERT INTO `sys_dict_item` VALUES ('350', '60', '郑州市', '郑州市', '0');
INSERT INTO `sys_dict_item` VALUES ('352', null, '河南省', '河南省', null);
INSERT INTO `sys_dict_item` VALUES ('354', '62', '东城区', '东城区', null);
INSERT INTO `sys_dict_item` VALUES ('355', null, '郑州市', '郑州市', null);
INSERT INTO `sys_dict_item` VALUES ('356', '62', '西城区', '西城区', null);
INSERT INTO `sys_dict_item` VALUES ('357', null, '郑州市', '郑州市', null);
INSERT INTO `sys_dict_item` VALUES ('361', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('362', '59', '北京', '北京', null);
INSERT INTO `sys_dict_item` VALUES ('363', '59', '上海', '上海', null);
INSERT INTO `sys_dict_item` VALUES ('364', '59', '天津', '天津', null);
INSERT INTO `sys_dict_item` VALUES ('365', '59', '重庆', '重庆', null);
INSERT INTO `sys_dict_item` VALUES ('366', '59', '河北', '河北', null);
INSERT INTO `sys_dict_item` VALUES ('367', '59', '山西', '山西', null);
INSERT INTO `sys_dict_item` VALUES ('368', '59', '河南', '河南', null);
INSERT INTO `sys_dict_item` VALUES ('369', '59', '辽宁', '辽宁', null);
INSERT INTO `sys_dict_item` VALUES ('370', '59', '吉林', '吉林', null);
INSERT INTO `sys_dict_item` VALUES ('371', '59', '黑龙江', '黑龙江', null);
INSERT INTO `sys_dict_item` VALUES ('372', '59', '内蒙古', '内蒙古', null);
INSERT INTO `sys_dict_item` VALUES ('373', '59', '江苏', '江苏', null);
INSERT INTO `sys_dict_item` VALUES ('374', '59', '山东', '山东', null);
INSERT INTO `sys_dict_item` VALUES ('375', '59', '安徽', '安徽', null);
INSERT INTO `sys_dict_item` VALUES ('376', '59', '浙江', '浙江', null);
INSERT INTO `sys_dict_item` VALUES ('377', '59', '福建', '福建', null);
INSERT INTO `sys_dict_item` VALUES ('378', '59', '湖北', '湖北', null);
INSERT INTO `sys_dict_item` VALUES ('379', '59', '湖南', '湖南', null);
INSERT INTO `sys_dict_item` VALUES ('380', '59', '广东', '广东', null);
INSERT INTO `sys_dict_item` VALUES ('381', '59', '广西', '广西', null);
INSERT INTO `sys_dict_item` VALUES ('382', '59', '江西', '江西', null);
INSERT INTO `sys_dict_item` VALUES ('383', '59', '四川', '四川', null);
INSERT INTO `sys_dict_item` VALUES ('384', '59', '海南', '海南', null);
INSERT INTO `sys_dict_item` VALUES ('385', '59', '贵州', '贵州', null);
INSERT INTO `sys_dict_item` VALUES ('386', '59', '云南', '云南', null);
INSERT INTO `sys_dict_item` VALUES ('387', '59', '西藏', '西藏', null);
INSERT INTO `sys_dict_item` VALUES ('388', '59', '陕西', '陕西', null);
INSERT INTO `sys_dict_item` VALUES ('389', '59', '甘肃', '甘肃', null);
INSERT INTO `sys_dict_item` VALUES ('390', '59', '青海', '青海', null);
INSERT INTO `sys_dict_item` VALUES ('391', '59', '宁夏', '宁夏', null);
INSERT INTO `sys_dict_item` VALUES ('392', '59', '新疆', '新疆', null);
INSERT INTO `sys_dict_item` VALUES ('393', '59', '台湾', '台湾', null);
INSERT INTO `sys_dict_item` VALUES ('394', '59', '香港', '香港', null);
INSERT INTO `sys_dict_item` VALUES ('395', '59', '澳门', '澳门', null);
INSERT INTO `sys_dict_item` VALUES ('396', '64', '朝阳区', '朝阳区', null);
INSERT INTO `sys_dict_item` VALUES ('397', '64', '海淀区', '海淀区', null);
INSERT INTO `sys_dict_item` VALUES ('398', '64', '西城区', '西城区', null);
INSERT INTO `sys_dict_item` VALUES ('399', '64', '东城区', '东城区', null);
INSERT INTO `sys_dict_item` VALUES ('400', '64', '崇文区', '崇文区', null);
INSERT INTO `sys_dict_item` VALUES ('401', '64', '宣武区', '宣武区', null);
INSERT INTO `sys_dict_item` VALUES ('402', '64', '丰台区', '丰台区', null);
INSERT INTO `sys_dict_item` VALUES ('403', '64', '石景山区', '石景山区', null);
INSERT INTO `sys_dict_item` VALUES ('404', '64', '门头沟', '门头沟', null);
INSERT INTO `sys_dict_item` VALUES ('405', '64', '房山区', '房山区', null);
INSERT INTO `sys_dict_item` VALUES ('406', '64', '通州区', '通州区', null);
INSERT INTO `sys_dict_item` VALUES ('407', '64', '大兴区', '大兴区', null);
INSERT INTO `sys_dict_item` VALUES ('408', '64', '顺义区', '顺义区', null);
INSERT INTO `sys_dict_item` VALUES ('409', '64', '怀柔区', '怀柔区', null);
INSERT INTO `sys_dict_item` VALUES ('410', '64', '密云区', '密云区', null);
INSERT INTO `sys_dict_item` VALUES ('411', '64', '昌平区', '昌平区', null);
INSERT INTO `sys_dict_item` VALUES ('412', '64', '平谷区', '平谷区', null);
INSERT INTO `sys_dict_item` VALUES ('413', '64', '延庆县', '延庆县', null);
INSERT INTO `sys_dict_item` VALUES ('414', '65', '黄浦区', '黄浦区', null);
INSERT INTO `sys_dict_item` VALUES ('415', '65', '徐汇区', '徐汇区', null);
INSERT INTO `sys_dict_item` VALUES ('416', '65', '长宁区', '长宁区', null);
INSERT INTO `sys_dict_item` VALUES ('417', '65', '静安区', '静安区', null);
INSERT INTO `sys_dict_item` VALUES ('418', '65', '闸北区', '闸北区', null);
INSERT INTO `sys_dict_item` VALUES ('419', '65', '虹口区', '虹口区', null);
INSERT INTO `sys_dict_item` VALUES ('420', '65', '杨浦区', '杨浦区', null);
INSERT INTO `sys_dict_item` VALUES ('421', '65', '宝山区', '宝山区', null);
INSERT INTO `sys_dict_item` VALUES ('422', '65', '闵行区', '闵行区', null);
INSERT INTO `sys_dict_item` VALUES ('423', '65', '嘉定区', '嘉定区', null);
INSERT INTO `sys_dict_item` VALUES ('424', '65', '浦东新区', '浦东新区', null);
INSERT INTO `sys_dict_item` VALUES ('425', '65', '青浦区', '青浦区', null);
INSERT INTO `sys_dict_item` VALUES ('426', '65', '松江区', '松江区', null);
INSERT INTO `sys_dict_item` VALUES ('427', '65', '金山区', '金山区', null);
INSERT INTO `sys_dict_item` VALUES ('428', '65', '奉贤区', '奉贤区', null);
INSERT INTO `sys_dict_item` VALUES ('429', '65', '普陀区', '普陀区', null);
INSERT INTO `sys_dict_item` VALUES ('430', '65', '崇明县', '崇明县', null);
INSERT INTO `sys_dict_item` VALUES ('431', '66', '东丽区', '东丽区', null);
INSERT INTO `sys_dict_item` VALUES ('432', '66', '和平区', '和平区', null);
INSERT INTO `sys_dict_item` VALUES ('433', '66', '河北区', '河北区', null);
INSERT INTO `sys_dict_item` VALUES ('434', '66', '河东区', '河东区', null);
INSERT INTO `sys_dict_item` VALUES ('435', '66', '河西区', '河西区', null);
INSERT INTO `sys_dict_item` VALUES ('436', '66', '红桥区', '红桥区', null);
INSERT INTO `sys_dict_item` VALUES ('437', '66', '蓟县', '蓟县', null);
INSERT INTO `sys_dict_item` VALUES ('438', '66', '静海县', '静海县', null);
INSERT INTO `sys_dict_item` VALUES ('439', '66', '南开区', '南开区', null);
INSERT INTO `sys_dict_item` VALUES ('440', '66', '塘沽区', '塘沽区', null);
INSERT INTO `sys_dict_item` VALUES ('441', '66', '西青区', '西青区', null);
INSERT INTO `sys_dict_item` VALUES ('442', '66', '武清区', '武清区', null);
INSERT INTO `sys_dict_item` VALUES ('443', '66', '津南区', '津南区', null);
INSERT INTO `sys_dict_item` VALUES ('444', '66', '汉沽区', '汉沽区', null);
INSERT INTO `sys_dict_item` VALUES ('445', '66', '大港区', '大港区', null);
INSERT INTO `sys_dict_item` VALUES ('446', '66', '北辰区', '北辰区', null);
INSERT INTO `sys_dict_item` VALUES ('447', '66', '宝坻区', '宝坻区', null);
INSERT INTO `sys_dict_item` VALUES ('448', '66', '宁河县', '宁河县', null);
INSERT INTO `sys_dict_item` VALUES ('449', '67', '万州区', '万州区', null);
INSERT INTO `sys_dict_item` VALUES ('450', '67', '涪陵区', '涪陵区', null);
INSERT INTO `sys_dict_item` VALUES ('451', '67', '梁平县', '梁平县', null);
INSERT INTO `sys_dict_item` VALUES ('452', '67', '南川区', '南川区', null);
INSERT INTO `sys_dict_item` VALUES ('453', '67', '潼南县', '潼南县', null);
INSERT INTO `sys_dict_item` VALUES ('454', '67', '大足区', '大足区', null);
INSERT INTO `sys_dict_item` VALUES ('455', '67', '黔江区', '黔江区', null);
INSERT INTO `sys_dict_item` VALUES ('456', '67', '武隆县', '武隆县', null);
INSERT INTO `sys_dict_item` VALUES ('457', '67', '丰都县', '丰都县', null);
INSERT INTO `sys_dict_item` VALUES ('458', '67', '奉节县', '奉节县', null);
INSERT INTO `sys_dict_item` VALUES ('459', '67', '开县', '开县', null);
INSERT INTO `sys_dict_item` VALUES ('460', '67', '云阳县', '云阳县', null);
INSERT INTO `sys_dict_item` VALUES ('461', '67', '忠县', '忠县', null);
INSERT INTO `sys_dict_item` VALUES ('462', '67', '巫溪县', '巫溪县', null);
INSERT INTO `sys_dict_item` VALUES ('463', '67', '巫山县', '巫山县', null);
INSERT INTO `sys_dict_item` VALUES ('464', '67', '石柱县', '石柱县', null);
INSERT INTO `sys_dict_item` VALUES ('465', '67', '彭水县', '彭水县', null);
INSERT INTO `sys_dict_item` VALUES ('466', '67', '垫江县', '垫江县', null);
INSERT INTO `sys_dict_item` VALUES ('467', '67', '酉阳县', '酉阳县', null);
INSERT INTO `sys_dict_item` VALUES ('468', '67', '秀山县', '秀山县', null);
INSERT INTO `sys_dict_item` VALUES ('469', '67', '城口县', '城口县', null);
INSERT INTO `sys_dict_item` VALUES ('470', '67', '璧山县', '璧山县', null);
INSERT INTO `sys_dict_item` VALUES ('471', '67', '荣昌县', '荣昌县', null);
INSERT INTO `sys_dict_item` VALUES ('472', '67', '铜梁县', '铜梁县', null);
INSERT INTO `sys_dict_item` VALUES ('473', '67', '合川区', '合川区', null);
INSERT INTO `sys_dict_item` VALUES ('474', '67', '巴南区', '巴南区', null);
INSERT INTO `sys_dict_item` VALUES ('475', '67', '北碚区', '北碚区', null);
INSERT INTO `sys_dict_item` VALUES ('476', '67', '江津区', '江津区', null);
INSERT INTO `sys_dict_item` VALUES ('477', '67', '渝北区', '渝北区', null);
INSERT INTO `sys_dict_item` VALUES ('478', '67', '长寿区', '长寿区', null);
INSERT INTO `sys_dict_item` VALUES ('479', '67', '永川区', '永川区', null);
INSERT INTO `sys_dict_item` VALUES ('480', '67', '江北区', '江北区', null);
INSERT INTO `sys_dict_item` VALUES ('481', '67', '南岸区', '南岸区', null);
INSERT INTO `sys_dict_item` VALUES ('482', '67', '九龙坡区', '九龙坡区', null);
INSERT INTO `sys_dict_item` VALUES ('483', '67', '沙坪坝区', '沙坪坝区', null);
INSERT INTO `sys_dict_item` VALUES ('484', '67', '大渡口区', '大渡口区', null);
INSERT INTO `sys_dict_item` VALUES ('485', '67', '綦江区', '綦江区', null);
INSERT INTO `sys_dict_item` VALUES ('486', '67', '渝中区', '渝中区', null);
INSERT INTO `sys_dict_item` VALUES ('487', '67', '高新区', '高新区', null);
INSERT INTO `sys_dict_item` VALUES ('488', '67', '北部新区', '北部新区', null);
INSERT INTO `sys_dict_item` VALUES ('489', '68', '石家庄市', '石家庄市', null);
INSERT INTO `sys_dict_item` VALUES ('490', '68', '邯郸市', '邯郸市', null);
INSERT INTO `sys_dict_item` VALUES ('491', '68', '邢台市', '邢台市', null);
INSERT INTO `sys_dict_item` VALUES ('492', '68', '保定市', '保定市', null);
INSERT INTO `sys_dict_item` VALUES ('493', '68', '张家口市', '张家口市', null);
INSERT INTO `sys_dict_item` VALUES ('494', '68', '承德市', '承德市', null);
INSERT INTO `sys_dict_item` VALUES ('495', '68', '秦皇岛市', '秦皇岛市', null);
INSERT INTO `sys_dict_item` VALUES ('496', '68', '唐山市', '唐山市', null);
INSERT INTO `sys_dict_item` VALUES ('497', '68', '沧州市', '沧州市', null);
INSERT INTO `sys_dict_item` VALUES ('498', '68', '廊坊市', '廊坊市', null);
INSERT INTO `sys_dict_item` VALUES ('499', '68', '衡水市', '衡水市', null);
INSERT INTO `sys_dict_item` VALUES ('500', '69', '太原市', '太原市', null);
INSERT INTO `sys_dict_item` VALUES ('501', '69', '大同市', '大同市', null);
INSERT INTO `sys_dict_item` VALUES ('502', '69', '阳泉市', '阳泉市', null);
INSERT INTO `sys_dict_item` VALUES ('503', '69', '晋城市', '晋城市', null);
INSERT INTO `sys_dict_item` VALUES ('504', '69', '朔州市', '朔州市', null);
INSERT INTO `sys_dict_item` VALUES ('505', '69', '晋中市', '晋中市', null);
INSERT INTO `sys_dict_item` VALUES ('506', '69', '忻州市', '忻州市', null);
INSERT INTO `sys_dict_item` VALUES ('507', '69', '吕梁市', '吕梁市', null);
INSERT INTO `sys_dict_item` VALUES ('508', '69', '临汾市', '临汾市', null);
INSERT INTO `sys_dict_item` VALUES ('509', '69', '运城市', '运城市', null);
INSERT INTO `sys_dict_item` VALUES ('510', '69', '长治市', '长治市', null);
INSERT INTO `sys_dict_item` VALUES ('511', '70', '郑州市', '郑州市', null);
INSERT INTO `sys_dict_item` VALUES ('512', '70', '开封市', '开封市', null);
INSERT INTO `sys_dict_item` VALUES ('513', '70', '洛阳市', '洛阳市', null);
INSERT INTO `sys_dict_item` VALUES ('514', '70', '平顶山市', '平顶山市', null);
INSERT INTO `sys_dict_item` VALUES ('515', '70', '焦作市', '焦作市', null);
INSERT INTO `sys_dict_item` VALUES ('516', '70', '鹤壁市', '鹤壁市', null);
INSERT INTO `sys_dict_item` VALUES ('517', '70', '新乡市', '新乡市', null);
INSERT INTO `sys_dict_item` VALUES ('518', '70', '安阳市', '安阳市', null);
INSERT INTO `sys_dict_item` VALUES ('519', '70', '濮阳市', '濮阳市', null);
INSERT INTO `sys_dict_item` VALUES ('520', '70', '许昌市', '许昌市', null);
INSERT INTO `sys_dict_item` VALUES ('521', '70', '漯河市', '漯河市', null);
INSERT INTO `sys_dict_item` VALUES ('522', '70', '三门峡市', '三门峡市', null);
INSERT INTO `sys_dict_item` VALUES ('523', '70', '南阳市', '南阳市', null);
INSERT INTO `sys_dict_item` VALUES ('524', '70', '商丘市', '商丘市', null);
INSERT INTO `sys_dict_item` VALUES ('525', '70', '周口市', '周口市', null);
INSERT INTO `sys_dict_item` VALUES ('526', '70', '驻马店市', '驻马店市', null);
INSERT INTO `sys_dict_item` VALUES ('527', '70', '信阳市', '信阳市', null);
INSERT INTO `sys_dict_item` VALUES ('528', '70', '济源市', '济源市', null);
INSERT INTO `sys_dict_item` VALUES ('529', '71', '沈阳市', '沈阳市', null);
INSERT INTO `sys_dict_item` VALUES ('530', '71', '大连市', '大连市', null);
INSERT INTO `sys_dict_item` VALUES ('531', '71', '鞍山市', '鞍山市', null);
INSERT INTO `sys_dict_item` VALUES ('532', '71', '抚顺市', '抚顺市', null);
INSERT INTO `sys_dict_item` VALUES ('533', '71', '本溪市', '本溪市', null);
INSERT INTO `sys_dict_item` VALUES ('534', '71', '丹东市', '丹东市', null);
INSERT INTO `sys_dict_item` VALUES ('535', '71', '锦州市', '锦州市', null);
INSERT INTO `sys_dict_item` VALUES ('536', '71', '葫芦岛市', '葫芦岛市', null);
INSERT INTO `sys_dict_item` VALUES ('537', '71', '营口市', '营口市', null);
INSERT INTO `sys_dict_item` VALUES ('538', '71', '盘锦市', '盘锦市', null);
INSERT INTO `sys_dict_item` VALUES ('539', '71', '阜新市', '阜新市', null);
INSERT INTO `sys_dict_item` VALUES ('540', '71', '辽阳市', '辽阳市', null);
INSERT INTO `sys_dict_item` VALUES ('541', '71', '朝阳市', '朝阳市', null);
INSERT INTO `sys_dict_item` VALUES ('542', '71', '铁岭市', '铁岭市', null);
INSERT INTO `sys_dict_item` VALUES ('543', '72', '长春市', '长春市', null);
INSERT INTO `sys_dict_item` VALUES ('544', '72', '吉林市', '吉林市', null);
INSERT INTO `sys_dict_item` VALUES ('545', '72', '四平市', '四平市', null);
INSERT INTO `sys_dict_item` VALUES ('546', '72', '通化市', '通化市', null);
INSERT INTO `sys_dict_item` VALUES ('547', '72', '白山市', '白山市', null);
INSERT INTO `sys_dict_item` VALUES ('548', '72', '松原市', '松原市', null);
INSERT INTO `sys_dict_item` VALUES ('549', '72', '白城市', '白城市', null);
INSERT INTO `sys_dict_item` VALUES ('550', '72', '延边州', '延边州', null);
INSERT INTO `sys_dict_item` VALUES ('551', '72', '辽源市', '辽源市', null);
INSERT INTO `sys_dict_item` VALUES ('552', '73', '哈尔滨市', '哈尔滨市', null);
INSERT INTO `sys_dict_item` VALUES ('553', '73', '齐齐哈尔市', '齐齐哈尔市', null);
INSERT INTO `sys_dict_item` VALUES ('554', '73', '鹤岗市', '鹤岗市', null);
INSERT INTO `sys_dict_item` VALUES ('555', '73', '双鸭山市', '双鸭山市', null);
INSERT INTO `sys_dict_item` VALUES ('556', '73', '鸡西市', '鸡西市', null);
INSERT INTO `sys_dict_item` VALUES ('557', '73', '大庆市', '大庆市', null);
INSERT INTO `sys_dict_item` VALUES ('558', '73', '伊春市', '伊春市', null);
INSERT INTO `sys_dict_item` VALUES ('559', '73', '牡丹江市', '牡丹江市', null);
INSERT INTO `sys_dict_item` VALUES ('560', '73', '佳木斯市', '佳木斯市', null);
INSERT INTO `sys_dict_item` VALUES ('561', '73', '七台河市', '七台河市', null);
INSERT INTO `sys_dict_item` VALUES ('562', '73', '黑河市', '黑河市', null);
INSERT INTO `sys_dict_item` VALUES ('563', '73', '绥化市', '绥化市', null);
INSERT INTO `sys_dict_item` VALUES ('564', '73', '大兴安岭地区', '大兴安岭地区', null);
INSERT INTO `sys_dict_item` VALUES ('565', '74', '呼和浩特市', '呼和浩特市', null);
INSERT INTO `sys_dict_item` VALUES ('566', '74', '包头市', '包头市', null);
INSERT INTO `sys_dict_item` VALUES ('567', '74', '乌海市', '乌海市', null);
INSERT INTO `sys_dict_item` VALUES ('568', '74', '赤峰市', '赤峰市', null);
INSERT INTO `sys_dict_item` VALUES ('569', '74', '乌兰察布市', '乌兰察布市', null);
INSERT INTO `sys_dict_item` VALUES ('570', '74', '锡林郭勒盟', '锡林郭勒盟', null);
INSERT INTO `sys_dict_item` VALUES ('571', '74', '呼伦贝尔市', '呼伦贝尔市', null);
INSERT INTO `sys_dict_item` VALUES ('572', '74', '鄂尔多斯市', '鄂尔多斯市', null);
INSERT INTO `sys_dict_item` VALUES ('573', '74', '巴彦淖尔市', '巴彦淖尔市', null);
INSERT INTO `sys_dict_item` VALUES ('574', '74', '阿拉善盟', '阿拉善盟', null);
INSERT INTO `sys_dict_item` VALUES ('575', '74', '兴安盟', '兴安盟', null);
INSERT INTO `sys_dict_item` VALUES ('576', '74', '通辽市', '通辽市', null);
INSERT INTO `sys_dict_item` VALUES ('577', '75', '南京市', '南京市', null);
INSERT INTO `sys_dict_item` VALUES ('578', '75', '徐州市', '徐州市', null);
INSERT INTO `sys_dict_item` VALUES ('579', '75', '连云港市', '连云港市', null);
INSERT INTO `sys_dict_item` VALUES ('580', '75', '淮安市', '淮安市', null);
INSERT INTO `sys_dict_item` VALUES ('581', '75', '宿迁市', '宿迁市', null);
INSERT INTO `sys_dict_item` VALUES ('582', '75', '盐城市', '盐城市', null);
INSERT INTO `sys_dict_item` VALUES ('583', '75', '扬州市', '扬州市', null);
INSERT INTO `sys_dict_item` VALUES ('584', '75', '泰州市', '泰州市', null);
INSERT INTO `sys_dict_item` VALUES ('585', '75', '南通市', '南通市', null);
INSERT INTO `sys_dict_item` VALUES ('586', '75', '镇江市', '镇江市', null);
INSERT INTO `sys_dict_item` VALUES ('587', '75', '常州市', '常州市', null);
INSERT INTO `sys_dict_item` VALUES ('588', '75', '无锡市', '无锡市', null);
INSERT INTO `sys_dict_item` VALUES ('589', '75', '苏州市', '苏州市', null);
INSERT INTO `sys_dict_item` VALUES ('590', '76', '济南市', '济南市', null);
INSERT INTO `sys_dict_item` VALUES ('591', '76', '青岛市', '青岛市', null);
INSERT INTO `sys_dict_item` VALUES ('592', '76', '淄博市', '淄博市', null);
INSERT INTO `sys_dict_item` VALUES ('593', '76', '枣庄市', '枣庄市', null);
INSERT INTO `sys_dict_item` VALUES ('594', '76', '东营市', '东营市', null);
INSERT INTO `sys_dict_item` VALUES ('595', '76', '潍坊市', '潍坊市', null);
INSERT INTO `sys_dict_item` VALUES ('596', '76', '烟台市', '烟台市', null);
INSERT INTO `sys_dict_item` VALUES ('597', '76', '威海市', '威海市', null);
INSERT INTO `sys_dict_item` VALUES ('598', '76', '莱芜市', '莱芜市', null);
INSERT INTO `sys_dict_item` VALUES ('599', '76', '德州市', '德州市', null);
INSERT INTO `sys_dict_item` VALUES ('600', '76', '临沂市', '临沂市', null);
INSERT INTO `sys_dict_item` VALUES ('601', '76', '聊城市', '聊城市', null);
INSERT INTO `sys_dict_item` VALUES ('602', '76', '滨州市', '滨州市', null);
INSERT INTO `sys_dict_item` VALUES ('603', '76', '菏泽市', '菏泽市', null);
INSERT INTO `sys_dict_item` VALUES ('604', '76', '日照市', '日照市', null);
INSERT INTO `sys_dict_item` VALUES ('605', '76', '泰安市', '泰安市', null);
INSERT INTO `sys_dict_item` VALUES ('606', '76', '济宁市', '济宁市', null);
INSERT INTO `sys_dict_item` VALUES ('607', '77', '铜陵市', '铜陵市', null);
INSERT INTO `sys_dict_item` VALUES ('608', '77', '合肥市', '合肥市', null);
INSERT INTO `sys_dict_item` VALUES ('609', '77', '淮南市', '淮南市', null);
INSERT INTO `sys_dict_item` VALUES ('610', '77', '淮北市', '淮北市', null);
INSERT INTO `sys_dict_item` VALUES ('611', '77', '芜湖市', '芜湖市', null);
INSERT INTO `sys_dict_item` VALUES ('612', '77', '蚌埠市', '蚌埠市', null);
INSERT INTO `sys_dict_item` VALUES ('613', '77', '马鞍山市', '马鞍山市', null);
INSERT INTO `sys_dict_item` VALUES ('614', '77', '安庆市', '安庆市', null);
INSERT INTO `sys_dict_item` VALUES ('615', '77', '黄山市', '黄山市', null);
INSERT INTO `sys_dict_item` VALUES ('616', '77', '滁州市', '滁州市', null);
INSERT INTO `sys_dict_item` VALUES ('617', '77', '阜阳市', '阜阳市', null);
INSERT INTO `sys_dict_item` VALUES ('618', '77', '亳州市', '亳州市', null);
INSERT INTO `sys_dict_item` VALUES ('619', '77', '宿州市', '宿州市', null);
INSERT INTO `sys_dict_item` VALUES ('620', '77', '池州市', '池州市', null);
INSERT INTO `sys_dict_item` VALUES ('621', '77', '六安市', '六安市', null);
INSERT INTO `sys_dict_item` VALUES ('622', '77', '宣城市', '宣城市', null);
INSERT INTO `sys_dict_item` VALUES ('623', '78', '宁波市', '宁波市', null);
INSERT INTO `sys_dict_item` VALUES ('624', '78', '杭州市', '杭州市', null);
INSERT INTO `sys_dict_item` VALUES ('625', '78', '温州市', '温州市', null);
INSERT INTO `sys_dict_item` VALUES ('626', '78', '嘉兴市', '嘉兴市', null);
INSERT INTO `sys_dict_item` VALUES ('627', '78', '湖州市', '湖州市', null);
INSERT INTO `sys_dict_item` VALUES ('628', '78', '绍兴市', '绍兴市', null);
INSERT INTO `sys_dict_item` VALUES ('629', '78', '金华市', '金华市', null);
INSERT INTO `sys_dict_item` VALUES ('630', '78', '衢州市', '衢州市', null);
INSERT INTO `sys_dict_item` VALUES ('631', '78', '丽水市', '丽水市', null);
INSERT INTO `sys_dict_item` VALUES ('632', '78', '台州市', '台州市', null);
INSERT INTO `sys_dict_item` VALUES ('633', '78', '舟山市', '舟山市', null);
INSERT INTO `sys_dict_item` VALUES ('634', '79', '福州市', '福州市', null);
INSERT INTO `sys_dict_item` VALUES ('635', '79', '厦门市', '厦门市', null);
INSERT INTO `sys_dict_item` VALUES ('636', '79', '三明市', '三明市', null);
INSERT INTO `sys_dict_item` VALUES ('637', '79', '莆田市', '莆田市', null);
INSERT INTO `sys_dict_item` VALUES ('638', '79', '泉州市', '泉州市', null);
INSERT INTO `sys_dict_item` VALUES ('639', '79', '漳州市', '漳州市', null);
INSERT INTO `sys_dict_item` VALUES ('640', '79', '南平市', '南平市', null);
INSERT INTO `sys_dict_item` VALUES ('641', '79', '龙岩市', '龙岩市', null);
INSERT INTO `sys_dict_item` VALUES ('642', '79', '宁德市', '宁德市', null);
INSERT INTO `sys_dict_item` VALUES ('643', '80', '武汉市', '武汉市', null);
INSERT INTO `sys_dict_item` VALUES ('644', '80', '黄石市', '黄石市', null);
INSERT INTO `sys_dict_item` VALUES ('645', '80', '襄阳市', '襄阳市', null);
INSERT INTO `sys_dict_item` VALUES ('646', '80', '十堰市', '十堰市', null);
INSERT INTO `sys_dict_item` VALUES ('647', '80', '荆州市', '荆州市', null);
INSERT INTO `sys_dict_item` VALUES ('648', '80', '宜昌市', '宜昌市', null);
INSERT INTO `sys_dict_item` VALUES ('649', '80', '孝感市', '孝感市', null);
INSERT INTO `sys_dict_item` VALUES ('650', '80', '黄冈市', '黄冈市', null);
INSERT INTO `sys_dict_item` VALUES ('651', '80', '咸宁市', '咸宁市', null);
INSERT INTO `sys_dict_item` VALUES ('652', '80', '恩施州', '恩施州', null);
INSERT INTO `sys_dict_item` VALUES ('653', '80', '鄂州市', '鄂州市', null);
INSERT INTO `sys_dict_item` VALUES ('654', '80', '荆门市', '荆门市', null);
INSERT INTO `sys_dict_item` VALUES ('655', '80', '随州市', '随州市', null);
INSERT INTO `sys_dict_item` VALUES ('656', '80', '潜江市', '潜江市', null);
INSERT INTO `sys_dict_item` VALUES ('657', '80', '天门市', '天门市', null);
INSERT INTO `sys_dict_item` VALUES ('658', '80', '仙桃市', '仙桃市', null);
INSERT INTO `sys_dict_item` VALUES ('659', '80', '神农架林区', '神农架林区', null);
INSERT INTO `sys_dict_item` VALUES ('660', '81', '长沙市', '长沙市', null);
INSERT INTO `sys_dict_item` VALUES ('661', '81', '株洲市', '株洲市', null);
INSERT INTO `sys_dict_item` VALUES ('662', '81', '湘潭市', '湘潭市', null);
INSERT INTO `sys_dict_item` VALUES ('663', '81', '韶山市', '韶山市', null);
INSERT INTO `sys_dict_item` VALUES ('664', '81', '衡阳市', '衡阳市', null);
INSERT INTO `sys_dict_item` VALUES ('665', '81', '邵阳市', '邵阳市', null);
INSERT INTO `sys_dict_item` VALUES ('666', '81', '岳阳市', '岳阳市', null);
INSERT INTO `sys_dict_item` VALUES ('667', '81', '常德市', '常德市', null);
INSERT INTO `sys_dict_item` VALUES ('668', '81', '张家界市', '张家界市', null);
INSERT INTO `sys_dict_item` VALUES ('669', '81', '郴州市', '郴州市', null);
INSERT INTO `sys_dict_item` VALUES ('670', '81', '益阳市', '益阳市', null);
INSERT INTO `sys_dict_item` VALUES ('671', '81', '永州市', '永州市', null);
INSERT INTO `sys_dict_item` VALUES ('672', '81', '怀化市', '怀化市', null);
INSERT INTO `sys_dict_item` VALUES ('673', '81', '娄底市', '娄底市', null);
INSERT INTO `sys_dict_item` VALUES ('674', '81', '湘西州', '湘西州', null);
INSERT INTO `sys_dict_item` VALUES ('675', '82', '广州市', '广州市', null);
INSERT INTO `sys_dict_item` VALUES ('676', '82', '深圳市', '深圳市', null);
INSERT INTO `sys_dict_item` VALUES ('677', '82', '珠海市', '珠海市', null);
INSERT INTO `sys_dict_item` VALUES ('678', '82', '汕头市', '汕头市', null);
INSERT INTO `sys_dict_item` VALUES ('679', '82', '韶关市', '韶关市', null);
INSERT INTO `sys_dict_item` VALUES ('680', '82', '河源市', '河源市', null);
INSERT INTO `sys_dict_item` VALUES ('681', '82', '梅州市', '梅州市', null);
INSERT INTO `sys_dict_item` VALUES ('682', '82', '惠州市', '惠州市', null);
INSERT INTO `sys_dict_item` VALUES ('683', '82', '汕尾市', '汕尾市', null);
INSERT INTO `sys_dict_item` VALUES ('684', '82', '东莞市', '东莞市', null);
INSERT INTO `sys_dict_item` VALUES ('685', '82', '中山市', '中山市', null);
INSERT INTO `sys_dict_item` VALUES ('686', '82', '江门市', '江门市', null);
INSERT INTO `sys_dict_item` VALUES ('687', '82', '佛山市', '佛山市', null);
INSERT INTO `sys_dict_item` VALUES ('688', '82', '阳江市', '阳江市', null);
INSERT INTO `sys_dict_item` VALUES ('689', '82', '湛江市', '湛江市', null);
INSERT INTO `sys_dict_item` VALUES ('690', '82', '茂名市', '茂名市', null);
INSERT INTO `sys_dict_item` VALUES ('691', '82', '肇庆市', '肇庆市', null);
INSERT INTO `sys_dict_item` VALUES ('692', '82', '云浮市', '云浮市', null);
INSERT INTO `sys_dict_item` VALUES ('693', '82', '清远市', '清远市', null);
INSERT INTO `sys_dict_item` VALUES ('694', '82', '潮州市', '潮州市', null);
INSERT INTO `sys_dict_item` VALUES ('695', '82', '揭阳市', '揭阳市', null);
INSERT INTO `sys_dict_item` VALUES ('696', '83', '南宁市', '南宁市', null);
INSERT INTO `sys_dict_item` VALUES ('697', '83', '柳州市', '柳州市', null);
INSERT INTO `sys_dict_item` VALUES ('698', '83', '桂林市', '桂林市', null);
INSERT INTO `sys_dict_item` VALUES ('699', '83', '梧州市', '梧州市', null);
INSERT INTO `sys_dict_item` VALUES ('700', '83', '北海市', '北海市', null);
INSERT INTO `sys_dict_item` VALUES ('701', '83', '防城港市', '防城港市', null);
INSERT INTO `sys_dict_item` VALUES ('702', '83', '钦州市', '钦州市', null);
INSERT INTO `sys_dict_item` VALUES ('703', '83', '贵港市', '贵港市', null);
INSERT INTO `sys_dict_item` VALUES ('704', '83', '玉林市', '玉林市', null);
INSERT INTO `sys_dict_item` VALUES ('705', '83', '贺州市', '贺州市', null);
INSERT INTO `sys_dict_item` VALUES ('706', '83', '百色市', '百色市', null);
INSERT INTO `sys_dict_item` VALUES ('707', '83', '河池市', '河池市', null);
INSERT INTO `sys_dict_item` VALUES ('708', '83', '来宾市', '来宾市', null);
INSERT INTO `sys_dict_item` VALUES ('709', '83', '崇左市', '崇左市', null);
INSERT INTO `sys_dict_item` VALUES ('710', '84', '南昌市', '南昌市', null);
INSERT INTO `sys_dict_item` VALUES ('711', '84', '景德镇市', '景德镇市', null);
INSERT INTO `sys_dict_item` VALUES ('712', '84', '萍乡市', '萍乡市', null);
INSERT INTO `sys_dict_item` VALUES ('713', '84', '新余市', '新余市', null);
INSERT INTO `sys_dict_item` VALUES ('714', '84', '九江市', '九江市', null);
INSERT INTO `sys_dict_item` VALUES ('715', '84', '鹰潭市', '鹰潭市', null);
INSERT INTO `sys_dict_item` VALUES ('716', '84', '上饶市', '上饶市', null);
INSERT INTO `sys_dict_item` VALUES ('717', '84', '宜春市', '宜春市', null);
INSERT INTO `sys_dict_item` VALUES ('718', '84', '抚州市', '抚州市', null);
INSERT INTO `sys_dict_item` VALUES ('719', '84', '吉安市', '吉安市', null);
INSERT INTO `sys_dict_item` VALUES ('720', '84', '赣州市', '赣州市', null);
INSERT INTO `sys_dict_item` VALUES ('721', '85', '成都市', '成都市', null);
INSERT INTO `sys_dict_item` VALUES ('722', '85', '自贡市', '自贡市', null);
INSERT INTO `sys_dict_item` VALUES ('723', '85', '攀枝花市', '攀枝花市', null);
INSERT INTO `sys_dict_item` VALUES ('724', '85', '泸州市', '泸州市', null);
INSERT INTO `sys_dict_item` VALUES ('725', '85', '绵阳市', '绵阳市', null);
INSERT INTO `sys_dict_item` VALUES ('726', '85', '德阳市', '德阳市', null);
INSERT INTO `sys_dict_item` VALUES ('727', '85', '广元市', '广元市', null);
INSERT INTO `sys_dict_item` VALUES ('728', '85', '遂宁市', '遂宁市', null);
INSERT INTO `sys_dict_item` VALUES ('729', '85', '内江市', '内江市', null);
INSERT INTO `sys_dict_item` VALUES ('730', '85', '乐山市', '乐山市', null);
INSERT INTO `sys_dict_item` VALUES ('731', '85', '宜宾市', '宜宾市', null);
INSERT INTO `sys_dict_item` VALUES ('732', '85', '广安市', '广安市', null);
INSERT INTO `sys_dict_item` VALUES ('733', '85', '南充市', '南充市', null);
INSERT INTO `sys_dict_item` VALUES ('734', '85', '达州市', '达州市', null);
INSERT INTO `sys_dict_item` VALUES ('735', '85', '巴中市', '巴中市', null);
INSERT INTO `sys_dict_item` VALUES ('736', '85', '雅安市', '雅安市', null);
INSERT INTO `sys_dict_item` VALUES ('737', '85', '眉山市', '眉山市', null);
INSERT INTO `sys_dict_item` VALUES ('738', '85', '资阳市', '资阳市', null);
INSERT INTO `sys_dict_item` VALUES ('739', '85', '阿坝州', '阿坝州', null);
INSERT INTO `sys_dict_item` VALUES ('740', '85', '甘孜州', '甘孜州', null);
INSERT INTO `sys_dict_item` VALUES ('741', '85', '凉山州', '凉山州', null);
INSERT INTO `sys_dict_item` VALUES ('742', '86', '海口市', '海口市', null);
INSERT INTO `sys_dict_item` VALUES ('743', '86', '儋州市', '儋州市', null);
INSERT INTO `sys_dict_item` VALUES ('744', '86', '琼海市', '琼海市', null);
INSERT INTO `sys_dict_item` VALUES ('745', '86', '万宁市', '万宁市', null);
INSERT INTO `sys_dict_item` VALUES ('746', '86', '东方市', '东方市', null);
INSERT INTO `sys_dict_item` VALUES ('747', '86', '三亚市', '三亚市', null);
INSERT INTO `sys_dict_item` VALUES ('748', '86', '文昌市', '文昌市', null);
INSERT INTO `sys_dict_item` VALUES ('749', '86', '五指山市', '五指山市', null);
INSERT INTO `sys_dict_item` VALUES ('750', '86', '临高县', '临高县', null);
INSERT INTO `sys_dict_item` VALUES ('751', '86', '澄迈县', '澄迈县', null);
INSERT INTO `sys_dict_item` VALUES ('752', '86', '定安县', '定安县', null);
INSERT INTO `sys_dict_item` VALUES ('753', '86', '屯昌县', '屯昌县', null);
INSERT INTO `sys_dict_item` VALUES ('754', '86', '昌江县', '昌江县', null);
INSERT INTO `sys_dict_item` VALUES ('755', '86', '白沙县', '白沙县', null);
INSERT INTO `sys_dict_item` VALUES ('756', '86', '琼中县', '琼中县', null);
INSERT INTO `sys_dict_item` VALUES ('757', '86', '陵水县', '陵水县', null);
INSERT INTO `sys_dict_item` VALUES ('758', '86', '保亭县', '保亭县', null);
INSERT INTO `sys_dict_item` VALUES ('759', '86', '乐东县', '乐东县', null);
INSERT INTO `sys_dict_item` VALUES ('760', '86', '三沙市', '三沙市', null);
INSERT INTO `sys_dict_item` VALUES ('761', '87', '贵阳市', '贵阳市', null);
INSERT INTO `sys_dict_item` VALUES ('762', '87', '六盘水市', '六盘水市', null);
INSERT INTO `sys_dict_item` VALUES ('763', '87', '遵义市', '遵义市', null);
INSERT INTO `sys_dict_item` VALUES ('764', '87', '铜仁市', '铜仁市', null);
INSERT INTO `sys_dict_item` VALUES ('765', '87', '毕节市', '毕节市', null);
INSERT INTO `sys_dict_item` VALUES ('766', '87', '安顺市', '安顺市', null);
INSERT INTO `sys_dict_item` VALUES ('767', '87', '黔西南州', '黔西南州', null);
INSERT INTO `sys_dict_item` VALUES ('768', '87', '黔东南州', '黔东南州', null);
INSERT INTO `sys_dict_item` VALUES ('769', '87', '黔南州', '黔南州', null);
INSERT INTO `sys_dict_item` VALUES ('770', '88', '昆明市', '昆明市', null);
INSERT INTO `sys_dict_item` VALUES ('771', '88', '曲靖市', '曲靖市', null);
INSERT INTO `sys_dict_item` VALUES ('772', '88', '玉溪市', '玉溪市', null);
INSERT INTO `sys_dict_item` VALUES ('773', '88', '昭通市', '昭通市', null);
INSERT INTO `sys_dict_item` VALUES ('774', '88', '普洱市', '普洱市', null);
INSERT INTO `sys_dict_item` VALUES ('775', '88', '临沧市', '临沧市', null);
INSERT INTO `sys_dict_item` VALUES ('776', '88', '保山市', '保山市', null);
INSERT INTO `sys_dict_item` VALUES ('777', '88', '丽江市', '丽江市', null);
INSERT INTO `sys_dict_item` VALUES ('778', '88', '文山州', '文山州', null);
INSERT INTO `sys_dict_item` VALUES ('779', '88', '红河州', '红河州', null);
INSERT INTO `sys_dict_item` VALUES ('780', '88', '西双版纳州', '西双版纳州', null);
INSERT INTO `sys_dict_item` VALUES ('781', '88', '楚雄州', '楚雄州', null);
INSERT INTO `sys_dict_item` VALUES ('782', '88', '大理州', '大理州', null);
INSERT INTO `sys_dict_item` VALUES ('783', '88', '德宏州', '德宏州', null);
INSERT INTO `sys_dict_item` VALUES ('784', '88', '怒江州', '怒江州', null);
INSERT INTO `sys_dict_item` VALUES ('785', '88', '迪庆州', '迪庆州', null);
INSERT INTO `sys_dict_item` VALUES ('786', '89', '拉萨市', '拉萨市', null);
INSERT INTO `sys_dict_item` VALUES ('787', '89', '那曲地区', '那曲地区', null);
INSERT INTO `sys_dict_item` VALUES ('788', '89', '山南地区', '山南地区', null);
INSERT INTO `sys_dict_item` VALUES ('789', '89', '昌都地区', '昌都地区', null);
INSERT INTO `sys_dict_item` VALUES ('790', '89', '日喀则地区', '日喀则地区', null);
INSERT INTO `sys_dict_item` VALUES ('791', '89', '阿里地区', '阿里地区', null);
INSERT INTO `sys_dict_item` VALUES ('792', '89', '林芝地区', '林芝地区', null);
INSERT INTO `sys_dict_item` VALUES ('793', '90', '西安市', '西安市', null);
INSERT INTO `sys_dict_item` VALUES ('794', '90', '铜川市', '铜川市', null);
INSERT INTO `sys_dict_item` VALUES ('795', '90', '宝鸡市', '宝鸡市', null);
INSERT INTO `sys_dict_item` VALUES ('796', '90', '咸阳市', '咸阳市', null);
INSERT INTO `sys_dict_item` VALUES ('797', '90', '渭南市', '渭南市', null);
INSERT INTO `sys_dict_item` VALUES ('798', '90', '延安市', '延安市', null);
INSERT INTO `sys_dict_item` VALUES ('799', '90', '汉中市', '汉中市', null);
INSERT INTO `sys_dict_item` VALUES ('800', '90', '榆林市', '榆林市', null);
INSERT INTO `sys_dict_item` VALUES ('801', '90', '商洛市', '商洛市', null);
INSERT INTO `sys_dict_item` VALUES ('802', '90', '安康市', '安康市', null);
INSERT INTO `sys_dict_item` VALUES ('803', '91', '兰州市', '兰州市', null);
INSERT INTO `sys_dict_item` VALUES ('804', '91', '金昌市', '金昌市', null);
INSERT INTO `sys_dict_item` VALUES ('805', '91', '白银市', '白银市', null);
INSERT INTO `sys_dict_item` VALUES ('806', '91', '天水市', '天水市', null);
INSERT INTO `sys_dict_item` VALUES ('807', '91', '嘉峪关市', '嘉峪关市', null);
INSERT INTO `sys_dict_item` VALUES ('808', '91', '平凉市', '平凉市', null);
INSERT INTO `sys_dict_item` VALUES ('809', '91', '庆阳市', '庆阳市', null);
INSERT INTO `sys_dict_item` VALUES ('810', '91', '陇南市', '陇南市', null);
INSERT INTO `sys_dict_item` VALUES ('811', '91', '武威市', '武威市', null);
INSERT INTO `sys_dict_item` VALUES ('812', '91', '张掖市', '张掖市', null);
INSERT INTO `sys_dict_item` VALUES ('813', '91', '酒泉市', '酒泉市', null);
INSERT INTO `sys_dict_item` VALUES ('814', '91', '甘南州', '甘南州', null);
INSERT INTO `sys_dict_item` VALUES ('815', '91', '临夏州', '临夏州', null);
INSERT INTO `sys_dict_item` VALUES ('816', '91', '定西市', '定西市', null);
INSERT INTO `sys_dict_item` VALUES ('817', '92', '西宁市', '西宁市', null);
INSERT INTO `sys_dict_item` VALUES ('818', '92', '海东地区', '海东地区', null);
INSERT INTO `sys_dict_item` VALUES ('819', '92', '海北州', '海北州', null);
INSERT INTO `sys_dict_item` VALUES ('820', '92', '黄南州', '黄南州', null);
INSERT INTO `sys_dict_item` VALUES ('821', '92', '海南州', '海南州', null);
INSERT INTO `sys_dict_item` VALUES ('822', '92', '果洛州', '果洛州', null);
INSERT INTO `sys_dict_item` VALUES ('823', '92', '玉树州', '玉树州', null);
INSERT INTO `sys_dict_item` VALUES ('824', '92', '海西州', '海西州', null);
INSERT INTO `sys_dict_item` VALUES ('825', '93', '银川市', '银川市', null);
INSERT INTO `sys_dict_item` VALUES ('826', '93', '石嘴山市', '石嘴山市', null);
INSERT INTO `sys_dict_item` VALUES ('827', '93', '吴忠市', '吴忠市', null);
INSERT INTO `sys_dict_item` VALUES ('828', '93', '固原市', '固原市', null);
INSERT INTO `sys_dict_item` VALUES ('829', '93', '中卫市', '中卫市', null);
INSERT INTO `sys_dict_item` VALUES ('830', '94', '乌鲁木齐市', '乌鲁木齐市', null);
INSERT INTO `sys_dict_item` VALUES ('831', '94', '克拉玛依市', '克拉玛依市', null);
INSERT INTO `sys_dict_item` VALUES ('832', '94', '石河子市', '石河子市', null);
INSERT INTO `sys_dict_item` VALUES ('833', '94', '吐鲁番地区', '吐鲁番地区', null);
INSERT INTO `sys_dict_item` VALUES ('834', '94', '哈密地区', '哈密地区', null);
INSERT INTO `sys_dict_item` VALUES ('835', '94', '和田地区', '和田地区', null);
INSERT INTO `sys_dict_item` VALUES ('836', '94', '阿克苏地区', '阿克苏地区', null);
INSERT INTO `sys_dict_item` VALUES ('837', '94', '喀什地区', '喀什地区', null);
INSERT INTO `sys_dict_item` VALUES ('838', '94', '克孜勒苏州', '克孜勒苏州', null);
INSERT INTO `sys_dict_item` VALUES ('839', '94', '巴音郭楞州', '巴音郭楞州', null);
INSERT INTO `sys_dict_item` VALUES ('840', '94', '昌吉州', '昌吉州', null);
INSERT INTO `sys_dict_item` VALUES ('841', '94', '博尔塔拉州', '博尔塔拉州', null);
INSERT INTO `sys_dict_item` VALUES ('842', '94', '伊犁州', '伊犁州', null);
INSERT INTO `sys_dict_item` VALUES ('843', '94', '塔城地区', '塔城地区', null);
INSERT INTO `sys_dict_item` VALUES ('844', '94', '阿勒泰地区', '阿勒泰地区', null);
INSERT INTO `sys_dict_item` VALUES ('845', '94', '五家渠市', '五家渠市', null);
INSERT INTO `sys_dict_item` VALUES ('846', '94', '博尔塔拉蒙古自治州阿拉山口口岸', '博尔塔拉蒙古自治州阿拉山口口岸', null);
INSERT INTO `sys_dict_item` VALUES ('847', '94', '阿拉尔市', '阿拉尔市', null);
INSERT INTO `sys_dict_item` VALUES ('848', '94', '图木舒克市', '图木舒克市', null);
INSERT INTO `sys_dict_item` VALUES ('849', '95', '台湾', '台湾', null);
INSERT INTO `sys_dict_item` VALUES ('850', '96', '香港特别行政区', '香港特别行政区', null);
INSERT INTO `sys_dict_item` VALUES ('851', '97', '澳门特别行政区', '澳门特别行政区', null);
INSERT INTO `sys_dict_item` VALUES ('856', '75', '靖江市', '靖江市', null);
INSERT INTO `sys_dict_item` VALUES ('857', '65', '上海市', '上海市', null);
INSERT INTO `sys_dict_item` VALUES ('858', '66', '天津市', '天津市', null);
INSERT INTO `sys_dict_item` VALUES ('859', '67', '重庆市', '重庆市', null);
INSERT INTO `sys_dict_item` VALUES ('860', '64', '北京市', '北京市', null);
INSERT INTO `sys_dict_item` VALUES ('861', '87', '仁怀市', '仁怀市', null);
INSERT INTO `sys_dict_item` VALUES ('862', '75', '东台市', '东台市', null);
INSERT INTO `sys_dict_item` VALUES ('863', '75', '新沂市', '新沂市', null);
INSERT INTO `sys_dict_item` VALUES ('864', '92', '共和县', '共和县', null);
INSERT INTO `sys_dict_item` VALUES ('865', '76', '高密市', '高密市', null);
INSERT INTO `sys_dict_item` VALUES ('866', '204', '全部数据可见', '2000', null);
INSERT INTO `sys_dict_item` VALUES ('867', '204', '审核', '3000', '0');
INSERT INTO `sys_dict_item` VALUES ('883', '57', '租赁债权', '租赁债权', null);
INSERT INTO `sys_dict_item` VALUES ('884', '57', '信贷资产及类信贷资产', '信贷资产及类信贷资产', null);
INSERT INTO `sys_dict_item` VALUES ('885', '57', '信托受益权', '信托受益权', null);
INSERT INTO `sys_dict_item` VALUES ('886', '57', '应收账款', '应收账款', null);
INSERT INTO `sys_dict_item` VALUES ('887', '57', '收益权', '收益权', null);
INSERT INTO `sys_dict_item` VALUES ('888', '57', '基础设施收费权', '基础设施收费权', null);
INSERT INTO `sys_dict_item` VALUES ('889', '57', '不动产收益权', '不动产收益权', null);
INSERT INTO `sys_dict_item` VALUES ('890', '57', '其他财产或财产权利', '其他财产或财产权利', null);
INSERT INTO `sys_dict_item` VALUES ('891', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('892', '1', '绿色债', '绿色债', null);
INSERT INTO `sys_dict_item` VALUES ('893', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('894', '1', '双创债', '双创债', null);
INSERT INTO `sys_dict_item` VALUES ('895', null, null, null, null);
INSERT INTO `sys_dict_item` VALUES ('896', '1', '熊猫债', '熊猫债', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operate_module` varchar(255) DEFAULT NULL COMMENT '操作模块名称',
  `operate_item` text COMMENT '操作条目',
  `operate_behavior` text COMMENT '操作行为',
  `operate_detail` text COMMENT '操作详情',
  `operate_person` varchar(255) DEFAULT NULL COMMENT '操作人员',
  `operate_person_id` int(255) DEFAULT NULL COMMENT '操作人员id',
  `operate_time` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `id_indexing` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2395 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('2203', '债券基本信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-20 14:09:41', '2019-08-20 14:09:41');
INSERT INTO `sys_log` VALUES ('2204', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 14:10:50', '2019-08-20 14:10:50');
INSERT INTO `sys_log` VALUES ('2205', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 14:13:14', '2019-08-20 14:13:14');
INSERT INTO `sys_log` VALUES ('2206', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-20 14:38:39', '2019-08-20 14:38:39');
INSERT INTO `sys_log` VALUES ('2207', '债券基本信息', '新增了1', '新增操作', '新增了：债券简称[1]', 'admin', '1', '2019-08-20 14:41:20', '2019-08-20 14:41:20');
INSERT INTO `sys_log` VALUES ('2208', '债券基本信息', '新增了1', '新增操作', '新增了：债券简称[1]', 'admin', '1', '2019-08-20 14:42:00', '2019-08-20 14:42:00');
INSERT INTO `sys_log` VALUES ('2209', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 15:29:59', '2019-08-20 15:29:59');
INSERT INTO `sys_log` VALUES ('2210', '债券基本信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-20 15:49:02', '2019-08-20 15:49:02');
INSERT INTO `sys_log` VALUES ('2211', '债券基本信息', '新增了qq', '新增操作', '新增了：债券简称[qq]', 'admin', '1', '2019-08-20 15:52:08', '2019-08-20 15:52:08');
INSERT INTO `sys_log` VALUES ('2212', '债券基本信息', '修改了qq', '修改操作', '<span  style=\"color:blue;\">债券简称[qq]被修改：</span><br/>{债券类型：修改前[]-->修改后[普通公司债]}；<br/>', 'admin', '1', '2019-08-20 15:56:22', '2019-08-20 15:56:22');
INSERT INTO `sys_log` VALUES ('2213', '债券基本信息', '修改了', '修改操作', '<span  style=\"color:blue;\">债券简称[]被修改：</span><br/>{债券类型：修改前[]-->修改后[普通公司债]}；<br/>', 'admin', '1', '2019-08-20 15:56:33', '2019-08-20 15:56:33');
INSERT INTO `sys_log` VALUES ('2214', '债券基本信息', '修改了zyc', '修改操作', '<span  style=\"color:blue;\">债券简称[zyc]被修改：</span><br/>{债券类型：修改前[]-->修改后[普通公司债]}；<br/>', 'admin', '1', '2019-08-20 16:15:32', '2019-08-20 16:15:32');
INSERT INTO `sys_log` VALUES ('2215', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 16:37:06', '2019-08-20 16:37:06');
INSERT INTO `sys_log` VALUES ('2216', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 16:41:08', '2019-08-20 16:41:08');
INSERT INTO `sys_log` VALUES ('2217', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-20 16:41:37', '2019-08-20 16:41:37');
INSERT INTO `sys_log` VALUES ('2218', '债券基本信息', '修改了zyc', '修改操作', '<span  style=\"color:blue;\">债券简称[zyc]被修改：</span><br/>{股票代码(如有)：修改前[S]-->修改后[888]}；<br/>', 'admin', '1', '2019-08-20 17:07:49', '2019-08-20 17:07:49');
INSERT INTO `sys_log` VALUES ('2219', '债券基本信息', '修改了fsd', '修改操作', '<span  style=\"color:blue;\">债券简称[fsd]被修改：</span><br/>{债券简称：修改前[]-->修改后[fsd]}；<br/>{债券类型：修改前[]-->修改后[用于并购重组用途的债券]}；<br/>{股票代码(如有)：修改前[]-->修改后[fa]}；<br/>', 'admin', '1', '2019-08-20 17:08:12', '2019-08-20 17:08:12');
INSERT INTO `sys_log` VALUES ('2220', '债券基本信息', '删除了undefined,', '删除操作', '删除了：债券简称[undefined,]', 'admin', '1', '2019-08-20 17:08:32', '2019-08-20 17:08:32');
INSERT INTO `sys_log` VALUES ('2221', '债券基本信息', '删除了undefined,1,', '删除操作', '删除了：债券简称[undefined,1,]', 'admin', '1', '2019-08-20 17:08:49', '2019-08-20 17:08:49');
INSERT INTO `sys_log` VALUES ('2222', '在审项目信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-20 19:11:32', '2019-08-20 19:11:32');
INSERT INTO `sys_log` VALUES ('2223', '在审项目信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-20 19:17:46', '2019-08-20 19:17:46');
INSERT INTO `sys_log` VALUES ('2224', '在审项目信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-20 19:18:35', '2019-08-20 19:18:35');
INSERT INTO `sys_log` VALUES ('2225', '在审项目信息', '新增了1', '新增操作', '新增了：债券简称[1]', 'admin', '1', '2019-08-20 19:19:56', '2019-08-20 19:19:56');
INSERT INTO `sys_log` VALUES ('2226', '债券风险或违约原因', '新增了1', '新增操作', '新增了：风险或违约原因[1]', 'admin', '1', '2019-08-21 16:00:43', '2019-08-21 16:00:43');
INSERT INTO `sys_log` VALUES ('2227', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-21 16:41:17', '2019-08-21 16:41:17');
INSERT INTO `sys_log` VALUES ('2228', '债券风险或违约原因', '新增了11', '新增操作', '新增了：风险或违约原因[11]', 'admin', '1', '2019-08-21 19:43:24', '2019-08-21 19:43:24');
INSERT INTO `sys_log` VALUES ('2229', '风险监测信息', '新增了zyc1', '新增操作', '新增了：债券简称[zyc1]', 'admin', '1', '2019-08-21 19:43:29', '2019-08-21 19:43:29');
INSERT INTO `sys_log` VALUES ('2230', '债券监管信息', '上传了文件', '上传文件', '上传文件名称附件2：个人所得税专项附加扣除政策指引一览表.pdf', 'admin', '1', '2019-08-21 19:44:38', '2019-08-21 19:44:38');
INSERT INTO `sys_log` VALUES ('2231', '债券监管信息', '在33下上传了文件', '上传文件', '上传文件名称：附件2：个人所得税专项附加扣除政策指引一览表20190821194437.pdf', 'admin', '1', '2019-08-21 19:44:55', '2019-08-21 19:44:55');
INSERT INTO `sys_log` VALUES ('2232', '债券监管信息', '新增了33', '新增操作', '新增了：债券简称[33]', 'admin', '1', '2019-08-21 19:44:55', '2019-08-21 19:44:55');
INSERT INTO `sys_log` VALUES ('2233', '债券监管信息', '上传了文件', '上传文件', '上传文件名称附件1：个人所得税预扣率表及计算举例.pptx', 'admin', '1', '2019-08-22 17:16:47', '2019-08-22 17:16:47');
INSERT INTO `sys_log` VALUES ('2234', '债券监管信息', '在zyc1下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190822171646.pptx', 'admin', '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50');
INSERT INTO `sys_log` VALUES ('2235', '债券监管信息', '新增了zyc1', '新增操作', '新增了：债券简称[zyc1]', 'admin', '1', '2019-08-22 17:16:50', '2019-08-22 17:16:50');
INSERT INTO `sys_log` VALUES ('2236', '风险监测信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-22 17:18:32', '2019-08-22 17:18:32');
INSERT INTO `sys_log` VALUES ('2237', '风险监测信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-22 17:18:54', '2019-08-22 17:18:54');
INSERT INTO `sys_log` VALUES ('2238', 'ABS基本信息', '新增了1', '新增操作', '新增了：资产支持证券名称[1]', 'admin', '1', '2019-08-26 13:37:29', '2019-08-26 13:37:29');
INSERT INTO `sys_log` VALUES ('2239', '债券监管信息', '上传了文件', '上传文件', '上传文件名称附件1：个人所得税预扣率表及计算举例.pptx', 'admin', '1', '2019-08-26 13:42:34', '2019-08-26 13:42:34');
INSERT INTO `sys_log` VALUES ('2240', '债券监管信息', '在1下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190826134234.pptx', 'admin', '1', '2019-08-26 13:42:36', '2019-08-26 13:42:36');
INSERT INTO `sys_log` VALUES ('2241', '债券监管信息', '在33下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190826134234.pptx', 'admin', '1', '2019-08-26 13:42:41', '2019-08-26 13:42:41');
INSERT INTO `sys_log` VALUES ('2242', '债券监管信息', '新增了33', '新增操作', '新增了：债券简称[33]', 'admin', '1', '2019-08-26 13:42:41', '2019-08-26 13:42:41');
INSERT INTO `sys_log` VALUES ('2243', '债券监管信息', '上传了文件', '上传文件', '上传文件名称附件1：个人所得税预扣率表及计算举例.pptx', 'admin', '1', '2019-08-26 13:43:27', '2019-08-26 13:43:27');
INSERT INTO `sys_log` VALUES ('2244', '债券监管信息', '在zyc下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190826134327.pptx', 'admin', '1', '2019-08-26 13:43:31', '2019-08-26 13:43:31');
INSERT INTO `sys_log` VALUES ('2245', '债券监管信息', '新增了zyc', '新增操作', '新增了：债券简称[zyc]', 'admin', '1', '2019-08-26 13:43:31', '2019-08-26 13:43:31');
INSERT INTO `sys_log` VALUES ('2246', '债券基本信息', '新增了债券简称', '新增操作', '新增了：债券简称[债券简称]', 'admin', '1', '2019-08-26 13:44:04', '2019-08-26 13:44:04');
INSERT INTO `sys_log` VALUES ('2247', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-26 13:44:33', '2019-08-26 13:44:33');
INSERT INTO `sys_log` VALUES ('2248', '债券基本信息', '新增了1234567890', '新增操作', '新增了：债券简称[1234567890]', 'admin', '1', '2019-08-26 13:48:56', '2019-08-26 13:48:56');
INSERT INTO `sys_log` VALUES ('2249', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{交易场所：修改前[]-->修改后[报价系统]}；<br/>{股票代码(如有)：修改前[]-->修改后[1234567890]}；<br/>{增信措施：修改前[1234567890]-->修改后[1234567890增信措施增信措施增信措施增信措施增信措施]}；<br/>{核准发行规模（亿）：修改前[]-->修改后[400]}；<br/>{实际发行规模（亿）：修改前[]-->修改后[200]}；<br/>{托管规模（亿）：修改前[]-->修改后[200]}；<br/>{期限（年）：修改前[]-->修改后[期限备注]}；<br/>{期限备注：修改前[]-->修改后[期限备注]}；<br/>{发行利率：修改前[]-->修改后[0.45]}；<br/>{发行日期：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{挂牌日期：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{起息日期：修改前[]-->修改后[2019-08-27 12:00:00]}；<br/>{其他发行人名称：修改前[]-->修改后[其他发行人名称]}；<br/>{发行人行业：修改前[]-->修改后[农、林、牧、渔业]}；<br/>{发行人联系方式：修改前[]-->修改后[1350000000]}；<br/>{主营业务：修改前[]-->修改后[主营业务]}；<br/>{企业性质：修改前[]-->修改后[中央国企]}；<br/>{主体评级：修改前[]-->修改后[AAA]}；<br/>{注册地（省）：修改前[]-->修改后[北京]}；<br/>{注册地（市）：修改前[]-->修改后[宣武区]}；<br/>{发行人所属证监局：修改前[]-->修改后[北京证监局]}；<br/>{是否为金融行业：修改前[]-->修改后[是]}；<br/>{主承销商项目负责人：修改前[]-->修改后[主承销商项目负责人]}；<br/>{主承销商所属证监局：修改前[]-->修改后[北京证监局]}；<br/>{会计师事务所签字会计师：修改前[]-->修改后[会计师事务所签字会计师]}；<br/>{律师事务所签字律师：修改前[]-->修改后[律师事务所签字律师]}；<br/>{其他资信评级机构名称：修改前[]-->修改后[其他资信评级机构名称]}；<br/>{资信评级机构项目负责人：修改前[]-->修改后[资信评级机构项目负责人]}；<br/>{资信评级机构所属证监局：修改前[]-->修改后[云南证监局]}；<br/>{受托管理人负责人：修改前[]-->修改后[受托管理人负责人]}；<br/>{受托管理人负责人联系方式：修改前[]-->修改后[受托管理人负责人联系方式]}；<br/>{受托管理人所属证监局：修改前[]-->修改后[内蒙古证监局]}；<br/>{到期日：修改前[]-->修改后[2019-08-27 12:00:00]}；<br/>{备注：修改前[]-->修改后[备注]}；<br/>', 'admin', '1', '2019-08-26 13:51:27', '2019-08-26 13:51:27');
INSERT INTO `sys_log` VALUES ('2250', '在审项目信息', '新增了债券简称', '新增操作', '新增了：债券简称[债券简称]', 'admin', '1', '2019-08-26 13:57:39', '2019-08-26 13:57:39');
INSERT INTO `sys_log` VALUES ('2251', '在审项目信息', '修改了债券简称', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称]被修改：</span><br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>{受托管理人名称：修改前[]-->修改后[律师事务所名称]}；<br/>{会计师事务所名称：修改前[]-->修改后[会计师事务所名称]}；<br/>{会计师事务所签字会计师：修改前[]-->修改后[会计师事务所签字会计师]}；<br/>{律师事务所名称：修改前[]-->修改后[律师事务所名称]}；<br/>{律师事务所签字律师：修改前[]-->修改后[律师事务所名称]}；<br/>{资信评级机构：修改前[]-->修改后[律师事务所名称]}；<br/>{资信评级机构项目负责人：修改前[]-->修改后[律师事务所名称]}；<br/>{审核状态：修改前[]-->修改后[8]}；<br/>', 'admin', '1', '2019-08-26 14:05:59', '2019-08-26 14:05:59');
INSERT INTO `sys_log` VALUES ('2252', '债券风险或违约原因', '新增了风险或违约原因', '新增操作', '新增了：风险或违约原因[风险或违约原因]', 'admin', '1', '2019-08-26 14:12:45', '2019-08-26 14:12:45');
INSERT INTO `sys_log` VALUES ('2253', '风险监测信息', '新增了1234567890', '新增操作', '新增了：债券简称[1234567890]', 'admin', '1', '2019-08-26 14:12:48', '2019-08-26 14:12:48');
INSERT INTO `sys_log` VALUES ('2254', 'ABS基本信息', '新增了11', '新增操作', '新增了：资产支持证券名称[11]', 'admin', '1', '2019-08-26 14:14:56', '2019-08-26 14:14:56');
INSERT INTO `sys_log` VALUES ('2255', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-26 14:23:13', '2019-08-26 14:23:13');
INSERT INTO `sys_log` VALUES ('2256', '风险监测信息', '删除了1234567890,', '删除操作', '删除了：债券简称[1234567890,]', 'admin', '1', '2019-08-26 14:40:30', '2019-08-26 14:40:30');
INSERT INTO `sys_log` VALUES ('2257', '风险监测信息', '删除了1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,', '删除操作', '删除了：债券简称[1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,]', 'admin', '1', '2019-08-26 14:40:54', '2019-08-26 14:40:54');
INSERT INTO `sys_log` VALUES ('2258', '风险监测信息', '删除了1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,', '删除操作', '删除了：债券简称[1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,1234567890,]', 'admin', '1', '2019-08-26 14:41:18', '2019-08-26 14:41:18');
INSERT INTO `sys_log` VALUES ('2259', 'ABS基本信息', '修改了1', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[1]被修改：</span><br/>{管理人所辖证监局：修改前[,天津证监局]-->修改后[北京证监局]}；<br/>', 'admin', '1', '2019-08-26 14:44:16', '2019-08-26 14:44:16');
INSERT INTO `sys_log` VALUES ('2260', 'ABS基本信息', '修改了', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[]被修改：</span><br/>{管理人所辖证监局：修改前[]-->修改后[天津证监局,北京证监局,河北证监局]}；<br/>', 'admin', '1', '2019-08-26 14:46:49', '2019-08-26 14:46:49');
INSERT INTO `sys_log` VALUES ('2261', 'ABS基本信息', '修改了11', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[11]被修改：</span><br/>{管理人所辖证监局：修改前[]-->修改后[天津证监局,北京证监局,河北证监局]}；<br/>', 'admin', '1', '2019-08-26 14:47:39', '2019-08-26 14:47:39');
INSERT INTO `sys_log` VALUES ('2262', 'ABS基本信息', '修改了11', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[11]被修改：</span><br/>{管理人所辖证监局：修改前[天津证监局,北京证监局,河北证监局]-->修改后[北京证监局,天津证监局,河北证监局]}；<br/>', 'admin', '1', '2019-08-26 14:51:37', '2019-08-26 14:51:37');
INSERT INTO `sys_log` VALUES ('2263', 'ABS基本信息', '修改了', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[]被修改：</span><br/>{管理人所辖证监局：修改前[天津证监局,北京证监局,河北证监局]-->修改后[天津证监局]}；<br/>', 'admin', '1', '2019-08-26 14:52:21', '2019-08-26 14:52:21');
INSERT INTO `sys_log` VALUES ('2264', 'ABS基本信息', '新增了资产支持证券名称', '新增操作', '新增了：资产支持证券名称[资产支持证券名称]', 'admin', '1', '2019-08-26 14:58:35', '2019-08-26 14:58:35');
INSERT INTO `sys_log` VALUES ('2265', 'ABS在审项目信息', '新增了资产支持证券名称', '新增操作', '新增了：资产支持证券名称[资产支持证券名称]', 'admin', '1', '2019-08-26 15:09:00', '2019-08-26 15:09:00');
INSERT INTO `sys_log` VALUES ('2266', 'ABS在审项目信息', '新增了资产支持证券名称', '新增操作', '新增了：资产支持证券名称[资产支持证券名称]', 'admin', '1', '2019-08-26 15:09:04', '2019-08-26 15:09:04');
INSERT INTO `sys_log` VALUES ('2267', 'ABS在审项目信息', '新增了资产支持证券名称', '新增操作', '新增了：资产支持证券名称[资产支持证券名称]', 'admin', '1', '2019-08-26 15:09:20', '2019-08-26 15:09:20');
INSERT INTO `sys_log` VALUES ('2268', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{资产支持证券类型：修改前[]-->修改后[租赁债权]}；<br/>{流水号：修改前[]-->修改后[1000]}；<br/>', 'admin', '1', '2019-08-26 15:11:31', '2019-08-26 15:11:31');
INSERT INTO `sys_log` VALUES ('2269', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{资产支持证券类型：修改前[]-->修改后[租赁债权]}；<br/>{流水号：修改前[]-->修改后[1000]}；<br/>', 'admin', '1', '2019-08-26 15:11:31', '2019-08-26 15:11:31');
INSERT INTO `sys_log` VALUES ('2270', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{资产支持证券类型：修改前[]-->修改后[租赁债权]}；<br/>{流水号：修改前[]-->修改后[100]}；<br/>', 'admin', '1', '2019-08-26 15:11:34', '2019-08-26 15:11:34');
INSERT INTO `sys_log` VALUES ('2271', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{资产支持证券类型：修改前[]-->修改后[租赁债权]}；<br/>{流水号：修改前[]-->修改后[100]}；<br/>', 'admin', '1', '2019-08-26 15:11:34', '2019-08-26 15:11:34');
INSERT INTO `sys_log` VALUES ('2272', '在审项目信息', '修改了债券简称', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称]被修改：</span><br/>{发行人所属证监局：修改前[北京证监局]-->修改后[河北证监局]}；<br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>', 'admin', '1', '2019-08-26 15:16:18', '2019-08-26 15:16:18');
INSERT INTO `sys_log` VALUES ('2273', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{流水号：修改前[]-->修改后[100]}；<br/>', 'admin', '1', '2019-08-26 15:18:35', '2019-08-26 15:18:35');
INSERT INTO `sys_log` VALUES ('2274', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[资产支持证券名称]}；<br/>{流水号：修改前[]-->修改后[100]}；<br/>', 'admin', '1', '2019-08-26 15:21:01', '2019-08-26 15:21:01');
INSERT INTO `sys_log` VALUES ('2275', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券类型：修改前[]-->修改后[租赁债权]}；<br/>{预审核规模（亿元）：修改前[]-->修改后[100.000]}；<br/>{增信措施：修改前[]-->修改后[无异议函编号]}；<br/>{审核状态：修改前[]-->修改后[8]}；<br/>{原始权益人名称：修改前[]-->修改后[无异议函编号]}；<br/>{原始权益人所属证监局：修改前[]-->修改后[北京证监局]}；<br/>{原始权益人注册地：修改前[]-->修改后[北京]}；<br/>{原始权益人行业：修改前[]-->修改后[农、林、牧、渔业]}；<br/>{公司经营范围：修改前[]-->修改后[无异议函编号]}；<br/>{企业性质：修改前[]-->修改后[中央国企]}；<br/>{是否属于金融行业：修改前[]-->修改后[是]}；<br/>{主体评级：修改前[]-->修改后[AAA]}；<br/>{管理人名称：修改前[]-->修改后[无异议函编号]}；<br/>{管理人项目负责人（签字人）：修改前[]-->修改后[无异议函编号]}；<br/>{管理人联系手机：修改前[]-->修改后[13433332222]}；<br/>{管理人所属证监局：修改前[]-->修改后[辽宁证监局]}；<br/>{会计师事务所名称：修改前[]-->修改后[无异议函编号]}；<br/>{会计师事务所签字会计师：修改前[]-->修改后[无异议函编号]}；<br/>{律师事务所名称：修改前[]-->修改后[无异议函编号]}；<br/>{律师事务所签字律师：修改前[]-->修改后[无异议函编号]}；<br/>{资信评级机构名称：修改前[]-->修改后[无异议函编号]}；<br/>{资信评级机构项目负责人：修改前[]-->修改后[无异议函编号]}；<br/>{无异议函编号：修改前[]-->修改后[无异议函编号]}；<br/>{申请材料接收时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{受理决定或不予受理决定时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{第一次反馈意见出具时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{接收第一次反馈回复时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{第二次反馈意见函出具时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{接收第二次反馈材料时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{出具预审核意见/出具无异议函时间：修改前[]-->修改后[2019-08-26 12:00:00]}；<br/>{备注：修改前[]-->修改后[无异议函编号]}；<br/>{担保人：修改前[]-->修改后[无异议函编号]}；<br/>{担保人联系方式：修改前[]-->修改后[无异议函编号]}；<br/>{实际融资人：修改前[]-->修改后[无异议函编号]}；<br/>', 'admin', '1', '2019-08-26 15:24:31', '2019-08-26 15:24:31');
INSERT INTO `sys_log` VALUES ('2276', 'ABS风险监测信息', '新增了资产支持证券名称', '新增操作', '新增了：资产支持证券简称[资产支持证券名称]', 'admin', '1', '2019-08-26 15:27:47', '2019-08-26 15:27:47');
INSERT INTO `sys_log` VALUES ('2277', 'ABS监管信息', '在资产支持证券名称下上传了文件', '上传文件', '上传文件名称：reportsys_slf4j_172.31.0.3_4591_2019080720190826153317.log', 'admin', '1', '2019-08-26 15:33:20', '2019-08-26 15:33:20');
INSERT INTO `sys_log` VALUES ('2278', 'ABS债券监管信息', '新增了资产支持证券名称', '新增操作', '新增了：ABS简称[资产支持证券名称]', 'admin', '1', '2019-08-26 15:33:20', '2019-08-26 15:33:20');
INSERT INTO `sys_log` VALUES ('2279', '风险监测信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678958]-->修改后[]}；<br/>{主体初始评级：修改前[]-->修改后[AAA]}；<br/>{主体当前评级：修改前[]-->修改后[AAA]}；<br/>{评级机构联系方式：修改前[]-->修改后[11]}；<br/>', 'admin', '1', '2019-08-26 15:43:35', '2019-08-26 15:43:35');
INSERT INTO `sys_log` VALUES ('2280', '风险监测信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678947]-->修改后[]}；<br/>{受托管理人所属证监局：修改前[内蒙古证监局]-->修改后[山西证监局]}；<br/>{评级机构所属证监局：修改前[云南证监局]-->修改后[河北证监局]}；<br/>', 'admin', '1', '2019-08-26 15:45:14', '2019-08-26 15:45:14');
INSERT INTO `sys_log` VALUES ('2281', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[]}；<br/>{原始权益人名称：修改前[无异议函编号]-->修改后[乱箭123]}；<br/>', 'admin', '1', '2019-08-27 17:23:18', '2019-08-27 17:23:18');
INSERT INTO `sys_log` VALUES ('2282', 'ABS在审项目信息', '新增了2', '新增操作', '新增了：资产支持证券名称[2]', 'admin', '1', '2019-08-27 18:13:38', '2019-08-27 18:13:38');
INSERT INTO `sys_log` VALUES ('2283', 'ABS风险监测信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[资产支持证券名称]被修改：</span><br/>{资产支持证券代码：修改前[100]-->修改后[]}；<br/>{涉及证监局：修改前[]-->修改后[北京证监局,天津证监局,河北证监局]}；<br/>{原始权益人所属证监局：修改前[北京证监局,天津证监局,河北证监局]-->修改后[北京证监局,天津证监局,河北证监局  ]}；<br/>', 'admin', '1', '2019-08-27 18:19:05', '2019-08-27 18:19:05');
INSERT INTO `sys_log` VALUES ('2284', 'ABS风险监测信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[资产支持证券名称]被修改：</span><br/>{资产支持证券代码：修改前[103]-->修改后[]}；<br/>{原始权益人：修改前[原始权益人名称]-->修改后[乱箭]}；<br/>{涉及证监局：修改前[]-->修改后[海南证监局,辽宁证监局,北京证监局]}；<br/>{原始权益人所属证监局：修改前[,北京证监局]-->修改后[,北京证监局  ]}；<br/>', 'admin', '1', '2019-08-27 18:22:27', '2019-08-27 18:22:27');
INSERT INTO `sys_log` VALUES ('2285', 'ABS风险监测信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[资产支持证券名称]被修改：</span><br/>{资产支持证券代码：修改前[103]-->修改后[]}；<br/>', 'admin', '1', '2019-08-27 18:22:27', '2019-08-27 18:22:27');
INSERT INTO `sys_log` VALUES ('2286', '债券风险或违约原因', '新增了测试1', '新增操作', '新增了：ABS风险或违约原因[测试1]', 'admin', '1', '2019-08-28 09:41:17', '2019-08-28 09:41:17');
INSERT INTO `sys_log` VALUES ('2287', '债券风险或违约原因', '新增了测试2', '新增操作', '新增了：ABS风险或违约原因[测试2]', 'admin', '1', '2019-08-28 09:41:30', '2019-08-28 09:41:30');
INSERT INTO `sys_log` VALUES ('2288', '债券风险或违约原因', '新增了测试3', '新增操作', '新增了：ABS风险或违约原因[测试3]', 'admin', '1', '2019-08-28 09:41:43', '2019-08-28 09:41:43');
INSERT INTO `sys_log` VALUES ('2289', '债券风险或违约原因', '新增了测试5', '新增操作', '新增了：ABS风险或违约原因[测试5]', 'admin', '1', '2019-08-28 09:42:37', '2019-08-28 09:42:37');
INSERT INTO `sys_log` VALUES ('2290', '债券基本信息', '新增了债券简称', '新增操作', '新增了：债券简称[债券简称]', 'admin', '1', '2019-08-28 10:52:07', '2019-08-28 10:52:07');
INSERT INTO `sys_log` VALUES ('2291', '债券基本信息', '新增了债券简称', '新增操作', '新增了：债券简称[债券简称]', 'admin', '1', '2019-08-28 10:52:29', '2019-08-28 10:52:29');
INSERT INTO `sys_log` VALUES ('2292', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 10:53:14', '2019-08-28 10:53:14');
INSERT INTO `sys_log` VALUES ('2293', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 11:02:12', '2019-08-28 11:02:12');
INSERT INTO `sys_log` VALUES ('2294', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-28 11:02:34', '2019-08-28 11:02:34');
INSERT INTO `sys_log` VALUES ('2295', '在审项目信息', '新增了32323232', '新增操作', '新增了：债券简称[32323232]', 'admin', '1', '2019-08-28 11:03:03', '2019-08-28 11:03:03');
INSERT INTO `sys_log` VALUES ('2296', '在审项目信息', '新增了2222', '新增操作', '新增了：债券简称[2222]', 'admin', '1', '2019-08-28 11:06:08', '2019-08-28 11:06:08');
INSERT INTO `sys_log` VALUES ('2297', '债券监管信息', '在债券简称下上传了文件', '上传文件', '上传文件名称201909fuxiyy.doc', 'admin', '1', '2019-08-28 11:21:56', '2019-08-28 11:21:56');
INSERT INTO `sys_log` VALUES ('2298', '债券监管信息', '修改了债券简称', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称]被修改：</span><br/>{债券代码：修改前[2]-->修改后[]}；<br/>', 'admin', '1', '2019-08-28 11:21:57', '2019-08-28 11:21:57');
INSERT INTO `sys_log` VALUES ('2299', '债券基本信息', '修改了2019年8月28日 13:41:35', '修改操作', '<span  style=\"color:blue;\">债券简称[2019年8月28日 13:41:35]被修改：</span><br/>{债券简称：修改前[]-->修改后[2019年8月28日 13:41:35]}；<br/>', 'admin', '1', '2019-08-28 13:41:39', '2019-08-28 13:41:39');
INSERT INTO `sys_log` VALUES ('2300', '债券基本信息', '修改了2019年8月28日', '修改操作', '<span  style=\"color:blue;\">债券简称[2019年8月28日]被修改：</span><br/>{债券简称：修改前[]-->修改后[2019年8月28日]}；<br/>', 'admin', '1', '2019-08-28 13:41:53', '2019-08-28 13:41:53');
INSERT INTO `sys_log` VALUES ('2301', '在审项目信息', '新增了12333445555', '新增操作', '新增了：债券简称[12333445555]', 'admin', '1', '2019-08-28 13:42:08', '2019-08-28 13:42:08');
INSERT INTO `sys_log` VALUES ('2302', '在审项目信息', '修改了新增加的2019年8月28日', '修改操作', '<span  style=\"color:blue;\">债券简称[新增加的2019年8月28日]被修改：</span><br/>{债券简称：修改前[12333445555]-->修改后[新增加的2019年8月28日]}；<br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>', 'admin', '1', '2019-08-28 13:42:33', '2019-08-28 13:42:33');
INSERT INTO `sys_log` VALUES ('2303', '债券基本信息', '修改了2121212121', '修改操作', '<span  style=\"color:blue;\">债券简称[2121212121]被修改：</span><br/>{债券简称：修改前[]-->修改后[2121212121]}；<br/>', 'ceshi', '142', '2019-08-28 13:45:54', '2019-08-28 13:45:54');
INSERT INTO `sys_log` VALUES ('2304', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'ceshi', '142', '2019-08-28 13:47:10', '2019-08-28 13:47:10');
INSERT INTO `sys_log` VALUES ('2305', '在审项目信息', '新增了CODE123', '新增操作', '新增了：债券简称[CODE123]', 'ceshi', '142', '2019-08-28 13:47:31', '2019-08-28 13:47:31');
INSERT INTO `sys_log` VALUES ('2306', '债券基本信息', '修改了CODE123', '修改操作', '<span  style=\"color:blue;\">债券简称[CODE123]被修改：</span><br/>{债券简称：修改前[]-->修改后[CODE123]}；<br/>', 'ceshi', '142', '2019-08-28 13:50:52', '2019-08-28 13:50:52');
INSERT INTO `sys_log` VALUES ('2307', '在审项目信息', '新增了CODE123123', '新增操作', '新增了：债券简称[CODE123123]', 'ceshi', '142', '2019-08-28 13:51:51', '2019-08-28 13:51:51');
INSERT INTO `sys_log` VALUES ('2308', '债券基本信息', '新增了CODE123123', '新增操作', '新增了：债券简称[CODE123123]', 'ceshi', '142', '2019-08-28 13:54:00', '2019-08-28 13:54:00');
INSERT INTO `sys_log` VALUES ('2309', '债券监管信息', '上传了文件', '上传文件', '上传文件名称关于公司2018年员工健康体检的通知.pdf', 'ceshi', '142', '2019-08-28 13:55:19', '2019-08-28 13:55:19');
INSERT INTO `sys_log` VALUES ('2310', '债券监管信息', '在CODE123123下上传了文件', '上传文件', '上传文件名称：关于公司2018年员工健康体检的通知20190828135518.pdf', 'ceshi', '142', '2019-08-28 13:55:20', '2019-08-28 13:55:20');
INSERT INTO `sys_log` VALUES ('2311', '债券监管信息', '新增了CODE123123', '新增操作', '新增了：债券简称[CODE123123]', 'ceshi', '142', '2019-08-28 13:55:20', '2019-08-28 13:55:20');
INSERT INTO `sys_log` VALUES ('2312', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-28 14:56:51', '2019-08-28 14:56:51');
INSERT INTO `sys_log` VALUES ('2313', 'ABS基本信息', '修改了CODE110', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[CODE110]被修改：</span><br/>{资产支持证券名称：修改前[]-->修改后[CODE110]}；<br/>{资产支持证券简称：修改前[]-->修改后[CODE110]}；<br/>', 'admin', '1', '2019-08-28 14:57:09', '2019-08-28 14:57:09');
INSERT INTO `sys_log` VALUES ('2314', 'ABS风险监测信息', '新增了CODE110', '新增操作', '新增了：资产支持证券简称[CODE110]', 'admin', '1', '2019-08-28 14:57:23', '2019-08-28 14:57:23');
INSERT INTO `sys_log` VALUES ('2315', 'ABS监管信息', '在CODE110下上传了文件', '上传文件', '上传文件名称：关于公司2018年员工健康体检的通知20190828145849.pdf', 'admin', '1', '2019-08-28 14:58:52', '2019-08-28 14:58:52');
INSERT INTO `sys_log` VALUES ('2316', 'ABS债券监管信息', '新增了CODE110', '新增操作', '新增了：ABS简称[CODE110]', 'admin', '1', '2019-08-28 14:58:52', '2019-08-28 14:58:52');
INSERT INTO `sys_log` VALUES ('2317', 'ABS监管信息', '在资产支持证券名称下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190828150548.pptx', 'admin', '1', '2019-08-28 15:05:52', '2019-08-28 15:05:52');
INSERT INTO `sys_log` VALUES ('2318', 'ABS债券监管信息', '新增了资产支持证券名称', '新增操作', '新增了：ABS简称[资产支持证券名称]', 'admin', '1', '2019-08-28 15:05:52', '2019-08-28 15:05:52');
INSERT INTO `sys_log` VALUES ('2319', 'ABS监管信息', '在资产支持证券名称下上传了文件', '上传文件', '上传文件名称：附件2：个人所得税专项附加扣除政策指引一览表20190828150632.pdf', 'admin', '1', '2019-08-28 15:06:33', '2019-08-28 15:06:33');
INSERT INTO `sys_log` VALUES ('2320', 'ABS债券监管信息', '新增了资产支持证券名称', '新增操作', '新增了：ABS简称[资产支持证券名称]', 'admin', '1', '2019-08-28 15:06:33', '2019-08-28 15:06:33');
INSERT INTO `sys_log` VALUES ('2321', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 15:12:06', '2019-08-28 15:12:06');
INSERT INTO `sys_log` VALUES ('2322', '债券基本信息', '修改了CODE223344', '修改操作', '<span  style=\"color:blue;\">债券简称[CODE223344]被修改：</span><br/>{债券简称：修改前[]-->修改后[CODE223344]}；<br/>{债券类型：修改前[]-->修改后[普通公司债]}；<br/>', 'admin', '1', '2019-08-28 15:12:25', '2019-08-28 15:12:25');
INSERT INTO `sys_log` VALUES ('2323', 'ABS债券监管信息', '修改了资产支持1', '修改操作', '<span  style=\"color:blue;\">ABS简称[资产支持1]被修改：</span><br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[资产支持1]}；<br/>{资产支持证券代码：修改前[105]-->修改后[]}；<br/>{原始权益人名称：修改前[原始权益人名称]-->修改后[原始权益1]}；<br/>{原始权益人所属证监局：修改前[北京证监局,天津证监局,河北证监局]-->修改后[辽宁证监局]}；<br/>', 'admin', '1', '2019-08-28 15:19:39', '2019-08-28 15:19:39');
INSERT INTO `sys_log` VALUES ('2324', 'ABS债券监管信息', '修改了111', '修改操作', '<span  style=\"color:blue;\">ABS简称[111]被修改：</span><br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[111]}；<br/>{资产支持证券代码：修改前[104]-->修改后[]}；<br/>{原始权益人名称：修改前[原始权益人名称]-->修改后[111]}；<br/>', 'admin', '1', '2019-08-28 15:21:22', '2019-08-28 15:21:22');
INSERT INTO `sys_log` VALUES ('2325', 'ABS监管信息', '在321下上传了文件', '上传文件', '上传文件名称：“党的十九大精神教育培训”网络专题课程完成情况反馈表20190828152211.xlsx', 'admin', '1', '2019-08-28 15:22:13', '2019-08-28 15:22:13');
INSERT INTO `sys_log` VALUES ('2326', 'ABS债券监管信息', '新增了321', '新增操作', '新增了：ABS简称[321]', 'admin', '1', '2019-08-28 15:22:13', '2019-08-28 15:22:13');
INSERT INTO `sys_log` VALUES ('2327', 'ABS债券监管信息', '修改了3333', '修改操作', '<span  style=\"color:blue;\">ABS简称[3333]被修改：</span><br/>{资产支持证券简称：修改前[321]-->修改后[3333]}；<br/>{资产支持证券代码：修改前[111]-->修改后[]}；<br/>{原始权益人名称：修改前[321]-->修改后[3333]}；<br/>', 'admin', '1', '2019-08-28 15:22:39', '2019-08-28 15:22:39');
INSERT INTO `sys_log` VALUES ('2328', 'ABS监管信息', '在乱箭123下上传了文件', '上传文件', '上传文件名称：附件1：国务院关于印发个人所得税专项附加扣除暂行办法的通知20190828152400.pdf', 'admin', '1', '2019-08-28 15:24:54', '2019-08-28 15:24:54');
INSERT INTO `sys_log` VALUES ('2329', 'ABS债券监管信息', '新增了乱箭123', '新增操作', '新增了：ABS简称[乱箭123]', 'admin', '1', '2019-08-28 15:24:54', '2019-08-28 15:24:54');
INSERT INTO `sys_log` VALUES ('2330', 'ABS监管信息', '在章鱼测试下上传了文件', '上传文件', '上传文件名称：附件1：个人所得税预扣率表及计算举例20190828152807.pptx', 'admin', '1', '2019-08-28 15:28:11', '2019-08-28 15:28:11');
INSERT INTO `sys_log` VALUES ('2331', 'ABS债券监管信息', '新增了章鱼测试', '新增操作', '新增了：ABS简称[章鱼测试]', 'admin', '1', '2019-08-28 15:28:11', '2019-08-28 15:28:11');
INSERT INTO `sys_log` VALUES ('2332', 'ABS债券监管信息', '修改了章鱼测试123', '修改操作', '<span  style=\"color:blue;\">ABS简称[章鱼测试123]被修改：</span><br/>{资产支持证券简称：修改前[章鱼测试]-->修改后[章鱼测试123]}；<br/>{资产支持证券代码：修改前[121]-->修改后[]}；<br/>{原始权益人名称：修改前[测试章鱼]-->修改后[测试章鱼123]}；<br/>', 'admin', '1', '2019-08-28 15:28:35', '2019-08-28 15:28:35');
INSERT INTO `sys_log` VALUES ('2333', 'ABS风险监测信息', '修改了测试章鱼123', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[测试章鱼123]被修改：</span><br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[测试章鱼123]}；<br/>{资产支持证券代码：修改前[100]-->修改后[]}；<br/>{原始权益人：修改前[原始权益人名称]-->修改后[章鱼测试123]}；<br/>{原始权益人所属证监局：修改前[北京证监局,天津证监局,河北证监局  ]-->修改后[北京证监局,天津证监局,河北证监局    ]}；<br/>', 'admin', '1', '2019-08-28 15:33:29', '2019-08-28 15:33:29');
INSERT INTO `sys_log` VALUES ('2334', 'ABS风险监测信息', '新增了乱箭123', '新增操作', '新增了：资产支持证券简称[乱箭123]', 'admin', '1', '2019-08-28 15:34:09', '2019-08-28 15:34:09');
INSERT INTO `sys_log` VALUES ('2335', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 15:50:21', '2019-08-28 15:50:21');
INSERT INTO `sys_log` VALUES ('2336', 'ABS基本信息', '修改了乱箭123', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[乱箭123]被修改：</span><br/>{资产支持证券名称：修改前[资产支持证券名称]-->修改后[乱箭123]}；<br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[乱箭321]}；<br/>{原始权益人名称：修改前[原始权益人名称]-->修改后[乱箭1234]}；<br/>', 'admin', '1', '2019-08-28 16:04:16', '2019-08-28 16:04:16');
INSERT INTO `sys_log` VALUES ('2337', 'ABS基本信息', '修改了乱箭123', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[乱箭123]被修改：</span><br/>{期限：修改前[资产支持证券名称1]-->修改后[111]}；<br/>{原始权益人所属证监局：修改前[,北京证监局]-->修改后[,北京证监局,天津证监局,河北证监局]}；<br/>{公司经营范围：修改前[原始权益人名称]-->修改后[111]}；<br/>{管理人名称：修改前[管理人名称]-->修改后[乱箭4321]}；<br/>{管理人项目负责人：修改前[管理人名称]-->修改后[111]}；<br/>', 'admin', '1', '2019-08-28 16:06:58', '2019-08-28 16:06:58');
INSERT INTO `sys_log` VALUES ('2338', '债券基本信息', '新增了CODE112233', '新增操作', '新增了：债券简称[CODE112233]', 'admin', '1', '2019-08-28 16:09:03', '2019-08-28 16:09:03');
INSERT INTO `sys_log` VALUES ('2339', '债券基本信息', '新增了LSH11', '新增操作', '新增了：债券简称[LSH11]', 'admin', '1', '2019-08-28 16:41:45', '2019-08-28 16:41:45');
INSERT INTO `sys_log` VALUES ('2340', '债券基本信息', '新增了LS88888888', '新增操作', '新增了：债券简称[LS88888888]', 'admin', '1', '2019-08-28 17:01:22', '2019-08-28 17:01:22');
INSERT INTO `sys_log` VALUES ('2341', '债券基本信息', '新增了DDDDDDD', '新增操作', '新增了：债券简称[DDDDDDD]', 'admin', '1', '2019-08-28 17:06:41', '2019-08-28 17:06:41');
INSERT INTO `sys_log` VALUES ('2342', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 17:14:27', '2019-08-28 17:14:27');
INSERT INTO `sys_log` VALUES ('2343', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 17:20:51', '2019-08-28 17:20:51');
INSERT INTO `sys_log` VALUES ('2344', '债券基本信息', '删除了undefined,', '删除操作', '删除了：债券简称[undefined,]', 'admin', '1', '2019-08-28 17:48:55', '2019-08-28 17:48:55');
INSERT INTO `sys_log` VALUES ('2345', '债券基本信息', '删除了undefined,', '删除操作', '删除了：债券简称[undefined,]', 'admin', '1', '2019-08-28 17:49:06', '2019-08-28 17:49:06');
INSERT INTO `sys_log` VALUES ('2346', '债券基本信息', '新增了FFFFF', '新增操作', '新增了：债券简称[FFFFF]', 'admin', '1', '2019-08-28 18:03:04', '2019-08-28 18:03:04');
INSERT INTO `sys_log` VALUES ('2347', '在审项目信息', '新增了22222222222222222', '新增操作', '新增了：债券简称[22222222222222222]', 'admin', '1', '2019-08-28 18:06:54', '2019-08-28 18:06:54');
INSERT INTO `sys_log` VALUES ('2348', '在审项目信息', '新增了33333333333333333333', '新增操作', '新增了：债券简称[33333333333333333333]', 'admin', '1', '2019-08-28 18:07:06', '2019-08-28 18:07:06');
INSERT INTO `sys_log` VALUES ('2349', '在审项目信息', '删除了22222222222222222,', '删除操作', '删除了：债券简称[22222222222222222,]', 'admin', '1', '2019-08-28 18:08:10', '2019-08-28 18:08:10');
INSERT INTO `sys_log` VALUES ('2350', '债券基本信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 18:09:07', '2019-08-28 18:09:07');
INSERT INTO `sys_log` VALUES ('2351', '风险监测信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 18:10:14', '2019-08-28 18:10:14');
INSERT INTO `sys_log` VALUES ('2352', '风险监测信息', '删除了,', '删除操作', '删除了：债券简称[,]', 'admin', '1', '2019-08-28 18:12:40', '2019-08-28 18:12:40');
INSERT INTO `sys_log` VALUES ('2353', '债券监管信息', '上传了文件', '上传文件', '上传文件名称关于公司2018年员工健康体检的通知.pdf', 'admin', '1', '2019-08-28 18:14:00', '2019-08-28 18:14:00');
INSERT INTO `sys_log` VALUES ('2354', '债券监管信息', '上传了文件', '上传文件', '上传文件名称：关于公司2018年员工健康体检的通知20190828181400.pdf', 'admin', '1', '2019-08-28 18:14:02', '2019-08-28 18:14:02');
INSERT INTO `sys_log` VALUES ('2355', '债券监管信息', '上传了文件', '上传文件', '上传文件名称：关于公司2018年员工健康体检的通知20190828181400.pdf', 'admin', '1', '2019-08-28 18:15:10', '2019-08-28 18:15:10');
INSERT INTO `sys_log` VALUES ('2356', '债券监管信息', '新增了', '新增操作', '新增了：债券简称[]', 'admin', '1', '2019-08-28 18:15:10', '2019-08-28 18:15:10');
INSERT INTO `sys_log` VALUES ('2357', '债券监管信息', '删除了,', '删除操作', '删除了：债券简称[,]', 'admin', '1', '2019-08-28 18:15:57', '2019-08-28 18:15:57');
INSERT INTO `sys_log` VALUES ('2358', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-28 18:17:58', '2019-08-28 18:17:58');
INSERT INTO `sys_log` VALUES ('2359', 'ABS基本信息', '新增了', '新增操作', '新增了：资产支持证券名称[]', 'admin', '1', '2019-08-28 18:18:21', '2019-08-28 18:18:21');
INSERT INTO `sys_log` VALUES ('2360', '', '删除了null', '删除操作', '删除了：null[null]', 'admin', '1', '2019-08-28 18:20:07', '2019-08-28 18:20:07');
INSERT INTO `sys_log` VALUES ('2361', 'ABS在审项目信息', '新增了KKKKKKKKKKKKK12', '新增操作', '新增了：资产支持证券名称[KKKKKKKKKKKKK12]', 'admin', '1', '2019-08-28 18:21:07', '2019-08-28 18:21:07');
INSERT INTO `sys_log` VALUES ('2362', 'ABS在审项目信息', '新增了KKKKKKKKKKKKK1223', '新增操作', '新增了：资产支持证券名称[KKKKKKKKKKKKK1223]', 'admin', '1', '2019-08-28 18:21:16', '2019-08-28 18:21:16');
INSERT INTO `sys_log` VALUES ('2363', 'ABS在审项目信息', '删除了KKKKKKKKKKKKK1223,', '删除操作', '删除了：资产支持证券名称[KKKKKKKKKKKKK1223,]', 'admin', '1', '2019-08-28 18:22:13', '2019-08-28 18:22:13');
INSERT INTO `sys_log` VALUES ('2364', 'ABS基本信息', '修改了CODE110', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[CODE110]被修改：</span><br/>', 'admin', '1', '2019-08-28 18:23:25', '2019-08-28 18:23:25');
INSERT INTO `sys_log` VALUES ('2365', 'ABS风险监测信息', '新增了222222', '新增操作', '新增了：资产支持证券简称[222222]', 'admin', '1', '2019-08-28 18:24:09', '2019-08-28 18:24:09');
INSERT INTO `sys_log` VALUES ('2366', 'ABS监管信息', '在222222下上传了文件', '上传文件', '上传文件名称：关于公司2018年员工健康体检的通知20190828182604.pdf', 'admin', '1', '2019-08-28 18:26:06', '2019-08-28 18:26:06');
INSERT INTO `sys_log` VALUES ('2367', 'ABS债券监管信息', '新增了222222', '新增操作', '新增了：ABS简称[222222]', 'admin', '1', '2019-08-28 18:26:06', '2019-08-28 18:26:06');
INSERT INTO `sys_log` VALUES ('2368', 'ABS风险监测信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[资产支持证券名称]被修改：</span><br/>{资产支持证券代码：修改前[105]-->修改后[]}；<br/>{原始权益人：修改前[原始权益人名称]-->修改后[乱箭测试]}；<br/>{原始权益人所属证监局：修改前[,北京证监局]-->修改后[,北京证监局  ]}；<br/>', 'admin', '1', '2019-08-28 19:11:19', '2019-08-28 19:11:19');
INSERT INTO `sys_log` VALUES ('2369', 'ABS风险监测信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[资产支持证券名称]被修改：</span><br/>{资产支持证券代码：修改前[109]-->修改后[]}；<br/>{原始权益人：修改前[原始权益人名称]-->修改后[乱箭123]}；<br/>{原始权益人所属证监局：修改前[,北京证监局]-->修改后[,北京证监局  ]}；<br/>', 'admin', '1', '2019-08-28 19:11:32', '2019-08-28 19:11:32');
INSERT INTO `sys_log` VALUES ('2370', '在审项目信息', '修改了债券简称111', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称111]被修改：</span><br/>{债券简称：修改前[债券简称]-->修改后[债券简称111]}；<br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>', 'admin', '1', '2019-08-29 09:02:38', '2019-08-29 09:02:38');
INSERT INTO `sys_log` VALUES ('2371', '债券基本信息', '修改了AAAAAAAAAAA', '修改操作', '<span  style=\"color:blue;\">债券简称[AAAAAAAAAAA]被修改：</span><br/>{债券简称：修改前[1234567890]-->修改后[AAAAAAAAAAA]}；<br/>', 'admin', '1', '2019-08-29 09:03:02', '2019-08-29 09:03:02');
INSERT INTO `sys_log` VALUES ('2372', 'ABS风险监测信息', '修改了222222', '修改操作', '<span  style=\"color:blue;\">资产支持证券简称[222222]被修改：</span><br/>{资产支持证券代码：修改前[222222]-->修改后[]}；<br/>{管理人：修改前[]-->修改后[乱箭]}；<br/>{原始权益人所属证监局：修改前[]-->修改后[  ]}；<br/>', 'admin', '1', '2019-08-30 15:06:30', '2019-08-30 15:06:30');
INSERT INTO `sys_log` VALUES ('2373', '风险监测信息', '删除了1234567890,', '删除操作', '删除了：债券简称[1234567890,]', 'admin', '1', '2019-09-04 10:29:08', '2019-09-04 10:29:08');
INSERT INTO `sys_log` VALUES ('2374', 'ABS风险监测信息', '删除了222222,CODE110,', '删除操作', '删除了：资产支持证券简称[222222,CODE110,]', 'admin', '1', '2019-09-04 10:50:54', '2019-09-04 10:50:54');
INSERT INTO `sys_log` VALUES ('2375', 'ABS基本信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{原始权益人行业：修改前[,农、林、牧、渔业]-->修改后[,制造业,电力、热力、燃气及水生产和供应业,建筑业,批发和零售业]}；<br/>', 'admin', '1', '2019-09-09 14:32:54', '2019-09-09 14:32:54');
INSERT INTO `sys_log` VALUES ('2376', 'ABS基本信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{原始权益人行业：修改前[,农、林、牧、渔业]-->修改后[,采矿业,制造业,电力、热力、燃气及水生产和供应业,建筑业]}；<br/>', 'admin', '1', '2019-09-09 14:33:03', '2019-09-09 14:33:03');
INSERT INTO `sys_log` VALUES ('2377', 'ABS基本信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{原始权益人行业：修改前[,农、林、牧、渔业]-->修改后[,电力、热力、燃气及水生产和供应业,批发和零售业,交通运输、仓库和邮政业]}；<br/>', 'admin', '1', '2019-09-09 14:33:11', '2019-09-09 14:33:11');
INSERT INTO `sys_log` VALUES ('2378', 'ABS在审项目信息', '修改了资产支持证券名称', '修改操作', '<span  style=\"color:blue;\">资产支持证券名称[资产支持证券名称]被修改：</span><br/>{资产支持证券简称：修改前[资产支持证券名称]-->修改后[]}；<br/>{原始权益人行业：修改前[农、林、牧、渔业]-->修改后[建筑业,教育,卫生和社会工作,文化、体育和娱乐业,综合]}；<br/>', 'admin', '1', '2019-09-09 14:33:56', '2019-09-09 14:33:56');
INSERT INTO `sys_log` VALUES ('2379', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[交通运输、仓库和邮政业]}；<br/>{注册地（省）：修改前[北京]-->修改后[河南]}；<br/>{注册地（市）：修改前[宣武区]-->修改后[开封市]}；<br/>{发行人所属证监局：修改前[北京证监局]-->修改后[内蒙古证监局]}；<br/>', 'admin', '1', '2019-09-09 14:43:46', '2019-09-09 14:43:46');
INSERT INTO `sys_log` VALUES ('2380', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{发行人所属证监局：修改前[北京证监局]-->修改后[山西证监局]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[采矿业]}；<br/>{注册地(省份)：修改前[北京]-->修改后[河北]}；<br/>{注册地(市)：修改前[宣武区]-->修改后[保定市]}；<br/>', 'admin', '1', '2019-09-09 14:44:37', '2019-09-09 14:44:37');
INSERT INTO `sys_log` VALUES ('2381', '在审项目信息', '修改了债券简称111', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称111]被修改：</span><br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>{注册地(省份)：修改前[北京]-->修改后[辽宁]}；<br/>{注册地(市)：修改前[朝阳区]-->修改后[锦州市]}；<br/>', 'admin', '1', '2019-09-09 14:44:59', '2019-09-09 14:44:59');
INSERT INTO `sys_log` VALUES ('2382', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{核准发行规模（亿）：修改前[400]-->修改后[40044]}；<br/>', 'admin', '1', '2019-09-09 14:46:43', '2019-09-09 14:46:43');
INSERT INTO `sys_log` VALUES ('2383', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{实际发行规模（亿）：修改前[200]-->修改后[40044]}；<br/>', 'admin', '1', '2019-09-09 14:47:26', '2019-09-09 14:47:26');
INSERT INTO `sys_log` VALUES ('2384', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{核准发行规模（亿）：修改前[40044]-->修改后[40044454545]}；<br/>{实际发行规模（亿）：修改前[40044]-->修改后[40044454545]}；<br/>', 'admin', '1', '2019-09-09 14:47:47', '2019-09-09 14:47:47');
INSERT INTO `sys_log` VALUES ('2385', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{拟发行金额(亿)：修改前[200]-->修改后[3344444]}；<br/>', 'admin', '1', '2019-09-09 14:48:44', '2019-09-09 14:48:44');
INSERT INTO `sys_log` VALUES ('2386', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{核准发行规模（亿）：修改前[40044454545]-->修改后[40]}；<br/>{实际发行规模（亿）：修改前[40044454545]-->修改后[40]}；<br/>', 'admin', '1', '2019-09-09 14:49:37', '2019-09-09 14:49:37');
INSERT INTO `sys_log` VALUES ('2387', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[制造业]}；<br/>', 'admin', '1', '2019-09-09 14:50:11', '2019-09-09 14:50:11');
INSERT INTO `sys_log` VALUES ('2388', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[电力、热力、燃气及水生产和供应业]}；<br/>', 'admin', '1', '2019-09-09 14:50:29', '2019-09-09 14:50:29');
INSERT INTO `sys_log` VALUES ('2389', '债券基本信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[建筑业]}；<br/>', 'admin', '1', '2019-09-09 14:50:42', '2019-09-09 14:50:42');
INSERT INTO `sys_log` VALUES ('2390', '在审项目信息', '修改了债券简称111', '修改操作', '<span  style=\"color:blue;\">债券简称[债券简称111]被修改：</span><br/>{拥有查看该债券权限的证监局：修改前[系统管理员]-->修改后[]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[批发和零售业]}；<br/>', 'admin', '1', '2019-09-09 14:51:04', '2019-09-09 14:51:04');
INSERT INTO `sys_log` VALUES ('2391', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[水利、环境和公共设施管理业]}；<br/>', 'admin', '1', '2019-09-09 14:51:36', '2019-09-09 14:51:36');
INSERT INTO `sys_log` VALUES ('2392', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[综合]}；<br/>', 'admin', '1', '2019-09-09 14:51:46', '2019-09-09 14:51:46');
INSERT INTO `sys_log` VALUES ('2393', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[文化、体育和娱乐业]}；<br/>', 'admin', '1', '2019-09-09 14:51:56', '2019-09-09 14:51:56');
INSERT INTO `sys_log` VALUES ('2394', '在审项目信息', '修改了1234567890', '修改操作', '<span  style=\"color:blue;\">债券简称[1234567890]被修改：</span><br/>{债券代码：修改前[12345678901]-->修改后[]}；<br/>{发行人行业：修改前[农、林、牧、渔业]-->修改后[教育]}；<br/>', 'admin', '1', '2019-09-09 14:52:08', '2019-09-09 14:52:08');

-- ----------------------------
-- Table structure for trail_data
-- ----------------------------
DROP TABLE IF EXISTS `trail_data`;
CREATE TABLE `trail_data` (
  `procode` varchar(255) DEFAULT NULL,
  `blobs` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of trail_data
-- ----------------------------

-- ----------------------------
-- Table structure for zs_data
-- ----------------------------
DROP TABLE IF EXISTS `zs_data`;
CREATE TABLE `zs_data` (
  `procode` varchar(255) DEFAULT NULL,
  `blobs` blob,
  `insertTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of zs_data
-- ----------------------------
