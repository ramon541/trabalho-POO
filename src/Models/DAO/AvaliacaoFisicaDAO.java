package Models.DAO;

import Models.AvaliacaoFisica;
import Models.ConnectionFactory;
import Models.Pessoa;
import Models.Util;

import java.sql.*;
import java.time.LocalDate;

public class AvaliacaoFisicaDAO {

    final PessoaDAO pessoaDAO;

    public AvaliacaoFisicaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public long adicionaAvaliacao(AvaliacaoFisica af) {
        String sql = "insert into avaliacaofisica(pessoa, taxaAtividade, peso, altura, idade, pescoco, cintura, quadril, imc, tmb, bodyFat, massaGorda, massaMagra) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(af.getPessoa().getId()));
            stmt.setString(2, String.valueOf(af.getFatorTaxaAtividade()));
            stmt.setString(3, String.valueOf(af.getPeso()));
            stmt.setString(4, String.valueOf(af.getAltura()));
            stmt.setString(5, String.valueOf(af.getIdade()));
            stmt.setString(6, String.valueOf(af.getPescoco()));
            stmt.setString(7, String.valueOf(af.getCintura()));
            stmt.setString(8, String.valueOf(af.getQuadril()));
            stmt.setString(9, String.valueOf(af.getImc()));
            stmt.setString(10, String.valueOf(af.getTmb()));
            stmt.setString(11, String.valueOf(af.getBodyFat()));
            stmt.setString(12, String.valueOf(af.getMassaGorda()));
            stmt.setString(13, String.valueOf(af.getMassaMagra()));
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
            throw new RuntimeException("Não foi possível inserir a avaliação física!" + e);
        }
    }

    private PreparedStatement createPreparedStatementLast(Connection con, long id) throws SQLException {
        String sql = "select * from avaliacaofisica where id = ? order by id desc limit 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public AvaliacaoFisica buscaUltimaAvaliacao(long idUsuario) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatementLast(connection, idUsuario);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
                avaliacaoFisica.setId(rs.getLong("id"));
                long pessoaId = Long.parseLong(rs.getString("pessoa"));
                avaliacaoFisica.setPessoa(pessoaDAO.buscaPorID(pessoaId));
                avaliacaoFisica.setFatorTaxaAtividade(Double.parseDouble(rs.getString("taxaAtividade")));
                avaliacaoFisica.setPeso(Double.parseDouble(rs.getString("peso")));
                avaliacaoFisica.setAltura(Double.parseDouble(rs.getString("altura")));
                avaliacaoFisica.setIdade(Integer.parseInt(rs.getString("idade")));
                avaliacaoFisica.setPescoco(Integer.parseInt(rs.getString("pescoco")));
                avaliacaoFisica.setCintura(Integer.parseInt(rs.getString("cintura")));
                avaliacaoFisica.setQuadril(Integer.parseInt(rs.getString("quadril")));
                avaliacaoFisica.setImc(Double.parseDouble(rs.getString("imc")));
                avaliacaoFisica.setTmb(Double.parseDouble(rs.getString("tmb")));
                avaliacaoFisica.setBodyFat(Double.parseDouble(rs.getString("bodyFat")));
                avaliacaoFisica.setMassaGorda(Double.parseDouble(rs.getString("massaGorda")));
                avaliacaoFisica.setMassaMagra(Double.parseDouble(rs.getString("massaMagra")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                avaliacaoFisica.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataModificacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                avaliacaoFisica.setDataModificacao(dataMod);

                return avaliacaoFisica;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a última avaliação física!" + e);
        }
        return null;
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from avaliacaofisica where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    public AvaliacaoFisica buscaAvaliacao(long idAvaliacao) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, idAvaliacao);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
                avaliacaoFisica.setId(rs.getLong("id"));
                long pessoaId = Long.parseLong(rs.getString("pessoa"));
                avaliacaoFisica.setPessoa(pessoaDAO.buscaPorID(pessoaId));
                avaliacaoFisica.setFatorTaxaAtividade(Double.parseDouble(rs.getString("taxaAtividade")));
                avaliacaoFisica.setPeso(Double.parseDouble(rs.getString("peso")));
                avaliacaoFisica.setAltura(Double.parseDouble(rs.getString("altura")));
                avaliacaoFisica.setIdade(Integer.parseInt(rs.getString("idade")));
                avaliacaoFisica.setPescoco(Integer.parseInt(rs.getString("pescoco")));
                avaliacaoFisica.setCintura(Integer.parseInt(rs.getString("cintura")));
                avaliacaoFisica.setQuadril(Integer.parseInt(rs.getString("quadril")));
                avaliacaoFisica.setImc(Double.parseDouble(rs.getString("imc")));
                avaliacaoFisica.setTmb(Double.parseDouble(rs.getString("tmb")));
                avaliacaoFisica.setBodyFat(Double.parseDouble(rs.getString("bodyFat")));
                avaliacaoFisica.setMassaGorda(Double.parseDouble(rs.getString("massaGorda")));
                avaliacaoFisica.setMassaMagra(Double.parseDouble(rs.getString("massaMagra")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                avaliacaoFisica.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataModificacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                avaliacaoFisica.setDataModificacao(dataMod);

                return avaliacaoFisica;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a última avaliação física!" + e);
        }
        return null;
    }

}
