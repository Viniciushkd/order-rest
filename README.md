# order-rest
Spring Rest
```
Para rodar no prompt de comando mvn sprint-boot:run
```
#### /order
## POST
###### /save
```
{
    "id": 1,
    "nome": "Marcos",
    "endereco": "teste",
    "item": {
        "id": 1,
        "descricao": "teste",
        "precounitario": 1.23,
        "quantidade": 4
    },
    "precototal": 1234,
    "formapagamento": {
        "idTransacao": 1,
        "formaPagamento": "teste"
    },
    "cartao": {
        "numero": "1231.24",
        "validade": "19/12",
        "bandeira": "teste"
    },
    "data": "19/12/1990",
    "status": "teste"
}
```
------
## GET
###### /findById/{id}
------
## PUT
###### /{id}
------
## DELETE
###### /{id}
------
