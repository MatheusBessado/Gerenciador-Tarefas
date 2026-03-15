# 📋 Task Manager CLI

Sistema de gerenciamento de tarefas via terminal desenvolvido em Java.

---

## 🚀 Funcionalidades

- ✅ Criar tarefa com título e descrição
- ✅ Listar todas as tarefas
- ✅ Buscar tarefa por ID
- ✅ Atualizar título e descrição de uma tarefa
- ✅ Concluir tarefa
- ✅ Deletar tarefa

---

## 🏗️ Arquitetura
```
ui (Main) → service (TarefaService) → repository (TarefaDAO) → model (Tarefa)
```

| Camada | Responsabilidade |
|---|---|
| `model` | Classes de dados |
| `repository` | Acesso aos dados |
| `service` | Regras de negócio |
| `ui` | Interface com o usuário |

---

## 🖥️ Como executar

1. Clone o repositório
2. Abra na sua IDE
3. Execute a classe `ui.Main`

---

## 🧱 Conceitos aplicados

- Orientação a Objetos (OOP)
- Interface como contrato
- Injeção de dependência
- Enum para status
- ArrayList para armazenar dados
- Padrão DAO

---

## 🔮 Próximas melhorias

- [ ] Banco de dados com SQLite e JDBC
- [ ] Interface gráfica com JavaFX
- [ ] API REST com Spring Boot

---

## 👨‍💻 Autor

**Matheus** — projeto desenvolvido como parte do aprendizado de Java.
