package Models.DAO;

import Models.Alimento;
import Models.Pessoa;
import Models.Preferencia;
import Models.Util;

public class PreferenciaDAO {
    Preferencia[] preferencias = new Preferencia[10];

    public boolean adicionaPreferencia(Alimento alimento) {

        int posicaoLivre = this.proximaPosicaoLivre();

        if(posicaoLivre == -1) {
            return false;
        } else {
            Preferencia preferencia = new Preferencia();
            preferencia.setPessoa(Util.getPessoaLogada());
            preferencia.setAlimento(alimento);

            this.preferencias[posicaoLivre] = preferencia;
            return true;
        }
    }

    public Preferencia buscaPorNomeAlimento(String nomeAlimento) {
        for(Preferencia p : this.preferencias) {
            if(p != null && p.getAlimento().getNome().equals(nomeAlimento)) return p;
        }

        return null;
    }

    public boolean ehVazio() {
        for(Preferencia preferencia: this.preferencias) {
            if(preferencia != null) return false;
        }

        return true;
    }

    public void mostrarPreferidos() {
        StringBuilder builder = new StringBuilder();

        if(ehVazio()) {
            builder.append("Não existe nenhum alimento preferido cadastrado.");
        } else {
            builder.append("==============================").append("\n");
            builder.append("ALIMENTOS PREFERIDOS").append("\n");
            builder.append("==============================").append("\n");

            for(Preferencia p: this.preferencias) {
                if(p != null && p.getPessoa().getNome().equals(Util.getPessoaLogada().getNome())) {
                    builder.append("Alimento: ").append(p.getAlimento().getNome()).append("\n");
                }
            }
        }

        System.out.println(builder);
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.preferencias.length; i++) {
            if(preferencias[i] == null) return i;
        }

        return -1;
    }

    public boolean remover(String nomeAlimento) {
        for(Preferencia p : this.preferencias) {
            if(p != null && p.getAlimento().getNome().equals(nomeAlimento)) {
                p = null;
                return true;
            }
        }

        return false;
    }

    public Preferencia[] getPreferencias() {
        return preferencias;
    }
}
