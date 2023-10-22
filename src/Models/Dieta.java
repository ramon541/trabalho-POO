package Models;

import java.time.LocalDateTime;

public class Dieta {
    protected long id;
    private static long serial;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDieta tipoDieta;
    private String objetivo;
    private double calorias;
    private int nRefeicoes;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Dieta() {
        serial++;
        this.id = serial;
        setDataCriacao(Util.getDataAtual());
    }

    public long getId(){
        return this.id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public AvaliacaoFisica getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getnRefeicoes() {
        return nRefeicoes;
    }

    public void setnRefeicoes(int nRefeicoes) {
        this.nRefeicoes = nRefeicoes;
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

    public String toString(){
        String builder = "";

        builder += "\n===============" +
                "\nTipo de Dieta: " + this.tipoDieta.getNome() +
                "\nObjetivo: " + this.objetivo + " o peso"+
                "\nN° de refeições: " + this.nRefeicoes +
                "\n\nCalorias: " + String.format("%.2f",this.calorias) +
                "\n===============\n";
        return builder;
    }
}
