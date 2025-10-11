# 🛒 Spring E-commerce

## 📖 Descripción general
**Spring E-commerce** es una aplicación web desarrollada con **Spring Boot** que implementa las funcionalidades básicas de un sistema de comercio electrónico.  
El proyecto permite gestionar productos, usuarios y órdenes mediante operaciones **CRUD**, integrando una interfaz web dinámica con **Thymeleaf** y una API REST para la comunicación entre capas.

Este desarrollo fue realizado con el objetivo de **consolidar conocimientos en el ecosistema Spring**, comprendiendo la arquitectura **MVC**, el uso de **JPA** para la persistencia de datos, y la integración de una base de datos relacional **MySQL**.  
Se planea incorporar **Spring Security** para implementar autenticación y autorización de usuarios.

---

## 🧩 Tecnologías utilizadas
- **Java 17**
- **Spring Boot** (Framework principal)
- **Spring MVC** (Arquitectura de controladores y vistas)
- **Spring Data JPA** (Persistencia y ORM)
- **Thymeleaf** (Motor de plantillas para la capa de presentación)
- **MySQL** (Base de datos relacional)
- **Git** (Control de versiones)

---

## ⚙️ Instalación y ejecución

### 🔧 Requisitos previos
- JDK 17 o superior  
- Maven 3.8+  
- MySQL Server  
- Git

### 🚀 Instrucciones
1. Clonar el repositorio:
```
git clone https://github.com/usuario/spring-ecommerce.git
```
2. Acceder al directorio del proyecto:
```
cd spring-ecommerce
```
3. Configurar las credenciales de la base de datos en el archivo **application.properties**:
```
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
4. Ejecutar el proyecto:
```
mvn spring-boot:run
```
5. Acceder desde el navegador:
```
http://localhost:8080
```

---

## 💡 Funcionalidades principales

- Gestión de productos (crear, listar, editar y eliminar)
- Registro y gestión de usuarios
- Creación y visualización de órdenes de compra
- Integración de vistas dinámicas mediante Thymeleaf
- Arquitectura MVC con separación clara de responsabilidades
- Persistencia de datos mediante Spring Data JPA y MySQL

---

## 🧱 Arquitectura del proyecto

El proyecto sigue el patrón Model-View-Controller (MVC):

```
src/
 ├── main/
 │   ├── java/com/ecommerce/
 │   │   ├── controller/     → Controladores de la aplicación
 │   │   ├── model/          → Entidades JPA
 │   │   ├── repository/     → Repositorios (DAO)
 │   │   └── service/        → Lógica de negocio
 │   └── resources/
 │       ├── templates/      → Vistas Thymeleaf
 │       ├── static/         → Archivos estáticos (CSS, JS, imágenes)
 │       └── application.properties
```

---

## 🧠 Aprendizajes

Durante el desarrollo de este proyecto se reforzaron conocimientos en:

- Configuración y estructura de proyectos Spring Boot.
- Integración de capas de servicio, repositorio y controlador bajo arquitectura MVC.
- Persistencia y mapeo de entidades con JPA y MySQL.
- Desarrollo de vistas dinámicas con Thymeleaf.
- Versionado de código y buenas prácticas con Git.

---

## 👨‍💻 Autor

Maximiliano González

Mail: maxigonzalezwk@gmail.com
Linkedin: https://www.linkedin.com/in/maximiliano-b-gonzalez/