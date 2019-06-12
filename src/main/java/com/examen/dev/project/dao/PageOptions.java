package com.examen.dev.project.dao;

public class PageOptions {
    private Integer size = 10;
    private Integer number = 1;
    private Integer offset = 0;

    public int getMaxResults() {
        return this.size;
    }

    public int getFirstResult() {
        int offset = this.offset != null ? this.offset : 0;
        int number = this.number != null ? this.number : 1;
        return offset + (number - 1) * size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
