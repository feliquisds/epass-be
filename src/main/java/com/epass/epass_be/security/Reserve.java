// package com.epass.epass_be.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class Reserve {

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/login", "/css/**", "/js/**").permitAll()
//                 .anyRequest().authenticated()
//             )
//             // .csrf(csrf -> csrf.disable())       // desativa CSRF temporariamente
//             // .authorizeHttpRequests(auth -> auth
//             //     .anyRequest().permitAll()       // permite qualquer endpoint
//             // )
//             .formLogin(form -> form
//                 .loginPage("/login") // tela customizada
//                 .defaultSuccessUrl("/home", true) // vai para /home se login OK
//                 .failureUrl("/login?error=true")  // volta para login se erro
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/login?logout=true")
//                 .permitAll())

//             // BASIC AUTH para uso no Postman / API
//             .httpBasic(httpBasic -> {});
                

//         return http.build();
//     }
// }