package br.ifba.edu.chamados.dto;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.chamados.model.Cliente;

public class ClienteDto {
	
	private long clienteId;
	private String nome;
	private String cnpj;
	private String endereco;
	private String dataRegistro;
	
	
	public ClienteDto(Cliente cliente) {
		
		this.clienteId = cliente.getClienteId();
		this.nome = cliente.getNome();
		this.cnpj = cliente.getCnpj();
		this.endereco = cliente.getEndereco();
		this.dataRegistro = cliente.getDataRegistro();
	}
	
	public static List<ClienteDto> converterClientes(List<Cliente> clientes){
		
		List<ClienteDto> dto = new ArrayList<>();
		for(int i = 0; i < clientes.size(); i++) {
			dto.add(new ClienteDto(clientes.get(i)));
		}
		return dto;
	}
	
	public static ClienteDto converterUnico(Cliente cliente) {
		
		ClienteDto dto = new ClienteDto(cliente);
		return dto;
		
	}
	
	public long getClienteId() {
		return clienteId;
	}
	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}	
	
}
