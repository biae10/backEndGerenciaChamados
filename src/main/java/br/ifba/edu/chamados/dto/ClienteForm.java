package br.ifba.edu.chamados.dto;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.ifba.edu.chamados.model.Cliente;
import br.ifba.edu.chamados.repository.ClienteRepository;

public class ClienteForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String cnpj;
	@NotNull @NotEmpty
	private String endereco;
	private String dataRegistro;

	public ClienteForm(String nome,String cnpj,String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		
		LocalDate todaysDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = todaysDate.format(formatter);
		this.dataRegistro = hojeFormatado;
	}
	
	public ClienteForm(Cliente cliente) {
		super();
		this.nome = cliente.getNome();
		this.cnpj = cliente.getCnpj();
		this.endereco = cliente.getEndereco();
		this.dataRegistro = cliente.getEndereco();
	}
	
	public Cliente converter() {
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCnpj(cnpj);
		cliente.setEndereco(endereco);
		cliente.setDataRegistro(dataRegistro);
		return cliente;
		
	}
	
	public Cliente atualizarCliente(ClienteRepository repository, long id) {
		
		Cliente modificado = repository.getById(id);
		modificado.setNome(nome);
		modificado.setCnpj(cnpj);
		modificado.setEndereco(endereco);
		modificado.setDataRegistro(dataRegistro);
		return modificado;
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
