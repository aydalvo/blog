package br.com.blog.dao;

import java.util.List;

import br.com.blog.model.Assunto;

/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

public interface DAO {
	
	void salvar (Assunto assunto);
	
	void remover (Long id);
	
	void alterar (Assunto assunto);
	
	List<Assunto> listar ();
	
	Assunto buscar (Long id);
	
}
