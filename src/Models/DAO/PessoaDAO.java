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

public class PessoaDAO {

    public PessoaDAO(PostDAO postDAO, PreferenciaDAO preferenciaDAO, AlimentoDAO alimentoDAO) {

    }

    private PreparedStatement criaConsulta(Connection con, String login, String senha) throws SQLException {
        String sql = "select * from pessoa where login = ? and senha = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        return ps;
    }

    public Pessoa buscaLogin(String login, String senha) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = criaConsulta(connection, login, senha);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pessoa elemento = new Pessoa();
                elemento.setId(rs.getLong("id"));
                elemento.setNome(rs.getString("nome"));
                elemento.setSexo(rs.getString("sexo"));
                elemento.setLogin(rs.getString("login"));
                elemento.setSenha(rs.getString("senha"));

                java.sql.Date dataNasc = rs.getDate("dataNascimento");
                LocalDate dataCriacaoDate = dataNasc.toLocalDate();
                elemento.setNascimento(dataCriacaoDate);

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                elemento.setDataCriacao(dataCriacao);

                java.sql.Date currentDateAtualizacao = rs.getDate("dataAtualizacao");
                LocalDate dataAtualizacao = currentDateAtualizacao.toLocalDate();
                elemento.setDataModificacao(dataAtualizacao);
                return elemento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public long adicionaPessoa(Pessoa p) {
        String sql = "insert into pessoa(nome, sexo, dataNascimento, login, senha) values (?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSexo());
            stmt.setString(3, String.valueOf(p.getNascimento()));
            stmt.setString(4, p.getLogin());
            stmt.setString(5, p.getSenha());
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

    public List<Pessoa> buscaTodos() throws SQLException {
        String sql = "select * from pessoa";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto
                Pessoa elemento = new Pessoa();
                elemento.setId(rs.getLong("id"));
                elemento.setNome(rs.getString("nome"));
                elemento.setSexo(rs.getString("sexo"));
                elemento.setNascimento(LocalDate.parse(rs.getString("dataNascimento")));
                elemento.setLogin(rs.getString("login"));
                elemento.setSenha(rs.getString("senha"));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                elemento.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                elemento.setDataModificacao(dataMod);

                pessoas.add(elemento);
            }
            rs.close();
            stmt.close();
            return pessoas;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from pessoa where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public Pessoa buscaPorID(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pessoa elemento = new Pessoa();
                elemento.setId(rs.getLong("id"));
                elemento.setNome(rs.getString("nome"));
                elemento.setSexo(rs.getString("sexo"));
                elemento.setNascimento(LocalDate.parse(rs.getString("dataNascimento")));
                elemento.setLogin(rs.getString("login"));
                elemento.setSenha(rs.getString("senha"));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                elemento.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                elemento.setDataModificacao(dataMod);

                return elemento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
