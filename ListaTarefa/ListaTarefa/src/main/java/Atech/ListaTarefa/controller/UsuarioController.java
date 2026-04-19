package Atech.ListaTarefa.controller;


import Atech.ListaTarefa.model.Usuario;
import Atech.ListaTarefa.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public void adicionarUsuario (@RequestBody Usuario usuario) {
        usuarioService.adicionarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario(){
        return usuarioService.listarUsuario();
    }
}
