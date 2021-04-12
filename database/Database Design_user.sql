
#用户表
CREATE TABLE u_user (
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_passwd VARCHAR(32) COMMENT '用户密码' NOT NULL,
	user_name VARCHAR(64) COMMENT '昵称' NOT NULL,
	user_sign VARCHAR(255) COMMENT '用户签名',
	gender CHAR(1) COMMENT '性别' DEFAULT'M' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	birth DATE COMMENT '生日',
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);
#insert into user_tb(user_name, user_sign, gender, birth) values('qweqwe', 'qweqwe', 'W','2000-02-12');

#图片表
CREATE TABLE pub_img (
	img_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	img_location VARCHAR(255) COMMENT '图片地址' NOT NULL,
	user_id INT,
	img_type INT NOT NULL COMMENT '图片类型',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

########
#账号安全表
CREATE TABLE u_safe (
	safe_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	email VARCHAR(20) COMMENT '邮箱',
	phone INT COMMENT '电话号码',
	ep_id INT NOT NULL UNIQUE,
	rn_id INT NOT NULL UNIQUE,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#密保问题表
CREATE TABLE u_pb (
	ep_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	problem VARCHAR(255) COMMENT '密保问题' NOT NULL,
	answer VARCHAR(255) COMMENT '密保答案' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(ep_id) REFERENCES u_safe(ep_id)
);

#实名表
CREATE TABLE u_realname (
	rn_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	realname VARCHAR(20) COMMENT '真实姓名' NOT NULL,
	ID_number VARCHAR(18) COMMENT '身份证号' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(rn_id) REFERENCES u_safe(rn_id)
);

####
#积分表
CREATE TABLE u_integral(
	integral_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	ig_balance INT COMMENT '积分余额' NOT NULL,
	modify_cause VARCHAR(255) COMMENT '消费原因' NOT NULL,
	change_number INT COMMENT '消费数额' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#硬币表
CREATE TABLE u_coin(
	coin_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	coin_balance INT COMMENT '硬币余额' NOT NULL, 
	modify_cause VARCHAR(255) COMMENT '投币信息' NOT NULL,
	change_number INT COMMENT '投币数额' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#钱包表
CREATE TABLE u_e_wallet(
	wallet_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	c_money INT COMMENT 'c币余额' NOT NULL,
	user_id INT,
	order_id INT NOT NULL,
	expend_type VARCHAR(32) COMMENT '消费类型',
	modify_cause VARCHAR(255) COMMENT '消费信息' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#预留:订单表

#关注表
CREATE TABLE u_follow(
	follow_tb_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	follow_id INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#黑名单表
CREATE TABLE u_blacklist(
	black_tb_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	black_id INT NOT NULL,
	user_id INT NOT NULL,
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);