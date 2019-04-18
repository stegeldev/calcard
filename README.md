# Avaliação Técnica Calcard

Sistema de Proposta e análise de Crédito.

A proposta de crédito consiste em um formulário contendo as seguintes informações de cadastro de cliente:

- Nome
- CPF
- idade
- sexo
- estado civil
- estado
- dependentes
- renda

O sistema avalia as informações de entrada e defini se o cliente foi negado ou se foi aprovado. Além disso, o algoritmo informa em qual faixa de limite de crédito o cliente se encaixou.

O sistema realiza a análise do cliente baseado nas informações cadastrais da proposta.
O sistema grava o cadastro da proposta no banco de dados.
O sistema toma a decisão da proposta, aprovando-a ou negando-a.
Após o cadastro da proposta e tomada de decisão, o sistema deve apresentar o resultado da análise.
Aprovação da proposta deve estar composta com valor de limite de crédito sugerido pelo sistema.
A Negação deve estar composta pelo motivo da não aprovação.

## Pré requisitos
- Maven
- Java 8
- Docker 1.13.0+

## Construindo o ambiente
```
mvn clean -Dmaven.test.skip=true package
 ```
 ```
docker build --build-arg JAR_FILE=target/*.jar -t calcard/propostas .
```
 ```
docker-compose run --rm wait
```

```
/* Aguardar inicialização do mysql. */
```

```
docker-compose up docker-app
```

Script SQL: Possui se precisar e está na raiz do projeto data.sql

## Documentação Swagger

http://localhost:8080/swagger-ui.html#/

## Acesso ao Projeto

O Acesso ao projeto se dá pelo endereço: http://localhost:8080/

