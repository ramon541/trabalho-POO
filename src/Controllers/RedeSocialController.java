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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeSocialController {

    StringBuilder builder;
    Scanner scan = new Scanner(System.in);

    public RedeSocialController(Menus menu, PostDAO postDAO, SeguirDAO seguirDAO, PessoaDAO pessoaDAO, MensagemDAO mensagemDAO) throws SQLException {
            int opc = 0;
            while (opc != 5) {
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
                        builder = new StringBuilder("");
                        builder.append("=====================").append("\n");
                        builder.append("LISTA DE USUÁRIOS").append("\n");
                        builder.append("=====================").append("\n");

                        List<Pessoa> usuarios = pessoaDAO.buscaTodos();

                        for(Pessoa usuario : usuarios) {
                            System.out.println(usuario.toString());
                        }

                        builder.append("=====================").append("\n");
                        builder.append("BUSCAR USUÁRIO").append("\n");
                        builder.append("=====================").append("\n");

                        builder.append("Digite o ID do usuário que deseja buscar: ");

                        System.out.println(builder);

                        try {
                            Pessoa usuarioBuscado = pessoaDAO.buscaPorID(Integer.parseInt(scan.nextLine()));

                            System.out.println("Usuário enctrontrado!");

                            boolean ehSeguidor = seguirDAO.ehSeguidor(usuarioBuscado);

                            new RedeSocialBuscarController(menu, usuarioBuscado, ehSeguidor, seguirDAO, mensagemDAO, postDAO);

                        } catch (ArithmeticException e) {
                            throw new RuntimeException("Erro ao buscar o usuário, digite um id válido.");
                        }

                        break;
                    case 4:
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
