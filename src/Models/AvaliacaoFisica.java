/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDateTime;

public class AvaliacaoFisica {
    protected long id;
    private static long serial;
    private final Pessoa pessoa;
    private double fatorTaxaAtividade;
    private double peso;
    private double altura;
    private int idade;
    private int pescoco;
    private int cintura;
    private int quadril;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private double imc;
    private double tmb;
    private double bodyFat;
    private double massaGorda;
    private double massaMagra;

    public AvaliacaoFisica() {
        serial++;
        this.id = serial;
        setDataCriacao(Util.getDataAtual());
        this.pessoa = Util.getPessoaLogada();
    }

    public long getId() {
        return id;
    }

    public Pessoa getPessoa() { return this.pessoa; }

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

    public void setPescoco(int pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(int cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(int quadril) {
        this.quadril = quadril;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTmb() {
        return tmb;
    }

    public void setTmb(double tmb) {
        this.tmb = tmb;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setDataModificacao(LocalDateTime dataModificacao) { this.dataModificacao = dataModificacao; }

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

    public void calcularIMC(){
        setImc(this.peso / ((this.altura/100) * (this.altura/100)));
    }

    public void calcularTMB(){
        if (pessoa.getSexo().equals("Masculino")){
            setTmb(this.fatorTaxaAtividade * (66 + ((13.7 * this.peso) + ( 5 * this.altura) - (6.8 * this.idade))));
        }else {
            setTmb(this.fatorTaxaAtividade * (655 + ((9.6 * this.peso) + ( 1.8 * this.altura) - (4.7 * this.idade))));
        }
    }

    public void calcularBodyFat(){
        if(pessoa.getSexo().equals("Masculino")){
            this.bodyFat = (86.010 * Math.log10(this.cintura - this.pescoco)) - (70.041 * Math.log10(this.altura)) + 36.76;
        }else {

            this.bodyFat = (163.205 * Math.log10(this.cintura + this.quadril - this.pescoco)) - (97.684 * Math.log10(this.altura)) - 78.387;
        }
        this.massaGorda = this.peso * (this.bodyFat/100);
        this.massaMagra = this.peso - this.massaGorda;
    }

    @Override
    public String toString() {
        String builder =
                "Peso: " + String.format("%.2f",this.peso) + " KG\n" +
                        "Altura: " + this.altura + " cm\n" +
                        "Idade: " + this.idade + " anos\n" +
                        "Pescoço: " + this.pescoco + " cm \n" +
                        "Cintura: " + this.cintura + " cm \n";
        if (pessoa.getSexo().equals("Feminino")){
            builder += "Quadril: " + this.quadril + " cm \n";
        }
        builder +=
                "IMC: " + String.format("%.2f",this.imc) + " kg/m²\n" +
                        "TMB: " + String.format("%.2f",this.tmb) + " calorias\n" +
                        "BF: " + String.format("%.2f",this.bodyFat) + " %\n" +
                        "Massa gorda: " + String.format("%.2f",this.massaGorda) + " kg\n" +
                        "Massa magra: " + String.format("%.2f",this.massaMagra) + " kg\n" +
                        "O BF está: " + this.diagnosticoBodyFat();

        return builder;
    }

    //Relatórios *************************

    public String diagnosticoBodyFat() {
        String semResposta = "Não encontrado";
        double gordCorp = this.bodyFat;

        if (pessoa.getSexo().equals("Masculino")){
            if (this.idade >= 20 && this.idade <= 29){
                if (gordCorp < 11) return "Atleta";
                if (gordCorp >= 11 && gordCorp <= 13) return "Bom";
                if (gordCorp >= 14 && gordCorp <= 20) return "Normal";
                if (gordCorp >= 21 && gordCorp <= 23) return "Elevado";
                if (gordCorp > 23) return "Muito elevado";
            } else if (this.idade >= 30 && this.idade <= 39){
                if (gordCorp < 12) return "Atleta";
                if (gordCorp >= 12 && gordCorp <= 14) return "Bom";
                if (gordCorp >= 15 && gordCorp <= 21) return "Normal";
                if (gordCorp >= 22 && gordCorp <= 24) return "Elevado";
                if (gordCorp > 24) return "Muito elevado";
            } else if (this.idade >= 40 && this.idade <= 49){
                if (gordCorp < 14) return "Atleta";
                if (gordCorp >= 14 && gordCorp <= 16) return "Bom";
                if (gordCorp >= 17 && gordCorp <= 23) return "Normal";
                if (gordCorp >= 24 && gordCorp <= 26) return "Elevado";
                if (gordCorp > 26) return "Muito elevado";
            } else if (this.idade >= 50 && this.idade <= 59){
                if (gordCorp < 15) return "Atleta";
                if (gordCorp >= 15 && gordCorp <= 17) return "Bom";
                if (gordCorp >= 18 && gordCorp <= 24) return "Normal";
                if (gordCorp >= 25 && gordCorp <= 27) return "Elevado";
                if (gordCorp > 27) return "Muito elevado";
            }
        }else {
            if (this.idade >= 20 && this.idade <= 29){
                if (gordCorp < 16) return "Atleta";
                if (gordCorp >= 16 && gordCorp <= 19) return "Bom";
                if (gordCorp >= 20 && gordCorp <= 28) return "Normal";
                if (gordCorp >= 29 && gordCorp <= 31) return "Elevado";
                if (gordCorp > 31) return "Muito elevado";
            } else if (this.idade >= 30 && this.idade <= 39){
                if (gordCorp < 17) return "Atleta";
                if (gordCorp >= 17 && gordCorp <= 20) return "Bom";
                if (gordCorp >= 21 && gordCorp <= 29) return "Normal";
                if (gordCorp >= 30 && gordCorp <= 32) return "Elevado";
                if (gordCorp > 32) return "Muito elevado";
            } else  if (this.idade >= 40 && this.idade <= 49){
                if (gordCorp < 18) return "Atleta";
                if (gordCorp >= 18 && gordCorp <= 21) return "Bom";
                if (gordCorp >= 22 && gordCorp <= 30) return "Normal";
                if (gordCorp >= 31 && gordCorp <= 33) return "Elevado";
                if (gordCorp > 33) return "Muito elevado";
            } else if (this.idade >= 50 && this.idade <= 59){
                if (gordCorp < 19) return "Atleta";
                if (gordCorp >= 19 && gordCorp <= 22) return "Bom";
                if (gordCorp >= 23 && gordCorp <= 31) return "Normal";
                if (gordCorp >= 32 && gordCorp <= 34) return "Elevado";
                if (gordCorp > 34) return "Muito elevado";
            }
        }
        return semResposta;
    }
}