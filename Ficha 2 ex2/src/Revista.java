public class Revista extends Publicacao {
    private String numeroRevista;

    public Revista() {
        super();
    }


    public String getNumeroRevista() {
        return numeroRevista;
    }

    public void setNumeroRevista(String numeroRevista) {
        this.numeroRevista = numeroRevista;
    }

    public void introduzirDados(String nome, String numeroRevista) {
        super.setNome(nome);
        this.numeroRevista = numeroRevista;
    }

    @Override
    public void mostraInformacao() {
        System.out.println("=== Revista ===");
        System.out.println("Número de Publicação: " + getNumeroPublicacao());
        System.out.println("Nome: " + getNome());
        System.out.println("Número da Revista: " + numeroRevista);
    }
}