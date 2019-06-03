package com.imagosur.dev.proyent.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractFilter<T> implements Filter<T> {

    protected abstract void populatePredicates(List<Predicate> predicates, Root<T> root, CriteriaBuilder critBuilder);

    @Override
    public void populateCriteriaQuery(CriteriaQuery<T> query, Root<T> root, CriteriaBuilder critBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        populatePredicates(predicates, root, critBuilder);
        query.where(predicates.toArray(new Predicate[predicates.size()]));
    }

    @Override
    public void populateCriteriaQueryForCount(CriteriaQuery<Long> query, Root<T> root, CriteriaBuilder critBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        populatePredicates(predicates, root, critBuilder);
        query.where(predicates.toArray(new Predicate[predicates.size()]));
    }

    protected boolean isEmpty(String value) {
        return StringUtils.isEmpty(value);
    }
}
