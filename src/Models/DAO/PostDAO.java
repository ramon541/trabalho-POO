package Models.DAO;

import Models.ConnectionFactory;
import Models.Pessoa;
import Models.Post;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    PessoaDAO pessoaDAO;

    public PostDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public long adicionaPost(Post p) {
        String sql = "insert into post(pessoa, conteudoPost) values (?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(p.getPessoa().getId()));
            stmt.setString(2, p.getConteudoPost());
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

    public List<Post> buscaTodos() throws SQLException {
        String sql = "select * from post";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<Post> posts = new ArrayList<Post>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto
                Post post = new Post();
                post.setId(rs.getLong("id"));
                long idUsuario = Long.parseLong(rs.getString("pessoa"));
                post.setPessoa(pessoaDAO.buscaPorID(idUsuario));
                post.setConteudoPost(rs.getString("conteudoPost"));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                post.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                post.setDataModificacao(dataMod);

                posts.add(post);
            }
            rs.close();
            stmt.close();
            return posts;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from post where pessoa = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public List<Post> buscarPostPorIdUsuario(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            List<Post> posts = new ArrayList<>();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("id"));
                long idUsuario = Long.parseLong(rs.getString("pessoa"));
                post.setPessoa(pessoaDAO.buscaPorID(idUsuario));
                post.setConteudoPost(rs.getString("conteudoPost"));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                post.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                post.setDataModificacao(dataMod);

                posts.add(post);
            }
            rs.close();
            ps.close();

            return posts;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
