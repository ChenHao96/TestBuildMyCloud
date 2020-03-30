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
`item_id`  int NOT NULL PRIMARY KEY,
`item_name`   VARCHAR(36) NOT NULL UNIQUE,
`status`    bit(1)  NOT NULL default 0,
`gmt_create`    TIMESTAMP not null,
KEY `status` (`status`) USING BTREE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;