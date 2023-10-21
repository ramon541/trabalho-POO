package Controllers;

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
                    alimentoDAO.mostrarTodos();
                    break;

                case 2:
                    preferenciaDAO.mostrarPreferidos();
                    break;

                case 3:
                    System.out.print("Digite o nome do alimento que deseja adicionar aos preferidos: ");
                    boolean preferenciaAdd = preferenciaDAO.adicionaPreferencia(scan.nextLine());
                    if(preferenciaAdd) {
                        System.out.println("Preferência adicionada.");
                    } else {
                        System.out.println("Não foi possível adicionar aos preferidos.");
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
