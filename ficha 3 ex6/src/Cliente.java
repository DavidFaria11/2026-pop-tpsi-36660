public class Cliente {
    private String nome;
    private String nif;
    private IArtigo[] artigos;

    public Cliente() {
        this.artigos = new IArtigo[5];
    }

    public String getNome() {
        return this.nome;
    }

    public String getNif() {
        return this.nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean adicionaArtigo(IArtigo artigo) {
        for (int x = 0; x < this.artigos.length; x++) {
            if (this.artigos[x] == null) {
                this.artigos[x] = artigo;
                return true;
            }
        }
        return false;
    }

    public int getQtdArtigos() {
        int count = 0;
        for (IArtigo a : artigos) {
            if (a != null) count++;
        }
        return count;
    }

    public IArtigo[] getArtigos() {
        return this.artigos;
    }
}