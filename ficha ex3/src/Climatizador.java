public class Climatizador extends Aquecedor {
    private boolean refrigeracaoLigada;
    private Velocidade potenciaRefrigerador;

    public Climatizador() {
        super();
        this.refrigeracaoLigada = false;
        this.potenciaRefrigerador = Velocidade.BAIXA;
    }


    public Velocidade getPotenciaRefrigerador() {
        return potenciaRefrigerador;
    }

    public void setPotenciaRefrigerador(Velocidade potenciaRefrigerador) {
        this.potenciaRefrigerador = potenciaRefrigerador;
    }

    public boolean refrigeracaoLigada() {
        return refrigeracaoLigada;
    }

    public void ligarRefrigeracao() {
        this.refrigeracaoLigada = true;
        desligarAquecimento(); // liga refrigeração e desliga aquecimento
    }

    public void desligarRefrigeracao() {
        this.refrigeracaoLigada = false;
    }

    @Override
    public void ligarAquecimento() {
        super.ligarAquecimento(); // liga aquecimento
        this.refrigeracaoLigada = false; // e desliga refrigeração
    }

    @Override
    public String toString() {
        return "=== Climatizador ===" +
                "\nVentoinha ligada: " + ventoinhaLigada() +
                "\nVelocidade ventoinha: " + getVelocidadeVentoinha() +
                "\nResistência ligada: " + resistenciaLigada() +
                "\nPotência resistência: " + getPotenciaResistencia() +
                "\nRefrigeração ligada: " + refrigeracaoLigada +
                "\nPotência refrigerador: " + potenciaRefrigerador;
    }
}