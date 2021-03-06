# sales-api
API REST para vendas utilizando Spring Boot

## Ferramentas utilizadas
* IntelliJ IDEA
* Postman
* Git

## Premissas
* Criar uma API usando Spring Boot, que faz parte da nossa stack.
* Utilizar um banco de dados em memória (HSQLDB ou H2)
* Não é necessário desenvolver front-end, apenas o back-end.

## Desenvolver os serviços REST:
* Criar uma nova venda
* Retornar a lista de vendedores com os campos: nome, total de vendas do vendedor e média de vendas diária, conforme o período informado por parâmetro 

### Testes
* Desenvolver um serviço que seja capaz de gerar uma venda.
* Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.

## URL Paths
### GET
* "/vendedores" - Retorna todos os vendedores
* "/vendedores/listar?dataInicial=2021-08-25&dataFinal=2021-09-25" - Retorna uma lista de vendedores com a média de vendas diárias calculada
* "/vendas" - Retorna todas as vendas

### POST
* "/vendedores" - Cadastrar um novo vendedor
```json
{
  "nome": "Alexandre Kawamura Tanaka"
}
```
* "/vendas/{vendedorId}/novaVenda" - Cadastrar uma nova venda
```json
{
    "valor": 100
}
```
