package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TipoDieta {
    protected long id;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public TipoDieta(){
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
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
        String builder = "ID: " +  this.getId();
        builder+= " - Tipo: " + this.getNome() + "\n";
        return builder;
    }

    //    public void setDietaAtleta (AvaliacaoFisica ultAvaliacaoUser) {
//        double prot = ultAvaliacaoUser.getPeso() * 0.2;
//        setProteina(prot/100);
//
//        double gord = ultAvaliacaoUser.getPeso() * 0.8;
//        setGordura(gord/100);
//
//        double carb = 100 - (gord + prot);
//        setCarboidrato(carb/100);
//    }
}
