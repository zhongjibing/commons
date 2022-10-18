package com.icezhg.commons.entity;

import java.util.Collection;

/**
 * Created by zhongjibing on 2022/09/04.
 */
public record PageResult(
        int total,
        Collection<?> data
) {}
