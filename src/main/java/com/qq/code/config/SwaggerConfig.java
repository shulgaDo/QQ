package com.qq.code.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
       return new OpenAPI()
               .info(new Info()
                       .title("QQ API")
                       .description("Is about QQ ")
                       .version("v1 ovo"));

    }

}
