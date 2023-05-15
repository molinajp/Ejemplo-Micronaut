package com.example;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.h2.tools.Server;

import java.sql.SQLException;

@OpenAPIDefinition(info = @Info(title = "Template", version = "0.0"))
public class Application {

    public static void main(String[] args) throws SQLException {
        //Esta línea habilita consola de H2 en localhost:8082
        //También se cambia en el pom la dependencia de H2 de scope runtime a compile
        //para más info: https://github.com/micronaut-projects/micronaut-core/issues/1004
        Server.createWebServer().start();
        Micronaut.run(Application.class, args);
    }
}