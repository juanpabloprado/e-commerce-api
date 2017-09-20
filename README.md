# e-commerce-api

Aplicación cuya funcionalidad principal sea una API que ejecute un scraper hacia una tienda de e-commerce (Amazon, Liverpool, Linio, nike.com, etc.) y obtenga información básica de los productos (nombre, descripción, precio).

- [ ] La aplicación debe persistir la información en una DB.
- [x] Deberá incluir dos endpoints:
- [x] Ejecutar el scraper (ejemplo: GET/sources/) y descargar 10 productos del catálogo.
- [x] Devolver la información guardada en un JSON (ejemplo: GET/products/).
- [x] Multiple store scrapping (2 o 3 tiendas).
- [x] Elegir la tienda en los parámetros del body de /sources/
- [x] Pasar un parámetro al body de /sources/ para elegir el número de productos a descargar (considera la paginación del sitio).
- [x] Evaluar si el producto encontrado se encuentra en la DB y no reescribirlo.
- [ ] Vista de los productos guardados en la DB.
- [x] Seguridad (Cualquier tipo de auth).
