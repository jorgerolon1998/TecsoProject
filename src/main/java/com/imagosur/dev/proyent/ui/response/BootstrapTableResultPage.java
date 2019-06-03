package com.imagosur.dev.proyent.ui.response;

import java.util.List;

import com.imagosur.dev.proyent.dao.ResultPage;

public class BootstrapTableResultPage<T> {
    private List<T> rows;
    private Long total;

    public static <T> BootstrapTableResultPage<T> fromResultPage(ResultPage<T> resultPage) {
        BootstrapTableResultPage<T> uiResultPage = new BootstrapTableResultPage<>();
        uiResultPage.setRows(resultPage.getItems());
        uiResultPage.setTotal(resultPage.getTotal());
        return uiResultPage;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
