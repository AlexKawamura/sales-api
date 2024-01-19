# sales-api
API REST para vendas utilizando Spring Boot.

## Ferramentas utilizadas
* IntelliJ IDEA
* Postman
* Git
* Docker

## Premissas
* Criar uma API usando Spring Boot, que faz parte da nossa stack.
* Utilizar um banco de dados em memória (HSQLDB ou H2).
* Não é necessário desenvolver front-end, apenas o back-end.

### Testes
* Desenvolver uma API REST que seja capaz de gerar um pedido. (código do cliente, código dos produtos, valor total e endereço de entrega)
* A api deve gravar o pedido no banco e enviar o pedido para a uma fila de mensagem de entregas, usando RabbitMQ.
* Criar um serviço para ler as entregas da fila e salvar na tabela Entrega (endereço de entrega e id do pedido).

## URL Paths
### GET (http://localhost:8080/)
* "/vendas/pedidos" - Retorna todos os pedidos cadastrados.
* "/produto" - Retorna lista de produtos.

### POST (http://localhost:8080/)
* "/produto" - Cadastra um produto novo.
* "/vendas/novoPedido" - Cadastrar um novo pedido (necessário ao menos um produto cadastrado).
```json
{
    "idCliente": 1,
    "idProdutos": [
        { "id": 1 },
        { "id": 2 }
    ],
    "valorTotal": 12.34,
    "enderecoEntrega": "Rua dos Bobos, 0"
}
```

### RabbitMQ
* http://localhost:15672/#/

### Database H2
* http://localhost:8080/h2-console
* Database: jdbc:h2:mem:salesapi
* Username: sa

## Funcionamento
* É preciso ter um container com RabbitMQ rodando no Docker.
  
`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.12-management`

* Feito isso basta utilizar o Postman ou um navegador para realizar o cadastro de pedidos.
