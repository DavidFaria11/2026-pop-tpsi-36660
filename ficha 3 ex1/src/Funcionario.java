public abstract class Funcionario {
    private String nome;
    private int cod_funcionario;

    public Funcionario(String nome, int cod_funcionario) {
        this.nome = nome;
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public abstract double calculaPagamento();
}