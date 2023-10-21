package Models;

import java.time.LocalDateTime;

public class Preferencia {
    protected long id;
    private static long serial;
    private Pessoa pessoa;
    private Alimento alimento;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Preferencia() {
        serial++;
        this.id = serial;
        setDataCriacao(Util.getDataAtual());
    }

    public long getId() {
        return this.id;
    }

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
