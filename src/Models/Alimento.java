package Models;

import java.time.LocalDateTime;

public class Alimento {
    protected long id;
    private static long serial;
    private String nome;
    private Double carboidratos;
    private Double proteínas;
    private Double gorduras;
    private Double calorias;
    private Double porcao;
    private String tipoUsuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Alimento(){
        serial++;
        this.id = serial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(Double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public Double getProteínas() {
        return proteínas;
    }

    public void setProteínas(Double proteínas) {
        this.proteínas = proteínas;
    }

    public Double getGorduras() {
        return gorduras;
    }

    public void setGorduras(Double gorduras) {
        this.gorduras = gorduras;
    }

    public Double getPorcao() {
        return porcao;
    }

    public void setPorcao(Double porcao) {
        this.porcao = porcao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public Double getCalorias() { return this.calorias; }
    public void setCalorias(){
        this.calorias = 4*this.carboidratos + 4*this.proteínas + 9*this.gorduras;
    }
}
