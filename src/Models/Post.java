package Models;

import java.time.LocalDateTime;
import java.util.Date;

public class Post {
    protected long id;

    private static long serial;
    private Pessoa pessoa;
    private String conteudoDaMensagem;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Post(){
        serial++;
        this.id = serial;
        this.setDataCriacao();
    }

    public long getId(){
        return this.id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getConteudoDaMensagem() {
        return conteudoDaMensagem;
    }

    public void setConteudoDaMensagem(String conteudoDaMensagem) {
        this.conteudoDaMensagem = conteudoDaMensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao() {
        this.dataCriacao = Util.getDataAtual();
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    private void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
