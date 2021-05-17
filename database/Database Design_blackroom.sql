#小黑屋表(在用户表创建后创建)
CREATE TABLE b_black_room(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	ban_info_id INT unsigned NOT NULL UNIQUE,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#小黑屋信息表
CREATE TABLE b_ban_info(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	user_id INT unsigned,
	ban_type VARCHAR(16) COMMENT '封禁类型' NOT NULL,
	ban_cause_id INT unsigned NOT NULL UNIQUE,
	ban_time DATETIME COMMENT '封禁时间' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
-- 	FOREIGN KEY(ban_info_id) REFERENCES b_black_room(ban_info_id),
-- 	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#封禁信息表
CREATE TABLE b_ban_cause(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	ban_cause varchar(255) COMMENT '封禁原因' NOT NULL,
	gmt_create DATETIME COMMENT '封禁时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
-- 	FOREIGN KEY(ban_cause_id) REFERENCES b_ban_info(ban_cause_id)
);