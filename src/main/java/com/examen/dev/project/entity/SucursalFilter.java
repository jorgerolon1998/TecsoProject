package com.examen.dev.project.entity;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.examen.dev.project.dao.AbstractFilter;

public class SucursalFilter extends AbstractFilter<Sucursal> {

    private String nombre;

    @Override
    protected void populatePredicates(List<Predicate> predicates, Root<Sucursal> root, CriteriaBuilder critBuilder) {
        if (isEmpty(nombre)) {
        }
    }

}
