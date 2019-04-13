/* creating tables */
create table Cliente(clienteId int not null auto_increment primary key, nome text, endereco text, cc text, data text, cpf text, cnh text, necessidadesEspeciais tinyint(1) default null, dataDeCriacao text);

/* inserting an example value */
insert into Cliente (nome, endereco, cc, data, cpf, cnh, necessidades_especiais) values ("João Ninguém da Silva", "Rua dos Bobos, 0", "1111 2222 3333 4444", "30-03-1999", "123.456.789-00", "000 111 222 33", 0, "13-04-2019");
