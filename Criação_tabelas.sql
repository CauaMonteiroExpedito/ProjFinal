create database ProjetoFinal;

use ProjetoFinal;

CREATE TABLE Aeroportos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  quantidade_terminais INT NOT NULL,
  tamanho_area_total DECIMAL(10, 2) NOT NULL,
  capacidade_avioes INT NOT NULL,
  torres_controle INT NOT NULL,
  pistas_voo INT NOT NULL,
  localizacao VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS equipamentos (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nomeequipamento VARCHAR(100) NOT NULL,
  datacompra date NOT NULL,
  precocompra double NOT NULL,
  validade VARCHAR(100) NOT NULL,
  lote VARCHAR(150) NOT NULL,
  quantidade int not null,
  marca varchar(100) not null,
  tecnicoresponsavel varchar(200) not null,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fornecedores (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  PRIMARY KEY (id)
);

create table manutencoes(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  data DATE NOT NULL,
  horimetro INT NOT NULL,
  idTecnico INT NOT NULL,
  idEquipamento INT NOT NULL,
  motivo VARCHAR(500) NOT NULL
);

ENGINE = INNODB

create table	tecnicos(
  id	BIGINT NOT	NULL	AUTO_INCREMENT,
  nome	VARCHAR(255),
  cpf	VARCHAR(11),
  telefone VARCHAR(11),
  setor VARCHAR(255),
  primary key	(id)
);
