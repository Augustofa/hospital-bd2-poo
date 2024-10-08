package DAOs;

import Entidades.Medico;
import Geral.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
       // a conexão com o banco de dados
    private Connection connection;

    public MedicoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Medico medico) {
        String sql = "insert into medico "
                + "(nome, cpf, endereco, data_nasc, email, telefone, crm, especialidades)"
                + " values (?,?,?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getEndereco());
            stmt.setString(4, Utils.converteStringToSqlDate(medico.getDataNascimento()));
            stmt.setString(5, medico.getEmail());
            stmt.setString(6, medico.getTelefone());
            stmt.setString(7, medico.getCrm());
            stmt.setString(8, medico.getEspecialidades());

            // executa
            if (!stmt.execute()) {
                System.out.println("Médico adicionado!");
            } else {
                System.out.println("Erro na gravação!");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //pega no banco e passa para objeto armazenando na lista
    public List<Medico> getLista() {
        try {
            List<Medico> medicos = new ArrayList<Medico>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from medico");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Medico medico = new Medico();
                medico.setIdMedico(rs.getInt("id_medico"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setEndereco(rs.getString("endereco"));
                medico.setDataNascimento(Utils.converteSqlDateToString(rs.getString("data_nasc")));
                medico.setEmail(rs.getString("email"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setCrm(rs.getString("crm"));
                medico.setEspecialidades(rs.getString("especialidades"));

                // adicionando o objeto à lista
                medicos.add(medico);
            }
            rs.close();
            stmt.close();
            return medicos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Medico buscar(int idMedico) {
        try {
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from medico where id_medico = ?");
            stmt.setInt(1, idMedico);
            ResultSet rs = stmt.executeQuery();
            
            Medico medico = new Medico();

            while (rs.next()) {
                // criando o objeto Medico
                 
                medico.setIdMedico(rs.getInt("id_medico"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setEndereco(rs.getString("endereco"));
                medico.setDataNascimento(rs.getString("data_nasc"));
                medico.setEmail(rs.getString("email"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setCrm(rs.getString("crm"));
                medico.setEspecialidades(rs.getString("especialidades"));
            }
            rs.close();
            stmt.close();
            return medico;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void listar() {
        System.out.println("------------ Listagem ------------");
        List<Medico> medicos = this.getLista();
        for (Medico m : medicos) {
            System.out.println("ID: " + m.getIdMedico());
            System.out.println("Nome: " + m.getNome());
            System.out.println("CPF: " + m.getCpf());
            System.out.println("Endereço: " + m.getEndereco());
            System.out.println("Data de nascimento: " + m.getDataNascimento());
            System.out.println("Email: " + m.getEmail());
            System.out.println("Telefone: " + m.getTelefone());
            System.out.println("CRM: " + m.getCrm());
            System.out.println("Especialidades: " + m.getEspecialidades());
            
            System.out.println("----------------------------------");
        }
    }

    public void alterar(Medico medico) {
        String sql = "update medico set nome=?, cpf=?, endereco=?, data_nasc=? ,email=?, telefone=?, crm=?, especialidades=? where id_medico=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCpf());
            stmt.setString(3, medico.getEndereco());
            stmt.setString(4, medico.getDataNascimento());
            stmt.setString(5, medico.getEmail());
            stmt.setString(6, medico.getTelefone());
            stmt.setString(7, medico.getCrm());
            stmt.setString(8, medico.getEspecialidades());
            stmt.setInt(9, medico.getIdMedico());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Medico medico) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from medico where id_medico=?");
            stmt.setLong(1, medico.getIdMedico());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
