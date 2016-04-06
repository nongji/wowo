DROP SCHEMA IF EXISTS wowo;
CREATE SCHEMA wowo;

SET MODE MYSQL; -- 设置MySQL模式

CREATE TABLE wowo.user (
  id             int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  number         bigint(20) NOT NULL COMMENT '用户编号',
  name           varchar(45)      DEFAULT NULL COMMENT '用户名',
  mobile         varchar(20)      DEFAULT NULL COMMENT '手机号',
  mobile_verify  tinyint(4) DEFAULT NULL COMMENT '手机号验证状态',
  email          varchar(45)      DEFAULT NULL COMMENT '邮件地址',
  email_verify   tinyint(4) DEFAULT NULL COMMENT '邮件地址验证状态',
  login_password varchar(256) NOT NULL COMMENT '登录密码',
  status         tinyint(4) DEFAULT NULL COMMENT '用户状态',
  created_at     timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at     timestamp NULL DEFAULT NULL COMMENT '更新时间',
  domain         VARCHAR(30) DEFAULT NULL
  COMMENT '个性域名，最多30个字符',
  PRIMARY KEY (id),
  UNIQUE KEY number_UNIQUE (number),
  UNIQUE KEY mobile_UNIQUE (mobile),
  UNIQUE KEY name_UNIQUE (name),
  UNIQUE KEY email_UNIQUE (email)
);

