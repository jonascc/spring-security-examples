package com.jonas.spring_security_examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    //Here we are overriding the default UserDetailsService
//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("john")
//                .password("12345")
//                .authorities("read")//the authority is an action allowed for that user; we can use any string for this.
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //Here we are customizing the handling of authentication and authorization
    @Bean
    SecurityFilterChain configure(HttpSecurity http) {
        //This is the same as the default configuration
//        http.httpBasic(Customizer.withDefaults());
//        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());
//        return http.build();

        //With this code, none of the requests need to be authenticated
//        http.httpBasic(Customizer.withDefaults());//Help configure the authentication approach: HTTP Basic
//        http.authorizeHttpRequests(c -> c.anyRequest().permitAll());//Configure the authorization rules at the endpoint level
//        return http.build();

        //We can also directly use the SecurityFilterChain bean to set both the UserDetailsService and the PasswordEncoder. This way we don't need the bean userDetailsService
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        UserDetails user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager(user);
        http.userDetailsService(userDetailsService);
        return http.build();
    }

}
