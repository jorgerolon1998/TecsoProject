package com.imagosur.dev.proyent.dao;

public interface Dao<T, K> {

    T get(K id);

    ResultPage<T> get(Filter<T> filter, PageOptions pageOpts);

    long count(Filter<T> filter);

    void insert(T obj);

    void update(K id, T obj);

    void delete(K id);


}
