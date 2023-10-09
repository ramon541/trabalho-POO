package Models.DAO;

import Models.Pessoa;
import Models.Post;
import Models.Util;

public class PostDAO {
    Post[] posts = new Post[10];

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

    /*public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe nenhum post publicado.");
        } else {
            StringBuilder builder = new StringBuilder();
            for(Post post: this.posts) {
                if(post != null) {
                    builder.append("Conteúdo: ").append(post.getConteudoDaMensagem()).append("\n");
                    builder.append("Publicado por: ").append(post.getPessoa().getNome()).append("\n");
                }
            }

            System.out.println(builder);
        }
    }*/

    public void mostrarPostsUsuario() {
        if(ehVazio()) {
            System.out.println("Não existe nenhum post publicado.");
        } else {
            for(Post post : getPosts()) {
                if(post.getPessoa().equals(Util.getPessoaLogada())) {
                    StringBuilder builder = new StringBuilder();

                    builder.append("Conteúdo: ").append(post.getConteudoDaMensagem()).append("\n");
                    builder.append("Publicado por: ").append(post.getPessoa().getNome()).append("\n");

                    System.out.println(builder);
                }
            }
        }
    }

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
