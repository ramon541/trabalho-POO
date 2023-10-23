package Models.DAO;

import Models.Alimento;
import Models.Refeicao;

public class RefeicaoDAO {
    Refeicao[] refeicoes = new Refeicao[4];

    public RefeicaoDAO() {
        Refeicao r1 = new Refeicao();
        r1.setNomeDaRefeicao("Café da Manhã");
        r1.setCarboidrato(0);
        r1.setProteina(0);
        r1.setGordura(0);
        r1.setCalorias(0);
        this.adicionaRefeicao(r1);

        Refeicao r2 = new Refeicao();
        r2.setNomeDaRefeicao("Almoço");
        r2.setCarboidrato(0);
        r2.setProteina(0);
        r2.setGordura(0);
        r2.setCalorias(0);
        this.adicionaRefeicao(r2);

        Refeicao r3 = new Refeicao();
        r3.setNomeDaRefeicao("Café da Tarde");
        r3.setCarboidrato(0);
        r3.setProteina(0);
        r3.setGordura(0);
        r3.setCalorias(0);
        this.adicionaRefeicao(r3);

        Refeicao r4 = new Refeicao();
        r4.setNomeDaRefeicao("Jantar");
        r4.setCarboidrato(0);
        r4.setProteina(0);
        r4.setGordura(0);
        r4.setCalorias(0);
        this.adicionaRefeicao(r4);
    }

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
