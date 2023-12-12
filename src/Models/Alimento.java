package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alimento {
    protected long id;
    private String nome;
    private Double carboidratos;
    private Double proteinas;
    private Double gorduras;
    private Double calorias;
    private Double porcao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Alimento(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getProteinas() {
        return proteinas;
    }

    public void setProteinas(Double proteinas) {
        this.proteinas = proteinas;
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

    public Double getCalorias() { return this.calorias; }

    public void setCalorias(double calorias){
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        String builder = "";
        builder +=
                "\nID: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nCarboidratos: " + String.format("%.2f",this.getCarboidratos()) + " g" +
                "\nProteínas: " + String.format("%.2f",this.getProteinas()) + " g" +
                "\nGorduras: " + String.format("%.2f",this.getGorduras()) + " g" +
                "\nCalorias: " + String.format("%.2f",this.getCalorias()) + " cal" +
                "\nPorção: " + String.format("%.2f",this.getPorcao()) + " g";
        return builder;
    }
}
