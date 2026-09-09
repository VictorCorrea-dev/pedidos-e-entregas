public class RetiradaNaLoja extends Entrega{

    public RetiradaNaLoja (String destino) {super(destino);}

    @Override
    public double calcularFrete(double peso) {
        return 0.0;
    }

    @Override
    public String calcularPrazo() {
        return "Retirada do produto diposnível no mesmo dia!";
    }
}
