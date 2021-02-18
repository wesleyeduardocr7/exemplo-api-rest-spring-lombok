CREATE TABLE IF NOT EXISTS `colaborador` (
    `id_colaborador` bigint(20) NOT NULL AUTO_INCREMENT,
    `nome` varchar(100) NOT NULL,
    `matricula` varchar(30) NOT NULL,
    `salario` decimal,
    `id_empresa` bigint(20) NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES empresa (id_empresa),
    PRIMARY KEY (`id_colaborador`)
)