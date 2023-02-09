/*
 Navicat Premium Data Transfer

 Source Server         : 124.221.237.161(云服务)
 Source Server Type    : MySQL
 Source Server Version : 50738 (5.7.38)
 Source Host           : 124.221.237.161:3306
 Source Schema         : hyper

 Target Server Type    : MySQL
 Target Server Version : 50738 (5.7.38)
 File Encoding         : 65001

 Date: 09/02/2023 20:22:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_code_item
-- ----------------------------
DROP TABLE IF EXISTS `t_code_item`;
CREATE TABLE `t_code_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码项ID',
  `item_text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项内容',
  `item_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码项值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `code_id` bigint(20) NULL DEFAULT NULL COMMENT '代码ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码项表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_code_item
-- ----------------------------
INSERT INTO `t_code_item` VALUES (1, '男', 'MALE', NULL, 2, NULL, 1);
INSERT INTO `t_code_item` VALUES (5, '女', 'FEMALE', NULL, 1, '2021-12-06 17:00:28', 1);
INSERT INTO `t_code_item` VALUES (20, '启用', 'VALID', NULL, 2, '2021-12-07 14:13:44', 13);
INSERT INTO `t_code_item` VALUES (21, '禁用', 'LOCK', NULL, 0, '2021-12-07 14:13:50', 13);
INSERT INTO `t_code_item` VALUES (24, 'cx', 'sx', '211', 1, '2023-02-06 13:27:10', 14);
INSERT INTO `t_code_item` VALUES (25, '未知', 'UNKNOWN', NULL, 0, '2023-02-06 13:45:26', 1);
INSERT INTO `t_code_item` VALUES (29, 'test', 'test1', 'ss', 0, '2023-02-06 14:29:27', 13);

-- ----------------------------
-- Table structure for t_code_main
-- ----------------------------
DROP TABLE IF EXISTS `t_code_main`;
CREATE TABLE `t_code_main`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '代码ID',
  `code_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码描述',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_code_main
-- ----------------------------
INSERT INTO `t_code_main` VALUES (1, '性别', '用户性别代码', 0, '2023-02-06 14:22:35');
INSERT INTO `t_code_main` VALUES (13, '状态', '', 0, '2021-12-07 14:13:32');
INSERT INTO `t_code_main` VALUES (14, 'ces', 'sdasda', 1, '2023-02-04 21:06:56');

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门ID',
  `dept_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建者ID',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  `dept_short_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门简称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_dept_parent_id`(`parent_id`) USING BTREE,
  INDEX `t_dept_dept_name`(`dept_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES (57, NULL, '管理部', 123, 11, '2023-01-10 16:21:40', NULL, 0, '管理', '没有');
INSERT INTO `t_dept` VALUES (58, 57, '管理1部', 234, 1, NULL, '2023-01-11 13:59:21', 0, '1部', 'hhhhgggg');
INSERT INTO `t_dept` VALUES (59, 58, '她她她', 123, NULL, '2023-01-11 14:19:32', '2023-01-11 14:19:32', 1, 'qqq', '4qwwa');
INSERT INTO `t_dept` VALUES (60, 0, 'ddd', 123, 0, '2023-01-11 15:41:29', '2023-01-11 15:41:29', 0, '1', '23');
INSERT INTO `t_dept` VALUES (61, 0, 'ddd', 123, NULL, '2023-01-11 15:43:02', '2023-01-11 15:43:02', 0, '11', 'qwe');
INSERT INTO `t_dept` VALUES (62, 0, 'wqe', 123, NULL, '2023-01-11 15:43:23', '2023-01-11 15:43:23', 0, 'asd', 'xcz');
INSERT INTO `t_dept` VALUES (63, 0, 'asd', 123, NULL, '2023-01-11 15:45:03', '2023-01-11 15:44:58', 0, 'ads', 'zxc');
INSERT INTO `t_dept` VALUES (64, NULL, 'jjjjjj', 123, 88, '2023-01-11 15:45:30', '2023-01-11 15:45:42', 0, 'uu', 'u');
INSERT INTO `t_dept` VALUES (65, 57, '管理2部', 123, NULL, '2023-01-13 15:56:24', '2023-01-13 15:56:24', 0, NULL, NULL);

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `login_time` datetime NOT NULL COMMENT '登录时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `system` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_login_log_login_time`(`login_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 815 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '登录日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES (814, 'test', '2023-02-06 17:51:30', 'test1', '12', 'ds', 'qwe');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件地址',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `is_expand` int(11) NULL DEFAULT 0 COMMENT '是否默认展开',
  `redirect` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重定向地址',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单标题',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `hidden` int(1) NULL DEFAULT 0 COMMENT '是否隐藏',
  `bread_crumb` int(1) NULL DEFAULT 1 COMMENT '面包屑',
  `always_show` int(1) NULL DEFAULT NULL COMMENT '是否公开',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '是否删除',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序号',
  `type` int(11) NULL DEFAULT NULL COMMENT '（1、目录，2、菜单，3、按钮）',
  `request_method` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `t_menu_tk`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 160 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '/', 'Layout', 'home', 0, '/user', 'Home', 'ri-bar-chart-line', NULL, 0, 1, 1, NULL, '2021-12-13 10:10:19', 0, 9, 1, 'GET');
INSERT INTO `t_menu` VALUES (2, '/dashboard', 'dashboard/index3', 'Dashboard', 0, '', 'Dashboard', 'mdi mdi-bullhorn-variant', 1, 1, 1, 1, NULL, '2023-02-02 19:58:03', 0, 1, 2, 'GET');
INSERT INTO `t_menu` VALUES (3, '/system', 'Layout', 'System', 1, '/user', '系统管理', 'mdi mdi-bullhorn-variant', NULL, 0, 1, 1, NULL, '2023-02-07 14:58:01', 0, 8, 1, 'GET');
INSERT INTO `t_menu` VALUES (5, '/user', 'system/user/index', 'user', 0, NULL, '用户管理', 'mdi mdi-account', 3, 0, 1, 1, NULL, '2023-02-03 15:39:11', 0, 7, 2, 'GET');
INSERT INTO `t_menu` VALUES (6, '/menu', 'system/menu/index', 'menu', 1, NULL, '菜单管理', 'mdi mdi-air-filter', 3, 0, 1, 1, NULL, '2023-02-03 16:14:28', 0, 4, 2, 'GET');
INSERT INTO `t_menu` VALUES (7, '/dept', 'dashboard/index', 'dept', 0, '', '部门管理', 'bx-sitemap', 1, 1, 1, 1, NULL, '2023-02-02 19:58:02', 0, 8, 2, 'GET');
INSERT INTO `t_menu` VALUES (11, '/monitor', 'Layout', 'Monitor', 0, '', '系统监控', 'bx-webcam', 3, 0, 1, 1, NULL, '2022-12-16 16:09:55', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (75, '/operation', 'monitor/operation-log/index', '', 0, '', '操作日志', '', 11, 0, 1, 1, '2021-11-23 15:42:18', '2021-11-23 15:42:41', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (76, '/login', 'monitor/login-log/index', 'LoginLog', 0, '', '登陆日志', '', 11, 0, 1, 1, '2021-11-23 15:46:26', '2021-11-23 15:46:40', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (77, '/active', 'monitor/active/index', 'Active', 0, '', '在线用户', '', 11, 0, 1, 1, '2021-11-24 13:30:50', '2021-11-24 13:31:17', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (83, '/metadata', 'Layout', 'nnb', 0, '', '元数据管理', 'mdi mdi-access-point-remove', NULL, 0, 1, 1, '2021-12-03 15:53:16', '2023-02-07 14:58:08', 0, 7, 1, 'GET');
INSERT INTO `t_menu` VALUES (84, '/systemConfig', 'metadata/systemConfig/index', 'systemConfig', 0, '', '系统参数', 'mdi mdi-air-filter', 83, 0, 1, 1, '2021-12-03 15:55:42', '2023-02-04 13:52:48', 0, 9, 2, 'GET');
INSERT INTO `t_menu` VALUES (85, '/codeMain', 'metadata/codeMain/index', 'ccc', 0, '', '代码管理', 'mdi mdi-account-details', 83, 0, 1, 1, '2021-12-03 15:56:26', '2023-02-04 21:03:47', 0, 8, 2, 'GET');
INSERT INTO `t_menu` VALUES (88, '/other', 'Layout', '', 0, '', '其他管理', 'bx-list-plus', NULL, 0, 1, 0, '2021-12-10 16:44:02', '2023-02-02 18:14:45', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (89, '/theme', 'other/theme/index', '', 0, '', '主题管理', 'bxs-layer', 88, 0, 1, 1, '2021-12-10 16:45:26', '2021-12-17 11:07:09', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (91, '/base', 'Layout', 'nnnmm', 0, '', '基础组件', 'mdi mdi-access-point-network', NULL, 0, 1, 1, '2021-12-17 13:07:08', '2022-12-16 10:41:44', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (92, '/menu', 'menu/index', 'menu', 0, '', '个人简介', '', 2, 0, 1, 1, '2021-12-17 13:07:56', '2021-12-20 10:32:40', 1, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (105, '/tet', 'menu/index', 'tet', 0, '', 'tet', 'mdi mdi-bullhorn-variant', 2, 1, 1, 1, '2022-12-07 10:36:37', '2022-12-07 10:36:37', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (106, '/tst', 'menu/index', 'ttt', 0, '', 'tst', 'mdi mdi-bullhorn-variant', 2, 0, 1, 1, '2022-12-07 10:37:54', '2022-12-07 10:37:54', 1, 3, 1, 'GET');
INSERT INTO `t_menu` VALUES (107, '/txt', 'menu/index', 'ee', 0, '', 'txt', 'mdi mdi-abjad-hebrew', 2, 0, 1, 1, '2022-12-07 13:06:43', '2022-12-07 13:06:43', 1, 2, 1, 'GET');
INSERT INTO `t_menu` VALUES (108, 'tess', 'tee', 'ttt', 0, 'sss', 'test1', 'mdi mdi-access-point-network-off', 2, 1, 1, 1, '2022-12-08 11:07:09', '2022-12-08 11:07:09', 1, 111, 1, 'GET');
INSERT INTO `t_menu` VALUES (109, '/person', 'menu/index', 'person', 0, '', '个人', 'mdi mdi-account-alert', 2, 0, 1, 1, '2022-12-08 19:58:51', '2022-12-08 19:58:51', 1, 1, 1, 'GET');
INSERT INTO `t_menu` VALUES (113, '/test', 'Layout', 'mytest', 0, 'test', 'mytest', 'mdi mdi-access-point-minus', NULL, 1, 1, 1, '2022-12-08 21:02:51', '2022-12-16 10:40:26', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (116, 'v', 'Layout', 'vv', 0, 'v', 'vvvv', '', NULL, 0, 1, 1, '2022-12-09 22:31:30', '2022-12-09 22:31:30', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (117, '/vg', 'Layout', 'vvg', 0, 'vg', 'vvvvggg', '', NULL, 1, 1, 1, '2022-12-09 22:31:44', '2022-12-16 10:40:06', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (118, 'vcx', 'Layout', 'cvx', 0, 'xv', 'vcx', 'mdi mdi-abjad-arabic', NULL, 0, 1, 1, '2022-12-09 23:21:33', '2022-12-09 23:21:33', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (119, '/x', 'Layout', 's', 0, 'c', 'xx', 'mdi mdi-abugida-thai', NULL, 1, 1, 1, '2022-12-09 23:35:17', '2022-12-16 11:00:30', 1, NULL, 1, 'GET');
INSERT INTO `t_menu` VALUES (125, '/sss', 'sss', 'xxxx', 0, 'xxx', 'tesss', 'mdi mdi-abjad-arabic', 88, 1, 1, 1, '2022-12-10 18:49:04', '2022-12-16 10:34:12', 1, 11, 2, 'GET');
INSERT INTO `t_menu` VALUES (126, 'qq', 'qqqq', 'q', 0, '22', 'qqqq', '', 88, 0, 1, 1, '2022-12-10 18:54:53', '2022-12-10 18:54:53', 1, 111, 2, 'GET');
INSERT INTO `t_menu` VALUES (127, 'qq', 'qqqq', 'q', 0, '22', 'qqqq', '', 88, 0, 1, 1, '2022-12-10 19:25:15', '2022-12-10 19:25:15', 1, 111, 2, 'GET');
INSERT INTO `t_menu` VALUES (131, 'ads', 'Layout', 'sad', 0, '', 'sasadsdcccxxx', 'mdi mdi-account-alert', 119, 0, 1, 1, '2022-12-10 23:09:12', '2022-12-11 16:35:54', 1, NULL, 2, 'GET');
INSERT INTO `t_menu` VALUES (134, '/tyuio', 'Layout', 'yy', 0, '', 'yyyyy', 'mdi mdi-access-point-network', 5, 1, 1, 1, '2022-12-13 22:09:22', '2022-12-14 13:33:15', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (135, '/tyuio', 'menu/index', 'yy', 0, '', 'yyyyynn', 'mdi mdi-access-point-network', 8, 0, 1, 1, '2022-12-13 22:09:43', '2022-12-13 22:09:43', 0, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (136, '/fghj', 'Layout', 'j', 0, '', 'nnn', 'mdi mdi-access-point-minus', NULL, 1, 1, 1, '2022-12-13 22:12:51', '2022-12-14 13:32:14', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (137, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjj', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:16', '2022-12-13 22:13:16', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (138, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjjkkk', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:39', '2022-12-13 22:13:39', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (139, 'fghj', 'Layout', 'j', 0, '', 'nnnjjjjkkkllll', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-13 22:13:58', '2022-12-13 22:13:58', 1, 3, 1, 'GET');
INSERT INTO `t_menu` VALUES (140, '/as', 'Layout', 'cx', 0, '', 'asd', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:08:50', '2022-12-16 10:40:48', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (141, '/ascc', 'Layout', 'cx', 0, '', 'asdccc', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:09:20', '2022-12-14 13:09:20', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (142, '/asccx', 'Layout', 'cx', 0, '/test', 'asdcccxx', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2022-12-14 13:09:46', '2022-12-16 10:33:05', 1, 6, 1, 'GET');
INSERT INTO `t_menu` VALUES (143, '/cc', 'Layout', 'cc', 0, 'cc', 'cc', 'mdi mdi-access-point-minus', NULL, 0, 1, 0, '2022-12-16 11:16:46', '2022-12-16 15:49:06', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (144, '/xx', 'Layout', 'xx', 0, 'xx', 'xxx', 'mdi mdi-access-point-network', NULL, 0, 1, 1, '2022-12-16 11:17:07', '2022-12-16 11:17:07', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (146, '/test', 'Layout', 'test', 0, '', 'test', 'mdi mdi-account-alert-outline', NULL, 0, 1, 1, '2023-01-04 15:00:43', '2023-01-04 15:00:43', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (147, '/role', 'system/role/index', 'role', 0, '', '角色管理', 'mdi mdi-account-box-multiple-outline', 3, 0, 1, 1, '2023-01-06 14:25:29', '2023-02-03 21:30:39', 0, 5, 2, 'GET');
INSERT INTO `t_menu` VALUES (148, '/333', 'Layout', '222', 0, NULL, '111444', 'mdi mdi-access-point-network', NULL, 1, 1, 1, '2023-01-06 17:28:13', '2023-01-06 17:28:35', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (149, '/dept', 'system/dept/index', 'dept', 0, NULL, '部门管理', 'mdi mdi-account-details-outline', 3, 0, 1, 1, '2023-01-10 14:52:13', '2023-02-03 15:39:18', 0, 6, 2, 'GET');
INSERT INTO `t_menu` VALUES (150, '/dddxx', NULL, NULL, 0, NULL, 'ddd', NULL, 1, 0, 1, 1, '2023-02-02 20:57:39', '2023-02-02 20:57:39', 1, 5, 3, 'POST');
INSERT INTO `t_menu` VALUES (151, '/test', 'Layout', 'ccc', 0, NULL, 'cccc', 'mdi mdi-access-point-minus', NULL, 0, 1, 1, '2023-02-02 20:59:58', '2023-02-02 20:59:58', 1, 0, 1, 'GET');
INSERT INTO `t_menu` VALUES (152, '/api/system/user', NULL, NULL, 0, NULL, '添加用户', NULL, 5, 0, 1, 1, '2023-02-03 09:37:48', '2023-02-03 14:34:27', 0, 9, 3, 'POST');
INSERT INTO `t_menu` VALUES (153, '/api/system/user/page', NULL, NULL, 0, NULL, '用户列表', NULL, 5, 0, 1, 1, '2023-02-03 14:30:19', '2023-02-03 16:11:21', 0, 10, 3, 'GET');
INSERT INTO `t_menu` VALUES (156, '/metadata', 'Layout', 'metadata', 0, NULL, '元数据管理', 'mdi mdi-air-filter', NULL, 0, 1, 1, '2023-02-04 13:49:10', '2023-02-04 13:49:10', 1, 8, 1, 'GET');
INSERT INTO `t_menu` VALUES (157, '/monitor', 'Layout', 'monitor', 0, NULL, '系统监控', 'mdi mdi-adjust', NULL, 0, 1, 1, '2023-02-06 17:44:24', '2023-02-07 14:58:12', 0, 6, 1, 'GET');
INSERT INTO `t_menu` VALUES (158, '/loginLog', 'monitor/loginLog/index', 'loginLog', 0, NULL, '登录日志', 'mdi mdi-account-box-multiple-outline', 157, 0, 1, 1, '2023-02-06 17:45:16', '2023-02-06 17:46:19', 0, 0, 2, 'GET');
INSERT INTO `t_menu` VALUES (159, '/operateLog', 'monitor/operateLog/index', 'operateLog', 0, NULL, '操作日志', 'mdi mdi-account-check', 157, 0, 1, 1, '2023-02-06 17:45:48', '2023-02-06 17:45:48', 0, 0, 2, 'GET');

-- ----------------------------
-- Table structure for t_menu_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_permission`;
CREATE TABLE `t_menu_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '按钮ID',
  `permission_id` bigint(20) NULL DEFAULT NULL COMMENT '权限ID',
  `permission_type` bigint(20) NULL DEFAULT NULL COMMENT '权限类别（1、角色，2、部门，3、用户）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 500 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu_permission
-- ----------------------------
INSERT INTO `t_menu_permission` VALUES (438, 142, 40, 1);
INSERT INTO `t_menu_permission` VALUES (439, 142, 42, 1);
INSERT INTO `t_menu_permission` VALUES (440, 142, 43, 1);
INSERT INTO `t_menu_permission` VALUES (441, 142, 44, 1);
INSERT INTO `t_menu_permission` VALUES (442, 142, 58, 2);
INSERT INTO `t_menu_permission` VALUES (443, 142, 64, 2);
INSERT INTO `t_menu_permission` VALUES (444, 142, 113, 3);
INSERT INTO `t_menu_permission` VALUES (445, 142, 114, 3);
INSERT INTO `t_menu_permission` VALUES (460, 1, 43, 1);
INSERT INTO `t_menu_permission` VALUES (461, 1, 44, 1);
INSERT INTO `t_menu_permission` VALUES (462, 1, 58, 2);
INSERT INTO `t_menu_permission` VALUES (463, 1, 65, 2);
INSERT INTO `t_menu_permission` VALUES (464, 1, 113, 3);
INSERT INTO `t_menu_permission` VALUES (477, 3, 40, 1);
INSERT INTO `t_menu_permission` VALUES (478, 3, 42, 1);
INSERT INTO `t_menu_permission` VALUES (479, 3, 57, 2);
INSERT INTO `t_menu_permission` VALUES (480, 3, 58, 2);
INSERT INTO `t_menu_permission` VALUES (481, 3, 65, 2);
INSERT INTO `t_menu_permission` VALUES (482, 3, 64, 2);
INSERT INTO `t_menu_permission` VALUES (483, 3, 113, 3);
INSERT INTO `t_menu_permission` VALUES (484, 3, 114, 3);
INSERT INTO `t_menu_permission` VALUES (485, 3, 115, 3);
INSERT INTO `t_menu_permission` VALUES (486, 3, 116, 3);
INSERT INTO `t_menu_permission` VALUES (487, 3, 117, 3);
INSERT INTO `t_menu_permission` VALUES (488, 3, 118, 3);
INSERT INTO `t_menu_permission` VALUES (489, 3, 119, 3);
INSERT INTO `t_menu_permission` VALUES (490, 3, 120, 3);
INSERT INTO `t_menu_permission` VALUES (493, 85, 123, 3);
INSERT INTO `t_menu_permission` VALUES (495, 88, 43, 1);
INSERT INTO `t_menu_permission` VALUES (499, 152, 113, 3);

-- ----------------------------
-- Table structure for t_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operate_log`;
CREATE TABLE `t_operate_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `operation` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作内容',
  `time` decimal(11, 0) NULL DEFAULT NULL COMMENT '耗时',
  `method` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作方法',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '方法参数',
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者IP',
  `operate_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_log_create_time`(`operate_time`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2196 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_operate_log
-- ----------------------------
INSERT INTO `t_operate_log` VALUES (2195, 'asd', 'qwe', 3, 'sda', 'wqe', '123', '2023-02-06 17:51:58', 'sad');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色标签',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '角色状态',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (40, '局长角色', 'test', 2, 1, 'dadaadda', NULL, '2023-01-13 13:16:24', 0);
INSERT INTO `t_role` VALUES (41, 'test2', '4444', 3, 0, 'dddddd', NULL, '2023-01-09 16:49:29', 1);
INSERT INTO `t_role` VALUES (42, '领导角色', '试试', NULL, 1, NULL, '2023-01-09 16:13:53', '2023-01-13 13:16:31', 0);
INSERT INTO `t_role` VALUES (43, '信息', 'zz', NULL, 1, NULL, '2023-01-09 16:14:58', '2023-01-09 16:14:58', 0);
INSERT INTO `t_role` VALUES (44, 'dsa', 'qwe', NULL, 0, 'zxcxxz', '2023-01-09 16:15:05', '2023-02-06 14:29:44', 0);
INSERT INTO `t_role` VALUES (45, 'ccc', 'ccc', 77, 0, 'cccc', '2023-01-09 16:16:47', '2023-01-09 16:16:47', 1);
INSERT INTO `t_role` VALUES (46, 'x', 's', 0, 1, 'cc', '2023-02-06 13:42:27', '2023-02-06 13:42:27', 1);

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
  `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置值',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `order_num` bigint(20) NULL DEFAULT NULL COMMENT '排序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_system_config
-- ----------------------------
INSERT INTO `t_system_config` VALUES (1, 'sessionExpireTime', '3600', '系统不操作过期时间', 9, NULL);
INSERT INTO `t_system_config` VALUES (2, 'resetPassword', '11111', '初始和重置密码', 0, '2021-12-17 09:16:25');
INSERT INTO `t_system_config` VALUES (5, 'd', 'x', '1wqe', 0, '2023-02-04 19:45:29');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示名称',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 0锁定 1有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近访问时间',
  `deleted` tinyint(4) NULL DEFAULT 0 COMMENT '删除标志',
  `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_user_username`(`username`) USING BTREE,
  INDEX `t_user_mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 135 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (113, '1234', '234', 1, '83428190@qq.com', '13218133416', '谢裕东', 'https://coderthemes.com/hyper_2/saas/assets/images/users/avatar-2.jpg', '678', 57, 1, '2022-12-16 17:35:58', '2023-02-02 18:15:13', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (114, '123', '234', 0, '2', '3', '王大苗', 'https://coderthemes.com/hyper_2/saas/assets/images/users/avatar-2.jpg', '6', 64, 0, '2022-12-16 17:35:58', '2022-12-16 17:36:44', '2022-12-16 17:36:41', 0, 1);
INSERT INTO `t_user` VALUES (115, 'asd', 'xz', 1, '12', '132456', 'weqsss', 'https://coderthemes.com/hyper_2/saas/assets/images/users/avatar-2.jpg', 'sad', 58, 0, '2022-12-25 20:43:13', '2023-02-02 13:06:58', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (116, 'hh', 'aa', 1, '234', '132', '刘宇东', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2022-12-28/1672233040634619.jpg', '1213', 57, 1, '2022-12-28 21:14:11', '2022-12-28 21:14:11', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (117, 'dd', 'ww', 1, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, 1, '2023-01-04 14:50:17', '2023-01-04 14:50:17', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (118, 'dd', 'ww', 2, '123', '132', 'qw', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1', 57, 1, '2023-01-04 14:51:30', '2023-01-04 14:51:30', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (119, 'mmnn', 'ggg', 0, '123', '132', '11', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672815349361169.jpg', 'rrrr', 57, 1, '2023-01-04 14:56:21', '2023-01-04 14:56:21', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (120, 'dda', '12', 1, '123', '123', 'wqe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '', 57, 1, '2023-01-04 15:11:25', '2023-01-04 15:11:25', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (121, 'xx', 'cc', 0, '456', '234567', 'aa', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-4/1672817212675451.jpg', '23', 57, 0, '2023-01-04 15:19:59', '2023-02-06 14:20:24', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (122, 'dd', 'ww', 1, '22', '11', 'xzc', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-6/1672997469947183.jpg', '111', 57, 1, '2023-01-06 17:31:02', '2023-01-06 17:31:12', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (123, 'd', 's', 0, '2', '1', 'w', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '1111', 64, 1, '2023-01-06 17:31:24', '2023-02-03 16:28:46', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (124, 'hgfd', 'hgf', 0, '1234', '123', 'hgf', 'https://since-hyper.oss-cn-nanjing.aliyuncs.com/images/2023-1-11/1673422311749878.jpg', 'jjjjj', 57, 1, '2023-01-11 15:30:13', '2023-01-11 15:31:54', NULL, 1, NULL);
INSERT INTO `t_user` VALUES (125, 'hjhh', 'yyy', 0, '55@qq.com', '13218133416', '234', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', NULL, 57, 1, '2023-02-01 13:29:16', '2023-02-01 13:29:16', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (126, 'ggg', 'fff', 0, '4213@qq.com', '1232', 'eeqwe', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'ggg', 57, 1, '2023-02-01 17:54:05', '2023-02-01 17:54:05', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (128, 'ddd', 'dd', 0, '12', '123', 'www', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', '132213', 57, 1, '2023-02-02 09:56:52', '2023-02-02 09:56:52', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (129, 'qqqq', 'sss', 0, '123', '132', 'ddd', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dd', 65, 1, '2023-02-02 18:11:01', '2023-02-02 18:11:13', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (130, 'VVV', 'VVV', 0, '234', '123', 'VVV', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'GGG', 57, 1, '2023-02-03 14:12:50', '2023-02-03 14:12:50', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (131, 'bb', 'cc', 0, '234', '123', 'sd', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'sda', 57, 1, '2023-02-03 14:13:14', '2023-02-03 14:13:14', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (132, 'zxc', 'sad', 0, '321', '123', 'we', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dsa', 57, 1, '2023-02-03 14:20:43', '2023-02-03 14:20:43', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (133, 'hg', 'hg', 0, '32', '123', '123', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'dsa', 57, 1, '2023-02-03 14:25:43', '2023-02-03 14:25:43', NULL, 0, NULL);
INSERT INTO `t_user` VALUES (134, 'cdcc', 'ccc', 0, '321', '123', 'ccc', 'https://preview.keenthemes.com/craft/assets/media/avatars/300-1.jpg', 'ddd', 57, 1, '2023-02-06 14:26:56', '2023-02-06 14:27:10', NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 275 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (247, 128, 40);
INSERT INTO `t_user_role` VALUES (248, 128, 42);
INSERT INTO `t_user_role` VALUES (249, 128, 43);
INSERT INTO `t_user_role` VALUES (250, 129, 40);
INSERT INTO `t_user_role` VALUES (251, 129, 42);
INSERT INTO `t_user_role` VALUES (252, 129, 40);
INSERT INTO `t_user_role` VALUES (253, 129, 42);
INSERT INTO `t_user_role` VALUES (255, 130, 40);
INSERT INTO `t_user_role` VALUES (256, 131, 40);
INSERT INTO `t_user_role` VALUES (257, 132, 40);
INSERT INTO `t_user_role` VALUES (258, 133, 40);
INSERT INTO `t_user_role` VALUES (261, 123, 40);
INSERT INTO `t_user_role` VALUES (262, 123, 42);
INSERT INTO `t_user_role` VALUES (263, 123, 43);
INSERT INTO `t_user_role` VALUES (266, 121, 42);
INSERT INTO `t_user_role` VALUES (267, 121, 40);
INSERT INTO `t_user_role` VALUES (268, 121, 43);
INSERT INTO `t_user_role` VALUES (273, 134, 40);
INSERT INTO `t_user_role` VALUES (274, 134, 42);

SET FOREIGN_KEY_CHECKS = 1;
