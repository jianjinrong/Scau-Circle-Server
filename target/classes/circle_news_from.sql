/*
 Navicat Premium Data Transfer

 Source Server         : hmt
 Source Server Type    : MySQL
 Source Server Version : 50625
 Source Host           : 202.116.163.199:3307
 Source Schema         : scau_circle

 Target Server Type    : MySQL
 Target Server Version : 50625
 File Encoding         : 65001

 Date: 31/08/2018 23:05:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for circle_news_from
-- ----------------------------
DROP TABLE IF EXISTS `circle_news_from`;
CREATE TABLE `circle_news_from`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息来源所属部门',
  `status` tinyint(4) UNSIGNED NOT NULL DEFAULT 1 COMMENT '状态，0为未启用，1为已启用',
  `deleted_at` tinyint(4) UNSIGNED NOT NULL DEFAULT 1 COMMENT '软删除字段,0为已删除，1为未删除，默认为1',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `update_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of circle_news_from
-- ----------------------------
INSERT INTO `circle_news_from` VALUES (1, '华南农业大学官网', 1, 1, '2018-08-31 21:30:36', '2018-08-31 21:30:40');
INSERT INTO `circle_news_from` VALUES (2, '教务处', 1, 1, '2018-08-31 21:30:55', '2018-08-31 21:30:57');
INSERT INTO `circle_news_from` VALUES (3, '图书馆', 1, 1, '2018-08-31 21:31:19', '2018-08-31 21:31:23');
INSERT INTO `circle_news_from` VALUES (4, '农学院', 1, 1, '2018-08-31 21:36:52', '2018-08-31 21:36:52');
INSERT INTO `circle_news_from` VALUES (5, '林学与风景园林学院', 1, 1, '2018-08-31 21:35:54', '2018-08-31 21:35:58');
INSERT INTO `circle_news_from` VALUES (6, '园艺学院', 1, 1, '2018-08-31 21:48:22', '2018-08-31 21:48:20');
INSERT INTO `circle_news_from` VALUES (7, '兽医学院', 1, 1, '2018-08-31 21:48:17', '2018-08-31 21:48:18');
INSERT INTO `circle_news_from` VALUES (8, '动物科学学院', 1, 1, '2018-08-31 21:48:15', '2018-08-31 21:48:11');
INSERT INTO `circle_news_from` VALUES (9, '资源环境学院', 1, 1, '2018-08-31 21:48:08', '2018-08-31 21:48:09');
INSERT INTO `circle_news_from` VALUES (10, '海洋学院	', 1, 1, '2018-08-31 21:48:06', '2018-08-31 21:48:02');
INSERT INTO `circle_news_from` VALUES (11, '生命科学学院	', 1, 1, '2018-08-31 21:47:51', '2018-08-31 21:47:53');
INSERT INTO `circle_news_from` VALUES (12, '工程学院', 1, 1, '2018-08-31 21:38:25', '2018-08-31 21:38:25');
INSERT INTO `circle_news_from` VALUES (13, '食品学院', 1, 1, '2018-08-31 21:47:48', '2018-08-31 21:47:45');
INSERT INTO `circle_news_from` VALUES (14, '水利与土木工程学院', 1, 1, '2018-08-31 21:47:40', '2018-08-31 21:47:42');
INSERT INTO `circle_news_from` VALUES (15, '材料与能源学院', 1, 1, '2018-08-31 21:47:38', '2018-08-31 21:47:36');
INSERT INTO `circle_news_from` VALUES (16, '数学与信息学院、软件学院', 1, 1, '2018-08-31 21:39:55', '2018-08-31 21:39:55');
INSERT INTO `circle_news_from` VALUES (17, '电子工程学院', 1, 1, '2018-08-31 21:40:04', '2018-08-31 21:40:04');
INSERT INTO `circle_news_from` VALUES (18, '经济管理学院', 1, 1, '2018-08-31 21:40:16', '2018-08-31 21:40:16');
INSERT INTO `circle_news_from` VALUES (19, '公共管理学院', 1, 1, '2018-08-31 21:40:20', '2018-08-31 21:40:20');
INSERT INTO `circle_news_from` VALUES (20, '人文与法学学院', 1, 1, '2018-08-31 21:40:30', '2018-08-31 21:40:30');
INSERT INTO `circle_news_from` VALUES (21, '外国语学院', 1, 1, '2018-08-31 21:40:38', '2018-08-31 21:40:38');
INSERT INTO `circle_news_from` VALUES (22, '艺术学院', 1, 1, '2018-08-31 21:40:43', '2018-08-31 21:40:43');
INSERT INTO `circle_news_from` VALUES (23, '马克思主义学院', 1, 1, '2018-08-31 21:40:52', '2018-08-31 21:40:52');
INSERT INTO `circle_news_from` VALUES (24, '继续教育学院', 1, 1, '2018-08-31 21:43:28', '2018-08-31 21:43:28');
INSERT INTO `circle_news_from` VALUES (25, '国际教育学院', 1, 1, '2018-08-31 21:43:41', '2018-08-31 21:43:41');
INSERT INTO `circle_news_from` VALUES (26, '创新创业学院', 1, 1, '2018-08-31 21:44:26', '2018-08-31 21:44:26');
INSERT INTO `circle_news_from` VALUES (27, '现代教育技术中心', 1, 1, '2018-08-31 21:44:48', '2018-08-31 21:44:48');
INSERT INTO `circle_news_from` VALUES (28, '公共基础课实验教学中心', 1, 1, '2018-08-31 21:45:37', '2018-08-31 21:45:37');
INSERT INTO `circle_news_from` VALUES (29, '工程基础教学与训练中心', 1, 1, '2018-08-31 21:47:30', '2018-08-31 21:47:32');
INSERT INTO `circle_news_from` VALUES (30, 'test', 1, 0, '2018-08-31 21:49:18', '2018-08-31 21:49:18');

SET FOREIGN_KEY_CHECKS = 1;
