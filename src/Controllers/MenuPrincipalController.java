package Controllers;

import Models.Util;
import Views.Menus;

public class MenuPrincipalController {
    public MenuPrincipalController(Menus menu) {
            int opc = 0;
            while (opc != 9) {
                opc = menu.menuPrincipal();
                switch (opc) {
                    case 1:
                        System.out.println("Menu Avaliação física");
                        break;

                    case 2:
                        System.out.println("Menu Dieta");
                        break;

                    case 3:
                        new RedeSocialController(menu);
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
