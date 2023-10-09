package Controllers;

import Models.DAO.MensagemDAO;
import Models.DAO.PostDAO;
import Models.DAO.SeguirDAO;
import Models.Pessoa;
import Views.Menus;

import java.util.Scanner;

public class RedeSocialBuscarController {

    StringBuilder builder;

    Scanner scan = new Scanner(System.in);

    public RedeSocialBuscarController(Menus menu, Pessoa usuarioBuscado, boolean ehSeguidor, SeguirDAO seguirDAO, MensagemDAO mensagemDAO, PostDAO postDAO) {
        int opc = 0;
        while (opc != 4) {
            opc = menu.menuRedeSocialBuscar(usuarioBuscado, ehSeguidor);
            switch (opc) {
                case 1:
                    builder = new StringBuilder("");

                    if(ehSeguidor) {
                        if(seguirDAO.deixarDeSeguir(usuarioBuscado)) {
                            builder.append("Deixando de seguir...");
                        } else {
                            builder.append("Não foi possível deixar de seguir!");
                        }
                    } else {
                        if(seguirDAO.seguirPessoa(usuarioBuscado)) {
                            builder.append("Seguindo ").append(usuarioBuscado.getNome());
                        } else {
                            builder.append("Não foi possível seguir o usuário.");
                        }
                    }

                    break;
                case 2:
                    postDAO.mostrarPostsUsuario(usuarioBuscado);

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
