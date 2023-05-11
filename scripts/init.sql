DROP TABLE IF EXISTS contactos;
CREATE TABLE contactos (
    id INT AUTO_INCREMENT, 
    nombre VARCHAR(50) NOT NULL, 
    apellidos VARCHAR(50), 
    email VARCHAR(50),
	telefono VARCHAR(20),
	PRIMARY KEY (id)
);

INSERT INTO contactos (nombre, apellidos, email, telefono) VALUES 
    ('Juan', 'Pérez', 'juanpi14@us.es', '659871254'),
    ('María', 'Gómez', 'magodefuego291@alum.us.es', '612395432'),
    ('Pedro', 'García', '11st1ke11@proton.me', '64249124'),
    ('Ana', 'Martínez', 'bluewisdomb4g@hotmail.es', '612502345'),
    ('Luisa', 'Sánchez', 'luismi142@gmail.com', '756723951');


