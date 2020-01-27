package com.examen.dev.project.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.dev.project.dao.Dao;
import com.examen.dev.project.dao.PageOptions;
import com.examen.dev.project.dao.ResultPage;
import com.examen.dev.project.entity.Sucursal;
import com.examen.dev.project.entity.SucursalFilter;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private Dao<Sucursal, Long> dao;

    private static final Logger logger = LoggerFactory.getLogger(SucursalServiceImpl.class);

    @Override
    public ResultPage<Sucursal> getSucursal(SucursalFilter filter, PageOptions pageOptions) {
        logger.trace("getCuenta");
        return this.dao.get(filter, pageOptions);
    }
    
    
    

    @Override
    @Transactional
    public void insert(Sucursal sucursal) {
        logger.trace("insert");
        dao.insert(sucursal);
    }

    @Override
    @Transactional
    public void update(Sucursal sucursal) {
        logger.trace("update");
        dao.update(sucursal.getId(), sucursal);
    }

	@Override
	public void delete(Long id) {
        logger.trace("delete");
        dao.delete(id);

		
	}


	@Override
	public Sucursal getSucursalByLatAndLong(Double latitud, Double longitud) {
        logger.trace("findByLatAndLong");
        return dao.findByLatAndLong(latitud, longitud);        
	}
}
