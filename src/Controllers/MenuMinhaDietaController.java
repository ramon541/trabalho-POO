package Controllers;

import Models.AvaliacaoFisica;
import Models.DAO.*;
import Models.Dieta;
import Models.TipoDieta;
import Models.Util;
import Views.Menus;

import java.util.Scanner;

public class MenuMinhaDietaController {
    public MenuMinhaDietaController(Menus menu, AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO,
                                    DietaDAO dietaDAO, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO,
                                    RefeicaoDAO refeicaoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO){
        int opc = 0;
        while (opc != 4){
            opc = menu.menuMinhaDieta();

            switch (opc){
                case 1:
                    boolean dietaAdicionada = this.newDieta(ultAvaliacao, tipoDietaDAO, dietaDAO);
                    if (dietaAdicionada) System.out.println("Dieta adicionada com sucesso!!");
                    else System.out.println("ERRO!!! Algo deu errado...");
                    break;

                case 2:
                    new AlimentoPreferenciaController(menu, alimentoDAO, preferenciaDAO);
                    break;

                case 3:
                    if (dietaDAO.procuraUltimaDieta() != null) {
                        new GerarRefeicoesController(menu, dietaDAO.procuraUltimaDieta(), alimentoDAO,
                                preferenciaDAO, refeicaoDAO, alimentoRefeicaoDAO);
                    }else System.out.println("ERRO!!! Primeiro você deve criar uma dieta");
                    break;

                case 4:
                    if (dietaDAO.procuraUltimaDieta() != null) {
                        alimentoRefeicaoDAO.mostrarRefeicoesDietaUsuario(dietaDAO.procuraUltimaDieta());
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

    private boolean newDieta(AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO, DietaDAO dietaDAO) {
//        tipoDietaDAO.procuraDieta("Atleta").setDietaAtleta(ultAvaliacao); //Altera o TipoDeDieta Atleta para o peso do Usuário logado

        Dieta novaDieta = new Dieta();
        Scanner scan = new Scanner(System.in);

        novaDieta.setPessoa(Util.getPessoaLogada());
        novaDieta.setAvaliacaoFisica(ultAvaliacao);

        System.out.println("==============================");
        System.out.println("NOVA DIETA");
        System.out.println("==============================");
        System.out.println(tipoDietaDAO.toString());
        System.out.print("Qual o tipo de dieta você deseja? R: ");
        TipoDieta dietaSelecionada = tipoDietaDAO.procuraDieta(scan.nextLine());
        if (dietaSelecionada != null) novaDieta.setTipoDieta(dietaSelecionada);
        else return false;
        System.out.print("""
            
            1 - Diminuir o peso
            2 - Manter o peso
            3 - Aumentar o peso
            """);
        System.out.print("Qual o seu objetivo? R: ");
        int opc = Integer.parseInt(scan.nextLine());
        switch (opc){
            case 1:
                novaDieta.setObjetivo("Diminuir");
                novaDieta.setCalorias(ultAvaliacao.getTmb() - 350.0);
                break;

            case 2:
                novaDieta.setObjetivo("Manter");
                novaDieta.setCalorias(ultAvaliacao.getTmb());
                break;

            case 3:
                novaDieta.setObjetivo("Aumentar");
                novaDieta.setCalorias(ultAvaliacao.getTmb() + 350.0);
                break;

            default:
                return false;
        }
//        System.out.print("\nQuantas refeições deseja fazer (1 a 5)? R: ");
//        opc = Integer.parseInt(scan.nextLine());
//        if (opc >= 1 && opc <= 5){
//            novaDieta.setNroRefeicoes(opc);
//        }else return false;

        System.out.print(novaDieta.toString());
        return dietaDAO.adicionaDieta(novaDieta);
    }
}
