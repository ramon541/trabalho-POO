package Models;

import Models.DAO.PostDAO;

public class Feed {
    private static final Post[] feed = new Post[30];

    public boolean adicionaPost(Post post) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        Feed.feed[posicaoLivre] = post;

        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < Feed.feed.length; i++) {
            if(feed[i] == null) return i;
        }

        return -1;
    }

    public static void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe nenhum post publicado.");
        } else {
            StringBuilder builder = new StringBuilder();
            for(Post post: Feed.feed) {
                if(post != null) {
                    builder.append("Conteúdo: ").append(post.getConteudoDaMensagem()).append("\n");
                    builder.append("Publicado por: ").append(post.getPessoa().getNome()).append("\n");
                }
            }

            System.out.println(builder);
        }
    }

    public static boolean ehVazio() {
        for(Post post : Feed.feed) {
            if(post != null) return false;
        }

        return true;
    }
}
