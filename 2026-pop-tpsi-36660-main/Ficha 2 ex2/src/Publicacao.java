public class Publicacao {
    private String nome;
    private static int quantidadePublicacoes = 0;
    private int numeroPublicacao;

    public Publicacao() {
        this.numeroPublicacao = quantidadePublicacoes;
        quantidadePublicacoes++;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroPublicacao() {
        return numeroPublicacao;
    }

    public static int obterQuantidadePublicacoes() {
        return quantidadePublicacoes;
    }

    public void introduzirDados(String nome) {
        this.nome = nome;
    }

    public void mostraInformacao() {
        System.out.println("=== Publicação ===");
        System.out.println("Número: " + numeroPublicacao);
        System.out.println("Nome: " + nome);
    }
}