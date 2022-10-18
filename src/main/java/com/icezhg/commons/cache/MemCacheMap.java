package com.icezhg.commons.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhongjibing on 2019/08/06
 */
public final class MemCacheMap<K, V> {

    private final long expireMillis;

    private final Map<K, Data<V>> cacheMap = new ConcurrentHashMap<>();

    public MemCacheMap() {
        this(Long.MAX_VALUE >> 1);
    }

    public MemCacheMap(long expireMillis) {
        if (expireMillis <= 0L) {
            throw new IllegalArgumentException("expire millis should be positive");
        }
        this.expireMillis = expireMillis;
    }

    public void set(K key, V value) {
        set(key, value, this.expireMillis);
    }

    public void set(K key, V value, long expire) {
        if (key == null) {
            throw new IllegalArgumentException("cache key should not be null");
        }
        if (expire <= 0) {
            throw new IllegalArgumentException("expire millis should be positive");
        }

        this.cacheMap.put(key, new Data<>(value, expire));
    }


    public V get(K key) {
        if (key == null) {
            return null;
        }

        Data<V> data = this.cacheMap.get(key);
        if (data != null) {
            if (data.isExpired()) {
                this.cacheMap.remove(key);
            } else {
                return data.getData();
            }
        }

        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        V v;
        return ((v = get(key)) != null) ? v : defaultValue;
    }

    static class Data<D> {
        private final D data;
        private final long expiretime;
        private final long timestamp;

        public Data(D data, long expiretime) {
            this.data = data;
            this.expiretime = expiretime;
            this.timestamp = System.currentTimeMillis();
        }

        public D getData() {
            return isExpired() ? null : this.data;
        }

        private boolean isExpired() {
            return System.currentTimeMillis() > timestamp + expiretime;
        }
    }
}
