package Models.DAO;

import Models.Mensagem;
import Models.Pessoa;
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

        builder = new StringBuilder("");

        for(Mensagem msg: this.mensagens) {
            if(msg != null && msg.getRemetente().equals(Util.getPessoaLogada()) && msg.getDestinatario().equals(usuarioBuscado) ||
                   msg != null && msg.getRemetente().equals(usuarioBuscado) && msg.getDestinatario().equals(Util.getPessoaLogada())
            ) {
                builder.append("Usuário: ").append(msg.getRemetente().getNome()).append("\n");
                builder.append("Mensagem: ").append(msg.getMensagem()).append("\n");
            }
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.mensagens.length; i++) {
            if(this.mensagens[i] == null) return i;
        }

        return -1;
    }
}
