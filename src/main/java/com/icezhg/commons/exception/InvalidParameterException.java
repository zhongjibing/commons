package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class InvalidParameterException extends ErrorCodeException {

    public InvalidParameterException(String code) {
        super(code);
    }

    public InvalidParameterException(String code, String message) {
        super(code, message);
    }

    public InvalidParameterException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
