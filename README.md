
# API de Gerenciamento de Treinamentos

## Sobre o projeto

A API de Treinamentos é uma aplicação backend desenvolvida para gerenciar treinamentos, cursos e participantes.

O sistema permite o controle completo de informações relacionadas a treinamentos, sendo aplicável em contextos corporativos e educacionais.

Este projeto foi desenvolvido com foco em boas práticas de arquitetura backend utilizando Java e Spring Boot.

---

## Funcionalidades

* Cadastro de treinamentos
* Gerenciamento de participantes
* Consulta de dados
* Atualização de informações
* Remoção de registros

---

## Tecnologias utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Maven
* Banco de dados relacional (H2 ou MySQL)

---

## Arquitetura

O projeto segue o padrão de camadas:

```
controller → service → repository → model
```

* Controller: responsável pelas requisições HTTP
* Service: regras de negócio
* Repository: acesso ao banco de dados
* Model: entidades da aplicação

---

## Como executar o projeto

### Pré-requisitos

* Java 17+
* Maven

### Passos

```
git clone https://github.com/LuzEscuraa/Api-Treinamentos.git
cd Api-Treinamentos
./mvnw spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

---

## Endpoints principais

Treinamentos:

```
GET /treinamentos
POST /treinamentos
PUT /treinamentos/{id}
DELETE /treinamentos/{id}
```

Participantes:

```
GET /participantes
POST /participantes
```

---

## Testes

A API pode ser testada utilizando ferramentas como Postman ou Insomnia.

---

## Melhorias futuras

* Implementação de autenticação (JWT)
* Testes automatizados
* Documentação com Swagger
* Deploy em nuvem

---

## Autor

João Antônio
https://github.com/LuzEscuraa
