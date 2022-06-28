package br.ifba.edu.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.chamados.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findListByclienteId(Long clienteId);
}
