CREATE TABLE tb_parcelamento (id BIGINT NOT NULL AUTO_INCREMENT,
                           cliente_id bigint NOT NULL,
                           descricao VARCHAR(20) NOT NULL,
                           valor_total DECIMAL(10, 2) NOT NULL,
                           quantidade_parcelas tinyint, data_criacao DATETIME NOT NULL,
                           PRIMARY KEY (id));


ALTER TABLE tb_parcelamento ADD CONSTRAINT fk_parcelamento_cliente
    FOREIGN KEY (cliente_id) REFERENCES tb_cliente (id);