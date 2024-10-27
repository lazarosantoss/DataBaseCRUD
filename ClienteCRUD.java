import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {

    public void inserirCliente(String nome, String estado) {
        String sql = "INSERT INTO clientes (nome, estado) VALUES (?, ?)";

        try (Connection conexao = DatabaseConnection.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, estado);
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public List<String> listarClientes() {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT nome FROM clientes";

        try (Connection conexao = DatabaseConnection.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                clientes.add(rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    public void atualizarCliente(String nomeAtual, String novoNome, String novoEstado) {
        String sql = "UPDATE clientes SET nome = ?, estado = ? WHERE nome = ?";

        try (Connection conexao = DatabaseConnection.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setString(2, novoEstado);
            stmt.setString(3, nomeAtual);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void deletarCliente(String nome) {
        String sql = "DELETE FROM clientes WHERE nome = ?";

        try (Connection conexao = DatabaseConnection.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}
