public class Tarefa {

    private String descricao;

    public Tarefa (String descricao){
        this.descricao = descricao;
    }

    public void verificarDescricao() {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode estar vazia");
        }
    }

    public String toString() {
        return " - " + descricao;
    }
}
