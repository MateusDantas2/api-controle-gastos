CREATE TABLE categoria (
    id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO categoria (nome) VALUES ('Alimentação');
INSERT INTO categoria (nome) VALUES ('Aluguel');
INSERT INTO categoria (nome) VALUES ('Cartão');
INSERT INTO categoria (nome) VALUES ('Farmácia');
INSERT INTO categoria (nome) VALUES ('Internet');
INSERT INTO categoria (nome) VALUES ('Luz');
INSERT INTO categoria (nome) VALUES ('Supermercado');
INSERT INTO categoria (nome) VALUES ('Transporte');