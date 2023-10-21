package Controllers;

import Models.DAO.AlimentoDAO;
import Models.DAO.PreferenciaDAO;
import Views.Menus;

public class MenuMinhaDietaController {
    public MenuMinhaDietaController(Menus menu, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO){
        int opc = 0;
        while (opc != 4){
            opc = menu.menuMinhaDieta();

            switch (opc){
                case 1:
                    System.out.println("Nova dieta...");
                    break;

                case 2:
                    new AlimentoPreferenciaController(menu, alimentoDAO, preferenciaDAO);
                    break;

                case 3:
                    System.out.println("Opção onde o Usuário cria as refeições e adiciona os alimentos nas refeições");
                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }
}
