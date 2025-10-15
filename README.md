# Sistema de Gestión de Ventas - Java

Sistema de gestión de ventas desarrollado en Java utilizando JPA/Hibernate para el manejo de persistencia de datos y MySQL como base de datos.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal
- **Hibernate**: Framework ORM para persistencia de datos
- **JPA**: API de persistencia de Java
- **MySQL**: Sistema de gestión de base de datos
- **Gradle**: Herramienta de construcción y gestión de dependencias
- **Docker**: Containerización para el entorno de desarrollo

## Estructura del Proyecto

```
sales-management-system-java/
├── backend/
│   ├── src/main/java/org/uptc/sales_tracker/
│   │   ├── model/
│   │   │   ├── Person.java      # Entidad de personas
│   │   │   ├── Product.java     # Entidad de productos
│   │   │   ├── Invoice.java     # Entidad de facturas
│   │   │   └── Detail.java      # Detalle de facturas
│   │   ├── conf/
│   │   │   └── PersistenceUtil.java
│   │   └── Main.java
│   ├── build.gradle.kts
│   └── settings.gradle.kts
├── db/
│   └── init.sql                 # Script de inicialización de BD
├── infra/
│   ├── compose.dev.yml          # Docker Compose para desarrollo
│   ├── .env.dev.example         # Ejemplo de variables de entorno
│   └── .env.dev                 # Variables de entorno (no versionado)
└── README.md
```

## Modelo de Datos

### Entidades Principales

- **Person**: Representa personas que pueden ser clientes, vendedores o proveedores
- **Product**: Productos disponibles en el sistema
- **Invoice**: Facturas de venta
- **Detail**: Detalles de cada producto en una factura

## Configuración

### Requisitos Previos

- Java 11 o superior
- Docker y Docker Compose
- MySQL 8.0 o superior (si no usas Docker)
- Gradle

### Opción 1: Usando Docker

1. Copiar el archivo de configuración:
```bash
cp infra/.env.dev.example infra/.env.dev
```

2. Ajustar las variables de entorno en `infra/.env.dev` si es necesario

3. Levantar la base de datos:
```bash
docker compose -f infra/compose.dev.yml --env-file infra/.env.dev up -d
```

Esto creará automáticamente:
- Contenedor MySQL en el puerto 21911
- Base de datos `sales_tracker_db`
- Usuario `sales_tracker_user`
- Ejecución automática del script `init.sql`

### Opción 2: Base de Datos Local

1. Crear una base de datos MySQL
2. Ejecutar el script `db/init.sql` para crear las tablas necesarias
3. Configurar la conexión en `backend/src/main/resources/META-INF/persistence.xml`  

### Compilación y Ejecución

```bash
# Navegar al directorio backend
cd backend

# Compilar el proyecto
./gradlew build

# Ejecutar la aplicación
./gradlew run
```

## Ejemplos de Uso

Al ejecutar la aplicación, automáticamente se realizan las siguientes operaciones:

- Carga datos de prueba
- Consulta facturas del cliente con ID 1
- Lista productos del proveedor con ID 1
- Calcula ingresos del vendedor con ID 1
- Imprime la factura con ID 1

## Dependencias

- `hibernate-core:6.0.2.Final`: Framework ORM
- `mysql-connector-java:8.0.33`: Conector MySQL
- `junit-jupiter`: Framework de testing

## Configuración de Base de Datos

La configuración por defecto para Docker incluye:

- **Host**: localhost
- **Puerto**: 21911
- **Base de datos**: sales_tracker_db
- **Usuario**: sales_tracker_user
- **Contraseña**: sales_tracker_pass

## Autor
Cristhian Fernando Moreno Manrique

Desarrollado como actividad académica para la Universidad Pedagógica y Tecnológica de Colombia (UPTC).