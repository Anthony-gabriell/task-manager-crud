package Atech.ListaTarefa.service;

// Abaixo temos os Imports as anotacoes do banco de dados
import Atech.ListaTarefa.model.Tarefa;
import Atech.ListaTarefa.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Registra esta classe como um componente de serviço do Spring
public class TarefaService {

    // O 'final' garante que a dependencia não mude após ser injetada
    private final TarefaRepository tarefaRepository;

    // Injeção de dependencia via construtor (melhor prática que o @Autowired pra escalabilidade)
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Metodo para salvar uma nova tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        validarDescricacao(tarefa); // Chama a validação antes de salvar
        tarefaRepository.save(tarefa); // O JPA faz o "INSERT INTO..." para você
    }

    // Metodo para buscar todas as tarefas do banco
    public List<Tarefa> listarTarefas() {
        // O findAll() já vai no banco e traz tudo
        List<Tarefa> todasAsTarefas = tarefaRepository.findAll();

        // Você usa um "for-each" (para cada tarefa dentro da lista...)
        for (Tarefa tarefa : todasAsTarefas) {
            System.out.println(tarefa.getId() + " - " + tarefa.getDescricao());
        }
        return todasAsTarefas;
    }

    // Metodo para remover tarefa por ID
    public void removerTarefa(Long id) {
        // Precisamos verificar se o ID existe no banco de dados
        if (!tarefaRepository.existsById(id)) {
            throw new IllegalArgumentException("Opção invalida!");
        }
        tarefaRepository.deleteById(id); // O JPA faz o "DELETE FROM no banco de dados
    }

    // Logica de validação
    private void validarDescricacao(Tarefa descricaoTarefa) {
        try{
            // Chamamos o metodo de validação que criamos dentro da classe Tarefa
            descricaoTarefa.verificarDescricao();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Logica de validação
    public void verificarListaVazia(TarefaRepository tarefaRepository){
        if (tarefaRepository.count() == 0) {
            throw new IllegalArgumentException("Lista vazia, por favor adicione uma tarefa.");
        }
    }
}


