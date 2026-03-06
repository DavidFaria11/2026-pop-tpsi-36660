public class Veiculo {

    private String marca;
    private String modelo;
    private int anoLancamento;
    private double precoInicial;


    public Veiculo() {
        marca = "";
        modelo = "";
        anoLancamento = 0;
        precoInicial = 0;
    }


    public Veiculo(String marca, String modelo, int anoLancamento) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoLancamento = anoLancamento;
        this.precoInicial = 0;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }


    @Override
    public String toString() {
        return "Marca: " + marca +
                "\nModelo: " + modelo +
                "\nAno de Lançamento: " + anoLancamento +
                "\nPreço Inicial: " + precoInicial;
    }

    public double getPrecoVeiculo(int ano) {

        int anosPassados = ano - anoLancamento;

        double preco = precoInicial * Math.pow(0.97, anosPassados);

        return preco;
    }
}
