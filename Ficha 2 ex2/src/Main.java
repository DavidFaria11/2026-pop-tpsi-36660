import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static boolean verificaExistenciaValor(ArrayList<Publicacao> publicacoes, int numeroPublicacao) {
        for (Publicacao p : publicacoes) {
            if (p.getNumeroPublicacao() == numeroPublicacao) {
                return true;
            }
        }
        return false;
    }


    public static void menu(ArrayList<Publicacao> publicacoes, Scanner sc) {
        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar Publicação");
            System.out.println("2. Adicionar Livro");
            System.out.println("3. Adicionar Revista");
            System.out.println("4. Listar todos os elementos");
            System.out.println("5. Verificar existência por número");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    Publicacao p = new Publicacao();
                    System.out.print("Nome da publicação: ");
                    String nomeP = sc.nextLine();
                    p.introduzirDados(nomeP);
                    publicacoes.add(p);
                    System.out.println("Publicação adicionada com número " + p.getNumeroPublicacao() + ".");
                    break;

                case 2:
                    Livro l = new Livro();
                    System.out.print("Nome do livro: ");
                    String nomeL = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    l.introduzirDados(nomeL, autor);
                    publicacoes.add(l);
                    System.out.println("Livro adicionado com número " + l.getNumeroPublicacao() + ".");
                    break;

                case 3:
                    Revista r = new Revista();
                    System.out.print("Nome da revista: ");
                    String nomeR = sc.nextLine();
                    System.out.print("Número da revista: ");
                    String numR = sc.nextLine();
                    r.introduzirDados(nomeR, numR);
                    publicacoes.add(r);
                    System.out.println("Revista adicionada com número " + r.getNumeroPublicacao() + ".");
                    break;

                case 4:
                    if (publicacoes.isEmpty()) {
                        System.out.println("Não há publicações.");
                    } else {
                        System.out.println("\n--- Lista de Publicações ---");
                        for (Publicacao pub : publicacoes) {
                            pub.mostraInformacao();
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    System.out.print("Número de publicação a procurar: ");
                    int num = sc.nextInt();
                    sc.nextLine();
                    boolean existe = verificaExistenciaValor(publicacoes, num);
                    if (existe) {
                        System.out.println("Publicação com número " + num + " existe.");
                    } else {
                        System.out.println("Publicação com número " + num + " não existe.");
                    }
                    break;

                case 0:
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ArrayList<Publicacao> publicacoes = new ArrayList<>();

        Livro l1 = new Livro();
        l1.introduzirDados("O Senhor dos Anéis", "J.R.R. Tolkien");
        publicacoes.add(l1);

        Revista r1 = new Revista();
        r1.introduzirDados("National Geographic", "Edição 42");
        publicacoes.add(r1);

        Publicacao p1 = new Publicacao();
        p1.introduzirDados("Publicação Genérica");
        publicacoes.add(p1);

        Livro l2 = new Livro();
        l2.introduzirDados("Harry Potter", "J.K. Rowling");
        publicacoes.add(l2);

        System.out.println("Array inicializado com " + publicacoes.size() + " publicações.");


        menu(publicacoes, sc);

        sc.close();
    }
}