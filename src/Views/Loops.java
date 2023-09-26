package Views;

import Models.Pessoa;
import Models.Util;

public class Loops {
    Menu menu = new Menu();

    public Loops() {
        this.main();
    }

    public void programa() {
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
                    System.out.println("Menu Rede Social");
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

                        this.programa();
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


}
