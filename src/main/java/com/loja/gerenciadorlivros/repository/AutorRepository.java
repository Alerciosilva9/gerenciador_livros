package com.loja.gerenciadorlivros.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.gerenciadorlivros.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
