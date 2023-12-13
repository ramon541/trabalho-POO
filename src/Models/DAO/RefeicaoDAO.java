package Models.DAO;

import Models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import java.sql.Connection;


public class RefeicaoDAO {
    final DietaDAO dietaDAO;

    public RefeicaoDAO(DietaDAO dietaDAO) { this.dietaDAO = dietaDAO; }

    public long adicionaRefeicao(Refeicao refeicao) {
        String sql = "insert into refeicao(nomeRefeicao, dieta, carboidratos, proteinas, gorduras, calorias) values (?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, refeicao.getNomeDaRefeicao());
            stmt.setString(2, String.valueOf(refeicao.getDieta().getId()));
            stmt.setString(3, String.valueOf(refeicao.getCarboidrato()));
            stmt.setString(4, String.valueOf(refeicao.getProteina()));
            stmt.setString(5, String.valueOf(refeicao.getGordura()));
            stmt.setString(6, String.valueOf(refeicao.getCalorias()));
            stmt.execute();

            //retorna o id do objeto inserido
            ResultSet rs=stmt.getGeneratedKeys();
            int retorno=0;
            if(rs.next()){
                retorno = rs.getInt(1);
            }
            System.out.println("O id inserido foi: " + retorno);
            System.out.println("Gravado!");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from refeicao where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public Refeicao buscaRefeicaoPorId(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Refeicao refeicao = new Refeicao();
                refeicao.setId(rs.getLong("id"));
                refeicao.setNomeDaRefeicao(rs.getString("nomeRefeicao"));
                refeicao.setDieta(dietaDAO.buscaDietaPorId(rs.getLong("dieta")));
                refeicao.setCarboidrato(Double.parseDouble(rs.getString("carboidratos")));
                refeicao.setProteina(Double.parseDouble(rs.getString("proteinas")));
                refeicao.setGordura(Double.parseDouble(rs.getString("gorduras")));
                refeicao.setCalorias(Double.parseDouble(rs.getString("calorias")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                refeicao.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                refeicao.setDataModificacao(dataMod);

                return refeicao;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Refeicao> buscaUltimasRefeicoesPorDieta(long idDieta) {
        String sql = "select * from refeicao where dieta = ? order by id desc limit 4";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
             stmt.setLong(1, idDieta);
            List<Refeicao> refeicoes = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Refeicao refeicao = new Refeicao();
                refeicao.setId(rs.getLong("id"));
                refeicao.setNomeDaRefeicao(rs.getString("nomeRefeicao"));
                refeicao.setDieta(dietaDAO.buscaDietaPorId(rs.getLong("dieta")));
                refeicao.setCarboidrato(Double.parseDouble(rs.getString("carboidratos")));
                refeicao.setProteina(Double.parseDouble(rs.getString("proteinas")));
                refeicao.setGordura(Double.parseDouble(rs.getString("gorduras")));
                refeicao.setCalorias(Double.parseDouble(rs.getString("calorias")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                refeicao.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                refeicao.setDataModificacao(dataMod);

                refeicoes.add(refeicao);
            }
            rs.close();
            stmt.close();
            Collections.reverse(refeicoes);
            return refeicoes;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
