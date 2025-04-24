CREATE DATABASE incidencias_tecnicas;
USE incidencias_tecnicas;

CREATE TABLE estados (
	id INT PRIMARY KEY AUTO_INCREMENT,
	estadoIncidencia VARCHAR(50) NOT NULL
);

CREATE TABLE tecnicos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE incidencias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    estado_id INT NOT NULL,
    tecnico_id INT NOT NULL,
    FOREIGN KEY (estado_id) REFERENCES estados (id),
    FOREIGN KEY (tecnico_id) REFERENCES tecnicos (id)
);