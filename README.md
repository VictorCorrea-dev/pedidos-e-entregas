# 📦 Sistema de Pedidos e Entregas

Um sistema em Java desenvolvido para gerenciar o processamento, cálculo e acompanhamento de diferentes modalidades de pedidos e entregas.

---

## 📌 Sobres o Projeto

O **Sistema de Pedidos e Entregas** é uma aplicação orientada a objetos que simula a gestão de entregas para diferentes cenários de logística (entregas expressas, agendadas, normais ou retirada em loja). O objetivo principal é aplicar conceitos fundamentais de Programação Orientada a Objetos (POO), tais como herança, polimorfismo e encapsulamento.

---

## 🚀 Funcionalidades

* 📝 **Gestão de Pedidos:** Cadastro e manipulação de informações essenciais de pedidos.
* 🚚 **Múltiplas Modalidades de Entrega:**
  * **Entrega Normal:** Cálculo padrão de prazos e taxas.
  * **Entrega Expressa:** Processamento prioritário com taxas diferenciadas.
  * **Entrega Agendada:** Definição prévia de datas e horários específicos.
  * **Retirada na Loja:** Isenção de frete e controle de ponto de coleta.
* 📊 **Cálculo de Custos e Prazos:** Regras de negócio dinâmicas de acordo com o tipo de entrega selecionado.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 11 ou superior)
* **IDE Recomendada:** IntelliJ IDEA / Eclipse / VS Code
* **Controle de Versão:** Git & GitHub

---

## 📁 Estrutura do Projeto

```text
sistema_pedidos_e_entregas/
├── src/
│   ├── Entrega.java
│   ├── EntregaAgendada.java
│   ├── EntregaExpressa.java
│   ├── EntregaNormal.java
│   ├── Main.java
│   ├── Pedido.java
│   └── RetiradaNaLoja.java
├── .gitignore
└── README.md
