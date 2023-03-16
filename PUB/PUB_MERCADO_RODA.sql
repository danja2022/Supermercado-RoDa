-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Retaguarda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Retaguarda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Retaguarda` DEFAULT CHARACTER SET utf8 ;
USE `Retaguarda` ;

-- -----------------------------------------------------
-- Table `Retaguarda`.`bairro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`bairro` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`bairro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`cidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`cidade` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`cidade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `desccricao` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`endereco` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`endereco` (
  `id INT` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(100) NOT NULL,
  `cep_` VARCHAR(11) NOT NULL,
  `bairro_id` INT NOT NULL,
  `cidade_id` INT NOT NULL,
  PRIMARY KEY (`id INT`),
  INDEX `fk_endereco_bairro_idx` (`bairro_id` ASC),
  INDEX `fk_endereco_cidade1_idx` (`cidade_id` ASC),
  CONSTRAINT `fk_enderecoBairro`
    FOREIGN KEY (`bairro_id`)
    REFERENCES `Retaguarda`.`bairro` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_enderecoCidade`
    FOREIGN KEY (`cidade_id`)
    REFERENCES `Retaguarda`.`cidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`colaborador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`colaborador` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`colaborador` (
  `id` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `fone1` VARCHAR(15) NOT NULL,
  `fone2` VARCHAR(15) NOT NULL,
  `complementoEndereco` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `observacao` VARCHAR(45) NULL,
  `status` CHAR NULL,
  `login` VARCHAR(10) NOT NULL,
  `senha` VARCHAR(10) NOT NULL,
  `endereco_id INT` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_colaborador_endereco1_idx` (`endereco_id INT` ASC),
  CONSTRAINT `fk_colaboradorEndereco`
    FOREIGN KEY (`endereco_id INT`)
    REFERENCES `Retaguarda`.`endereco` (`id INT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`cliente` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `fone1` VARCHAR(15) NOT NULL,
  `fone2` VARCHAR(15) NOT NULL,
  `complementeEndereco` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `observacao` VARCHAR(45) NULL,
  `status` CHAR NULL,
  `CPF` VARCHAR(14) NOT NULL,
  `rg` VARCHAR(9) NOT NULL,
  `dataNascimento` VARCHAR(45) NOT NULL,
  `endereco_id INT` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_endereco1_idx` (`endereco_id INT` ASC),
  CONSTRAINT `fk_clientEndereco`
    FOREIGN KEY (`endereco_id INT`)
    REFERENCES `Retaguarda`.`endereco` (`id INT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`cupomFiscal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`cupomFiscal` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`cupomFiscal` (
  `id` BINARY(16) NOT NULL,
  `dataVenda` DATE NOT NULL,
  `horaVenda` TIME NOT NULL,
  `valorDesconto` FLOAT NOT NULL,
  `valorAcrescimo` FLOAT NOT NULL,
  `totalCupom` FLOAT NOT NULL,
  `status` VARCHAR(1) NOT NULL,
  `colaborador_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cupomFiscal_colaborador1_idx` (`colaborador_id` ASC),
  INDEX `fk_cupomFiscal_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_cupomFiscalColaborador`
    FOREIGN KEY (`colaborador_id`)
    REFERENCES `Retaguarda`.`colaborador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cupomFiscalCliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `Retaguarda`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`fornecedor` (
  `id` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `fone1` VARCHAR(15) NOT NULL,
  `fone2` VARCHAR(15) NOT NULL,
  `complementoEndereco` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `dataCadastro` DATE NOT NULL,
  `status` VARCHAR(45) NULL,
  `Fornecedor` VARCHAR(45) NOT NULL,
  `InscEstadual` VARCHAR(45) NOT NULL,
  `contato` VARCHAR(45) NOT NULL,
  `razaoSocial` VARCHAR(60) NOT NULL,
  `CPF` VARCHAR(11) NOT NULL,
  `rg` VARCHAR(9) NOT NULL,
  `endereco_id INT` INT NOT NULL,
  `observacao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fornecedor_endereco1_idx` (`endereco_id INT` ASC),
  CONSTRAINT `fk_forneEndereco`
    FOREIGN KEY (`endereco_id INT`)
    REFERENCES `Retaguarda`.`endereco` (`id INT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`classe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`classe` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`classe` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
COMMENT = '	';


-- -----------------------------------------------------
-- Table `Retaguarda`.`Marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`Marca` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`Marca` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`produto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`produto` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`produto` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(60) NOT NULL,
  `valorCompra` FLOAT NOT NULL,
  `valorVenda` FLOAT NOT NULL,
  `unidadeCompra` VARCHAR(45) NULL,
  `unidadeVenda` VARCHAR(45) NULL,
  `fatorConversao` INT NULL,
  `status` CHAR NULL,
  `dataCadastro` DATE NULL,
  `barraEntrada` VARCHAR(45) NULL,
  `barraSaida` VARCHAR(45) NULL,
  `estoqueMinimo` FLOAT NULL,
  `estoqueMaximo` FLOAT NULL,
  `classe_id` INT NOT NULL,
  `Marca_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produto_classe1_idx` (`classe_id` ASC),
  INDEX `fk_produto_Marca1_idx` (`Marca_id` ASC),
  CONSTRAINT `fk_produtoClasse`
    FOREIGN KEY (`classe_id`)
    REFERENCES `Retaguarda`.`classe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtoMarca`
    FOREIGN KEY (`Marca_id`)
    REFERENCES `Retaguarda`.`Marca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`itensCupomFiscal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`itensCupomFiscal` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`itensCupomFiscal` (
  `id` BINARY(16) NOT NULL,
  `quantidadeProduto` FLOAT NOT NULL,
  `valorUnitarioProduto` FLOAT NOT NULL,
  `status` CHAR NOT NULL,
  `cupomFiscal_id` BINARY(16) NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itensCupomFiscal_cupomFiscal1_idx` (`cupomFiscal_id` ASC),
  INDEX `fk_itensCupomFiscal_produto1_idx` (`produto_id` ASC),
  CONSTRAINT `fk_itensCupomFiscal_cupomFiscal1`
    FOREIGN KEY (`cupomFiscal_id`)
    REFERENCES `Retaguarda`.`cupomFiscal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itensCupomFiscal_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `Retaguarda`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`condicaoPagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`condicaoPagamento` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`condicaoPagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricaoCondicao` VARCHAR(45) NOT NULL,
  `numeroParcelas` INT NOT NULL,
  `diasPrimeiraParcela` INT NOT NULL,
  `diaEntreParcela` INT NOT NULL,
  `status` CHAR NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`compra` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataCompra` DATE NOT NULL,
  `horaCompra` TIME NOT NULL,
  `numeroNF` VARCHAR(45) NOT NULL,
  `tipoNF` VARCHAR(45) NOT NULL,
  `valorDesconto` FLOAT NOT NULL,
  `valorAcrescimo` FLOAT NOT NULL,
  `totalNF` FLOAT NOT NULL,
  `status` CHAR NOT NULL,
  `fornecedor_id` INT NOT NULL,
  `condicaoPagamento_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compra_fornecedor1_idx` (`fornecedor_id` ASC),
  INDEX `fk_compra_condicaoPagamento1_idx` (`condicaoPagamento_id` ASC),
  CONSTRAINT `fk_compraFornecedor`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `Retaguarda`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_condPagamento`
    FOREIGN KEY (`condicaoPagamento_id`)
    REFERENCES `Retaguarda`.`condicaoPagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`itensCompra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`itensCompra` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`itensCompra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidadeProduto` FLOAT NOT NULL,
  `valorUnitarioProduto` FLOAT NOT NULL,
  `status` CHAR NOT NULL,
  `compra_id` INT NOT NULL,
  `produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itensCompra_compra1_idx` (`compra_id` ASC),
  INDEX `fk_itensCompra_produto1_idx` (`produto_id` ASC),
  CONSTRAINT `fk_itensCompraCompra`
    FOREIGN KEY (`compra_id`)
    REFERENCES `Retaguarda`.`compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itensCompraProduto`
    FOREIGN KEY (`produto_id`)
    REFERENCES `Retaguarda`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`historicoMovimentacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`historicoMovimentacao` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`historicoMovimentacao` (
  `id` BINARY(16) NOT NULL,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `tipo` CHAR NOT NULL,
  `quantidade` FLOAT NOT NULL,
  `status` CHAR NOT NULL,
  `produto_id` INT NOT NULL,
  `itensCupomFiscal_id` BINARY(16) NOT NULL,
  `itensCompra_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_historicoMovimentacao_produto1_idx` (`produto_id` ASC),
  INDEX `fk_historicoMovimentacao_itensCupomFiscal1_idx` (`itensCupomFiscal_id` ASC),
  INDEX `fk_historicoMovimentacao_itensCompra1_idx` (`itensCompra_id` ASC),
  CONSTRAINT `fk_historicoMovProduto`
    FOREIGN KEY (`produto_id`)
    REFERENCES `Retaguarda`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historicoMovItensCupomFiscal`
    FOREIGN KEY (`itensCupomFiscal_id`)
    REFERENCES `Retaguarda`.`itensCupomFiscal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historicoMovItensCompra`
    FOREIGN KEY (`itensCompra_id`)
    REFERENCES `Retaguarda`.`itensCompra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`Pagar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`Pagar` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`Pagar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataEmissao` INT NOT NULL,
  `horaEmissao` INT NOT NULL,
  `dataVencimento` INT NOT NULL,
  `valorPagar` INT NOT NULL,
  `status` INT NOT NULL,
  `compra_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pagar_compra1_idx` (`compra_id` ASC),
  CONSTRAINT `fk_PagarCompra`
    FOREIGN KEY (`compra_id`)
    REFERENCES `Retaguarda`.`compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Retaguarda`.`Pagamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Retaguarda`.`Pagamento` ;

CREATE TABLE IF NOT EXISTS `Retaguarda`.`Pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dataPagamento` DATE NOT NULL,
  `horaPagamento` DATE NOT NULL,
  `valorDesconto` FLOAT NOT NULL,
  `valorAcrescimo` FLOAT NOT NULL,
  `valorPago` FLOAT NOT NULL,
  `status` CHAR NOT NULL,
  `Pagar_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pagamento_Pagar1_idx` (`Pagar_id` ASC),
  CONSTRAINT `fk_PagamentoPagar`
    FOREIGN KEY (`Pagar_id`)
    REFERENCES `Retaguarda`.`Pagar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
