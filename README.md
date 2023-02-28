# SystemManagement_V1.0-

Repositorio destinada a aula de DBE, gerenciador de tarefas.

## Endpoints

- Tarefa
    - [cadastrar](#cadastra-tarefa)
    - apagar
    - listar todas
    - alterar
    - [detalhes](#detalhes-da-tarefa)

- Usuario
    - [cadastrar](#cadastrar-usuario) 
    - apagar
    - listar todas
    - [alterar](#alterar-usuario)
    - [detalhes](#detalhes-do-usuario)

---

### Cadastrar da Tarefa 

`POST` /systemmanagement_V1.0-/api/tarefa

**Campos da Requisição**

| campo| tipo | obrigatório | descrição
|:-------:|:------:|:-------------:|:----------:
| tarefa | texto | sim | titulo da tarefa 
|data | data | sim | a data limite de entrega
|descrição | texto | não | um texto sobre a tarefa
|prioridade_id | int | sim | o id de prioridade 

---

**Exemplo corpo de requisição**

```js
{
    tarefa: "Plano de Voo",
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
### Detalhes da Tarefa

`GET` /systemmanagement_V1.0-/api/tarefa/{id}

**Exemplo corpo de resposta**

```js
{
    tarefa: "Plano de Voo",
    descricao: "Tarefa de DBE",
    data: '2023-02-27',
    prioridade{
        prioridade_id: 2,
        nome: "Importante"
    }
}
```

**Respostas**

|código | descrição
|-|-
| **201** | dados da despesa retornados
| **404** | não existe prioridade com o id informado 

---

### Cadastrar Usuario 

`POST` /systemmanagement_V1.0-/api/usuario

**Campos da Requisição**

| campo | tipo | obrigatório | descrição 
|:-------:|:------:|:-------------:|---
|login | texto | sim | username do usuario
|email | texto | sim | o email do usuario
|telefone| int | sim | o telefone do usuario
|senha | texto | sim | a senha do usuario

---

**Exemplo corpo de requisição**

```js
{
    login: "mouratins",
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

### Alterar Usuario

`PUT` /systemmanagement_V1.0-/api/usuario

**Exemplo corpo de resposta**

```js
{
    login: "martoura",
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

`GET` /systemmanagement_V1.0-/api/usuario

**Exemplo corpo de resposta**

```js
{
    login: "mouratins",
    email: "mouratins@hotmail.com",
    telefone: '11 94446-6450',
    senha: "ilovc0de",
}

```

**Respostas**

|código | descrição
|-|-
| **201** | dados do usuario retornados
| **404** | username inexistente 



