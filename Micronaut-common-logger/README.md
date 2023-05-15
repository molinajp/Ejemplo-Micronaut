# Módulo de logging común para proyectos en Micronaut

## Objetivo

Crear un módulo que pueda utilizarse como responsable de loguear Requests y Responses 
de la aplicación  

---

## Filters

Para lograr esto se utilizó las anotaciones @Filter, y se implementaron las interfaces
HttpServerFilter y HttpClientFilter. 

#### HttpServerFilter

Está encargada de loguear requests y responses que pasen por los **controladores** del server.

#### HttpClientFilter

Está encargada de loguear requests y responses que pasen por los **clientes Rest** de la aplicación.

#### Observaciones

Los @Filter se manejan con programación reactiva, por lo que el orden de ejecución no es el orden
en el que se loguea (al menos en una comunicación sincrónica). El body de un request que entra al
server no está disponible hasta que el controlador lo necesita. Por esta razón, cuando se llame a 
un servicio rest de terceros, en una comunicación sincrónica, el orden de logs sería el siguiente:

- Request del Cliente Rest
- Response del Cliente Rest
- Request del server
- Response del server

Se deja la [documentación oficial](https://docs.micronaut.io/latest/guide/) de Micronaut. Se puede buscar 
la palabra filter para ir a lo que concierne de los filtros.
