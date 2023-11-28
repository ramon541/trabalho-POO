package Models;

import java.time.LocalDateTime;

public class Refeicao {
    protected long id;
    private static long serial;
    private Dieta dieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    public double limiteCalorias;
    public double limiteGorduras;
    public double limiteCarboidratos;
    public double limiteProteinas;
    private String nomeDaRefeicao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
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

    public double getLimiteCalorias() {
        return limiteCalorias;
    }

    public double getLimiteGorduras() {
        return limiteGorduras;
    }

    public void setLimiteGorduras(double limiteGorduras) {
        this.limiteGorduras = limiteGorduras;
    }

    public double getLimiteCarboidratos() {
        return limiteCarboidratos;
    }

    public void setLimiteCarboidratos(double limiteCarboidratos) {
        this.limiteCarboidratos = limiteCarboidratos;
    }

    public double getLimiteProteinas() {
        return limiteProteinas;
    }

    public void setLimiteProteinas(double limiteProteinas) {
        this.limiteProteinas = limiteProteinas;
    }

    public void setLimiteCalorias() {
        if(this.calorias != 0) {
            this.limiteCalorias = this.calorias / 4;
        }
    }

    public String toString(){
        String build = "";
        build += this.getNomeDaRefeicao() + "   ( " + "Carb.: " + String.format("%.2f",this.getCarboidrato()) +
                " | " + "Prot.: " + String.format("%.2f",this.getProteina()) + " | " + "Gord.: " + String.format("%.2f",this.getGordura()) +
                " | " + "Calorias: " + String.format("%.2f",this.getCalorias()) + ")";
        return build;
    }
}
