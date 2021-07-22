package ch.priv.ah.springbootcode.architecture.otherServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @class: CorsConfiguration
 * @author: Anes Hodza
 * @version: 15.07.2021
 **/

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/people")
                        .allowedMethods("GET", "POST", "PUT")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/people/{id}")
                        .allowedMethods("POST")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/people/{id}/my-groups")
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");

                registry.addMapping("/items")
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/items/{id}")
                        .allowedMethods("DELETE", "PUT")
                        .allowedOrigins("http://localhost:3000");

                registry.addMapping("/groups")
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");
                registry.addMapping("/groups/{groupUrl}")
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }
}