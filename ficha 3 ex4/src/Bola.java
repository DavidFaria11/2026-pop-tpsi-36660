public abstract class Bola implements Lancavel {
    private String marca;

    public Bola(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public abstract void ressaltar();
}