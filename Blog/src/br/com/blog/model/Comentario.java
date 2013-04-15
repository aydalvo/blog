package br.com.blog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * @version 1.0
 * @since   13/04/2013
 * @author  Aydalvo Nery Neto
 *
 */

@Entity
public class Comentario {

	@Id
	@GeneratedValue
	private Long id;
	
	@Length(max=75)
	@Column(name="contato")
	private String email;
	
	@Length(max=500)
	@Column(name="comentario")
	private String texto;
	
	@Column(name="dt_postagem")
	@Temporal(TemporalType.DATE)
	private Date postagem;
	
	@ManyToOne
	// após criar a classe Materia substituiria esse relacionamento para utiliza-la.
	private Assunto assunto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getPostagem() {
		return postagem;
	}

	public void setPostagem(Date postagem) {
		this.postagem = postagem;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

}
