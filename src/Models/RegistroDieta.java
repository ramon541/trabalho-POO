/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class RegistroDieta {
    private int id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDieta tipoDieta;
    private String objetivo;
    private double calorias;
    private int nRefeicoes;
    private Date dataCriacao;
    private Date dataModificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
