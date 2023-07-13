/*
 Navicat Premium Data Transfer

 Source Server         : TomyJansLoli
 Source Server Type    : MySQL
 Source Server Version : 80320
 Source Host           : 127.0.0.1:3306
 Source Schema         : moe_classroom_manager

 Target Server Type    : MySQL
 Target Server Version : 80320
 File Encoding         : 65001

 Date: 04/07/2023 10:58:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('root', MD5('123456'), 1000000, '2023-07-03 22:37:48', '2023-07-03 22:37:50', 'admin');
INSERT INTO `admin` VALUES ('admin', MD5('123456'), 1000001, '2023-07-04 08:26:49', '2023-07-04 08:26:49', 'default');

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('西教2', 1000005, '西教2的备注', '彭家坪校区北村', 1000001, '2023-07-03 20:46:31', '2023-07-04 10:55:22');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `user_id` int(11) NULL DEFAULT 0,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1000001, '21计一', 1000000, '2023-07-04 09:55:12', '2023-07-04 09:55:12');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('warwolf', 1000002, '0:0:0:0:0:0:0:1', 1000000, '2023-06-09 13:36:11', '2023-06-09 13:36:11');
INSERT INTO `login_log` VALUES ('warwolf', 1000002, '192.168.56.1', 1000001, '2023-06-10 15:22:05', '2023-06-10 15:22:05');
INSERT INTO `login_log` VALUES ('warwolf', 1000002, '0:0:0:0:0:0:0:1', 1000002, '2023-06-17 10:47:38', '2023-06-17 10:47:38');
INSERT INTO `login_log` VALUES ('tianhuang', 1000005, '0:0:0:0:0:0:0:1', 1000003, '2023-06-17 10:56:19', '2023-06-17 10:56:19');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `user_id` int(11) NULL DEFAULT 0,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `room_id` int(11) NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000001 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1000002, '123456', 1000000, 1000000, '2023-07-04 10:49:33', '2023-07-04 10:49:33');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `user_id` int(11) NULL DEFAULT 0,
  `room_id` int(11) NULL DEFAULT 0,
  `order_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `opinion1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `opinion2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `week` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1000001, 1000001, '2023-07-04', '一级意见初始文本', '二级意见初始文本', 'WAIT', 1000000, '2023-07-04 10:01:58', '2023-07-04 10:02:02', '3');
INSERT INTO `orders` VALUES (1000002, 1000001, '2023-07-04', '一级同意意见', '二级拒绝意见', 'REJECT_2', 1000001, '2023-07-03 15:40:05', '2023-07-03 15:40:05', '6');

-- ----------------------------
-- Table structure for orders_log
-- ----------------------------
DROP TABLE IF EXISTS `orders_log`;
CREATE TABLE `orders_log`  (
  `orders_id` int(11) NULL DEFAULT 0,
  `status_old` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `status_new` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000000 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for orders_overtime
-- ----------------------------
DROP TABLE IF EXISTS `orders_overtime`;
CREATE TABLE `orders_overtime`  (
  `orders_id` int(11) NULL DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000000 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `floor_id` int(11) NULL DEFAULT 0,
  `week1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `week7` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `floor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `scale` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('西教2-101', '西教2一楼左', 1000001, '1', '1,3', '1,4', '1,3', '1,2', '1,3', '1,2,3,4', 1000000, '2023-07-03 21:07:51', '2023-07-04 09:56:04', '一楼', '小教室(40人)');
INSERT INTO `room` VALUES ('西教2-302', '西教2三楼左', 1000001, '1', '4', '1', '2,3', '4', '4', '4', 1000001, '2023-07-03 09:52:47', '2023-07-03 14:56:11', '三楼', '中教室(80人)');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `classes_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('TomyJan', MD5('123456'), 'TomyJan', 'TomyJan6@gmail.com', '18888888888', '', 1000000, '2023-07-03 18:59:37', '2023-07-03 19:53:21', 'STUDENT', 1000000);
INSERT INTO `user` VALUES ('tianhuang', MD5('123456'), '孙笑川', 'father@vov.moe', '1231', '', 1000001, '2023-07-03 19:50:40', '2023-07-03 19:51:15', 'COUNSELOR', 0);
INSERT INTO `user` VALUES ('warwolf', MD5('123456'), '周培茄', 'china@vov.moe', '6661', '', 1000002, '2023-07-03 21:06:39', '2023-07-03 21:54:09', 'STUDENT', 1000000);
INSERT INTO `user` VALUES ('zzz', MD5('123456'), '周喆直', 'zzz@vov.moe', '1', '', 1000005, '2023-07-03 18:22:13', '2023-07-03 18:22:16', 'LANDLORD', 0);
INSERT INTO `user` VALUES ('li', MD5('123456'), '董钓之', 'imsb@vov.moe', '1', '', 1000006, '2023-07-03 22:41:00', '2023-07-03 22:41:00', 'STUDENT', 1000000);
INSERT INTO `user` VALUES ('oceanwang', MD5('123456'), '王海洋', 'xudong.zhong@vov.moe', '1333333', '', 1000007, '2023-07-04 10:44:49', '2023-07-04 10:44:49', 'TEACHER', 1000000);

SET FOREIGN_KEY_CHECKS = 1;
