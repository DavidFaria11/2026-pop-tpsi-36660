public class Main {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno();
        aluno1.setNome("João Silva");
        aluno1.setCidade("Braga");
        aluno1.setEmail("joao@email.com");
        aluno1.setIdade(20);
        aluno1.setNumeroCartao(1001);


        System.out.println("Informação do aluno:");
        System.out.println(aluno1);


        System.out.println("\nA adicionar notas...");
        aluno1.addNota(15.5);
        aluno1.addNota(18.0);
        aluno1.addNota(12.0);
        aluno1.addNota(16.5);
        aluno1.addNota(20.0);


        System.out.println("Tentar adicionar nota a mais:");
        aluno1.addNota(10.0);


        System.out.printf("%nMédia do aluno: %.2f%n", aluno1.obterMedia());
        System.out.printf("Melhor nota do aluno: %.2f%n", aluno1.obterMelhorNota());
    }
}