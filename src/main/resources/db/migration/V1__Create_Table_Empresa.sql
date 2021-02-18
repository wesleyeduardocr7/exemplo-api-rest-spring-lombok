CREATE TABLE IF NOT EXISTS `empresa` (
  `id_empresa` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_fantasia` varchar(100) NOT NULL,
  `cnpj` varchar(30) NOT NULL,
  `endereco` varchar(100),
  PRIMARY KEY (`id_empresa`)
) 