package com.epass.epass_be.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UsuarioDetailsService usuarioDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String email;
        final String token;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        email = jwtUtil.extractEmail(token);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = usuarioDetailsService.loadUserByUsername(email);
            if (jwtUtil.isTokenValid(token, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    // @Override
    // protected void doFilterInternal(HttpServletRequest request,
    //                                 HttpServletResponse response,
    //                                 FilterChain filterChain) throws ServletException, IOException {

    //     final String authHeader = request.getHeader("Authorization");
    //     final String tipoUsuario;
    //     final Long id;
    //     final String token;

    //     if (authHeader == null || !authHeader.startsWith("Bearer ")) {
    //         filterChain.doFilter(request, response);
    //         return;
    //     }

    //     token = authHeader.substring(7);
    //     String account = jwtUtil.extractAccount(token);
    //     String[] parts = account.split(":");

    //     tipoUsuario = parts[0];
    //     id = Long.parseLong(parts[1]);

    //     if (tipoUsuario != null && id != null && SecurityContextHolder.getContext().getAuthentication() == null) {
    //         var userDetails = usuarioDetailsService.loadUser(tipoUsuario, id);
    //         if (jwtUtil.isTokenValid(token, tipoUsuario, id)) {
    //             UsernamePasswordAuthenticationToken authToken =
    //                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    //             authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    //             SecurityContextHolder.getContext().setAuthentication(authToken);
    //         }
    //     }

    //     filterChain.doFilter(request, response);
    // }
}