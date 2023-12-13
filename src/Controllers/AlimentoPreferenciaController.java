package Controllers;

import Models.Alimento;
import Models.DAO.AlimentoDAO;
import Models.DAO.PreferenciaDAO;
import Views.Menus;

import java.sql.SQLException;
import java.util.Scanner;

public class AlimentoPreferenciaController {

    Scanner scan = new Scanner(System.in);
    public AlimentoPreferenciaController(Menus menu, AlimentoDAO alimentoDAO, PreferenciaDAO preferenciaDAO) throws SQLException {
        int opc = 0;
        while (opc != 4){
            opc = menu.alimentoPreferencia();

            switch (opc){
                case 1:
                    preferenciaDAO.mostrarPreferidos();
                    break;

                case 2:
                    System.out.println(alimentoDAO.buscaTodosAlimentos());
                    break;

                case 3:
                    System.out.print("Digite o nome do alimento que deseja adicionar aos preferidos: ");
                    Alimento alimento = alimentoDAO.buscaAlimentoPorId(Long.parseLong(scan.nextLine()));

                    if(alimento != null){
                        preferenciaDAO.adicionaPreferencia(alimento);
                    } else {
                        System.out.println("Não foi possível encontrar o alimento. Verifique se o nome foi digitado corretamente.");
                    }
                    break;

                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!! Selecione outra opção...");
                    break;
            }
        }
    }
}
