package ui;

// Classe principal da interface do usuário (UI) para o gerenciador de tarefas.
// Esta classe apresenta um menu interativo no console, permitindo ao usuário criar, listar, buscar, atualizar, deletar e concluir tarefas.
// Utiliza o TarefaService para executar as operações de negócio.

import model.Tarefa;
import service.TarefaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Método para criar uma nova tarefa, solicitando título e descrição ao usuário.
    private static void criaTarefa(TarefaService service, Scanner scanner) {
        System.out.println("Digite o titulo da tarefa:");
        String titulo = scanner.nextLine();
        System.out.println("Digite a descrição da tarefa:");
        String descricao = scanner.nextLine();
        service.criarTarefa(titulo, descricao);
    }

    // Método para listar todas as tarefas armazenadas.
    // Exibe cada tarefa usando seu método toString().
    private static void listarTarefas(TarefaService service) {
        List<Tarefa> tarefas = service.buscarTarefas();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }
        System.out.println("Lista de Tarefas:");
        tarefas.forEach(tarefa -> System.out.println(tarefa));
     }

    // Método para buscar uma tarefa específica pelo ID.
    // Solicita o ID ao usuário e exibe a tarefa se encontrada.
     private static void BuscarTarefaPorId(TarefaService service, Scanner scanner) {
        System.out.println("Digite o id da tarefa:");
        int id = Integer.parseInt(scanner.nextLine());
        Tarefa tarefa = service.buscarTarefaPorId(id);
        if (tarefa != null) {
            System.out.println("Tarefa encontrada: " + tarefa);
        }
     }

    // Método para atualizar uma tarefa existente.
    // Solicita ID, novo título e nova descrição ao usuário.
     private static void atualizarTarefa(TarefaService service, Scanner scanner ) {
    System.out.println("Digite o id da tarefa que deseja atualizar:");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.println("Digite o novo titulo da tarefa:");
    String titulo = scanner.nextLine();
    System.out.print("Nova descricao: "); // avisa antes de ler
         String descricao = scanner.nextLine();
         service.atualizarTarefa(id, titulo, descricao);

     }

    // Método para marcar uma tarefa como concluída.
    // Solicita o ID da tarefa ao usuário.
     private static void concluirTarefa(TarefaService service, Scanner scanner) {
    System.out.println("Digite o id da tarefa que deseja concluir:");
      int id = Integer.parseInt(scanner.nextLine());
      service.concluirTarefa(id);

     }

    // Método para deletar uma tarefa.
    // Solicita o ID e confirma a exclusão (embora a confirmação não seja implementada).
     private static void deletarTarefa(TarefaService service, Scanner scanner) {
    System.out.println("Digite o id da tarefa que deseja deletar:");
       int id = Integer.parseInt(scanner.nextLine());

       service.deletarTarefa(id);
     }

    // Método principal que inicia o programa.
    // Cria o scanner e o serviço, e entra em um loop para exibir o menu até o usuário sair.
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        TarefaService service = new TarefaService(new Repository.TarefaDAO());
        while (true) {
             System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
             System.out.println("Escolha uma opção:");
             System.out.println("1. Criar Tarefa");
             System.out.println("2. Listar Tarefas");
             System.out.println("3. Buscar Tarefa por ID");
             System.out.println("4. Atualizar Tarefa");
             System.out.println("5. Deletar Tarefa");
             System.out.println("6. Concluir Tarefa");
             System.out.println("7. Sair");
             int opcao = Integer.parseInt(scanner.nextLine());
             switch (opcao) {
                 case 1:
                     Main.criaTarefa(service, scanner);
                     break;
                 case 2:
                     listarTarefas(service);
                     break;
                 case 3:
                     BuscarTarefaPorId(service, scanner);
                     break;
                 case 4:
                     atualizarTarefa(service, scanner);
                     break;
                 case 5:
                     deletarTarefa(service, scanner);
                     break;
                 case 6:
                     concluirTarefa(service, scanner);
                     break;
                 case 7:
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                     break;
             }

        }

    }
}
