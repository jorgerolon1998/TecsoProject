package com.examen.dev.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examen.dev.project.dao.Dao;
import com.examen.dev.project.dao.DaoEntityManagerImpl;
import com.examen.dev.project.entity.Sucursal;

@Configuration
public class MyConfigDao {

    @Bean
    public Dao<Sucursal, Long> getSucursalDao() {
        return new DaoEntityManagerImpl<>(Sucursal.class);
    }
    

}
