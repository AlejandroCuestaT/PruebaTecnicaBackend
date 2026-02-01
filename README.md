# PruebaTecnicaBackend
 
Prueba Tecnica hecha con Java 17 y Spring Boot.

La aplicacion permite ver, editar y eliminar libros en una biblioteca

Tecnologia usada:

- Java 17
- Spring Boot 4.0.2
- Maven para las dependencias

Instalacion y ejecucion:

- Descargar el proyecto
- Abrir el proyecto en un IDE [ Use SpringToolSuite4 ]
- Ejecutar la clase principal ' BibliotecaApplication.java '
- La API empieza a correr en ' http://localhost:8080/api/books '

A continuacion, dejare una breve guia do todos los endpoints disponibles [ Todos previamente probados en POSTMAN ]:

- GET: /api/books  |  Devuelve la lista completa de los libros [ Hay unos creados por defecto ]

- GET: /api/books/{id}  |  Devuelve un libro especifico por su id

- POST: /api/books  |  Crea un nuevo libro
  BODY[JSON]:
    {
        "title": "Moby Dick",
        "author": "Herman Melville"
    }

- PUT: /api/books/{id}  |  Actualiza un libro ya existente
  BODY[JSON]:
    {
        "title": "Don Quijote (Versión Editada)",
        "author": "Miguel de Cervantes"
    }

- PATCH: /api/books/{id}/read  |  Alterna el estado de lectura [ false --> true | true --> false ]    

- DELETE: /api/books/{id}  |  Elimina un libro ya existente


A parte, el proyecto maneja los siguientes errores:

- 200 OK  |  Todo realizado correctamente

- 201 CREATED  |  El nuevo libro se añade correctamente

- 204 NO CONTENT  |  El libro se ha eliminado correctamente

- 400 BAD REQUEST  |  El JSON enviado no es valido

- 404 NOT FOUND  |  Cuando intentas buscar, editar o eliminar un libro cuya id no existe