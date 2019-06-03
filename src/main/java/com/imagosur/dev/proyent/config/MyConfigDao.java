package com.imagosur.dev.proyent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.imagosur.dev.proyent.dao.Dao;
import com.imagosur.dev.proyent.dao.DaoEntityManagerImpl;
import com.imagosur.dev.proyent.entity.Empleado;

@Configuration
public class MyConfigDao {

    @Bean
    public Dao<Empleado, Long> getEmpleadoDao() {
        return new DaoEntityManagerImpl<>(Empleado.class);
    }
}
