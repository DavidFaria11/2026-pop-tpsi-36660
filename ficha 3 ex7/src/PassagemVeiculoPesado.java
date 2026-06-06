public class PassagemVeiculoPesado extends PassagemVeiculo {
    private int num_eixos;

    public PassagemVeiculoPesado(int cod_passagem) {
        super(cod_passagem);
    }

    public int getNumEixos() {
        return num_eixos;
    }

    public void setNumEixos(int num_eixos) {
        this.num_eixos = num_eixos;
    }

    @Override
    public String toString() {
        return super.toString() + " | eixos: " + num_eixos + "]".replace("]]", "]");
    }
}