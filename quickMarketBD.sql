CREATE DATABASE quickmarket;
USE quickmarket;

CREATE TABLE `quickmarket`.`roles` (
  `idroles` INT NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idroles`));
  
INSERT INTO `quickmarket`.`roles` (`idroles`, `nombres`) VALUES ('11', 'Administrador');
INSERT INTO `quickmarket`.`roles` (`idroles`, `nombres`) VALUES ('12', 'Cajero');

CREATE UNIQUE INDEX roles_pk ON `roles` (`idroles`);

CREATE TABLE `quickmarket`.`usuarios`(
  `idusuario` INT NOT NULL,
  `idroles` INT NULL,
  `usuario` VARCHAR(25) NOT NULL,
  `contrasenia` VARCHAR(25) NOT NULL,
  PRIMARY KEY (idusuario),
  CONSTRAINT FK_USUARIOS_TIENE_ROLES FOREIGN KEY (`idroles`) REFERENCES `roles` (`idroles`)
);

CREATE UNIQUE INDEX USUARIOS_PK ON USUARIOS (`idusuario`);

CREATE INDEX TIENE_FK ON USUARIOS (`idroles`);

INSERT INTO `quickmarket`.`USUARIOS` (`idusuario`, `idroles`, `usuario`, `contrasenia`) VALUES ('1234', '11', 'danny', '1234');
INSERT INTO `quickmarket`.`USUARIOS` (`idusuario`, `idroles`, `usuario`, `contrasenia`) VALUES ('1235', '12', 'carlos', '1212');
INSERT INTO `quickmarket`.`USUARIOS` (`idusuario`, `idroles`, `usuario`, `contrasenia`) VALUES ('1236', '12', 'pedro', '1111');

DELETE FROM `prueba`.`USUARIOS` WHERE (`idusuario` = '1236');
SELECT * FROM ROLES;
SELECT * FROM USUARIOS;