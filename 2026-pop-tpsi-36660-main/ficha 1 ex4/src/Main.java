public class Main {

    public static void main(String[] args) {

        UnidadeCurricular uc = new UnidadeCurricular();


        Aluno a1 = new Aluno("João Silva", "Braga", "joao@email.com", 20, 1001);
        a1.addNota(15.5);
        a1.addNota(18.0);
        a1.addNota(12.0);

        Aluno a2 = new Aluno("Maria Santos", "Porto", "maria@email.com", 22, 1002);
        a2.addNota(14.0);
        a2.addNota(17.5);
        a2.addNota(19.0);

        Aluno a3 = new Aluno("Carlos Pereira", "Lisboa", "carlos@email.com", 21, 1003);
        a3.addNota(19.0);
        a3.addNota(18.5);
        a3.addNota(20.0);

        Aluno a4 = new Aluno("Ana Costa", "Viana", "ana@email.com", 23, 1004);
        a4.addNota(19.0);
        a4.addNota(18.5);
        a4.addNota(20.0); // mesma média que a3, mas cartão mais alto → a3 vence


        System.out.println("---Adicionar Alunos---");
        uc.adicionarAluno(a1);
        uc.adicionarAluno(a2);
        uc.adicionarAluno(a3);
        uc.adicionarAluno(a4);


        System.out.println("\n--- Teste Duplicado (cartão 1002) ---");
        uc.adicionarAluno(new Aluno("Duplicado", "Porto", "dup@email.com", 20, 1002));


        System.out.println("\n---Listar Alunos---");
        uc.listarAlunos();


        System.out.println("\n--- Obter Aluno com cartão 1003 ---");
        Aluno encontrado = uc.obterAluno(1003);
        if (encontrado != null) {
            System.out.println(encontrado);
        }

        System.out.println("\n--- Aluno com Melhor Média ---");
        Aluno melhor = uc.obterAlunoMelhorMedia();
        if (melhor != null) {
            System.out.printf("%s - Média: %.2f%n", melhor.getNome(), melhor.obterMedia());
        }
    }
}