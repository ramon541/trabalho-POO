package Models.DAO;

import Models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Connection;


public class RefeicaoDAO {
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
}
