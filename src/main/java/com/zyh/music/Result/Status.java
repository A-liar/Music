package com.zyh.music.Result;

public enum Status {
    SUCCESS(200, "请求成功"),
    FAIL(201, "请求失败"),
    SYSTEM_ERROR(101, "系统异常"),
    SQL_ERROR(109, "SQL语句异常");
    private Integer code;

    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
