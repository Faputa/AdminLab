/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : admin

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 20/05/2020 18:09:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rbac_menu
-- ----------------------------
DROP TABLE IF EXISTS `rbac_menu`;
CREATE TABLE `rbac_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint(20) NULL DEFAULT NULL COMMENT '父ID',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `icon` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `seq` int(11) NULL DEFAULT NULL COMMENT '排序',
  `is_enable` bit(1) NULL DEFAULT NULL COMMENT '是否启用(0禁用1启用)',
  `is_leaf_node` bit(1) NULL DEFAULT NULL COMMENT '是否叶子节点(0否1是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_menu
-- ----------------------------
INSERT INTO `rbac_menu` VALUES (1, NULL, '一级菜单', NULL, NULL, NULL, b'1', b'0');
INSERT INTO `rbac_menu` VALUES (2, 1, '二级菜单', NULL, NULL, NULL, b'1', b'0');
INSERT INTO `rbac_menu` VALUES (3, 2, '三级菜单', NULL, 'http://www.baidu.com', NULL, b'1', b'1');
INSERT INTO `rbac_menu` VALUES (4, NULL, '欢迎', 'glyphicon-home', '/welcome.html', NULL, b'1', b'1');

SET FOREIGN_KEY_CHECKS = 1;
