import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IO.println("=== SISTEMA DE CRIAÇÃO DE PEDIDOS ===\n");

        
        IO.print("Digite o valor do produto (R$): ");
        double valorProduto = scanner.nextDouble();

        IO.print("Digite o peso do pacote (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); 

        
        IO.print("Digite o endereço de destino: ");
        String destino = scanner.nextLine();

        
        IO.println("\nEscolha a modalidade de entrega:");
        IO.println("1 - Entrega Normal");
        IO.println("2 - Entrega Expressa");
        IO.println("3 - Retirada na Loja");
        IO.println("4 - Entrega Agendada");
        IO.print("Opção desejada: ");
        int opcao = scanner.nextInt();

        Entrega entregaEscolhida = null;

        
        switch (opcao) {
            case 1:
                entregaEscolhida = new EntregaNormal(destino);
                break;
            case 2:
                entregaEscolhida = new EntregaExpressa(destino);
                break;
            case 3:
                entregaEscolhida = new RetiradaNaLoja(destino);
                break;
            case 4:
                IO.print("Quantos dias à frente deseja agendar a entrega? ");
                int dias = scanner.nextInt();
                LocalDate dataAgendada = LocalDate.now().plusDays(dias);
                entregaEscolhida = new EntregaAgendada(destino, dataAgendada);
                break;
            default:
                IO.println("Opção inválida! Selecionando Entrega Normal por padrão.");
                entregaEscolhida = new EntregaNormal(destino);
                break;
        }

        
        IO.println("\nProcessando o seu pedido...\n");
        Pedido pedidoCliente = new Pedido(valorProduto, peso, entregaEscolhida);
        pedidoCliente.exibirResumo();
    }
}
