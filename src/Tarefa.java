import java.util.ArrayList;

public class Tarefa {

    private String descricao;

    public Tarefa (String descricao){
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode estar vazia");
        }
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String toString() {
        return " - " + descricao;
    }
}
