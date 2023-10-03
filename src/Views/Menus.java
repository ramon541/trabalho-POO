/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Views;

import Models.AvaliacaoFisica;
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

        System.out.print("Sexo [Masculino] ou [Feminino]: ");
        novoUsuario.setSexo(scan.nextLine());

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        novoUsuario.setNascimento(scan.nextLine());

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

    public int avaliacaoFisica() {
        StringBuilder builder = new StringBuilder("");

        builder.append("==============================\n");
        builder.append("AVALIAÇÃO FÍSICA\n");
        builder.append("==============================\n");
        builder.append("1 - Nova Avaliação Física\n");
        builder.append("2 - Voltar");
        builder.append("\n\nQual a sua opção? R: ");

        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    public void newAvaliacaoFisica () {
        AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();

        System.out.println("==============================");
        System.out.println("NOVA AVALIAÇÃO FÍSICA");
        System.out.println("==============================");
        System.out.print("Qual o seu peso?(KG) R: ");
        novaAvaliacao.setPeso(Double.parseDouble(scan.nextLine()));
        System.out.print("Qual a sua altura?(cm) R: ");
        novaAvaliacao.setAltura(Integer.parseInt(scan.nextLine()));
        System.out.print("Qual a sua idade? R: ");
        novaAvaliacao.setIdade(Integer.parseInt(scan.nextLine()));
        System.out.print("Qual a medida do seu pescoço?(cm) R: ");
        novaAvaliacao.setPescoco(Integer.parseInt(scan.nextLine()));
        System.out.print("Qual a medida da sua cintura?(cm) R: ");
        novaAvaliacao.setCintura(Integer.parseInt(scan.nextLine()));
        if (novaAvaliacao.getPessoa().getSexo().equals("Feminino")){
            System.out.print("Qual a medida do seu quadril?(cm) R: ");
            novaAvaliacao.setQuadril(Integer.parseInt(scan.nextLine()));
        }

        System.out.print("""
                Qual a sua taxa de atividade?
                1 - Sedentário (pouco ou nenhum exercício)
                2 - Levemente ativo (exercício leve 1 a 3 dias por semana)
                3 - Moderadamente ativo (exercício moderado 6 a 7 dias por semana)
                4 - Muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)
                5 - Extra ativo (exercício muito difícil, treinamento ou trabalho físico)
                """);
        System.out.print("R: ");
        int opc = Integer.parseInt(scan.nextLine());
        switch (opc) {
            case 1:
                novaAvaliacao.setFatorTaxaAtividade(1.2);
                break;

            case 2:
                novaAvaliacao.setFatorTaxaAtividade(1.375);
                break;

            case 3:
                novaAvaliacao.setFatorTaxaAtividade(1.55);
                break;

            case 4:
                novaAvaliacao.setFatorTaxaAtividade(1.725);
                break;

            case 5:
                novaAvaliacao.setFatorTaxaAtividade(1.9);
                break;
            default:
                novaAvaliacao.setFatorTaxaAtividade(1.2);
                System.out.println("OPÇÃO INVÁLIDA!! Taxa de atividade setada como 1 - Sedentário");
                break;
        }

        novaAvaliacao.calcularIMC();
        novaAvaliacao.calcularTMB();
        novaAvaliacao.calcularBodyFat();
        System.out.println(novaAvaliacao.toString());
        boolean adicionado = Util.getPessoaLogada().getAvaliacaoFisicaDAO().adicionaAvaliacao(novaAvaliacao);
        if (adicionado){
            System.out.println("AVALIAÇÃO ADICIONADA COM SUCESSO!!");
        } else {
            System.out.println("OPS, ALGO DEU ERRADO!");
        }

    }
}