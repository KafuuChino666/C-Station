# audit


# 审核员表
CREATE TABLE staff_auditor(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	staff_id INT unsigned NOT NULL COMMENT '员工id',
	audit_type INT unsigned NOT NULL COMMENT '审核类型',
	audit_num_today INT unsigned NOT NULL COMMENT '今日审核数',
	audit_num_month INT unsigned NOT NULL COMMENT '本月审核数',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

# 视频审核表
CREATE TABLE v_audit(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	auditor_id INT unsigned NOT NULL COMMENT '审核员id',
	discipline_info VARCHAR(64) NOT NULL COMMENT '违纪说明',
	auditor_info VARCHAR(64) NOT NULL COMMENT '视频审核员记录',
	audit_status INT unsigned NOT NULL COMMENT '审核状态',
	gmt_create DATETIME NOT NULL COMMENT '创建时间',
	gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)


# 视频审类型
CREATE TABLE v_audit_type(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	type_name VARCHAR(16) COMMENT '类型名称',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
)