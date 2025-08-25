# DSList — API de listas de jogos (Spring Boot)

> API REST para consulta de jogos e organização em listas ordenadas (com movimentação de posições), construída com **Java + Spring Boot**, **JPA/Hibernate**, **PostgreSQL (via Docker)**.  
> Projeto de portfólio inspirado no **Intensivão Java Spring** da DevSuperior, cobrindo fundamentos REST, modelagem de domínio, consultas otimizadas, perfis de execução e boas práticas de arquitetura.

[![Java](https://img.shields.io/badge/Java-17+-red)](#) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](#) [![Build](https://img.shields.io/badge/Build-Maven-informational)](#) [![Database](https://img.shields.io/badge/DB-PostgreSQL--Docker-blue)](#)

---

## Modelo de domínio

<img width="824" height="290" alt="Image" src="https://github.com/user-attachments/assets/d500ec11-2797-4209-aa46-7e062634a69b" />

Entidades do modelo:

Game → título, ano, gênero, plataformas, score, imagens e descrições.

GameList → agrupador de jogos por categoria.

Belonging → entidade de associação (N:N) com chave composta (@EmbeddedId), responsável por guardar a posição do jogo dentro da lista.

---

## 🎯 Visão geral
Este projeto expõe endpoints para:
- Listar **jogos** (dados resumidos e detalhados);
- Listar **listas de jogos**;
- Consultar **jogos por lista** mantendo a **ordenação definida**;
- **Mover** um jogo de posição dentro de uma lista (operação transacional/atômica).

---

## 🌐 Fundamentos REST aplicados
O projeto segue o padrão **RESTful**, conforme estudado no treinamento:
- Comunicação **cliente/servidor** via HTTP.
- **Stateless**: cada requisição é independente.
- **Interface uniforme**: endpoints bem definidos e consistentes.
- **Formato padronizado**: JSON para requisições e respostas.
- **Uso correto dos verbos HTTP**:
  - `GET` para consulta
  - `POST` para movimentação de itens
  - (mantendo idempotência sempre que necessário)


## 🛣️ Endpoints

### 🎮 Games
```http
GET /games
```

```http
GET /games/{id}
```

---

### 📂 Lists
```http
GET /lists
```

```http
GET /lists/{id}/games
```

---

### 🔄 Operação especial (mover jogo de posição)
```http
POST /lists/{listId}/replacement
```

**Body (JSON):**
```json
{
  "sourceIndex": 3,
  "targetIndex": 1
}
```


## Como executar o projeto

### Pré-requisitos
- **Java 17**
- **Maven 3.8+**
---

### 1) Clonar repositório
```bash
git clone https://github.com/GusstavoAp/dslist.git
```

### 2) Entrar na pasta do projeto
```bash
cd dslist
```

### 3) Executar o projeto (perfil de teste com H2)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=test
```

---

### 4) Acessar o H2 Console
Depois que o projeto estiver rodando, acesse no navegador:

```
http://localhost:8080/h2-console
```

**Configurações de conexão:**
- **JDBC URL**: `jdbc:h2:mem:testdb`  
- **User**: `sa`  
- **Password**: *(deixe em branco)*  

