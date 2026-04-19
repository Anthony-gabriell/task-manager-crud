package Atech.ListaTarefa.service;

// Abaixo temos os Imports as anotacoes do banco de dados
import Atech.ListaTarefa.model.Tarefa;
import Atech.ListaTarefa.model.Usuario;
import Atech.ListaTarefa.repository.TarefaRepository;
import Atech.ListaTarefa.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Registra esta classe como um componente de serviço do Spring
public class TarefaService {

    // O 'final' garante que a dependencia não mude após ser injetada
    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;


    // Injeção de dependencia via construtor (melhor prática que o @Autowired pra escalabilidade)
    public TarefaService(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo para salvar uma nova tarefa
    public Tarefa adicionarTarefa(Tarefa tarefa) {
        Long idUsuario = tarefa.getUsuario().getId(); // pega o ID do usuário que veio no JSON.

        Usuario usuario = usuarioRepository.findById(idUsuario) // busca o usuário no banco. Retorna um Optional um objeto que pode ou não ter valor.
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado")); // se não encontrou, lança exceção. Se encontrou, retorna o usuário.

        tarefa.setUsuario(usuario); // substitui o usuário parcial que veio do JSON pelo usuário completo que veio do banco.
        validarDescricacao(tarefa);
       return tarefaRepository.save(tarefa); //salva com o vínculo correto.
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


