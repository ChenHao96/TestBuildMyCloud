package org.example.shardingJdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("t_user")
public class TUser implements Serializable {

    private static final long serialVersionUID = -77707053343087498L;

    @TableId(type = IdType.AUTO)
    private Long uId;

    private String account;

    private String nickName;

    private String password;

    private Boolean status;

    private Date gmtCreate;

    private Date gmtModified;
}