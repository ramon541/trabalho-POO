package Models;

import java.util.Date;

public class Post {
    protected long id;

    private static long serial;
    private String pessoa;
    private String conteudoDaMensagem;
    private Date dataCriacao;
    private Date dataModificacao;

    public Post(){
        serial++;
        this.id = serial;
    }

    public long getId(){
        return this.id;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getConteudoDaMensagem() {
        return conteudoDaMensagem;
    }

    public void setConteudoDaMensagem(String conteudoDaMensagem) {
        this.conteudoDaMensagem = conteudoDaMensagem;
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
