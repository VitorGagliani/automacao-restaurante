 # 🍽️ Sistema de Automação de Restaurante

Sistema web para **automação de restaurantes**, focado em agilidade no atendimento, redução de erros nos pedidos e melhor controle operacional entre **mesa e cozinha**.

---

## 🎯 Objetivo do Projeto

O objetivo é automatizar o fluxo de pedidos de um restaurante, desde a escolha dos itens pelo cliente/garçom até a preparação na cozinha, centralizando todas as informações em um único sistema.

Benefícios principais:

* Redução de erros de anotação
* Agilidade no envio de pedidos à cozinha
* Controle de pedidos por mesa
* Organização do fluxo de atendimento

---

## 🧠 Visão Geral do Funcionamento

O fluxo principal do sistema segue as etapas abaixo:

1. Identificação da mesa ou cliente
2. Seleção dos itens do cardápio
3. Criação do pedido no sistema
4. Cálculo automático do valor total
5. Envio do pedido para a cozinha
6. Atualização de status (Em preparo → Pronto)

---

## 🧱 Arquitetura do Sistema

### 🔹 Backend

* API REST responsável por:

  * Gerenciamento de usuários
  * Cardápio (produtos e categorias)
  * Pedidos e itens do pedido
  * Mesas
  * Pagamentos
  * Regras de negócio

### 🔹 Frontend -> https://github.com/VitorGagliani/zesty-angular

Interfaces específicas para cada papel:

* Garçom / Pedido
* Cozinha

---

## 🗂️ Principais Entidades

* **Usuário**: controle de acesso por perfil
* **Mesa**: identifica mesas do restaurante
* **Cliete**: identifica o cliente
* **Categoria**: organização do cardápio
* **Produto**: itens disponíveis para pedido
* **Pedido**: representa um pedido ativo ou finalizado


---

## 🔄 Status do Pedido

Os pedidos seguem um fluxo de estados:

* ABERTO
* EM_PREPARO
* PRONTO
* FECHADO

Esse controle permite visibilidade em tempo real para a cozinha.

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven

### Frontend

* Angular
* TailwindCss

## 📌 Status do Projeto

🚧 Em desenvolvimento

---

## 👨‍💻 Autor

Desenvolvido por **Vitor Gagliani**



