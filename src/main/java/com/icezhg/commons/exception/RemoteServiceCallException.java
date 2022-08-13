package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class RemoteServiceCallException extends ErrorCodeException {

    public RemoteServiceCallException(String code) {
        super(code);
    }

    public RemoteServiceCallException(String code, String message) {
        super(code, message);
    }

    public RemoteServiceCallException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
