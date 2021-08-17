package com.stephen.ofs.entity.model;

import com.stephen.ofs.constant.ErrorCode;
import java.io.Serializable;
import lombok.Data;

@Data
public class CommonResult implements Serializable {

    private String code;

    private Object data;

    private String message;

    //默认成功
    public CommonResult() {
        this.code = "200";
        this.message = "";
    }

    public CommonResult(Object data) {
        this();
        this.data = data;
    }

    public CommonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
