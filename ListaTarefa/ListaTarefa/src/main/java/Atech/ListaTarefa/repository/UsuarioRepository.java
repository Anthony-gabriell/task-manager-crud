package Atech.ListaTarefa.repository;

// Abaixo eu tengo os Imports as anotações do banco de dados
import Atech.ListaTarefa.model.Tarefa;
import Atech.ListaTarefa.model.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica que esta interface é responsável pelo acesso aos dados
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
}
