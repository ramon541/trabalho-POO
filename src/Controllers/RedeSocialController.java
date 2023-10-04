package Controllers;

import Models.DAO.PostDAO;
import Models.Post;
import Models.Util;
import Views.Menus;

import java.util.Scanner;

public class RedeSocialController {

    StringBuilder builder;
    Scanner scan = new Scanner(System.in);

    public RedeSocialController(Menus menu, PostDAO postDAO) {
            int opc = 0;
            while (opc != 7) {
                opc = menu.menuRedeSocial();
                switch (opc) {
                    case 1:
                        postDAO.mostrarTodos();
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
                        System.out.println("Buscar usuário.");

                        break;

                    case 4:
                        System.out.println("Ver seguidores.");

                        break;
                    case 5:
                        System.out.println("Chat.");

                        break;
                    case 7:
                        System.out.println("Saindo...");

                        break;

                    default:
                        System.out.println("\n\nOPÇÃO INVÁLIDA!!");
                        break;
                }
            }
    }
}
