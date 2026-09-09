public class EntregaExpressa extends Entrega {

    public EntregaExpressa(String destino) {
        super(destino);
    }

    @Override
    public double calcularFrete(double peso) {
        return (peso * 10) + 10;
    }

    @Override
    public String calcularPrazo() {
        return "2 dias!";
    }
}
