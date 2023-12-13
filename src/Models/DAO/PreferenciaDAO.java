package Models.DAO;

import Models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreferenciaDAO {

    final PessoaDAO pessoaDAO;
    final AlimentoDAO alimentoDAO;


    public PreferenciaDAO(PessoaDAO pessoaDAO, AlimentoDAO alimentoDAO){
        this.pessoaDAO = pessoaDAO;
        this.alimentoDAO = alimentoDAO;
    }

    public long adicionaPreferencia(Alimento alimento){
        String sql = "insert into preferencia(pessoa, alimento) values (?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(Util.getPessoaLogada().getId()));
            stmt.setString(2, String.valueOf(alimento.getId()));
            stmt.execute();

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

    public List<Preferencia> buscaPreferencias(long idUsuario) {
        String sql = "select * from preferencia where pessoa = ?";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            List<Preferencia> preferencias = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Preferencia preferencia = new Preferencia();
                preferencia.setId(rs.getLong("id"));
                preferencia.setPessoa(pessoaDAO.buscaPorID(rs.getLong("pessoa")));
                preferencia.setAlimento(alimentoDAO.buscaAlimentoPorId(rs.getLong("alimento")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                preferencia.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                preferencia.setDataModificacao(dataMod);

                preferencias.add(preferencia);
            }
            rs.close();
            stmt.close();
            return preferencias;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPreferidos(){
        List<Preferencia> preferencias = buscaPreferencias(Util.getPessoaLogada().getId());
        if (preferencias == null){
            System.out.println("Não existe nenhum alimento preferido cadastrado.");
        } else {
            for (Preferencia preferencia : preferencias){
                System.out.print("\n\n------------\n");
                System.out.print(preferencia.toString());
                System.out.println("\n------------");
            }
        }
    }
}
