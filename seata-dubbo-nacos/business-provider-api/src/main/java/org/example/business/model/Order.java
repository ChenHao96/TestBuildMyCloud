package org.example.business.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Order implements Serializable {

    /**
     * since: 0.0.1
     */
    private String orderNumber;

    /**
     * since: 0.0.1
     */
    private int orderCount;

    /**
     * since: 0.0.1
     */
    private int totalMoney;

    /**
     * since: 0.0.1
     */
    private Date createTime;
}
