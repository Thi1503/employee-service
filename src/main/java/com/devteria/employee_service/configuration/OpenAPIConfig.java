package com.devteria.employee_service.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@OpenAPIDefinition(
//        info =
//                @io.swagger.v3.oas.annotations.info.Info(
//                        title = "Organization Service",
//                        version = "v0.0.1",
//                        description = "Organization Service API"),
//        security = {@SecurityRequirement(name = "bearerAuth")})
//@SecurityScheme(
//        name = "bearerAuth", // Tên tham chiếu trong @SecurityRequirement
//        type = SecuritySchemeType.HTTP, // Kiểu HTTP Auth
//        scheme = "bearer", // Dạng Bearer token
//        bearerFormat = "JWT" // Định dạng token JWT
//        )
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Service")
                        .description("Employee Service API")
                        .version("v0.0.1"));
    }
}
