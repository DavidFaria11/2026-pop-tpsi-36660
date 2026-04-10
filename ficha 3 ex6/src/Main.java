public class Main {
    public static void main(String[] args) {


        Artigo a1 = new Artigo(1, "O Senhor dos Anéis", "Livro de J.R.R. Tolkien");
        Artigo a2 = new Artigo(2, "Harry Potter", "Livro de J.K. Rowling");
        Artigo a3 = new Artigo(3, "Clean Code", "Livro de Robert C. Martin");
        Artigo a4 = new Artigo(4, "Java para Iniciantes", "Livro de Herbert Schildt");


        Cliente c1 = new Cliente();
        c1.setNome("Ana Silva");
        c1.setNif("123456789");
        c1.adicionaArtigo(a1);
        c1.adicionaArtigo(a2);

        Cliente c2 = new Cliente();
        c2.setNome("Bruno Costa");
        c2.setNif("987654321");
        c2.adicionaArtigo(a3);

        Cliente c3 = new Cliente();
        c3.setNome("Carla Dias");
        c3.setNif("111222333");
        c3.adicionaArtigo(a4);
        c3.adicionaArtigo(a1);
        c3.adicionaArtigo(a2);


        ListaDeClientes lista = new ListaDeClientes();
        lista.addCliente(c1);
        lista.addCliente(c2);
        lista.addCliente(c3);


        Cliente cDup = new Cliente();
        cDup.setNome("Duplicado");
        cDup.setNif("123456789");
        lista.addCliente(cDup);


        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente c : lista.getClientes()) {
            if (c == null) break;
            System.out.println("Cliente: " + c.getNome() + " | NIF: " + c.getNif()
                    + " | Artigos emprestados: " + c.getQtdArtigos());
            for (IArtigo art : c.getArtigos()) {
                if (art != null) {
                    System.out.println("   - " + art);
                }
            }
        }
    }
}