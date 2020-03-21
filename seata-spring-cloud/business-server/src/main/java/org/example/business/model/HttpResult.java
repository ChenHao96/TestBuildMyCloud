package org.example.business.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HttpResult<D> {

    private int code;

    private String msg;

    private D data;

    public HttpResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HttpResult(int code, String msg, D data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
