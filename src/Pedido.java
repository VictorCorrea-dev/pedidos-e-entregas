public class Pedido {

    //    Atributos
    private double preco;
    private double pesoTotal;
    private Entrega modalidadeEntrega;

    // Construtor
    public Pedido(double valorProduto, double pesoTotal, Entrega modalidadeEntrega) {

        if (valorProduto <= 0 || pesoTotal <= 0) {
            throw new IllegalArgumentException("O preço e o peso do produto devem ser maiores do que 0!");
        }

        if (modalidadeEntrega == null) {
            throw new IllegalArgumentException("A modalidade de entrega é obrigatória!");
        }

        this.preco = valorProduto;
        this.pesoTotal = pesoTotal;
        this.modalidadeEntrega = modalidadeEntrega;
    }

    // Métodos (ações que o Pedido faz)

    public double calcularValorTotal() {
        return this.preco + this.modalidadeEntrega.calcularFrete(this.pesoTotal);
    }

    public void exibirResumo() {
        System.out.println("=== RESUMO DO PEDIDO ===");
        System.out.println("Destino: " + this.modalidadeEntrega.getDestino());
        System.out.println("Prazo: " + this.modalidadeEntrega.calcularPrazo());
        System.out.println("Valor do Produto: R$ " + this.preco);
        System.out.println("Valor do Frete: R$ " + this.modalidadeEntrega.calcularFrete(this.pesoTotal));
        System.out.println("Valor Total: R$ " + this.calcularValorTotal());
        System.out.println("========================");
    }

}