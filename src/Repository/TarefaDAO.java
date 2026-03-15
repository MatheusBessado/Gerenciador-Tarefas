package   Repository;


import model.StatusTarefa;
import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO  implements TarefaRepository{
    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1; // controla o ID manualmente



    @Override
      public void salvar(Tarefa tarefa) {
     tarefa.setId(proximoId++); // atribui o ID e incrementa para o próximo
       tarefas.add(tarefa);
      System.out.println("Tarefa salva com sucesso: " + tarefa);
    }

    @Override
    public List<Tarefa> BuscarTarefas() {
        System.out.println("Buscando tarefas...");
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
        return tarefas;
    }

    @Override
    public Tarefa BuscarTarefaPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }

        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
        return null;
    }

    @Override
    public void atualizar(Tarefa tarefa) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == tarefa.getId()) {
                tarefas.set(i, tarefa);
                System.out.println("Tarefa atualizada com sucesso: " + tarefa);
                return;
            }
        }

    }

    @Override
    public void deletar(int id) {
        for (int i = 0; i < tarefas.size(); i++) {
            if (tarefas.get(i).getId() == id) {
                tarefas.remove(i);
                System.out.println("Tarefa deletada com sucesso.");
                return;
            }
        }

    }
    public void TarefaStatus(Tarefa tarefa) {
        if (tarefa != null && tarefa.getStatus() == StatusTarefa.Concluida) {
            System.out.println("Tarefa concluída: " + tarefa);
        } else {
            System.out.println("Tarefa não concluída ou não encontrada.");
        }
    }

}
