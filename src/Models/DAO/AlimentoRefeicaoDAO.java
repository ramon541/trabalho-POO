package Models.DAO;

import Models.AlimentoRefeicao;
import Models.AvaliacaoFisica;
import Models.Preferencia;

import java.util.Random;

public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentoRefeicaoList = new AlimentoRefeicao[20];

    public boolean adicionaAlimentoRefeicao(AlimentoRefeicao alimentoRefeicao) {
        int posicaoLivre = this.proximaPosicaoLivre();

        if(posicaoLivre == -1) {
            return false;
        }

        this.alimentoRefeicaoList[posicaoLivre] = alimentoRefeicao;

        return true;
    }

    public double calcularQtdCaloriasPorRefeicao(double caloriasTotaisDieta, int nroRefeicoes) {
        return caloriasTotaisDieta / nroRefeicoes;
    }

    public int gerarNumeroAleatorio(int qtdAlimentosCadastrados) {
        return new Random().nextInt(qtdAlimentosCadastrados + 1);
    }

    public boolean gerarRefeicoesAutomaticas(Preferencia[] alimentosPreferidos) {
        return true;
    }

    public boolean ehVazio() {
        for(AlimentoRefeicao alimentoRefeicao : this.alimentoRefeicaoList) {
            if(alimentoRefeicao != null) return false;
        }
        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.alimentoRefeicaoList.length; i++) {
            if(alimentoRefeicaoList[i] == null) return i;
        }
        return -1;
    }
}
