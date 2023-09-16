CREATE TABLE lancamento (
    id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_categoria BIGINT(20) NOT NULL,
    id_pessoa BIGINT(20) NOT NULL,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DOUBLE NOT NULL,
    observacao VARCHAR(50),
    tipo ENUM('RECEITA','DESPESA') NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id),
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id)
);