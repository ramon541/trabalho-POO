package Models;

import java.time.LocalDate;

public class Dieta {
    protected long id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDieta tipoDieta;
    private String objetivo;
    private double calorias;
    private final int nroRefeicoes = 4;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;


    public long getId(){
        return this.id;
    }

    public void setId(long id) { this.id = id; }

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

    public int getNroRefeicoes() {
        return nroRefeicoes;
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
        String builder = "";

        builder += "\n===============" +
                "\nTipo de Dieta: " + this.tipoDieta.getNome() +
                "\nObjetivo: " + this.objetivo + " o peso"+
                "\nN° de refeições: " + this.nroRefeicoes +
                "\n\nCalorias: " + String.format("%.2f",this.calorias) +
                "\n===============\n";
        return builder;
    }
}
