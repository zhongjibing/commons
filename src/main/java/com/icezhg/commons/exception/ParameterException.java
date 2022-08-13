package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class ParameterException extends ErrorCodeException {

    public ParameterException(String code) {
        super(code);
    }

    public ParameterException(String code, String message) {
        super(code, message);
    }

    public ParameterException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
