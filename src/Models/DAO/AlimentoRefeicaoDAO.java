package Models.DAO;

import Models.*;

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
        return new Random().nextInt(qtdAlimentosCadastrados);
    }

    public void gerarRefeicoesAutomaticas(Preferencia[] alimentosPreferidos, Refeicao[] refeicoes) {
        for(Refeicao refeicao: refeicoes) {
            if(refeicao != null) {
                for (Preferencia alimentoPreferido : alimentosPreferidos) {
                    if (alimentoPreferido != null) {
                        AlimentoRefeicao newAlimentoRefeicao = this.createAlimentoRefeicao(alimentoPreferido.getAlimento(), refeicao);
                        boolean alimentoAdicionado = this.adicionaAlimentoRefeicao(newAlimentoRefeicao);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public AlimentoRefeicao createAlimentoRefeicao(Alimento alimento, Refeicao refeicao) {
        AlimentoRefeicao alimentoRef = new AlimentoRefeicao();
        alimentoRef.setAlimento(alimento);
        alimentoRef.setCalorias(alimento.getCalorias());
        alimentoRef.setGordura(alimento.getGorduras());
        alimentoRef.setProteina(alimento.getProteinas());
        alimentoRef.setPorcao(alimento.getPorcao());
        alimentoRef.setRefeicao(refeicao);

        return alimentoRef;
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
