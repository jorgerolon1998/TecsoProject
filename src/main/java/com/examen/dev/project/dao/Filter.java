package com.examen.dev.project.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public interface Filter<T> {
    void populateCriteriaQuery(CriteriaQuery<T> query, Root<T> root, CriteriaBuilder critBuilder);

    void populateCriteriaQueryForCount(CriteriaQuery<Long> query, Root<T> root, CriteriaBuilder critBuilder);
}
