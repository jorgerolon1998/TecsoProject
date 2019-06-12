package com.examen.dev.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examen.dev.project.dao.Dao;
import com.examen.dev.project.dao.DaoEntityManagerImpl;
import com.examen.dev.project.entity.Cuenta;
import com.examen.dev.project.entity.Movimiento;

@Configuration
public class MyConfigDao {

    @Bean
    public Dao<Cuenta, Long> getCuentaDao() {
        return new DaoEntityManagerImpl<>(Cuenta.class);
    }
    
    @Bean
    public Dao<Movimiento, Long> getMovimiento() {
        return new DaoEntityManagerImpl<>(Movimiento.class);
    }
}
