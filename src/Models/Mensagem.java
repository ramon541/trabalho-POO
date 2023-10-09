package Models;

import java.util.Date;

public class Mensagem {
    protected long id;
    private static long serial;
    private final Pessoa remetente;
    private Pessoa destinatario;
    private String mensagem;
    private Date dataCriacao;
    private Date dataModificacao;

    public Mensagem() {
        serial++;
        this.id = serial;

        this.remetente = Util.getPessoaLogada();
    }

    public long getId() {
        return this.id;
    }

    public Pessoa getRemetente() {
        return this.remetente;
    }

    public Pessoa getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
