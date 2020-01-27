package com.examen.dev.project.service;

import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Sucursal;
import com.examen.dev.project.entity.SucursalFilter;

public interface SucursalService {

    ResultPage<Sucursal> getSucursal(SucursalFilter filter, PageOptions pageOptions);
    
    Sucursal getSucursalByLatAndLong(Double latitud, Double longitud);
    
    
    void insert(Sucursal sucursal);
    
    void update(Sucursal sucursal);
    
    void delete (Long id);
}
