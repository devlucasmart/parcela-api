CREATE TABLE
    cliente
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    nome     VARCHAR(60)  NOT NULL,
    email    VARCHAR(255) NOT NULL,
    telefone VARCHAR(20)  NOT NULL,
    PRIMARY KEY (id)
);

alter table cliente
    add constraint uk_cliente unique (email);