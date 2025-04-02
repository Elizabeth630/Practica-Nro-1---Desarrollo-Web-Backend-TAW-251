#Práctica 1 Backend TAW-251: Proyecto Universidad - Spring Boot
# 🎓 Práctica 1 Backend TAW-251: Proyecto Universidad - Spring Boot

Este es un sistema de gestión de estudiantes desarrollado con Spring Boot.  
Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los estudiantes.

## 🚀 Tecnologías utilizadas  
- **Java 17**  
- **Spring Boot**  
- **Maven**  
- **Postman** para pruebas  

## 📌 Endpoints principales  
    | Método  | URL                        | Descripción                   |
    |---------|----------------------------|-------------------------------|
    | `GET`   | `/api/estudiantes`         | Obtener todos los estudiantes |
    | `POST`  | `/api/estudiantes`         | Crear un estudiante           |
    | `PUT`   | `/api/estudiantes/{id}`    | Actualizar un estudiante      |
    | `DELETE`| `/api/estudiantes/{id}`    | Eliminar un estudiante        |

## 📂 Estructura del proyecto  
    com.universidad
    ├── controller
    │   ├── EstudianteController.java
    │   ├── Saludo_RestController.java
    ├── dto
    │   ├── DocenteDTO.java
    │   ├── EstudianteDTO.java
    │   ├── MateriaDTO.java
    ├── model
    │   ├── Docente.java
    │   ├── Estudiante.java
    │   ├── Materia.java
    │   ├── Persona.java
    ├── repository
    │   ├── EstudianteRepository.java
    ├── service
    │   ├── IEstudianteService.java
    │   ├── impl
    │       ├── EstudianteServiceImpl.java
    ├── MiProyectoSpringBootApplication.java


## 📖 Cómo ejecutar el proyecto  
    1️⃣ Clona el repositorio  
    ```sh
    git clone https://github.com/tu-usuario/mi-proyecto-spring-boot.git

    2️⃣ Accede a la carpeta del proyecto
        cd "Proyecto Universidad/mi-proyecto-spring-boot/mi-proyecto-spring-boot"

    3️⃣ Ejecuta la aplicación con Maven
        mvn spring-boot:run

    4️⃣ Prueba los endpoints con Postman o un navegador

        📎 Enlace al repositorio en GitHub
        https://github.com/Elizabeth630/Practica-Nro-1---Desarrollo-Web-Backend-TAW-251.git