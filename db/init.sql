/* creating tables */
CREATE TABLE Cliente (
    CPF varchar(11),
    CNH varchar(11),
    Nome varchar(255),
    Endereco varchar(255),
    CreditCard varchar(16),
    DataDeNascimento varchar(10),
    NecessidadesEspeciais tinyint(1) default null,
    DataDeCadastro varchar(10),
    DataDeAlteracao varchar(10)
) ENGINE=INNODB;

CREATE TABLE Veiculos (
    CPF varchar(11),
    foreign key (CPF) references Cliente (CPF),
    Modelo varchar(40),
    Marca varchar(40),
    Placa varchar(10),
    Grupo varchar(5),
    DataInicio varchar(10),
    DataTermino varchar(10)
) ENGINE=INNODB;

/* inserting an example value */
INSERT INTO Cliente (
    nome,
    endereco,
    cc,
    dataDeNascimento,
    cpf,
    cnh,
    necessidadesEspeciais,
    dataDeCadastro,
    dataDeAlteracao
) VALUES (
    "João Ninguém da Silva",
    "Rua dos Bobos, 0",
    "1111 2222 3333 4444",
    "30/03/1999",
    "12345678900",
    "000 111 222 33",
    0,
    "20/04/2019",
    "20/04/2019"
);

INSERT INTO Veiculos (
    CPF,
    Modelo,
    Marca,
    Placa,
    Grupo,
    DataInicio,
    DataTermino
) VALUES (
    "12345678900",
    "Model X",
    "Tesla",
    "P4D4R14",
    "sp",
    "20/04/2019",
    "23/04/2019"
);