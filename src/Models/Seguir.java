package Models;

import java.time.LocalDateTime;

public class Seguir {
    protected long id;
    private static long serial;
    private Pessoa usuario;
    private Pessoa seguindo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Seguir(){
        serial++;
        this.id = serial;

        this.setUsuario();
        this.setDataCriacao();
    }

    public long getId(){
        return this.id;
    }
    public Pessoa getUsuario() {
        return this.usuario;
    }

    public void setUsuario() {
        this.usuario = Util.getPessoaLogada();
    }

    public Pessoa getSeguindo() {
        return this.seguindo;
    }

    public void setSeguindo(Pessoa seguindo) {
        this.seguindo = seguindo;
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

    public void setDataModificacao() {
        this.dataModificacao = Util.getDataAtual();;
    }

}
