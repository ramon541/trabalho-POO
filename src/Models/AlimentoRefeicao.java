package Models;

import java.util.Date;

public class AlimentoRefeicao {
    protected long id;
    private static long serial;
    private Refeicao refeicao;
    private Alimento alimento;
    private double porcao;
    private double proteina;
    private double gordura;
    private double carboidrato;
    private double calorias;
    private Date dataCriacao;
    private Date dataModificacao;

    public AlimentoRefeicao() {
        serial++;
        this.id = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Alimento getAlimento() {
        return this.alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
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

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
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

    public String toString() {
        String builder = "";
        builder +=
                "\n" + this.getAlimento().getNome() + "    " +
                        "Gord: " + String.format("%.2f",this.getGordura()) + " g | " +
                        "Carbs: " + String.format("%.2f",this.getCarboidrato()) + " g | " +
                        "Prot: " + String.format("%.2f",this.getProteina()) + " g | " +
                        "Cals: " + String.format("%.2f",this.getCalorias()) + " cal" +
                        "\nPorção: " + String.format("%.2f",this.getPorcao()) + " g";
        return builder;
    }
}
