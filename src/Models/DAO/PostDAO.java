package Models.DAO;

import Models.ConnectionFactory;
import Models.Pessoa;
import Models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    Post[] posts = new Post[10];

    PessoaDAO pessoaDAO;

    public PostDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public boolean adicionaPost(Post post) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.posts[posicaoLivre] = post;

        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.posts.length; i++) {
            if(posts[i] == null) return i;
        }

        return -1;
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

    /*public void mostrarPostsUsuario(Pessoa usuario) {
        StringBuilder builder = new StringBuilder();

        builder.append("=======================").append("\n");
        builder.append("POSTS").append("\n");
        builder.append("=======================").append("\n");

        if(ehVazio()) {
            builder.append("Não existe nenhum post publicado.");
        } else {
            for(Post post : getPosts()) {
                if(post != null && post.getPessoa().equals(usuario)) {
                    builder.append("Conteúdo: ").append(post.getConteudoPost()).append("\n");
                    builder.append("Publicado por: ").append(post.getPessoa().getNome()).append("\n");
                    builder.append("=============================").append("\n");
                }
            }
        }

        System.out.println(builder);
    }*/

    public boolean ehVazio() {
        for(Post post : this.posts) {
            if(post != null) return false;
        }

        return true;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }
}
