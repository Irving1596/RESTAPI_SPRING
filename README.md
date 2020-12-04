# RESTAPI_SPRING
RESTful API con Spring Boot y MySQL
# Documentación
## Tecnologias Utilizadas
`App tier: Spring Boot 2.3` 

`Data tier: Mysql 8.0` 

`Conexión a la base de datos: JPA `

## IDE utilizado

`Eclipse`

 ## Pasos para la instalación. 
 
Tener instalado Java, MySQL, y Apache Maven. 

Clonar el repositorio. Ejecutar `git clone https://github.com/Irving1596/RESTAPI_SPRING.git`   

Situarse en el directorio `RESTAPI_SPRING`   

Ejecutar  `mvn spring-boot:run` ya con este comando se estaria levantando el aplicativo. 

## EndPoints 

1- Lista de usuarios
- `GET http://localhost:8080/api/v1/users`

2- Obtener un usuario por medio de su ID.
- `GET http://localhost:8080/api/v1/users/{id}`

3- Crear un nuevo usuario
- `POST http://localhost:8080/api/v1/users`

   `BODY:`    
    {"nombre":"Merlin",  
    "apellido":"Kioshiro",  
    "sexo":"M",  
    "edad":"19",  
    "correo":"merlin.kioshiro@outlook.com"
    }
    
4- Modificar un usuario
- `PUT http://localhost:8080/api/v1/users/{id}`

   `BODY:`    
    {"nombre":"Merlin",  
    "apellido":"Koan",  
    "sexo":"M",  
    "edad":"19",  
    "correo":"merlin.koan@gmail.com"
    }

5- Eliminar un usuario
- `DEL http://localhost:8080/api/v1/users/{id}`

Data de endpoint y ejemplos en POSTMAN.   
https://www.getpostman.com/collections/e627d60e864d7b7c57d0

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/e627d60e864d7b7c57d0)


