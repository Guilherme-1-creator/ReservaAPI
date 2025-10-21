# 🏢 Sistema de Gerenciamento de Salas, Usuários e Reservas

Aplicação **backend** desenvolvida em **Spring Boot**, utilizando **Spring Data JPA** para persistência em banco relacional (**MySQL**).  
O sistema permite **criar, listar, atualizar e remover** salas, usuários e reservas, com **validações de domínio**, **checagem de conflitos** e **controle de status** das reservas.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 17**
- 🌱 **Spring Boot 3**
- 🗃️ **Spring Data JPA**
- 🔒 **Spring Security**
- 🔁 **Hibernate**
- 🐬 **MySQL**
- ⚙️ **Gradle**
- 🧪 **Postman** (para testar as requisições)

---

## 📋 Regras de Negócio

- ❌ Não é possível reservar **salas inativas**.  
- ✅ A **capacidade da sala** deve ser **positiva**.  
- ⏳ As **datas de início** devem ser **anteriores às de fim**.  
- 🚫 A **mesma sala** não pode ter **reservas sobrepostas** (`[início, fim)`).  
- 🔄 **Reservas canceladas** não entram em conflito com outras.  
- 🔖 O **status da reserva** controla o fluxo (**ATIVA ↔ CANCELADA**).

---

## ⚡ Endpoints REST

### 🏠 **Salas**
| Método | URL           | Descrição               |
|--------|----------------|-------------------------|
| GET    | `/salas`       | Listar todas as salas   |
| GET    | `/salas/{id}`  | Buscar sala por ID      |
| POST   | `/salas`       | Criar nova sala         |
| DELETE | `/salas/{id}`  | Remover sala            |

---

### 👤 **Usuários**
| Método | URL             | Descrição              |
|--------|------------------|------------------------|
| GET    | `/usuarios`      | Listar usuários        |
| GET    | `/usuarios/{id}` | Buscar usuário por ID  |
| POST   | `/usuarios`      | Criar usuário          |
| DELETE | `/usuarios/{id}` | Remover usuário        |

---

### 📅 **Reservas**
| Método | URL               | Descrição                               |
|--------|--------------------|------------------------------------------|
| GET    | `/reservas`        | Listar todas as reservas                 |
| GET    | `/reservas/{id}`   | Buscar reserva por ID                    |
| POST   | `/reservas`        | Criar nova reserva                       |
| DELETE | `/reservas/{id}`   | Cancelar reserva (**status → CANCELADA**) |
