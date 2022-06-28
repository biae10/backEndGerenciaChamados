package br.ifba.edu.chamados.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import br.ifba.edu.chamados.model.Chamado;
import br.ifba.edu.chamados.model.Cliente;
import br.ifba.edu.chamados.model.StatusChamado;
import br.ifba.edu.chamados.model.Usuario;
import br.ifba.edu.chamados.repository.ChamadoRepository;
import br.ifba.edu.chamados.repository.ClienteRepository;
import br.ifba.edu.chamados.repository.UsuarioRepository;

public class ChamadoForm {

	private String assunto;
	private StatusChamado status = StatusChamado.ABERTO;
	private String complemento;
	private String dataRegistro;
	
	private long cliente;
	private long usuario;
	
	public ChamadoForm(String assunto, StatusChamado status, String complemento, long cliente, long usuario) {
		this.assunto = assunto;
		this.status = status;
		this.complemento = complemento;
		this.cliente = cliente;
		this.usuario = usuario;
		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = todaysDate.format(formatter);
		this.dataRegistro = hojeFormatado;
	}

	public Chamado converter() {
		Chamado chamado = new Chamado();
		chamado.setAssunto(assunto);
		chamado.setStatus(status);
		chamado.setComplemento(complemento);
		chamado.setDataRegistro(dataRegistro);
		return chamado;
	}
	
	public Chamado atualiza(ChamadoRepository repository, long id) {
		Chamado chamado = repository.getById(id);
		chamado.setAssunto(assunto);
		chamado.setStatus(status);
		chamado.setComplemento(complemento);
		return chamado;
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

	public long getCliente() {
		return cliente;
	}

	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	
	
}
