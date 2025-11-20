package com.epass.epass_be.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.epass.epass_be.model.Usuario;
import com.epass.epass_be.repository.UsuarioRepository;

@Controller
public class HomeController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/home")
    public String home(Model model, Principal principal) {

        // Pega o email do usuário logado
        String email = principal.getName();

        // Busca o usuário
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Nome genérico
        String nome = usuario.getEmail();

        // Se for responsável
        if (usuario.getResponsavel() != null) {
            nome = usuario.getResponsavel().getNome();
        }

        // Se for professor
        if (usuario.getProfessor() != null) {
            nome = usuario.getProfessor().getNome();
        }

        model.addAttribute("nome", nome);

        return "home";  // Vai renderizar home.html
    }
}