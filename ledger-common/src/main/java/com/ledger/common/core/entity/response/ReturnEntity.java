package com.ledger.common.core.entity.response;

/**
 * Created by chen on 2017/5/8.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 返回的 数据模型
 */
public class ReturnEntity {
    protected int code;
    protected String message;
    protected Object data;

    public ReturnEntity(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ReturnEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ReturnEntity() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

