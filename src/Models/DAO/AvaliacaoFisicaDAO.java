package Models.DAO;

import Models.AvaliacaoFisica;

public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[2];

    public void adicionaAvaliacao(AvaliacaoFisica avaliacao) {
        AvaliacaoFisica avaliacaoAntiga = avaliacoes[0];
        avaliacoes[0] = avaliacao;
        avaliacoes[1] = avaliacaoAntiga;
    }

    public boolean ehVazio() {
        for(AvaliacaoFisica avaliacoes : this.avaliacoes) {
            if(avaliacoes != null) return false;
        }
        return true;
    }

    public String mostrarTodos() {
        String builder = "";
        if(ehVazio()) {
            builder+= "\nNão existe avaliação física cadastrada.\n\n";
        } else {
            builder += "----------- ÚLTIMA AVALIAÇÃO FÍSICA -----------\n" +
            avaliacoes[0].toString() + "\n" +
            "------------------------------------------------\n" +
            "\n---------- AVALIAÇÃO FÍSICA ANTERIOR ----------\n";

            if (avaliacoes[1] == null){
                builder += "SEM REGISTRO!\n";
            } else {
                builder += avaliacoes[1].toString() + "\n";
            }
            builder += "------------------------------------------------\n\n";
        }
        return builder;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.avaliacoes.length; i++) {
            if(avaliacoes[i] == null) return i;
        }
        return -1;
    }

}
