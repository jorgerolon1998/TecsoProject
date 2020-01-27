# Examen

El proyecto consiste en una pequeña aplicación de tipo ABM sin terminar acerca de Sucursales de una organización.

## Set-Up

Se requiere tener instalado Maven, una jdk de Java 8 y tenerla referenciada en la variable de sistema %JAVA_HOME% para que maven pueda usarla.
Se debe ejecutar lo siguiente por cmd,  en el directorio donde se encuentre el proyecto descargado.

```
mvn compile
```

Para facilitar la instalación,  el proyecto tiene base de springboot e incluye lo siguiente

* Servidor de aplicaciones embebido: undertow
* Base de datos embebida: H2
 
Para probarlo,  correrlo normalmente con el IDE o ejecutar lo siguiente por cmd

```
mvn spring-boot::run
```

Luego dirigirse al sitio http://localhost:8080 para verificar que la aplicación se encuentra funcionando.


Nota: Revisar dicho puerto (8080).

Los servicios publicados son:

http://localhost:8080/api/sucursales

http://localhost:8080/api/findSucursales

Delete
http://localhost:8080/api/sucursales/{id}

Post (Add  con un objeto de sucursal)
http://localhost:8080/api/sucursales{Sucursal}

PUT (update de objeto sucursal )
http://localhost:8080//api/sucursales/{Sucursal}


frameworks

* [Maven](https://maven.apache.org/) - Gestor de dependencias y de ciclo de vida de proyecto
* [Spring 5](https://spring.io/) - DI container
* [SpringMvc](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) - Backend Web Stack de Spring
* [SpringBoot](https://spring.io/) - Base de aplicaciones de diferente tipo
* [H2](http://www.h2database.com/html/quickstart.html) - Base de datos embebida de Java
* [JPA](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html) - Java Persistence API
* [Hibernate 5](http://hibernate.org/orm/documentation/5.2/) - ORM
* [Thymeleaf](https://www.thymeleaf.org/documentation.html) - Template engine
* [Webjars](https://www.webjars.org/) - libs de javascript inyectadas por Maven
* [JQuery](http://api.jquery.com/) - lib frontend de propósito general
* [Bootstrap](https://getbootstrap.com/docs/3.3/getting-started/) - framework frontend para desarrollo estilizado y responsive de aplicaciones Web.
* [Bootstrap Table](http://bootstrap-table.wenzhixin.net.cn/documentation/) - grillas de bootstrap
* [Bootbox](http://bootboxjs.com/documentation.html) - dialogs

