CREATE TABLE pessoa (
    id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
    numero VARCHAR(20),
    complemento VARCHAR(20),
    bairro VARCHAR(20),
    cep VARCHAR(10),
    cidade VARCHAR(30),
    estado VARCHAR(20),
    ativo BOOLEAN NOT NULL
);