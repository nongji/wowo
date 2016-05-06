DROP SCHEMA IF EXISTS wowo;
CREATE SCHEMA wowo;

SET MODE MYSQL; -- 设置MySQL模式

CREATE TABLE wowo.user (
  id             int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  name           varchar(45) NOT NULL DEFAULT '' COMMENT '用户名',
  mobile         varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  mobile_verify  tinyint(4) NOT NULL DEFAULT '1' COMMENT '手机号验证状态, 1: 未验证, 2: 已验证',
  email          varchar(45) NOT NULL DEFAULT '' COMMENT '邮件地址',
  email_verify   tinyint(4) NOT NULL DEFAULT '1' COMMENT '邮件地址验证状态, 1: 未验证, 2: 已验证',
  login_password varchar(256) NOT NULL DEFAULT '' COMMENT '登录密码',
  status         tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户状态: 1. 未激活 2.已激活 3. 已被锁定 4. 已删除',
  created_at     timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  updated_at     timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP /*ON UPDATE CURRENT_TIMESTAMP*/ COMMENT '更新时间',
  domain         VARCHAR(30) NOT NULL DEFAULT '' COMMENT '个性域名，最多30个字符',
  PRIMARY KEY (id),
  UNIQUE KEY mobile_UNIQUE (mobile),
  UNIQUE KEY name_UNIQUE (name),
  UNIQUE KEY email_UNIQUE (email)
) /*ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息'*/;


