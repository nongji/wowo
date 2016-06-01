DROP SCHEMA IF EXISTS wowo;
CREATE SCHEMA wowo;

SET MODE MYSQL; -- 设置MySQL模式

-- 系统用户基本信息

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
  domain         VARCHAR(30) NOT NULL DEFAULT '' comment '个性域名，最多30个字符',
  PRIMARY KEY (id),
  UNIQUE KEY mobile_UNIQUE (mobile),
  UNIQUE KEY name_UNIQUE (name),
  UNIQUE KEY email_UNIQUE (email)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息' */;


-- 农机机主信息

CREATE TABLE wowo.machine_owner (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  user_id int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  user_type tinyint(2) NOT NULL DEFAULT 0 COMMENT '商户类型: 0: 其他 1: 个人 2： 公司  3: 合作社',
  location varchar(127) NOT NULL DEFAULT '' COMMENT '用户所在地',
  lng double NOT NULL COMMENT '经度',
  lat double NOT NULL COMMENT '纬度 ',
  id_card_1 int(11) NOT NULL DEFAULT 0 COMMENT '身份证正面',
  id_card_2 int(11) NOT NULL DEFAULT 0 COMMENT '身份证反面',
  certificate_1 int(11) NOT NULL DEFAULT 0 COMMENT '',
  certificate_2 int(11) NOT NULL DEFAULT 0 COMMENT '',

  PRIMARY KEY (id)
) /*ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='农机机主信息' */;


-- 农机基本信息表

CREATE TABLE wowo.machine (
  id               INT(11)      NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  user_id          INT(11)      NOT NULL DEFAULT 0 COMMENT '所属人用户id',
  drive_type       TINYINT (3) NOT NULL DEFAULT 0 COMMENT '驱动类型',

  driver_name      VARCHAR(255) NOT NULL DEFAULT ''COMMENT '司机姓名',
  driver_age       TINYINT (3) NOT NULL COMMENT '司机年龄',
  driver_gender    TINYINT (1) NOT NULL COMMENT '性别',

  license_type     TINYINT (3) NOT NULL COMMENT '驾照类型',
  machine_type     INT(11)      NOT NULL COMMENT '机器类型',
  machine_name     VARCHAR(255) NOT NULL DEFAULT ''COMMENT '机器名称',
  machine_power    TINYINT (4) NOT NULL COMMENT '机器马力',
  passenger_num    TINYINT (3) NOT NULL COMMENT '可载客数量',
  wheel_distance   DOUBLE       NOT NULL COMMENT '轮距',
  check_time       TIMESTAMP    NOT NULL COMMENT '',
  pay_type         TINYINT (3) NOT NULL COMMENT '支付方式',
  lease_month      INT(5) COMMENT '租赁月份',
  lease_time       DOUBLE COMMENT '租赁时间',
  work_condition   TINYINT (3) NOT NULL COMMENT '工作环境',
  need_type        TINYINT (3) NOT NULL COMMENT '是否自备',
  with_item        TINYINT (3) NOT NULL COMMENT '',
  house_type       TINYINT (3) NOT NULL COMMENT '农机库',

  driver_license   INT(11)      NOT NULL DEFAULT 0 COMMENT '驾照信息',
  machine_license1 INT(11)      NOT NULL DEFAULT 0 COMMENT '',
  machine_license2 INT(11)      NOT NULL DEFAULT 0 COMMENT '',


  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='农机基本信息' */;


-- 农机扩展信息表, 用于存放不常用和较大字段
CREATE TABLE wowo.machine_ext (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  machine_id int(11) NOT NULL DEFAULT 0 COMMENT '对应的农机id',
  detail varchar(10240) NOT NULL DEFAULT '' COMMENT '详情字段',
  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='农机扩展信息' */;


-- 驾照信息

CREATE TABLE wowo.driver_license (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',

  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='驾照信息'*/;

-- 位置信息

CREATE TABLE wowo.area (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',

  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='位置信息' */;

-- 审核记录表

CREATE TABLE wowo.audit_history (
  id INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  status tinyint(2) NOT NULL DEFAULT 0 COMMENT '审核状态 0: 待审核 1: 已通过 2: 已拒绝 ',
  refuse_type tinyint(3) NOT NULL DEFAULT 0 COMMENT '拒绝理由分类',
  refuse_reason varchar(511) NOT NULL DEFAULT '' COMMENT '拒绝愿意: 详细描述',
  type tinyint(3) NOT NULL DEFAULT 0 COMMENT '审核类型 0:未知 1：农机 2：用户身份 3:驾驶证 4:行驶证',
  related_id int(11) NOT NULL DEFAULT 0 COMMENT '审核关联记录id',

  create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '审核记录创建时间',
  update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP /*ON UPDATE CURRENT_TIMESTAMP*/ COMMENT '更新时间',
  finished_time timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '审核完成时间',

  PRIMARY KEY (id)
) /*ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核记录表' */;

-- 用户评论表

CREATE TABLE wowo.comment (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  publish_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论发表时间',
  type tinyint(2) NOT NULL DEFAULT 0 COMMENT '评论类型',
  related_id int(11) NOT NULL DEFAULT 0 COMMENT '评论关联id',
  parent_id int(11) NOT NULL DEFAULT 0 COMMENT '父评论id',
  user_id int(11) NOT NULL DEFAULT 0 COMMENT '回复发起用户的userId',
  commentted_user_id int(11) NOT NULL DEFAULT 0 COMMENT '被回复的用户',
  content varchar(1023) NOT NULL DEFAULT '' COMMENT '用户回复内容',

  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户评论表' */;

-- 用户敏感操作纪录

CREATE TABLE wowo.user_operation_log (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  user_id int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  type int(4) NOT NULL DEFAULT 0 COMMENT '用户操作类型',
  finished_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作发生时间',
  ip_address varchar(127) NOT NULL DEFAULT '' COMMENT '请求发起者ip地址',
  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户操作记录表'*/;

-- 资源文件

CREATE TABLE wowo.assets (
  id          INT(11)      NOT NULL AUTO_INCREMENT COMMENT '自增主键',

  base_path   VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文件基础路径',
  path        VARCHAR(255) NOT NULL DEFAULT '' COMMENT '文件路径',

  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文件创建时间',

  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件记录表' */;

-- 报价信息

CREATE TABLE wowo.quotation (
  id          INT(11)      NOT NULL AUTO_INCREMENT COMMENT '自增主键',


  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文件创建时间',

  PRIMARY KEY (id)
)/* ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报价信息表' */;
