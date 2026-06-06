import java.util.Date;

public class PassagemVeiculo {
    private int cod_passagem;
    private Date dataHora_passagem;
    private String marca;
    private String matricula_veiculo;

    public PassagemVeiculo(int cod_passagem) {
        this.cod_passagem = cod_passagem;
    }

    public void setDataHora_passagem(Date data) {
        this.dataHora_passagem = data;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula_veiculo = matricula;
    }

    public int getCodPassagem() {
        return cod_passagem;
    }

    public Date getDataHora() {
        return dataHora_passagem;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula_veiculo;
    }

    @Override
    public String toString() {
        return "Passagem [cod: " + cod_passagem + " | marca: " + marca
                + " | matrícula: " + matricula_veiculo
                + " | data: " + dataHora_passagem + "]";
    }
}