package br.ifba.edu.chamados.dto;

import org.springframework.web.multipart.MultipartFile;

import br.ifba.edu.chamados.model.Imagem;

public class ImagemForm {

	private String caminho;
	private Long idUsuario;
	private MultipartFile data;
	
	
	public ImagemForm(String caminho, MultipartFile data, Long idUsuario) {
		super();
		this.caminho = caminho;
		this.data = data;
		this.idUsuario = idUsuario;
	}
	
	public Imagem converter() {
		Imagem img = new Imagem();
		img.setCaminho(caminho);
		return img;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
