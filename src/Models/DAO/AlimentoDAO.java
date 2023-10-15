package Models.DAO;

import Models.Alimento;
import Models.AvaliacaoFisica;

public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[20];

    public boolean adicionaAlimento(Alimento alimento) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.alimentos[posicaoLivre] = alimento;

        return true;
    }

    public boolean ehVazio() {
        for(Alimento alimento : this.alimentos) {
            if(alimento != null) return false;
        }
        return true;
    }

    public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe alimentos cadastrados");
        } else {
            String builder = "";
            for(Alimento alimento : this.alimentos) {
                if(alimento != null) {
                    builder += "\n===============" +
                            "\nNome: " + alimento.getNome() +
                            "\nCarboidratos: " + alimento.getCarboidratos() + " g" +
                            "\nProteínas: " + alimento.getProteinas() + " g" +
                            "\nGorduras: " + alimento.getGorduras() + " g" +
                            "\nCalorias: " + alimento.getCalorias() + " cal" +
                            "\nPorção: " + alimento.getPorcao() + " g" +
                            "\n===============\n";
                }
            }
            System.out.println(builder);
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.alimentos.length; i++) {
            if(alimentos[i] == null) return i;
        }
        return -1;
    }
}
