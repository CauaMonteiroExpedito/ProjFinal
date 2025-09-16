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
  PRIMARY KEY (id));
