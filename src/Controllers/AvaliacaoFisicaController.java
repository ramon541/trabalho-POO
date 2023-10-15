package Controllers;

import Models.AvaliacaoFisica;
import Models.DAO.AvaliacaoFisicaDAO;

import java.util.Scanner;

public class AvaliacaoFisicaController {
    Scanner scan = new Scanner(System.in);
    public AvaliacaoFisicaController(AvaliacaoFisicaDAO avaliacaoFisicaDAO) {
        newAvaliacaoFisica(avaliacaoFisicaDAO);
    }

    public void newAvaliacaoFisica (AvaliacaoFisicaDAO avaliacaoFisicaDAO) {
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
        System.out.println(novaAvaliacao);
        boolean adiconado = avaliacaoFisicaDAO.adicionaAvaliacao(novaAvaliacao);
        if (adiconado){
            System.out.println("Avaliação física adicionada com sucesso!!");
        } else {
            System.out.println("Opsss... Não foi possível adicionar a Avalição Física.");
        }
    }
}