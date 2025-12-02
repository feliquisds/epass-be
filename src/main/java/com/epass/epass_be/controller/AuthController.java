package com.epass.epass_be.controller;

import com.epass.epass_be.model.Usuario;
import com.epass.epass_be.service.UsuarioService;
import com.epass.epass_be.security.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            // autentica o usuário
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
            );

            Usuario usuario = usuarioService.findByEmail(request.getEmail());
            
            String token = jwtUtil.generateToken(usuario.getEmail());
            // String token = jwtUtil.generateToken(usuario.getTipo().name(), usuario.getResponsavel().getId());

            return ResponseEntity.ok(new LoginResponse(
                usuario.getTipo().name(),
                usuario.getResponsavel().getId(),
                token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
    }

    // @PostMapping("/checkToken")
    // public boolean checkToken(@RequestHeader("Authorization") String token,
    //                                     @RequestParam String tipoUsuario, @RequestParam Long id) {
    //     boolean isValid = jwtUtil.isTokenValid(token.replace("Bearer ", ""), tipoUsuario, id);
    //     return isValid;
    // }

    @Data
    static class LoginRequest {
        private String email;
        private String senha;
    }

    @Data
    @AllArgsConstructor
    static class LoginResponse {
        private String tipoUsuario;
        private Long id;
        private String token;
    }
}