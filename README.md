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

Tecnologias utilizadas:

- Spring Boot 1.4.3
- Spring 4.3.5
- Spring data JPA 1.10.6
- MySQL 5.1.40
- AngularJS 1.5.8
- Maven 3.1
- JDK 1.7
- Eclipse NEON
- Integrações: Rest conceito Restful

EndPoints
- Consulta todos os clientes e propostas - http://localhost:8080/calcard/api/user/
- Consilta o cliente pelo CPF - http://localhost:8080/calcard/api/cliente/{cpf}
- Consulta a análise e tomada de descisão da proposta - http://localhost:8080/calcard/api/user/proposta/{idProposta} 
- Executa o motor para análise da proposta - http://localhost:8080/calcard/api/user/proposta/analisa/

Banco de dados

Segue os dados do banco Mysql para testar
Host: mysql.uhserver.com/calcard
User: calcard
Pass: C@lcard2018
PHPMyAdmin: https://admin.mysql.uhserver.com

Script SQL: está na raiz do projeto data.sql

O Acesso ao projeto se dá pelo endereço: http://localhost:8080/calcard/

