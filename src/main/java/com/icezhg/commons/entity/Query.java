package com.icezhg.commons.entity;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhongjibing on 2022/09/04.
 */
public interface Query {
    default Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("isFuzzyQuery", isFuzzyQuery());
        addFieldValues(this.getClass(), map);

        Class<?> clazz = this.getClass().getSuperclass();
        while (clazz != null) {
            addFieldValues(clazz, map);
            clazz = clazz.getSuperclass();
        }

        return map;
    }

    private void addFieldValues(Class<?> clazz, Map<String, Object> map) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = getField(field, this);
            map.put(field.getName(), value);
        }
    }

    private Object getField(Field field, Object target) {
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    default boolean isFuzzyQuery() {
        return true;
    }
}
