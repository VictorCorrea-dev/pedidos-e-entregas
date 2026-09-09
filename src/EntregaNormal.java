public class EntregaNormal extends Entrega {

    public EntregaNormal(String destino) {
        super(destino);
    }

    @Override
    public double calcularFrete(double peso) {
        return (peso * 4.0);
    }

    @Override
    public String calcularPrazo() {
        return "7 dias";
    }

}
