package br.com.blog.dao.generica;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

public class DAO<T> {
	
	/*
	 * Essa classe generica serviria de base para cada uma classeDao (especifica).
	 *  
	 */

	private final EntityManager em;
	
	private final Class<T> classe;
	
	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}
	
	public void adiciona(T t) {
		this.em.persist(t);
	}
	
	public void remove(T t) {
		this.em.remove(t);
	}
	
	public T busca(Long id) {
		return em.getReference(classe, id);
	}
	
	public List<T> lista() {
		return em.createQuery("select e from " + classe.getName() + " e ").getResultList();
	}
	
}
