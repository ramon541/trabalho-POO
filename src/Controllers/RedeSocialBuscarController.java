package Controllers;

import Models.*;
import Models.DAO.MensagemDAO;
import Models.DAO.PostDAO;
import Models.DAO.SeguirDAO;
import Views.Menus;

import java.util.List;
import java.util.Scanner;

public class RedeSocialBuscarController {

    StringBuilder builder;

    Scanner scan = new Scanner(System.in);

    public RedeSocialBuscarController(Menus menu, Pessoa usuarioBuscado, boolean ehSeguidor, SeguirDAO seguirDAO, MensagemDAO mensagemDAO, PostDAO postDAO, Seguir seguir) {
        int opc = 0;
        while (opc != 5) {
            opc = menu.menuRedeSocialBuscar(usuarioBuscado, ehSeguidor);
            switch (opc) {
                case 1:
                    builder = new StringBuilder("");

                    if(ehSeguidor) {
                        if(seguirDAO.updateSeguir(seguir.getId(), 0)) {
                            builder.append("Deixando de seguir...");
                            ehSeguidor = false;
                        } else {
                            builder.append("Não foi possível deixar de seguir!");
                        }
                    } else {

                        long idSeguindo;

                        if(seguir == null) {
                            idSeguindo = seguirDAO.seguirPessoa(usuarioBuscado);

                            if(idSeguindo != 0) {
                                builder.append("Seguindo ").append(usuarioBuscado.getNome());
                                ehSeguidor = true;
                            } else {
                                builder.append("Não foi possível seguir o usuário.");
                            }

                        } else {
                            boolean agoraSegue = seguirDAO.updateSeguir(seguir.getId(), 1);

                            if(agoraSegue) {
                                builder.append("Seguindo ").append(usuarioBuscado.getNome());
                                ehSeguidor = true;
                            } else {
                                builder.append("Não foi possível seguir o usuário.");
                            }
                        }


                    }

                    System.out.println(builder);

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

                    long msgEnviada = mensagemDAO.enviarMensagem(Util.getPessoaLogada(), usuarioBuscado, msg);

                    if(msgEnviada != 0) {
                        System.out.println("Mensagem enviada!");
                    } else {
                        System.out.println("Não foi possível enviar a mensagem!");
                    }

                    break;
                case 4:

                    StringBuilder builder = new StringBuilder();
                    builder.append("=======================").append("\n");
                    builder.append("CHAT").append("\n");
                    builder.append("=======================").append("\n");
                    System.out.println(builder);

                    List<Mensagem> mensagens = mensagemDAO.buscaMensagens(Util.getPessoaLogada(), usuarioBuscado);

                    if(mensagens.size() != 0) {
                        for(Mensagem mensagem : mensagens) {
                            System.out.println("\n" + mensagem.getRemetente().getNome() + " :");
                            System.out.println(mensagem.getMensagem());
                        }
                    } else {
                        System.out.println("Não há nenhuma mensagem.");
                    }

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
