-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- cria o banco de dados "mydb", caso não exista
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- seleciona o BD para podermos usar
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Recurso`
-- -----------------------------------------------------
-- cria a tabela "Recurso" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Recurso` (
-- id é a PK com auto increment, juntamento com a definição dos outros atributos
-- esta é a tabela mãe para Couro e Pedra, que no código será abstrata e mãe de Couro e Pedra
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `preco` INT NOT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Capuz`
-- -----------------------------------------------------
-- cria a tabela "Capuz" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Capuz` (
-- id é a PK com auto increment, juntamento com a definição dos outros atributos
-- receita pode ser nula, pois somente é preenchida com o crafting
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `receita` INT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Couro`
-- -----------------------------------------------------
-- cria a tabela "Couro" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Couro` (
-- Recurso_id é a PK, que vem do relacionamento 1:N entre Couro e Recurso (Couro herda Recurso, Couro is a Recurso)
-- Já o capuz_id é o id do item craftado, caso ocorra o crafting, por isso pode ser nulo
-- também define nenhuma ação em caso de delete ou update, a não ser para o RecursoID, ou seja:
-- caso o recurso com o id que referencia este couro seja deletado, este couro também é
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
-- cria a tabela "Esconderijo" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Esconderijo` (
-- id é a PK com auto increment, juntamento com a definição dos outros atributos
-- receita pode ser nula, pois somente é preenchida com o crafting
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `receita` INT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `mydb`.`Pedra`
-- -----------------------------------------------------
-- cria a tabela "Pedra" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Pedra` (
-- Recurso_id é a PK, que vem do relacionamento 1:N entre Pedra e Recurso (Pedra herda Recurso, Pedra is a Recurso)
-- Já o esconderijo_id é o id do item craftado, caso ocorra o crafting, por isso pode ser nulo
-- também define nenhuma ação em caso de delete ou update, a não ser para o RecursoID, ou seja:
-- caso o recurso com o id que referencia esta pedra seja deletado, esta pedra também é
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

-- cria a tabela "Transmutacao" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Transmutacao` (
-- id é a PK com auto increment, juntamento com a definição dos outros atributos
  `id` INT NOT NULL AUTO_INCREMENT,
  `preco` INT NOT NULL,
  `encantamento` ENUM('1', '2', '3', '4') NOT NULL,
  `grau` ENUM('4', '5', '6', '7', '8') NOT NULL,
  PRIMARY KEY (`id`));

-- cria a tabela "Recurso_has_Transmutacao" no banco de dados "mydb", caso ela não exista
CREATE TABLE IF NOT EXISTS `mydb`.`Recurso_has_Transmutacao` (
-- recursoId e transmutacaoId são FKs e PKs ao mesmo tempo, visto que esta é uma tabela que representa um relacionamento
-- M:n entre transmutacao e recurso
-- também define nenhuma ação em caso de delete ou update
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

