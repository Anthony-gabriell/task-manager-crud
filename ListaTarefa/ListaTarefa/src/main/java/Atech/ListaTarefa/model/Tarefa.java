package Atech.ListaTarefa.model;

// Abaixo os Imports as anotações do banco de dados
import jakarta.persistence.*;

@Entity // Define que esta classe será uma tabela no banco de dados
public class Tarefa {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID automaticament
    private Long id;

    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL) // Indica relacionamento: Muitas tarefas para um usuário e ALL' diz: se o usuário for novo, salve-o antes da tarefa
    @JoinColumn(name = "usuario_id") // Nome da coluna estrangeira no banco
    private Usuario usuario;

    // Abaixo a lista geral de construtores
    // Construtor vazio essencial para o JPA
    public Tarefa(){
    }

    public Tarefa (String descricao, Usuario usuario){
        this.descricao = descricao;
        this.usuario = usuario;
    }

    // Abaixo a lista de metodos
    public void verificarDescricao() {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode estar vazia");
        }
    }
    @Override
    public String toString() {
        return " - " + descricao;
    }

    // Abaixo a lista de Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
