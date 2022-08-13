package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class ErrorCodeException extends RuntimeException {

    private String code = "";

    public ErrorCodeException(String code) {
        super();
        this.code = code;
    }

    public ErrorCodeException(String code, String message) {
        super(message);
        this.code = code;
    }


    public ErrorCodeException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
