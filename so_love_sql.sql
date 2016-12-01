/*创建用户信息表--userInfo*/
DROP TABLE IF EXISTS `solove_userInfo`;
CREATE TABLE `solove_userInfo` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userID',
  `getChoiceNum` int(11) DEFAULT 0 COMMENT '获赞数(有几个人对我有意向)',
  `setChoiceNum` int(11) DEFAULT 0 COMMENT '点赞数(对几个人有意向)',
  `userIntegral` int(11) DEFAULT 0 COMMENT '积分',
  `userLevel` varchar(10) NOT NULL DEFAULT 'general' COMMENT '用户级别, general:普通用户    member:会员',
  `loginName` varchar(50) DEFAULT NULL COMMENT '登录名',
  `passWord` varchar(50) DEFAULT NULL COMMENT '密码',
  `registerDate` TIMESTAMP NOT NULL DEFAULT now() COMMENT '注册普通用户日期',
  `isCurrent` varchar(10) NOT NULL DEFAULT 'normal' COMMENT '当前状态, normal:正常(默认) pause:暂停',
  `isDelete` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否删除, yes:已删除  no:未删除(默认)',
  PRIMARY KEY (`userID`)
) DEFAULT CHARSET=utf8;

/*创建用户照片表--solove_userInfoImg*/
DROP TABLE IF EXISTS `solove_userDetailInfo`;
CREATE TABLE `solove_userDetailInfo` (
  `userDetailInfoID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userDetailInfoID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `userSex` varchar(5) DEFAULT NULL COMMENT '性别, man:男   woman:女',
  `userAge` int(2) DEFAULT NULL COMMENT '年龄',
  `userName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `userNick` varchar(50) DEFAULT NULL COMMENT '昵称',
  `userPhone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `userHeadImage` varchar(50) DEFAULT NULL COMMENT '用户头像',
  `userNation` varchar(20) DEFAULT NULL COMMENT '民族',
  `userWork` varchar(20) DEFAULT NULL COMMENT '工作性质',
  `userFaith` varchar(20) DEFAULT NULL COMMENT '宗教信仰',
  `userBlood` varchar(2) DEFAULT NULL COMMENT '血型  A B O AB',
  `userHeight` int(5) DEFAULT NULL COMMENT '身高(cm)',
  `userWeight` int(5) DEFAULT NULL COMMENT '体重(公斤)',
  `userBirthday` date DEFAULT NULL COMMENT '生日',
  
  `userEvaluation` varchar(500) DEFAULT NULL COMMENT '自我评价',
  `userLovePlan` varchar(500) DEFAULT NULL COMMENT '爱情规划',
  
  `userEducation` int(2) NOT NULL DEFAULT 0 COMMENT '学历  0无、1小学、2初中、3高中、4大专、5专科、6本科、7硕士、8博士',
  `userIncomeLevel` int(2) DEFAULT NULL COMMENT '月收入范围   0:2000及以下  1:2001——10000  2:10000及以上',
  `userMaritalStatus` varchar(15) NOT NULL DEFAULT 'unmarried' COMMENT '婚姻状况  unmarried:未婚   remarried:离异',
  `userHaveCar` varchar(5) NOT NULL DEFAULT 'no' COMMENT '购车情况  no:没车   yes:有车',
  `userHaveHome` varchar(5) NOT NULL DEFAULT 'no' COMMENT '购房情况  no:没房   yes:有房',
  `provinceID` int(11) DEFAULT NULL COMMENT '省ID',
  `provinceName` varchar(50) DEFAULT NULL COMMENT '省名称',
  `cityID` int(11) DEFAULT NULL COMMENT '市ID',
  `cityName` varchar(50) DEFAULT NULL COMMENT '市名称',
  `countyID` int(11) DEFAULT NULL COMMENT '区县ID',
  `countyName` varchar(50) DEFAULT NULL COMMENT '区县名称',
  `townID` int(11) DEFAULT NULL COMMENT '村ID',
  `townName` varchar(50) DEFAULT NULL COMMENT '村名称',
  PRIMARY KEY (`userDetailInfoID`)
) DEFAULT CHARSET=utf8;

/*创建用户照片表--solove_userInfoImg*/
DROP TABLE IF EXISTS `solove_userInfoImg`;
CREATE TABLE `solove_userInfoImg` (
  `userImgID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userImgID',
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
  PRIMARY KEY (`userImgID`)
) DEFAULT CHARSET=utf8;

/*创建子女信息表--solove_childrenInfo*/
DROP TABLE IF EXISTS `solove_childrenInfo`;
CREATE TABLE `solove_childrenInfo` (
  `childrenID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'childrenID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `childrenSex` varchar(5) DEFAULT NULL COMMENT '性别, man:男   woman:女',
  `childrenAge` int(2) DEFAULT NULL COMMENT '年龄',
  `childrenRecommend` varchar(500) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`childrenID`)
) DEFAULT CHARSET=utf8;


/*创建会员信息表--solove_memberInfo*/
DROP TABLE IF EXISTS `solove_memberInfo`;
CREATE TABLE `solove_memberInfo` (
  `memberID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'memberID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `memberLevel` int(2) NOT NULL DEFAULT '1' COMMENT '会员等级,默认1级,级数越高权限越大',
  `beginDate` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '会员开启日期',
  `endDate` TIMESTAMP NOT NULL DEFAULT '2030-12-12 23:59:59' COMMENT '会员结束日期',
  PRIMARY KEY (`memberID`)
) DEFAULT CHARSET=utf8;

