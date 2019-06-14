package com.examen.dev.project.service;

import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Cuenta;
import com.examen.dev.project.entity.CuentaFilter;
import com.examen.dev.project.entity.Movimiento;
import com.examen.dev.project.entity.MovimientoFilter;

public interface MovimientoService {

    ResultPage<Movimiento> getMovimiento(MovimientoFilter filter, PageOptions pageOptions, long idcuenta);
    
    
    
    void insert(Movimiento movimiento);
    
    
}
