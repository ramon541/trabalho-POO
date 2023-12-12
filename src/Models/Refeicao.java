package Models;

import java.time.LocalDate;

public class Refeicao {
    protected long id;
    private static long serial;
    private Dieta dieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String nomeDaRefeicao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    public Refeicao(){
        serial++;
        this.id = serial;

        this.setCarboidrato(0);
        this.setProteina(0);
        this.setGordura(0);
        this.setCalorias(0);
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id) { this.id = id; }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
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

    public String toString(){
        String build = "";
        build += this.getNomeDaRefeicao() + "   ( " + "Carb.: " + String.format("%.2f",this.getCarboidrato()) +
                " | " + "Prot.: " + String.format("%.2f",this.getProteina()) + " | " + "Gord.: " + String.format("%.2f",this.getGordura()) +
                " | " + "Calorias: " + String.format("%.2f",this.getCalorias()) + ")";
        return build;
    }
}
