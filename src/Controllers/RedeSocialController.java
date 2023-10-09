package Controllers;

import Models.DAO.MensagemDAO;
import Models.DAO.PessoaDAO;
import Models.DAO.PostDAO;
import Models.DAO.SeguirDAO;
import Models.Pessoa;
import Models.Post;
import Models.Seguir;
import Models.Util;
import Views.Menus;

import java.util.Scanner;

public class RedeSocialController {

    StringBuilder builder;
    Scanner scan = new Scanner(System.in);

    public RedeSocialController(Menus menu, PostDAO postDAO, SeguirDAO seguirDAO, PessoaDAO pessoaDAO, MensagemDAO mensagemDAO) {
            int opc = 0;
            while (opc != 7) {
                opc = menu.menuRedeSocial();
                switch (opc) {
                    case 1:
                        //ver meus posts
                        postDAO.mostrarPostsUsuario(Util.getPessoaLogada());
                        break;
                    case 2:
                        Post post = new Post();
                        builder = new StringBuilder("");
                        builder.append("Conteudo do post: ");
                        System.out.println(builder);

                        post.setConteudoDaMensagem(scan.nextLine());
                        post.setPessoa(Util.getPessoaLogada());
                        postDAO.adicionaPost(post);

                        break;

                    case 3:
                        System.out.println("Buscar usuário");

                        System.out.println("=====================\n");
                        System.out.println("Buscar usuário\n");
                        System.out.println("=====================\n");
                        System.out.println("Digite o nome do usuário que deseja pesquisar: ");
                        Pessoa usuarioBuscado = pessoaDAO.buscaPorNome(scan.nextLine());

                        if(usuarioBuscado == null) {
                            System.out.println("Não existe nenhum usuário com esse nome.");
                        } else {
                            System.out.println("Usuário enctrontrado!");

                            boolean ehSeguidor = seguirDAO.ehSeguidor(usuarioBuscado);

                            new RedeSocialBuscarController(menu, usuarioBuscado, ehSeguidor, seguirDAO, mensagemDAO, postDAO);
                        }

                        break;
                    case 4:
                        //ver seguidores
                        seguirDAO.mostrarSeguidores();

                        break;

                    case 5:
                        System.out.println("Saindo...");

                        break;

                    default:
                        System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                        break;
                }
            }
    }
}
