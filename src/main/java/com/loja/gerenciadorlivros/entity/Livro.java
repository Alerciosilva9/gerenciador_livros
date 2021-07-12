package com.loja.gerenciadorlivros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
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
	
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Integer getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(Integer capitulos) {
		this.capitulos = capitulos;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNomeeditora() {
		return nomeeditora;
	}

	public void setNomeeditora(String nomeeditora) {
		this.nomeeditora = nomeeditora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
