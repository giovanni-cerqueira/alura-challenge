CREATE TABLE receitas (
	id int auto_increment primary key,
    descricao varchar(255) not null unique,
    valor float not null,
    data date not null,
    id_conta not not null,
    FOREIGN KEY (id_conta) REFERENCES conta_usuario(id_conta)
);

