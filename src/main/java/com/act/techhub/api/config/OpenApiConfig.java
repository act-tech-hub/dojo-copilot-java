package com.act.techhub.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("Product Management API")
                .pathsToMatch("**/api/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                                .title("Product Management API")
                                .version("0.0.1-SNAPSHOT")
                                .description("Demo project for Spring Boot with detailed Swagger documentation.")
                                .contact(new Contact().name("act tech hub").email("techhub@actdigital.com").url(""))
                        // ... other configurations like Contact, License etc.
                );
    }
}
