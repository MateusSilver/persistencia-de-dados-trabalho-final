# Projeto final de Persistencia de Dados - Java Web Application

Este projeto é uma aplicação Java Web desenvolvida como parte das atividades acadêmicas. A aplicação utiliza Java EE com uma estrutura moderna de pastas e práticas recomendadas para construção e manutenção de aplicativos dinâmicos baseados em web.

## Estrutura do Projeto

A estrutura principal do projeto segue a convenção de um projeto Java Web moderno:

- **Frontend**: Localizado em `src/main/webapp`, contém arquivos HTML, CSS e JavaScript.
- **Backend**: Localizado em `src/main/java`, onde estão as classes Java, incluindo servlets e lógica de negócios.
- **Recursos**: Arquivos de configuração, como `application.properties` ou outros recursos, estão em `src/main/resources`.
- **Configurações**: O projeto utiliza Maven para gerenciar as dependências, com as configurações no arquivo `pom.xml`.

## Pré-requisitos

Para rodar este projeto, você precisará de:

- **Java JDK** 11 ou superior
- **Maven** para gerenciamento de dependências, no eclipse ou standalone.
- Um servidor de aplicação como [**Apache Tomcat**](https://tomcat.apache.org/).

## Instalação e Configuração

1. **Clone o repositório**:

```bash
git clone https://github.com/MateusSilver/persistencia-de-dados-trabalho-final.git
```

2. **Importe o projeto na sua IDE**:

- Para Eclipse: Selecione `Import > Existing Maven Projects`.
- Para IntelliJ: Selecione `File > Open` e escolha o diretório do projeto.

3. **Compile o projeto**:

No terminal, dentro do diretório do projeto, execute:

```bash
Copiar código
mvn clean install
```

4. **Inicie o servidor de aplicação**:

Apache Tomcat na sua IDE e execute o projeto como uma aplicação web.

5. **Acesse a aplicação**:

No navegador acesse: `http://localhost:8080/persistencia-de-dados-trabalho-final`

## Grupo de desenvolvimento:

| aluno              | matricula | github                                          |
| ------------------ | --------- | ----------------------------------------------- |
| Mateus da Silveira | 201905543 | [Mateussilver](https://github.com/Mateussilver) |
|                    |           |                                                 |
