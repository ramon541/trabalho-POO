package Controllers;

import Models.DAO.*;
import Models.Pessoa;
import Models.Post;
import Models.Seguir;
import Models.Util;
import Views.Menus;

public class LoginController {
    private final Menus menu = new Menus();
    private final PostDAO postDAO = new PostDAO();
    private final SeguirDAO seguirDAO = new SeguirDAO();
    private final PessoaDAO pessoaDAO = new PessoaDAO(this.postDAO);
    private final AvaliacaoFisicaDAO avaliacaoFisicaDAO = new AvaliacaoFisicaDAO();
    private final AlimentoDAO alimentoDAO = new AlimentoDAO();
    private final TipoDietaDAO tipoDietaDAO = new TipoDietaDAO();
    private final DietaDAO dietaDAO = new DietaDAO();

    public LoginController() {
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

                        //criação de mais um usuário teste
                        criacaoNovosUsuariosTeste();

                        //mostrar timeline
                        this.verTimeline();

                        MensagemDAO mensagemDAO = new MensagemDAO();
                        new MenuPrincipalController(this.getMenu(), this.getPostDAO(), this.getSeguirDAO(),
                                pessoaDAO, mensagemDAO, this.getAvaliacaoFisicaDAO(), this.getAlimentoDAO(),
                                this.getTipoDietaDAO(), this.getDietaDAO());
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

    public void verTimeline() {
        StringBuilder builder = new StringBuilder();
        builder.append("=======================").append("\n");
        builder.append("TIMELINE").append("\n");
        builder.append("=======================").append("\n");

        for (Post post: postDAO.getPosts()) {
            if(post != null) {
                for (Seguir seguir: seguirDAO.getSeguindoList()) {
                    if (seguir != null && (post.getPessoa().equals(seguir.getSeguindo()) || post.getPessoa().equals(Util.getPessoaLogada()))) {
                        builder.append("Conteúdo: ").append(post.getConteudoDaMensagem()).append("\n");
                        builder.append("Publicado por: ").append(post.getPessoa().getNome()).append("\n");
                        builder.append("=============================").append("\n");
                    }
                }
            }
        }

        System.out.println(builder);
    }

    public void criacaoNovosUsuariosTeste() {
        Pessoa p2 = new Pessoa();
        p2.setNome("Fulana");
        p2.setNascimento("05/05/2000");
        p2.setSexo("Feminina");
        p2.setLogin("fulana");
        p2.setSenha("fulana");
        p2.setTipoUsuario("comum");

        this.pessoaDAO.adicionaPessoa(p2);

        Post post2 = new Post();
        post2.setConteudoDaMensagem("Post Teste");
        post2.setPessoa(p2);

        postDAO.adicionaPost(post2);

        //fazer o usuário admin seguir o novo usuário teste
        this.seguirDAO.seguirPessoa(p2);
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
    public AvaliacaoFisicaDAO getAvaliacaoFisicaDAO() { return this.avaliacaoFisicaDAO; }
    public AlimentoDAO getAlimentoDAO() { return alimentoDAO; }
    public TipoDietaDAO getTipoDietaDAO() { return tipoDietaDAO; }
    public DietaDAO getDietaDAO() { return dietaDAO; }
}
