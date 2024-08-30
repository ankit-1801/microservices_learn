package com.microservices.idenity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean 
	UserDetailsService getUserDetailsService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/auth/register", "/auth/login", "/auth/validate").permitAll()  // Allow all requests without authentication
            )
            .csrf(csrf -> csrf.disable());  // Disable CSRF protection if not needed

        return http.build();
    }
    
    @Bean
    PasswordEncoder getPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
