package br.ifba.edu.chamados.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifba.edu.chamados.dto.ChamadoDto;
import br.ifba.edu.chamados.dto.ChamadoForm;
import br.ifba.edu.chamados.dto.ClienteForm;
import br.ifba.edu.chamados.model.Chamado;
import br.ifba.edu.chamados.model.Cliente;
import br.ifba.edu.chamados.repository.ChamadoRepository;
import br.ifba.edu.chamados.repository.ClienteRepository;
import br.ifba.edu.chamados.repository.UsuarioRepository;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<ChamadoDto> listarChamados(Long id){
		
		if(id != null) {
			return ChamadoDto.converterChamados(chamadoRepository.findListaChamadosBychamadoId(id));
		}
		return ChamadoDto.converterChamados(chamadoRepository.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> salvarNovoChamado(@RequestBody ChamadoForm form){
		Chamado chamado = form.converter();
		chamado.setUsuario(userRepository.getById(form.getUsuario()));
		chamado.setCliente(clienteRepository.getById( form.getCliente()));
		chamadoRepository.save(chamado);
		return new ResponseEntity<String>("Chamado adicionado com sucesso!",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> editarChamado(@PathVariable long id, @RequestBody ChamadoForm form ){
		Chamado chamado = form.atualiza(chamadoRepository, id);
		chamado.setUsuario(userRepository.getById(form.getUsuario()));
		chamado.setCliente(clienteRepository.getById( form.getCliente()));
		chamadoRepository.save(chamado);		
		return new ResponseEntity<String>("O chamado foi atualizado com sucesso!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> removerChamado(@PathVariable long id){
		chamadoRepository.deleteById(id);
		return new ResponseEntity<String>("Chamado removido com sucesso!",HttpStatus.OK);
	}
	
}
