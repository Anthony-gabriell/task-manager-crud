package Atech.ListaTarefa.service;

import Atech.ListaTarefa.model.Usuario;
import Atech.ListaTarefa.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void adicionarUsuario (Usuario usuario) {
        validarUsuario(usuario);
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario() {
        List <Usuario> todosOsUsuarios =  usuarioRepository.findAll();

        for (Usuario usuario : todosOsUsuarios) {
            System.out.println(usuario.getId() + " - " + usuario.getNome());
        }
        return todosOsUsuarios;
    }

    private void validarUsuario (Usuario descricaoUsuario) {
        try {
            descricaoUsuario.validarNome(descricaoUsuario.getNome());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
