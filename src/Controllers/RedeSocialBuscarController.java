package Controllers;

import Models.DAO.MensagemDAO;
import Models.DAO.PostDAO;
import Models.DAO.SeguirDAO;
import Models.Pessoa;
import Models.Post;
import Models.Util;
import Views.Menus;

import java.util.List;
import java.util.Scanner;

public class RedeSocialBuscarController {

    StringBuilder builder;

    Scanner scan = new Scanner(System.in);

    public RedeSocialBuscarController(Menus menu, Pessoa usuarioBuscado, boolean ehSeguidor, SeguirDAO seguirDAO, MensagemDAO mensagemDAO, PostDAO postDAO) {
        int opc = 0;
        while (opc != 5) {
            opc = menu.menuRedeSocialBuscar(usuarioBuscado, ehSeguidor);
            switch (opc) {
                case 1:
                    builder = new StringBuilder("");

                    if(ehSeguidor) {
                        if(seguirDAO.deixarDeSeguir(Util.getPessoaLogada().getId(), usuarioBuscado.getId())) {
                            builder.append("Deixando de seguir...");
                        } else {
                            builder.append("Não foi possível deixar de seguir!");
                        }
                    } else {

                        long idSeguindo = seguirDAO.seguirPessoa(usuarioBuscado);

                        if(idSeguindo != 0) {
                            builder.append("Seguindo ").append(usuarioBuscado.getNome());
                        } else {
                            builder.append("Não foi possível seguir o usuário.");
                        }
                    }

                    break;
                case 2:
                    List<Post> posts = postDAO.buscarPostPorIdUsuario(usuarioBuscado.getId());

                    if(posts.size() != 0) {
                        for(Post p : posts) {
                            System.out.println(p.toString());
                        }
                    } else {
                        System.out.println("O usuário não tem nenhum post publicado!");
                    }

                    break;
                case 3:

                    System.out.println("Digite a mensagem a ser enviada: ");
                    String msg = scan.nextLine();
                    boolean msgEnviada = mensagemDAO.enviarMensagem(usuarioBuscado, msg);

                    if(msgEnviada) {
                        System.out.println("Mensagem enviada!");
                    } else {
                        System.out.println("Não foi possível enviar a mensagem!");
                    }

                    break;
                case 4:
                    mensagemDAO.verMensagens(usuarioBuscado);

                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
