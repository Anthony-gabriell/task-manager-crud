package Atech.ListaTarefa.controller;

// Abaixo a lista de imports
import Atech.ListaTarefa.model.Tarefa;
import Atech.ListaTarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que esta classe é um controlador API REST
@RequestMapping("/tarefas") // Define a rota base e a comuicação com o mundo: http://localhost:8080/tarefas

public class TarefaController {

    // Injetamos o Service para usar a lógica de negócio, sem usar o Auterride
    private final TarefaService tarefaService;

    // Construtor para injeção de dependência (mais seguro que o @Autowired sozinho)
    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping // POST: Usado para criar uma nova tarefa
    public void adicionarTarefa(@RequestBody Tarefa tarefa){
        // @RequestBody indica que o JSON enviado pelo clinete deve ser convertido em objeto Tarefa
        tarefaService.adicionarTarefa(tarefa);
    }

    @GetMapping// GET: usado para buscar e listar as tarefas
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }

    @DeleteMapping("/{id}") // DELETE: Usado para remover uma tarefa específica pelo ID na URL (se mudar o ID o delete será redirecionado)
    public void removerTarefa(@PathVariable Long id){
        // @PathVariable pega o valor do {id} na URL (ex: /tarefas/5) e passa para o metodo
        tarefaService.removerTarefa(id);
    }


}
