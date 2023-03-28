-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: retaguarda
-- ------------------------------------------------------
-- Server version	8.0.32-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bairro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `fone1` varchar(15) NOT NULL,
  `fone2` varchar(15) NOT NULL,
  `complemento` varchar(100) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `dataCadastro` date NOT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  `status` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cpf` varchar(14) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `rg` varchar(9) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `endereco_id` int NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_endereco1_idx` (`endereco_id`),
  CONSTRAINT `fk_clientEndereco` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `colaborador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colaborador` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `fone1` varchar(15) NOT NULL,
  `fone2` varchar(15) NOT NULL,
  `complementoEndereco` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dataCadastro` date NOT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `login` varchar(10) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `endereco_id INT` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_colaborador_endereco1_idx` (`endereco_id INT`),
  CONSTRAINT `fk_colaboradorEndereco` FOREIGN KEY (`endereco_id INT`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataCompra` date NOT NULL,
  `horaCompra` time NOT NULL,
  `numeroNF` varchar(45) NOT NULL,
  `tipoNF` varchar(45) NOT NULL,
  `valorDesconto` float NOT NULL,
  `valorAcrescimo` float NOT NULL,
  `totalNF` float NOT NULL,
  `status` char(1) NOT NULL,
  `fornecedor_id` int NOT NULL,
  `condicaoPagamento_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compra_fornecedor1_idx` (`fornecedor_id`),
  KEY `fk_compra_condicaoPagamento1_idx` (`condicaoPagamento_id`),
  CONSTRAINT `fk_compra_condPagamento` FOREIGN KEY (`condicaoPagamento_id`) REFERENCES `condicaoPagamento` (`id`),
  CONSTRAINT `fk_compraFornecedor` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `condicaoPagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condicaoPagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricaoCondicao` varchar(45) NOT NULL,
  `numeroParcelas` int NOT NULL,
  `diasPrimeiraParcela` int NOT NULL,
  `diaEntreParcela` int NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `cupomFiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupomFiscal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataVenda` date NOT NULL,
  `horaVenda` time NOT NULL,
  `valorDesconto` float NOT NULL,
  `valorAcrescimo` float NOT NULL,
  `totalCupom` float NOT NULL,
  `status` varchar(1) NOT NULL,
  `colaborador_id` int NOT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cupomFiscal_colaborador1_idx` (`colaborador_id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `cupomFiscal_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_cupomFiscalColaborador` FOREIGN KEY (`colaborador_id`) REFERENCES `colaborador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(100) NOT NULL,
  `cep` varchar(11) DEFAULT NULL,
  `bairro_id` int NOT NULL,
  `cidade_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_endereco_bairro_idx` (`bairro_id`),
  KEY `fk_endereco_cidade1_idx` (`cidade_id`),
  CONSTRAINT `fk_enderecoBairro` FOREIGN KEY (`bairro_id`) REFERENCES `bairro` (`id`),
  CONSTRAINT `fk_enderecoCidade` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `fone1` varchar(15) NOT NULL,
  `fone2` varchar(15) NOT NULL,
  `complementoEndereco` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dataCadastro` date NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `Fornecedor` varchar(45) NOT NULL,
  `InscEstadual` varchar(45) NOT NULL,
  `contato` varchar(45) NOT NULL,
  `razaoSocial` varchar(60) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `rg` varchar(9) NOT NULL,
  `endereco_id INT` int NOT NULL,
  `observacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fornecedor_endereco1_idx` (`endereco_id INT`),
  CONSTRAINT `fk_forneEndereco` FOREIGN KEY (`endereco_id INT`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `historicoMovimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historicoMovimentacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `tipo` char(1) NOT NULL,
  `quantidade` float NOT NULL,
  `status` char(1) NOT NULL,
  `itensCompra_id` int NOT NULL,
  `itemCupomFiscal_id` int DEFAULT NULL,
  `produto_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_historicoMovimentacao_itensCompra1_idx` (`itensCompra_id`),
  KEY `itemCupomFiscal_id` (`itemCupomFiscal_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `fk_historicoMovItensCompra` FOREIGN KEY (`itensCompra_id`) REFERENCES `itensCompra` (`id`),
  CONSTRAINT `historicoMovimentacao_ibfk_1` FOREIGN KEY (`itemCupomFiscal_id`) REFERENCES `itensCupomFiscal` (`id`),
  CONSTRAINT `historicoMovimentacao_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `itensCompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itensCompra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantidadeProduto` float NOT NULL,
  `valorUnitarioProduto` float NOT NULL,
  `status` char(1) NOT NULL,
  `compra_id` int NOT NULL,
  `produto_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_itensCompra_compra1_idx` (`compra_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `fk_itensCompraCompra` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id`),
  CONSTRAINT `itensCompra_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `itensCupomFiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itensCupomFiscal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantidadeProduto` float NOT NULL,
  `valorUnitarioProduto` float NOT NULL,
  `status` char(1) NOT NULL,
  `cupomFiscal_id` int DEFAULT NULL,
  `produto_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cupomFiscal_id` (`cupomFiscal_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `itensCupomFiscal_ibfk_1` FOREIGN KEY (`cupomFiscal_id`) REFERENCES `cupomFiscal` (`id`),
  CONSTRAINT `itensCupomFiscal_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataPagamento` date NOT NULL,
  `horaPagamento` date NOT NULL,
  `valorDesconto` float NOT NULL,
  `valorAcrescimo` float NOT NULL,
  `valorPago` float NOT NULL,
  `status` char(1) NOT NULL,
  `Pagar_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Pagamento_Pagar1_idx` (`Pagar_id`),
  CONSTRAINT `fk_PagamentoPagar` FOREIGN KEY (`Pagar_id`) REFERENCES `pagar` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `pagar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagar` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataEmissao` int NOT NULL,
  `horaEmissao` int NOT NULL,
  `dataVencimento` int NOT NULL,
  `valorPagar` int NOT NULL,
  `status` int NOT NULL,
  `compra_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Pagar_compra1_idx` (`compra_id`),
  CONSTRAINT `fk_PagarCompra` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) NOT NULL,
  `valorCompra` float NOT NULL,
  `valorVenda` float NOT NULL,
  `unidadeCompra` varchar(45) DEFAULT NULL,
  `unidadeVenda` varchar(45) DEFAULT NULL,
  `fatorConversao` int DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `barraEntrada` varchar(45) DEFAULT NULL,
  `barraSaida` varchar(45) DEFAULT NULL,
  `estoqueMinimo` float DEFAULT NULL,
  `estoqueMaximo` float DEFAULT NULL,
  `classe_id` int DEFAULT NULL,
  `marca_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `classe_id` (`classe_id`),
  KEY `marca_id` (`marca_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`classe_id`) REFERENCES `classe` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-27 20:59:36
