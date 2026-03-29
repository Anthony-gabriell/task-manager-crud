import java.util.ArrayList;

public class Tarefa {

    private int id;
    private String descricao;

    public Tarefa (int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String toString() {
        return id + " - " + descricao;
    }
}
