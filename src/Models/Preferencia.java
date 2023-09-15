package Models;

import java.util.Date;

public class Preferencia {
    protected long id;
    private static long serial;
    private String pessoa;
    private String alimento;
    private Date dataCriacao;
    private Date dataModificacao;

    public Preferencia() {
        serial++;
        this.id = serial;
    }

    public long getId() {
        return this.id;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
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
