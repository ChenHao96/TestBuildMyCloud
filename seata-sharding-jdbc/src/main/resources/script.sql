-- for AT mode you must to init this sql for you business database. the seata server not need it.
CREATE TABLE IF NOT EXISTS `undo_log`(
    `id`            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT 'increment id',
    `branch_id`     BIGINT(20)   NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(100) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME     NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME     NOT NULL COMMENT 'modify datetime',
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';

CREATE TABLE IF NOT EXISTS `t_user`(
`u_id`  BIGINT NOT NULL PRIMARY KEY,
`account`   VARCHAR(36) NOT NULL UNIQUE,
`nick_name` VARCHAR(50) NOT NULL,
`password`  VARCHAR(36),
`status`    bit(1)  NOT NULL default 0,
`gmt_create`    TIMESTAMP not null,
`gmt_modified`  TIMESTAMP not null,
KEY `nick_name` (`nick_name`) USING HASH,
KEY `status` (`status`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_user_package`(
`p_id`  BIGINT NOT NULL PRIMARY KEY,
`u_id`  BIGINT NOT NULL UNIQUE,
`item_id` int NOT NULL,
`item_count` int NOT NULL default 0,
`status`    bit(1)  NOT NULL default 0,
`gmt_create`    TIMESTAMP not null,
KEY `item_id` (`item_id`) USING BTREE,
KEY `status` (`status`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `t_item`(
`item_id`  int NOT NULL PRIMARY KEY AUTO_INCREMENT,
`item_name`   VARCHAR(36) NOT NULL UNIQUE,
`status`    bit(1)  NOT NULL default 0,
`gmt_create`    TIMESTAMP not null,
KEY `status` (`status`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;