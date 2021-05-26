
#用户表
CREATE TABLE u_user (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_passwd VARCHAR(32) COMMENT '用户密码' NOT NULL,
	user_name VARCHAR(64) COMMENT '昵称' NOT NULL,
	user_sign VARCHAR(255) COMMENT '用户签名',
	`status` varchar(12) COMMENT '用户状态',
	gender CHAR(1) COMMENT '性别' DEFAULT'男' NOT NULL,
	birth DATE COMMENT '生日',
	category_id int unsigned not null DEFAULT 1, 
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);
#insert into user_tb(user_name, user_sign, gender, birth) values('qweqwe', 'qweqwe', 'W','2000-02-12');

########
#账号安全表
CREATE TABLE u_safe (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT unsigned,
	email VARCHAR(20) COMMENT '邮箱',
	phone varchar(20) COMMENT '电话号码',
	ep_id INT unsigned NOT NULL DEFAULT 0,
	rn_id INT unsigned NOT NULL DEFAULT 0,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

create table u_category (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	category varchar(12) COMMENT '会员类型' not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#密保问题表
CREATE TABLE u_pb (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	problem VARCHAR(255) COMMENT '密保问题' NOT NULL,
	answer VARCHAR(255) COMMENT '密保答案' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(ep_id) REFERENCES u_safe(ep_id)
);

#实名表
CREATE TABLE u_realname (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	realname VARCHAR(20) COMMENT '真实姓名' NOT NULL,
	ID_number VARCHAR(18) COMMENT '身份证号' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(rn_id) REFERENCES u_safe(rn_id)
);

####
#积分表
CREATE TABLE u_integral(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT unsigned,
	ig_balance INT unsigned COMMENT '积分余额' NOT NULL,
	modify_cause VARCHAR(255) COMMENT '消费原因' NOT NULL,
	change_number INT unsigned COMMENT '消费数额' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#硬币表
CREATE TABLE u_coin(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT unsigned,
	coin_balance INT COMMENT '硬币余额' NOT NULL, 
	modify_cause VARCHAR(255) COMMENT '投币信息' NOT NULL,
	change_number INT unsigned COMMENT '投币数额' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#钱包表
CREATE TABLE u_e_wallet(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	c_money INT unsigned COMMENT 'c币余额' NOT NULL,
	c_total int unsigned comment 'c币总数' not null,
	user_id INT unsigned,
	order_id INT unsigned NOT NULL,
	expend_type VARCHAR(32) COMMENT '消费类型',
	modify_cause VARCHAR(255) COMMENT '消费信息' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#预留:订单表

#关注表
CREATE TABLE u_follow(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	follow_id INT unsigned NOT NULL,
	user_id INT unsigned NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#黑名单表
CREATE TABLE u_blacklist(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	black_id INT unsigned NOT NULL,
	user_id INT unsigned NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#收藏夹表
CREATE TABLE u_facorites(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	user_id INT unsigned,
	facorites_name VARCHAR(32) COMMENT '收藏夹名' NOT NULL,
	collect_id INT unsigned,
	# 视频id是要计算收藏夹的总播放量
	video_id INT unsigned,
	facorites_status VARCHAR(16) COMMENT '收藏夹状态' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id),
	#FOREIGN KEY(video_id) REFERENCES v_video(video_id)
);

#收藏表
CREATE TABLE u_collect(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	video_id INT unsigned,
	facorites_id INT unsigned,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(video_id) REFERENCES v_video(video_id),
	#FOREIGN KEY(collect_id) REFERENCES u_facorites(collect_id),
	#FOREIGN KEY(facorites_id) REFERENCES u_facorites(facorites_id)
	
);

# 订阅表
CREATE TABLE u_subscription (
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT unsigned,
	sub_sitcom_id INT unsigned NOT NULL,
	sub_bangumi_id INT unsigned,
	label_id INT unsigned NOT NULL, 
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id),
	#FOREIGN KEY(sub_bangumi_id) REFERENCES u_sub_bangumi(sub_bangumi_id)
);

#追番表
CREATE TABLE u_sub_bangumi (
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	user_id INT unsigned,
	bangumi_info_id INT unsigned,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id),
	#FOREIGN KEY(bangumi_info_id) REFERENCES bg_bangumi_info(bangumi_info_id)
);

#记录用户点赞视频
CREATE TABLE u_like_video(
	id int unsigned primary key auto_increment,
	user_id int unsigned not null,
	video_id int unsigned not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#记录用户点赞评论
CREATE TABLE u_like_comment(
	id int unsigned primary key auto_increment,
	user_id int unsigned not null,
	comment_id int unsigned not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#记录用户点赞专栏
CREATE TABLE u_like_column(
	id int unsigned primary key auto_increment,
	user_id int unsigned not null,
	column_id int unsigned not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);


#查询用户所有数据
explain select u.id userId, u.user_name,r.realname, u.gender, c.id category, s.phone, w.c_total, r.ID_number idNumber, s.email 
from u_user u 
left join u_e_wallet w on w.user_id = u.id
left join u_category c on u.category_id = c.id
left join u_safe s on u.id = s.user_id
left join u_realname r on s.rn_id = r.id
where userId = 1
#根据条件查询用户数据

select u.id userId, u.user_name,r.realname, u.gender, c.id category, s.phone, w.c_total, r.ID_number IDNumber, s.email         
from u_user u         
left join u_e_wallet w on w.user_id = u.id         
left join u_category c on u.category_id = c.id         
left join u_safe s on u.id = s.user_id         
left join u_realname r on s.rn_id = r.id
LIMIT 0,4


SELECT COUNT(1) FROM u_user u 
LEFT JOIN u_e_wallet w ON w.user_id = u.id 
LEFT JOIN u_category c ON u.category_id = c.id 
LEFT JOIN u_safe s ON u.id = s.user_id 
LEFT JOIN u_realname r ON s.rn_id = r.id 
WHERE userId = 1;


select id, category from u_category;
