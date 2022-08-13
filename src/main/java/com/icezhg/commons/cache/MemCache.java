package com.icezhg.commons.cache;

import java.io.Serializable;

/**
 * Created by zhongjibing on 2019/08/06
 */
public class MemCache<D> implements Serializable {
    private static final long serialVersionUID = 7456898353257055261L;

    private static final long DEFAULT_EXPIRE_TIME = 24 * 60 * 60 * 1000L;

    private final transient long expiretime;
    private final transient long timestamp = System.currentTimeMillis();
    private final D data;

    public MemCache(D data) {
        this(data, DEFAULT_EXPIRE_TIME);
    }

    public MemCache(D data, long expireTimeMillis) {
        this.data = data;
        this.expiretime = expireTimeMillis;
    }

    public D getData() {
        return data;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > timestamp + expiretime;
    }
}
