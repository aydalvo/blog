package br.com.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blog.model.Assunto;

/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Component
public class AssuntoDAO implements DAO {
	
	private Session session;
	
	@Autowired
	public AssuntoDAO(SessionFactory factory) {
		this.session = factory.openSession();
	}
	
	public AssuntoDAO() {
	}

	@Override
	public void salvar(Assunto assunto) {
		session.save(assunto);
	}

	@Override
	public void remover(Long id) {
		session.delete(buscar(id));
	}

	@Override
	public void alterar(Assunto assunto) {
		session.update(assunto);
	}

	@Override
	public List<Assunto> listar() {
		List<Assunto> assuntos = session.createQuery(" from Assunto ").list();
		return assuntos;
	}
	
	public List<Assunto> listar(Long id) {
		List<Assunto> assuntos = session.createQuery(" select a from Assunto a.id = "+ id).list();
		return assuntos;
	}

	@Override
	public Assunto buscar(Long id) {
		return (Assunto) session.get(Assunto.class, id);
	}
	
}
