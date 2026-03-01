import javax.naming.CompositeName;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<String> listaTarefas;

    public Usuario(String nome) {
        this.nome = nome;
        this.listaTarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getListaTarefas() {
        return listaTarefas;
    }

    public void adicionarTarefa(String tarefa) {
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
