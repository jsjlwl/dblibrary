DROP DATABASE IF EXISTS dblibrary;
CREATE DATABASE dblibrary CHARACTER SET utf8 COLLATE utf8_general_ci;
DROP TABLE IF EXISTS dblibrary.user;
create table dblibrary.user
(
    uid int auto_increment comment '用户ID',
    user_name varchar(50) null comment '用户名称',
    user_age int null comment '用户年龄',
    user_pwd varchar(50) null comment '用户密码',
    constraint user_pk
        primary key (uid)
)
    comment '用户表';

