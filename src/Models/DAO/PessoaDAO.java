package Models.DAO;

import Models.Alimento;
import Models.Pessoa;
import Models.Post;
import Models.Preferencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Connection;

public class PessoaDAO {
    public List<Pessoa> getAll(){
        String sql = "select * from pessoa";
        List<Pessoa> pessoas = new ArrayList<>();

        try(
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getLong("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSexo(rs.getString("sexo"));
                Date currentBirthday = rs.getDate("dataNascimento");
                LocalDate dataNascimento = currentBirthday.toLocalDate();
                pessoa.setNascimento(dataNascimento);
                pessoa.setLogin(rs.getString("login"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setDataCriacao(rs.getDate("dataCriacao"));
                pessoa.setDataModificacao();
                pessoas.add(pessoa);
            }

        } catch (SQLException e) {
            System.out.println("Não foi possível carregar a lista de pessoas. ERRO: " + e.getMessage());
        }

        return pessoas;
    }
}
