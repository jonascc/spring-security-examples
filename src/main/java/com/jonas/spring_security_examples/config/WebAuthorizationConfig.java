package com.jonas.spring_security_examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//Here, the config class needs to define a bean of type SecurityFilterChain to configure the authentication and authorization rules
@Configuration
public class WebAuthorizationConfig {

//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.httpBasic(Customizer.withDefaults());
//        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
//        return http.build();
//    }

}
