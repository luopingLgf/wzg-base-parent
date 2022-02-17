/*
 Navicat Premium Data Transfer

 Source Server         : 本地-mysql-root
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : wzg_base_system

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 16/02/2022 10:38:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_authority
-- ----------------------------
DROP TABLE IF EXISTS `c_authority`;
CREATE TABLE `c_authority`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_authority
-- ----------------------------

-- ----------------------------
-- Table structure for c_gateway_route
-- ----------------------------
DROP TABLE IF EXISTS `c_gateway_route`;
CREATE TABLE `c_gateway_route`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '路由表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_gateway_route
-- ----------------------------

-- ----------------------------
-- Table structure for c_gateway_uri
-- ----------------------------
DROP TABLE IF EXISTS `c_gateway_uri`;
CREATE TABLE `c_gateway_uri`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'Uri路径表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_gateway_uri
-- ----------------------------

-- ----------------------------
-- Table structure for c_menu
-- ----------------------------
DROP TABLE IF EXISTS `c_menu`;
CREATE TABLE `c_menu`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_menu
-- ----------------------------

-- ----------------------------
-- Table structure for c_role
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_role
-- ----------------------------

-- ----------------------------
-- Table structure for c_sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `c_sys_dic`;
CREATE TABLE `c_sys_dic`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_sys_dic
-- ----------------------------

-- ----------------------------
-- Table structure for c_sys_setting
-- ----------------------------
DROP TABLE IF EXISTS `c_sys_setting`;
CREATE TABLE `c_sys_setting`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_sys_setting
-- ----------------------------

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------

-- ----------------------------
-- Table structure for t_black_ip
-- ----------------------------
DROP TABLE IF EXISTS `t_black_ip`;
CREATE TABLE `t_black_ip`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'IP黑名单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_black_ip
-- ----------------------------

-- ----------------------------
-- Table structure for t_file_data
-- ----------------------------
DROP TABLE IF EXISTS `t_file_data`;
CREATE TABLE `t_file_data`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_file_data
-- ----------------------------

-- ----------------------------
-- Table structure for t_file_record
-- ----------------------------
DROP TABLE IF EXISTS `t_file_record`;
CREATE TABLE `t_file_record`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_file_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_log_access
-- ----------------------------
DROP TABLE IF EXISTS `t_log_access`;
CREATE TABLE `t_log_access`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '访问日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_log_access
-- ----------------------------

-- ----------------------------
-- Table structure for t_log_error
-- ----------------------------
DROP TABLE IF EXISTS `t_log_error`;
CREATE TABLE `t_log_error`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '错误日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_log_error
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_account
-- ----------------------------
DROP TABLE IF EXISTS `t_role_account`;
CREATE TABLE `t_role_account`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色账号关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_account
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
