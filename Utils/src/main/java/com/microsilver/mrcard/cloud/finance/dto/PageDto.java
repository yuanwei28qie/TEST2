package com.microsilver.mrcard.cloud.finance.dto;

/**
 * Created by Jade on 2017/8/15.
 * 分页基础数据
 */
public class PageDto {
    int pageNum =1;
    int pageSize = 10;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
