package br.ifba.edu.chamados.dto;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.chamados.model.Chamado;
import br.ifba.edu.chamados.model.StatusChamado;

public class ChamadoDto {

	private long chamadoId;
	private String assunto;
	private StatusChamado status = StatusChamado.ABERTO;
	private String complemento;
	private String dataRegistro;
	
	private ClienteDto cliente;
	private UsuarioDto usuario;
	
	public ChamadoDto(Chamado chamado) {
		this.chamadoId = chamado.getChamadoId();
		this.assunto = chamado.getAssunto();
		this.status = chamado.getStatus();
		this.complemento = chamado.getComplemento();
		this.dataRegistro = chamado.getDataRegistro();
		this.cliente = ClienteDto.converterUnico(chamado.getCliente());
		this.usuario = UsuarioDto.converterUnico(chamado.getUsuario());
	}
	
	public static List<ChamadoDto> converterChamados(List<Chamado> chamados){
		List<ChamadoDto> chamadosDto = new ArrayList<>();
		for(int i = 0; i < chamados.size(); i++) {
			chamadosDto.add(new ChamadoDto(chamados.get(i)));
		}
		return chamadosDto;
	}

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

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}
	
	
	
}
