package com.example.zhitongguigu.request;

import javax.validation.constraints.NotNull;

public class PageRequest {

    @NotNull(message = "page idx can't be null")
    private int pageIdx;

    public int getPageIdx() {
        return pageIdx;
    }

    public void setPageIdx(int pageIdx) {
        this.pageIdx = pageIdx;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @NotNull(message = "page size can't be null")
    private int pageSize;
}
