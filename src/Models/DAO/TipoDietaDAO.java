package Models.DAO;

import Models.Pessoa;
import Models.TipoDieta;

public class TipoDietaDAO {
    TipoDieta[] tipoDietas = new TipoDieta[8];

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
