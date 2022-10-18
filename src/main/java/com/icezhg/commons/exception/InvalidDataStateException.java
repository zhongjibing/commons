package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class InvalidDataStateException extends ErrorCodeException {

    public InvalidDataStateException(String code) {
        super(code);
    }

    public InvalidDataStateException(String code, String message) {
        super(code, message);
    }

    public InvalidDataStateException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
