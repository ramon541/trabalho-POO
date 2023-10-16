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
    private PessoaDAO pessoaDAO;
    Scanner scan = new Scanner(System.in);

    StringBuilder builder;
    public int menuLogin() {
        builder = new StringBuilder("");

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
        builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Avaliação Física");
        builder.append("\n2 - Minha Dieta");
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

        return getPessoaDAO().buscaLogin(login, senha);
    }

    public void registrar () {
        Pessoa novoUsuario = new Pessoa();

        System.out.println("==============================");
        System.out.println("REGISTRAR");
        System.out.println("==============================");

        System.out.print("Nome: ");
        novoUsuario.setNome(scan.nextLine());

        System.out.print("Sexo [Masculino] ou [Feminino]: ");
        novoUsuario.setSexo(scan.nextLine());

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        novoUsuario.setNascimento(scan.nextLine());

        System.out.print("Login: ");
        novoUsuario.setLogin(scan.nextLine());

        System.out.print("Senha: ");
        novoUsuario.setSenha(scan.nextLine());

        boolean adicionado = getPessoaDAO().adicionaPessoa(novoUsuario);
        if (adicionado){
            System.out.println("Cadastro realizado com sucesso!!");
        }else {
            System.out.println("Falha no cadastro. Tente novamente!!");
        }
    }

    public int menuRedeSocial() {
        builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("REDE SOCIAL\n");
        builder.append("==============================\n");
        builder.append("\n1 - Ver meus posts");
        builder.append("\n2 - Criar um novo post");
        builder.append("\n3 - Buscar usuário");
        builder.append("\n4 - Ver seguidores");
        builder.append("\n5 - Sair");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public int menuRedeSocialBuscar(Pessoa usuario, boolean ehSeguidor) {
        builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("USUÁRIO BUSCADO\n");
        builder.append("Nome: ").append(usuario.getNome()).append("\n");
        builder.append("==============================\n");

        if(ehSeguidor) {
            builder.append("\n1 - Deixar de seguir");
        } else {
            builder.append("\n1 - Seguir");
        }

        builder.append("\n2 - Ver posts");
        builder.append("\n3 - Enviar mensagem");
        builder.append("\n4 - Ver mensagens");
        builder.append("\n5 - Sair");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public int menuMinhaDieta(){
        builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("MINHA DIETA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Nova Dieta;");
        builder.append("\n2 - Alimentos Preferidos;");
        builder.append("\n3 - Meu Diário Alimentar;");
        builder.append("\n4 - Voltar;");

        return Integer.parseInt(scan.nextLine());
    }
    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }
}