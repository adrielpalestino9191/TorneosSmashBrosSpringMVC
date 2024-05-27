package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Métodos adicionales según sea necesario
	
	  // Método para buscar un usuario por correo y contraseña
    Usuario findByCorreoAndContrasena(String correo, String contrasena);
}
