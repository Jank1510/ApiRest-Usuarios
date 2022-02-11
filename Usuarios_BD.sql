CREATE SCHEMA IF NOT EXISTS `clientes`;
USE `clientes`;

CREATE TABLE IF NOT EXISTS clientes.`usuarios`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(100) NOT NULL,
    `apellido` VARCHAR(100) NOT NULL,
    `cedula`  VARCHAR(100) NOT NULL,
    `status` VARCHAR(100) NOT NULL,    
    PRIMARY KEY(`id`)
);
/*
INSERT INTO usuarios(nombre, apellido, cedula, status)
VALUES 
('jank','hurtado','41243245','activo');*/