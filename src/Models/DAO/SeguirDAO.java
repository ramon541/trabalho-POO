package Models.DAO;

import Models.ConnectionFactory;
import Models.Pessoa;
import Models.Seguir;
import Models.Util;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeguirDAO {

    private final PessoaDAO pessoaDAO;

    public SeguirDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public long seguirPessoa(Pessoa seguindo) {
        String sql = "insert into seguir(pessoa, seguindo, estaSeguindo) values (?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(Util.getPessoaLogada().getId()));
            stmt.setString(2, String.valueOf(seguindo.getId()));
            stmt.setString(3, String.valueOf(1));
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
        String sql = "select * from seguir where seguindo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public List<Pessoa> buscarSeguidores(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            List<Pessoa> seguidores = new ArrayList<Pessoa>();
            while (rs.next()) {
                Seguir seguir = new Seguir();
                seguir.setId(rs.getLong("id"));
                long idPessoa = Long.parseLong(rs.getString("pessoa"));
                Pessoa seguidor = this.pessoaDAO.buscaPorID(idPessoa);
                seguir.setUsuario(seguidor);
                seguidores.add(seguidor);

                long idPessoaSeguindo = Long.parseLong(rs.getString("seguindo"));
                Pessoa pessoaSeguindo = this.pessoaDAO.buscaPorID(idPessoaSeguindo);
                seguir.setSeguindo(pessoaSeguindo);

                seguir.setEstaSeguindo(Boolean.parseBoolean(rs.getString("estaSeguindo")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                seguir.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                seguir.setDataModificacao(dataMod);
            }
            rs.close();
            ps.close();
            return seguidores;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean deixarDeSeguir(long idUsuario, long idSeguindo) {
        String sql = "update seguir set estaSeguindo = 0 where pessoa = ? and seguindo = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            stmt.setLong(2, idSeguindo);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    private PreparedStatement newPreparedStatement(Connection con, long idUsuario, long idSeguindo) throws SQLException {
        String sql = "select * from seguir where pessoa = ? and seguindo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, idUsuario);
        ps.setLong(2, idSeguindo);
        return ps;
    }

    public Seguir buscaSeguir(long idUsuario, long idSeguindo) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = newPreparedStatement(connection, idUsuario, idSeguindo);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Seguir seguir = new Seguir();
                seguir.setId(rs.getLong("id"));

                long usuarioId = Long.parseLong(rs.getString("pessoa"));
                seguir.setUsuario(this.pessoaDAO.buscaPorID(usuarioId));

                long seguindoId = Long.parseLong(rs.getString("seguindo"));
                seguir.setSeguindo(this.pessoaDAO.buscaPorID(seguindoId));

                seguir.setEstaSeguindo(Boolean.parseBoolean(rs.getString("estaSeguindo")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                seguir.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                seguir.setDataModificacao(dataMod);

                return seguir;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
