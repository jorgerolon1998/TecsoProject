package com.examen.dev.project.dao;

import java.util.List;

public class ResultPage<T> {
    private List<T> items;
    private PageOptions page;
    private Long total;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PageOptions getPage() {
        return page;
    }

    public void setPage(PageOptions page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
