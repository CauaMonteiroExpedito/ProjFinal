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
