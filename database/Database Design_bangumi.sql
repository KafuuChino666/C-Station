# 番剧表bg开头
CREATE TABLE bg_bangumi_indexs(
	bangumi_id INT PRIMARY KEY AUTO_INCREMENT,
	bangumi_type VARCHAR(32) COMMENT '番剧类型' NOT NULL,
	bangumi_info_id INT NOT NULL UNIQUE,
	bangumi_status_id INT UNIQUE NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);


#番剧信息
CREATE TABLE bg_bangumi_info(
	bangumi_info_id INT PRIMARY KEY AUTO_INCREMENT,
	bangumi_name VARCHAR(32) NOT NULL,
	bangumi_info_str TEXT NOT NULL,
	sub_bangumi_id INT,
	video_id INT,
	FOREIGN KEY(video_id) REFERENCES v_video(video_id)
)