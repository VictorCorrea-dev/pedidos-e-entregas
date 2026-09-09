import java.time.LocalDate;

public class EntregaAgendada extends Entrega {

    private LocalDate dataAgendada;

    public EntregaAgendada(String destino, LocalDate dataAgendada) {
        super(destino);

        if (dataAgendada == null || dataAgendada.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Não foi possível realizar o agendamento!");
        }

        this.dataAgendada = dataAgendada;
    }

    @Override
    public double calcularFrete(double peso) {
        return (peso * 6) + 15.0;
    }

    @Override
    public String calcularPrazo() {
        return "Agendado para: " + this.dataAgendada;
    }
}
