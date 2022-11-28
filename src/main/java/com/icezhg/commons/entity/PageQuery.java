package com.icezhg.commons.entity;

/**
 * Created by zhongjibing on 2022/09/04.
 */
public class PageQuery extends FuzzyQuery {
    private int pageNum = 1;
    private int pageSize = 10;
    private int offset = 0;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum != null && pageNum > 0) {
            this.pageNum = pageNum;

            resetOffset();
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null && pageSize > 0) {
            this.pageSize = pageSize;

            resetOffset();
        }
    }

    public int getOffset() {
        return offset;
    }

    private void resetOffset() {
        this.offset = (pageNum - 1) * pageSize;
    }

}
