package br.ifba.edu.chamados.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.web.multipart.MultipartFile;

@Entity(name="Imagem")
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String caminho;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	
	public Imagem(long id, String caminho, Usuario usuario) {
		super();
		this.id = id;
		this.caminho = caminho;
		this.usuario = usuario;
	}
	
	public Imagem() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
