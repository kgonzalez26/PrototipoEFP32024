DROP DATABASE siu;
CREATE DATABASE siu;
USE siu;
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(60) NOT NULL,
  password VARCHAR(25)NOT NULL,
  PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS aplicacion(
  aplid int NOT NULL AUTO_INCREMENT,
    aplnombre VARCHAR(50),
    aplestatus VARCHAR(50),
    PRIMARY KEY (aplid)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;

-- Creanción de la Bitacora de seguridad
CREATE TABLE IF NOT EXISTS bitacora (
  bitid int auto_increment PRIMARY KEY,
    bitfecha datetime NULL,
    bitaccion VARCHAR(10) NOT NULL,
    bitip VARCHAR(25) NOT NULL,
    bitnombrepc VARCHAR(50) NOT NULL,
    usuid INT NOT NULL,
    aplid INT NOT NULL,
    FOREIGN KEY (aplid) references aplicacion (aplid),
    FOREIGN KEY (usuid) references usuario (id_usuario)
) ENGINE = InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS peliculas (
    idPeliculas INT,
    nombre VARCHAR(45),
    clasificacion VARCHAR(45),
    genero VARCHAR(45),
    subtitulado VARCHAR(45),
    idioma VARCHAR(45),
    precio DOUBLE
) ENGINE = InnoDB DEFAULT CHARSET=latin1;