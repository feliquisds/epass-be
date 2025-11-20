package com.epass.epass_be.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // ---------------------------------------------------------
    // CHAIN 1: Configuração para API (React / Postman)
    // ---------------------------------------------------------
    @Bean
    @Order(1) // Esta configuração tem prioridade e será verificada primeiro
    public SecurityFilterChain apiFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtFilter) throws Exception {
        http
            // Define que este filtro só se aplica a URLs que começam com /auth/
            // Se você tiver outras rotas de API (ex: /api/**), adicione aqui.
            .securityMatcher("/auth/**") 
            
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login", "/auth/login/").permitAll()
                .anyRequest().authenticated()
            )
            // Adiciona o filtro JWT apenas para estas rotas
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // ---------------------------------------------------------
    // CHAIN 2: Configuração para Web Tradicional (Navegador)
    // ---------------------------------------------------------
    @Bean
    @Order(2) // Se não caiu na regra acima, cai nesta aqui
    public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
        http
            // Não precisa de securityMatcher, ele pega "o resto"
            .csrf(csrf -> csrf.disable()) // Pode habilitar se quiser proteção em formulários web
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/login").permitAll()
                .anyRequest().authenticated()
            )
            // Configuração do Login por Formulário (Session/Cookie)
            .formLogin(form -> form
                .loginPage("/login") // Sua página HTML customizada
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            );

        return http.build();
    }
}