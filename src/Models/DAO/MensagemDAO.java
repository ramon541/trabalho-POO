package Models.DAO;

import Models.Mensagem;
import Models.Pessoa;
import Models.Post;
import Models.Util;

public class MensagemDAO {

    Mensagem[] mensagens = new Mensagem[10];

    StringBuilder builder;

    public boolean enviarMensagem(Pessoa destinatario, String mensagem) {

        int posicaoLivre = proximaPosicaoLivre();

        if(posicaoLivre == -1) {
            return false;
        } else {
            Mensagem msg = new Mensagem();
            msg.setMensagem(mensagem);
            msg.setDestinatario(destinatario);
            this.mensagens[posicaoLivre] = msg;
            return true;
        }
    }

    public void verMensagens(Pessoa usuarioBuscado) {
        StringBuilder builder = new StringBuilder();
        builder.append("=======================").append("\n");
        builder.append("CHAT").append("\n");
        builder.append("=======================").append("\n");

        if(this.ehVazio()) {
            builder.append("Nenhuma mensagem foi enviada.");
        } else {
            for (Mensagem msg : this.mensagens) {
                if (msg != null) {
                    Pessoa remetente = msg.getRemetente();
                    Pessoa destinatario = msg.getDestinatario();

                    if ((remetente.equals(Util.getPessoaLogada()) && destinatario.equals(usuarioBuscado)) ||
                            (remetente.equals(usuarioBuscado) && destinatario.equals(Util.getPessoaLogada()))) {

                        builder.append("Usuário: ").append(remetente.getNome()).append("\n");
                        builder.append("Mensagem: ").append(msg.getMensagem()).append("\n");
                        builder.append("=============================").append("\n");
                    }
                }
            }
        }

        System.out.println(builder);
    }

    public boolean ehVazio() {
        for(Mensagem msg : this.mensagens) {
            if(msg != null) return false;
        }

        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.mensagens.length; i++) {
            if(this.mensagens[i] == null) return i;
        }

        return -1;
    }
}
