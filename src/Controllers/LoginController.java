package Controllers;

import Models.DAO.AvaliacaoFisicaDAO;
import Models.DAO.PessoaDAO;
import Models.DAO.PostDAO;
import Models.DAO.TipoDietaDAO;
import Models.Pessoa;
import Models.Util;
import Views.Menus;

public class LoginController {
    Menus menu = new Menus();
    PostDAO postDAO = new PostDAO();
    AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
    TipoDietaDAO tipoDietaDAO = new TipoDietaDAO();
    public LoginController() {

        PessoaDAO pessoaDAO = new PessoaDAO(getPostDAO());
        getMenu().setPessoaDAO(pessoaDAO);

        int opc;
        while (true) {
            opc = getMenu().menuLogin();
            switch (opc) {
                case 1:
                    Pessoa logado = getMenu().login();

                    if (logado != null){
                        System.out.println("Login feito com sucesso!!");
                        Util.setPessoaLogada(logado);

                        new MenuPrincipalController(getMenu(), getPostDAO(), getAvaliacaoFisicaDAO());
                    } else {
                        System.out.println("Login Inválido. Tente novamente...");
                    }
                    break;

                case 2:
                    getMenu().registrar();
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

    public static void main(String[] args) {
        new LoginController();
    }

    public Menus getMenu() {
        return menu;
    }

    public PostDAO getPostDAO() {
        return postDAO;
    }

    public AvaliacaoFisicaDAO getAvaliacaoFisicaDAO() { return avaliacaoFisicaDAO; }

}
