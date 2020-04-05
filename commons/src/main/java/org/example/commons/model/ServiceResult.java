package org.example.commons.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ServiceResult<D> {

    private boolean success;

    private String msg;

    private D data;

    public ServiceResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ServiceResult(boolean success, String msg, D data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
}
