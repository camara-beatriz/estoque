DROP TABLE IF EXISTS produto;

CREATE TABLE produto (
                         id_produto BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         preco DECIMAL(10, 2) NOT NULL,
                         quantidade_estoque INT DEFAULT 0,
                         data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
);