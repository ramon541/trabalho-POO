package Models.DAO;

import Models.AvaliacaoFisica;
import Models.Dieta;
import Models.Util;

public class DietaDAO {
    Dieta[] dietas = new Dieta[10];

    public boolean adicionaDieta(Dieta dieta) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.dietas[posicaoLivre] = dieta;

        return true;
    }

    public boolean ehVazio() {
        for(Dieta dieta : this.dietas) {
            if(dieta != null) return false;
        }
        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.dietas.length; i++) {
            if(dietas[i] == null) return i;
        }
        return -1;
    }

    public Dieta procuraUltimaDieta(){
        Dieta ultDieta = null;
        if (!ehVazio()){
            for (int i = dietas.length-1; i >= 0; i--){
                if (dietas[i]!= null && dietas[i].getPessoa().getId() == Util.getPessoaLogada().getId()){
                    ultDieta = dietas[i];
                    break;
                }
            }
        }
        return ultDieta;
    }
}
