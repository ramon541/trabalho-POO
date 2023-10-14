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

        StringBuilder builder = new StringBuilder();

        if(ehVazio()) {
            builder.append("Não há ninguem seguindo ninguém!");
        } else {

            builder.append("======================").append("\n");
            builder.append("Seguidores ").append("\n");
            builder.append("======================").append("\n");

            int countSeguidores = 0;

            for (Seguir seguir : this.seguindoList) {
                if (seguir != null && seguir.getSeguindo().equals(Util.getPessoaLogada())) {
                    builder.append("Nome: ").append(seguir.getUsuario().getNome()).append("\n");
                    countSeguidores++;
                }
            }

            if(countSeguidores == 0) {
                builder.append("Você não tem nenhum seguidor!");
            }
        }

        System.out.println(builder);
    }

    public boolean ehSeguidor(Pessoa usuario) {
        for(Seguir seguir: this.seguindoList) {
            if(seguir != null && (seguir.getUsuario().equals(Util.getPessoaLogada()) && seguir.getSeguindo().equals(usuario))) {
                return true;
            }
        }

        return false;
    }

    public boolean deixarDeSeguir(Pessoa usuario) {
        for(int i = 0; i < this.seguindoList.length; i++) {
            if(this.seguindoList[i] != null && this.seguindoList[i].getUsuario().equals(Util.getPessoaLogada()) && this.seguindoList[i].getSeguindo().equals(usuario)) {
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
