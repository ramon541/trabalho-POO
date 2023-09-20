package Views;

import Models.Pessoa;
import Models.Util;

public class Loops {
    Menu menu = new Menu();

    public void programa() {
        int opc = 0;
        while (opc != 5) {
            opc = menu.menuPrincipal();
            switch (opc) {
                case 1:
                    System.out.println("Menu Alimento Refeição");
                    break;

                case 2:
                    System.out.println("Menu Avaliação física");
                    break;

                case 3:
                    System.out.println("Menu Registro de Dieta");
                    break;

                case 4:
                    System.out.println("Menu Refeições");
                    break;

                case 5:
                    System.out.println("Logout...");
                    Util.setPessoaLogada(null);
                    break;

                case 9:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                    break;
            }
        }
    }

    public void main() {
        int opc;
        while (true) {
            opc = menu.menuLogin();
            switch (opc) {
                case 1:
                    Pessoa logado = menu.login();

                    if (logado != null){
                        System.out.println("Login feito com sucesso!!");
                        Util.setPessoaLogada(logado);

                        programa();
                    } else {
                        System.out.println("Login Inválido. Tente novamente...");
                    }
                    break;

                case 2:
                    //Método para criar o cadastro de um novo usuário
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                    break;
            }
        }
    }


}
