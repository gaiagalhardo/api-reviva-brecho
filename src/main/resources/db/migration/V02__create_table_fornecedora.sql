CREATE TABLE fornecedora(
	id INT AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(20) NOT NULL,
	nome VARCHAR(200) NOT NULL,
	apelido VARCHAR(200),
	data_aniversario DATETIME NOT NULL,
	data_cadastro DATETIME NOT NULL,
	pais VARCHAR(200),
	estado VARCHAR(2) NOT NULL,
	cidade VARCHAR(200) NOT NULL,
	bairro VARCHAR(200),
	cep VARCHAR(20),
	complemento VARCHAR(200),
	email VARCHAR(100),
	instagram VARCHAR(50), 	
	id_banco INT,
	chave_pix VARCHAR(100),
	pix VARCHAR(100),
	
	CONSTRAINT fk_fornecedoraBanco FOREIGN KEY (id_banco) REFERENCES banco (id)
	
);