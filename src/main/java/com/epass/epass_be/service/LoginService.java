// package com.epass.epass_be.service;

// import com.epass.epass_be.model.Usuario;
// import com.epass.epass_be.repository.UsuarioRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class LoginService implements UserDetailsService {

//     @Autowired
//     private UsuarioRepository usuarioRepository;

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         Usuario usuario = usuarioRepository.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

//         return User.builder()
//                 .username(usuario.getEmail())
//                 .password(usuario.getSenha()) // senha já criptografada com BCrypt
//                 .roles("USER") // pode ajustar conforme sua regra
//                 .build();
//     }
// }