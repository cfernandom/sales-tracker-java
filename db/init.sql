CREATE TABLE personas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    tipo_documento VARCHAR(2),
    numero_documento VARCHAR(15)
);

CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio_unitario DECIMAL(6,3) NOT NULL
);

CREATE TABLE proveedor_producto (
    proveedor_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    PRIMARY KEY (proveedor_id, producto_id),
    FOREIGN KEY (proveedor_id) REFERENCES personas(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

CREATE TABLE facturas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE DEFAULT CURRENT_DATE,
    vendedor_id BIGINT NOT NULL,
    cliente_id BIGINT NOT NULL,
    FOREIGN KEY (vendedor_id) REFERENCES personas(id),
    FOREIGN KEY (cliente_id) REFERENCES personas(id)
);

CREATE TABLE detalles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    factura_id BIGINT NOT NULL,
    producto_id BIGINT NOT NULL,
    cantidad INT NOT NULL,
    precio_venta DECIMAL(6,3) NOT NULL,
    FOREIGN KEY (factura_id) REFERENCES facturas(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

