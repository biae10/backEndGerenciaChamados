package br.ifba.edu.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.chamados.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long>{

	List<Imagem> findListaById(Long id);
	List<Imagem> findListaByusuarioId(Long id);
}
