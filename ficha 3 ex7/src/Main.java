import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Portagem portagem = new Portagem();

        PassagemVeiculo p1 = new PassagemVeiculo(1);
        p1.setMarca("Toyota");
        p1.setMatricula("AA-00-AA");
        p1.setDataHora_passagem(new Date(2025 - 1900, 3, 10, 9, 0, 0)); // 10/04/2025

        PassagemVeiculo p2 = new PassagemVeiculo(2);
        p2.setMarca("Renault");
        p2.setMatricula("BB-11-BB");
        p2.setDataHora_passagem(new Date(2025 - 1900, 3, 10, 11, 30, 0)); // 10/04/2025

        PassagemVeiculo p3 = new PassagemVeiculo(3);
        p3.setMarca("BMW");
        p3.setMatricula("CC-22-CC");
        p3.setDataHora_passagem(new Date(2025 - 1900, 3, 11, 8, 0, 0)); // 11/04/2025


        PassagemVeiculoPesado pp1 = new PassagemVeiculoPesado(4);
        pp1.setMarca("Volvo");
        pp1.setMatricula("DD-33-DD");
        pp1.setDataHora_passagem(new Date(2025 - 1900, 3, 10, 14, 0, 0)); // 10/04/2025
        pp1.setNumEixos(4);

        PassagemVeiculoPesado pp2 = new PassagemVeiculoPesado(5);
        pp2.setMarca("Volvo");
        pp2.setMatricula("EE-44-EE");
        pp2.setDataHora_passagem(new Date(2025 - 1900, 3, 10, 16, 0, 0)); // 10/04/2025
        pp2.setNumEixos(6);


        portagem.adicionarPassagem(p1);
        portagem.adicionarPassagem(p2);
        portagem.adicionarPassagem(p3);
        portagem.adicionarPassagem(pp1);
        portagem.adicionarPassagem(pp2);


        Date dia10 = new Date(2025 - 1900, 3, 10);

        System.out.println("=== Portagem ===");
        System.out.println("Total passagens a 10/04/2025: "
                + portagem.getQuantidadePassagensData(dia10));
        System.out.println("Passagens pesados a 10/04/2025: "
                + portagem.getQuantidadePassagensPesadosData(dia10));
        System.out.println("Passagens pesados marca Volvo: "
                + portagem.getQuantidadePassagensPesadosMarca("Volvo"));
    }
}