/*创建择偶信息表--solove_mateInfo*/
DROP TABLE IF EXISTS `solove_mateInfo`;
CREATE TABLE `solove_mateInfo` (
  `mateID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'mateID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `mateSex` varchar(5) DEFAULT NULL COMMENT '性别, man:男   woman:女',
  `mateAgeLevel` int(2) DEFAULT NULL COMMENT '年龄  0:-25  1:25-30 2:30-35  3:35-40  4:40-50 5:50+',
  `mateHeightLevel` int(2) DEFAULT NULL COMMENT '身高  0:-160 1:160-165  2:165-170  3:170-175  4:175-180 5:180+',
  `mateEducation` int(2) NOT NULL DEFAULT 0 COMMENT '学历  0无、1小学、2初中、3高中、4大专、5专科、6本科、7硕士、8博士',
  `mateIncomeLevel` varchar(50) DEFAULT NULL COMMENT '月收入范围   0:2000及以下  1:2001——10000  2:10000及以上',
  `mateMaritalStatus` varchar(15) NOT NULL DEFAULT 'unmarried' COMMENT '婚姻状况  unmarried:未婚   remarried:离异',
  `mateHaveCar` varchar(5) NOT NULL DEFAULT 'no' COMMENT '购车情况  no:没车   yes:有车',
  `mateHaveHome` varchar(5) NOT NULL DEFAULT 'no' COMMENT '购房情况  no:没房   yes:有房',
  `mateHaveChildren` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否有子女  no:没有   yes:有',
  `provinceID` int(11) DEFAULT NULL COMMENT '省ID',
  `provinceName` varchar(50) DEFAULT NULL COMMENT '省名称',
  `cityID` int(11) DEFAULT NULL COMMENT '市ID',
  `cityName` varchar(50) DEFAULT NULL COMMENT '市名称',
  `countyID` int(11) DEFAULT NULL COMMENT '区县ID',
  `countyName` varchar(50) DEFAULT NULL COMMENT '区县名称',
  `townID` int(11) DEFAULT NULL COMMENT '村ID',
  `townName` varchar(50) DEFAULT NULL COMMENT '村名称',
  PRIMARY KEY (`mateID`)
) DEFAULT CHARSET=utf8;


/*创建兴趣爱好表--solove_hobby*/
DROP TABLE IF EXISTS `solove_hobby`;
CREATE TABLE `solove_hobby` (
  `hobbyID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hobbyID',
  `parentHobbyID` int(11) NOT NULL COMMENT '父hobbyID',
  `content` varchar(50) DEFAULT NULL COMMENT '内容',
  `sort` int(5) NOT NULL DEFAULT '1' COMMENT '排序',
  `isParent` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否为父hobby, yes:是  no:否(默认)',
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

/*创建用户有权限查看信息的表--solove_user_hobby*/
DROP TABLE IF EXISTS `solove_userChoice`;
CREATE TABLE `solove_userChoice` (
  `userChoiceID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userChoiceID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '所属用户ID',
  `choiceUserID` int(11) NOT NULL DEFAULT '0' COMMENT '有权限查看的用户ID',
  `setChoice` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否有意向(是否点赞), yes:是  no:否',
  `getChoice` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否获得对方意向(是否获得回赞), yes:是  no:否',
  `choiceDate` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '有权限查看的开始日期',
  PRIMARY KEY (`userChoiceID`)
) DEFAULT CHARSET=utf8;

/*创建活动表--solove_activity*/
DROP TABLE IF EXISTS `solove_activity`;
CREATE TABLE `solove_activity` (
  `activityID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'activityID',
  `activityMoney` int(5) NOT NULL DEFAULT '0' COMMENT '参加活动金额',
  `activityStartTime` TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '活动开始时间',
  `activityEndTime` TIMESTAMP NOT NULL DEFAULT '2030-12-12 23:59:59' COMMENT '活动结束时间',
  `activityContent` varchar(255) DEFAULT NULL COMMENT '活动内容',
  `sort` int(5) NOT NULL DEFAULT '1' COMMENT '排序',
  `isCurrent` varchar(10) NOT NULL DEFAULT 'normal' COMMENT '当前状态, normal:正常(默认) pause:暂停',
  `isDelete` varchar(5) NOT NULL DEFAULT 'no' COMMENT '是否删除, yes:已删除  no:未删除(默认)',
  PRIMARY KEY (`activityID`)
) DEFAULT CHARSET=utf8;

/*创建用户_活动关联表--solove_user_activity*/
DROP TABLE IF EXISTS `solove_user_activity`;
CREATE TABLE `solove_user_activity` (
  `userActivityID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'userActivityID',
  `userID` int(11) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `activityID` int(11) NOT NULL DEFAULT '0' COMMENT '活动ID',
  PRIMARY KEY (`userActivityID`)
) DEFAULT CHARSET=utf8;















/*创建app设置表--solove_appSetting*/
DROP TABLE IF EXISTS `solove_appSetting`;
CREATE TABLE `solove_appSetting` (
  `appSettingID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'appSettingID',
  `appVersion` int(11) NOT NULL DEFAULT '0' COMMENT 'APP版本',
  PRIMARY KEY (`appSettingID`)
) DEFAULT CHARSET=utf8;
