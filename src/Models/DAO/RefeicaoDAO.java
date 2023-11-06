package Models.DAO;

import Models.Alimento;
import Models.Refeicao;

public class RefeicaoDAO {
    Refeicao[] refeicoes = new Refeicao[40];

    public Refeicao buscaPorNome(String nomeRefeicao) {
        if (!this.ehVazio()) {
            for (Refeicao refeicao : this.refeicoes) {
                if (refeicao != null && refeicao.getNomeDaRefeicao().equals(nomeRefeicao)) {
                    return refeicao;
                }
            }
        }

        return null;
    }

    public boolean adicionaRefeicao(Refeicao refeicao) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.refeicoes[posicaoLivre] = refeicao;

        return true;
    }

    public boolean ehVazio() {
        for(Refeicao refeicao : this.refeicoes) {
            if(refeicao != null) return false;
        }
        return true;
    }

    public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe refeições cadastradas");
        } else {
            String builder = "";
            for(Refeicao refeicao : this.refeicoes) {
                if(refeicao != null) {
                    builder += "\n--------------------------------------\n" +
                            refeicao.toString() +
                            "\n--------------------------------------";
                }
            }
            System.out.println(builder);
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.refeicoes.length; i++) {
            if(refeicoes[i] == null) return i;
        }
        return -1;
    }
}
