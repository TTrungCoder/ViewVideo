package dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import utils.JpaUtils;

public class AbstractDAO<T> {
	public static final EntityManager em = JpaUtils.getEntityManager();

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public T findById(Class<T> clazz, Integer id) {
		return em.find(clazz, id);
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT o FROM ").append(entityName).append(" o ");
		if (existIsActive == true) {
			jpql.append("WHERE isActive = 1");
		}
		TypedQuery<T> query = em.createQuery(jpql.toString(), clazz);
		return query.getResultList();
	}

	public List<T> findPage(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT o FROM ").append(entityName).append(" o ");
		if (existIsActive == true) {
			jpql.append("WHERE isActive = 1");
		}
		TypedQuery<T> query = em.createQuery(jpql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	public T findOne(Class<T> clazz, String jpql, Object... params) { // tham so co do dai bien doi
		TypedQuery<T> query = em.createQuery(jpql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public List<T> findMany(Class<T> clazz, String jpql, Object... params) { // tham so co do dai bien doi
		TypedQuery<T> query = em.createQuery(jpql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params) {
		try {
			Query query = em.createNativeQuery(sql);
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
			return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> callStored(String nameStored, Map<String, Object> params) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery(nameStored);
		params.forEach((key, value) -> query.setParameter(key, value));
		return (List<T>) query.getResultList();
	}

	public T create(T entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			System.out.println("Create successed");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Can't create entity " + entity.getClass().getSimpleName() + " to DB");
			throw new RuntimeException();
		}
	}

	public T update(T entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			System.out.println("Update successed");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Can't update entity " + entity.getClass().getSimpleName());
			throw new RuntimeException();
		}
	}

	public T delete(T entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			System.out.println("Delete successed");
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			System.out.println("Can't delete entity " + entity.getClass().getSimpleName());
			throw new RuntimeException();
		}
	}
}
