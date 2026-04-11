import java.util.ArrayList;

public class Usuario {
    private String nome;

    private void validarNome(String nomeUser) {
        if (nomeUser == null || nomeUser.isBlank()) {
            throw new IllegalArgumentException("O campo usuario não pode estar vazio");
        }
    }
    public Usuario(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
