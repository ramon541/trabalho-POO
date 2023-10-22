package Controllers;

import Models.Alimento;
import Models.DAO.AlimentoDAO;
import Models.DAO.PreferenciaDAO;
import Views.Menus;

import java.util.Scanner;

public class AlimentoPreferenciaController {

    Scanner scan = new Scanner(System.in);
    public AlimentoPreferenciaController(Menus menu, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO){
        int opc = 0;
        while (opc != 5){
            opc = menu.alimentoPreferencia();

            switch (opc){
                case 1:
                    preferenciaDAO.mostrarPreferidos();
                    break;

                case 2:
                    alimentoDAO.mostrarTodos();
                    break;

                case 3:
                    System.out.print("Digite o nome do alimento que deseja adicionar aos preferidos: ");
                    Alimento alimento = alimentoDAO.buscaPorNome(scan.nextLine());

                    if(alimento != null){
                        boolean alimentoAdicionado = preferenciaDAO.adicionaPreferencia(alimento);

                        if(alimentoAdicionado) {
                            System.out.println("Alimento adicionado aos preferidos!");
                        } else {
                            System.out.println("Não foi possível adicionar o alimento aos preferidos!");
                        }
                    } else {
                        System.out.println("Não foi possível encontrar o alimento. Verifique se o nome foi digitado corretamente.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do alimento que deseja remover dos preferidos: ");
                    boolean preferenciaRemovida = preferenciaDAO.remover(scan.nextLine());
                    if(preferenciaRemovida) {
                        System.out.println("Preferência removida.");
                    } else {
                        System.out.println("Não foi possível remover dos preferidos.");
                    }
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }
}
