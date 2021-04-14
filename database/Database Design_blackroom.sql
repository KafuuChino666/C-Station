#小黑屋表(在用户表创建后创建)
CREATE TABLE b_black_room(
	black_room_id INT PRIMARY KEY AUTO_INCREMENT,
	ban_info_id INT NOT NULL UNIQUE,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
)

#小黑屋信息表

CREATE TABLE b_ban_info(
	ban_info_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT,
	ban_type VARCHAR(16) COMMENT '封禁类型' NOT NULL,
	ban_cause VARCHAR(255) COMMENT '封禁原因' NOT NULL,
	ban_time DATETIME COMMENT '封禁时间' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(ban_info_id) REFERENCES b_black_room(ban_info_id),
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
)