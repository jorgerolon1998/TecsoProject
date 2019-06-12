package com.examen.dev.project.service;

import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Cuenta;
import com.examen.dev.project.entity.CuentaFilter;

public interface CuentaService {

    ResultPage<Cuenta> getCuenta(CuentaFilter filter, PageOptions pageOptions);
    
    
    
    void insert(Cuenta cuenta);
    
    void update(Cuenta cuenta);
    
    void delete (Long id);
}
