# e-commerce-api

Aplicación cuya funcionalidad principal sea una API que ejecute un scraper hacia una tienda de e-commerce (Amazon, Liverpool, Linio, nike.com, etc.) y obtenga información básica de los productos (nombre, descripción, precio).

- [x] La aplicación debe persistir la información en una DB.
- [x] Deberá incluir dos endpoints:
- [x] Ejecutar el scraper (ejemplo: GET/sources/) y descargar 10 productos del catálogo.
- [x] Devolver la información guardada en un JSON (ejemplo: GET/products/).
- [x] Multiple store scrapping (2 o 3 tiendas).
- [x] Elegir la tienda en los parámetros del body de /sources/
- [x] Pasar un parámetro al body de /sources/ para elegir el número de productos a descargar (considera la paginación del sitio).
- [x] Evaluar si el producto encontrado se encuentra en la DB y no reescribirlo.
- [ ] Vista de los productos guardados en la DB.
- [x] Seguridad (Cualquier tipo de auth).

Para correr el proyecto, primero hay que compilar y despues ejecutar el jar, esto se puede hacer en una sola linea de comandos:
```bash
./gradlew clean build && java -jar build/libs/e-commerce-api-0.0.1-SNAPSHOT.jar
```
Por defecto, correra con una base de datos embebida H2.

Si quieres correr el proyecto conectado a MySQL, deberas usar el perfil 'local'. Asegurate de tener la base de datos y credenciales correctas https://github.com/juanpabloprado/e-commerce-api/wiki/Create-a-MySQL-Database-and-User
```bash
java -jar -Dspring.profiles.active=local build/libs/e-commerce-api-0.0.1-SNAPSHOT.jar
```
Espere a que el servidor comienze, una vez iniciada la aplicación. Abre el navagador y visita: http://localhost:8080/api/v1/sources para obtener los datos, luego comienza a explorar la API en http://localhost:8080/api/v1

Puedes acceder a los endpoints de usuario con las siguientes credenciales:

- user: user
- password : password

Y alos endpoints administrativos:

- user: admin
- password: password
