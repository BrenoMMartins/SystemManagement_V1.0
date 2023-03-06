# SystemManagement_V1.0-

Repositorio destinada a aula de DBE, gerenciador de tarefas.

## Endpoints

- Tarefa
    - [cadastrar](#cadastra-tarefa)
    - [apagar](#apagar-tarefa)
    - [alterar](#alterar-tarefa)
    - [detalhes](#detalhes-da-tarefa)

- Usuario
    - [cadastrar](#cadastrar-usuario) 
    - [apagar](#alterar-usuario)
    - [alterar](#alterar-usuario)
    - [detalhes](#detalhes-do-usuario)

---

### Cadastrar da Tarefa 

`POST` /systemmanagement_V1.0-/api/tarefa{id}

**Campos da Requisição**

| campo| tipo | obrigatório | descrição
|:-------:|:------:|:-------------:|:----------:
| tarefa_id | int | sim | titulo da tarefa 
|data | data | sim | a data limite de entrega
|descrição | texto | não | um texto sobre a tarefa
|prioridade_id | int | sim | o id de prioridade 

**Exemplo corpo de requisição**

```js
{
    tarefa{
        tarefa_id: 1,
        nome: "Plano de Voo"
    }
    descricao: "Tarefa de DBE",
    data: '2023-03-06',
    prioridade_id: 2,
}

```

**Respostas**

|código | descrição
|-|-
| **201** | tarefa cadastrada com sucesso 
| **400** | campos inválidos
---
### Apagar Tarefa

`DELETE`/systemmanagement_V1.0-/api/tarefa/{id}

|código | descrição
|-|-
| **200** | tarefa apagada com sucesso
| **404** | id da tarefa não encontrado
---
### Alterar Tarefa

`PUT`/systemmanagement_V1.0-/api/tarefa/{id}

**Exemplo corpo de resposta**

```js
{
    tarefa{
        tarefa_id: 1,
        nome: "Arquitetura de Dados"
    }
    descricao: "Tarefa de DBE",
    data: '2023-02-27',
    prioridade{
        prioridade_id: 1,
        nome: "Pouco Urgente"
    }
}
```

**Respostas**

|código | descrição
|-|-
| **202** | dados da tarefa alterados com sucesso
| **401** | data invalida 
---
### Detalhes da Tarefa

`GET`/systemmanagement_V1.0-/api/tarefa/{id}

**Exemplo corpo de resposta**

```js
{
    tarefa{
        tarefa_id: 1,
        nome: "Arquitetura de Dados"
    }
    descricao: "Tarefa de DBE",
    data: '2023-02-27',
    prioridade{
        prioridade_id: 1,
        nome: "Pouco Urgente"
    }
}
```

**Respostas**

|código | descrição
|-|-
| **200** | dados da tarefa retornados com sucesso
| **404** | não existe prioridade com o id informado 

---

### Cadastrar Usuario 

`POST`/systemmanagement_V1.0-/api/usuario

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|:-------:|:------:|:-------------:|---
|login_id | int | sim | username do usuario
|email | texto | sim | o email do usuario
|telefone| int | sim | o telefone do usuario
|senha | texto | sim | a senha do usuario

**Exemplo corpo de requisição**

```js
{
    login{
        login_id: 1,
        nome: "mouratins"
    }
    email: "mouratins@hotmail.com",
    telefone: '11 94446-6401',
    senha: "Eu4moDBE",
}

```

**Respostas**

|código | descrição
|-|-
| **201** | usuario cadastrado com sucesso 
| **400** | campos inválidos
---
## Apagar Usuario 

`DELETE`/systemmanagement_V1.0-/api/usuario{id}

**Respostas**

|código | descrição
|-|-
| **200** | usuario apagado com sucesso 
| **404** | id do usuario não encontrado
---

### Alterar Usuario

`PUT`/systemmanagement_V1.0-/api/usuario{id}

**Exemplo corpo de resposta**

```js
{
    login{
        login_id: 1,
        nome: "martoura"
    }
    email: "mouratins@hotmail.com",
    telefone: '11 94446-6450',
    senha: "ilovc0de",
}

```

**Respostas**

|código | descrição
|-|-
| **202** | usuario alterado com sucesso
| **401** | username ja esta em uso

---

### Detalhes do Usuario

`GET`/systemmanagement_V1.0-/api/usuario{id}

**Exemplo corpo de resposta**

```js
{
    login{
        login_id: 1,
        nome: "martoura"
    }
    email: "mouratins@hotmail.com",
    telefone: '11 94446-6450',
    senha: "ilovc0de",
}

```

**Respostas**

|código | descrição
|-|-
| **200** | dados do usuario retornados com sucesso
| **404** | id do usuario não encontrado



