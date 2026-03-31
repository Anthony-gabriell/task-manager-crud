import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Tarefa> listaTarefas;

    private void validarNome(String nomeUser) {
        if (nomeUser == null || nomeUser.isBlank()) {
            throw new IllegalArgumentException("O campo usuario não pode estar vazio");
        }
    }

    private void validarDescricacao(Tarefa descricaoTarefa){
        if (descricaoTarefa == null){
            throw new IllegalArgumentException("O campo tarefa não pode estar vazio");
        }
    }

    public Usuario(String nome) {
        validarNome(nome);
        this.nome = nome;
        this.listaTarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return new ArrayList<Tarefa>(listaTarefas);
    }

    public void adicionarTarefa(Tarefa tarefa) {
        validarDescricacao(tarefa);
        listaTarefas.add(tarefa);
    }

    public void removerTarefa(int tarefa) {
        listaTarefas.remove(tarefa);
    }

    public void listarTarefas() {
        for (int i = 0; i < listaTarefas.size(); i++) {
            System.out.println(i + " - " + listaTarefas.get(i));
        }
    }
}
