package com.sri.job_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Job Service API",
                version = "1.0",
                description = "Job Management Microservice"
        )
)
public class OpenApiConfig {
}
