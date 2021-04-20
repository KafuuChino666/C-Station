#视频表
CREATE TABLE v_video(
	video_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	author_id INT NOT NULL,
	comment_id INT NOT NULL UNIQUE,
	video_info_id INT NOT NULL UNIQUE,
	video_location VARCHAR(255) COMMENT '视频信息' NOT NULL, 
	img_id INT NOT NULL, 
	zone_id INT NOT NULL UNIQUE, 
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(author_id) REFERENCES u_user(user_id),
	FOREIGN KEY(img_id) REFERENCES pub_img(img_id)
);

#视频信息
CREATE TABLE v_video_info(
	video_info_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_id INT NOT NULL UNIQUE,
	play_nub LONG COMMENT '播放数' NOT NULL,
	video_pnumb LONG COMMENT '分享数' NOT NULL,
	video_coin LONG COMMENT '投币数' NOT NULL,
	video_title VARCHAR(128) COMMENT '视频标题' NOT NULL,
	video_brief TEXT COMMENT '视频简介' NOT NULL,
	audit_id INT NOT NULL UNIQUE,
	video_status_id INT NOT NULL UNIQUE,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(video_info_id) REFERENCES v_video(video_info_id)
);

#点赞表
CREATE TABLE v_like(
	like_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_number INT COMMENT '点赞数' NOT NULL,
	like_type VARCHAR(10) COMMENT '赞/踩',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(like_id) REFERENCES v_video_info(like_id)
);

#弹幕表
CREATE TABLE v_barrage(
	barrage_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT,
	video_id INT,
	barrage_str TEXT COMMENT '弹幕内容' NOT NULL,
	video_time TIME COMMENT '视频时间' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(user_id) REFERENCES v_video(video_id),
	FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

#评论表1
CREATE TABLE v_comment_first(
	comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	comment_type VARCHAR(10) COMMENT '评论1类型' NOT NULL,
	comment_text VARCHAR(255) COMMENT '评论1内容' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(comment_id) REFERENCES v_video(comment_id)
);

#评论表2
CREATE TABLE v_comment_second(
	comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	comment_type VARCHAR(10) COMMENT '评论2类型' NOT NULL,
	comment_text VARCHAR(255) COMMENT '评论2内容' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL,
	FOREIGN KEY(comment_id) REFERENCES v_comment_first(comment_id)
);