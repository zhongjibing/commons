package com.icezhg.commons.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by zhongjibing on 2019/08/05
 */
@Getter
@Setter
public class PageResult<T> extends PageQuery {

    private int totalCount;
    private List<T> records;

    public int getTotalPage() {
        return (totalCount + super.getPageSize() - 1) / super.getPageSize();
    }

}
