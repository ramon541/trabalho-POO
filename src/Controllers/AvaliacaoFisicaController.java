package Controllers;

import Views.Menus;

public class AvaliacaoFisicaController {
    public AvaliacaoFisicaController(Menus menu) {
        int opc = 0;
        while (opc != 2) {
            opc = menu.avaliacaoFisica();
            switch (opc) {
                case 1:
                    menu.newAvaliacaoFisica();
                    break;

                case 2:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                    break;
            }
        }
    }
}
