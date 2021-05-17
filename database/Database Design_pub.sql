#预留首页信息表
CREATE TABLE pub_hp_message(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT UNIQUE NOT NULL,
	zone_id INT UNIQUE NOT NULL,
	video_id INT UNIQUE NOT NULL,
	black_room_id INT UNIQUE NOT NULL,
	column_id INT UNIQUE NOT NULL,
	live_id INT UNIQUE NOT NULL,
	classroom_id INT UNIQUE NOT NULL,
	musicplus_id INT UNIQUE NOT NULL,
	play_center_id INT UNIQUE NOT NULL,
	customer_server_id INT UNIQUE NOT NULL,
	bangumi_id INT UNIQUE NOT NULL,
	cartoon_id INT UNIQUE NOT NULL,
	#FOREIGN KEY()
)
	
#分区表(在视频表创建后创建)
CREATE TABLE pub_zone(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	zone_type VARCHAR(20) COMMENT '分区类型' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(zone_id) REFERENCES v_video(zone_id)
);

#图片表(在用户表创建后创建)
CREATE TABLE pub_img (
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	img_location VARCHAR(255) COMMENT '图片地址' NOT NULL,
	user_id INT unsigned,
	img_type INT unsigned NOT NULL COMMENT '图片类型',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);
