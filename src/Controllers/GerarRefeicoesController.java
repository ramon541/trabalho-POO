package Controllers;

import Views.Menus;

import java.awt.*;

public class GerarRefeicoesController {
    public GerarRefeicoesController(Menus menu) {
        int opc = 0;
        while (opc != 3) {
            opc = menu.gerarRefeicoes();

            switch (opc) {
                case 1:
                    System.out.println("Gerar automaticamente");
                    break;

                case 2:
                    new GerarRefeicaoManualController();
                    break;

                case 3:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }
}