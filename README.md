# 📦 Sistema de Pedidos e Entregas

Aplicação orientada a objetos desenvolvida em Java para gestão de pedidos, cálculo de custos e acompanhamento de diferentes modalidades de entrega.

---

## 📄 Documentação

### 1. Regras de Cada Modalidade

O sistema oferece quatro modalidades distintas de recebimento:

* **Entrega Normal:** Modalidade padrão com cálculo de frete baseado na distância/peso e prazo regular de envio.
* **Entrega Expressa:** Modalidade prioritária. Possui taxa adicional sobre o valor base do frete e reduz significativamente o prazo de entrega.
* **Entrega Agendada:** Permite ao cliente escolher uma data e janela de horário específicas para a entrega, aplicando uma taxa fixa de agendamento.
* **Retirada na Loja:** Isenta o cliente do custo de frete (valor R$ 0,00) e disponibiliza um ponto fixo de coleta após o processamento do pedido.

---

### 2. Cálculo do Valor Total

O **Valor Total do Pedido** é determinado pela soma do valor dos itens cadastrados no pedido com o valor final do frete calculado pela modalidade escolhida:

$$\text{Valor Total} = \text{Valor dos Itens} + \text{Valor do Frete}$$

* **Normal:** Frete Base.
* **Expressa:** Frete Base + Adicional de Urgência.
* **Agendada:** Frete Base + Taxa de Agendamento.
* **Retirada na Loja:** Frete = R$ 0,00.

---

### 3. Comparação das Entregas

| Modalidade | Custo do Frete | Prazo de Entrega | Diferencial |
| :--- | :--- | :--- | :--- |
| **Normal** | Padrão | Regular | Custo-benefício equilibrado |
| **Expressa** | Elevado (Taxa extra) | Curto / Prioritário | Rapidez na entrega |
| **Agendada** | Padrão + Taxa fixa | Data/Horário definidos | Conveniência para o cliente |
| **Retirada na Loja** | Isento (R$ 0,00) | Conforme disponibilidade | Sem custo de frete |

---

### 4. Composição entre Pedido e Entrega

A arquitetura utiliza o conceito de **Composição (ou Agregação)** da POO:
* A classe `Pedido` possui uma referência/atributo do tipo `Entrega`.
* Em vez do `Pedido` calcular o frete diretamente, ele **delega** essa responsabilidade para o objeto `Entrega` associado a ele.
* Isso permite mudar a modalidade de entrega de um pedido de forma flexível e descolada da estrutura central do pedido.

---

### 5. Aplicação dos Pilares da POO

* **Abstração:** A classe abstrata (ou interface) `Entrega` define o contrato geral do que toda entrega deve ter (como o método de calcular frete), escondendo detalhes complexos da regra de negócio central.
* **Herança:** As classes filhas (`EntregaNormal`, `EntregaExpressa`, `EntregaAgendada`, `RetiradaNaLoja`) herdam os atributos e métodos comuns da classe base `Entrega`.
* **Encapsulamento:** Os atributos das classes são mantidos como `private` e manipulados com segurança via métodos *getters* e *setters* ou construtores, protegendo os dados contra alterações indevidas.
* **Polimorfismo:** O método de cálculo do frete é sobrescrito (`@Override`) em cada classe filha, permitindo que o `Pedido` execute o cálculo correto dinamicamente.

