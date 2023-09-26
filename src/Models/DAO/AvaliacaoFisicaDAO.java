package Models.DAO;

import Models.AvaliacaoFisica;

public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[2];

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
            System.out.println("Não existe avaliação física cadastrada.");
        } else {
            StringBuilder builder = new StringBuilder();
            for(AvaliacaoFisica avaliacoes: this.avaliacoes) {
                if(avaliacoes != null) {
                    //builder.append("Nome: ").append(pessoa.getNome()).append("\n");
                    //Algoritmo de mostrar as avaliacoes fisicas
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
