package Models.DAO;

import Models.Pessoa;
import Models.TipoDieta;

public class TipoDietaDAO {
    TipoDieta[] tipoDietas = new TipoDieta[8];

    TipoDietaDAO(Pessoa p){
        TipoDieta td1 = new TipoDieta();
        td1.setNome("Equilibrada");
        td1.setCarboidrato(40);
        td1.setProteina(30);
        td1.setGordura(30);

        TipoDieta td2 = new TipoDieta();
        td1.setNome("Low Carb");
        td1.setCarboidrato(30);
        td1.setProteina(50);
        td1.setGordura(20);

        TipoDieta td3 = new TipoDieta();
        td1.setNome("Cetogênica");
        td1.setCarboidrato(15);
        td1.setProteina(15);
        td1.setGordura(70);

        TipoDieta td4 = new TipoDieta();
        Double peso,carb,prot,gord;
        peso = p.getAvaliacaoFisicaDAO().avaliacoes[0].getPeso();
        prot = 0.2 * peso; //Precisa verificar, pois no trabalho está marcado como 2 * peso (pode ser que o prof tenha se enganado)
        gord = 0.8 * peso;
        carb = 100 - (prot + gord);
        td1.setNome("Atleta");
        td1.setCarboidrato(carb);
        td1.setProteina(prot);
        td1.setGordura(gord);
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
}
