package br.com.digitalhouse.Clinica.odontologica.app.api.openapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
    @Configuration
    public class SwaggerConfig {
        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Clinica Odontologica - RestFull API")
                            .description("API desenvolvida para Checkpoint de back-end da Digital House")
                            .version("1.0")
                            .termsOfService("Termo de uso: Open Source")
                            .license(new License()
                                    .name("Apache 2.0")
                                    .url("https://github.com/Brunosouzad/ClinicaOndotologica")
                            )
                    ).externalDocs(
                            new ExternalDocumentation()
                                    .description("Bruno Souza")
                                    .url("https://github.com/Brunosouzad/ClinicaOndotologica"));
        }

    }
