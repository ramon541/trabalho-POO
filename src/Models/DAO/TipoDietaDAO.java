package Models.DAO;

import Models.Dieta;
import Models.TipoDieta;

public class TipoDietaDAO {
    TipoDieta[] tipoDietas = new TipoDieta[8];
    public TipoDietaDAO() {
        TipoDieta d1 = new TipoDieta();
        d1.setNome("Equilibrada");
        d1.setCarboidrato(0.4);
        d1.setProteina(0.3);
        d1.setGordura(0.3);
        this.adicionaTipoDieta(d1);

        TipoDieta d2 = new TipoDieta();
        d2.setNome("Low Carb");
        d2.setCarboidrato(0.3);
        d2.setProteina(0.5);
        d2.setGordura(0.2);
        this.adicionaTipoDieta(d2);

        TipoDieta d3 = new TipoDieta();
        d3.setNome("Cetogênica");
        d3.setCarboidrato(0.15);
        d3.setProteina(0.15);
        d3.setGordura(0.70);
        this.adicionaTipoDieta(d3);

        TipoDieta d4 = new TipoDieta();
        d4.setNome("Atleta");
        d4.setCarboidrato(0.0);
        d4.setProteina(0.0);
        d4.setGordura(0.0);
        this.adicionaTipoDieta(d4);
    }
    public boolean adicionaTipoDieta(TipoDieta tipoDieta) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }
        this.tipoDietas[posicaoLivre] = tipoDieta;
        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.tipoDietas.length; i++) {
            if(tipoDietas[i] == null) return i;
        }
        return -1;
    }

    public TipoDieta procuraDieta(String nomeTipoDieta){
        for (TipoDieta tipoDieta : this.tipoDietas) {
            if (tipoDieta.getNome().equals(nomeTipoDieta)){
                return tipoDieta;
            }
        }
        return null;
    }
}
