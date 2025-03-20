package com.emazon.api_users.aplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.services.UserServiceImpl;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class BeansConfig {
    @Bean
    public UserServiceImpl getServiceImpl(IUserRepositoryPort repositoryPort){
        return new UserServiceImpl(repositoryPort);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Microservice Users")
                        .version("1.0.0")
                        .description("In this microservice you can link and register users, as well as create a user with the role of warehouse assistant.."));
    }

     
}