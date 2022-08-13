package com.icezhg.commons.entity;

import lombok.Getter;

/**
 * Created by zhongjibing on 2019/08/05
 */
@Getter
public class PageQuery {
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_NO = 1;

    private int pageSize = DEFAULT_PAGE_SIZE;
    private int pageNo = DEFAULT_PAGE_NO;


    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
        }
    }
}
