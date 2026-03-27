public class Ventoinha {
    private boolean ventoinhaLigada;
    private Velocidade velocidadeVentoinha;

    public Ventoinha() {
        this.ventoinhaLigada = false;
        this.velocidadeVentoinha = Velocidade.BAIXA;
    }


    public Velocidade getVelocidadeVentoinha() {
        return velocidadeVentoinha;
    }

    public void setVelocidadeVentoinha(Velocidade velocidadeVentoinha) {
        this.velocidadeVentoinha = velocidadeVentoinha;
    }

    public boolean ventoinhaLigada() {
        return ventoinhaLigada;
    }

    public void ligar() {
        this.ventoinhaLigada = true;
    }

    public void desligar() {
        this.ventoinhaLigada = false;
    }

    @Override
    public String toString() {
        return "=== Ventoinha ===" +
                "\nLigada: " + ventoinhaLigada +
                "\nVelocidade: " + velocidadeVentoinha;
    }
}