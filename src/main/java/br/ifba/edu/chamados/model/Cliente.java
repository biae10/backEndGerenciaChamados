package br.ifba.edu.chamados.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clienteId;
	private String nome;
	private String cnpj;
	private String endereco;
	private String dataRegistro;
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Chamado> chamados;
	
	public Cliente(long clienteId, String nome, String cnpj, String endereco, String dataRegistro) {
		super();
		this.clienteId = clienteId;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.dataRegistro = dataRegistro;
	}
	
	public Cliente() {}
	
	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
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
