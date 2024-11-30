package br.com.g4f.cartoes_ms.settings.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de analise de crédito",
                version = "1.0.0"
        )
)
public class OpenApiConfig {
}
