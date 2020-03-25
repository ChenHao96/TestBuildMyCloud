package org.example.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("order_tbl")
public class OrderEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

}
