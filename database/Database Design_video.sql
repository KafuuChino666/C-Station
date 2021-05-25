#视频表
CREATE TABLE v_video(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT, #视频id
	video_sort int unsigned not null,
	video_title varchar(32) not null,
	video_duration varchar(16) not null,
	video_location VARCHAR(255) COMMENT '视频信息' NOT NULL, 	 #视频地址
	video_info_id INT unsigned NOT NULL,								 #视频信息表
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(author_id) REFERENCES u_user(user_id),
	#FOREIGN KEY(img_id) REFERENCES pub_img(img_id)
);


#视频信息
CREATE TABLE v_video_info(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_id varchar(12) NOT NULL,
	play_nub varchar(12) COMMENT '播放数' NOT NULL,
	video_pnumb varchar(12) COMMENT '分享数' NOT NULL,
	video_coin int unsigned COMMENT '投币数' NOT NULL,
	audit_id INT unsigned NOT NULL,
	video_status INT unsigned NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(video_info_id) REFERENCES v_video(video_info_id)
);

#视频信息表分表字段
CREATE TABLE v_video_text(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	video_info_id INT unsigned NOT NULL,								 #视频信息表
	zone_id INT unsigned NOT NULL, 										 #类型
	img_id INT unsigned NOT NULL, 														 #图片id
	author_id INT unsigned NOT NULL,													 #作者id
	comment_id INT unsigned NOT NULL,									 #评论id
	video_title VARCHAR(128) COMMENT '视频标题' NOT NULL,
	video_brief varchar(200) COMMENT '视频简介' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);


#视频信息表分表字段
CREATE TABLE v_video_extra(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	video_info_id INT unsigned NOT NULL,
	tags VARCHAR(128) COMMENT '标签',
	is_innovate INT(4) unsigned NOT NULL COMMENT '自制声明',
	is_watermark INT(4) unsigned NOT NULL COMMENT '开启专属水印',
	video_caption VARCHAR(128) COMMENT '字幕', #预留
	is_commerce INT(4) unsigned NOT NULL COMMENT '商业声明',
	rests_cast_caption INT(4) unsigned NOT NULL COMMENT '允许观众投稿字幕',
	fan_dynamic varchar(200) COMMENT '粉丝动态',
	is_timing INT(4) unsigned NOT NULL COMMENT '定时发布',
	timing_time DATETIME COMMENT '定时时间' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
)

#点赞表
CREATE TABLE v_like(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	like_number VARCHAR(12) COMMENT '点赞数' NOT NULL DEFAULT '0',
	down_number VARCHAR(12) COMMENT '点踩数' not null DEFAULT '0',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(like_id) REFERENCES v_video_info(like_id)
);

#弹幕表
CREATE TABLE v_barrage(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT unsigned,
	video_id INT unsigned,
	barrage_str varchar(200) COMMENT '弹幕内容' NOT NULL,
	video_time TIME COMMENT '视频时间' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
	#FOREIGN KEY(user_id) REFERENCES v_video(video_id),
	#FOREIGN KEY(user_id) REFERENCES u_user(user_id)
);

-- #评论表1
-- CREATE TABLE v_comment_first(
-- 	comment_id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- 	comment_type VARCHAR(10) COMMENT '评论1类型' NOT NULL,
-- 	comment_text VARCHAR(255) COMMENT '评论1内容' NOT NULL,
-- 	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
-- 	gmt_modified DATETIME NOT NULL
-- );
-- 
-- #评论表2
-- CREATE TABLE v_comment_second(
-- 	comment_id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- 	comment_type VARCHAR(10) COMMENT '评论2类型' NOT NULL,
-- 	comment_text VARCHAR(255) COMMENT '评论2内容' NOT NULL,
-- 	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
-- 	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
-- );

#视频状态表
CREATE TABLE v_video_status(
	id INT unsigned PRIMARY KEY AUTO_INCREMENT,
	video_status VARCHAR(32) COMMENT '视频状态' NOT NULL,
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
);

#视频表索引

show index from pub_img;
show index from v_video_info;
show index from pub_zone;
show index from v_video_text;


use db02;
create index idx_pub_img_localtion on pub_img(img_location);
create index idx_text_infoIdta on v_video_text(video_info_id, video_title, author_id);
create index idx_zone_type on pub_zone(zone_type);
create index idx_info_nub on v_video_info(play_nub);
create index idx_status on v_video_status(id);

drop index idx_text_ on v_video_text;
drop index idx_info_nub on v_video_info;
drop index idx_status on v_video_status;

EXPLAIN SELECT img.img_location, text.video_title, text.author_id, zone.zone_type, info.play_nub, s.id
FROM v_video v 
LEFT JOIN v_video_info info ON v.`video_info_id` = info.`id`
left join v_video_text text on v.`video_info_id` = text.`video_info_id`
LEFT JOIN pub_zone zone ON text.`zone_id` = zone.`id`
LEFT JOIN pub_img img ON img.`id` = text.`img_id`
left join v_video_status s on info.`video_status` = s.`id`
where v.id=1 
and text.video_title = '人之初性本色'
and text.author_id = 1
and v.gmt_create > '2021-05-18 11:54:40'
and v.gmt_create < '2021-05-18 11:54:43'
and info.play_nub = '79038'
and s.id = 1;

select * from v_video_text;

#索引
show index from u_user;
show index from v_video_info;
show index from v_like;
show index from pub_zone;
show index from v_video_text;

create index idx_video_v on v_video(video_id);
create index idx_user_username on u_user(user_name);
create index idx_text_iatb on v_video_text(video_info_id, author_id, video_title, video_brief);
create index idx_info_gppc on v_video_info(video_info_id, gmt_create, play_nub, video_pnumb, video_coin);
create index idx_lk_ud on v_like(like_number, down_number);
create index idx_status_status on v_video_status(video_status);

create index idx_text_infoid on v_video_text(video_info_id);

drop index idx_info_gppcs on v_video_info;



EXPLAIN SELECT v.id, text.author_id, u.user_name, text.video_title, text.video_brief, info.gmt_create, info.play_nub, info.video_pnumb, info.video_coin, lk.like_number, lk.down_number, zone.zone_type, s.id, v.video_location
FROM  v_video v
LEFT JOIN v_video_info info ON v.`video_info_id` = info.`id`
left join v_video_text text on v.`video_info_id` = text.`video_info_id`
LEFT JOIN u_user u ON text.`author_id` = u.`id`
LEFT JOIN v_like lk ON info.`like_id` = lk.`id`
LEFT JOIN pub_zone zone ON text.`zone_id` = zone.`id`
left join v_video_status s on info.`video_status` = s.`id`
where v.id=1;


show index from v_video_info;
show index from v_video_status;

create index idx_video_idstatus on v_video_status(id, video_status);

EXPLAIN SELECT id, video_status FROM v_video_status;

drop index indx_video_status on v_video_info;