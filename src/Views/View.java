package Views;

import Models.Pessoa;
import Models.Util;

import java.util.Scanner;

public class View {
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

                        //Método do menu principal
                    } else {
                        System.out.println("Login Inválido. Tente novamente...");
                    }
                    break;

                case 2:
                    //Método para criar o cadastro de um novo usuário
                    break;

                default:
                    System.out.println("\n\nOPÇÃO INVÁLIDA!!");
            }
        }
    }
}
