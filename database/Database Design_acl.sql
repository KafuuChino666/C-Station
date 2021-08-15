create table acl_staff
(
   id                   bigint not null auto_increment,
   username             varchar(64) comment '用户名',
   password             varchar(64) comment '密码',
   icon                 varchar(100) comment '头像',
   email                varchar(100) comment '邮箱',
   nick_name            varchar(100) comment '昵称',
   remark               varchar(200) comment '备注信息',
   status               int(1) default 1 comment '帐号启用状态：0：禁用；1：启用',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);

# 角色
create table acl_role
(
   id                   bigint not null auto_increment,
   name                 varchar(100) comment '名称',
   description          varchar(500) comment '描述',
   status               int(1) default 1 comment '启用状态：0->禁用；1->启用',
   sort                 int default 0,
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);

create table acl_staff_role
(
   id                   bigint not null auto_increment,
   staff_id             bigint,
   role_id              bigint,
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);


-- create table acl_menu
-- (
--    id                   bigint not null auto_increment,
--    parent_id            bigint comment '父级ID',
--    title                varchar(100) comment '菜单名称',
--    level                int(4) comment '菜单级数',
--    sort                 int(4) comment '菜单排序',
--    name                 varchar(100) comment '前端名称',
--    icon                 varchar(200) comment '前端图标',
--    hidden               int(1) comment '前端隐藏',
-- 	 gmt_create           datetime comment '创建时间',
--    gmt_modified         datetime comment '修改时间',
--    primary key (id)
-- );

create table acl_menu
(
   id                   bigint not null auto_increment,
   parent_id            bigint comment '父级ID',
   name                 varchar(100) comment '前端名称',
   icon                 varchar(50) comment '前端图标',
	 path									varchar(100) comment '访问路径',
	 component						varchar(100) comment '组件路径',
   level                int(4) comment '菜单级数',
   sort                 int(4) comment '菜单排序',
   hidden               int(1) comment '前端隐藏',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);


create table acl_resource
(
   id                   bigint not null auto_increment,
   name                 varchar(200) comment '资源名称',
   url                  varchar(200) comment '资源URL',
   description          varchar(200) comment '描述',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);


create table acl_role_menu
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   menu_id              bigint comment '菜单ID',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);


create table acl_role_resource
(
   id                   bigint not null auto_increment,
   role_id              bigint comment '角色ID',
   resource_id          bigint comment '资源ID',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);


# 首页视频推荐
CREATE table cms_recommend
(
   id                   bigint not null auto_increment,
	 v_id                 bigint comment '视频id',
	 priority             int comment '推送优先级',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);

# 首页轮播
CREATE TABLE cms_carousel
(
   id                   bigint not null auto_increment,
	 content              VARCHAR(200) comment '文字内容',
	 img_Url							VARCHAR(400) comment '图片url',
	 link                 VARCHAR(400) comment '跳转链接',
	 rank                 int comment '顺序',
	 reveal								INT(1) comment '是否显示',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);

# 广告
CREATE TABLE cms_advertising
(
   id                   bigint not null auto_increment,
	 title                VARCHAR(200) comment '标题',
	 u_id                 int comment 'uuid',
	 img_Url							VARCHAR(400) comment '图片url',
	 link                 VARCHAR(400) comment '跳转链接',
	 type                 int comment '广告类型',
	 reveal								INT(1) comment '是否显示',
	 gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   primary key (id)
);

