package com.emdev.wallet.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User API", version = "1.0", contact = @Contact(name = "EmDev", email = "ezequielmassa.dev@gmail.com", url = "https://www.baeldung.com"), license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"), termsOfService = "", description = "api testing swagger"), servers = @Server(url = "http://localhost:8080", description = "Development"))
public class OpenAPISecurityConfiguration {

}