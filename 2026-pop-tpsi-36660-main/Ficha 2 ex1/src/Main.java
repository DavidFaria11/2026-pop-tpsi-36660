public class Main {
    public static void main(String[] args) {


        Publicacao p = new Publicacao();
        p.introduzirDados("Publicação Genérica");
        p.mostraInformacao();
        System.out.println();


        Livro l = new Livro();
        l.introduzirDados("O Senhor dos Anéis", "J.R.R. Tolkien");
        l.mostraInformacao();
        System.out.println();


        Revista r = new Revista();
        r.introduzirDados("National Geographic", "Edição 42");
        r.mostraInformacao();
        System.out.println();


        System.out.println("Total de publicações criadas: " + Publicacao.obterQuantidadePublicacoes());
    }
}