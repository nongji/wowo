DROP SCHEMA IF EXISTS cdb;
CREATE SCHEMA cdb;

SET MODE MYSQL; -- 设置MySQL模式

CREATE TABLE cdb.user (
  id BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
);