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
		long aux = novolivro.getAutor().getId();
		System.out.println("find with id - "+aux);
		if(autorrepository.findById(aux).orElse(null)==null) {
			return null;
		}else{
			return livrorepository.save(novolivro);
		}
	}
	
}
