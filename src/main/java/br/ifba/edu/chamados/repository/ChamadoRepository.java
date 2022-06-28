package br.ifba.edu.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifba.edu.chamados.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

	List<Chamado> findListaChamadosBychamadoId(Long id);
}
