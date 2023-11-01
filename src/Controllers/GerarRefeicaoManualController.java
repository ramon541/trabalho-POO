package Controllers;

import Models.Alimento;
import Models.AlimentoRefeicao;
import Models.DAO.AlimentoDAO;
import Models.DAO.AlimentoRefeicaoDAO;
import Models.DAO.PreferenciaDAO;
import Models.DAO.RefeicaoDAO;
import Models.Dieta;
import Models.Refeicao;

import java.util.Scanner;

public class GerarRefeicaoManualController {
    Scanner scan = new Scanner(System.in);
    AlimentoRefeicao[] alimentosRefeicoes;
    double totGord=0.0, totCarbs=0.0, totProt=0.0, totCals=0.0;
    public GerarRefeicaoManualController(Dieta ultDieta, AlimentoDAO alimentoDAO, RefeicaoDAO refeicaoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO){
        int opc = 0;
        //Cria as 4 refeições padrão
        Refeicao r1 = new Refeicao();
        r1.setNomeDaRefeicao("Café da Manhã");
        r1.setDieta(ultDieta);
        refeicaoDAO.adicionaRefeicao(r1);

        Refeicao r2 = new Refeicao();
        r2.setNomeDaRefeicao("Almoço");
        r2.setDieta(ultDieta);
        refeicaoDAO.adicionaRefeicao(r2);

        Refeicao r3 = new Refeicao();
        r3.setNomeDaRefeicao("Café da Tarde");
        r3.setDieta(ultDieta);
        refeicaoDAO.adicionaRefeicao(r3);

        Refeicao r4 = new Refeicao();
        r4.setNomeDaRefeicao("Jantar");
        r4.setDieta(ultDieta);
        refeicaoDAO.adicionaRefeicao(r4);

        while(opc!=5){
            opc = this.gerarManualmente(r1, r2, r3, r4, alimentoRefeicaoDAO);
            totGord=0.0;
            totCarbs=0.0;
            totProt=0.0;
            totCals=0.0;
            switch (opc){
                case 1:
                    criaAlimentoRefeicao(r1, alimentoDAO, alimentoRefeicaoDAO);
                    break;

                case 2:
                    criaAlimentoRefeicao(r2, alimentoDAO, alimentoRefeicaoDAO);
                    break;

                case 3:
                    criaAlimentoRefeicao(r3, alimentoDAO, alimentoRefeicaoDAO);
                    break;

                case 4:
                    criaAlimentoRefeicao(r4, alimentoDAO, alimentoRefeicaoDAO);
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA!!! Digite novamente...");
                    break;
            }
        }
    }

    private int gerarManualmente(Refeicao r1, Refeicao r2, Refeicao r3, Refeicao r4, AlimentoRefeicaoDAO alimentoRefeicaoDAO){
        String builder = "";
        builder +=
            "==============================" +
            "\nGERAR ALIMENTAÇÃO MANUALMENTE" +
            "\n==============================";

            builder += "\n1 - Café da Manhã";
            builder += calculadora(r1, alimentoRefeicaoDAO);

            builder +="\n\n2 - Almoço";
            builder += calculadora(r2, alimentoRefeicaoDAO);

            builder += "\n\n3 - Café da Tarde";
            builder += calculadora(r3, alimentoRefeicaoDAO);

            builder += "\n\n4 - Jantar";
            builder += calculadora(r4, alimentoRefeicaoDAO);

            builder += "\n\n5 - Finalizar Alimentação" +
                "\n\nTotal: " + "    " + "Gord: " + String.format("%.2f",totGord) + " g | " +
                "Carbs: " + String.format("%.2f",totCarbs) + " g | " +
                "Prot: " + String.format("%.2f",totProt) + " g | " +
                "Cals: " + String.format("%.2f",totCals) + " cal"+
                "\n\nDeseja adicionar alimentos a qual refeição? R: ";
        System.out.print(builder);

        return Integer.parseInt(scan.nextLine());
    }

    private void criaAlimentoRefeicao(Refeicao refeicao, AlimentoDAO alimentoDAO, AlimentoRefeicaoDAO alimentoRefeicaoDAO){
        alimentoDAO.mostrarTodos();
        System.out.print("\nQual alimento você quer adicionar a/ao " + refeicao.getNomeDaRefeicao() + "? R: ");
        Alimento alimento = alimentoDAO.buscaPorNome(scan.nextLine());
        if (alimento != null){
            System.out.println(alimento.toString());
            AlimentoRefeicao novoAlimentoRefeicao = new AlimentoRefeicao();
            System.out.print("Quantas porções deseja? (Ex.: 1 || 1.5 || 2 || 2.3) R: ");
            double porcao = Double.parseDouble(scan.nextLine());

            novoAlimentoRefeicao.setAlimento(alimento);
            novoAlimentoRefeicao.setRefeicao(refeicao);
            novoAlimentoRefeicao.setPorcao(porcao * alimento.getPorcao());
            novoAlimentoRefeicao.setCalorias(porcao * alimento.getCalorias());
            novoAlimentoRefeicao.setProteina(porcao * alimento.getProteinas());
            novoAlimentoRefeicao.setGordura(porcao * alimento.getGorduras());
            novoAlimentoRefeicao.setCarboidrato(porcao * alimento.getCarboidratos());

            boolean adicionou = alimentoRefeicaoDAO.adicionaAlimentoRefeicao(novoAlimentoRefeicao, alimentoRefeicaoDAO.getAlimentoRefeicaoList());

            if (adicionou)System.out.println("Alimento adicionado a refeição com sucesso!!!");
            else System.out.println("ERRO!!! Algo não funcionou corretamente...");

        }else System.out.println("ERRO!!! Esse alimento não existe...");
    }

    private String calculadora(Refeicao refeicao, AlimentoRefeicaoDAO alimentoRefeicaoDAO){
        String builder = "";
        double gord=0.0,carbs=0.0,prot=0.0,cals=0.0;
        this.alimentosRefeicoes = alimentoRefeicaoDAO.procuraAlimentoDaRefeicao(refeicao);
        for (AlimentoRefeicao alimentoDaRef : alimentosRefeicoes){
            if (alimentoDaRef != null){
                builder += alimentoDaRef.toString();
                totGord += alimentoDaRef.getGordura();
                totCarbs += alimentoDaRef.getCarboidrato();
                totProt += alimentoDaRef.getProteina();
                totCals += alimentoDaRef.getCalorias();
            }
        }

        return builder;
    }
}
