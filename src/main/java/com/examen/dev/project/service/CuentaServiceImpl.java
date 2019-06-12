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

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private Dao<Cuenta, Long> dao;

    private static final Logger logger = LoggerFactory.getLogger(CuentaServiceImpl.class);

    @Override
    public ResultPage<Cuenta> getCuenta(CuentaFilter filter, PageOptions pageOptions) {
        logger.trace("getCuenta");
        return this.dao.get(filter, pageOptions);
    }
    
    
    

    @Override
    @Transactional
    public void insert(Cuenta cuenta) {
        logger.trace("insert");
        dao.insert(cuenta);
    }

    @Override
    @Transactional
    public void update(Cuenta cuenta) {
        logger.trace("update");
        dao.update(cuenta.getId(), cuenta);
    }

	@Override
	public void delete(Long id) {
        logger.trace("delete");
        dao.delete(id);

		
	}
}
