package Controllers;

import Models.Feed;
import Views.Menus;

public class RedeSocialController {

    public RedeSocialController(Menus menu) {
            int opc;
            while (true) {
                opc = menu.menuRedeSocial();
                switch (opc) {
                    case 1:
                        Feed.mostrarTodos();
                        break;
                    case 2:
                        System.out.println("Criar um novo post.");
                        break;

                    case 3:
                        System.out.println("Buscar usuário.");

                        break;

                    case 4:
                        System.out.println("Ver seguidores.");

                        break;
                    case 5:
                        System.out.println("Chat.");

                        break;
                    case 7:
                        System.out.println("Saindo...");

                        break;

                    default:
                        System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                        break;
                }
            }
    }
}
