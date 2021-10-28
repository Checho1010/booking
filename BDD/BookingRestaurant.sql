CREATE SCHEMA IF NOT EXISTS `BOOKING_RESTAURANT` DEFAULT CHARACTER SET utf8 ;
USE `BOOKING_RESTAURANT` ;

-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`RESTAURANT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`RESTAURANT` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(100) NULL,
  `ADDRESS` VARCHAR(100) NULL,
  `IMAGE` VARCHAR(500) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`RESERVATION` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `LOCATOR` VARCHAR(45) NULL,
  `PERSON` INT(19) NULL,
  `DATE` DATE NULL,
  `TURN` VARCHAR(45) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_RESERVATION_RESTAURANT_idx` (`RESTAURANT_ID` ASC) ,
  CONSTRAINT `fk_RESERVATION_RESTAURANT`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`TURN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`TURN` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_TURN_RESTAURANT1_idx` (`RESTAURANT_ID` ASC) ,
  CONSTRAINT `fk_TURN_RESTAURANT1`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '				';


-- -----------------------------------------------------
-- Table `BOOKING_RESTAURANT`.`BOARD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`BOARD` (
  `ID` INT(19) NOT NULL AUTO_INCREMENT,
  `CAPACITY` INT(19) NULL,
  `NUMBER` INT(19) NULL,
  `RESTAURANT_ID` INT(19) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_BOARD_RESTAURANT1_idx` (`RESTAURANT_ID` ASC) ,
  CONSTRAINT `fk_BOARD_RESTAURANT1`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `BOOKING_RESTAURANT`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

ALTER TABLE `booking_restaurant`.`restaurant` 
ADD COLUMN `PRICE` INT(19) NULL AFTER `IMAGE`;


ALTER TABLE `booking_restaurant`.`reservation` 
ADD COLUMN `NAME` VARCHAR(45) NULL AFTER `RESTAURANT_ID`,
ADD COLUMN `EMAIL` VARCHAR(45) NULL AFTER `NAME`;

ALTER TABLE `booking_restaurant`.`reservation` 
ADD COLUMN `PAYMENT` BLOB NULL AFTER `EMAIL`;




CREATE TABLE IF NOT EXISTS `BOOKING_RESTAURANT`.`NOTIFICATION` (
  `ID` INT(19) NOT NULL,
  `TEMPLATE` VARCHAR(8000) NULL,
  `TEMPLATE_TYPE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;

