package Models.DAO;

import Models.ConnectionFactory;
import Models.Dieta;
import Models.Pessoa;
import Models.TipoDieta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TipoDietaDAO {

    public List<TipoDieta> buscaTiposDieta() throws SQLException {
        String sql = "select * from tipodieta";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<TipoDieta> tiposDieta = new ArrayList<TipoDieta>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto
                TipoDieta tipoDieta = new TipoDieta();
                tipoDieta.setId(rs.getLong("id"));
                tipoDieta.setNome(rs.getString("nome"));
                tipoDieta.setCarboidrato(Double.parseDouble(rs.getString("carboidrato")));
                tipoDieta.setProteina(Double.parseDouble(rs.getString("proteina")));
                tipoDieta.setGordura(Double.parseDouble(rs.getString("gordura")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                tipoDieta.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                tipoDieta.setDataModificacao(dataMod);

                tiposDieta.add(tipoDieta);
            }
            rs.close();
            stmt.close();
            return tiposDieta;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from tipodieta where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public TipoDieta buscaTipoDietaPorId(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoDieta tipoDieta = new TipoDieta();
                tipoDieta.setId(rs.getLong("id"));
                tipoDieta.setNome(rs.getString("nome"));
                tipoDieta.setCarboidrato(Double.parseDouble(rs.getString("carboidrato")));
                tipoDieta.setProteina(Double.parseDouble(rs.getString("proteina")));
                tipoDieta.setGordura(Double.parseDouble(rs.getString("gordura")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                tipoDieta.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                tipoDieta.setDataModificacao(dataMod);

                return tipoDieta;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
