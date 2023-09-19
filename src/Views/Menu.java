/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Views;

import Models.DAO.PessoaDAO;
import Models.Pessoa;

import java.util.Scanner;

public class Menu {
    private PessoaDAO pessoaDAO = new PessoaDAO();
    Scanner scan = new Scanner(System.in);
    public int menuLogin() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Logar");
        builder.append("\n2 - Cadastrar");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public int menuPrincipal() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n");
        builder.append("==============================\n");
        builder.append("\n1 - Alimento/Receita;");
        builder.append("\n2 - Avaliação física;");
        //No Registo de Dieta terá o Tipo de Dieta (Equilibrada, Low Carb, Cetogênica...) e também perguntará o Objetivo (Diminuir o Peso, Manter o Peso, Melhorar Composição Corporal e Aumentar o Peso.)
        builder.append("\n3 - Registro de Dieta;");
        //Em Refeições (café da manhã, almoço, café da tarde, janta, ceia ou outro nome) terá o Alimento das Refeições que iremos conseguri adicionar os elementos e terá também a Preferência
        builder.append("\n4 - Refeições;");
        builder.append("\n5 - Logout;");
        builder.append("\n9 - Fechar programa;");
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
        System.out.print("\nUsuário: ");
        login = scan.nextLine();
        System.out.print("\nSenha: ");
        senha = scan.nextLine();

        return pessoaDAO.buscaLogin(login, senha);
    }

    public void registrar () {

    }
}
