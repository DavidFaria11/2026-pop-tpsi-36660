public class ListaDeClientes {
    private Cliente[] clientes;

    public ListaDeClientes() {
        this.clientes = new Cliente[5];
    }

    public Cliente[] getClientes() {
        return clientes;
    }


    public void addCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c == null) break;
            if (c.getNif().equals(cliente.getNif())) {
                System.out.println("Erro: já existe um cliente com o NIF " + cliente.getNif() + ".");
                return;
            }
        }
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                return;
            }
        }
        System.out.println("Erro: lista de clientes sem capacidade.");
    }
}