# Ejemplo de Desarrollo para microservicios

## Objetivo
Proyecto base para el desarrollo de nuevos microservicios en JAVA 17,
utilizando Micronaut y Maven, basado en buenas prácticas, como se describe 
en el documento de Buenas Practicas y Arquitectura de microservicios.

## Alcance
Los features o capacidades del microservicio implementados son los siguientes:

## Manejo de Logs con Common-logger:**
	Modelado de la informacion expuesta en los logs, injectado como dependencia el proyecto common-logger
	con su respectiva configuracion en el archivo en el archivo logback.xml y su activacion desde la clase
	principal del template.
	
## Swagger para exposicion de los endpoints y documentacion de contratos
	Configuración de Swagger en las controller interface. 
	
## Manejo de Excepciones con ErrorHandler
	Cacheo de errores a traves de la implementación de la interfaz ErrorResponseProcessor. Esta clase se encuentra
    ubicada en el paquete error handler y el modelado de los errores, según su tipo, dentro del paquete exception.
		
## Cliente HTTP para llamadas REST
	Llama a servicio REST mediante la implementación de HTTP Micronaut Client dentro del paquete client.
	
## Conexion a una base de datos embebida utilizando Java Persistence API (JPA)
	La app se conecta a la base de datos H2. No se ha encontrado una forma de insertar los datos a través de sql.
    Se podría lograr el mismo resultado si se hace desde el código al levantar la app.

## Modelado de datos de transferencia utilzando DTO
	Ejemplo en el paquete dto.user y dto.category.
		
## Validacion de campos
	Ejemplos de tipo de validacion dentro de los dto (CategoryDTO y UserDTO).
		
## Implementacion de checkstyle y formatter para automatizar el proceso de comprobación de código
	Configuración de checkstyle dentro del archivo checkstyle.xml conforme a lo sugerido en la documentacion
	de desarrollo.
	
## Inspeccion de codigo con SonarQube
	Inspeccion de codigo con sonarQube conforme a lo sugerido en la documentación de desarrollo.


## Correr el proyecto

1) Ejecutando el método `main` ubicado en `com.example`

2) Utilizando el comando Java  `java -jar Template-0.1.jar` dentro de la carpeta 'target' ubicada en la carpeta base del proyecto

3) Utilizando el comando Java  `mvn mn:run` en la carpeta base del proyecto

Se deja la [documentación oficial](https://docs.micronaut.io/latest/guide/) de Micronaut. Se puede buscar
la palabra que se necesite en el momento para ir al tema del que se desee entender.