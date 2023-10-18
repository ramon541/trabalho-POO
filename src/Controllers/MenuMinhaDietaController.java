package Controllers;

import Models.AvaliacaoFisica;
import Models.DAO.DietaDAO;
import Models.DAO.TipoDietaDAO;
import Models.Dieta;
import Views.Menus;

public class MenuMinhaDietaController {
    public MenuMinhaDietaController(Menus menu, AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO, DietaDAO dietaDAO){
        int opc = 0;
        while (opc != 4){
            opc = menu.menuMinhaDieta();

            switch (opc){
                case 1:
                    boolean dietaAdicionada = this.newDieta(ultAvaliacao, tipoDietaDAO, dietaDAO);
                    if (dietaAdicionada) System.out.println("Dieta adicionada com sucesso!!");
                    else System.out.println("ERRO!!! Algo deu errado...");
                    break;

                case 2:
                    System.out.println("Opção onde o Usuário vê os alimentos preferídos dele, podendo adicionar e excluir alimentos da preferência");
                    break;

                case 3:
                    System.out.println("Opção onde o Usuário cria as refeições e adiciona os alimentos nas refeições");
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

    private boolean newDieta(AvaliacaoFisica ultAvaliacao, TipoDietaDAO tipoDietaDAO, DietaDAO dietaDAO) {
        tipoDietaDAO.procuraDieta("Atleta").setDietaAtleta(ultAvaliacao); //Altera o TipoDeDieta Atleta para o peso do Usuário logado
        Dieta novaDieta = new Dieta();


        return true;
    }
}
