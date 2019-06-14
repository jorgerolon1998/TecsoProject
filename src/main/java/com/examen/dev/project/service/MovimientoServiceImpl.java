package com.examen.dev.project.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.dev.project.dao.Dao;
import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Cuenta;
import com.examen.dev.project.entity.CuentaFilter;
import com.examen.dev.project.entity.Movimiento;
import com.examen.dev.project.entity.MovimientoFilter;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private Dao<Movimiento, Long> dao;

    private static final Logger logger = LoggerFactory.getLogger(MovimientoServiceImpl.class);



	@Override
	public ResultPage<Movimiento> getMovimiento(MovimientoFilter filter, PageOptions pageOptions, long idcuenta) {

        return this.dao.get(filter, pageOptions, idcuenta);

	}




	@Override
	public void insert(Movimiento movimiento) {
		// TODO Auto-generated method stub
		
	}
}
