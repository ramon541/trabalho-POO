package Models.DAO;

import Models.Pessoa;
import Models.Post;

public class PessoaDAO {
    Pessoa[] pessoas = new Pessoa[10];

    public PessoaDAO(PostDAO postDAO) {

        Pessoa p1 = new Pessoa();
        p1.setNome("Admin");
        p1.setNascimento("01/01/2000");
        p1.setSexo("Masculino");
        p1.setLogin("admin");
        p1.setSenha("admin");
        p1.setTipoUsuario("admin");

        this.adicionaPessoa(p1);

        Pessoa p2 = new Pessoa();
        p2.setNome("Fulana");
        p2.setNascimento("05/05/2000");
        p2.setSexo("Feminina");
        p2.setLogin("fulana");
        p2.setSenha("fulana");
        p2.setTipoUsuario("comum");

        this.adicionaPessoa(p2);

        Post post = new Post();
        post.setConteudoDaMensagem("Post Teste");
        post.setPessoa(p1);

        postDAO.adicionaPost(post);
    }

    public boolean adicionaPessoa(Pessoa pessoa) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.pessoas[posicaoLivre] = pessoa;

        return true;
    }

    public Pessoa buscaLogin(String login, String senha) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }

        return null;
    }

    public Pessoa buscaPorNome(String nome) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getNome().equals(nome)) return p;
        }

        return null;
    }

    public boolean ehVazio() {
        for(Pessoa pessoa : this.pessoas) {
            if(pessoa != null) return false;
        }

        return true;
    }

    public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe pessoa cadastrada.");
        } else {
            StringBuilder builder = new StringBuilder();
            for(Pessoa pessoa: this.pessoas) {
                if(pessoa != null) {
                    builder.append("Nome: ").append(pessoa.getNome()).append("\n");
                }
            }

            System.out.println(builder);
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.pessoas.length; i++) {
            if(pessoas[i] == null) return i;
        }

        return -1;
    }

    public boolean remover(long id) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getId() == id) {
                p = null;
                return true;
            }
        }

        return false;
    }
}
