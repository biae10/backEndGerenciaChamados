package br.ifba.edu.chamados.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ifba.edu.chamados.dto.ImagemDto;
import br.ifba.edu.chamados.dto.ImagemForm;
import br.ifba.edu.chamados.model.Imagem;

import br.ifba.edu.chamados.repository.ImagemRepository;
import br.ifba.edu.chamados.repository.UsuarioRepository;

@RestController
@RequestMapping("/imagens")
public class ImagemController {
	
	public static String endereco = "C:\\Users\\user\\Documents\\Estudos\\Faculdade\\Pweb\\ExemplosReact\\public\\img\\";
	@Autowired
	private ImagemRepository repository;
	@Autowired
	private UsuarioRepository userRepository;

	
	@GetMapping
	public List<ImagemDto> Listarimagem(Long id){
		if(id != null) {
			return ImagemDto.converterImagens(repository.findListaByusuarioId(id));
		}
		return ImagemDto.converterImagens(repository.findAll());
	}
	
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<String> uploadImagem(@ModelAttribute ImagemForm imagem){
		
		Imagem img = new Imagem();
		
		img = imagem.converter();
		img.setUsuario(userRepository.getById(imagem.getIdUsuario()));
		
		try {
			if(!imagem.getData().isEmpty()) {
				byte[] bytes = imagem.getData().getBytes();
				Path caminho = Paths.get(endereco+String.valueOf(imagem.getIdUsuario())+imagem.getData().getOriginalFilename());
				Files.write(caminho, bytes);
				img.setCaminho(String.valueOf(imagem.getIdUsuario())+imagem.getData().getOriginalFilename());
			}
		}catch(IOException e) {
			
		}
		repository.save(img);
		return new ResponseEntity<String>("Imagem adicionada com sucesso!",HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.PUT, consumes = {"multipart/form-data"})
	public ResponseEntity<String> atualizarImagem(@ModelAttribute("data") ImagemForm imagem,@PathVariable Long id){
		
		Imagem img = new Imagem();
		
		img = imagem.converter();
		img.setUsuario(userRepository.getById(imagem.getIdUsuario()));
		img.setId(id);
		
		Imagem amostra = repository.getById(id);
		repository.deleteById(id);
		
		try {
			if(!imagem.getData().isEmpty()) {
				byte[] bytes = imagem.getData().getBytes();
				Path caminho = Paths.get(endereco+String.valueOf(imagem.getIdUsuario())+imagem.getData().getOriginalFilename());
				Files.write(caminho, bytes);
				Files.delete(Paths.get(endereco + amostra.getCaminho()));
				img.setCaminho(String.valueOf(imagem.getIdUsuario())+imagem.getData().getOriginalFilename());
			}
		}catch(IOException e) {
			
		}
		repository.save(img);
		return new ResponseEntity<String>("Imagem adicionada com sucesso!",HttpStatus.CREATED);
	}
	
}
