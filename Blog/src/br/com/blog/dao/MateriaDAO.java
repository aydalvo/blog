package br.com.blog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blog.model.Comentario;
import br.com.blog.model.Materia;


/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Component
public class MateriaDAO {

	private Session session;
	
	@Autowired
	public MateriaDAO(SessionFactory factory) {
		this.session = factory.openSession();
	}
	
	public MateriaDAO() {
	}

	public void salvar(Materia materia) {
		session.beginTransaction().begin();
		session.save(materia);
		session.beginTransaction().commit();
	}

	public void remover(Long id) {
		session.beginTransaction().begin();
		session.delete(buscar(id));
		session.beginTransaction().commit();
	}

	public void alterar(Materia materia) {
		session.beginTransaction().begin();
		session.update(materia);
		session.beginTransaction().commit();
	}

	public List<Materia> listar() {
		List<Materia> comentarios = session.createQuery(" from Materia m ").list();
		return comentarios;
	}
	
	public List<Comentario> listar(Long id) {
		List<Comentario> materias = session.createQuery(" select m from Materia m where m.assunto.id = " + id).list();
		return materias;
	}
	
	public Materia buscar(Long id) {
		return (Materia) session.get(Materia.class, id);
	}
	
}
