package br.com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @version 1.0
 * @since   15/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Entity
public class Materia {

	@Id
	@GeneratedValue
	private Long id;
	
	@Length(max=100)
	private String titulo;
	
	@Length(max=1000)
	private String conteudo;
	
	@ManyToOne
	private Assunto assunto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
