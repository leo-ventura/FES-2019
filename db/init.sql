/* creating tables */
CREATE TABLE Cliente (
    CPF varchar(11) unique,
    CNH varchar(11) unique,
    Nome varchar(255),
    Endereco varchar(255),
    CreditCard varchar(16),
    DataDeNascimento varchar(10),
    NecessidadesEspeciais tinyint(1) default null,
    DataDeCadastro varchar(10),
    DataDeAlteracao varchar(10)
) ENGINE=INNODB;

CREATE TABLE Veiculos (
    CarId int not null auto_increment primary key,
    Modelo varchar(40),
    Marca varchar(40),
    Placa varchar(10),
    Grupo varchar(5)
) ENGINE=INNODB;

CREATE TABLE HistoricoVeiculos (
    HistoricoId int not null auto_increment primary key,
    CarId int not null,
    foreign key (CarId) references Veiculos (CarId),
    DataDeInicio varchar(10),
    DataDeTermino varchar(10),
    ClienteCPF varchar(11),
    foreign key (ClienteCPF) references Cliente (CPF)
) ENGINE=INNODB;

/* inserting an example value */
INSERT INTO Cliente (
    CPF,
    CNH,
    Nome,
    Endereco,
    CreditCard,
    DataDeNascimento,
    NecessidadesEspeciais,
    DataDeCadastro,
    DataDeAlteracao
) VALUES (
    "12345678900",
    "00011122233",
    "Felipe Coll",
    "Rua do Possato, 0",
    "1111 2222 3333 4444",
    "30/03/1999",
    0,
    "20/04/2019",
    "20/04/2019"
);

INSERT INTO Veiculos (
    Modelo,
    Marca,
    Placa,
    Grupo,
) VALUES (
    "Model X",
    "Tesla",
    "P4D4R14",
    "sp",
);

INSERT INTO Veiculos (
    Modelo,
    Marca,
    Placa,
    Grupo,
) VALUES (
    "Civic",
    "Honda",
    "LEO3264",
    "a",
);

INSERT INTO Veiculos (
    Modelo,
    Marca,
    Placa,
    Grupo,
) VALUES (
    "Etios",
    "Toyota",
    "COL1020",
    "b",
);

INSERT INTO Veiculos (
    Modelo,
    Marca,
    Placa,
    Grupo,
) VALUES (
    "Corsa",
    "Chevrolet",
    "KGB1954",
    "c",
);

INSERT INTO Veiculos (
    Modelo,
    Marca,
    Placa,
    Grupo,
) VALUES (
    "Uno",
    "Fiat",
    "USA1929",
    "d",
);