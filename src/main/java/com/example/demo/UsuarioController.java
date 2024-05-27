package com.example.demo;

import java.util.List;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    
    @GetMapping("/registro")
    public ModelAndView mostrarFormularioRegistro(HttpSession session) {
    	
    	ModelAndView modelAndView = new ModelAndView();
        // Verificar si el usuario está autenticado
        if (session.getAttribute("usuario") != null) {
            // El usuario está autenticado, mostrar la vista de listaUsuarios
            modelAndView.setViewName("registro");
        } else {
            // El usuario no está autenticado, redirigir al formulario de inicio de sesión
            modelAndView.setViewName("redirect:/login");
        }
        return modelAndView;
        
       
    }
    
    @GetMapping("/registroExitoso")
    public String registroExitoso() {
        return "registroExitoso"; // Esto retornará el nombre de la vista "registro.html"
    }
    
    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
        // Lógica para guardar el usuario en la base de datos
        usuarioService.guardarUsuario(usuario);
        return "redirect:/registroExitoso";
    }
    
    @GetMapping("/listaUsuarios")
    public String mostrarListaUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "listadoUsuarios"; // Esto retornará el nombre de la vista "listaUsuarios.html"
    }
}
