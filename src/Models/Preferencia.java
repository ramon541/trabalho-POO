package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Preferencia {
    protected long id;
    private Pessoa pessoa;
    private Alimento alimento;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public long getId() {
        return this.id;
    }

    public void setId(long id) { this.id = id; }
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
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
        String builder="";

        builder+= "ID: " + getId();
        builder+= "\nNome: " + getAlimento().getNome();
        return builder;
    }
}
