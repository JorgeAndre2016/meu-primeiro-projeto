CREATE TABLE IF NOT EXISTS `testes`.`empresa` (
  `idempresa` INT NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(255) NOT NULL,
  `data_atualizacao` DATETIME NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `razao_social` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idempresa`))
ENGINE = InnoDB