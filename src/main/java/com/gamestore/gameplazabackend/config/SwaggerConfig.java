package com.gamestore.gameplazabackend.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Piyush Kumar",
                        email = "piyushkumarcse44@gmail.com",
                        url = "http://edge-pro-frontend-dev.s3-website.ap-south-1.amazonaws.com/login"
                ),
                description = "This API exposes endpoints to manage GamePlaza.",
                title = "GamePlaza API",
                version = "3.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
//                @Server(
//                        description = "DEVELOPMENT ENV",
//                        url = "http://15.207.221.112:8082"
//                ),
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8082"
                )
//                @Server(
//                        description = "PROD ENV",
//                        url = "http://52.66.118.93:8092"
//                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {


}

