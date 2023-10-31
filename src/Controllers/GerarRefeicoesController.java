package Controllers;

import Models.DAO.AlimentoDAO;
import Models.DAO.AlimentoRefeicaoDAO;
import Models.DAO.PreferenciaDAO;
import Models.DAO.RefeicaoDAO;
import Models.Dieta;
import Views.Menus;

import java.awt.*;

public class GerarRefeicoesController {
    public GerarRefeicoesController(Menus menu, Dieta ultDieta, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO, RefeicaoDAO refeicaoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO) {
        int opc = 0;
        while (opc != 3) {
            opc = menu.gerarRefeicoes();

            switch (opc) {
                case 1:
                    System.out.println("Gerar automaticamente");
                    break;

                case 2:
                    new GerarRefeicaoManualController(ultDieta, alimentoDAO, refeicaoDAO, alimentoRefeicaoDAO);
                    break;

                case 3:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }
}