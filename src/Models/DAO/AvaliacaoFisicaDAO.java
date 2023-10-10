package Models.DAO;

import Models.AvaliacaoFisica;
import Models.Pessoa;

public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[10];

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

}
