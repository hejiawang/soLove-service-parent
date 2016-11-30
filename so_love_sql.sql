/*创建用户信息表--userInfo*/
DROP TABLE IF EXISTS `solove_userInfo`;
CREATE TABLE `solove_userInfo` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `userSex` varchar(5) DEFAULT NULL COMMENT '性别, man:男   woman:女',
  `userAge` int(2) DEFAULT NULL COMMENT '年龄',
  `userName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `userNick` varchar(50) DEFAULT NULL COMMENT '昵称',
  `userPhone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `userHeadImage` varchar(50) DEFAULT NULL COMMENT '用户头像',
  
  
  
  `userDetail` varchar(500) DEFAULT NULL COMMENT '简介',
  `userLevel` varchar(10) NOT NULL DEFAULT 'general' COMMENT '用户级别, general:普通用户    member:会员',
  `loginName` varchar(50) DEFAULT NULL COMMENT '登录名',
  `passWord` varchar(50) DEFAULT NULL COMMENT '密码',
  `registerDate` TIMESTAMP NOT NULL DEFAULT now() COMMENT '注册普通用户日期',
  `isCurrent` varchar(10) NOT NULL DEFAULT 'normal' COMMENT '当前状态, normal:正常(默认) pause:暂停',
  `isDelete` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否删除, yes:已删除  no:未删除(默认)',
  PRIMARY KEY (`userID`)
) DEFAULT CHARSET=utf8;

/*创建用户照片表--solove_userInfoImg*/
DROP TABLE IF EXISTS `solove_userInfoImg`;
CREATE TABLE `solove_userInfoImg` (
  `userImg` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userImg',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `userImage1` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage2` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage3` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage4` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage5` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage6` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage7` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage8` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage9` varchar(50) DEFAULT NULL COMMENT '用户照片',
  `userImage10` varchar(50) DEFAULT NULL COMMENT '用户照片',
  PRIMARY KEY (`userImg`)
) DEFAULT CHARSET=utf8;

/*创建会员信息表--solove_memberInfo*/
DROP TABLE IF EXISTS `solove_memberInfo`;
CREATE TABLE `solove_memberInfo` (
  `memberID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'memberID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `memberLevel` int(2) NOT NULL DEFAULT '1' COMMENT '会员等级,默认1级,级数越高权限越大',
  `beginDate` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '会员开启日期',
  `endDate` TIMESTAMP DEFAULT '2030-12-12 23:59:59' COMMENT '会员结束日期',
  PRIMARY KEY (`memberID`)
) DEFAULT CHARSET=utf8;

/*创建兴趣爱好表--solove_hobby*/
DROP TABLE IF EXISTS `solove_hobby`;
CREATE TABLE `solove_hobby` (
  `hobbyID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hobbyID',
  `content` varchar(50) DEFAULT NULL COMMENT '内容',
  `sort` int(5) NOT NULL DEFAULT '1' COMMENT '排序',
  `isCurrent` varchar(10) NOT NULL DEFAULT 'normal' COMMENT '当前状态, normal:正常(默认) pause:暂停',
  `isDelete` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否删除, yes:已删除  no:未删除(默认)',
  PRIMARY KEY (`hobbyID`)
) DEFAULT CHARSET=utf8;

/*创建用户——兴趣爱好关联表--solove_user_hobby*/
DROP TABLE IF EXISTS `solove_user_hobby`;
CREATE TABLE `solove_user_hobby` (
  `userHobbyID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userHobbyID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT 'userID',
  `hobbyID` int(11) NOT NULL DEFAULT '0' COMMENT 'hobbyID',
  PRIMARY KEY (`userHobbyID`)
) DEFAULT CHARSET=utf8;
