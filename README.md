# Gerenciador de Tarefas

Este é um projeto simples de gerenciador de tarefas desenvolvido em Java. Ele permite ao usuário criar, listar, buscar, atualizar, deletar e marcar tarefas como concluídas através de um menu interativo no console.

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas para separar responsabilidades:

- **model/**: Contém as classes de modelo de dados.
  - `StatusTarefa.java`: Enum que define os possíveis status de uma tarefa (Pendente ou Concluida).
  - `Tarefa.java`: Classe que representa uma tarefa, com atributos como ID, título, descrição e status.

- **Repository/**: Camada de acesso a dados.
  - `TarefaRepository.java`: Interface que define as operações de CRUD (Create, Read, Update, Delete) para tarefas.
  - `TarefaDAO.java`: Implementação da interface (atualmente com métodos vazios, simulando stubs para futuras implementações com banco de dados).

- **service/**: Camada de lógica de negócio.
  - `TarefaService.java`: Classe que valida entradas, aplica regras de negócio e coordena com o repositório.

- **ui/**: Interface do usuário.
  - `Main.java`: Classe principal com o menu interativo no console.

## Funcionalidades

- **Criar Tarefa**: Permite criar uma nova tarefa com título e descrição.
- **Listar Tarefas**: Exibe todas as tarefas armazenadas.
- **Buscar Tarefa por ID**: Busca e exibe uma tarefa específica pelo seu ID.
- **Atualizar Tarefa**: Atualiza o título e descrição de uma tarefa existente.
- **Deletar Tarefa**: Remove uma tarefa pelo ID.
- **Concluir Tarefa**: Marca uma tarefa como concluída.
- **Sair**: Encerra o programa.

## Pré-requisitos

- Java JDK 11 ou superior.
- Driver JDBC do SQLite: Baixe o arquivo `sqlite-jdbc.jar` (versão mais recente) de [https://github.com/xerial/sqlite-jdbc/releases](https://github.com/xerial/sqlite-jdbc/releases) e adicione ao classpath do projeto.

### Como Adicionar o Driver no IntelliJ IDEA:
1. Baixe o `sqlite-jdbc.jar`.
2. No IntelliJ, clique com o botão direito no projeto > **Open Module Settings** (F4).
3. Vá para **Libraries** > **+** > **Java** > Selecione o arquivo `sqlite-jdbc.jar`.
4. Aplique e OK.

## Como Executar

1. Certifique-se de ter o Java JDK e o driver SQLite configurados.
2. Abra um terminal na pasta raiz do projeto (`D:\Tarefa`).
3. Compile o projeto:
   ```
   javac -d bin -cp sqlite-jdbc.jar src/model/*.java src/Repository/*.java src/service/*.java src/ui/*.java
   ```
4. Execute o programa:
   ```
   java -cp bin:sqlite-jdbc.jar ui.Main
   ```
   (No Windows, use `;` em vez de `:` para separar caminhos no classpath: `java -cp bin;sqlite-jdbc.jar ui.Main`)

5. Siga as instruções no menu interativo.

O banco de dados `tarefas.db` será criado automaticamente na raiz do projeto se não existir.

## Limitações Atuais

- **Validações**: Há validações básicas, mas podem ser aprimoradas (ex: tratamento de exceções para entradas inválidas).
- **Confirmação de Exclusão**: No método de deletar, há uma mensagem de confirmação, mas ela não é processada (sempre deleta).

## Melhorias Futuras

- Adicionar tratamento de exceções para entradas inválidas (ex: `NumberFormatException`).
- Implementar a confirmação real para deletar tarefas.
- Adicionar mais validações (ex: limite de caracteres para título/descrição).
- Criar uma interface gráfica (GUI) em vez de console.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Paradigma**: Orientação a Objetos
- **Arquitetura**: MVC-like (Model-View-Controller), com separação em camadas (Model, Repository, Service, UI)

## Autor

Projeto desenvolvido como exemplo educacional.</content>
<parameter name="filePath">D:\Tarefa\README.md
