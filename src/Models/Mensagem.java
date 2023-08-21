package Models;

import java.util.Date;

public class Mensagem {
    private int id;
    private String pessoaOrigem;
    private String pessoaDestino;
    private String mensagem;
    private Date dataCriacao;
    private Date dataModificacao;

    public String getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(String pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public String getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(String pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
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
