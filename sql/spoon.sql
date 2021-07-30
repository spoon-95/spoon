/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 42.193.136.50:3306
 Source Schema         : spoon

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 30/07/2021 13:48:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作 sub主子表操作）',
  `package_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (3, 'sys_role_permission', '', NULL, NULL, 'SysRolePermission', 'crud', 'com.wsp.spoon', 'spoon', 'sysRolePermission', NULL, 'spoon', '0', '/', NULL, 'spoon', '2021-07-30 11:54:44', '', NULL, NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (3, '3', 'id', NULL, 'int(11)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'spoon', '2021-07-30 11:54:44', '', NULL);
INSERT INTO `gen_table_column` VALUES (4, '3', 'role_id', '角色id', 'int(11)', 'Long', 'roleId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'spoon', '2021-07-30 11:54:44', '', NULL);
INSERT INTO `gen_table_column` VALUES (5, '3', 'permission_id', '权限id', 'int(11)', 'Long', 'permissionId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'spoon', '2021-07-30 11:54:44', '', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单Id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `href` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `target` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '_self' COMMENT 'target',
  `order_num` int(4) NULL DEFAULT NULL COMMENT '显示顺序',
  `visible` int(1) NULL DEFAULT NULL COMMENT '菜单状态（0显示 1隐藏）',
  `level` int(5) NULL DEFAULT NULL COMMENT '菜单层级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '常规管理', 'fa fa-address-book', NULL, '_self', 1, 0, 1);
INSERT INTO `sys_menu` VALUES (2, 21, '主页模板', 'fa fa-home', NULL, '_self', 1, 0, 2);
INSERT INTO `sys_menu` VALUES (3, 2, '主页一', 'fa fa-tachometer', 'page/welcome-1.html', '_self', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (4, 2, '主页二', 'fa fa-tachometer', 'page/welcome-2.html', '_self', 2, 0, 3);
INSERT INTO `sys_menu` VALUES (5, 2, '主页三', 'fa fa-tachometer', 'page/welcome-3.html', '_self', 3, 0, 3);
INSERT INTO `sys_menu` VALUES (6, 39, '菜单管理', 'fa fa-window-maximize', 'sysMenu/menu', '_self', 2, 0, 2);
INSERT INTO `sys_menu` VALUES (7, 21, '系统设置', 'fa fa-gears', 'page/setting.html', '_self', 3, 0, 2);
INSERT INTO `sys_menu` VALUES (8, 21, '表格示例', 'fa fa-file-text', 'page/table.html', '_self', 4, 0, 2);
INSERT INTO `sys_menu` VALUES (9, 21, '表单示例', 'fa fa-calendar', NULL, '_self', 5, 0, 2);
INSERT INTO `sys_menu` VALUES (10, 9, '普通表单', 'fa fa-list-alt', 'page/form.html', '_self', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (11, 9, '分步表单', 'fa fa-navicon', 'page/form-step.html', '_self', 2, 0, 3);
INSERT INTO `sys_menu` VALUES (12, 21, '登录模板', 'fa fa-flag-o', NULL, '_self', 6, 0, 2);
INSERT INTO `sys_menu` VALUES (13, 12, '登录-1', 'fa fa-stumbleupon-circle', 'page/login-1.html', '_blank', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (14, 12, '登录-2', 'fa fa-viacoin', 'page/login-2.html', '_blank', 2, 0, 3);
INSERT INTO `sys_menu` VALUES (15, 12, '登录-3', 'fa fa-tags', 'page/login-3.html', '_blank', 3, 0, 3);
INSERT INTO `sys_menu` VALUES (16, 21, '异常页面', 'fa fa-home', NULL, '_self', 7, 0, 2);
INSERT INTO `sys_menu` VALUES (17, 16, '404页面', 'fa fa-hourglass-end', 'page/404.html', '_self', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (18, 21, '其它界面', 'fa fa-snowflake-o', NULL, '_self', 8, 0, 2);
INSERT INTO `sys_menu` VALUES (19, 18, '按钮示例', 'fa fa-snowflake-o', 'page/button.html', '_self', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (20, 18, '弹出层', 'fa fa-shield', 'page/layer.html', '_self', 2, 0, 3);
INSERT INTO `sys_menu` VALUES (21, 0, '组件管理', 'fa fa-lemon-o', NULL, '_self', 2, 0, 1);
INSERT INTO `sys_menu` VALUES (22, 21, '图标列表', 'fa fa-dot-circle-o', 'page/icon.html', '_self', 1, 0, 2);
INSERT INTO `sys_menu` VALUES (23, 21, '图标选择', 'fa fa-adn', 'page/icon-picker.html', '_self', 2, 0, 2);
INSERT INTO `sys_menu` VALUES (24, 21, '颜色选择', 'fa fa-dashboard', 'page/color-select.html', '_self', 3, 0, 2);
INSERT INTO `sys_menu` VALUES (25, 21, '下拉选择', 'fa fa-angle-double-down', 'page/table-select.html', '_self', 4, 0, 2);
INSERT INTO `sys_menu` VALUES (26, 21, '文件上传', 'fa fa-arrow-up', 'page/upload.html', '_self', 5, 0, 2);
INSERT INTO `sys_menu` VALUES (27, 21, '富文本编辑器', 'fa fa-edit', 'page/editor.html', '_self', 6, 0, 2);
INSERT INTO `sys_menu` VALUES (28, 21, '省市县区选择器', 'fa fa-rocket', 'page/area.html', '_self', 7, 0, 2);
INSERT INTO `sys_menu` VALUES (29, 0, '其它管理', 'fa fa-slideshare', NULL, '_self', 3, 0, 1);
INSERT INTO `sys_menu` VALUES (30, 29, '多级菜单', 'fa fa-meetup', NULL, '_self', 1, 0, 2);
INSERT INTO `sys_menu` VALUES (31, 30, '按钮1', 'fa fa-calendar', 'page/button.html?v=1', '_self', 1, 0, 3);
INSERT INTO `sys_menu` VALUES (32, 31, '按钮2', 'fa fa-snowflake-o', 'page/button.html?v=2', '_self', 1, 0, 4);
INSERT INTO `sys_menu` VALUES (33, 32, '按钮3', 'fa fa-snowflake-o', 'page/button.html?v=3', '_self', 1, 0, 5);
INSERT INTO `sys_menu` VALUES (34, 32, '表单4', 'fa fa-calendar', 'page/form.html?v=1', '_self', 2, 0, 5);
INSERT INTO `sys_menu` VALUES (35, 29, '失效菜单', 'fa fa-superpowers', 'page/error.html', '_self', 2, 0, 2);
INSERT INTO `sys_menu` VALUES (39, 1, '系统管理', 'fa fa-align-justify', NULL, '_self', 0, 0, 0);
INSERT INTO `sys_menu` VALUES (40, 39, '用户管理', 'fa fa-address-book-o', 'sysUser/user', '_self', 1, 0, 0);
INSERT INTO `sys_menu` VALUES (41, 39, '角色管理', 'fa fa-arrows-alt', 'sysRole/role', '_self', 0, 0, 0);
INSERT INTO `sys_menu` VALUES (42, 39, '代码生成', 'fa fa-500px', 'tool/gen', '_self', 5, 0, 0);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级权限id',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int(3) NULL DEFAULT 0 COMMENT '排序',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '管理员', 1, '2021-07-30 11:34:54', '2021-07-30 11:51:47');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 1);
INSERT INTO `sys_role_menu` VALUES (5, 1);
INSERT INTO `sys_role_menu` VALUES (6, 1);
INSERT INTO `sys_role_menu` VALUES (7, 1);
INSERT INTO `sys_role_menu` VALUES (8, 1);
INSERT INTO `sys_role_menu` VALUES (9, 1);
INSERT INTO `sys_role_menu` VALUES (10, 1);
INSERT INTO `sys_role_menu` VALUES (11, 1);
INSERT INTO `sys_role_menu` VALUES (12, 1);
INSERT INTO `sys_role_menu` VALUES (13, 1);
INSERT INTO `sys_role_menu` VALUES (14, 1);
INSERT INTO `sys_role_menu` VALUES (15, 1);
INSERT INTO `sys_role_menu` VALUES (16, 1);
INSERT INTO `sys_role_menu` VALUES (17, 1);
INSERT INTO `sys_role_menu` VALUES (18, 1);
INSERT INTO `sys_role_menu` VALUES (19, 1);
INSERT INTO `sys_role_menu` VALUES (20, 1);
INSERT INTO `sys_role_menu` VALUES (21, 1);
INSERT INTO `sys_role_menu` VALUES (22, 1);
INSERT INTO `sys_role_menu` VALUES (23, 1);
INSERT INTO `sys_role_menu` VALUES (24, 1);
INSERT INTO `sys_role_menu` VALUES (25, 1);
INSERT INTO `sys_role_menu` VALUES (26, 1);
INSERT INTO `sys_role_menu` VALUES (27, 1);
INSERT INTO `sys_role_menu` VALUES (28, 1);
INSERT INTO `sys_role_menu` VALUES (29, 1);
INSERT INTO `sys_role_menu` VALUES (30, 1);
INSERT INTO `sys_role_menu` VALUES (31, 1);
INSERT INTO `sys_role_menu` VALUES (32, 1);
INSERT INTO `sys_role_menu` VALUES (33, 1);
INSERT INTO `sys_role_menu` VALUES (34, 1);
INSERT INTO `sys_role_menu` VALUES (35, 1);
INSERT INTO `sys_role_menu` VALUES (39, 1);
INSERT INTO `sys_role_menu` VALUES (40, 1);
INSERT INTO `sys_role_menu` VALUES (41, 1);
INSERT INTO `sys_role_menu` VALUES (42, 1);

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `sex` int(255) NULL DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `status` int(1) NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`, `user_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (25, '12138', 'admin', 'a658086ca7fe651456de7f02160cba14', '61612f', '965867965@qq.com', '18702515515', 1, 28, 1, '2021-02-24 03:06:36', '2021-07-30 11:45:05', NULL, 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
