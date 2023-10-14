package Models.DAO;

import Models.AvaliacaoFisica;

public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[30];

    public boolean adicionaAvaliacao(AvaliacaoFisica avaliacao) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.avaliacoes[posicaoLivre] = avaliacao;

        return true;
    }

    public boolean ehVazio() {
        for(AvaliacaoFisica avaliacoes : this.avaliacoes) {
            if(avaliacoes != null) return false;
        }
        return true;
    }

    public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe avaliações fisicas cadastras");
        } else {
            String builder = "";
            for(AvaliacaoFisica avaliacaoFisica: this.avaliacoes) {
                if(avaliacaoFisica != null) {
                    builder = avaliacaoFisica + "\n";
                }
            }
            System.out.println(builder);
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.avaliacoes.length; i++) {
            if(avaliacoes[i] == null) return i;
        }
        return -1;
    }

    public AvaliacaoFisica[] procuraAvaliacoes(long id){
        AvaliacaoFisica[] avaliacoesFisicasUser = new AvaliacaoFisica[2];
        AvaliacaoFisica aux;
        for (int i = 0; i < avaliacoes.length; i++){
            if (avaliacoes[i].getPessoa().getId() == id){
                aux = avaliacoesFisicasUser[0];
                avaliacoesFisicasUser[0] = avaliacoes[i];
                avaliacoesFisicasUser[1] = aux;
            }
        }
        return avaliacoesFisicasUser;
    }

}
