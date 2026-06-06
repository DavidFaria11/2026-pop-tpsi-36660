public class Livro extends Publicacao {
    private String autor;

    public Livro() {
        super();
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void introduzirDados(String nome, String autor) {
        super.setNome(nome);
        this.autor = autor;
    }

    @Override
    public void mostraInformacao() {
        System.out.println("=== Livro ===");
        System.out.println("Número: " + getNumeroPublicacao());
        System.out.println("Nome: " + getNome());
        System.out.println("Autor: " + autor);
    }
}