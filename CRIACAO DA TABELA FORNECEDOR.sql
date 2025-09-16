Create database ProjetoFinal;

use projetofinal;

CREATE TABLE IF NOT EXISTS fornecedores (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  email VARCHAR(100) NOT NULL,
  endereco VARCHAR(150) NOT NULL,
  PRIMARY KEY (id))
