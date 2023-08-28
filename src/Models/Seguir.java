package Models;

import java.util.Date;

public class Seguir {
    private int id;
    private String pessoaOrigem;
    private String pessoaSeguindo;
    private Date dataCriacao;
    private Date dataModificacao;

    public String getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(String pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public String getPessoaSeguindo() {
        return pessoaSeguindo;
    }

    public void setPessoaSeguindo(String pessoaSeguindo) {
        this.pessoaSeguindo = pessoaSeguindo;
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
