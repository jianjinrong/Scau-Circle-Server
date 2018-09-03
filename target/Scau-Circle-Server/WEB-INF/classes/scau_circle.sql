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

 Date: 01/09/2018 11:52:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for circle_news
-- ----------------------------
DROP TABLE IF EXISTS `circle_news`;
CREATE TABLE `circle_news`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `url` varchar(625) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原文链接',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `pub_date` datetime(0) DEFAULT NULL COMMENT '发布时间',
  `from_id` int(11) UNSIGNED DEFAULT NULL COMMENT '来源对应的id',
  `click_times` int(11) DEFAULT NULL COMMENT '点击量',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文本内容',
  `status` tinyint(4) UNSIGNED NOT NULL COMMENT '状态，0为未启用，1为已启用，默认为1',
  `deleted_at` tinyint(4) UNSIGNED NOT NULL DEFAULT 1 COMMENT '软删除字段,0为已删除，1为未删除，默认为1',
  `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `from_id`(`from_id`) USING BTREE COMMENT '消息来源对应的外键',
  CONSTRAINT `circle_news_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `circle_news_from` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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

SET FOREIGN_KEY_CHECKS = 1;
