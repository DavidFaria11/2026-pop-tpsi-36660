public class Main {

    public static void main(String[] args) {

        Stand stand = new Stand();


        Veiculo v1 = new Veiculo("Toyota", "Corolla", 2019);
        v1.setPrecoInicial(22500.00);

        Veiculo v2 = new Veiculo("Toyota", "Yaris", 2020);
        v2.setPrecoInicial(18900.00);

        Veiculo v3 = new Veiculo("BMW", "Série 3", 2021);
        v3.setPrecoInicial(45000.00);

        Veiculo v4 = new Veiculo("Renault", "Clio", 2018);
        v4.setPrecoInicial(14500.00);

        Veiculo v5 = new Veiculo("Volkswagen", "Golf", 2022);
        v5.setPrecoInicial(28000.00);

        Veiculo v6 = new Veiculo("BMW", "Série 5", 2020);
        v6.setPrecoInicial(58000.00);

        Veiculo v7 = new Veiculo("Renault", "Megane", 2017);
        v7.setPrecoInicial(12000.00);


        stand.adicionarVeiculo(v1);
        stand.adicionarVeiculo(v2);
        stand.adicionarVeiculo(v3);
        stand.adicionarVeiculo(v4);
        stand.adicionarVeiculo(v5);
        stand.adicionarVeiculo(v6);
        stand.adicionarVeiculo(v7);


        System.out.println("\nQuantidade de veículos no stand: " + stand.obterQuantidadeVeiculos());


        System.out.println("\n--- Pesquisa por modelo: Golf ---");
        Veiculo encontrado = stand.obterVeiculo("Golf");
        if (encontrado != null) {
            System.out.println(encontrado);
            System.out.println("Preço atual (2025): " + String.format("%.2f€", encontrado.getPrecoVeiculo(2025)));
        } else {
            System.out.println("Veículo não encontrado.");
        }


        stand.listarVeiculos("Toyota");
        stand.listarVeiculos("BMW");


        stand.listarVeiculos("Ferrari");
    }
}