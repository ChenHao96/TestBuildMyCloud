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
@TableName("t_user_package")
public class TUserPackage implements Serializable {

    private static final long serialVersionUID = 850698006321946859L;

    @TableId(type = IdType.AUTO)
    private Long pId;

    private Long uId;

    private Integer itemId;

    private Integer itemCount;

    private Boolean status;

    private Date gmtCreate;
}