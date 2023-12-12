package Models;

import java.time.LocalDate;

public class Mensagem {
    protected long id;
    private Pessoa remetente;
    private Pessoa destinatario;
    private String mensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Mensagem() {
    }

    public long getId() {
        return this.id;
    }

    public Pessoa getRemetente() {
        return this.remetente;
    }

    public void setRemetente(Pessoa remetente) {
        this.remetente = remetente;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
