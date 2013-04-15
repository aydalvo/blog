package br.com.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blog.model.Comentario;


/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Component
public class ComentarioDAO {
	
	// Existe redundancia de código nas classes DAO. A ideia era utilizar a classe generica em cada classe especifica,
	// adaptando apenas as consultas específicas.

	private Session session;
	
	@Autowired
	public ComentarioDAO(SessionFactory factory) {
		this.session = factory.openSession();
	}
	
	public ComentarioDAO() {
	}

	public void salvar(Comentario assunto) {
		session.beginTransaction().begin();
		session.save(assunto);
		session.beginTransaction().commit();
	}

	public void remover(Long id) {
		session.beginTransaction().begin();
		session.delete(buscar(id));
		session.beginTransaction().commit();
	}

	public void alterar(Comentario comentario) {
		session.beginTransaction().begin();
		session.update(comentario);
		session.beginTransaction().commit();
	}

	public List<Comentario> listar() {
		List<Comentario> comentarios = session.createQuery(" from Comentario c ").list();
		return comentarios;
	}
	
	public List<Comentario> listar(Long id) {
		List<Comentario> comentarios = session.createQuery(" select c from Comentario c where c.assunto.id = " + id).list();
		return comentarios;
	}
	
	public Comentario buscar(Long id) {
		return (Comentario) session.get(Comentario.class, id);
	}
	
}
