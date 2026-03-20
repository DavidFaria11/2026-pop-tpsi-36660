public class Revista extends Publicacao {
    private String nome;
    private String numeroRevista;

    public Revista() {
        super();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        super.setNome(nome);
    }

    public String getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(String numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public void introduzirDados(String nome, String numeroRevista) {
        this.setNome(nome);
        this.numeroRevista = numeroRevista;
    }

    @Override
    public void mostraInformacao() {
        System.out.println("=== Revista ===");
        System.out.println("Número de Publicação: " + getNumeroPublicacao());
        System.out.println("Nome: " + nome);
        System.out.println("Número da Revista: " + numeroRevista);
    }
}