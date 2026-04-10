public class Livro extends Publicacao {
    private String nome;
    private String autor;

    public Livro() {
        super();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        super.setNome(nome);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void introduzirDados(String nome, String autor) {
        this.setNome(nome);
        this.autor = autor;
    }

    @Override
    public void mostraInformacao() {
        System.out.println("=== Livro ===");
        System.out.println("Número: " + getNumeroPublicacao());
        System.out.println("Nome: " + nome);
        System.out.println("Autor: " + autor);
    }
}