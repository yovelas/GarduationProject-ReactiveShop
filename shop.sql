/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2020-05-08 21:21:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(50) NOT NULL COMMENT '管理员姓名',
  `admin_pwd` varchar(50) NOT NULL COMMENT '管理员密码',
  `salt` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', '123456', '2020-05-07 20:51:57', '2020-05-07 20:52:01', '0');
INSERT INTO `admin` VALUES ('2', 'gg', 'b10355dd3af5d7686a7f8d22f5ccc3e4', '3dc699762a33', '2020-05-07 21:00:14', '2020-05-07 21:20:11', '0');
INSERT INTO `admin` VALUES ('3', 'aa', '5a16fcfd779daa012483463855b6da57', 'be8355b78d53', '2020-05-07 21:08:57', '2020-05-07 21:08:57', '0');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `focus_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `users_id` int(11) NOT NULL COMMENT '用户ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `focus_time` datetime NOT NULL COMMENT '关注时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`focus_id`),
  KEY `users_id` (`users_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `focus_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `focus_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focus
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(50) NOT NULL COMMENT '商品名',
  `goods_oprice` double NOT NULL COMMENT '原价',
  `goods_price` double NOT NULL COMMENT '现价',
  `goods_store` int(11) NOT NULL COMMENT '库存',
  `goods_picture` varchar(50) DEFAULT NULL COMMENT '图片',
  `goods_describe` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `goodstype_id` int(11) NOT NULL COMMENT '类型ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`goods_id`),
  KEY `goodstype_id` (`goodstype_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`goodstype_id`) REFERENCES `goodstype` (`goodstype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `goodstype_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型ID',
  `goodstype_name` varchar(50) NOT NULL COMMENT '商品类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`goodstype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '服饰', '2020-05-08 17:38:06', '2020-05-08 17:38:09', '0');
INSERT INTO `goodstype` VALUES ('2', '家具', '2020-05-08 17:38:36', '2020-05-08 17:38:38', '0');
INSERT INTO `goodstype` VALUES ('3', '电器', '2020-05-08 17:38:36', '2020-05-08 21:18:41', '1');

-- ----------------------------
-- Table structure for orderbasis
-- ----------------------------
DROP TABLE IF EXISTS `orderbasis`;
CREATE TABLE `orderbasis` (
  `orderbasis_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `users_id` int(11) NOT NULL COMMENT '用户ID',
  `amount` double NOT NULL COMMENT '金额',
  `status` int(11) NOT NULL COMMENT '状态',
  `orderdate` datetime NOT NULL COMMENT '下单时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`orderbasis_id`),
  KEY `users_id` (`users_id`),
  CONSTRAINT `orderbasis_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderbasis
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orders_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `orderbasis_id` int(11) NOT NULL COMMENT '订单ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `shoppingnum` int(11) NOT NULL COMMENT '购买数量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`orders_id`),
  KEY `goods_id` (`goods_id`),
  KEY `orderbasis_id` (`orderbasis_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`orderbasis_id`) REFERENCES `orderbasis` (`orderbasis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for shopping
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `shopping_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `users_id` int(11) NOT NULL COMMENT '用户ID',
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `shoppingnum` int(11) NOT NULL COMMENT '购买数量',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`shopping_id`),
  KEY `users_id` (`users_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `shopping_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`users_id`),
  CONSTRAINT `shopping_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `users_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `users_name` varchar(50) NOT NULL COMMENT '用户名',
  `users_pwd` varchar(50) NOT NULL COMMENT '用户密码',
  `salt` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `is_del` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'aa', '123456', '123456', '2020-05-08 09:57:11', '2020-05-08 09:57:15', '0');
INSERT INTO `users` VALUES ('2', 'bb', 'fa119d805e9b12b7f9e57d0921408bad', '33cbf2763aae', '2020-05-08 10:28:59', '2020-05-08 10:28:59', '0');
INSERT INTO `users` VALUES ('3', 'gg', 'a0220ac5aa4d4920327425290ca09779', '1dc6ed3874c3', '2020-05-08 09:57:11', '2020-05-08 10:46:14', '0');
