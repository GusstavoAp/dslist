package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class WebConfig {

        //pego o valor da variavel que esta configurado no Cors Origins e "jogo" no "corsOrigins"
        @Value("${cors.origins}")
        private String corsOrigins;


        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    //Faço a configuração para permitir o acesso aos enderços que estão na variavel
                    registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
                }
            };
        }

    }
