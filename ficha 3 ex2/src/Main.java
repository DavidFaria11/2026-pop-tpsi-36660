public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();


        FuncionarioPorHora f1 = new FuncionarioPorHora("Ana Silva", 1, 12.50);
        f1.setNumHoras(160);

        FuncionarioComissao f2 = new FuncionarioComissao("Bruno Costa", 2);
        f2.setTotalVendas(8000.0);

        FuncionarioPorHoraEComissao f3 = new FuncionarioPorHoraEComissao("Carla Dias", 3, 10.0);
        f3.setNumHoras(80);
        f3.setTotalVendas(5000.0);

        FuncionarioPorHora f4 = new FuncionarioPorHora("Diogo Matos", 4, 15.0);
        f4.setNumHoras(120);


        empresa.adicionarFuncionario(f1);
        empresa.adicionarFuncionario(f2);
        empresa.adicionarFuncionario(f3);
        empresa.adicionarFuncionario(f4);


        FuncionarioPorHora fDup = new FuncionarioPorHora("Duplicado", 2, 10.0);
        empresa.adicionarFuncionario(fDup);

        System.out.println();


        empresa.calcularPagamentos();
    }
}