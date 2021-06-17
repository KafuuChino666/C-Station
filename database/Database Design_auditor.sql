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
-- CREATE TABLE v_audit(
-- 	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
-- 	auditor_id INT unsigned NOT NULL COMMENT '审核员id',
-- 	discipline_info VARCHAR(64) NOT NULL COMMENT '违纪说明',
-- 	auditor_info VARCHAR(64) NOT NULL COMMENT '视频审核员记录',
-- 	audit_status INT unsigned NOT NULL COMMENT '审核状态',
-- 	gmt_create DATETIME NOT NULL COMMENT '创建时间',
-- 	gmt_modified DATETIME NOT NULL COMMENT '修改时间'
-- )
-- 

# 视频审类型
CREATE TABLE v_audit_type(
	id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
	type_name VARCHAR(16) COMMENT '类型名称',
	gmt_create DATETIME COMMENT '创建时间' NOT NULL,
	gmt_modified DATETIME COMMENT '修改时间' NOT NULL
)



/**
	工作流程表
	删除了 上述的v_audit表替换为 video_audit_status 表
**/

# 流程表 work_flow
CREATE TABLE work_flow(
		id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
		flow_name VARCHAR(100) COMMENT '流程名称' NOT NULL,
		remark VARCHAR(200) COMMENT '备注',
		gmt_create DATETIME NOT NULL COMMENT '创建时间',
		gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

# 流程节点表 work_flow_node
CREATE TABLE work_flow_node(
		id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
		flow_id INT unsigned COMMENT '流程号' NOT NULL,
		flow_node_name VARCHAR(100) COMMENT '流程节点名称' NOT NULL,
		flow_node_role INT unsigned COMMENT '流程角色' NOT NULL,
		remark VARCHAR(200) COMMENT '备注',
		gmt_create DATETIME NOT NULL COMMENT '创建时间',
		gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

# 流程线表 work_flow_line
CREATE TABLE work_flow_line(
		id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
		flow_id INT unsigned COMMENT '流程号' NOT NULL,
		prev_node_id INT unsigned COMMENT '前一节点编号' NOT NULL,
		next_node_id INT unsigned COMMENT '后一节点编号' NOT NULL,
		remark VARCHAR(200) COMMENT '备注',
		gmt_create DATETIME NOT NULL COMMENT '创建时间',
		gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

# 角色和节点
CREATE TABLE work_flow_node_role(
		id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT,
		node_id INT unsigned COMMENT '节点号' NOT NULL,
		role_id INT unsigned COMMENT '角色id' NOT NULL,
		gmt_create DATETIME NOT NULL COMMENT '创建时间',
		gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

# 审批状态 video_audit_status
CREATE TABLE v_audit_status(
		id INT unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT, # 审批编号
		v_id INT unsigned COMMENT '视频id' NOT NULL,
		flow_id INT unsigned COMMENT '流程号' NOT NULL,
		current_node INT unsigned COMMENT '当前节点编号' NOT NULL,
		auditor_id INT unsigned COMMENT '审核员id(表示当前正在操作的审核员id)',
		discipline_info VARCHAR(200) NOT NULL COMMENT '违纪说明',
		audit_status INT unsigned NOT NULL COMMENT '审核状态(0: 为审核; 1: 审核通过; 2:未通过)',
		auditor_info VARCHAR(64) NOT NULL COMMENT '视频审核员记录',
		gmt_create DATETIME NOT NULL COMMENT '创建时间',
		gmt_modified DATETIME NOT NULL COMMENT '修改时间'
)

gmt_create
author_id
video_title
zone_id
audit_status

