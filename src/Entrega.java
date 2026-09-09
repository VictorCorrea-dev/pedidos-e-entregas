public abstract class Entrega {

    private String destino;

    public Entrega(String destino) {
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("O destino não pode ser nulo ou vazio!!!");
        }
        this.destino = destino;
    }

    public String getDestino() {
        return this.destino;
    }

    public abstract double calcularFrete(double peso);

    public abstract String calcularPrazo();


}
