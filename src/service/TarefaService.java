package service;

// Camada de serviço que contém a lógica de negócio para gerenciar tarefas.
// Esta classe valida entradas, aplica regras de negócio e coordena com o repositório para operações de dados.
// É a ponte entre a interface do usuário e o acesso a dados.

import Repository.TarefaRepository;
import model.StatusTarefa;
import model.Tarefa;

import java.util.List;

public class TarefaService {
    // Repositório injetado para acessar operações de dados.
    private TarefaRepository repository;

    // Construtor que recebe o repositório (injeção de dependência).
    public TarefaService(TarefaRepository repository) {
        this.repository = repository; ;
    }

    // Método para criar uma nova tarefa.
    // Valida se o título é obrigatório e salva a tarefa no repositório.
    public void criarTarefa(String titulo, String descricao) {
        if (titulo == null || titulo.isBlank()){
            System.out.println("O titulo e obrigatorio ");
               return;
        }
        repository.salvar(new Tarefa(titulo,descricao));
        System.out.println("Tarefa criada com sucesso");
    }

    // Método para buscar todas as tarefas.
    // Retorna a lista obtida do repositório.
     public List<Tarefa> buscarTarefas() {
        return repository.BuscarTarefas();
     }

    // Método para buscar uma tarefa pelo ID.
    // Valida o ID e retorna a tarefa se encontrada, ou null.
     public  Tarefa buscarTarefaPorId(int id) {
        if (id <= 0) {
            System.out.println("Id invalido");
            return null;
        }Tarefa tarefa = repository.BuscarTarefaPorId(id);
        if (tarefa == null) {
            System.out.println("Nenhuma tarefa encontrada com esse id");

        }
        return tarefa;

     }

    // Método para atualizar uma tarefa existente.
    // Busca a tarefa pelo ID, atualiza os campos e salva as mudanças.
      public void atualizarTarefa(int id, String titulo, String descricao) {
        Tarefa tarefa = repository.BuscarTarefaPorId(id);
        if (tarefa == null) {
            System.out.println("Nenhuma tarefa encontrada para atualizar");
            return;
        }
        tarefa.setDescricao(descricao);
        tarefa.setTitulo(titulo);
        repository.atualizar(tarefa);
        System.out.println("Tarefa atualizada com sucesso");
      }

    // Método para deletar uma tarefa pelo ID.
    // Verifica se a tarefa existe antes de deletar.
     public void deletarTarefa(int id) {
        Tarefa tarefa = repository.BuscarTarefaPorId(id);
         if (tarefa == null) {
            System.out.println("Nenhuma tarefa encontrada para deletar");
            return;
         }repository.deletar(id);
          System.out.println("Tarefa deletada com sucesso");

    }

    // Método para marcar uma tarefa como concluída.
    // Verifica se a tarefa existe e não está já concluída.
       public void concluirTarefa(int id) {
        Tarefa tarefa = repository.BuscarTarefaPorId(id);
        if (tarefa == null) {
            System.out.println("Nenhuma tarefa encontrada para concluir");
            return;
        }else if (tarefa.getStatus() == StatusTarefa.Concluida) {
            System.out.println("Tarefa ja esta concluida");
            return;
        }

        tarefa.setStatus(StatusTarefa.Concluida);
        repository.atualizar(tarefa);
        System.out.println("Tarefa concluida com sucesso");
    }
}
