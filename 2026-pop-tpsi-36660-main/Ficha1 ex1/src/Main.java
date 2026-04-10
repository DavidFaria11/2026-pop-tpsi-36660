public class Main {

    public static void main(String[] args) {

        Veiculo v1 = new Veiculo();

        v1.setMarca("Toyota");
        v1.setModelo("Corolla");
        v1.setAnoLancamento(2020);
        v1.setPrecoInicial(25000);


        System.out.println(v1);


        double preco3anos = v1.getPrecoVeiculo(2023);

        System.out.println("\nPreço do veículo 3 anos após lançamento: " + preco3anos);
    }
}