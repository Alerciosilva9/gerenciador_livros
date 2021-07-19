-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Autor_seq;

CREATE TABLE Autor(
	id BIGINT PRIMARY KEY DEFAULT NEXTVAL ('Autor_seq'),
    nome VARCHAR(50) NOT NULL,
   	idade BIGINT NOT NULL
) ; 

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE Livro_seq;

CREATE TABLE Livro(
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL ('Livro_seq'),
    nome VARCHAR(50) NOT NULL,
    paginas BIGINT NOT NULL,
    capitulos  BIGINT NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    nomeeditora VARCHAR(50) NOT NULL,
    id_autor BIGINT NOT NULL,
     FOREIGN KEY (id_autor) references Autor(id)
) ; 

insert into Autor(nome,idade) values ('carlos',1);


