/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Views;

import Models.DAO.PessoaDAO;
import Models.Pessoa;
import Models.Util;

import java.util.Scanner;

public class Menus {
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    Scanner scan = new Scanner(System.in);
    public int menuLogin() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Logar");
        builder.append("\n2 - Cadastrar");
        builder.append("\n3 - Finalizar programa");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public int menuPrincipal() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Avaliação Física");
        builder.append("\n2 - Dieta");
        builder.append("\n3 - Rede Social");
        if (Util.getPessoaLogada().getTipoUsuario().equals("admin")){
            builder.append("\n8 - Painel Administrativo");
        }
        builder.append("\n9 - Logout;");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public Pessoa login() {
        String login;
        String senha;
        System.out.println("==============================");
        System.out.println("LOGIN");
        System.out.println("==============================");
        System.out.print("Usuário: ");
        login = scan.nextLine();
        System.out.print("Senha: ");
        senha = scan.nextLine();

        return pessoaDAO.buscaLogin(login, senha);
    }

    public void registrar () {
        Pessoa novoUsuario = new Pessoa();

        System.out.println("==============================");
        System.out.println("REGISTRAR");
        System.out.println("==============================");
        System.out.print("Nome: ");
        novoUsuario.setNome(scan.nextLine());
        System.out.print("Login: ");
        novoUsuario.setLogin(scan.nextLine());
        System.out.print("Senha: ");
        novoUsuario.setSenha(scan.nextLine());

        boolean adicionado = this.pessoaDAO.adicionaPessoa(novoUsuario);
        if (adicionado){
            System.out.println("Cadastro realizado com sucesso!!");
        }else {
            System.out.println("Falha no cadastro. Tente novamente!!");
        }
    }

    public int menuRedeSocial() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("REDE SOCIAL\n");
        builder.append("==============================\n");
        builder.append("\n1 - Ver posts");
        builder.append("\n2 - Criar um novo post");
        builder.append("\n3 - Buscar usuário");
        builder.append("\n4 - Ver seguidores");
        builder.append("\n5 - Chat");
        builder.append("\n7 - Sair");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }
}
