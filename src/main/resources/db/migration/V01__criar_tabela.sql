CREATE TABLE Autor(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
   	idade BIGINT(20) NOT NULL
) ENGINE=innoDB DEFAULT CHARSET=utf8; 

CREATE TABLE Livro(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    paginas BIGINT(20) NOT NULL,
    capitulos  BIGINT(20) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    nomeeditora VARCHAR(50) NOT NULL,
    id_autor BIGINT(20) NOT NULL,
     FOREIGN KEY (id_autor) references Autor(id)
) ENGINE=innoDB DEFAULT CHARSET=utf8; 

insert into Autor(nome,idade) values ('carlos',19);


