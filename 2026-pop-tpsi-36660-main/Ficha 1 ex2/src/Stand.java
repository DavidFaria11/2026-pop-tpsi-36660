public class Stand {


    private Veiculo[] veiculos;
    private int totalVeiculos;


    public Stand() {
        this.veiculos = new Veiculo[50];
        this.totalVeiculos = 0;
    }


    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }


    public void adicionarVeiculo(Veiculo veiculo) {
        if (totalVeiculos < veiculos.length) {
            veiculos[totalVeiculos] = veiculo;
            totalVeiculos++;
            System.out.println("Veículo adicionado: " + veiculo.getModelo());
        } else {
            System.out.println("O stand está cheio! Não é possível adicionar mais veículos.");
        }
    }


    public Veiculo obterVeiculo(String modelo) {
        for (int i = 0; i < totalVeiculos; i++) {
            if (veiculos[i].getModelo().equalsIgnoreCase(modelo)) {
                return veiculos[i];
            }
        }
        return null;
    }


    public int obterQuantidadeVeiculos() {
        return totalVeiculos;
    }


    public void listarVeiculos(String marca) {
        boolean encontrou = false;
        System.out.println("\n--- Veículos da marca \"" + marca + "\" ---");
        for (int i = 0; i < totalVeiculos; i++) {
            if (veiculos[i].getMarca().equalsIgnoreCase(marca)) {
                System.out.println(veiculos[i]);
                System.out.println("---");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("O stand não possui veículos da marca «" + marca + "»");
        }
    }
}