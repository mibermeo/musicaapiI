CREATE TABLE IF NOT EXISTS musico(
    idm SERIAL,
    nombre VARCHAR (100) NOT NULL,
    apellido VARCHAR (100) NOT NULL,
    edad INT,
    descripcion VARCHAR (200) NOT NULL,
    PRIMARY KEY (idm)
    );

CREATE TABLE IF NOT EXISTS band(
    id SERIAL,
    idm SERIAL,
    nombre_band VARCHAR (100) NOT NULL,
    genero VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idm) REFERENCES musico(idm)

    );


CREATE TABLE IF NOT EXISTS cliente(
    id SERIAL,
    nombre_cli VARCHAR (100) NOT NULL,
    apelli_clie VARCHAR (100) NOT NULL,
    edad INT,
    correo VARCHAR (100) NOT NULL,
    PRIMARY KEY (id)
    );