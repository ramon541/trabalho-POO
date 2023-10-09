package Models.DAO;

import Models.Pessoa;
import Models.Seguir;
import Models.Util;

public class SeguirDAO {

    private Seguir[] seguindoList = new Seguir[10];

    public boolean seguirPessoa(Pessoa seguidor) {
        int posicaoLivre = this.proximaPosicaoLivre();

        if(posicaoLivre != -1) {
            Seguir seguindo = new Seguir();
            seguindo.setSeguindo(seguidor);
            seguindo.setDataCriacao();

            this.seguindoList[posicaoLivre] = seguindo;
            return true;
        }

        return false;
    }

    public boolean ehVazio() {
        for(Seguir seguindo : this.seguindoList) {
            if(seguindo != null) return false;
        }

        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.seguindoList.length; i++) {
            if(this.seguindoList[i] == null) return i;
        }

        return -1;
    }

    public void mostrarSeguidores() {
        if(ehVazio()) {
            System.out.println("Não há nenhum seguidor!");
        } else {
            for (Seguir seguir: this.seguindoList) {
                if(seguir.getUsuario().equals(Util.getPessoaLogada())) {
                    StringBuilder builder = new StringBuilder("");
                    builder.append("======================").append("\n");
                    builder.append("Seguidores ").append("\n");
                    builder.append("======================").append("\n");
                    builder.append("Nome: ").append(seguir.getSeguindo().getNome()).append("\n");
                }
            }
        }
    }

    public boolean ehSeguidor(Pessoa usuario) {
        for(Seguir seguir: this.seguindoList) {
            if(seguir.getUsuario().equals(Util.getPessoaLogada()) && seguir.getSeguindo().equals(usuario)) {
                return true;
            }
        }

        return false;
    }

    public boolean deixarDeSeguir(Pessoa usuario) {
        for(int i = 0; i < this.seguindoList.length; i++) {
            if(this.seguindoList[i].getUsuario().equals(Util.getPessoaLogada()) && this.seguindoList[i].getSeguindo().equals(usuario)) {
                this.seguindoList[i] = null;
                return true;
            }
        }

        return false;
    }

    public Seguir[] getSeguindoList() {
        return this.seguindoList;
    }

    public void setSeguindoList(Seguir[] seguindoList) {
        this.seguindoList = seguindoList;
    }
}
