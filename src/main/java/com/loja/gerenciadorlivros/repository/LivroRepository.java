package com.loja.gerenciadorlivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.gerenciadorlivros.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
