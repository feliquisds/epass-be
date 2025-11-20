package com.epass.epass_be.security;

import com.epass.epass_be.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsuarioDetails implements UserDetails {

    private final Usuario usuario;

    public UsuarioDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    // Aqui você retorna o tipo como uma ROLE
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Exemplo: ROLE_PROFESSOR ou ROLE_RESPONSAVEL
        String role = "ROLE_" + usuario.getTipo().name();
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // por enquanto
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // por enquanto
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // por enquanto
    }

    @Override
    public boolean isEnabled() {
        return true; // por enquanto
    }
}