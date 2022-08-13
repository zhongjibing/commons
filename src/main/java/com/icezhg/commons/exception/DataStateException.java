package com.icezhg.commons.exception;

/**
 * Created by zhongjibing on 2019/07/30
 */
public class DataStateException extends ErrorCodeException {

    public DataStateException(String code) {
        super(code);
    }

    public DataStateException(String code, String message) {
        super(code, message);
    }

    public DataStateException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
