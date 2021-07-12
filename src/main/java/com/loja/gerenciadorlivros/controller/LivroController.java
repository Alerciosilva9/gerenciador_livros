package com.loja.gerenciadorlivros.controller;
import java.net.URI;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.loja.gerenciadorlivros.entity.Livro;
import com.loja.gerenciadorlivros.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroRepository livrorepository;
	
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid Livro livro, HttpServletResponse response) {
		 
		
		Livro livrosalvo = livrorepository.save(livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Id}").buildAndExpand(livrosalvo.getId()).toUri();
		 response.setHeader("Locale", uri.toASCIIString());
		 return ResponseEntity.created(uri).body(livrosalvo);
		

		
		
	}
	
	
}
