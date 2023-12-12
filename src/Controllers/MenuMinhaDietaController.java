package Controllers;

import Models.AvaliacaoFisica;
import Models.DAO.*;
import Models.Dieta;
import Models.TipoDieta;
import Models.Util;
import Views.Menus;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuMinhaDietaController {
    public MenuMinhaDietaController(Menus menu, AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO,
                                    DietaDAO dietaDAO, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO,
                                    RefeicaoDAO refeicaoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO) throws SQLException {
        int opc = 0;
        while (opc != 5){
            opc = menu.menuMinhaDieta();

            switch (opc){
                case 1:
                    long dietaAdicionada = this.newDieta(ultAvaliacao, tipoDietaDAO, dietaDAO);
                    if (dietaAdicionada != 0) System.out.println("Dieta adicionada com sucesso!!");
                    else System.out.println("ERRO!!! Algo deu errado...");
                    break;

                case 2:
                    new AlimentoPreferenciaController(menu, alimentoDAO, preferenciaDAO);
                    break;

                case 3:
                    if (dietaDAO.buscaUltimaDieta(Util.getPessoaLogada().getId()) != null) {
                        new GerarRefeicoesController(menu, dietaDAO.buscaUltimaDieta(Util.getPessoaLogada().getId()), alimentoDAO,
                                preferenciaDAO, refeicaoDAO, alimentoRefeicaoDAO);
                    }else System.out.println("ERRO!!! Primeiro você deve criar uma dieta");
                    break;

                case 4:
                    if (dietaDAO.buscaUltimaDieta(Util.getPessoaLogada().getId()) != null) {
                        alimentoRefeicaoDAO.mostrarRefeicoesDietaUsuario(dietaDAO.buscaUltimaDieta(Util.getPessoaLogada().getId()));
                    } else {
                        System.out.printf("Não há nenhuma dieta cadastrada!");
                    }
                    break;

                case 5:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }

    private long newDieta(AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO, DietaDAO dietaDAO) throws SQLException {
//        tipoDietaDAO.procuraDieta("Atleta").setDietaAtleta(ultAvaliacao); //Altera o TipoDeDieta Atleta para o peso do Usuário logado

        Dieta novaDieta = new Dieta();
        Scanner scan = new Scanner(System.in);

        novaDieta.setPessoa(Util.getPessoaLogada());
        novaDieta.setAvaliacaoFisica(ultAvaliacao);

        System.out.println("==============================");
        System.out.println("NOVA DIETA");
        System.out.println("==============================");
        List<TipoDieta> tiposDieta = tipoDietaDAO.buscaTiposDieta();
        for(TipoDieta tipo : tiposDieta) {
            System.out.println(tipo.toString());
        }
        System.out.print("Qual o tipo de dieta você deseja, selecione o ID: R: ");
        TipoDieta dietaSelecionada = tipoDietaDAO.buscaTipoDietaPorId(Integer.parseInt(scan.nextLine()));
        if (dietaSelecionada != null) novaDieta.setTipoDieta(dietaSelecionada);
        else return 0;
        System.out.print("""
            
            1 - Diminuir o peso
            2 - Manter o peso
            3 - Aumentar o peso
            """);
        System.out.print("Qual o seu objetivo? R: ");
        int opc = Integer.parseInt(scan.nextLine());
        switch (opc){
            case 1:
                novaDieta.setObjetivo("Diminuir o peso");
                novaDieta.setCalorias(ultAvaliacao.getTmb() - 350.0);
                break;

            case 2:
                novaDieta.setObjetivo("Manter o peso");
                novaDieta.setCalorias(ultAvaliacao.getTmb());
                break;

            case 3:
                novaDieta.setObjetivo("Aumentar o peso");
                novaDieta.setCalorias(ultAvaliacao.getTmb() + 350.0);
                break;

            default:
                return 0;
        }

        System.out.print(novaDieta);
        return dietaDAO.insereDieta(novaDieta);
    }
}
