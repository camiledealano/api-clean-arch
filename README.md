# API de Gerenciamento de Tarefas - Clean Architecture

Este projeto implementa uma API RESTful para gerenciamento de tarefas utilizando Clean Architecture com Java 17 e Spring Boot.

## Arquitetura

O projeto segue os princípios da Clean Architecture, organizando o código em camadas bem definidas:

1. **Domain Layer**: Contém as entidades de negócio, interfaces de repositório e serviços. É independente de frameworks externos.
2. **Application Layer**: Contém os DTOs, mappers e casos de uso. Orquestra o fluxo entre a interface e o domínio.
3. **Infrastructure Layer**: Implementações concretas dos repositórios, controllers, entidades JPA e configurações.

## Tecnologias Utilizadas

* **Java 17**: Linguagem de programação
* **Spring Boot 3.2.0**: Framework para construção da aplicação
* **Spring Data JPA**: Para persistência de dados
* **H2 Database**: Banco de dados em memória para desenvolvimento
* **MapStruct**: Para mapeamento entre objetos DTO e entidades
* **Maven**: Ferramenta de automação de build

## Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter o Java Development Kit (JDK) 17 ou superior instalado em sua máquina.

### Configuração

Não é necessária nenhuma configuração adicional para o banco de dados H2 em memória, pois ele é configurado automaticamente pelo Spring Boot.

### Execução

1.  **Clone o repositório:**

    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd API-MVC
    ```

2.  **Compile e execute a aplicação usando Maven:**

    ```bash
    ./mvnw spring-boot:run
    ```

    A aplicação será iniciada na porta 8083.

## Endpoints da API

A API expõe os seguintes endpoints para gerenciamento de tarefas:

### `GET /api/tarefas`

Lista todas as tarefas cadastradas.

**Exemplo de Resposta:**

```json
[
  {
    "id": 1,
    "titulo": "Comprar Leite",
    "descricao": "Ir ao supermercado e comprar leite integral",
    "prioridade": "ALTA",
    "status": "PENDENTE",
    "dataLimite": "2025-08-30"
  },
  {
    "id": 2,
    "titulo": "Pagar Contas",
    "descricao": "Pagar contas de água e luz",
    "prioridade": "MEDIA",
    "status": "CONCLUIDA",
    "dataLimite": "2025-08-25"
  }
]
```

### `GET /api/tarefas/{id}`

Busca uma tarefa específica pelo seu ID, retornando um objeto `TarefaResponse`.

**Parâmetros de Path:**

*   `id` (Long): O ID da tarefa.

**Exemplo de Resposta (Sucesso - 200 OK):**

```json
{
  "id": 1,
  "titulo": "Comprar Leite",
  "descricao": "Ir ao supermercado e comprar leite integral",
  "prioridade": "ALTA",
  "status": "PENDENTE",
  "dataLimite": "2025-08-30"
}
```

**Exemplo de Resposta (Não Encontrado - 404 Not Found):**

```
(Corpo vazio)
```

### `POST /api/tarefas`

Cria uma nova tarefa, aceitando um objeto `TarefaRequest` e retornando um `TarefaResponse`.

**Corpo da Requisição (JSON - TarefaRequest):**

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de Spring Boot e JPA",
  "prioridade": "ALTA",
  "status": "PENDENTE",
  "dataLimite": "2025-09-15"
}
```

**Exemplo de Resposta (Sucesso - 200 OK - TarefaResponse):**

```json
{
  "id": 3,
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar conceitos de Spring Boot e JPA",
  "prioridade": "ALTA",
  "status": "PENDENTE",
  "dataLimite": "2025-09-15"
}
```

### `PUT /api/tarefas/{id}`

Atualiza uma tarefa existente pelo seu ID, aceitando um objeto `TarefaRequest` e retornando um `TarefaResponse`.

**Parâmetros de Path:**

*   `id` (Long): O ID da tarefa a ser atualizada.

**Corpo da Requisição (JSON - TarefaRequest):**

```json
{
  "titulo": "Comprar Leite Desnatado",
  "descricao": "Ir ao supermercado e comprar leite desnatado",
  "prioridade": "MEDIA",
  "status": "CONCLUIDA",
  "dataLimite": "2025-08-30"
}
```

**Exemplo de Resposta (Sucesso - 200 OK - TarefaResponse):**

```json
{
  "id": 1,
  "titulo": "Comprar Leite Desnatado",
  "descricao": "Ir ao supermercado e comprar leite desnatado",
  "prioridade": "MEDIA",
  "status": "CONCLUIDA",
  "dataLimite": "2025-08-30"
}
```

**Exemplo de Resposta (Não Encontrado - 404 Not Found):**

```
(Corpo vazio)
```

### `DELETE /api/tarefas/{id}`

Deleta uma tarefa pelo seu ID.

**Parâmetros de Path:**

*   `id` (Long): O ID da tarefa a ser deletada.

**Exemplo de Resposta (Sucesso - 204 No Content):**

```
(Corpo vazio)
```

**Exemplo de Resposta (Não Encontrado - 404 Not Found):**

```
(Corpo vazio)
```

---