package Views;

import Models.Pessoa;
import Models.Util;

import java.util.Scanner;

public class View {

    public static int loopPrograma() {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        int fecharPrograma = 0;
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
                    opc = 5;
                    fecharPrograma = 9;
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                    break;
            }
        }
        return fecharPrograma;
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);
        int opc = 0;
        while (true) {
            opc = menu.menuLogin();
            switch (opc) {
                case 1:
                    Pessoa logado = menu.login();

                    if (logado != null){
                        System.out.println("Login feito com sucesso!!");
                        Util.setPessoaLogada(logado);

                        opc = loopPrograma();
                        if (opc == 9){
                            System.out.println("Saindo...");
                            scan.close();
                            System.exit(0);
                        }
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
