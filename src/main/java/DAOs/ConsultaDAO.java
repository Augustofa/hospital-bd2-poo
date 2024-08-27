
package DAOs;

import Entidades.Consulta;
import Entidades.Medico;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    // a conexão com o banco de dados
    private Connection connection;

    public ConsultaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Consulta consulta) {
        String sql = "insert into consulta "
                + "(id_paciente, id_medico, data_e_hora, diagnostico)"
                + " values (?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, consulta.getPaciente().getIdPaciente());
            stmt.setInt(2, consulta.getMedico().getIdMedico());
            stmt.setString(3, consulta.getDataEhora());
            stmt.setString(4, consulta.getDiagnostico());

            // executa
            if (!stmt.execute()) {
                System.out.println("Consulta adicionada!");
            } else {
                System.out.println("Erro na gravação!");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> getLista() {
        try {
            List<Consulta> consultas = new ArrayList<Consulta>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from consulta");
            ResultSet rs = stmt.executeQuery();
            
            PacienteDAO pDao = new PacienteDAO();
            MedicoDAO mDao = new MedicoDAO();
          

            while (rs.next()) {
                // criando o objeto Consulta
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                
                int idPaciente = rs.getInt("id_paciente");
                Paciente paciente = pDao.buscar(idPaciente);
                consulta.setPaciente(paciente);
                
                int idMedico = rs.getInt("id_medico");
                Medico medico = mDao.buscar(idMedico);
                consulta.setMedico(medico);
                
                consulta.setDataEhora(rs.getString("data_e_hora"));
                consulta.setDiagnostico(rs.getString("diagnostico"));

                // adicionando o objeto à lista
                consultas.add(consulta);
            }
            rs.close();
            stmt.close();
            return consultas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void listar() {
        System.out.println("------------ Listagem ------------");
        List<Consulta> consultas = this.getLista();
        for (Consulta c : consultas) {
            System.out.println("Id da Consulta: " + c.getIdConsulta());
            System.out.println("Paciente: " + c.getPaciente().getNome());
            System.out.println("Médico: " + c.getMedico().getNome());
            System.out.println("Data e hora: " + c.getDataEhora());
            System.out.println("Diagnostico: " + c.getDiagnostico());
            System.out.println("----------------------------------");
        }
    }

    public void alterar(Consulta consulta) {
        String sql = "update consulta set id_paciente=?, id_medico=?, data_e_hora=?, diagnostico=? where id_consulta=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, consulta.getPaciente().getIdPaciente());
            stmt.setInt(2, consulta.getMedico().getIdMedico());
            stmt.setString(3, consulta.getDataEhora());
            stmt.setString(4, consulta.getDiagnostico());
            stmt.setInt(7, consulta.getIdConsulta());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Consulta consulta) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from consulta where id=?");
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
