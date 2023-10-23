package Controllers;

import java.util.Scanner;

public class GerarRefeicaoManualController {
    Scanner scan = new Scanner(System.in);
    public GerarRefeicaoManualController(){
        int opc = 0;
        while(opc!=5){
            opc = this.gerarManualmente();
            switch (opc){
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!!! Digite novamente...");
                    break;
            }
        }
    }

    private int gerarManualmente(){
        String builder = "";
        builder +=
            "==============================" +
            "\nGERAR ALIMENTAÇÃO MANUALMENTE" +
            "\n==============================" +
            "\n1 - Café da Manhã" +
            "\n2 - Almoço" +
            "\n3 - Café da Tarde" +
            "\n4 - Jantar" +
            "\n5 - Voltar" +
            "\n\nDeseja adicionar alimentos a qual refeição? R: ";
        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }
}
