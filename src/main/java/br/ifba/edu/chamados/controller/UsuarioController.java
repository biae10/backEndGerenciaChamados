package br.ifba.edu.chamados.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ifba.edu.chamados.dto.UsuarioDto;
import br.ifba.edu.chamados.dto.UsuarioForm;
import br.ifba.edu.chamados.model.Usuario;
import br.ifba.edu.chamados.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<UsuarioDto> listarUsuarios(String email){
		if((email != null) && (email != "")) {
			return UsuarioDto.converterUsuarios(usuarioRepository.findByEmail(email));
		}
		return UsuarioDto.converterUsuarios(usuarioRepository.findAll());
	}

	@PostMapping("/add")
	public ResponseEntity<String> salvarNovoUsuario(@RequestBody UsuarioForm form){
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		return new ResponseEntity<String>("Usuário adicionado com sucesso!",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> editarUsuario(@PathVariable long id, @RequestBody UsuarioForm form){
		
		Usuario usuario = form.atualizar(usuarioRepository, id);
		usuarioRepository.save(usuario);
		return new ResponseEntity<String>("O usuário foi atualizado com sucesso!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> removerUsuario(@PathVariable long id){
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("O usuário foi removido com sucesso!!",HttpStatus.OK);
	}
	
	
	
}
