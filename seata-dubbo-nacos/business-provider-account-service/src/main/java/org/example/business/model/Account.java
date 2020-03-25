package org.example.business.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("account_tbl")
public class Account {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userId;

    private Integer money;
}
