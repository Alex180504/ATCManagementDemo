-- MySQL Script generated by MySQL Workbench
-- Fri May 26 14:01:30 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`atc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atc` (
  `idatc` INT NOT NULL,
  `atc_name` VARCHAR(45) NULL,
  `atc_type` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  PRIMARY KEY (`idatc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`subscriber`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`subscriber` (
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `patronym` VARCHAR(45) NULL,
  `bith_date` VARCHAR(45) NULL,
  `gender` VARCHAR(45) NULL,
  `atc_idatc` INT NOT NULL,
  PRIMARY KEY (`atc_idatc`),
  INDEX `fk_subscriber_atc_idx` (`atc_idatc` ASC) VISIBLE,
  CONSTRAINT `fk_subscriber_atc`
    FOREIGN KEY (`atc_idatc`)
    REFERENCES `mydb`.`atc` (`idatc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
