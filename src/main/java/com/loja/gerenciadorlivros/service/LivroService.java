package com.loja.gerenciadorlivros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.gerenciadorlivros.entity.Livro;
import com.loja.gerenciadorlivros.repository.AutorRepository;
import com.loja.gerenciadorlivros.repository.LivroRepository;
@Service
public class LivroService {

	@Autowired
	LivroRepository livrorepository;
	
	@Autowired
	AutorRepository autorrepository;

	public Livro cadastrarlivro(Livro novolivro) {
		if(autorrepository.findById(novolivro.getAutor().getId()).orElse(null)==null) {
			return null;
		}else{
			return livrorepository.save(novolivro);
		}
	}
	
}
