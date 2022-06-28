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

import br.ifba.edu.chamados.dto.ClienteDto;
import br.ifba.edu.chamados.dto.ClienteForm;
import br.ifba.edu.chamados.model.Cliente;
import br.ifba.edu.chamados.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<ClienteDto> listarClientes(Long id){
		if(id != null) {
			return ClienteDto.converterClientes(clienteRepository.findListByclienteId(id));
		}
		return ClienteDto.converterClientes(clienteRepository.findAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> salvarNovoCliente(@RequestBody ClienteForm form){
		Cliente cliente = form.converter();
		clienteRepository.save(cliente);
		return new ResponseEntity<String>("Cliente adicionado com sucesso!",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> editarCliente(@PathVariable long id, @RequestBody ClienteForm form ){
		Cliente cliente = form.atualizarCliente(clienteRepository, id);
		clienteRepository.save(cliente);		
		return new ResponseEntity<String>("O cliente foi atualizado com sucesso!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> removerCliente(@PathVariable long id){
		clienteRepository.deleteById(id);
		return new ResponseEntity<String>("Cliente removido com sucesso!",HttpStatus.OK);
	}
	
}
