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
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");

                registry.addMapping("/items")
                        .allowedMethods("GET")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }
}