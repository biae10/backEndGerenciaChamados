package br.ifba.edu.chamados.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.ifba.edu.chamados.model.Usuario;
import br.ifba.edu.chamados.repository.UsuarioRepository;

public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String email;
	private String imagem;
	
	public UsuarioForm(String nome,String email,String imagem) {
		this.nome = nome;
		this.email = email;
		this.imagem = imagem;
	}
	
	public Usuario converter() {		
		Usuario novo = new Usuario();
		novo.setNome(nome);
		novo.setEmail(email);
		novo.setImagem(imagem);
		return novo;
	}
	
	public Usuario atualizar(UsuarioRepository repository, long id) {
		Usuario atualizado = repository.getById(id);
		atualizado.setNome(nome);
		atualizado.setEmail(email);
		atualizado.setImagem(imagem);
		return atualizado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	
}
