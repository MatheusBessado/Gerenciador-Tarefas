package model;

// Classe que representa uma tarefa no sistema.
// Uma tarefa tem um ID único, título, descrição e status.
// Esta classe é o modelo de dados principal.
public class Tarefa {
    private int id;  // Identificador único da tarefa
    private String titulo;  // Título da tarefa
    private String descricao;  // Descrição detalhada da tarefa
    private StatusTarefa status;  // Status da tarefa (usando o enum StatusTarefa)

    // Construtor para criar uma nova tarefa com título e descrição.
    // O ID e status são definidos posteriormente.
    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = StatusTarefa.Pendente; // Define o status inicial como Pendente
    }

    public String getDescricao() {
        return descricao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getters e setters para acessar e modificar os campos privados
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    // toString() é um método da classe Object que retorna uma representação em string do objeto.
    // É usado automaticamente quando você imprime o objeto (ex: System.out.println(tarefa)).
    // De forma simples: transforma o objeto em texto legível para humanos.
    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", status=" + status + "]";
    }
}
