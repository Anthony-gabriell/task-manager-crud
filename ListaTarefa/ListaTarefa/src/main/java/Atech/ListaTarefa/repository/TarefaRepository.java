package Atech.ListaTarefa.repository;

// Abaixo eu tengo os Imports as anotações do banco de dados
import Atech.ListaTarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interface é responsável pelo acesso aos dados
public interface TarefaRepository extends JpaRepository <Tarefa, Long> {
}
// JpaRepository<Tarefa, Long> significa:
// "Vou gerenciar a entidade Tarefa e a chave primária (ID) dela é do tipo Long"
// Não precisamos escrever metodos, ne referencias aqui, eles já nascem ao extender a interface.
