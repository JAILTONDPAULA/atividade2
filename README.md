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
