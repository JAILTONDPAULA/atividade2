# Projeto Java com Spring Boot, Maven, Docker e Docker Compose

Este é um projeto Java desenvolvido com **Spring Boot** e **Maven**. Ele utiliza **Lombok** para simplificar o código e se integra com um banco de dados configurado via **Docker** e **Docker Compose**.

## Dependências

- **Java 17** (requerido para execução do projeto)
- **Spring Boot** (framework principal)
- **Lombok** (para evitar a necessidade de escrever código boilerplate, como getters, setters, etc.)
- **Maven** (para gerenciamento de dependências e build do projeto)
- **Docker** e **Docker Compose** (para configurar e executar o banco de dados em contêineres)

## Versão do Java

Este projeto foi desenvolvido utilizando **Java 17**. Para garantir que a versão correta do Java esteja sendo usada, defina o Java 17 em seu ambiente de desenvolvimento.

## Como rodar o projeto

### Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17** (se não tiver, você pode baixá-lo do [site oficial do OpenJDK](https://adoptopenjdk.net/))
- **Maven** (para compilar o projeto)
- **Docker** e **Docker Compose** (para rodar o banco de dados no contêiner)

### 1. Rodando o banco de dados com Docker Compose

O banco de dados está configurado com **Docker Compose**. Para levantar o banco de dados, basta executar o seguinte comando na raiz do projeto:

```bash
docker-compose up
```
## Migrations com Flyway

Este projeto utiliza o **Flyway** para o gerenciamento de migrações do banco de dados.  
As migrações são arquivos SQL que ajudam a manter a estrutura do banco de dados sincronizada entre os diferentes ambientes.

### Configuração

As migrações estão localizadas no diretório `src/main/resources/db/migration`.  
Certifique-se de que a configuração do Flyway no arquivo `application.yml` está apontando para a base de dados correta.

### Comandos úteis

- **Executar migrações automaticamente**: As migrações são executadas automaticamente ao iniciar a aplicação, desde que o Flyway esteja configurado no datasource.
- **Executar migrações manualmente** (caso necessário):  
  Utilize o comando abaixo no terminal:
  ```bash
  mvn flyway:migrate



Este diagrama contém a representação gráfica do modelo de dados do sistema, mostrando as entidades, seus atributos e os relacionamentos entre elas.

# DER
### Como visualizar o DER
1. Navegue até o diretório `src/main/resources/cets/`.
2. Abra o arquivo `DER.drawio.png` em qualquer visualizador de imagens ou editor de diagramas que suporte o formato `.png`.


# Documentação da API

## Cliente

A API oferece os seguintes endpoints para gerenciamento de clientes:

### 1. **GET /api/v1/clientes**

Recupera uma lista de todos os clientes.

- **Método**: `GET`
- **URL**: `/api/v1/clientes`
- **Descrição**: Retorna todos os clientes cadastrados.
- **Resposta**:
  - **Código 200**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML

**Exemplo de resposta**:
```json
[
  {
    "id": number,
    "nomeCompleto": string,
    "cpf": string",
    "dataNascimento": date,
    "stCivil": string,
    "rendaMensal": number,
    "aberturaConta": date",
    "email": string
  },
]
```
### 2. **POST /api/v1/clientes**

Recupera uma lista de todos os clientes.

- **Método**: `POST`
- **URL**: `/api/v1/clientes`
- **Descrição**: Salva um novo cliente no banco de dados.
- **Resposta**:
  - **Código 201**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML
- **Formato da Envio**: JSON ou XML

**Exemplo de envio**:
```json
{
    "nomeCompleto" : string,
    "cpf" : string,
    "dataNascimento" : date
    "email": string,
    "rendaMensal": number,
    "contaAberta": date
}
```
### 3. **PUT /api/v1/clientes**

Recupera uma lista de todos os clientes.

- **Método**: `POST`
- **URL**: `/api/v1/clientes/{id}`
- **Descrição**: Atualizar dados do cliente no banco de dados.
- **Resposta**:
  - **Código 200**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML
- **Formato da Envio**: JSON ou XML

**Exemplo de envio, podendo enviar um ou mais campos**:
```json
{
    "nomeCompleto" : string,
    "cpf" : string,
    "dataNascimento" : date
    "email": string,
    "rendaMensal": number,
    "contaAberta": date
}
```

## Proposta

A API oferece os seguintes endpoints para gerenciamento de propostas:

### 1. **GET /api/v1/propostas**

Recupera uma lista de todas as propostas geradas.

- **Método**: `GET`
- **URL**: `/api/v1/propostas`
- **Resposta**:
  - **Código 200**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML

**Exemplo de resposta**:
```json
[
  {
        "id": number,
        "data": date,
        "valorAprovado": number,
        "status": number,
        "cliente": "cliente"
    }
]
```
### 2. **POST /api/v1/propostas**

Gera uma nova proposta de crédito de acordo com cliente.

- **Método**: `POST`
- **URL**: `/api/v1/clientes/{idCliente}`
- **Resposta**:
  - **Código 201**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML
- **Formato da Envio**: JSON ou XML

**Exemplo de resposta**:
```json
{
  "id": number,
  "data": date,
  "valorAprovado": number,
  "status": number,
  "cliente": "cliente"
}
```

### 3. **POST /api/v1/propostas**

Gera aprovação e cartão de acordo com a proposta.

- **Método**: `POST`
- **URL**: `/api/v1/clientes/{id}`
- **Resposta**:
  - **Código 201**: Sucesso
  - **Código 500**: Erro no servidor
- **Formato da Resposta**: JSON ou XML
- **Formato da Envio**: JSON ou XML

**Retorna uma mensagem e envia um E-mail**


