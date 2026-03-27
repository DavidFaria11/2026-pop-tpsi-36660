public class Empresa {
    private Funcionario[] funcionarios;

    public Empresa() {
        this.funcionarios = new Funcionario[100];
    }

    public boolean adicionarFuncionario(Funcionario f) {
        // Verificar se já existe um funcionário com o mesmo código
        for (Funcionario func : funcionarios) {
            if (func == null) break;
            if (func.getCod_funcionario() == f.getCod_funcionario()) {
                System.out.println("Erro: já existe um funcionário com o código " + f.getCod_funcionario() + ".");
                return false;
            }
        }
        // Adicionar no primeiro lugar livre
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) {
                funcionarios[i] = f;
                return true;
            }
        }
        System.out.println("Erro: empresa sem capacidade para mais funcionários.");
        return false;
    }

    public void calcularPagamentos() {
        System.out.println("=== Folha de Pagamentos ===");
        for (Funcionario f : funcionarios) {
            if (f == null) break;
            System.out.printf("%-30s (cod: %d) → %.2f€%n",
                    f.getNome(), f.getCod_funcionario(), f.calculaPagamento());
        }
    }
}