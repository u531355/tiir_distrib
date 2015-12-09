package daoimpl;

import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import dao.Dao;

@SuppressWarnings("serial")
public abstract class DaoImpl<K, E> implements Dao<K, E> {
	private Class<E> entityClass;


	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	public DaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
		
	}

	public E rechercher(K id) {
		return (E) em.find(entityClass, id);
	}

	public E enregistrer(E entité) {
		System.out.println(em);
		em.persist(entité);
		return entité;
	}

	public E mettreAJour(E entité) {
		return em.merge(entité);
	}

	public E recharger(K id) {
		E entité = rechercher(id);
		em.refresh(entité);
		return entité;
	}

	public void supprimer(K id) {
		E entité = rechercher(id);
		em.remove(entité);
	}

	public List<E> lister() {
		return liste("select x from " + entityClass.getName() + " x");
	}

	protected List<E> liste(String queryString, Object... params) {
		List<E> entités = null;
		
		TypedQuery<E> query = em.createQuery(queryString, entityClass);
		int i = 0, j = 1;
		while (i < params.length) {
			if (params[i] instanceof Date) {
				query.setParameter(j, (Date) params[i], (TemporalType) params[i + 1]);
				i += 2;
			} else if (params[i] instanceof Calendar) {
				query.setParameter(j, (Calendar) params[i], (TemporalType) params[i + 1]);
				i += 2;
			} else {
				query.setParameter(j, params[i]);
				i++;
			}
			j++;
		}
		entités = query.getResultList();
		return entités;
	}

	protected E recherche(String queryString, Object... params) {
		try {

			TypedQuery<E> query = em.createQuery(queryString, entityClass);
			int i = 0, j = 1;
			while (i < params.length) {
				if (params[i] instanceof Date) {
					query.setParameter(j, (Date) params[i], (TemporalType) params[i + 1]);
					i += 2;
				} else if (params[i] instanceof Calendar) {
					query.setParameter(j, (Calendar) params[i], (TemporalType) params[i + 1]);
					i += 2;
				} else {
					query.setParameter(j, params[i]);
					i++;
				}
				j++;
			}
			System.out.println("test"+query.toString());
			return (E) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NonUniqueResultException e) {
			throw new InternalError();
		}
	}
}
