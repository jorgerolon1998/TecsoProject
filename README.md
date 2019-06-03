# Proyecto Entrevista

El proyecto consiste en una pequeña aplicación de tipo ABM sin terminar acerca de Empleados de una organización.

## Set-Up

Se requiere tener instalado una jdk de Java 8 y tenerla referenciada en la variable de sistema %JAVA_HOME% para que maven pueda usarla.
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

*IMPORTANTE* 
Los cambios se deben subir a un repositorio remoto creados por el evaluado, manteniendo la historia de versionado original previa del repositorio remoto de origen.

```
$ git remote add mi-propio-repo <url-a-repo-propio>
```

## Objetivo del ejercicio

Se desea poner a prueba los conocimientos backend y frontend del desarrollador para poder implementar los siguientes requerimientos:

* Corregir problema de paginación. Se encuentran precargados más usuarios de los que se muestran en la primer página. Al pasar a la siguiente,  se siguen visualizando los mismos
* Agregar eliminación de usuarios
* Agregar visualización y edición de campos edad, tipo de documento y n° de documento
* (OPCIONAL) Escribir sobre el archivo ./NotasEvaluado.txt alguna propuesta de mejora sobre la evaluación.

Una vez satisfechos los requerimientos,  realizar lo siguiente:

    1) subir los cambios al repositorio privado propio
    2) dar permisos de visualización al evaluador y avisarle que los cambios estan listos
    3) esperar una respuesta del evaluador


## Notas

* Se puede consultar al evaluador sobre cualquier aspecto del ejercicio en cualquier momento ( Incluso sobre los framework utilizados )
* Se pueden escribir sobre el archivo .*NotasEvaluado.txt en caso de querer aclarar algo de la resolución


## Documentación de frameworks

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

