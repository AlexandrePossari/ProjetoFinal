-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Recurso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `preco` INT NOT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Capuz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Capuz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `receita` INT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Couro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Couro` (
  `Capuz_id` INT NULL,
  `Recurso_id` INT NOT NULL,
  PRIMARY KEY (`Recurso_id`),
  CONSTRAINT `fk_Couro_Capuz1`
    FOREIGN KEY (`Capuz_id`)
    REFERENCES `mydb`.`Capuz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Couro_Recurso1`
    FOREIGN KEY (`Recurso_id`)
    REFERENCES `mydb`.`Recurso` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Esconderijo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Esconderijo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `receita` INT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Pedra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pedra` (
  `Esconderijo_id` INT NULL,
  `Recurso_id` INT NOT NULL,
  PRIMARY KEY (`Recurso_id`),
  CONSTRAINT `fk_Pedra_Esconderijo1`
    FOREIGN KEY (`Esconderijo_id`)
    REFERENCES `mydb`.`Esconderijo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedra_Recurso1`
    FOREIGN KEY (`Recurso_id`)
    REFERENCES `mydb`.`Recurso` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Transmutacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Transmutacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Recurso_has_Transmutacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Recurso_has_Transmutacao` (
  `Recurso_id` INT NOT NULL,
  `Transmutacao_id` INT NOT NULL,
  PRIMARY KEY (`Recurso_id`, `Transmutacao_id`),
  CONSTRAINT `fk_Recurso_has_Transmutacao_Recurso1`
    FOREIGN KEY (`Recurso_id`)
    REFERENCES `mydb`.`Recurso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Recurso_has_Transmutacao_Transmutacao1`
    FOREIGN KEY (`Transmutacao_id`)
    REFERENCES `mydb`.`Transmutacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

