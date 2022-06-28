package br.ifba.edu.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.chamados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEmail(String email);
}
