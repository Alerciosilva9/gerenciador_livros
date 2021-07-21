package com.loja.gerenciadorlivros.controller;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.loja.gerenciadorlivros.entity.Livro;
import com.loja.gerenciadorlivros.repository.LivroRepository;
import com.loja.gerenciadorlivros.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroservice;
	
	@Autowired
	LivroRepository livrorepository;

	
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid Livro livro, HttpServletResponse response) {
		Livro livrosalvo = livroservice.cadastrarlivro(livro);
		if(livrosalvo!=null) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Id}").buildAndExpand(livrosalvo.getId()).toUri();
			response.setHeader("Locale", uri.toASCIIString());
			return ResponseEntity.created(uri).body(livrosalvo);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id informado nao existe");
		}
	}
	
	@GetMapping()
	public List<Livro> listarlivros(){
		return livrorepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> procurarpeloid(@PathVariable long id){
		Livro livro = livrorepository.findById(id).orElse(null);
		return livro!=null ? ResponseEntity.ok(livro) : ResponseEntity.notFound().build() ;
	}
	
}
