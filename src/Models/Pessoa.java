package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {
    protected long id;
    private static long serial;
    private String nome;
    private String sexo;
    private LocalDate nascimento;
    private String login;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Pessoa() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate DataCriacao) {
        this.dataCriacao = DataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate DataModificacao) {
        this.dataModificacao = DataModificacao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", nascimento=" + nascimento +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sexo, nascimento, login, senha, dataCriacao, dataModificacao);
    }

    @Override
    public boolean equals(Object pessoa) {
        if(this == pessoa) return true;
        if(pessoa == null) return false;
        if(getClass() != pessoa.getClass());
        final Pessoa other = (Pessoa) pessoa;
        if(!Objects.equals(this.getLogin(), other.getLogin()) && !Objects.equals(this.getSenha(), other.getSenha())) {
            return false;
        }

        return true;
    }
}
