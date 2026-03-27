public class FuncionarioPorHoraEComissao extends FuncionarioPorHora {
    private static final double COMISSAO = 0.15;
    private double totalVendas;

    public FuncionarioPorHoraEComissao(String nome, int cod_funcionario, double valorHora) {
        super(nome, cod_funcionario, valorHora);
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
        return super.calculaPagamento() + (totalVendas * COMISSAO);
    }
}