package Models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Pessoa {
    protected long id;
    private static long serial;
    private String nome;
    private String sexo;
    private Date nascimento;
    private String login;
    private String senha;
    private String tipoUsuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Pessoa() {
        serial++;
        this.id = serial;

        this.setDataCriacao();
    }

    public long getId() {
        return id;
    }
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
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao() {
        this.dataCriacao = Util.getDataAtual();
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao() {
        this.dataModificacao = Util.getDataAtual();
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
