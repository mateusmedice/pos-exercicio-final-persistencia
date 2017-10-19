/**
 * 
 */
package exercicio.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * @author mateus.medice
 *
 */
public interface DAO <T, I extends Serializable> {
	
	T add(T t);
	
	void remove(T t);

	@SuppressWarnings("rawtypes")
	T getById(Class t, I pk);

	@SuppressWarnings("rawtypes")
	List<T> getAll(Class t);
	
	EntityManager getEntityManager();
	
	Session getSession();

	@SuppressWarnings("rawtypes")
	Criteria createCriteria(Class T);
}
