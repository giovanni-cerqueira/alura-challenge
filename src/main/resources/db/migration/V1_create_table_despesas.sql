CREATE TABLE despesas (
	id int auto_increment primary key,
	descricao varchar(255) not null unique,
	valor float not null,
	data date not null,
	id_categoria,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

