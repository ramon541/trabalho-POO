package Controllers;

import Models.DAO.AvaliacaoFisicaDAO;
import Models.DAO.PostDAO;
import Models.Util;
import Views.Menus;

public class MenuPrincipalController {
    public MenuPrincipalController(Menus menu, PostDAO postDAO, AvaliacaoFisicaDAO avaliacaoFisicaDAO) {
            int opc = 0;
            while (opc != 9) {
                opc = menu.menuPrincipal();
                switch (opc) {
                    case 1:
                        new AvaliacaoFisicaController(avaliacaoFisicaDAO);
                        break;

                    case 2:
                        new RegistroDietaController(menu);
                        break;

                    case 3:
                        new RedeSocialController(menu, postDAO);
                        break;

                    case 8:
                        if (Util.getPessoaLogada().getTipoUsuario().equals("admin")){
                            //Menu painel admin
                        } else {
                            System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                        }
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
