import java.util.Date;

public class Portagem {
    private PassagemVeiculo[] passagens;

    public Portagem() {
        this.passagens = new PassagemVeiculo[100];
    }

    public boolean adicionarPassagem(PassagemVeiculo passagem) {
        for (int i = 0; i < passagens.length; i++) {
            if (passagens[i] == null) {
                passagens[i] = passagem;
                return true;
            }
        }
        System.out.println("Erro: portagem sem capacidade para mais passagens.");
        return false;
    }

    public int getQuantidadePassagensData(Date data) {
        int count = 0;
        for (PassagemVeiculo p : passagens) {
            if (p == null) break;
            if (p.getDataHora() != null && isMesmaData(p.getDataHora(), data)) {
                count++;
            }
        }
        return count;
    }

    public int getQuantidadePassagensPesadosData(Date data) {
        int count = 0;
        for (PassagemVeiculo p : passagens) {
            if (p == null) break;
            if (p instanceof PassagemVeiculoPesado && isMesmaData(p.getDataHora(), data)) {
                count++;
            }
        }
        return count;
    }

    public int getQuantidadePassagensPesadosMarca(String marca) {
        int count = 0;
        for (PassagemVeiculo p : passagens) {
            if (p == null) break;
            if (p instanceof PassagemVeiculoPesado && p.getMarca().equalsIgnoreCase(marca)) {
                count++;
            }
        }
        return count;
    }


    private boolean isMesmaData(Date d1, Date d2) {
        return d1.getDate() == d2.getDate()
                && d1.getMonth() == d2.getMonth()
                && d1.getYear() == d2.getYear();
    }
}