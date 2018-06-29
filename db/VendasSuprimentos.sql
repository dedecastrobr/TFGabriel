-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TrabalhoLPBD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TrabalhoLPBD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TrabalhoLPBD` DEFAULT CHARACTER SET utf8 ;
USE `TrabalhoLPBD` ;

-- -----------------------------------------------------
-- Table `TrabalhoLPBD`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrabalhoLPBD`.`Clientes` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `NumTelefone` INT(12) NOT NULL,
  `DataNasc` DATE NOT NULL,
  `CPF` INT(13) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TrabalhoLPBD`.`Suprimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrabalhoLPBD`.`Suprimentos` (
  `idSuprimentos` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Preco` FLOAT NOT NULL,
  `Marca` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSuprimentos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TrabalhoLPBD`.`Demandas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrabalhoLPBD`.`Demandas` (
  `idDemandas` INT NOT NULL AUTO_INCREMENT,
  `Data` VARCHAR(45) NOT NULL,
  `ValorTotal` FLOAT NOT NULL,
  PRIMARY KEY (`idDemandas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TrabalhoLPBD`.`Clientes_has_Demandas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrabalhoLPBD`.`Clientes_has_Demandas` (
  `Clientes_idCliente` INT NOT NULL,
  `Demandas_idDemandas` INT NOT NULL,
  PRIMARY KEY (`Clientes_idCliente`, `Demandas_idDemandas`),
  INDEX `fk_Clientes_has_Demandas_Demandas1_idx` (`Demandas_idDemandas` ASC),
  INDEX `fk_Clientes_has_Demandas_Clientes_idx` (`Clientes_idCliente` ASC),
  CONSTRAINT `fk_Clientes_has_Demandas_Clientes`
    FOREIGN KEY (`Clientes_idCliente`)
    REFERENCES `TrabalhoLPBD`.`Clientes` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clientes_has_Demandas_Demandas1`
    FOREIGN KEY (`Demandas_idDemandas`)
    REFERENCES `TrabalhoLPBD`.`Demandas` (`idDemandas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TrabalhoLPBD`.`Demandas_has_Suprimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TrabalhoLPBD`.`Demandas_has_Suprimentos` (
  `Demandas_idDemandas` INT NOT NULL,
  `Suprimentos_idSuprimentos` INT NOT NULL,
  PRIMARY KEY (`Demandas_idDemandas`, `Suprimentos_idSuprimentos`),
  INDEX `fk_Demandas_has_Suprimentos_Suprimentos1_idx` (`Suprimentos_idSuprimentos` ASC),
  INDEX `fk_Demandas_has_Suprimentos_Demandas1_idx` (`Demandas_idDemandas` ASC),
  CONSTRAINT `fk_Demandas_has_Suprimentos_Demandas1`
    FOREIGN KEY (`Demandas_idDemandas`)
    REFERENCES `TrabalhoLPBD`.`Demandas` (`idDemandas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Demandas_has_Suprimentos_Suprimentos1`
    FOREIGN KEY (`Suprimentos_idSuprimentos`)
    REFERENCES `TrabalhoLPBD`.`Suprimentos` (`idSuprimentos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
