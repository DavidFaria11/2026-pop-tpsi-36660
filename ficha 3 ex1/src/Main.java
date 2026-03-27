public class Main {
    public static void main(String[] args) {


        FuncionarioPorHora f1 = new FuncionarioPorHora("Ana Silva", 1, 12.50);
        f1.setNumHoras(160);
        System.out.println("=== Funcionário Por Hora ===");
        System.out.println("Nome: " + f1.getNome());
        System.out.println("Código: " + f1.getCod_funcionario());
        System.out.println("Horas: " + f1.getNumHoras());
        System.out.println("Valor/hora: " + f1.getValorHora() + "€");
        System.out.printf("Pagamento: %.2f€%n%n", f1.calculaPagamento());


        FuncionarioComissao f2 = new FuncionarioComissao("Bruno Costa", 2);
        f2.setTotalVendas(8000.0);
        System.out.println("=== Funcionário Por Comissão ===");
        System.out.println("Nome: " + f2.getNome());
        System.out.println("Código: " + f2.getCod_funcionario());
        System.out.println("Total vendas: " + f2.getTotalVendas() + "€");
        System.out.printf("Pagamento (15%%): %.2f€%n%n", f2.calculaPagamento());


        FuncionarioPorHoraEComissao f3 = new FuncionarioPorHoraEComissao("Carla Dias", 3, 10.0);
        f3.setNumHoras(80);
        f3.setTotalVendas(5000.0);
        System.out.println("=== Funcionário Por Hora e Comissão ===");
        System.out.println("Nome: " + f3.getNome());
        System.out.println("Código: " + f3.getCod_funcionario());
        System.out.println("Horas: " + f3.getNumHoras());
        System.out.println("Valor/hora: " + f3.getValorHora() + "€");
        System.out.println("Total vendas: " + f3.getTotalVendas() + "€");
        System.out.printf("Pagamento: %.2f€%n", f3.calculaPagamento());
    }
}