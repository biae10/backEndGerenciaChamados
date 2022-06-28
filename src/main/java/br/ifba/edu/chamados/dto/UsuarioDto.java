package br.ifba.edu.chamados.dto;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.chamados.model.Usuario;

public class UsuarioDto {

	private long id;
	private String nome;
	private String email;
	private String imagem;
	

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.imagem = usuario.getImagem();
	}
	
	public static List<UsuarioDto> converterUsuarios(List<Usuario> usuarios){

		List<UsuarioDto> usuariosDto = new ArrayList<>();
		for(int i = 0; i < usuarios.size(); i++) {
			usuariosDto.add(new UsuarioDto(usuarios.get(i)));
		}
		return usuariosDto;
	}
	
	
	public static UsuarioDto converterUnico(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
		return usuarioDto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
