package DAOs;

import Entidades.Prescricao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescricaoDAO {
    
    
    // a conexão com o banco de dados
    private Connection connection;

    public PrescricaoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(Prescricao prescricao) {
        String sql = "insert into prescricao "
                + "(id_consulta, data_validade, categora, medicamentos, recomendacoes)"
                + " values (?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, prescricao.getConsulta().getIdConsulta());
            stmt.setString(2, prescricao.getDataDeValidade());
            stmt.setInt(3, prescricao.getCategoria());
            stmt.setString(4, prescricao.getMedicamentos());
            stmt.setString(5, prescricao.getRecomendacoes());

            // executa
            if (!stmt.execute()) {
                System.out.println("Prescrição adicionada!");
            } else {
                System.out.println("Erro na gravação!");
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prescricao> getLista() {
        try {
            List<Prescricao> prescricoes = new ArrayList<Prescricao>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from prescricao");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Prescricao
                Prescricao prescricao = new Prescricao();
                prescricao.setIdPrescricao(rs.getInt("id_prescricao"));
                prescricao.getConsulta().setIdConsulta(rs.getInt("id_consulta"));
                prescricao.setDataDeValidade(rs.getString("data_validade"));
                prescricao.setCategoria(rs.getInt("categoria"));
                prescricao.setMedicamentos(rs.getString("medicamentos"));
                prescricao.setRecomendacoes(rs.getString("recomendacoes"));

                // adicionando o objeto à lista
                prescricoes.add(prescricao);
            }
            rs.close();
            stmt.close();
            return prescricoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void listar() {
        System.out.println("------------ Listagem ------------");
        List<Prescricao> prescricoes = this.getLista();
        for (Prescricao p : prescricoes) {
            System.out.println("Id da Consulta: " + p.getIdPrescricao());
            System.out.println("Consulta: " + p.getConsulta().getIdConsulta());
            System.out.println("Data e hora: " + p.getDataDeValidade());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.println("Medicamentos: " + p.getMedicamentos());
            System.out.println("Recomendacoes: " + p.getRecomendacoes());
            System.out.println("----------------------------------");
        }
    }

    public void alterar(Prescricao prescricao) {
        String sql = "update prescricao set id_consulta=?, data_validade=?, categoria=?, medicamentos=?, recomendacoes=? where id_prescricao=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, prescricao.getConsulta().getIdConsulta());
            stmt.setString(2, prescricao.getDataDeValidade());
            stmt.setInt(3, prescricao.getCategoria());
            stmt.setString(4, prescricao.getMedicamentos());
            stmt.setString(5, prescricao.getRecomendacoes());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Prescricao prescricao) {
        try {
            PreparedStatement stmt = connection
                    .prepareStatement("delete from prescricao where id_prescricao=?");
            stmt.setInt(1, prescricao.getIdPrescricao());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
