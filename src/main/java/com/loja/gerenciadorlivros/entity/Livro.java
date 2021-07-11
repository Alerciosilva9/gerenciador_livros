package com.loja.gerenciadorlivros.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;


@Entity
@Data
@Builder
public class Livro {

	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false)
	private Integer paginas;
	
	@Column(nullable = false)
	private Integer capitulos;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(nullable = false)
	private String nomeeditora;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE.PERSIST.REMOVE)
	@JoinColumn(name = "autor_id")
	private Autor autor;
}
