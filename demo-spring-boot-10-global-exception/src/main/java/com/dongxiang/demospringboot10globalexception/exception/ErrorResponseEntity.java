package com.dongxiang.demospringboot10globalexception.exception;

/**
 * author:dongxiang
 * data:2018/7/5 15:43
 * email:dongxiang_android_sdk2@aliyun.com
 * description:
 * function:
 * using:
 * note:
 * <p>自定义异常-模板</p>
 * <li></li>
 */
public class ErrorResponseEntity {
    private int code;
    private String message;

    public ErrorResponseEntity() {
    }

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponseEntity{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
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
}
