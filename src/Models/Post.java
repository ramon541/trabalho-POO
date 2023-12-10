package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
    protected long id;
    private static long serial;
    private Pessoa pessoa;
    private String conteudoPost;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Post(){
    }

    public void setId(long id) {
        this.id = id;
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

    public String getConteudoPost() {
        return conteudoPost;
    }

    public void setConteudoPost(String conteudoPost) {
        this.conteudoPost = conteudoPost;
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

    @Override
    public String toString() {
        return "\nPost " + id + ":\n" +
                "Publicado por " + pessoa.getNome() + "\n" +
                "Conteudo: '" + conteudoPost + "'\n" +
                "Criado em:" + dataCriacao + "\n" +
                "Atualizado em:" + dataModificacao + "\n";
    }
}
