
#用户表
CREATE TABLE tb_user (
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(24) NOT NULL,
	user_sign VARCHAR(255),
	gender CHAR(1) DEFAULT'M' NOT NULL,
	gmt_create DATETIME NOT NULL,
	birth DATE,
	gmt_modified DATETIME NOT NULL
);
#insert into user_tb(user_name, user_sign, gender, birth) values('qweqwe', 'qweqwe', 'W','2000-02-12');

#图片表
CREATE TABLE tb_img (
	img_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	img_location VARCHAR(255),
	user_id INT,
	img_type INT,
	gmt_create DATETIME,
	gmt_modified DATETIME,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
);

########
#账号安全表
CREATE TABLE tb_safe (
	safe_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	email VARCHAR(20),
	phone INT,
	ep_id INT NOT NULL UNIQUE,
	rn_id INT NOT NULL UNIQUE,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
);

#密保问题表
CREATE TABLE tb_pb (
	ep_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	problem VARCHAR(255) NOT NULL,
	answer VARCHAR(18) NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(ep_id) REFERENCES tb_safe(ep_id)
);

#实名表
CREATE TABLE tb_realname (
	rn_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	realname VARCHAR(20) nnot NULL,
	ID_number VARCHAR(18) NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(rn_id) REFERENCES tb_safe(rn_id)
);

####
#积分表
CREATE TABLE tb_integral(
	integral_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	ig_balance INT NOT NULL,
	modify_cause VARCHAR NOT NULL,
	change_number INT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
)

#硬币表
CREATE TABLE tb_coin(
	coin_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	coin_balance INT NOT NULL, 
	modify_cause VARCHAR NOT NULL,
	change_number INT NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
)