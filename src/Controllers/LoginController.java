package Controllers;

import Models.Pessoa;
import Models.Util;
import Views.Menus;

public class LoginController {

    Menus menu = new Menus();
    public LoginController() {
        int opc;
        while (true) {
            opc = menu.menuLogin();
            switch (opc) {
                case 1:
                    Pessoa logado = menu.login();

                    if (logado != null){
                        System.out.println("Login feito com sucesso!!");
                        Util.setPessoaLogada(logado);

                        new MenuPrincipalController(menu);
                    } else {
                        System.out.println("Login Inválido. Tente novamente...");
                    }
                    break;

                case 2:
                    menu.registrar();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new LoginController();
    }
}
