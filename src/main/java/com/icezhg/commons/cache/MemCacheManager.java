package com.icezhg.commons.cache;

import java.util.Map;

/**
 * Created by zhongjibing on 2019/08/06
 */
public abstract class MemCacheManager {

    protected static <K, V> void setCache(Map<K, MemCache<V>> cacheMap, K key, V data) {
        cacheMap.put(key, new MemCache<>(data));
    }

    protected static <K, V> void setCache(Map<K, MemCache<V>> cacheMap, K key, V data, long expireTimeMillis) {
        cacheMap.put(key, new MemCache<>(data, expireTimeMillis));
    }

    protected static <K, V> MemCache<V> getAndExpire(Map<K, MemCache<V>> cacheMap, K key) {
        if (cacheMap.containsKey(key)) {
            final MemCache<V> cache = cacheMap.get(key);
            if (cache.isExpired()) {
                cacheMap.remove(key);
            }
            return cache;
        }
        return null;
    }
}
