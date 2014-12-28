-- MySQL Script generated by MySQL Workbench
-- Sun Dec 28 14:55:14 2014
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema jb_menu_design
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jb_menu_design` ;

-- -----------------------------------------------------
-- Schema jb_menu_design
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jb_menu_design` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `jb_menu_design` ;

-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_dish` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_dish` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT '菜的ID',
  `name` VARCHAR(45) NOT NULL COMMENT '菜名',
  `is_typed` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '这个菜是否已经被归类',
  `price` FLOAT NULL,
  `description` VARCHAR(300) NULL,
  `disabled` TINYINT(1) NOT NULL DEFAULT 0,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `start_time` TIME NULL,
  `end_time` TIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_user` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_user` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` VARCHAR(45) NULL COMMENT '用户名',
  `passwd` VARCHAR(45) NULL COMMENT '用户密码',
  `type` VARCHAR(45) NULL DEFAULT 0 COMMENT '用户类型 0 Admin',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_menu` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_menu` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL COMMENT '套餐名称',
  `description` VARCHAR(300) NULL,
  `start_time` TIME NULL,
  `end_time` TIME NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_menu_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_menu_dish` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_menu_dish` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `dish_id` BIGINT(10) NOT NULL COMMENT 'Dish’s  ID\n',
  `menu_id` BIGINT(10) NOT NULL COMMENT 'Menu’s ID',
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `md_dish_key_idx` (`dish_id` ASC),
  INDEX `md_menu_key_idx` (`menu_id` ASC),
  CONSTRAINT `md_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `md_menu_key`
    FOREIGN KEY (`menu_id`)
    REFERENCES `jb_menu_design`.`md_menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_activity` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_activity` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(300) NULL,
  `start_time` TIME NULL,
  `end_time` TIME NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_activity_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_activity_dish` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_activity_dish` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `dish_id` BIGINT(10) NOT NULL,
  `activity_id` BIGINT(10) NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `ad_activity_key_idx` (`activity_id` ASC),
  INDEX `ad_dish_key_idx` (`dish_id` ASC),
  CONSTRAINT `ad_activity_key`
    FOREIGN KEY (`activity_id`)
    REFERENCES `jb_menu_design`.`md_activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ad_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
