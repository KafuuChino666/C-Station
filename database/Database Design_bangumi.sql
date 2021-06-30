# 番剧状态表 bg开头
CREATE TABLE bg_status(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	bangumi_stat varchar(32) COMMENT '番剧状态' not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);


#番剧信息
CREATE TABLE bg_bangumi_info(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	bangumi_type_id int COMMENT '番剧类型' NOT NULL,
	bangumi_name VARCHAR(32) NOT NULL COMMENT '番剧名称' NOT NULL,
	bangumi_info_str varchar(255) NOT NULL COMMENT '番剧简介信息' NOT NULL,
	bangumi_status VARCHAR(20) COMMENT '番剧状态' NOT NULL,
	video_id INT unsigned,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(video_id) REFERENCES v_video(video_id),
	#FOREIGN KEY(sub_bangumi_id) REFERENCES u_sub_bangumi(sub_bangumi_id)
);

#番剧类型表
create table bg_type(
	id int unsigned primary key auto_increment,
	bangumi_type varchar(16) not null COMMENT '番剧类型',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#番剧更新时间表
create table bg_gettime(
	id int unsigned PRIMARY KEY AUTO_INCREMENT,
	bangumi_gettime varchar(128) COMMENT '更新时间' not null,
	bangumi_info_id int UNSIGNED not null,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);