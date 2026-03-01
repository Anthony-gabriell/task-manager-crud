import java.util.Scanner;

public class Tarefas {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("BEM VINDO A SUA LISTA DE TAREFAS");

        System.out.println("Digite seu nome:");
        String usuario = teclado.nextLine();
        Usuario u1 = new Usuario(usuario);
        String tarefa;
        String novaTarefa;
        int opcao = 0;

        while (opcao !=4) {

            System.out.println("As opções disponiveis são:");
            System.out.println("1 - Adicionar tarefas.");
            System.out.println("2 - Remover tarefas.");
            System.out.println("3 - Visualizar tarefas");
            System.out.println("4 - Encerrar");
            System.out.println("Selecione a opção desejada:");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    do {
                        System.out.println("Digite o nome da tarefa:");
                        tarefa = teclado.nextLine();
                        u1.adicionarTarefa(tarefa);

                        System.out.println("Deseja adicionar nova tarefa, digite S (sim) ou N (não)");
                        novaTarefa = teclado.nextLine();

                        while (!novaTarefa.equalsIgnoreCase("S") && (!novaTarefa.equalsIgnoreCase("N"))) {
                            System.out.println("Comando invalido, digite S ou N:");
                            novaTarefa = teclado.nextLine();
                        }
                    }
                    while (novaTarefa.equalsIgnoreCase("S"));
                    break;

                case 2:
                    if (u1.getListaTarefas().isEmpty()) {
                        System.out.println("Lista vazia, por favor adicione uma tarefa.");
                        break;
                    }
                    System.out.println("Suas tarefas são:");
                    u1.listarTarefas();
                    System.out.println("Selecione a tarefa que deseja remover:");
                    int rmTarefa = teclado.nextInt();

                    if (rmTarefa < 0 || rmTarefa >= u1.getListaTarefas().size()) {
                        System.out.println("Opção invalida!");
                        break;
                    }
                        System.out.println("Item excluido com sucesso!");
                        u1.removerTarefa(rmTarefa);
                        break;

                case 3:
                    if (u1.getListaTarefas().isEmpty()) {
                        System.out.println("Lista vazia, por favor adicione uma tarefa.");
                        break;
                    }
                    System.out.println("Suas tarefas são:");
                    u1.listarTarefas();
                    break;

                case 4:
                    break;
                    }
            }
        }
    }








































































