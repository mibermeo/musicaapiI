CREATE TABLE IF NOT EXISTS manager(
    id SERIAL,
    nombre VARCHAR (100) NOT NULL,
    apellido VARCHAR (100) NOT NULL,
    edad INT,
    correo VARCHAR (100) NOT NULL,
    contacto VARCHAR (100) NOT NUll,
    PRIMARY KEY (id)

    );

CREATE TABLE IF NOT EXISTS band(
    id SERIAL,
    manager_id INT NOT NULL,
    nombre_band VARCHAR (100) NOT NULL,
    genero VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (manager_id) REFERENCES manager(id)

    );

CREATE TABLE IF NOT EXISTS musico(
    idm SERIAL,
    band_id INT NOT NULL,
    nombre VARCHAR (100) NOT NULL,
    apellido VARCHAR (100) NOT NULL,
    edad INT,
    descripcion VARCHAR (200) NOT NULL,
    PRIMARY KEY (idm),
    FOREIGN KEY (band_id) REFERENCES band(id)
    );

CREATE TABLE IF NOT EXISTS manager(
    id SERIAL,
    nombre VARCHAR (100) NOT NULL,
    apellido VARCHAR (100) NOT NULL,
    edad INT,
    correo VARCHAR (100) NOT NULL,
    contacto VARCHAR (100) NOT NUll,
    PRIMARY KEY (id)

    );