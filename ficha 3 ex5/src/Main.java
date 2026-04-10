import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        Aluno[] alunos = {
                new Aluno("Carlos", "Silva", 22),
                new Aluno("Ana", "Costa", 19),
                new Aluno("Bruno", "Matos", 25),
                new Aluno("Diana", "Ferreira", 20),
                new Aluno("Eduardo", "Alves", 18)
        };


        Arrays.sort(alunos);
        System.out.println("=== Ordenados por Idade ===");
        for (Aluno a : alunos) {
            System.out.println(a);
        }


        Arrays.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getPrimeiroNome().compareTo(a2.getPrimeiroNome());
            }
        });
        System.out.println("\n=== Ordenados por Primeiro Nome ===");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }
}