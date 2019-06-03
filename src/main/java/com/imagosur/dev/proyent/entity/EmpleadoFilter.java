package com.imagosur.dev.proyent.entity;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.imagosur.dev.proyent.dao.AbstractFilter;

public class EmpleadoFilter extends AbstractFilter<Empleado> {

    private String nombreYApellidoLike;

    @Override
    protected void populatePredicates(List<Predicate> predicates, Root<Empleado> root, CriteriaBuilder critBuilder) {
        if (isEmpty(nombreYApellidoLike)) {
            // predicates.add()
        }
    }

}
