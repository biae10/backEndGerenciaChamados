package br.ifba.edu.chamados.dto;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.chamados.model.Cliente;
import br.ifba.edu.chamados.model.Imagem;

public class ImagemDto {

	private long id;
	private String caminho;
	private long usuarioId;
	
	
	public ImagemDto(Imagem imagem) {
		super();
		this.id = imagem.getId();
		this.caminho = imagem.getCaminho();
		this.usuarioId = imagem.getUsuario().getId();
	}
	
	public static List<ImagemDto> converterImagens(List<Imagem> imagens){
		
		List<ImagemDto> dto = new ArrayList<>();
		for(int i = 0; i < imagens.size(); i++) {
			dto.add(new ImagemDto(imagens.get(i)));
		}
		return dto;
	}
	

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
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
	

}
