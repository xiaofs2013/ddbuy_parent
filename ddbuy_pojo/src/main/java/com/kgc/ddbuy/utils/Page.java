package com.kgc.ddbuy.utils;

import java.io.Serializable;

public class Page implements Serializable {

    private int page = 1;

    private int rows = 3;

    public Page() {
    }

    public Page(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
