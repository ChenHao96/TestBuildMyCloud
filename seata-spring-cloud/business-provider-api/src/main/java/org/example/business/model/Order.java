package org.example.business.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Order implements Serializable {

    /**
     * since:0.0.1
     */
    private String orderNumber;
}
