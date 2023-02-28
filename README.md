# SystemManagement_V1.0-

Repositorio destinada a aula de DBE, gerenciador de gastos pessoais.

## Endpoints

- Despesas
    - [cadastrar](#cadastrar-despesas) 
    - apagar
    - alterar - listar todas
    - alterar
    - mostrar detalhes

- Contas
    - cadastrar 
    - apagar
    - alterar - listar todas
    - alterar
    - mostrar detalhes

---

### Cadastrar Despesas 

`POST` /meujulius/api/despesas

**Campos da Requisição**

| campo | tipo | obrigatório | descrição
|:-------:|:------:|:-------------:|:----------:
|valor | decimal | sim | o valor da despesa, deve ser maior que zero
|data | data | sim | a data da despesa
|conta_id | int | sim | o id da conta previamente cadastrada
|categoria_id | int | sim | o id de uma categoria 
|descrição | texto | não | um texto sobre a despesa 

---

**Exemplo corpo de requisição**

```js
{
    valor: 100.00,
    data: '2023-02-27',
    conta_id: 1,
    descricao: "cinema - homem aranha"
}

```

**Respostas**

|código | descrição
|-|-
| **201** | despesa cadastrada com sucesso 
| **400** | campos invalidos 

---
## Detalhes da Despesa 

`GET` /meujulius/api/despesas/{id}

**Exemplo corpo de resposta**

```js
{
    valor: 100.00,
    data: '2023-02-27',
    conta{
        cinta_id: 1,
        nome: "itaú"
    },
    categoria{
        categoria_id: 1,
        nome: "lazer"
    },
    descricao: "cinema - homem aranha"
}
```

**Respostas**

|código | descrição
|-|-
| **201** | dados da despesa retornados
| **404** | não existe despesa com o id informado 





