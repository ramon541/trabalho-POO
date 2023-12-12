package Models;

import java.time.LocalDate;

public class Seguir {
    protected long id;
    private Pessoa usuario;
    private Pessoa seguindo;
    private int estaSeguindo;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Seguir(){
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public void setSeguindo(Pessoa seguindo) {
        this.seguindo = seguindo;
    }

    public int isEstaSeguindo() {
        return estaSeguindo;
    }

    public void setEstaSeguindo(int estaSeguindo) {
        this.estaSeguindo = estaSeguindo;
    }

    public Pessoa getUsuario() {
        return this.usuario;
    }

    public Pessoa getSeguindo() {
        return this.seguindo;
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
        this.dataModificacao = dataModificacao;;
    }

    @Override
    public String toString() {
        return "Seguir{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", seguindo=" + seguindo +
                ", estaSeguindo" + estaSeguindo +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
