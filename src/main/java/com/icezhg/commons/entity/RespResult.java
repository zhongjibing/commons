package com.icezhg.commons.entity;

/**
 * Created by zhongjibing on 2019/07/23
 */
public class RespResult<T> {

    private String msg = "success";
    private T data;

    public RespResult() {
    }

    public RespResult(T data) {
        this.data = data;
    }

    public RespResult(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> RespResult<T> success() {
        return new RespResult<>();
    }

    public static <T> RespResult<T> success(T data) {
        return new RespResult<>(data);
    }

    public static <T> RespResult<T> error() {
        return error("error");
    }

    public static <T> RespResult<T> error(String msg) {
        return create(msg, null);
    }

    public static <T> RespResult<T> create(String msg, T data) {
        return new RespResult<>(msg, data);
    }
}
