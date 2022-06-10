CREATE TABLE IF NOT EXISTS `transports` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `transport` VARCHAR(45) NOT NULL,
    `t_image` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`tk_driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tk_driver` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`routes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `routes` (
      `id` BIGINT NOT NULL AUTO_INCREMENT,
      `transport_id` BIGINT NOT NULL,
      `route_number` INT NOT NULL,
      `time_start` TIME NOT NULL,
      `time_end` TIME NOT NULL,
      `interval_` INT NOT NULL,
      `schedule_` VARCHAR(100) NOT NULL,
      `route_start` VARCHAR(65) NOT NULL,
      `route_end` VARCHAR(65) NOT NULL,
      `tk_driver_id` BIGINT NULL,
      PRIMARY KEY (`id`),
      INDEX `fk_routes_transports_idx` (`transport_id` ASC) VISIBLE,
      INDEX `fk_routes_tk_driver1_idx` (`tk_driver_id` ASC) VISIBLE,
      CONSTRAINT `fk_routes_transports`
      FOREIGN KEY (`transport_id`)
      REFERENCES `transports` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
      CONSTRAINT `fk_routes_tk_driver1`
      FOREIGN KEY (`tk_driver_id`)
      REFERENCES `tk_driver` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`stops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `stops` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `stop_address` VARCHAR(65) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`route_stops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `route_stops` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `route_id` BIGINT NOT NULL,
    `stop_id` BIGINT NOT NULL,
    INDEX `fk_route_stops_stops1_idx` (`stop_id` ASC) VISIBLE,
    INDEX `fk_route_stops_routes1_idx` (`route_id` ASC) VISIBLE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_route_stops_stops1`
    FOREIGN KEY (`stop_id`)
    REFERENCES `stops` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_route_stops_routes1`
    FOREIGN KEY (`route_id`)
    REFERENCES `routes` (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`tk_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tk_user` (
     `id` BIGINT NOT NULL AUTO_INCREMENT,
     `user_name` VARCHAR(15) NOT NULL,
     `first_name` VARCHAR(55) NOT NULL,
     `last_name` VARCHAR(55) NOT NULL,
     `tkpassword` VARCHAR(100) NOT NULL,
     PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_roles` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `tk_role` VARCHAR(45) NOT NULL,
    `tk_user_id` BIGINT NOT NULL,
     PRIMARY KEY (`id`),
     INDEX `fk_user_roles_tk_user1_idx` (`tk_user_id` ASC) VISIBLE,
     CONSTRAINT `fk_user_roles_tk_user1`
     FOREIGN KEY (`tk_user_id`)
     REFERENCES `tk_user` (`id`)
     ON DELETE CASCADE
     ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `transitkyivdb`.`responses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `responses` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `tk_username` VARCHAR(50) NOT NULL,
    `response_text` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;
