package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class InvalidAccessException extends ErrorCodeException {

    public InvalidAccessException(String code) {
        super(code);
    }

    public InvalidAccessException(String code, String message) {
        super(code, message);
    }

    public InvalidAccessException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
