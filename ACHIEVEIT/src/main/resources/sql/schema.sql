create database achieveit;

use achieveit;

create table user(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
   user_name varchar(120) NOT NULL  DEFAULT '' COMMENT '用户名',
   password varchar(120) NOT NULL  DEFAULT '' COMMENT '密码',
   roles varchar(120) NOT NULL  DEFAULT '' COMMENT '用户角色',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   UNIQUE INDEX username_index(user_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

create table role(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
   role_name varchar(120) NOT NULL  DEFAULT '' COMMENT '角色名',
   description varchar(300) NOT NULL DEFAULT '' COMMENT '角色描述',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id),
   UNIQUE INDEX role_name_index(role_name)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

create table permission(
   id bigint NOT NULL AUTO_INCREMENT COMMENT '权限id',
   role_name varchar(120) NOT NULL  DEFAULT '' COMMENT '关联角色名',
   permission_name varchar(120) NOT NULL  DEFAULT '' COMMENT '权限名',
   description varchar(300) NOT NULL DEFAULT '' COMMENT '权限描述',
   create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   change_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更改时间',
   PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

#插入用户信息
insert into user(user_name,password,roles) values ('fjm','123','PM');
insert into user(user_name,password,roles) values ('br','123','');

#插入角色信息
insert into role(role_name,description) values('PS','项目上级');
insert into role(role_name,description) values('CMO','组织级配置管理员');
insert into role(role_name,description) values('EPG','项目改进小组');
insert into role(role_name,description) values('QA','质量监控');
insert into role(role_name,description) values('PM','项目经理');
insert into role(role_name,description) values('AM','项目资产管理员');
insert into role(role_name,description) values('TM','项目成员');

#插入权限信息
insert into permission(role_name,permission_name,description) values ('PS','','');
insert into permission(role_name,permission_name,description) values ('CMO','','');
insert into permission(role_name,permission_name,description) values ('CMO','','');
insert into permission(role_name,permission_name,description) values ('EPG','','');
insert into permission(role_name,permission_name,description) values ('QA','','');
insert into permission(role_name,permission_name,description) values ('PM','personManage','项目组员管理，可添加或者修改');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('PM','','');
insert into permission(role_name,permission_name,description) values ('AM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');
insert into permission(role_name,permission_name,description) values ('TM','','');