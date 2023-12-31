package Controllers;

import Models.AvaliacaoFisica;
import Models.DAO.*;
import Models.Util;
import Views.Menus;

import java.sql.SQLException;

public class MenuPrincipalController {
    public MenuPrincipalController(Menus menu, PostDAO postDAO, SeguirDAO seguirDAO, PessoaDAO pessoaDAO,
                                   MensagemDAO mensagemDAO, AvaliacaoFisicaDAO avaliacaoFisicaDAO,
                                   AlimentoDAO alimentoDAO, TipoDietaDAO tipoDietaDAO, DietaDAO dietaDAO,
                                   PreferenciaDAO preferenciaDAO, RefeicaoDAO refeicaoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO) throws SQLException {
            int opc = 0;
            while (opc != 9) {
                opc = menu.menuPrincipal();
                switch (opc) {
                    case 1:
                        new AvaliacaoFisicaController(avaliacaoFisicaDAO);
                        break;

                    case 2:
                        //Esse if verifica se o Usuário fez alguma avaliação física

                        AvaliacaoFisica ultAvaliacao = avaliacaoFisicaDAO.buscaUltimaAvaliacao(Util.getPessoaLogada().getId());

                        if (ultAvaliacao == null){
                            System.out.println("Primeiro você deve fazer uma Avaliação Física!!");
                        }else {
                            new MenuMinhaDietaController(menu, ultAvaliacao, tipoDietaDAO, dietaDAO, alimentoDAO, preferenciaDAO, refeicaoDAO, alimentoRefeicaoDAO);
                        }
                        break;

                    case 3:
                        new RedeSocialController(menu, postDAO, seguirDAO, pessoaDAO, mensagemDAO);
                        break;

                    case 9:
                        System.out.println("Logout...");
                        Util.setPessoaLogada(null);
                        break;

                    default:
                        System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                        break;
                }
            }

    }
}
