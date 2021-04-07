#视频表
CREATE TABLE v_video(
	video_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	author_id INT NOT NULL,
	comment_id INT NOT NULL UNIQUE,
	video_info_id INT NOT NULL UNIQUE,
	video_location VARCHAR(255) NOT NULL, 
	img_id INT NOT NULL, 
	zone_id INT NOT NULL UNIQUE, 
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(author_id) REFERENCES u_user(user_id),
	FOREIGN KEY(img_id) REFERENCES pub_img(img_id)
);

#分区表
CREATE TABLE v_zone(
	zone_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	zone_type VARCHAR(20) NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(zone_id) REFERENCES v_video(zone_id)
);

#视频信息
CREATE TABLE v_video_info(
	video_info_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_id INT NOT NULL UNIQUE,
	video_pnumb LONG NOT NULL,
	video_coin LONG NOT NULL,
	video_title VARCHAR(80) NOT NULL,
	video_brief TEXT NOT NULL,
	audit_id INT NOT NULL UNIQUE,
	video_status_id INT NOT NULL UNIQUE,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(video_info_id) REFERENCES v_video(video_info_id)
);

#点赞表
CREATE TABLE v_like(
	like_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_number INT NOT NULL,
	like_type VARCHAR(10),
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(like_id) REFERENCES v_video_info(like_id)
);

#评论表1
CREATE TABLE v_comment_first(
	comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	comment_type VARCHAR(10) NOT NULL,
	comment_text VARCHAR(255) NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(comment_id) REFERENCES v_video(comment_id)
);

#评论表2
CREATE TABLE v_comment_second(
	comment_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	comment_type VARCHAR(10) NOT NULL,
	comment_text VARCHAR(255) NOT NULL,
	gmt_create DATETIME NOT NULL,
	gmt_modified DATETIME NOT NULL,
	FOREIGN KEY(comment_id) REFERENCES v_comment_first(comment_id)
);