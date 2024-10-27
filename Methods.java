public class Methods {
    public static void main(String[] args) {
        ClienteCRUD clienteCRUD = new ClienteCRUD();

        // Inserir clientes
        clienteCRUD.inserirCliente("Carlos Silva", "São Paulo");
        clienteCRUD.inserirCliente("Ana Costa", "Rio de Janeiro");
        clienteCRUD.inserirCliente("Lázaro", "Amazonas");
        // Listar clientes

        System.out.println("Lista de clientes:");
        for (String cliente : clienteCRUD.listarClientes()) {
            System.out.println(cliente);
        }

        // Atualizar cliente
        clienteCRUD.atualizarCliente("Carlos Silva", "Carlos Silva Junior", "Minas Gerais");

        // Deletar cliente
        clienteCRUD.deletarCliente("Ana Costa");
    }
}
