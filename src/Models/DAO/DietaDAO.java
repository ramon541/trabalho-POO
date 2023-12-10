package Models.DAO;

import Models.*;

import java.sql.*;

public class DietaDAO {
    Dieta[] dietas = new Dieta[10];

    public boolean adicionaDieta(Dieta dieta) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.dietas[posicaoLivre] = dieta;

        return true;
    }

    public long insereDieta(Dieta d) {
        String sql = "insert into dieta(pessoa, avaliacaoFisica, tipoDieta, objetivo, calorias) values (?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(d.getPessoa().getId()));
            stmt.setString(2, String.valueOf(d.getAvaliacaoFisica().getId()));
            stmt.setString(3, String.valueOf(d.getTipoDieta().getId()));
            stmt.setString(4, d.getObjetivo());
            stmt.setString(5, String.valueOf(d.getCalorias()));
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

    public boolean ehVazio() {
        for(Dieta dieta : this.dietas) {
            if(dieta != null) return false;
        }
        return true;
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.dietas.length; i++) {
            if(dietas[i] == null) return i;
        }
        return -1;
    }

    public Dieta procuraUltimaDieta(){
        Dieta ultDieta = null;
        if (!ehVazio()){
            for (int i = dietas.length-1; i >= 0; i--){
                if (dietas[i]!= null && dietas[i].getPessoa().getId() == Util.getPessoaLogada().getId()){
                    ultDieta = dietas[i];
                    break;
                }
            }
        }
        return ultDieta;
    }
}
