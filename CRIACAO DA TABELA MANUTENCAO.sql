create table manutencoes(

id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
data DATE NOT NULL,
horimetro INT NOT NULL,
idTecnico INT NOT NULL,
idEquipamento INT NOT NULL,
motivo VARCHAR(500) NOT NULL)

ENGINE = INNODB
