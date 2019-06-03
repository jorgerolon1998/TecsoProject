package com.imagosur.dev.proyent.service;

import com.imagosur.dev.proyent.dao.PageOptions;
import com.imagosur.dev.proyent.dao.ResultPage;
import com.imagosur.dev.proyent.entity.Empleado;
import com.imagosur.dev.proyent.entity.EmpleadoFilter;

public interface EmpleadoService {

    ResultPage<Empleado> getEmpleados(EmpleadoFilter filter, PageOptions pageOptions);
    
    void insert(Empleado empleado);
    
    void update(Empleado empleado);
    
    void delete (Long id);
}
