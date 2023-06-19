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

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Mateus Dantas', 'Rua Baraúnas', '195', 'Apt 607', 'Universitário', '58.429-000', 'Campina Grande', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Crisley Marques', 'Rua Baraúnas', '195', 'Apt 607', 'Universitário', '58.429-000', 'Campina Grande', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Jailton Araújo', 'Rua João Pessoa', '24', null, 'Centro', '58.178-000', 'Nova Floresta', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Gabriel Lobinho', 'Rua da Catrevagem', '2424', 'Casa', 'Centro', '58.170-000', 'Barra de Santa Rosa', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Hércules Silva', 'Rua 25 de Março', '121', null, 'Rua da Facada', '58.175-000', 'Cuité', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Davi Marques', 'Rua do Sapo', '100', null, 'Centro', '58.188-000', 'Baraúna', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Hilton Júnior', 'Benedito Marinho', '50', 'Casa', 'Centro', '58.178-000', 'Nova Floresta', 'PB', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);