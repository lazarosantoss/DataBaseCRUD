import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseQuerry {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/banco_ficticio";
        String user = "postgres";
        String password = "senha";

        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultado = null;

        try {
            conexao = DriverManager.getConnection(url, user, password);
            consulta = conexao.createStatement();
            String sql = "SELECT nome FROM clientes WHERE estado = 'Sergipe'";
            resultado = consulta.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("Nome do cliente: " + resultado.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Banco de dados inexistente ou não encontrado.");
        } finally {
            try {
                if (resultado != null)
                    resultado.close();
                if (consulta != null)
                    consulta.close();
                if (conexao != null)
                    conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão.");
            }
        }
    }
}
