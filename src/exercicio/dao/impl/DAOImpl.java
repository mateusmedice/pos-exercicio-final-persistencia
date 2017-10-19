package exercicio.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;

import exercicio.dao.DAO;

/**
 * @author mateus.medice
 *
 */
public class DAOImpl <T, I extends Serializable> implements DAO<T, I> {

	private EntityManager em;
	
	private Session session;
	
	public DAOImpl() {
		if (em == null) {
			em = getEntityManager();
		}
	}
	
	@Override
	public T add(T t) {
		try {
			
			this.begin();
			
			return this.em.merge(t);
	
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	@Override
	public void remove(T t) {
		
		try {	
		
			this.em.remove(t);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> getAll(Class t) {
		
		return this.getSession().createCriteria(t).list();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(Class t, I pk) {
		return (T) this.em.find(t, pk);
	}

	@Override
	public EntityManager getEntityManager() {
		
		return Persistence.createEntityManagerFactory("meuDB").createEntityManager();
	}

	@Override
	public Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class T) {
		return this.getSession().createCriteria(T);
	}
	
	private void begin() {
		this.em.getTransaction().begin();
	}

	private void commit() {
		this.em.getTransaction().commit();
	}
}
