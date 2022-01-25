CREATE TABLE conta_usuario(
	id_conta int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome varchar(100) not null,
	email varchar(100),
	senha varchar(255)
);