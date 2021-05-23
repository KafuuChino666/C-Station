/*
 Navicat MySQL Data Transfer

 Source Server         : 8.131.121.227
 Source Server Type    : MySQL
 Source Server Version : 50651
 Source Host           : 8.131.121.227:3306
 Source Schema         : o0u0o

 Target Server Type    : MySQL
 Target Server Version : 50651
 File Encoding         : 65001

 Date: 23/05/2021 21:35:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for acl_menu
-- ----------------------------
DROP TABLE IF EXISTS `acl_menu`;
CREATE TABLE `acl_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级ID',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `level` int(4) NULL DEFAULT NULL COMMENT '菜单级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '菜单排序',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端名称',
  `icon` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端图标',
  `hidden` int(1) NULL DEFAULT NULL COMMENT '前端隐藏',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1386270670562488322 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_menu
-- ----------------------------
INSERT INTO `acl_menu` VALUES (1386268880530010114, 1, '权限', 1, 1, '权限', 'el-icon-unlock', 0, '2021-04-25 18:40:31', '2021-04-25 18:40:31');
INSERT INTO `acl_menu` VALUES (1386269146201419777, 1386268880530010114, '员工列表', 2, 1, '员工列表', 'el-icon-unlock', 0, '2021-04-25 18:41:35', '2021-04-25 18:41:35');
INSERT INTO `acl_menu` VALUES (1386270399509786626, 1386268880530010114, '角色列表', 2, 1, '角色列表', 'el-icon-unlock', 0, '2021-04-25 18:46:34', '2021-04-25 18:46:34');
INSERT INTO `acl_menu` VALUES (1386270584977715202, 1386268880530010114, '菜单列表', 2, 1, '菜单列表', 'el-icon-unlock', 0, '2021-04-25 18:47:18', '2021-04-25 18:47:18');
INSERT INTO `acl_menu` VALUES (1386270670562488321, 1386268880530010114, '资源列表', 2, 1, '资源列表', 'el-icon-unlock', 0, '2021-04-25 18:47:38', '2021-04-25 18:47:38');

-- ----------------------------
-- Table structure for acl_resource
-- ----------------------------
DROP TABLE IF EXISTS `acl_resource`;
CREATE TABLE `acl_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1386266680416243714 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_resource
-- ----------------------------
INSERT INTO `acl_resource` VALUES (1386266680416243713, '权限管理', '/admin/acl/**', '管理员权限管理', '2021-04-25 18:31:47', '2021-04-25 18:31:47');

-- ----------------------------
-- Table structure for acl_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_role`;
CREATE TABLE `acl_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(1) NULL DEFAULT 1 COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) NULL DEFAULT 0,
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_role
-- ----------------------------
INSERT INTO `acl_role` VALUES (14, '权限管理', '权限管理', 1, 0, NULL, NULL);
INSERT INTO `acl_role` VALUES (15, '超管', '超管', 1, 0, NULL, NULL);

-- ----------------------------
-- Table structure for acl_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `acl_role_menu`;
CREATE TABLE `acl_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1386272024068603911 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_role_menu
-- ----------------------------
INSERT INTO `acl_role_menu` VALUES (1384482378024169474, 2, 3, '2021-04-20 20:21:36', '2021-04-20 20:21:36');
INSERT INTO `acl_role_menu` VALUES (1384482404800606209, 3, 5, '2021-04-20 20:21:42', '2021-04-20 20:21:42');
INSERT INTO `acl_role_menu` VALUES (1384482404800606210, 3, 6, '2021-04-20 20:21:42', '2021-04-20 20:21:42');
INSERT INTO `acl_role_menu` VALUES (1385210998791208961, 1, 1381954726742663170, '2021-04-22 20:36:53', '2021-04-22 20:36:53');
INSERT INTO `acl_role_menu` VALUES (1385212343745200130, 11, 1381954726742663170, '2021-04-22 20:42:13', '2021-04-22 20:42:13');
INSERT INTO `acl_role_menu` VALUES (1385214115356295169, 12, 1381954726742663170, '2021-04-22 20:49:16', '2021-04-22 20:49:16');
INSERT INTO `acl_role_menu` VALUES (1385214921824485378, 13, 1381954726742663170, '2021-04-22 20:52:28', '2021-04-22 20:52:28');
INSERT INTO `acl_role_menu` VALUES (1386271931898773505, 14, 1386268880530010114, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_menu` VALUES (1386271931898773506, 14, 1386269146201419777, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_menu` VALUES (1386271931898773507, 14, 1386270399509786626, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_menu` VALUES (1386271931898773508, 14, 1386270584977715202, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_menu` VALUES (1386271931898773509, 14, 1386270670562488321, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_menu` VALUES (1386272024068603906, 15, 1386268880530010114, '2021-04-25 18:53:01', '2021-04-25 18:53:01');
INSERT INTO `acl_role_menu` VALUES (1386272024068603907, 15, 1386269146201419777, '2021-04-25 18:53:01', '2021-04-25 18:53:01');
INSERT INTO `acl_role_menu` VALUES (1386272024068603908, 15, 1386270399509786626, '2021-04-25 18:53:01', '2021-04-25 18:53:01');
INSERT INTO `acl_role_menu` VALUES (1386272024068603909, 15, 1386270584977715202, '2021-04-25 18:53:01', '2021-04-25 18:53:01');
INSERT INTO `acl_role_menu` VALUES (1386272024068603910, 15, 1386270670562488321, '2021-04-25 18:53:01', '2021-04-25 18:53:01');

-- ----------------------------
-- Table structure for acl_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `acl_role_resource`;
CREATE TABLE `acl_role_resource`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1386272024727109635 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_role_resource
-- ----------------------------
INSERT INTO `acl_role_resource` VALUES (1384482303176814593, 1, 1381232121496690689, '2021-04-20 20:21:18', '2021-04-20 20:21:18');
INSERT INTO `acl_role_resource` VALUES (1384482307022991361, 2, 1384470452808400898, '2021-04-20 20:21:19', '2021-04-20 20:21:19');
INSERT INTO `acl_role_resource` VALUES (1385209786280837122, 1, 1384470452808400898, '2021-04-22 20:32:04', '2021-04-22 20:32:04');
INSERT INTO `acl_role_resource` VALUES (1385211003664990209, 1, 1384470452808400898, '2021-04-22 20:36:54', '2021-04-22 20:36:54');
INSERT INTO `acl_role_resource` VALUES (1385212344001052674, 11, 1384470452808400898, '2021-04-22 20:42:13', '2021-04-22 20:42:13');
INSERT INTO `acl_role_resource` VALUES (1385214115620536322, 2, 1384470452808400898, '2021-04-22 20:49:16', '2021-04-22 20:49:16');
INSERT INTO `acl_role_resource` VALUES (1385214922084532225, 13, 1384470452808400898, '2021-04-22 20:52:28', '2021-04-22 20:52:28');
INSERT INTO `acl_role_resource` VALUES (1386271932615999490, 14, 1386266680416243713, '2021-04-25 18:52:39', '2021-04-25 18:52:39');
INSERT INTO `acl_role_resource` VALUES (1386272024727109634, 15, 1386266680416243713, '2021-04-25 18:53:01', '2021-04-25 18:53:01');

-- ----------------------------
-- Table structure for acl_staff
-- ----------------------------
DROP TABLE IF EXISTS `acl_staff`;
CREATE TABLE `acl_staff`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `status` int(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0：禁用；1：启用',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_staff
-- ----------------------------
INSERT INTO `acl_staff` VALUES (9, 'admin', '96e79218965eb72c92a549dd5a330112', '233', '1', '13992244829', '1', '1', 1, '2021-04-25 19:42:33', '2021-04-25 19:42:41');
INSERT INTO `acl_staff` VALUES (10, '2', 'c4ca4238a0b923820dcc509a6f75849b', '233', '1', '13992244829', '1', '1', 1, '2021-04-25 20:38:27', '2021-04-25 20:39:24');

-- ----------------------------
-- Table structure for acl_staff_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_staff_role`;
CREATE TABLE `acl_staff_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staff_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1380515672213880838 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of acl_staff_role
-- ----------------------------
INSERT INTO `acl_staff_role` VALUES (1380515672213880837, 9, 14, '2021-04-25 19:44:30', '2021-04-25 19:44:32');

-- ----------------------------
-- Table structure for b_ban_cause
-- ----------------------------
DROP TABLE IF EXISTS `b_ban_cause`;
CREATE TABLE `b_ban_cause`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ban_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封禁原因',
  `gmt_create` datetime NOT NULL COMMENT '封禁时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_ban_cause
-- ----------------------------

-- ----------------------------
-- Table structure for b_ban_info
-- ----------------------------
DROP TABLE IF EXISTS `b_ban_info`;
CREATE TABLE `b_ban_info`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `ban_type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封禁类型',
  `ban_cause_id` int(10) UNSIGNED NOT NULL,
  `ban_time` datetime NOT NULL COMMENT '封禁时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ban_cause_id`(`ban_cause_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_ban_info
-- ----------------------------

-- ----------------------------
-- Table structure for b_black_room
-- ----------------------------
DROP TABLE IF EXISTS `b_black_room`;
CREATE TABLE `b_black_room`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ban_info_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_black_room
-- ----------------------------

-- ----------------------------
-- Table structure for bg_bangumi_indexs
-- ----------------------------
DROP TABLE IF EXISTS `bg_bangumi_indexs`;
CREATE TABLE `bg_bangumi_indexs`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bangumi_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '番剧类型',
  `bangumi_info_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_bangumi_indexs
-- ----------------------------

-- ----------------------------
-- Table structure for bg_bangumi_info
-- ----------------------------
DROP TABLE IF EXISTS `bg_bangumi_info`;
CREATE TABLE `bg_bangumi_info`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `bangumi_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '番剧名称',
  `bangumi_info_str` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '番剧简介信息',
  `bangumi_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '番剧状态',
  `sub_bangumi_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `video_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bg_bangumi_info
-- ----------------------------

-- ----------------------------
-- Table structure for pub_img
-- ----------------------------
DROP TABLE IF EXISTS `pub_img`;
CREATE TABLE `pub_img`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `img_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片地址',
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `img_type` int(10) UNSIGNED NOT NULL COMMENT '图片类型',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pub_img_localtion`(`img_location`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pub_img
-- ----------------------------
INSERT INTO `pub_img` VALUES (1, 'https://mcsql-002.oss-cn-beijing.aliyuncs.com/wallhaven-lq7672.png', 1, 0, '2021-05-18 20:07:59', '2021-05-18 20:08:01');

-- ----------------------------
-- Table structure for pub_zone
-- ----------------------------
DROP TABLE IF EXISTS `pub_zone`;
CREATE TABLE `pub_zone`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `notes` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级ID',
  `level` int(4) NULL DEFAULT NULL COMMENT '分区级数',
  `sort` int(4) NULL DEFAULT NULL COMMENT '分区排序',
  `show` int(4) NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pub_zone
-- ----------------------------
INSERT INTO `pub_zone` VALUES (1, '生活', NULL, 0, 0, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (2, '游戏', NULL, 0, 0, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (3, '知识', NULL, 0, 0, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (4, '影视', NULL, 0, 0, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (5, '音乐', NULL, 0, 0, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (6, '动画', NULL, 0, 0, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (7, '时尚', NULL, 0, 0, 7, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (8, '美食', NULL, 0, 0, 8, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (9, '汽车', NULL, 0, 0, 9, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (10, '数码', NULL, 0, 0, 10, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (11, '动物圈', NULL, 0, 0, 11, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (12, '舞蹈', NULL, 0, 0, 12, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (13, '国创', NULL, 0, 0, 13, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (14, '鬼畜', NULL, 0, 0, 14, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (15, '纪录片', NULL, 0, 0, 15, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (16, '番剧', NULL, 0, 0, 16, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (17, '电视剧', NULL, 0, 0, 17, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (18, '电影', NULL, 0, 0, 18, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (19, '日常', '一般日常向的生活类视频', 1, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (20, '搞笑', '搞笑挑战、剪辑、表演、配音以及各类日常沙雕视频', 1, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (21, '运动', '一般向运动项目以及惊险刺激的户外极限运动', 1, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (22, '绘画', '绘画爱好者们关于绘画技巧、绘图过程的分享交流场所', 1, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (23, '手工', '简易手工艺品的diy制作视频，例如；折纸、手账、橡皮章等', 1, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (24, '其他', '无法判断分区归属的视频', 1, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (25, '单机游戏', '以单机或其联机模式为主要内容的相关视频', 2, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (26, '网络游戏', '多人在线游戏为主要内容的相关视频', 2, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (27, '手机游戏', '手机及平板设备平台上的游戏相关视频', 2, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (28, '电子竞技', '电子竞技游戏项目为主要内容的相关视频', 2, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (29, '桌游棋牌', '桌游、棋牌、卡牌、聚会游戏等相关视频', 2, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (30, '音游', '通过配合音乐与节奏而进行的音乐类游戏视频', 2, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (31, 'GMV', '使用游戏内容或CG为素材制作的MV类型的视频', 2, 1, 7, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (32, 'Mugen', '使用Mugen引擎制作或与Mugen相关的游戏视频', 2, 1, 8, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (33, '科学科普', '以自然科学或基于科学思维展开的科普视频', 3, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (34, '社科人文', '社会/历史/法律/心理/文化/趣闻/艺术/人物/互联网', 3, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (35, '财经', '财政金融经济相关视频', 3, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (36, '校园学习', '学校里学习的相关内容，分享学习经验或是课程干货', 3, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (37, '职业职场', '职场经验、行业知识相关内容', NULL, NULL, NULL, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `pub_zone` VALUES (38, '职业职场', '职场经验、行业知识相关内容', 3, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (39, '野生技术协会', '技术型技能展示或是技能经验分享视频', NULL, NULL, NULL, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `pub_zone` VALUES (40, '野生技术协会', '技术型技能展示或是技能经验分享视频', 3, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (41, '短片', '具有一定故事线的剧情短片或者追求印象诗意化的实验短片', 4, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (42, '影视杂谈', '影视评论、解说、吐槽、科普、配音等', 4, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (43, '影视剪辑', '对影视素材进行剪辑再创作的视频', 4, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (44, '预告·资讯', '影视类相关资讯，预告，花絮等视频', 4, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (45, '音乐综合', '收录无法定义到其他音乐子分区的音乐视频。', 5, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (46, '音乐现场', '音乐实况表演视频', 5, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (47, '演奏', '使用各种传统及非传统乐器进行演奏创作', 5, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (48, '翻唱', '非官方性质的人声歌曲演绎', 5, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (49, 'MV', '音乐录影带，官方为搭配音乐而拍摄的短片。', 5, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (50, 'VOCALOID·UTAU', '以Vocaloid及UTAU引擎环境为主，运用各种音源进行创作', 5, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (51, '电音', '以电子合成器、音乐软体等产生的电子声响制作的音乐。', 5, 1, 7, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (52, '原创音乐', '由上传者本人参与创作制作或原作者授权代投的歌曲及纯音乐', 5, 1, 8, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (53, 'MAD·AMV', '具有一定创作度的动/静画二次创作视频', 6, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (54, 'MMD·3D', '使用MMD和其他3D软件制作的视频', NULL, NULL, NULL, 0, '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `pub_zone` VALUES (55, 'MMD·3D', '使用MMD和其他3D软件制作的视频', 6, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (56, '综合', '以动画及相关内容为素材的创作', 6, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (57, '短片·手书·配音', '颇具特色的短片/手书及ACG相关配音', 6, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (58, '手办·模玩', '手办模玩的测评、改造或其他衍生内容', 6, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (59, '特摄', '特摄相关衍生视频', 6, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (60, '美妆', '涵盖妆容、发型、美甲等教程，彩妆、护肤相关产品测评、分享等', 7, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (61, '服饰', '服饰风格、穿搭技巧的教程与展示', 7, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (62, 'T台', '发布会走秀现场及模特相关时尚片、采访、后台花絮', 7, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (63, '健身', '器械、有氧、拉伸运动等，以达到强身健体、减肥瘦身、形体塑造目的', 7, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (64, '风尚标', '时尚明星专访、街拍、时尚购物相关知识科普', 7, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (65, '美食制作', '包括但不限于料理制作教程，各种菜系、甜点、速食、饮料、小吃制作等', 8, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (66, '美食侦探', '包括但不限于探店、街边美食、饮食文化，发现特色地域美食、路边摊与热门网红食物等', 8, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (67, '美食测评', '包括但不限于边吃边聊、测评推荐或吐槽各种美食等', 8, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (68, '田园美食', '包括但不限于乡野美食、三农采摘、钓鱼赶海等', 8, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (69, '美食记录', '记录一日三餐，美食vlog、料理、便当、饮品合集、美食小剧场等', 8, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (70, '汽车生活', '和汽车等交通工具相关的一切泛化内容的视频', 9, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (71, '汽车文化', '和汽车文化相关的视频', 9, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (72, '汽车极客', '热衷于汽车技术及运用汽车技术实践的汽车发烧友', 9, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (73, '智能出行', '和新能源汽车及新出行方式相关的视频', 9, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (74, '购车攻略', '和新车二手车选购相关的视频', 9, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (75, '手机平板', '手机平板、app 和产品教程等相关视频', 10, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (76, '电脑装机', '电脑笔记本、装机配件、外设和软件教程等相关视频', 10, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (77, '摄影摄像', '摄影摄像器材、拍摄剪辑技巧等相关视频', 10, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (78, '影音智能', '影音设备、智能硬件、生活家电等相关视频', 10, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (79, '喵星人', '与猫相关的视频，包括但不限于猫咪日常、猫咪喂养、猫咪知识、猫咪剧场、猫咪救助、猫咪娱乐相关的内容', 11, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (80, '汪星人', '与狗相关的视频，包括但不限于狗狗日常、狗狗喂养、狗狗知识、狗狗剧场、狗狗救助、狗狗娱乐相关的内容', 11, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (81, '野生动物', '与野生动物相关的视频，包括但不限于狮子、老虎、狼等动物内容', 11, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (82, '爬宠', '与爬宠相关的视频，包括但不限于龟、蜘蛛、蜥蜴等以宠物方式养育的爬行类动物内容 v', 11, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (83, '大熊猫', '与大熊猫相关的视频，包括但不限于熊猫日常、熊猫喂养、熊猫知识、熊猫剧场、熊猫救助、熊猫娱乐相关的内容', 11, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (84, '动物综合', '除喵星人、汪星人、大熊猫、爬宠、野生动物之外的其余动物相关视频以及动物相关的延伸内容', 11, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (85, '宅舞', '与ACG相关的翻跳、原创舞蹈', 12, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (86, '舞蹈综合', '收录无法定义到其他舞蹈子分区的舞蹈视频', 12, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (87, '舞蹈教程', '动作分解，基础教程等具有教学意义的舞蹈视频', 12, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (88, '街舞', '收录街舞相关内容，包括赛事现场、舞室作品、个人翻跳、FREESTYLE等', 12, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (89, '明星舞蹈', '国内外明星发布的官方舞蹈及其翻跳内容', 12, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (90, '中国舞', '传承中国艺术文化的舞蹈内容，包括古典舞、民族民间舞、汉唐舞、古风舞等', 12, 1, 6, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (91, '国产动画', '国产连载动画，国产完结动画', 13, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (92, '国产原创相关', '以国产动画、漫画、小说为素材的二次创作', 13, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (93, '布袋戏', '布袋戏以及相关剪辑节目', 13, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (94, '资讯', '原创国产动画、漫画的相关资讯、宣传节目等', 13, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (95, '动态漫·广播剧', '国产动态漫画、有声漫画、广播剧', 13, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (96, '鬼畜调教', '使用素材在音频、画面上做一定处理，达到与BGM具有一定同步感的视频', 14, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (97, '音MAD', '使用素材音频进行一定的二次创作来达到还原原曲的非商业性质稿件', 14, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (98, '人力VOCALOID', '将人物或者角色的无伴奏素材进行人工调音，使其就像VOCALOID一样歌唱的技术', 14, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (99, '鬼畜剧场', '使用素材进行人工剪辑编排的有剧情的视频', 14, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (100, '教程演示', '鬼畜相关的科普和教程演示', 14, 1, 5, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (101, '人文·历史', '除宣传片、影视剪辑外的，人文艺术历史纪录剧集或电影、预告、花絮、二创、5分钟以上纪录短片', 15, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (102, '科学·探索·自然', '除演讲、网课、教程外的，科学探索自然纪录剧集或电影、预告、花絮、二创、5分钟以上纪录短片', 15, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (103, '军事', '除时政军事新闻外的，军事纪录剧集或电影、预告、花絮、二创、5分钟以上纪录短片', 15, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (104, '社会·美食·旅行', '除VLOG、风光摄影外的，社会美食旅行纪录剧集或电影、预告、花絮、二创、5分钟以上纪录短片', 15, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (105, '资讯', '以动画/轻小说/漫画/杂志为主的资讯内容，PV/CM/特报/冒头/映像/预告', 16, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (106, '官方延伸', '以动画番剧及声优为主的EVENT/生放送/DRAMA/RADIO/LIVE/特典/冒头等', 16, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (107, '国产剧', NULL, 17, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (108, '海外剧', NULL, 17, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (109, '其他国家', NULL, 18, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (110, '欧美电影', NULL, 18, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (111, '日本电影', NULL, 18, 1, 3, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (112, '国产电影', NULL, 18, 1, 4, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (113, '娱乐', NULL, 0, 0, 19, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (114, '综艺', '国内外电视或网络自制的综艺正片及精彩剪辑视频', 113, 1, 1, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');
INSERT INTO `pub_zone` VALUES (115, '明星', '三次元明星相关的动态、资讯、粉丝向自制剪辑视频', 113, 1, 2, 1, '2021-05-23 20:55:51', '2021-05-23 20:55:51');

-- ----------------------------
-- Table structure for u_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `u_blacklist`;
CREATE TABLE `u_blacklist`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `black_id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_blacklist
-- ----------------------------

-- ----------------------------
-- Table structure for u_coin
-- ----------------------------
DROP TABLE IF EXISTS `u_coin`;
CREATE TABLE `u_coin`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `coin_balance` int(11) NOT NULL COMMENT '硬币余额',
  `modify_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '投币信息',
  `change_number` int(10) UNSIGNED NOT NULL COMMENT '投币数额',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_coin
-- ----------------------------

-- ----------------------------
-- Table structure for u_collect
-- ----------------------------
DROP TABLE IF EXISTS `u_collect`;
CREATE TABLE `u_collect`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `video_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `facorites_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_collect
-- ----------------------------

-- ----------------------------
-- Table structure for u_e_wallet
-- ----------------------------
DROP TABLE IF EXISTS `u_e_wallet`;
CREATE TABLE `u_e_wallet`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `c_money` int(10) UNSIGNED NOT NULL COMMENT 'c币余额',
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `order_id` int(10) UNSIGNED NOT NULL,
  `expend_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消费类型',
  `modify_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消费信息',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_e_wallet
-- ----------------------------

-- ----------------------------
-- Table structure for u_facorites
-- ----------------------------
DROP TABLE IF EXISTS `u_facorites`;
CREATE TABLE `u_facorites`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `facorites_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收藏夹名',
  `collect_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `video_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `facorites_status` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收藏夹状态',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_facorites
-- ----------------------------

-- ----------------------------
-- Table structure for u_follow
-- ----------------------------
DROP TABLE IF EXISTS `u_follow`;
CREATE TABLE `u_follow`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `follow_id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_follow
-- ----------------------------

-- ----------------------------
-- Table structure for u_integral
-- ----------------------------
DROP TABLE IF EXISTS `u_integral`;
CREATE TABLE `u_integral`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `ig_balance` int(10) UNSIGNED NOT NULL COMMENT '积分余额',
  `modify_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消费原因',
  `change_number` int(10) UNSIGNED NOT NULL COMMENT '消费数额',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_integral
-- ----------------------------

-- ----------------------------
-- Table structure for u_like_column
-- ----------------------------
DROP TABLE IF EXISTS `u_like_column`;
CREATE TABLE `u_like_column`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NOT NULL,
  `column_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_like_column
-- ----------------------------

-- ----------------------------
-- Table structure for u_like_comment
-- ----------------------------
DROP TABLE IF EXISTS `u_like_comment`;
CREATE TABLE `u_like_comment`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NOT NULL,
  `comment_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_like_comment
-- ----------------------------

-- ----------------------------
-- Table structure for u_like_video
-- ----------------------------
DROP TABLE IF EXISTS `u_like_video`;
CREATE TABLE `u_like_video`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NOT NULL,
  `video_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_like_video
-- ----------------------------

-- ----------------------------
-- Table structure for u_pb
-- ----------------------------
DROP TABLE IF EXISTS `u_pb`;
CREATE TABLE `u_pb`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密保问题',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密保答案',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_pb
-- ----------------------------

-- ----------------------------
-- Table structure for u_realname
-- ----------------------------
DROP TABLE IF EXISTS `u_realname`;
CREATE TABLE `u_realname`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `realname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `ID_number` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_realname
-- ----------------------------

-- ----------------------------
-- Table structure for u_safe
-- ----------------------------
DROP TABLE IF EXISTS `u_safe`;
CREATE TABLE `u_safe`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '电话号码',
  `ep_id` int(10) UNSIGNED NOT NULL,
  `rn_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_safe
-- ----------------------------

-- ----------------------------
-- Table structure for u_sub_bangumi
-- ----------------------------
DROP TABLE IF EXISTS `u_sub_bangumi`;
CREATE TABLE `u_sub_bangumi`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `bangumi_info_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_sub_bangumi
-- ----------------------------

-- ----------------------------
-- Table structure for u_subscription
-- ----------------------------
DROP TABLE IF EXISTS `u_subscription`;
CREATE TABLE `u_subscription`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `sub_sitcom_id` int(10) UNSIGNED NOT NULL,
  `sub_bangumi_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `label_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_subscription
-- ----------------------------

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_passwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `user_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户签名',
  `status` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户状态',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'M' COMMENT '性别',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `birth` date NULL DEFAULT NULL COMMENT '生日',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_user
-- ----------------------------

-- ----------------------------
-- Table structure for v_barrage
-- ----------------------------
DROP TABLE IF EXISTS `v_barrage`;
CREATE TABLE `v_barrage`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `video_id` int(10) UNSIGNED NULL DEFAULT NULL,
  `barrage_str` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '弹幕内容',
  `video_time` time NOT NULL COMMENT '视频时间',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_barrage
-- ----------------------------

-- ----------------------------
-- Table structure for v_like
-- ----------------------------
DROP TABLE IF EXISTS `v_like`;
CREATE TABLE `v_like`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `like_number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '点赞数',
  `down_number` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '点踩数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_like
-- ----------------------------
INSERT INTO `v_like` VALUES (1, '87260', '8163', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (2, '69805', '99883', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (3, '57734', '43395', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (4, '94529', '36287', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (5, '841', '78996', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (6, '69731', '1276', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (7, '48520', '85700', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (8, '22835', '96821', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (9, '91589', '85445', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (10, '44276', '4084', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (11, '51565', '60625', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (12, '99575', '29636', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (13, '42237', '80782', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (14, '2289', '51506', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (15, '13493', '41542', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (16, '45332', '58692', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (17, '85462', '75790', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (18, '41280', '27836', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (19, '20224', '41232', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (20, '99952', '53059', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (21, '14774', '42578', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (22, '3578', '8573', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (23, '86853', '99247', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (24, '38865', '5862', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (25, '21125', '30162', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (26, '15674', '64922', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (27, '85855', '30065', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (28, '27813', '69896', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (29, '60714', '90216', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (30, '94767', '83708', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (31, '27911', '46687', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (32, '40350', '22330', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (33, '33416', '92193', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (34, '83355', '58153', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (35, '28308', '72289', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (36, '98664', '95770', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (37, '50809', '94983', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (38, '67671', '28251', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (39, '68491', '89733', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (40, '80688', '90872', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (41, '70719', '31194', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (42, '3391', '29056', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (43, '17249', '76854', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (44, '17517', '99362', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (45, '46762', '83971', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (46, '16875', '11583', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (47, '27814', '79345', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (48, '25235', '19938', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (49, '62693', '27647', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (50, '40026', '34013', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (51, '3757', '50331', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (52, '14757', '73251', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (53, '53747', '14202', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (54, '90607', '47450', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (55, '84274', '38154', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (56, '86825', '46535', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (57, '87899', '68225', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (58, '52775', '23777', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (59, '83724', '91758', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (60, '67857', '65486', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (61, '44502', '94706', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (62, '51447', '77586', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (63, '70283', '25909', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (64, '66113', '62544', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (65, '38086', '55907', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (66, '11578', '65336', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (67, '22846', '85808', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (68, '84444', '90389', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (69, '2796', '72863', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (70, '4138', '8321', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (71, '23988', '67757', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (72, '76198', '19754', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (73, '63068', '72575', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (74, '8773', '47468', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (75, '14310', '80083', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (76, '75701', '88157', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (77, '81476', '71401', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (78, '82167', '93924', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (79, '97197', '86798', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (80, '99186', '3540', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (81, '79957', '29640', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (82, '34820', '58321', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (83, '29580', '20783', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (84, '69969', '83514', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (85, '16168', '33139', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (86, '45831', '85902', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (87, '72172', '53265', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (88, '16437', '91667', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (89, '7298', '65891', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (90, '69549', '13772', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (91, '11300', '2170', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (92, '67031', '54106', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (93, '25288', '78528', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (94, '10799', '80589', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (95, '83162', '86165', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (96, '40411', '11037', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (97, '97243', '41876', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (98, '13247', '85537', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (99, '9305', '91340', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (100, '6152', '41239', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (101, '13530', '32563', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (102, '62101', '9073', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (103, '11798', '69375', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (104, '11774', '23118', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (105, '99622', '40765', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (106, '80830', '11130', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (107, '15586', '10242', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (108, '47215', '2960', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (109, '54338', '76680', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (110, '75856', '84358', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (111, '83405', '94525', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (112, '90080', '25119', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (113, '761', '80808', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (114, '33369', '87396', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (115, '34791', '73164', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (116, '8428', '79166', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (117, '77097', '91791', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (118, '69915', '54319', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (119, '90482', '14813', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_like` VALUES (120, '71101', '49269', '2021-05-18 11:54:42', '2021-05-18 11:54:42');

-- ----------------------------
-- Table structure for v_video
-- ----------------------------
DROP TABLE IF EXISTS `v_video`;
CREATE TABLE `v_video`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `video_sort` int(10) UNSIGNED NOT NULL,
  `video_title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video_duration` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频信息',
  `video_info_id` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_video
-- ----------------------------
INSERT INTO `v_video` VALUES (1, 0, '人之初性本色1', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (2, 0, '人之初性本色2', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 2, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (3, 0, '人之初性本色3', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 3, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (4, 0, '人之初性本色4', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 4, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (5, 0, '人之初性本色5', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 5, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (6, 0, '人之初性本色6', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 6, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (7, 0, '人之初性本色7', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 7, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (8, 0, '人之初性本色8', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 8, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (9, 0, '人之初性本色9', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 9, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (10, 0, '人之初性本色10', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 10, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (11, 0, '人之初性本色11', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 11, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (12, 0, '人之初性本色12', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 12, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (13, 0, '人之初性本色13', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 13, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (14, 0, '人之初性本色14', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 14, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (15, 0, '人之初性本色15', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 15, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (16, 0, '人之初性本色16', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 16, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (17, 0, '人之初性本色17', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 17, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (18, 0, '人之初性本色18', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 18, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (19, 0, '人之初性本色19', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 19, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (20, 0, '人之初性本色20', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 20, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (21, 0, '人之初性本色21', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 21, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (22, 0, '人之初性本色22', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 22, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (23, 0, '人之初性本色23', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 23, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (24, 0, '人之初性本色24', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 24, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (25, 0, '人之初性本色25', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 25, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (26, 0, '人之初性本色26', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 26, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (27, 0, '人之初性本色27', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 27, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (28, 0, '人之初性本色28', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 28, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (29, 0, '人之初性本色29', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 29, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (30, 0, '人之初性本色30', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 30, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (31, 0, '人之初性本色31', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 31, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (32, 0, '人之初性本色32', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 32, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (33, 0, '人之初性本色33', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 33, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (34, 0, '人之初性本色34', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 34, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (35, 0, '人之初性本色35', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 35, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (36, 0, '人之初性本色36', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 36, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (37, 0, '人之初性本色37', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 37, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (38, 0, '人之初性本色38', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 38, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (39, 0, '人之初性本色39', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 39, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (40, 0, '人之初性本色40', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 40, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (41, 0, '人之初性本色41', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 41, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (42, 0, '人之初性本色42', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 42, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (43, 0, '人之初性本色43', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 43, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (44, 0, '人之初性本色44', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 44, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (45, 0, '人之初性本色45', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 45, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (46, 0, '人之初性本色46', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 46, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (47, 0, '人之初性本色47', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 47, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (48, 0, '人之初性本色48', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 48, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (49, 0, '人之初性本色49', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 49, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (50, 0, '人之初性本色50', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 50, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (51, 0, '人之初性本色51', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 51, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (52, 0, '人之初性本色52', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 52, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (53, 0, '人之初性本色53', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 53, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (54, 0, '人之初性本色54', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 54, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (55, 0, '人之初性本色55', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 55, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (56, 0, '人之初性本色56', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 56, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (57, 0, '人之初性本色57', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 57, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (58, 0, '人之初性本色58', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 58, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (59, 0, '人之初性本色59', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 59, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (60, 0, '人之初性本色60', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 60, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (61, 0, '人之初性本色61', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 61, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (62, 0, '人之初性本色62', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 62, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (63, 0, '人之初性本色63', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 63, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (64, 0, '人之初性本色64', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 64, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (65, 0, '人之初性本色65', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 65, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (66, 0, '人之初性本色66', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 66, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (67, 0, '人之初性本色67', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 67, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (68, 0, '人之初性本色68', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 68, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (69, 0, '人之初性本色69', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 69, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (70, 0, '人之初性本色70', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 70, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (71, 0, '人之初性本色71', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 71, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (72, 0, '人之初性本色72', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 72, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (73, 0, '人之初性本色73', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 73, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (74, 0, '人之初性本色74', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 74, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (75, 0, '人之初性本色75', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 75, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (76, 0, '人之初性本色76', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 76, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (77, 0, '人之初性本色77', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 77, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (78, 0, '人之初性本色78', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 78, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (79, 0, '人之初性本色79', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 79, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (80, 0, '人之初性本色80', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 80, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (81, 0, '人之初性本色81', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 81, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (82, 0, '人之初性本色82', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 82, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (83, 0, '人之初性本色83', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 83, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (84, 0, '人之初性本色84', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 84, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (85, 0, '人之初性本色85', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 85, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (86, 0, '人之初性本色86', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 86, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (87, 0, '人之初性本色87', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 87, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (88, 0, '人之初性本色88', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 88, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (89, 0, '人之初性本色89', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 89, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (90, 0, '人之初性本色90', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 90, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (91, 0, '人之初性本色91', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 91, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (92, 0, '人之初性本色92', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 92, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (93, 0, '人之初性本色93', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 93, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (94, 0, '人之初性本色94', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 94, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (95, 0, '人之初性本色95', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 95, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (96, 0, '人之初性本色96', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 96, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (97, 0, '人之初性本色97', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 97, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (98, 0, '人之初性本色98', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 98, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (99, 0, '人之初性本色99', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 99, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (100, 0, '人之初性本色100', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 100, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (101, 0, '人之初性本色101', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 101, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (102, 0, '人之初性本色102', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 102, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (103, 0, '人之初性本色103', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 103, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (104, 0, '人之初性本色104', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 104, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (105, 0, '人之初性本色105', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 105, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (106, 0, '人之初性本色106', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 106, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (107, 0, '人之初性本色107', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 107, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (108, 0, '人之初性本色108', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 108, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (109, 0, '人之初性本色109', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 109, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (110, 0, '人之初性本色110', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 110, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (111, 0, '人之初性本色111', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 111, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (112, 0, '人之初性本色112', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 112, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (113, 0, '人之初性本色113', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 113, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (114, 0, '人之初性本色114', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 114, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (115, 0, '人之初性本色115', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 115, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (116, 0, '人之初性本色116', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 116, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (117, 0, '人之初性本色117', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 117, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (118, 0, '人之初性本色118', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 118, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (119, 0, '人之初性本色119', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 119, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video` VALUES (120, 0, '人之初性本色120', '2021-05-18 11:54', '30ac017200af4214ab82c02b6644662f', 120, '2021-05-18 11:54:42', '2021-05-18 11:54:42');

-- ----------------------------
-- Table structure for v_video_info
-- ----------------------------
DROP TABLE IF EXISTS `v_video_info`;
CREATE TABLE `v_video_info`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `like_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `play_nub` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '播放数',
  `video_pnumb` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分享数',
  `video_coin` int(10) UNSIGNED NOT NULL COMMENT '投币数',
  `audit_id` int(10) UNSIGNED NOT NULL,
  `video_status` int(10) UNSIGNED NOT NULL,
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_video_info
-- ----------------------------
INSERT INTO `v_video_info` VALUES (1, '1', '79038', '70699', 16380, 1, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (2, '2', '90000', '50352', 81758, 2, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (3, '3', '43775', '88689', 12119, 3, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (4, '4', '97851', '80391', 8403, 4, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (5, '5', '92458', '25300', 49126, 5, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (6, '6', '97187', '82105', 18967, 6, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (7, '7', '82937', '57586', 39119, 7, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (8, '8', '15597', '87525', 90833, 8, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (9, '9', '52459', '5962', 72433, 9, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (10, '10', '87591', '25701', 65734, 10, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (11, '11', '48430', '60274', 56079, 11, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (12, '12', '49455', '58366', 43467, 12, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (13, '13', '77199', '43649', 86647, 13, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (14, '14', '50662', '98792', 41974, 14, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (15, '15', '67233', '11537', 55989, 15, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (16, '16', '57464', '11247', 83841, 16, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (17, '17', '22562', '85441', 59521, 17, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (18, '18', '15341', '93197', 19963, 18, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (19, '19', '45487', '3739', 82234, 19, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (20, '20', '65439', '68016', 43764, 20, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (21, '21', '68565', '15093', 69772, 21, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (22, '22', '32134', '34948', 78339, 22, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (23, '23', '35675', '80636', 96155, 23, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (24, '24', '12716', '45994', 91822, 24, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (25, '25', '87436', '46691', 71150, 25, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (26, '26', '77586', '93166', 33071, 26, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (27, '27', '92759', '73600', 89722, 27, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (28, '28', '66040', '20514', 4451, 28, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (29, '29', '68937', '74037', 63376, 29, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (30, '30', '34238', '20067', 97623, 30, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (31, '31', '49702', '8449', 93139, 31, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (32, '32', '90602', '86020', 58295, 32, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (33, '33', '60717', '27005', 52874, 33, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (34, '34', '40699', '29036', 23083, 34, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (35, '35', '76524', '65751', 99183, 35, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (36, '36', '82860', '26986', 86354, 36, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (37, '37', '22490', '27501', 70035, 37, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (38, '38', '38243', '6461', 17575, 38, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (39, '39', '43190', '46752', 4189, 39, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (40, '40', '12298', '88872', 7467, 40, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (41, '41', '43812', '25481', 95967, 41, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (42, '42', '35104', '88355', 36463, 42, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (43, '43', '32525', '32063', 62742, 43, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (44, '44', '44260', '23212', 83279, 44, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (45, '45', '79568', '45927', 90931, 45, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (46, '46', '7287', '1687', 86575, 46, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (47, '47', '13285', '28387', 2079, 47, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (48, '48', '23985', '60112', 28606, 48, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (49, '49', '50155', '67834', 88706, 49, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (50, '50', '49985', '47888', 89484, 50, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (51, '51', '40385', '50933', 33512, 51, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (52, '52', '21982', '90158', 84844, 52, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (53, '53', '9767', '6233', 1861, 53, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (54, '54', '65431', '84807', 27739, 54, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (55, '55', '37947', '75274', 62529, 55, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (56, '56', '72202', '21406', 90424, 56, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (57, '57', '77428', '82463', 80033, 57, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (58, '58', '60558', '31459', 75620, 58, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (59, '59', '7620', '62825', 91267, 59, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (60, '60', '23859', '22836', 42602, 60, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (61, '61', '40021', '15989', 59883, 61, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (62, '62', '33589', '35187', 75169, 62, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (63, '63', '18696', '15752', 22674, 63, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (64, '64', '14379', '84262', 78174, 64, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (65, '65', '65279', '58671', 97518, 65, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (66, '66', '91948', '63730', 42807, 66, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (67, '67', '60503', '45090', 43943, 67, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (68, '68', '98616', '21911', 13705, 68, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (69, '69', '55927', '61048', 37456, 69, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (70, '70', '29191', '20993', 17394, 70, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (71, '71', '66823', '30843', 53745, 71, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (72, '72', '70177', '91624', 47588, 72, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (73, '73', '73671', '50629', 32132, 73, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (74, '74', '11023', '12712', 30489, 74, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (75, '75', '57486', '47182', 63449, 75, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (76, '76', '13683', '3942', 78660, 76, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (77, '77', '12575', '48672', 5637, 77, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (78, '78', '23117', '33816', 99729, 78, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (79, '79', '42398', '51598', 30796, 79, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (80, '80', '20143', '90096', 90049, 80, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (81, '81', '8327', '52715', 38593, 81, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (82, '82', '87145', '60761', 42373, 82, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (83, '83', '15175', '13527', 22110, 83, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (84, '84', '7664', '87779', 15901, 84, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (85, '85', '17189', '86531', 81085, 85, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (86, '86', '92018', '2384', 35865, 86, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (87, '87', '49810', '89254', 96840, 87, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (88, '88', '9025', '70121', 23532, 88, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (89, '89', '7561', '40135', 77991, 89, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (90, '90', '60213', '59750', 18110, 90, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (91, '91', '76950', '78240', 60350, 91, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (92, '92', '69434', '84855', 15970, 92, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (93, '93', '16775', '48292', 91135, 93, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (94, '94', '70548', '10972', 43215, 94, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (95, '95', '81340', '48205', 97005, 95, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (96, '96', '33955', '36662', 81446, 96, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (97, '97', '17654', '62639', 60233, 97, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (98, '98', '87945', '83113', 51729, 98, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (99, '99', '28785', '69906', 63174, 99, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (100, '100', '87740', '14983', 11696, 100, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (101, '101', '22224', '13430', 478, 101, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (102, '102', '59059', '68076', 63206, 102, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (103, '103', '11479', '49271', 11917, 103, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (104, '104', '80267', '31983', 19114, 104, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (105, '105', '4961', '2511', 97673, 105, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (106, '106', '13159', '32408', 22562, 106, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (107, '107', '4455', '91547', 44371, 107, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (108, '108', '73155', '56893', 65004, 108, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (109, '109', '20387', '71894', 98307, 109, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (110, '110', '94221', '18033', 7501, 110, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (111, '111', '22408', '28463', 75094, 111, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (112, '112', '55354', '1412', 41000, 112, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (113, '113', '1754', '66349', 26483, 113, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (114, '114', '36873', '22177', 264, 114, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (115, '115', '61445', '87732', 54325, 115, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (116, '116', '70548', '15242', 64564, 116, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (117, '117', '27664', '62949', 31753, 117, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (118, '118', '61848', '46282', 45865, 118, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (119, '119', '2618', '68653', 35412, 119, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_info` VALUES (120, '120', '33040', '17394', 87849, 120, 1, '2021-05-18 11:54:42', '2021-05-18 11:54:42');

-- ----------------------------
-- Table structure for v_video_status
-- ----------------------------
DROP TABLE IF EXISTS `v_video_status`;
CREATE TABLE `v_video_status`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `video_status` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频状态',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_video_idstatus`(`id`, `video_status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_video_status
-- ----------------------------
INSERT INTO `v_video_status` VALUES (1, '审核中', '2021-05-18 19:55:46', '2021-05-18 19:55:49');
INSERT INTO `v_video_status` VALUES (2, '审核通过', '2021-05-18 19:56:21', '2021-05-18 19:56:25');
INSERT INTO `v_video_status` VALUES (3, '未通过审核', '2021-05-18 19:58:55', '2021-05-18 19:58:57');

-- ----------------------------
-- Table structure for v_video_text
-- ----------------------------
DROP TABLE IF EXISTS `v_video_text`;
CREATE TABLE `v_video_text`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `video_info_id` int(10) UNSIGNED NOT NULL,
  `zone_id` int(10) UNSIGNED NOT NULL,
  `img_id` int(10) UNSIGNED NOT NULL,
  `author_id` int(10) UNSIGNED NOT NULL,
  `comment_id` int(10) UNSIGNED NOT NULL,
  `video_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频标题',
  `video_brief` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_text_infoid`(`video_info_id`) USING BTREE,
  INDEX `idx_text_infoIdta`(`video_info_id`, `video_title`, `author_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of v_video_text
-- ----------------------------
INSERT INTO `v_video_text` VALUES (1, 1, 1, 1, 1, 1, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (2, 2, 2, 1, 2, 2, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (3, 3, 3, 1, 3, 3, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (4, 4, 4, 1, 4, 4, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (5, 5, 5, 1, 5, 5, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (6, 6, 6, 1, 6, 6, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (7, 7, 7, 1, 7, 7, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (8, 8, 8, 1, 8, 8, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (9, 9, 9, 1, 9, 9, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (10, 10, 10, 1, 10, 10, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (11, 11, 11, 1, 11, 11, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (12, 12, 12, 1, 12, 12, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (13, 13, 13, 1, 13, 13, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (14, 14, 14, 1, 14, 14, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (15, 15, 15, 1, 15, 15, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (16, 16, 16, 1, 16, 16, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (17, 17, 17, 1, 17, 17, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (18, 18, 18, 1, 18, 18, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (19, 19, 19, 1, 19, 19, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (20, 20, 20, 1, 20, 20, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (21, 21, 21, 1, 21, 21, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (22, 22, 22, 1, 22, 22, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (23, 23, 23, 1, 23, 23, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (24, 24, 24, 1, 24, 24, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (25, 25, 25, 1, 25, 25, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (26, 26, 26, 1, 26, 26, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (27, 27, 27, 1, 27, 27, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (28, 28, 28, 1, 28, 28, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (29, 29, 29, 1, 29, 29, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (30, 30, 30, 1, 30, 30, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (31, 31, 31, 1, 31, 31, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (32, 32, 32, 1, 32, 32, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (33, 33, 33, 1, 33, 33, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (34, 34, 34, 1, 34, 34, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (35, 35, 35, 1, 35, 35, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (36, 36, 36, 1, 36, 36, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (37, 37, 37, 1, 37, 37, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (38, 38, 38, 1, 38, 38, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (39, 39, 39, 1, 39, 39, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (40, 40, 40, 1, 40, 40, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (41, 41, 41, 1, 41, 41, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (42, 42, 42, 1, 42, 42, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (43, 43, 43, 1, 43, 43, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (44, 44, 44, 1, 44, 44, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (45, 45, 45, 1, 45, 45, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (46, 46, 46, 1, 46, 46, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (47, 47, 47, 1, 47, 47, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (48, 48, 48, 1, 48, 48, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (49, 49, 49, 1, 49, 49, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (50, 50, 50, 1, 50, 50, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (51, 51, 51, 1, 51, 51, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (52, 52, 52, 1, 52, 52, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (53, 53, 53, 1, 53, 53, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (54, 54, 54, 1, 54, 54, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (55, 55, 55, 1, 55, 55, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (56, 56, 56, 1, 56, 56, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (57, 57, 57, 1, 57, 57, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (58, 58, 58, 1, 58, 58, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (59, 59, 59, 1, 59, 59, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (60, 60, 60, 1, 60, 60, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (61, 61, 61, 1, 61, 61, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (62, 62, 62, 1, 62, 62, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (63, 63, 63, 1, 63, 63, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (64, 64, 64, 1, 64, 64, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (65, 65, 65, 1, 65, 65, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (66, 66, 66, 1, 66, 66, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (67, 67, 67, 1, 67, 67, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (68, 68, 68, 1, 68, 68, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (69, 69, 69, 1, 69, 69, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (70, 70, 70, 1, 70, 70, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (71, 71, 71, 1, 71, 71, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (72, 72, 72, 1, 72, 72, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (73, 73, 73, 1, 73, 73, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (74, 74, 74, 1, 74, 74, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (75, 75, 75, 1, 75, 75, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (76, 76, 76, 1, 76, 76, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (77, 77, 77, 1, 77, 77, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (78, 78, 78, 1, 78, 78, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (79, 79, 79, 1, 79, 79, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (80, 80, 80, 1, 80, 80, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (81, 81, 81, 1, 81, 81, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (82, 82, 82, 1, 82, 82, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (83, 83, 83, 1, 83, 83, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (84, 84, 84, 1, 84, 84, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (85, 85, 85, 1, 85, 85, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (86, 86, 86, 1, 86, 86, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (87, 87, 87, 1, 87, 87, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (88, 88, 88, 1, 88, 88, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (89, 89, 89, 1, 89, 89, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (90, 90, 90, 1, 90, 90, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (91, 91, 91, 1, 91, 91, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (92, 92, 92, 1, 92, 92, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (93, 93, 93, 1, 93, 93, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (94, 94, 94, 1, 94, 94, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (95, 95, 95, 1, 95, 95, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (96, 96, 96, 1, 96, 96, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (97, 97, 97, 1, 97, 97, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (98, 98, 98, 1, 98, 98, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (99, 99, 99, 1, 99, 99, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (100, 100, 100, 1, 100, 100, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (101, 101, 101, 1, 101, 101, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (102, 102, 102, 1, 102, 102, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (103, 103, 103, 1, 103, 103, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (104, 104, 104, 1, 104, 104, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (105, 105, 105, 1, 105, 105, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (106, 106, 106, 1, 106, 106, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (107, 107, 107, 1, 107, 107, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (108, 108, 108, 1, 108, 108, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (109, 109, 109, 1, 109, 109, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (110, 110, 110, 1, 110, 110, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (111, 111, 111, 1, 111, 111, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (112, 112, 112, 1, 112, 112, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (113, 113, 113, 1, 113, 113, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (114, 114, 114, 1, 114, 114, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (115, 115, 115, 1, 115, 115, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (116, 116, 116, 1, 116, 116, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (117, 117, 117, 1, 117, 117, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (118, 118, 118, 1, 118, 118, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (119, 119, 119, 1, 119, 119, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');
INSERT INTO `v_video_text` VALUES (120, 120, 120, 1, 120, 120, '人之初性本色', '萌', '2021-05-18 11:54:42', '2021-05-18 11:54:42');

-- ----------------------------
-- Function structure for generateUserName
-- ----------------------------
DROP FUNCTION IF EXISTS `generateUserName`;
delimiter ;;
CREATE FUNCTION `generateUserName`()
 RETURNS varchar(255) CHARSET utf8
  DETERMINISTIC
BEGIN
    DECLARE xing varchar(2056) DEFAULT '赵钱孙李周郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁';

    DECLARE ming varchar(2056) DEFAULT '嘉懿煜城懿轩烨伟苑博伟泽熠彤鸿煊博涛烨霖烨华煜祺智宸正豪昊然明杰诚立轩立辉峻熙弘文熠彤鸿煊烨霖哲瀚鑫鹏致远俊驰雨泽烨磊晟睿天佑文昊修洁黎昕远航旭尧鸿涛伟祺轩越泽浩宇瑾瑜皓轩擎苍擎宇志泽睿渊楷瑞轩弘文哲瀚雨泽鑫磊梦琪忆之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安夜蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南莲紫翠雨寒易烟如萱若南寻真晓亦向珊慕灵以蕊寻雁映易雪柳孤岚笑霜海云凝天沛珊寒云冰旋宛儿绿真盼儿晓霜碧凡夏菡曼香若烟半梦雅绿冰蓝灵槐平安书翠翠风香巧代云梦曼幼翠友巧听寒梦柏醉易访旋亦玉凌萱访卉怀亦笑蓝春翠靖柏夜蕾冰夏梦松书雪乐枫念薇靖雁寻春恨山从寒忆香觅波静曼凡旋以亦念露芷蕾千兰新波代真新蕾雁玉冷卉紫山千琴恨天傲芙盼山怀蝶冰兰山柏翠萱乐丹翠柔谷山之瑶冰露尔珍谷雪乐萱涵菡海莲傲蕾青槐冬儿易梦惜雪宛海之柔夏青亦瑶妙菡春竹修杰伟诚建辉晋鹏天磊绍辉泽洋明轩健柏煊昊强伟宸博超君浩子骞明辉鹏涛炎彬鹤轩越彬风华靖琪明诚高格光华国源宇晗昱涵润翰飞翰海昊乾浩博和安弘博鸿朗华奥华灿嘉慕坚秉建明金鑫锦程瑾瑜鹏经赋景同靖琪君昊俊明季同开济凯安康成乐语力勤良哲理群茂彦敏博明达朋义彭泽鹏举濮存溥心璞瑜浦泽奇邃祥荣轩';

    DECLARE I_xing int DEFAULT LENGTH(xing) / 3;
    DECLARE I_ming int DEFAULT LENGTH(ming) / 3;
    DECLARE return_str varchar(2056) DEFAULT '';

    SET return_str = CONCAT(return_str, substring(xing, floor(1 + RAND() * I_xing), 1));
    SET return_str = CONCAT(return_str, substring(ming, floor(1 + RAND() * I_ming), 1));
    IF RAND() > 0.400 THEN
        SET return_str = CONCAT(return_str, substring(ming, floor(1 + RAND() * I_ming), 1));
    END IF;
		

    RETURN return_str;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_u_user
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_u_user`;
delimiter ;;
CREATE PROCEDURE `insert_u_user`(in start int(10), in max_num int(10))
begin
    declare i int default 0;
    set autocommit = 0;
    repeat
        set i = i+1;
        insert into u_user (user_passwd, user_name, user_sign, gender, gmt_create, birth, gmt_modified) VALUES
        ('123456', rand_str(5), '人之初性本色，萝相近莉相远。', '男', now(), now(), now());
    until i = max_num
        end repeat;
    commit;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_v_video
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_v_video`;
delimiter ;;
CREATE PROCEDURE `insert_v_video`(in start int(10), in max_num int(10))
begin
    declare i int default 0;
    set autocommit = 0;
    repeat
        set i = i+1;
        insert into v_like (id, like_number, down_number, gmt_create, gmt_modified) VALUES
        (i, num(), num(), now(), now());

        insert into v_video_info (id, like_id, play_nub, video_pnumb, video_coin, audit_id, video_status, gmt_create, gmt_modified) VALUES
        (i, i,num(), num(), num(), i, 1, now(), now());

        insert into v_video (id, video_sort, video_title, video_duration, video_location, video_info_id, gmt_create, gmt_modified) VALUES
        (i, 0, concat('人之初性本色', i), now(), '30ac017200af4214ab82c02b6644662f', i, now(), now());

        insert into v_video_text (id, zone_id, img_id, author_id, comment_id, video_title, video_brief, gmt_create, gmt_modified) VALUES
        (i, i, i, i, i, '人之初性本色', '萌', now(), now());
    until i = max_num
        end repeat;
    commit;
end
;;
delimiter ;

-- ----------------------------
-- Function structure for num
-- ----------------------------
DROP FUNCTION IF EXISTS `num`;
delimiter ;;
CREATE FUNCTION `num`()
 RETURNS int(6)
BEGIN
	#Routine body goes here...

	RETURN ROUND(RAND() * 100000);
END
;;
delimiter ;

-- ----------------------------
-- Function structure for rand_str
-- ----------------------------
DROP FUNCTION IF EXISTS `rand_str`;
delimiter ;;
CREATE FUNCTION `rand_str`(n int)
 RETURNS varchar(255) CHARSET utf8
begin 
    declare chars_str varchar(100) default 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    declare return_str varchar(100) default '';
    declare i int default 0;
    while i < n do 
        set return_str = concat(return_str, substring(chars_str, floor(1 + rand() * 52) ,1));
        set i = i+1;
    end while;
    return return_str;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
