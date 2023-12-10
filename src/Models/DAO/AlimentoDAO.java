package Models.DAO;

import Models.Alimento;
import Models.AvaliacaoFisica;
import Models.ConnectionFactory;
import Models.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[25];

    public AlimentoDAO() {
    }

    public Alimento buscaPorNome(String nomeAlimento) {
        if (!this.ehVazio()) {
            for (Alimento alimento : this.alimentos) {
                if (alimento != null && alimento.getNome().equals(nomeAlimento)) {
                    return alimento;
                }
            }
        }

        return null;
    }

    public boolean adicionaAlimento(Alimento alimento) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.alimentos[posicaoLivre] = alimento;

        return true;
    }

    public boolean ehVazio() {
        for(Alimento alimento : this.alimentos) {
            if(alimento != null) return false;
        }
        return true;
    }

    public List<Alimento> buscaTodosAlimentos() throws SQLException {
        String sql = "select * from alimento";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<Alimento> alimentos = new ArrayList<Alimento>();
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

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.alimentos.length; i++) {
            if(alimentos[i] == null) return i;
        }
        return -1;
    }
}
