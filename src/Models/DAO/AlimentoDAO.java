package Models.DAO;

import Models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {
    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from alimento where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public Alimento buscaAlimentoPorId(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setId(rs.getLong("id"));
                alimento.setNome(rs.getString("nome"));
                alimento.setCarboidratos(Double.parseDouble(rs.getString("carboidratos")));
                alimento.setProteinas(Double.parseDouble(rs.getString("proteinas")));
                alimento.setGorduras(Double.parseDouble(rs.getString("gorduras")));
                alimento.setCalorias(Double.parseDouble(rs.getString("calorias")));
                alimento.setPorcao(Double.parseDouble(rs.getString("porcao")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                alimento.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                alimento.setDataModificacao(dataMod);

                return alimento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public List<Alimento> buscaTodosAlimentos() {
        String sql = "select * from alimento";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<Alimento> alimentos = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto
                Alimento alimento = new Alimento();
                alimento.setId(rs.getLong("id"));
                alimento.setNome(rs.getString("nome"));
                alimento.setCarboidratos(Double.parseDouble(rs.getString("carboidratos")));
                alimento.setProteinas(Double.parseDouble(rs.getString("proteinas")));
                alimento.setGorduras(Double.parseDouble(rs.getString("gorduras")));
                alimento.setCalorias(Double.parseDouble(rs.getString("calorias")));
                alimento.setPorcao(Double.parseDouble(rs.getString("porcao")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                alimento.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                alimento.setDataModificacao(dataMod);

                alimentos.add(alimento);
            }
            rs.close();
            stmt.close();
            return alimentos;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
