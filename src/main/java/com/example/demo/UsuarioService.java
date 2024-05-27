package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    // Método para recuperar todos los usuarios
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
    
    public Usuario obtenerUsuarioPorCorreoYContrasena(String correo, String contrasena) {
        // Utiliza el método findByCorreoAndContrasena del repositorio para buscar el usuario
        return usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
    }
}