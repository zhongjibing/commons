package com.icezhg.commons.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zhongjibing on 2022/08/29.
 */
public class OptRef<T> {

    private static final OptRef<?> EMPTY = new OptRef<>(null);

    private final T value;

    public OptRef(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> OptRef<T> of(T value) {
        return value == null ? (OptRef<T>) EMPTY : new OptRef<>(value);
    }

    public <R> OptRef<R> map(Function<? super T, ? extends R> mapper) {
        if (value != null) {
            return new OptRef<>(mapper.apply(value));
        }
        return empty();
    }

    public <R> OptRef<R> cast(Class<R> clazz) {
        if (value != null && clazz.isAssignableFrom(value.getClass())) {
            @SuppressWarnings("unchecked")
            OptRef<R> instance = (OptRef<R>) this;
            return instance;
        }
        return empty();
    }

    public <R> OptRef<R> empty() {
        @SuppressWarnings("unchecked")
        OptRef<R> empty = (OptRef<R>) EMPTY;
        return empty;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<? super T> action) {
        if (value != null) {
            action.accept(value);
        }
    }

    public boolean isEmpty() {
        return value == null;
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }
}
