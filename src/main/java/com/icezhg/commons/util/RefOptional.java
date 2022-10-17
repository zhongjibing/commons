package com.icezhg.commons.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zhongjibing on 2022/08/29.
 */
public class RefOptional<T> {

    private static final RefOptional<?> EMPTY = new RefOptional<>(null);

    private final T value;

    public RefOptional(T value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public static <T> RefOptional<T> of(T value) {
        return value == null ? (RefOptional<T>) EMPTY : new RefOptional<>(value);
    }

    public <R> RefOptional<R> map(Function<? super T, ? extends R> mapper) {
        if (value != null) {
            return new RefOptional<>(mapper.apply(value));
        }
        return empty();
    }

    public <R> RefOptional<R> cast(Class<R> clazz) {
        if (value != null && clazz.isAssignableFrom(value.getClass())) {
            @SuppressWarnings("unchecked")
            RefOptional<R> instance = (RefOptional<R>) this;
            return instance;
        }
        return empty();
    }

    public <R> RefOptional<R> empty() {
        @SuppressWarnings("unchecked")
        RefOptional<R> empty = (RefOptional<R>) EMPTY;
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
