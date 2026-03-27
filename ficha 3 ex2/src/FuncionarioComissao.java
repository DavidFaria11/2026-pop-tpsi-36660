public class FuncionarioComissao extends Funcionario {
    private static final double COMISSAO = 0.15;
    private double totalVendas;

    public FuncionarioComissao(String nome, int cod_funcionario) {
        super(nome, cod_funcionario);
        this.totalVendas = 0;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    @Override
    public double calculaPagamento() {
        return totalVendas * COMISSAO;
    }
}