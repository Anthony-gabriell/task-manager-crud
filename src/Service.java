import java.util.ArrayList;

public class Service {

    private ArrayList<Tarefa> listaTarefas;

    public Service() {
        this.listaTarefas = new ArrayList<>();
    }

    private void validarDescricacao(Tarefa descricaoTarefa) {
        if (descricaoTarefa == null) {
            throw new IllegalArgumentException("O campo tarefa não pode estar vazio");
        }
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
            System.out.println(i + "" + listaTarefas.get(i));
        }
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return new ArrayList<Tarefa>(listaTarefas);
    }
}

