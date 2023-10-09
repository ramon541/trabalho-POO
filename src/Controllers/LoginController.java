package Controllers;

import Models.DAO.MensagemDAO;
import Models.DAO.PessoaDAO;
import Models.DAO.PostDAO;
import Models.DAO.SeguirDAO;
import Models.Pessoa;
import Models.Util;
import Views.Menus;

public class LoginController {
    private final Menus menu = new Menus();
    private final PostDAO postDAO = new PostDAO();
    private final SeguirDAO seguirDAO = new SeguirDAO();

    private final MensagemDAO mensagemDAO = new MensagemDAO();
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

                        new MenuPrincipalController(this.getMenu(), this.getPostDAO(), this.getSeguirDAO(), pessoaDAO, this.mensagemDAO);
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

    public SeguirDAO getSeguirDAO() {
        return this.seguirDAO;
    }
}
