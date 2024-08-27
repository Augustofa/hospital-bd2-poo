
package DAOs;

import Entidades.Paciente;
import Entidades.Prontuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDAO {

    // a conexão com o banco de dados
    private Connection connection;

    public ProntuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Prontuario prontuario) {
        String sql = "insert into prontuario "
                + "(id_paciente, tipo_sanguineo, sexo, profissao, alergias, doencas, med_continuo, cir_previas)"
                + " values (?,?,?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, prontuario.getPaciente().getIdPaciente());
            stmt.setString(2, prontuario.getTipoSanguineo());
            stmt.setString(3, String.valueOf(prontuario.getSexo()));
            stmt.setString(4, prontuario.getProfissao());
            stmt.setString(5, prontuario.getAlergias());
            stmt.setString(6, prontuario.getDoencas());
            stmt.setString(7, prontuario.getMedContinuo());
            stmt.setString(8, prontuario.getCirPrevia());

            // executa
            if (!stmt.execute()) {
                System.out.println("Prontuário adicionado!");
            } else {
                System.out.println("Erro na gravação!");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prontuario> getLista() {
        try {
            List<Prontuario> prontuarios = new ArrayList<Prontuario>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from prontuario");
            ResultSet rs = stmt.executeQuery();

            PacienteDAO pDao = new PacienteDAO();
            while (rs.next()) {
                // criando o objeto Prontuário
                Prontuario prontuario = new Prontuario();
                prontuario.setIdProntuario(rs.getInt("id_prontuario"));
                int idPaciente = rs.getInt("id_paciente");
                
                Paciente paciente = pDao.buscar(idPaciente);
                prontuario.setPaciente(paciente);
                prontuario.setTipoSanguineo(rs.getString("tipo_sanguineo"));
                prontuario.setSexo(rs.getString("sexo").charAt(0));
                prontuario.setProfissao(rs.getString("profissao"));
                prontuario.setAlergias(rs.getString("alergias"));
                prontuario.setDoencas(rs.getString("doencas"));
                prontuario.setMedContinuo(rs.getString("med_continuo"));
                prontuario.setCirPrevia(rs.getString("cir_previas"));

                // adicionando o objeto à lista
                prontuarios.add(prontuario);
            }
            rs.close();
            stmt.close();
            return prontuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void listar() {
        System.out.println("------------ Listagem ------------");
        List<Prontuario> prontuarios = this.getLista();
        for (Prontuario p : prontuarios) {
            System.out.println("Id do Prontuário: " + p.getIdProntuario());
            System.out.println("Paciente: " + p.getPaciente().getNome());
            System.out.println("Tipo Sanguíneo: " + p.getTipoSanguineo());
            System.out.println("Sexo: " + p.getSexo());
            System.out.println("Profissão: " + p.getProfissao());
            System.out.println("Alergias: " + p.getAlergias());
            System.out.println("Doenças: " + p.getDoencas());
            System.out.println("Medicamentos de  uso contínuo: " + p.getMedContinuo());
            System.out.println("Cirurgias Prévias: " + p.getCirPrevia());
            System.out.println("----------------------------------");
        }
    }

    public void alterar(Prontuario prontuario) {
        String sql = "update prontuario set id_paciente=?, tipo_sanguineo=?, sexo=?, profissao=?, alergias=?, doencas=?, med_continuo=?, cir_previas=? where id_prontuario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, prontuario.getPaciente().getIdPaciente());
            stmt.setString(2, prontuario.getTipoSanguineo());
            stmt.setString(3, String.valueOf(prontuario.getSexo()));
            stmt.setString(4, prontuario.getProfissao());
            stmt.setString(5, prontuario.getAlergias());
            stmt.setString(6, prontuario.getDoencas());
            stmt.setString(7, prontuario.getMedContinuo());
            stmt.setString(8, prontuario.getCirPrevia());
            stmt.setInt(9, prontuario.getIdProntuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Prontuario prontuario) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from prontuario where id_prontuario=?");
            stmt.setInt(1, prontuario.getIdProntuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
