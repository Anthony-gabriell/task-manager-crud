package Atech.ListaTarefa.model;

// Abaixo eu tengo os Imports as anotações do banco de dados
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Define que esta classe será uma tabela no banco de dados
public class Usuario {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID automaticament
    private Long id;

    private String nome;

    // ABAIXO A LISTA DE CONSTRUTORES
    // Construtor vazio, Obrigatório para o JPA/Hibernate funcionar
    public Usuario() {
    }

    public Usuario(String nome) {
        validarNome(nome);
        this.nome = nome;
    }
    // Abaixo lista de metodos de validação
    public void validarNome(String nomeUser) {
        if (nomeUser == null || nomeUser.isBlank()) {
            throw new IllegalArgumentException("O campo usuario não pode estar vazio");
        }
    }
    // Abaixo temos a lista de Getters e Setters
    // Essa é a comunicação essencial entre controller e service acessar os dados

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