PACK_KEYS = Default;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_command`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_command` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_command` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `msg_extra` VARCHAR(150) NULL,
  `order_date` DATE NULL,
  `order_time` TIME NULL,
  `table_no` INT NULL,
  `client_no` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_command_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_command_dish` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_command_dish` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `command_id` BIGINT(10) NOT NULL,
  `dish_id` BIGINT(10) NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `cd_command_key_idx` (`command_id` ASC),
  INDEX `cd_dish_key_idx` (`dish_id` ASC),
  CONSTRAINT `cd_command_key`
    FOREIGN KEY (`command_id`)
    REFERENCES `jb_menu_design`.`md_command` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cd_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_command_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_command_menu` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_command_menu` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `command_id` BIGINT(10) NOT NULL,
  `menu_id` BIGINT(10) NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `cm_command_key_idx` (`command_id` ASC),
  INDEX `cm_menu_key_idx` (`menu_id` ASC),
  CONSTRAINT `cm_command_key`
    FOREIGN KEY (`command_id`)
    REFERENCES `jb_menu_design`.`md_command` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cm_menu_key`
    FOREIGN KEY (`menu_id`)
    REFERENCES `jb_menu_design`.`md_menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_types`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_types` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_types` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `is_firstmenu` TINYINT(1) NULL,
  `is_secondmenu` TINYINT(1) NULL,
  `firstmenu_id` BIGINT(10) NOT NULL COMMENT 'if is the seconde menu then use this to find first menu',
  `name` VARCHAR(45) NULL COMMENT 'type or menu name',
  `description` VARCHAR(45) NULL,
  `is_for_customize` TINYINT(1) NULL COMMENT 'whether is to show in dish detail page',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_conflict_dish_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_conflict_dish_type` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_conflict_dish_type` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `type_id` BIGINT(10) NOT NULL,
  `conflict_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `cdt_type_key_idx` (`type_id` ASC),
  INDEX `cdt_conflict_type_key_idx` (`conflict_id` ASC),
  CONSTRAINT `cdt_type_key`
    FOREIGN KEY (`type_id`)
    REFERENCES `jb_menu_design`.`md_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cdt_conflict_type_key`
    FOREIGN KEY (`conflict_id`)
    REFERENCES `jb_menu_design`.`md_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_command_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_command_activity` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_command_activity` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `command_id` BIGINT(10) NOT NULL,
  `activity_id` BIGINT(10) NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `ca_command_key_idx` (`command_id` ASC),
  INDEX `ca_activity_key_idx` (`activity_id` ASC),
  CONSTRAINT `ca_command_key`
    FOREIGN KEY (`command_id`)
    REFERENCES `jb_menu_design`.`md_command` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ca_activity_key`
    FOREIGN KEY (`activity_id`)
    REFERENCES `jb_menu_design`.`md_activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_dish_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_dish_type` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_dish_type` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `dish_id` BIGINT(10) NOT NULL,
  `type_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `dt_dish_key_idx` (`dish_id` ASC),
  INDEX `dt_type_key_idx` (`type_id` ASC),
  CONSTRAINT `dt_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dt_type_key`
    FOREIGN KEY (`type_id`)
    REFERENCES `jb_menu_design`.`md_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_options`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_options` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_options` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_dish_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_dish_option` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_dish_option` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `dish_id` BIGINT(10) NOT NULL,
  `option_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `do_option_key_idx` (`option_id` ASC),
  INDEX `do_dish_key_idx` (`dish_id` ASC),
  CONSTRAINT `do_option_key`
    FOREIGN KEY (`option_id`)
    REFERENCES `jb_menu_design`.`md_options` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `do_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_file`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_file` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_file` (
  `id` BIGINT(10) NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `size` BIGINT(10) NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_file_dish`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_file_dish` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_file_dish` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `file_id` BIGINT(10) NOT NULL,
  `dish_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fd_file_key_idx` (`file_id` ASC),
  INDEX `fd_dish_key_idx` (`dish_id` ASC),
  CONSTRAINT `fd_file_key`
    FOREIGN KEY (`file_id`)
    REFERENCES `jb_menu_design`.`md_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fd_dish_key`
    FOREIGN KEY (`dish_id`)
    REFERENCES `jb_menu_design`.`md_dish` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_file_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_file_activity` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_file_activity` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `file_id` BIGINT(10) NOT NULL,
  `activity_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fa_file_key_idx` (`file_id` ASC),
  INDEX `fa_activity_key_idx` (`activity_id` ASC),
  CONSTRAINT `fa_file_key`
    FOREIGN KEY (`file_id`)
    REFERENCES `jb_menu_design`.`md_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fa_activity_key`
    FOREIGN KEY (`activity_id`)
    REFERENCES `jb_menu_design`.`md_activity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jb_menu_design`.`md_file_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jb_menu_design`.`md_file_menu` ;

CREATE TABLE IF NOT EXISTS `jb_menu_design`.`md_file_menu` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `file_id` BIGINT(10) NOT NULL,
  `menu_id` BIGINT(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fm_file_key_idx` (`file_id` ASC),
  INDEX `fm_menu_key_idx` (`menu_id` ASC),
  CONSTRAINT `fm_file_key`
    FOREIGN KEY (`file_id`)
    REFERENCES `jb_menu_design`.`md_file` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fm_menu_key`
    FOREIGN KEY (`menu_id`)
    REFERENCES `jb_menu_design`.`md_menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `jb_menu_design` ;

-- -----------------------------------------------------
-- Placeholder table for view `jb_menu_design`.`Tree Error Node`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jb_menu_design`.`Tree Error Node` (`id` INT);

-- -----------------------------------------------------
-- View `jb_menu_design`.`Tree Error Node`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `jb_menu_design`.`Tree Error Node` ;
DROP TABLE IF EXISTS `jb_menu_design`.`Tree Error Node`;
USE `jb_menu_design`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
