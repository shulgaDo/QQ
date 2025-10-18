### 做一个类似QQ的项目，使用的技术栈有
* SpringBoot
* MySQL
* Spring Data JPA
* Redis
* 
# 数据库表设计
/*
Navicat Premium Data Transfer

Source Server         : booker
Source Server Type    : MySQL
Source Server Version : 80017
Source Host           : localhost:3306
Source Schema         : qq

Target Server Type    : MySQL
Target Server Version : 80017
File Encoding         : 65001

Date: 18/10/2025 16:35:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for add_friend_apply
-- ----------------------------
DROP TABLE IF EXISTS `add_friend_apply`;
CREATE TABLE `add_friend_apply`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`friend_account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`status` tinyint(4) NULL DEFAULT 0 COMMENT '0: 待处理, 1: 已同意, 2: 已拒绝',
`remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
`message` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证信息',
`friend_group` tinyint(4) NULL DEFAULT 0 COMMENT '分组',
`status_permission` tinyint(4) NULL DEFAULT NULL COMMENT '好友权限',
`avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`create_at` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for album_comment
-- ----------------------------
DROP TABLE IF EXISTS `album_comment`;
CREATE TABLE `album_comment`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`album_id` bigint(255) NULL DEFAULT NULL COMMENT '相册ID',
`user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户ID',
`avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
`comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户评论',
`nickname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
`comment_time` datetime NULL DEFAULT NULL COMMENT '评论时间',
`create_at` datetime NULL DEFAULT NULL,
`is_deleted` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for album_photo
-- ----------------------------
DROP TABLE IF EXISTS `album_photo`;
CREATE TABLE `album_photo`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`album_id` bigint(255) NULL DEFAULT NULL,
`upload_time` date NULL DEFAULT NULL COMMENT '上次日期',
`photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片url',
`create_at` date NULL DEFAULT NULL COMMENT '创建日期',
`is_deleted` int(1) NULL DEFAULT 0,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for album_recycle
-- ----------------------------
DROP TABLE IF EXISTS `album_recycle`;
CREATE TABLE `album_recycle`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
`user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户ID',
`update_at` datetime NULL DEFAULT NULL COMMENT '修改时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info_photo
-- ----------------------------
DROP TABLE IF EXISTS `info_photo`;
CREATE TABLE `info_photo`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户ID',
`photo_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片URL',
`is_deleted` tinyint(2) NULL DEFAULT NULL COMMENT '是否删除(0表示没删除，1表示已经删除)',
`upload_at` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '新增时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info_school
-- ----------------------------
DROP TABLE IF EXISTS `info_school`;
CREATE TABLE `info_school`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL,
`school_type` int(1) NULL DEFAULT NULL COMMENT '学校类型',
`school` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
`start_date` int(5) NULL DEFAULT NULL COMMENT '入学时间',
`public_show` int(1) NULL DEFAULT 1 COMMENT '公开教育经历',
`allow_fine` int(1) NULL DEFAULT 1 COMMENT '允许校友发现我',
`update_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for info_university
-- ----------------------------
DROP TABLE IF EXISTS `info_university`;
CREATE TABLE `info_university`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL,
`university` int(10) NULL DEFAULT NULL COMMENT '大学',
`start_date` int(5) NULL DEFAULT NULL COMMENT '入学日期',
`department` int(5) NULL DEFAULT NULL COMMENT '院系',
`degree` int(5) NULL DEFAULT NULL COMMENT '学历',
`public_show` int(1) NULL DEFAULT 1 COMMENT '公开交予经历(1表示允许，0表示否）',
`allow_find` int(1) NULL DEFAULT 1 COMMENT '允许校友发现我(1表示允许，0表示否）',
`update_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
`password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
`is_lock` bit(1) NULL DEFAULT b'0' COMMENT '是否被冻结(0表示未被冻结，1表示被冻结)',
`created_at` datetime NULL DEFAULT NULL COMMENT '注册时间',
`is_deleted` bit(1) NULL DEFAULT b'0' COMMENT '是否注销(0表示未被注销，1表示被注销)',
`update_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_album
-- ----------------------------
DROP TABLE IF EXISTS `user_album`;
CREATE TABLE `user_album`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL,
`album_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相册描述',
`album_num` int(10) NULL DEFAULT NULL COMMENT '相片数量',
`album_status` int(5) NULL DEFAULT NULL COMMENT '相册权限',
`create_at` datetime NULL DEFAULT NULL COMMENT '相册创建时间',
`is_deleted` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '是否删除(默认为0未删除，1已删除)',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_friends
-- ----------------------------
DROP TABLE IF EXISTS `user_friends`;
CREATE TABLE `user_friends`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL,
`friend_id` bigint(255) NULL DEFAULT NULL,
`remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '好友备注',
`group_id` int(50) NULL DEFAULT NULL COMMENT '好友分组',
`status` tinyint(1) NULL DEFAULT NULL COMMENT '好友状态(0表示已经删除，1表示正常)',
`create_time` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL COMMENT '用户ID',
`account` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
`avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
`signature` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名',
`nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
`gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别(0表示女，1表示男)',
`job` int(19) NULL DEFAULT NULL COMMENT '职业',
`company` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司',
`location` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地',
`hometown` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故乡',
`email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
`personal_statement` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人说明',
`update_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
`birth_year` int(1) NULL DEFAULT NULL COMMENT '出生年份',
`birth_day` int(1) NULL DEFAULT NULL COMMENT '出生日期',
`birth_month` int(1) NULL DEFAULT NULL COMMENT '出生月份',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_login_log
-- ----------------------------
DROP TABLE IF EXISTS `user_login_log`;
CREATE TABLE `user_login_log`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NOT NULL COMMENT '用户ID',
`ip_address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆ip地址',
`login_time` datetime NULL DEFAULT NULL COMMENT '登陆时间',
`status` tinyint(1) NULL DEFAULT 1 COMMENT '登陆状态(0表示没有登陆，1表示已经登陆)',
`update_at` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_status
-- ----------------------------
DROP TABLE IF EXISTS `user_status`;
CREATE TABLE `user_status`  (
`id` bigint(255) NOT NULL AUTO_INCREMENT,
`user_id` bigint(255) NULL DEFAULT NULL,
`user_status` int(10) NULL DEFAULT 0 COMMENT '用户状态',
`create_at` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;



## user(用户表)

* id
* account(账号)
* password(密码)
* is_lock(是否被冻结)
* created_at(注册时间)
* is_deleted(是否注销)
* update_at(更新时间)

## user_login_log(用户登陆日志表)

* id
* user_id
* ip_address(ip地址)
* login_time(登陆时间)
* status(登陆状态)
* device(设备名称)
* update_at(更新时间)

## user_info(用户信息表)

* id
* user_id(用户ID)
* account(用户账号)
* avatar(用户头像)
* signature(签名)
* nickname(昵称)
* gender(性别)
* job(职业)
* company(公司)
* location(所在地)
* hometown(故乡)
* email(邮箱)
* personal_statement(个人说明)
* update_at(更新时间)
* birth_day(出生日期)
* birth_month(出生月份)
* birth_year(出生年份)

## info_photo(精选照片表)

* id
* user_id(用户ID)
* photo_url(照片URL)
* is_deleted(是否删除)
* upload_at(上传时间)

## API接口设计

1. 用户登陆接口(`/api/user/login`)  
    **请求参数**
    - ***account***:用户账号(必填)
    - ***password***:用户密码(必填)

    **请求方式**
    `POST`

    **返回值**
    - ***UserDTO***:用户账号信息
2. 用户登出接口(`/api/user/logout`)




# 懒得写了，QQ这个系统太复杂了！



