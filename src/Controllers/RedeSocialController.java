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
                        List<Post> meusPosts = postDAO.buscarPostPorIdUsuario(Util.getPessoaLogada().getId());

                        if(meusPosts.size() != 0) {
                            for(Post p : meusPosts) {
                                System.out.println(p.toString());
                            }
                        }else {
                            System.out.println("Você não publicou nada ainda.");
                        }

                        break;
                    case 2:
                        Post post = new Post();
                        builder = new StringBuilder("");
                        builder.append("Conteudo do post: ");
                        System.out.println(builder);

                        post.setConteudoPost(scan.nextLine());
                        post.setPessoa(Util.getPessoaLogada());
                        long idPost = postDAO.adicionaPost(post);

                        if(idPost != 0) {
                            System.out.println("Post criado com sucesso!");
                        }else {
                            System.out.println("Não foi possível criar o post!");
                        }

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

                            if(usuarioBuscado != null) {
                                System.out.println("Usuário enctrontrado!");

                                Seguir seguir = seguirDAO.buscaSeguir(Util.getPessoaLogada().getId(), usuarioBuscado.getId());

                                boolean ehSeguidor = false;

                                if(seguir != null) {
                                    System.out.println("seguir" + seguir.toString());
                                    ehSeguidor = seguir.isEstaSeguindo() == 1;
                                }

                                new RedeSocialBuscarController(menu, usuarioBuscado, ehSeguidor, seguirDAO, mensagemDAO, postDAO, seguir);

                            } else {
                                System.out.println("Não foi possível buscar esse usuário!");
                            }

                        } catch (ArithmeticException e) {
                            throw new RuntimeException("Erro ao buscar o usuário, digite um id válido.");
                        }

                        break;
                    case 4:
                         List<Pessoa> seguidores = seguirDAO.buscarSeguidores(Util.getPessoaLogada().getId());

                         if(seguidores.size() != 0) {
                             for(Pessoa p : seguidores) {
                                 System.out.println(p.toString());
                             }
                         }else {
                             System.out.println("Você não tem seguidores!");
                         }

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
