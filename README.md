# order-rest
Spring Rest
```
Para rodar no prompt de comando mvn sprint-boot:run
```
#### /order
## POST
###### /save
```
curl -X POST \
  http://localhost:8080/order/save \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 44216986-2da9-13b5-ba8e-608ad7d29df1' \
  -d '{
	"id":1,
	"nome":"Marcos",
	"endereco":"teste",
	"item":{
		"id":1,
		"descricao":"teste",
		"precounitario":1.23,
		"quantidade":4
	},
	"precototal":"1234",
	"formapagamento":{
		"idTransacao":1,
		"formaPagamento":"teste"
	},
	"cartao": {
		"numero":1231.24,
		"validade":"19/12",
		"bandeira":"teste"
	},
	"data":"19/12/1990",
	"status":"teste"
}'
```
------
## GET
###### /findById/{id}
```
curl -X GET \
  http://localhost:8080/order/findById/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 7db3e4ba-6c57-71bb-1906-c68f3b9640a7'
```
------
## PUT
###### /{id}
```
curl -X PUT \
  http://localhost:8080/order/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 608f7656-a07c-18e3-e086-4295b7f7903d' \
  -d '{
	"id":1,
	"nome":"Marcos",
	"endereco":"Rua aaaaaaa",
	"item":{
		"id":1,
		"descricao":"teste",
		"precounitario":123.25,
		"quantidade":4
	},
	"precototal":1234.95,
	"formapagamento":{
		"idTransacao":1,
		"formaPagamento":"teste"
	},
	"cartao": {
		"numero":"123124",
		"validade":"19/12",
		"bandeira":"teste"
	},
	"data":"19/12/1990",
	"status":"teste"
}'
```
------
## DELETE
###### /{id}
```
curl -X DELETE \
  http://localhost:8080/order/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: a7a100e1-485f-4796-67a7-78fe6e222ba6'
```
------
