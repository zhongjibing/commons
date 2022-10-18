package com.icezhg.commons.cache;

import java.util.function.Supplier;

/**
 * Created by zhongjibing on 2019/08/06
 */
public final class MemCache<D> {
    private final Supplier<D> supplier;
    private final long expiretime;
    private volatile long timestamp;
    private volatile D data;

    public MemCache(Supplier<D> supplier) {
        this.supplier = supplier;
        this.expiretime = 60 * 1000L;
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
