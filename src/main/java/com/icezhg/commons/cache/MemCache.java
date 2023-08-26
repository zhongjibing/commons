package com.icezhg.commons.cache;

import java.util.function.Supplier;

/**
 * Created by zhongjibing on 2019/08/06
 */
public final class MemCache<D> {
    private static final long DEFAULT_EXPIRE_TIME = 60 * 1000L;
    private final Supplier<D> supplier;
    private final long expiretime;
    private volatile long timestamp;
    private volatile D data;

    public MemCache(Supplier<D> supplier) {
        this(supplier, DEFAULT_EXPIRE_TIME);
    }

    public MemCache(Supplier<D> supplier, long expireMills) {
        this.supplier = supplier;
        this.expiretime = expireMills;
    }

    public D getData() {
        if (isExpired()) {
            synchronized (this) {
                if (isExpired()) {
                    this.data = supplier.get();
                    this.timestamp = System.currentTimeMillis();
                }
            }
        }
        return this.data;
    }

    private boolean isExpired() {
        return System.currentTimeMillis() > timestamp + expiretime;
    }
}
