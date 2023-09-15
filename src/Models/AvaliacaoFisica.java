/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class AvaliacaoFisica {
    protected long id;
    private static long serial;
    private Pessoa pessoa;
    private double fatorTaxaAtividade;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private Date dataCriacao;
    private Date dataModificacao;
    private double imc;
    private double tmb;
    private double bodyFat;
    private double massaGorda;
    private double massaMagra;

    public AvaliacaoFisica() {
        serial++;
        this.id = serial;
    }

    public long getId() {
        return id;
    }

    public double getFatorTaxaAtividade() {
        return fatorTaxaAtividade;
    }

    public void setFatorTaxaAtividade(double fatorTaxaAtividade) {
        this.fatorTaxaAtividade = fatorTaxaAtividade;
    }
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
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
    public double getBodyFat() {
        return bodyFat;
    }
    public double getMassaGorda() {
        return massaGorda;
    }

    public double getMassaMagra() {
        return massaMagra;
    }
    //Métodos *************************

    public void CalcularIMC(){
        this.imc = this.peso / Math.pow(this.altura, 2);
    }

    public void CalcularTMB(){
        if (pessoa.getSexo().equals("Masculino")){
            this.tmb = this.fatorTaxaAtividade * (66 + ((13.7 * this.peso) + ( 5 * this.altura) - (6.8 * this.idade)));
        }else {
            this.tmb = this.fatorTaxaAtividade * (655 + ((9.6 * this.peso) + ( 1.8 * this.altura) - (4.7 * this.idade)));
        }
    }

    public void CalcularBodyFat(){
        if(pessoa.getSexo().equals("Masculino")){
            this.bodyFat = (86.010 * Math.log10(this.cintura - this.pescoco)) - (70.041 * Math.log10(this.altura)) + 36.76;
        }else {

            this.bodyFat = (163.205 * Math.log10(this.cintura + this.quadril - this.pescoco)) - (97.684 * Math.log10(this.altura)) - 78.387;
        }
        this.massaGorda = this.peso * (this.bodyFat/100);
        this.massaMagra = this.peso - this.massaGorda;
    }

    //Relatórios *************************
}