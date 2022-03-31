# EQUIPE 3 - DuroDeCodar - Desafio iLab

## Telemetria de Motoboys

O objetivo do projeto consiste em, pelo ponto de vista do entregador
apresentar os pedidos que foram feitos e estão em aberto, em formato de lista,
da-lo a opção de escolher um deles para efetuar, independente de 
localização ou qualquer outro critério, e apartir disso iniciar uma captura de coordenadas,
para acompanhamento da localização em tempo real.

Para ver o Front-end, clique aqui: https://github.com/JessieZan/frontend-desafioilab

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu 
application.properties

`DB_URL`

`DB_USER`

`DB_PASSWORD`

## Instalação

- Instalação das tecnologias utilizadas
- Criação do banco de dados a partir de SCHEMA_DB_DESAFIO_ILAB.sql
contido na pasta raiz do projeto.
- Rodar projeto como java application

## Autores

- [@JessieZan](https://www.github.com/JessieZan)
- [@Gabrielli5047](https://www.github.com/Gabrielli5047)
- [@brunodelucasbarbosa](https://www.github.com/brunodelucasbarbosa)
- [@nettojulio](https://www.github.com/nettojulio)
- [@Italo-C-TI](https://www.github.com/Italo-C-TI)
## Stack utilizada

**Front-end:** React.

**Back-end:** Java, SpringBoot, PostgreSQL, JWT, Bcrypt, Cors.


## Documentação da API

### End-Points

### Autenticação de Usuário

```http
  POST /login
```

#### Dados Enviados

| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `email` | `string` | email do usuario/entregador |
| `telefone` | `string` | telefone do usuario/entregador|
| `senha` | `string` | **Obrigatório**. telefone do usuario/entregador |


#### Body
```http
{
    "email":"italo@email.com",
    "senha": "senhaqualquer"
}
```

#### Dados Recebidos

#### Sucesso (200) ou Erro(400) Bad Request

| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `token` | `string` | token de acesso do usuario/entregador |


#### Exemplo
```http
{
	"token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdGFsb19Db3N0YSwyLGl
    0YWxvQGVtYWlsLmNvbSw3MTEyMzQ1Njc4OSIsImlzcyI6IkZvb2RMb3ZlcnMiLCJleHAi
    OjE2NDg3ODA4Nzl9.0UW7jMU8_S9VvluB3tMDvwRHAbp6ZcMoCoyFRrO6Udk"
}
```

---



### Retorna todos os pedidos de acordo com o parametro de query informados

```http
  GET /pedidos?status={status}
```

#### Dados Enviados - Query Params - Não obrigatorio

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `status`      | `string` | o tipo de status para filtrar os pedidos que serao recuperados|

#### **No Body

#### Dados Recebidos

#### Sucesso (200) ou Erro(400) Bad Request

#### Exemplo
```http
[
	{
		"id": 4,
		"dataCriacao": "2022-03-28T18:02:16.559583",
		"valorTotal": 53000,
		"status": "em_aberto",
		"enderecoEntrega": "rua da serenidade ,119, bairro da paz, salvador-BA",
		"entregador": {
			"id": null,
			"nome": "null",
			"email": "null",
			"telefone": "null",
			"emEntrega": null
		},
		"cliente": {
			"id": 1,
			"nome": "Fulano"
		}
	},
	{
		"id": 5,
		"dataCriacao": "2022-03-28T18:02:16.559583",
		"valorTotal": 23000,
		"status": "em_aberto",
		"enderecoEntrega": "rua dos coqueiros ,120, brotas, salvador-BA",
		"entregador": {
			"id": null,
			"nome": "null",
			"email": "null",
			"telefone": "null",
			"emEntrega": null
		},
		"cliente": {
			"id": 2,
			"nome": "Ciclano"
		}
	},
]    
```

### Altera status do pedido de acordo com parametros de query informados

```http
  PUT /pedidos/{id}?acao={acao}&idEntregador={idEntregador}
```

#### Dados Enviados - Query Params - Obrigatorios

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `acao`      | `string` | "atribuir", "finalizar" ou "cancelar"|
| `idEntregador` | `int` | id do entregador logado |

#### **No Body

#### Dados Recebidos

#### Sucesso (200) ou Erro(404) Not Found

#### Exemplo
```http
{
	"id": 1,
	"dataCriacao": "2022-03-25T20:56:34.78966",
	"valorTotal": 25000,
	"status": "em_andamento",
	"enderecoEntrega": "rua da pamonha ,116, brotas, salvador-BA",
	"entregador": {
		"id": 5,
		"nome": "Bruno",
		"email": "bruno@email.com",
		"telefone": "11987654321",
		"senha": "senhaqualquer",
		"emEntrega": true
	},
	"cliente": {
		"id": 2,
		"nome": "Ciclano",
		"senha": "senhaqualquer"
	}
}
```
### Recebe e salva geolocalização do pedido/entregador no banco

```http
  POST /pedidos/cadastrar-coordenada
```

#### Dados Enviados - Query Params - Obrigatorios

| Chave   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idPedido`      | `string` | id do pedido em andamento|
| `idEntregador` | `int` | id do entregador logado |
| `timestamp` | `string` | timestamp do momento da captura |
| `coordenada` | `string` | coordenada de geolocalização |

#### Body

```http
{
    "idPedido": 1,
    "idEntregador": 1,
    "timestamp": "2017-01-13T17:09:42.411",
    "coordenada": "@-13.0273645,-40.5187074"
}
```

#### Dados Recebidos

#### Sucesso (200) Ok ou Erro(400) Bad Request


### Retorna Tracking de Pedido

```http
  GET /pedidos/rastrear/{id}
```
#### Dados Enviados - No Body

#### Dados Recebidos

#### Sucesso (200) Ok ou Erro(404) Not Found

#### Exemplo
```http
[
	{
		"idPedido": 2,
		"timestamp": "2022-03-28T18:02:16.559583",
		"coordenada": "@-12.9873645,-38.5187074"
	},
	{
		"idPedido": 2,
		"timestamp": "2022-03-28T18:02:16.559583",
		"coordenada": "@-13.0273645,-40.5187074"
	},
	{
		"idPedido": 2,
		"timestamp": "2022-03-28T18:02:16.559583",
		"coordenada": "@-12.9873645,-40.5187074"
	},
	{
		"idPedido": 2,
		"timestamp": "2022-03-29T19:17:39.025",
		"coordenada": "-12.9108314 -38.4304855"
	}
]    
```


