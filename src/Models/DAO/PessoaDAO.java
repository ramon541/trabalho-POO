package Models.DAO;

import Models.Pessoa;

public class PessoaDAO {
    Pessoa[] pessoas = new Pessoa[10];

    public PessoaDAO() {
        Pessoa p1 = new Pessoa();
        p1.setNome("Fulano");
        p1.setSexo("Masculino");
        p1.setLogin("fulaninho");
        p1.setSenha("fulaninho");

        this.adicionaPessoa(p1);
    }

    boolean adicionaPessoa(Pessoa pessoa) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.pessoas[posicaoLivre] = pessoa;

        return true;
    }

    Pessoa buscaLogin(String login, String senha) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }

        return null;
    }

    Pessoa buscaPorNome(String nome) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getNome().equals(nome)) return p;
        }

        return null;
    }

    boolean ehVazio() {
        for(Pessoa pessoa : this.pessoas) {
            if(pessoa != null) return false;
        }

        return true;
    }

    void mostrarTodos() {
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

    boolean remover(long id) {
        for(Pessoa p : this.pessoas) {
            if(p != null && p.getId() == id) {
                p = null;
                return true;
            }
        }

        return false;
    }
}
