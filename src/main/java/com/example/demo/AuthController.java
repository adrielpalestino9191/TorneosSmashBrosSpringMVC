package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Retorna la vista para el formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String correo, @RequestParam String contrasena, HttpSession session) {
        // Verificar las credenciales del usuario
        Usuario usuario = usuarioService.obtenerUsuarioPorCorreoYContrasena(correo, contrasena);
        if (usuario != null) {
            // Autenticación exitosa, guardar usuario en la sesión
            session.setAttribute("usuario", usuario);
            return "redirect:/listaUsuarios"; // Redireccionar a la página de inicio del usuario
        } else {
            // Autenticación fallida, redirigir de vuelta al formulario de inicio de sesión con un mensaje de error
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        // Invalidar la sesión y redirigir al usuario a la página de inicio de sesión
        session.invalidate();
        return "redirect:/login";
    }
}
