package Models.DAO;

import Models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MensagemDAO {

    public final PessoaDAO pessoaDAO;

    public MensagemDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public long enviarMensagem(Pessoa remetente, Pessoa destinatario, String mensagem) {
        String sql = "insert into mensagem(remetente, destinatario, mensagem) values (?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(remetente.getId()));
            stmt.setString(2, String.valueOf(destinatario.getId()));
            stmt.setString(3, mensagem);
            stmt.execute();

            //retorna o id do objeto inserido
            ResultSet rs=stmt.getGeneratedKeys();
            int retorno=0;
            if(rs.next()){
                retorno = rs.getInt(1);
            }
            System.out.println("O id inserido foi: " + retorno);
            System.out.println("Gravado!");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement criaConsulta(Connection con, Pessoa remetente, Pessoa destinatario) throws SQLException {
        String sql = "select * from mensagem where (remetente = ? and destinatario = ?) or (remetente = ? and destinatario = ?) order by id desc";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, String.valueOf(remetente.getId()));
        ps.setString(2, String.valueOf(destinatario.getId()));
        ps.setString(3, String.valueOf(destinatario.getId()));
        ps.setString(4, String.valueOf(remetente.getId()));

        return ps;
    }

    public List<Mensagem> buscaMensagens(Pessoa remetente, Pessoa destinatario) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = criaConsulta(connection, remetente, destinatario);
             ResultSet rs = ps.executeQuery()) {
            List<Mensagem> mensagens = new ArrayList<Mensagem>();
            while (rs.next()) {
                Mensagem msg = new Mensagem();
                long idRemetente = rs.getLong("remetente");
                long idDestinatario = rs.getLong("remetente");

                if(idRemetente == remetente.getId()) {
                    msg.setRemetente(pessoaDAO.buscaPorID(idRemetente));
                    msg.setDestinatario(pessoaDAO.buscaPorID(idDestinatario));
                } else {
                    msg.setRemetente(pessoaDAO.buscaPorID(idDestinatario));
                    msg.setDestinatario(pessoaDAO.buscaPorID(idRemetente));
                }

                msg.setMensagem(rs.getString("mensagem"));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                msg.setDataCriacao(dataCriacao);

                java.sql.Date currentDateAtualizacao = rs.getDate("dataAtualizacao");
                LocalDate dataAtualizacao = currentDateAtualizacao.toLocalDate();
                msg.setDataModificacao(dataAtualizacao);

                mensagens.add(msg);
            }

            rs.close();
            ps.close();
            return mensagens;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
