package Models.DAO;

import Models.*;

import java.sql.*;
import java.util.Random;

public class AlimentoRefeicaoDAO {

    AlimentoRefeicao[] alimentoRefeicaoList = new AlimentoRefeicao[100];

    public AlimentoRefeicao[] getAlimentoRefeicaoList() { return alimentoRefeicaoList; }

    public long adicionaAlimentoRefeicaoDB(AlimentoRefeicao alimentoRefeicao){
        String sql = "insert into alimentorefeicao(alimento, refeicao, porcao, proteina, gordura, carboidrato, calorias) values (?,?,?,?,?,?,?)";
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(alimentoRefeicao.getAlimento().getId()));
            stmt.setString(2, String.valueOf(alimentoRefeicao.getRefeicao().getId()));
            stmt.setString(3, String.valueOf(alimentoRefeicao.getPorcao()));
            stmt.setString(4, String.valueOf(alimentoRefeicao.getProteina()));
            stmt.setString(5, String.valueOf(alimentoRefeicao.getGordura()));
            stmt.setString(6, String.valueOf(alimentoRefeicao.getCarboidrato()));
            stmt.setString(7, String.valueOf(alimentoRefeicao.getCalorias()));
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

    public boolean adicionaAlimentoRefeicao(AlimentoRefeicao alimentoRefeicao, AlimentoRefeicao[] alimentoRefeicaoList) {
        int posicaoLivre = this.proximaPosicaoLivre(alimentoRefeicaoList);

        if(posicaoLivre == -1) {
            return false;
        }

        alimentoRefeicaoList[posicaoLivre] = alimentoRefeicao;

        return true;
    }

    public double calcularQtdCaloriasPorRefeicao(double caloriasTotaisDieta, int nroRefeicoes) {
        return caloriasTotaisDieta / nroRefeicoes;
    }

    public int gerarNumeroAleatorio(int qtdAlimentosCadastrados) {
        return new Random().nextInt(qtdAlimentosCadastrados);
    }

    public void gerarRefeicoesAutomaticas(Preferencia[] alimentosPreferidos, Refeicao[] refeicoes) {
        for(Refeicao refeicao: refeicoes) {
            if(refeicao != null) {
                for (Preferencia alimentoPreferido : alimentosPreferidos) {
                    if (alimentoPreferido != null) {
                        AlimentoRefeicao newAlimentoRefeicao = this.createAlimentoRefeicao(alimentoPreferido.getAlimento(), refeicao);
                        boolean alimentoAdicionado = this.adicionaAlimentoRefeicao(newAlimentoRefeicao, this.alimentoRefeicaoList);
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public AlimentoRefeicao createAlimentoRefeicao(Alimento alimento, Refeicao refeicao) {
        AlimentoRefeicao alimentoRef = new AlimentoRefeicao();
        alimentoRef.setAlimento(alimento);
        alimentoRef.setCalorias(alimento.getCalorias());
        alimentoRef.setGordura(alimento.getGorduras());
        alimentoRef.setProteina(alimento.getProteinas());
        alimentoRef.setPorcao(alimento.getPorcao());
        alimentoRef.setRefeicao(refeicao);

        return alimentoRef;
    }

    public boolean ehVazio() {
        for(AlimentoRefeicao alimentoRefeicao : this.alimentoRefeicaoList) {
            if(alimentoRefeicao != null) return false;
        }
        return true;
    }

    private int proximaPosicaoLivre(AlimentoRefeicao[] alimentoRefeicaoList) {
        for(int i = 0; i < alimentoRefeicaoList.length; i++) {
            if(alimentoRefeicaoList[i] == null) return i;
        }
        return -1;
    }

    public AlimentoRefeicao[] procuraAlimentoDaRefeicao (Refeicao refeicao){
        AlimentoRefeicao[] respAlimentoRef  = new AlimentoRefeicao[15];
        for (AlimentoRefeicao alimentoRef : this.alimentoRefeicaoList){
            if (alimentoRef != null && alimentoRef.getRefeicao().getId() == refeicao.getId()){
                adicionaAlimentoRefeicao(alimentoRef, respAlimentoRef);
            }
        }

        return respAlimentoRef;
    }

    public void mostrarRefeicoesDietaUsuario(Dieta ultDieta) {

        StringBuilder builder = new StringBuilder();

        if(ehVazio()) {
            builder.append("Não há nenhuma refeição cadastrada!");
        } else {
            for(AlimentoRefeicao refeicao : this.alimentoRefeicaoList) {
                if(refeicao != null && refeicao.getRefeicao().getDieta().equals(ultDieta)) {
                    builder.append(refeicao.getRefeicao().toString()).append("\n");
                    builder.append(refeicao.getAlimento().toString()).append("\n");
                }
            }
        }

        System.out.println(builder);
    }
}
