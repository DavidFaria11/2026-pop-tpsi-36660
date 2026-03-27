public class Aquecedor extends Ventoinha {
    private boolean resistenciaLigada;
    private Velocidade potenciaResistencia;

    public Aquecedor() {
        super();
        this.resistenciaLigada = false;
        this.potenciaResistencia = Velocidade.BAIXA;
    }


    public Velocidade getPotenciaResistencia() {
        return potenciaResistencia;
    }

    public void setPotenciaResistencia(Velocidade potenciaResistencia) {
        this.potenciaResistencia = potenciaResistencia;
    }

    public boolean resistenciaLigada() {
        return resistenciaLigada;
    }

    public void ligarAquecimento() {
        this.resistenciaLigada = true;
    }

    public void desligarAquecimento() {
        this.resistenciaLigada = false;
    }

    @Override
    public String toString() {
        return "=== Aquecedor ===" +
                "\nVentoinha ligada: " + ventoinhaLigada() +
                "\nVelocidade ventoinha: " + getVelocidadeVentoinha() +
                "\nResistência ligada: " + resistenciaLigada +
                "\nPotência resistência: " + potenciaResistencia;
    }
}