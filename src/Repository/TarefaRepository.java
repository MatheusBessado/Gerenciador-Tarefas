package Repository;

import model.Tarefa;

import java.util.List;

public interface TarefaRepository {
    // Salva uma tarefa
    void salvar(Tarefa tarefa);
    // Busca todas as tarefas
    List<Tarefa> BuscarTarefas();
    // Busca uma tarefa pelo ID
    Tarefa BuscarTarefaPorId(int id);
    // Atualiza uma tarefa
    void atualizar(Tarefa tarefa);
    // Deleta uma tarefa pelo ID
    void deletar(int id);

}
