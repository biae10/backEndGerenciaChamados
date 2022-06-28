package br.ifba.edu.chamados.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "Chamado")
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long chamadoId;
	private String assunto;
	
	@Enumerated(EnumType.STRING)
	private StatusChamado status = StatusChamado.ABERTO;
	private String complemento;
	private String dataRegistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;	
	
	public Chamado(long chamadoId, String assunto, StatusChamado status, String complemento, String dataRegistro) {
		super();
		this.chamadoId = chamadoId;
		this.assunto = assunto;
		this.status = status;
		this.complemento = complemento;
		this.dataRegistro = dataRegistro;
	}

	public Chamado() {}
	
	public long getChamadoId() {
		return chamadoId;
	}

	public void setChamadoId(long chamadoId) {
		this.chamadoId = chamadoId;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public StatusChamado getStatus() {
		return status;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
