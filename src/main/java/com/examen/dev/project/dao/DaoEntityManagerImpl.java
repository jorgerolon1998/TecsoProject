package com.examen.dev.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.examen.dev.project.entity.Sucursal;
import com.examen.dev.project.entity.SucursalFilter;


@SuppressWarnings("unused")
public class DaoEntityManagerImpl<T, K> implements Dao<T, K> {

    @PersistenceContext
    
    private EntityManager entityManager;

    private Class<T> entityClass;

    public DaoEntityManagerImpl(Class<T> entityClass) {
        if (entityClass == null) {
            throw new RuntimeException("entity class not defined");
        }
        this.entityClass = entityClass;
    }

    @Override
    public ResultPage<T> get(Filter<T> filter, PageOptions pageOptions) {
        CriteriaBuilder critBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = critBuilder.createQuery(entityClass);
        Root<T> entityRoot = query.from(entityClass);
        query.select(entityRoot);
        if (filter != null) {
            filter.populateCriteriaQuery(query, entityRoot, critBuilder);
        }
        TypedQuery<T> tQuery = entityManager.createQuery(query);
        if (pageOptions != null) {
            tQuery.setMaxResults(pageOptions.getMaxResults());
            tQuery.setFirstResult(pageOptions.getFirstResult());
        }
        List<T> results = tQuery.getResultList();
        long total = pageOptions != null ? this.count(filter) : results.size();
        ResultPage<T> resultPage = new ResultPage<T>();
        resultPage.setItems(results);
        resultPage.setPage(pageOptions);
        resultPage.setTotal(total);
        return resultPage;
    }
    
    

    @Override
    public long count(Filter<T> filter) {
        long count = 0L;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<T> entityRoot = query.from(entityClass);
        query.select(cb.count(entityRoot));
        if (filter != null) {
            filter.populateCriteriaQueryForCount(query, entityRoot, cb);
        }
        count = entityManager.createQuery(query).getSingleResult();
        return count;
    }

    @Override
    public void insert(T obj) {
        this.entityManager.persist(obj);
    }

    @Override
    @Transactional
    public void delete(K id) {
    	Sucursal obj = this.entityManager.find(Sucursal.class, id);
    	  	
        this.entityManager.remove(obj);
    	
    }

    @Override
    public T get(K id) {
        T obj = this.entityManager.find(entityClass, id);
        if (obj == null) {
            throw new RuntimeException("la entidad de id " + id + " no existia");
        }
        return obj;
    }

    @Override
    public void update(K id, T obj) {
        this.get(id);
        this.entityManager.merge(obj);
    }

	@Override
	public ResultPage<Sucursal> get(SucursalFilter filter, PageOptions pageOptions, long idcuenta) {
    	
		String sql = "SELECT * FROM SUCURSAL  where id_cuenta = " +idcuenta;
    	
    	List  results = entityManager.createNativeQuery(sql).getResultList();
		
    	
	
	        long total = pageOptions != null ? this.count((Filter<T>) filter) : results.size();
	        ResultPage<T> resultPage = new ResultPage<T>();
	        resultPage.setItems((List<T>) results);
	        resultPage.setPage(pageOptions);
	        resultPage.setTotal(total);
	        return (ResultPage<Sucursal>) resultPage;
	}

	@Override
	public Sucursal findByLatAndLong(Double latitud, Double longitud) {

		String sqlString = "SELECT s FROM Sucursal AS s";
		@SuppressWarnings("unchecked")
		List<Sucursal> sucursales = (List<Sucursal>) entityManager.createQuery(sqlString);
		Sucursal sucu= new Sucursal();
		for (Sucursal suc: sucursales) {
			if ((latitud == suc.getLatitud()) && (longitud == suc.getLongitud())) {
				sucu = suc;
			}
			else {
				Double theta = latitud - suc.getLatitud();
				Double dist = Math.sin(Math.toRadians(latitud)) * Math.sin(Math.toRadians(suc.getLatitud())) + Math.cos(Math.toRadians(latitud)) * Math.cos(Math.toRadians(suc.getLatitud())) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				sucu = suc;
			}
		}
		return sucu;
		
	}

}
