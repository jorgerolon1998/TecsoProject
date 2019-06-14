package com.examen.dev.project.dao;

import com.examen.dev.project.entity.Movimiento;
import com.examen.dev.project.entity.MovimientoFilter;

public interface Dao<T, K> {

    T get(K id);

    ResultPage<T> get(Filter<T> filter, PageOptions pageOpts);
    
    

    long count(Filter<T> filter);

    void insert(T obj);

    void update(K id, T obj);

    void delete(K id);

	ResultPage<Movimiento> get(MovimientoFilter filter, PageOptions pageOptions, long idcuenta);


}
