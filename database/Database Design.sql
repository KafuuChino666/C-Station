CREATE TABLE tb_user (
	user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(24),
	user_sign VARCHAR(255),
	gender CHAR(1) DEFAULT'M',
	userc_time DATETIME,
	birth DATE
);
#insert into user_tb(user_name, user_sign, gender, birth) values('qweqwe', 'qweqwe', 'W','2000-02-12');

CREATE TABLE tb_img (
	img_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	img_location VARCHAR(255),
	user_id INT,
	img_type INT,
	img_time DATETIME,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
);

########
CREATE TABLE tb_safe (
	safe_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	user_id INT,
	email VARCHAR(20),
	phone INT,
	ep_id INT NOT NULL UNIQUE,
	rn_id INT NOT NULL UNIQUE,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE tb_pb (
	ep_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	problem VARCHAR(255) NOT NULL,
	answer VARCHAR(18) NOT NULL,
	pbc_time DATETIME,
	FOREIGN KEY(ep_id) REFERENCES tb_safe(ep_id)
);

CREATE TABLE tb_realname (
	rn_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	realname VARCHAR(20),
	ID_number VARCHAR(18),
	rn_time DATETIME
	FOREIGN KEY(rn_id) REFERENCES tb_safe(rn_id)
);

####

CREATE TABLE tb_vip_total (
	vp_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	total_id INT NOT NULL UNIQUE,
	coin_id INT NOT NULL UNIQUE,
	user_id INT,
	FOREIGN KEY(user_id) REFERENCES tb_user(user_id)
);

CREATE TABLE tb_total (
	total_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	total_balance FLOAT NOT NULL,
	consumption_id INT NOT NULL UNIQUE,
	FOREIGN KEY(total_id) REFERENCES tb_vip_total(total_id)
);

CREATE TABLE tb_consumption (
	consumption_id
);