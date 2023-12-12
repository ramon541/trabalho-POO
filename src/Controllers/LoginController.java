package Controllers;

import Models.DAO.*;
import Models.Pessoa;
import Models.Post;
import Models.Seguir;
import Models.Util;
import Views.Menus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private final Menus menu = new Menus();

    private final AlimentoDAO alimentoDAO = new AlimentoDAO();
    private final TipoDietaDAO tipoDietaDAO = new TipoDietaDAO();
    private final PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    private final AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO(this.pessoaDAO);
    private final DietaDAO dietaDAO = new DietaDAO(this.pessoaDAO, this.avaliacaoFisicaDAO, this.tipoDietaDAO);
    private final SeguirDAO seguirDAO = new SeguirDAO(this.pessoaDAO);
    private final PostDAO postDAO = new PostDAO(this.pessoaDAO);
    private final RefeicaoDAO refeicaoDAO = new RefeicaoDAO(this.dietaDAO);
    private final AlimentoRefeicaoDAO alimentoRefeicaoDAO = new AlimentoRefeicaoDAO();

    public LoginController() throws SQLException {
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

                        //mostrar timeline
                        this.verTimeline();

                        MensagemDAO mensagemDAO = new MensagemDAO(this.pessoaDAO);
                        new MenuPrincipalController(this.getMenu(), this.getPostDAO(), this.getSeguirDAO(),
                                pessoaDAO, mensagemDAO, this.getAvaliacaoFisicaDAO(), this.getAlimentoDAO(),
                                this.getTipoDietaDAO(), this.getDietaDAO(), this.getPreferenciaDAO(), this.getRefeicaoDAO(), this.getAlimentoRefeicaoDAO());
                    } else {
                        System.out.println("Login ou Senha Inválidos. Tente novamente...");
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

    public void verTimeline() throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("=======================").append("\n");
        builder.append("TIMELINE").append("\n");
        builder.append("=======================").append("\n");
        System.out.println(builder);

        List<Post> postList = postDAO.buscaTodos();

        List<Pessoa> seguindoList = seguirDAO.buscarPessoasSeguindo(Util.getPessoaLogada().getId());

        if(postList.size() != 0 && seguindoList.size() != 0) {
            for (Post post: postList) {
                for(Pessoa p : seguindoList) {
                    if(post.getPessoa().equals(Util.getPessoaLogada()) || post.getPessoa().equals(p))
                        System.out.println(post);
                }
            }
        } else {
            System.out.println("Feed vazio! Não há nenhum post publicado ainda.");
        }
    }

    public static void main(String[] args) throws SQLException {
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
    public AvaliacaoFisicaDAO getAvaliacaoFisicaDAO() { return this.avaliacaoFisicaDAO; }
    public AlimentoDAO getAlimentoDAO() { return alimentoDAO; }
    public TipoDietaDAO getTipoDietaDAO() { return tipoDietaDAO; }
    public DietaDAO getDietaDAO() { return dietaDAO; }
    public PreferenciaDAO getPreferenciaDAO() {
        return preferenciaDAO;
    }
    public RefeicaoDAO getRefeicaoDAO() { return this.refeicaoDAO; }
    public AlimentoRefeicaoDAO getAlimentoRefeicaoDAO() { return alimentoRefeicaoDAO; }

}
