public class FuncionarioPorHora extends Funcionario {
    private double valorHora;
    private int numHoras;

    public FuncionarioPorHora(String nome, int cod_funcionario, double valorHora) {
        super(nome, cod_funcionario);
        this.valorHora = valorHora;
        this.numHoras = 0;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(int numHoras) {
        this.numHoras = numHoras;
    }

    @Override
    public double calculaPagamento() {
        return valorHora * numHoras;
    }
}