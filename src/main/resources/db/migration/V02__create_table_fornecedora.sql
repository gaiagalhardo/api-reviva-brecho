CREATE TABLE fornecedora(
	id INT AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(20) NOT NULL,
	nome VARCHAR(200) NOT NULL,
	apelido VARCHAR(200),
	data_aniversario DATETIME NOT NULL,
	data_cadastro DATETIME NOT NULL,
	estado VARCHAR(2) NOT NULL,
	cidade VARCHAR(200) NOT NULL,
	bairro VARCHAR(200),
	cep VARCHAR(20),
	complemento VARCHAR(200),
	fone VARCHAR(100),
	email VARCHAR(100),
	instagram VARCHAR(50), 	
	id_banco INT,
	conta VARCHAR(100),
	digito VARCHAR(5),
	agencia VARCHAR(100),
	tipo_conta VARCHAR(100),
	chave_pix VARCHAR(100),
	pix VARCHAR(100),
	
	CONSTRAINT fk_fornecedoraBanco FOREIGN KEY (id_banco) REFERENCES banco (id)
	
);