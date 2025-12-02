package com.epass.epass_be.repository;

import com.epass.epass_be.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByTipoAndResponsavelId(String tipoUsuario, Long id);
}