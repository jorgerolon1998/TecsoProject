package com.examen.dev.project.entity;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.examen.dev.project.dao.AbstractFilter;

public class MovimientoFilter extends AbstractFilter<Cuenta> {

    private String razonSocialLike;

    @Override
    protected void populatePredicates(List<Predicate> predicates, Root<Cuenta> root, CriteriaBuilder critBuilder) {
        if (isEmpty(razonSocialLike)) {
            // predicates.add()
        }
    }

}
