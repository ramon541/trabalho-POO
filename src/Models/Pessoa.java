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
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Pessoa() {
        //Ações padrão para todos os usuários
        serial++;
        this.id = serial;
        this.setTipoUsuario("comum");
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
        this.sexo = sexo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nascimento = LocalDate.parse(nascimento, formato);
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
