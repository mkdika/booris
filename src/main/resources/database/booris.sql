-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema booris
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `booris` ;

-- -----------------------------------------------------
-- Schema booris
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booris` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `booris` ;

-- -----------------------------------------------------
-- Table `booris`.`tb_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_user` (
  `uid` VARCHAR(100) NOT NULL,
  `disable` BIT(1) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`uid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `booris`.`tb_book_author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_book_author` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_book_author` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `authorname` VARCHAR(100) NOT NULL,
  `disable` BIT(1) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `inputdt` DATETIME NULL DEFAULT NULL,
  `inputby` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ajoa5nk53m9dac1spo7dan5i7` (`inputby` ASC),
  CONSTRAINT `FK_ajoa5nk53m9dac1spo7dan5i7`
    FOREIGN KEY (`inputby`)
    REFERENCES `booris`.`tb_user` (`uid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `booris`.`tb_book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_book` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `disable` BIT(1) NOT NULL,
  `image` VARCHAR(100) NULL DEFAULT NULL,
  `inputdt` DATETIME NULL DEFAULT NULL,
  `isbn` VARCHAR(50) NOT NULL,
  `pages` INT(11) NOT NULL,
  `qty` INT(11) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `bookauthor` INT(11) NOT NULL,
  `inputby` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_5fpbu7qe10ryhu4blwgthrkhs` (`bookauthor` ASC),
  INDEX `FK_mok7qxf73qc78y45jolm0obuk` (`inputby` ASC),
  CONSTRAINT `FK_5fpbu7qe10ryhu4blwgthrkhs`
    FOREIGN KEY (`bookauthor`)
    REFERENCES `booris`.`tb_book_author` (`id`),
  CONSTRAINT `FK_mok7qxf73qc78y45jolm0obuk`
    FOREIGN KEY (`inputby`)
    REFERENCES `booris`.`tb_user` (`uid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `booris`.`tb_customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_customer` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `customername` VARCHAR(100) NOT NULL,
  `disable` BIT(1) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `inputdt` DATETIME NULL DEFAULT NULL,
  `inputby` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_oi9n1gksol2h09cmlmdutrkot` (`inputby` ASC),
  CONSTRAINT `FK_oi9n1gksol2h09cmlmdutrkot`
    FOREIGN KEY (`inputby`)
    REFERENCES `booris`.`tb_user` (`uid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `booris`.`tb_borrow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_borrow` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_borrow` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `inputdt` DATETIME NULL DEFAULT NULL,
  `note` VARCHAR(255) NULL DEFAULT NULL,
  `transaction_date` DATE NOT NULL,
  `transaction_type` INT(11) NOT NULL,
  `customerid` INT(11) NULL DEFAULT NULL,
  `inputby` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_eppuuoj0d26oqo2ic7b37b213` (`customerid` ASC),
  INDEX `FK_7o9wrls71t9p9bktg7cgcjnls` (`inputby` ASC),
  CONSTRAINT `FK_7o9wrls71t9p9bktg7cgcjnls`
    FOREIGN KEY (`inputby`)
    REFERENCES `booris`.`tb_user` (`uid`),
  CONSTRAINT `FK_eppuuoj0d26oqo2ic7b37b213`
    FOREIGN KEY (`customerid`)
    REFERENCES `booris`.`tb_customer` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `booris`.`tb_borrow_book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `booris`.`tb_borrow_book` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `booris`.`tb_borrow_book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `qty` INT(11) NOT NULL,
  `bookid` INT(11) NULL DEFAULT NULL,
  `borrowid` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_ay3g7xfhx16kn28o6e1epllo4` (`bookid` ASC),
  INDEX `FK_s7orsvbwd0t7v25ye6j6dmu5k` (`borrowid` ASC),
  CONSTRAINT `FK_ay3g7xfhx16kn28o6e1epllo4`
    FOREIGN KEY (`bookid`)
    REFERENCES `booris`.`tb_book` (`id`),
  CONSTRAINT `FK_s7orsvbwd0t7v25ye6j6dmu5k`
    FOREIGN KEY (`borrowid`)
    REFERENCES `booris`.`tb_borrow` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
