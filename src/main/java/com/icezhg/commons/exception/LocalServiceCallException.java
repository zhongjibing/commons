package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class LocalServiceCallException extends ErrorCodeException {

    public LocalServiceCallException(String code) {
        super(code);
    }

    public LocalServiceCallException(String code, String message) {
        super(code, message);
    }

    public LocalServiceCallException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
