package Models;

import java.util.Date;

public class Refeicao {
    protected long id;
    private static long serial;
    private String dieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String nomeDaRefeicao;
    private Date dataCriacao;
    private Date dataModificacao;
    public Refeicao(){
        serial++;
        this.id = serial;
    }

    public long getId(){
        return this.id;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
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

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getNomeDaRefeicao() {
        return nomeDaRefeicao;
    }

    public void setNomeDaRefeicao(String nomeDaRefeicao) {
        this.nomeDaRefeicao = nomeDaRefeicao;
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
