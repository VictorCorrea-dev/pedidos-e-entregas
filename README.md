# 📦 Sistema de Gestão de Pedidos e Entregas

Aplicação orientada a objetos desenvolvida em Java para gestão de pedidos, cálculo dinâmico de fretes e acompanhamento de modalidades de entrega.

---

## 📄 Documentação do Projeto

### 1. Regras de Cada Modalidade

O sistema oferece quatro modalidades distintas de recebimento:

* **Entrega Normal:** Cobra um valor base de R$ 5,00 por quilo do pacote e entrega no prazo padrão.
* **Entrega Expressa:** Modalidade prioritária. Cobra uma taxa fixa de R$ 15,00 somada a R$ 8,00 por quilo para reduzir o prazo de envio.
* **Entrega Agendada:** Permite ao cliente escolher uma data para a entrega. Aplica uma taxa fixa de R$ 15,00 somada a R$ 6,00 por quilo e impede o agendamento em datas anteriores ao dia atual.
* **Retirada na Loja:** Isenta o cliente do custo de frete (R$ 0,00) para coleta em ponto fixo.

---

### 2. Cálculo do Valor Total

O **Valor Total do Pedido** é determinado na classe `Pedido` somando o preço do produto com o custo do frete calculado dinamicamente pela modalidade associada:

$$\text{Valor Total} = \text{Preço do Produto} + \text{Valor do Frete}$$

Fórmula executada no método `calcularValorTotal()`:
return this.preco + this.modalidadeEntrega.calcularFrete(this.pesoTotal);

### 3. Comparação das Entregas

| Modalidade | Taxa Fixa | Custo por kg | Validação de Data | Diferencial |
| :--- | :--- | :--- | :--- | :--- |
| **Normal** | R$ 0,00 | R$ 5,00 | Não exige | Custo-benefício equilibrado |
| **Expressa** | R$ 15,00 | R$ 8,00 | Não exige | Maior rapidez na entrega |
| **Agendada** | R$ 15,00 | R$ 6,00 | Exige data ≥ dia atual | Escolha da data de recebimento |
| **Retirada na Loja** | R$ 0,00 | R$ 0,00 | Não exige | Frete grátis |

---

### 4. Composição entre Pedido e Entrega

A arquitetura utiliza o conceito de **Composição (Associação)** e o padrão **Strategy**:
* A classe `Pedido` contém um atributo/referência do tipo base `Entrega`.
* Em vez de o `Pedido` calcular o frete diretamente, ele **delega** essa responsabilidade para a instância de `Entrega` associada.
* Isso permite alterar a modalidade de entrega sem modificar a estrutura central da classe `Pedido`.

---

### 5. Aplicação dos Pilares da POO

* **Abstração:** Representada pela classe abstrata `Entrega`, que define o contrato com as assinaturas de `calcularFrete` e `calcularPrazo`, ocultando as particularidades de cada conta.
* **Herança:** As subclasses (`EntregaNormal`, `EntregaExpressa`, `EntregaAgendada` e `RetiradaNaLoja`) herdam os atributos e comportamentos da classe pai `Entrega` (como o `destino`).
* **Encapsulamento:** Os atributos (`preco`, `pesoTotal`, `destino`, `dataAgendada`) são mantidos como `private`, garantindo o acesso seguro via construtores e métodos seletores.
* **Polimorfismo:** O método `calcularFrete` é sobrescrito (`@Override`) em cada classe filha, permitindo que a classe `Pedido` execute o cálculo correto em tempo de execução.
