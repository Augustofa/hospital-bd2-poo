
package DAOs;

import Entidades.Paciente;
import Geral.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    
    // a conexão com o banco de dados
    private Connection connection;

    public PacienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Paciente paciente) {
        String sql = "insert into paciente "
                + "(nome, cpf, endereco, data_nasc, email, telefone)"
                + " values (?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getEndereco());
            stmt.setString(4, Utils.converteStringToSqlDate(paciente.getDataNascimento()));
            stmt.setString(5, paciente.getEmail());
            stmt.setString(6, paciente.getTelefone());

            // executa
            if (!stmt.execute()) {
                System.out.println("Paciente adicionado!");
            } else {
                System.out.println("Erro na gravação!");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Paciente> getLista() {
        try {
            List<Paciente> pacientes = new ArrayList<Paciente>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from paciente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Paciente
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setDataNascimento(Utils.converteSqlDateToString(rs.getString("data_nasc")));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));

                // adicionando o objeto à lista
                pacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            return pacientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Paciente buscar(int idPaciente) {
        try {
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from paciente where id_paciente = ?");
            stmt.setInt(1, idPaciente);
            ResultSet rs = stmt.executeQuery();
            
            Paciente paciente = new Paciente();

            while (rs.next()) {
                // criando o objeto Paciente
                
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setDataNascimento(rs.getString("data_nasc"));
                paciente.setEmail(rs.getString("email"));
                paciente.setTelefone(rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
            return paciente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void listar() {
        System.out.println("------------ Listagem ------------");
        List<Paciente> pacientes = this.getLista();
        for (Paciente p : pacientes) {
            System.out.println("ID: " + p.getIdPaciente());
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Endereço: " + p.getEndereco());
            System.out.println("Data de nascimento: " + p.getDataNascimento());
            System.out.println("Email: " + p.getEmail());
            System.out.println("Telefone: " + p.getTelefone());
            System.out.println("----------------------------------");
        }
    }

    public void alterar(Paciente paciente) {
        String sql = "update paciente set nome=?, cpf=?, endereco=?, data_nasc=?, email=?, telefone=? where id_paciente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getEndereco());
            stmt.setString(4, paciente.getDataNascimento());
            stmt.setString(5, paciente.getEmail());
            stmt.setString(6, paciente.getTelefone());
            stmt.setInt(7, paciente.getIdPaciente());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Paciente paciente) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from paciente where id_paciente=?");
            stmt.setLong(1, paciente.getIdPaciente());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
