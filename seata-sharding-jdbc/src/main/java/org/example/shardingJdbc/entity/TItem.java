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
@TableName("t_item")
public class TItem implements Serializable {
    private static final long serialVersionUID = 776336735396923994L;

    @TableId(type = IdType.AUTO)
    private Integer itemId;

    private String itemName;

    private Boolean status;

    private Date gmtCreate;
}