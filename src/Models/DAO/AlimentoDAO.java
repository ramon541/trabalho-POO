package Models.DAO;

import Models.Alimento;
import Models.AvaliacaoFisica;

public class AlimentoDAO {
    Alimento[] alimentos = new Alimento[25];

    public AlimentoDAO() {
        Alimento a1 = new Alimento();
        a1.setNome("Arroz Branco (Cozido)");
        a1.setCarboidratos(28.18);
        a1.setProteinas(2.5);
        a1.setGorduras(0.23);
        a1.setCalorias();
        a1.setPorcao(100.0);
        this.adicionaAlimento(a1);

        Alimento a2 = new Alimento();
        a2.setNome("Feijão Carioca (Cozido)");
        a2.setCarboidratos(13.61);
        a2.setProteinas(5.04);
        a2.setGorduras(0.85);
        a2.setCalorias();
        a2.setPorcao(100.0);
        this.adicionaAlimento(a2);

        Alimento a3 = new Alimento();
        a3.setNome("Salada de Alface com Vegetais Variados (com Tomates e/ou Cenouras)");
        a3.setCarboidratos(3.08);
        a3.setProteinas(0.87);
        a3.setGorduras(0.17);
        a3.setCalorias();
        a3.setPorcao(100.0);
        this.adicionaAlimento(a3);

        Alimento a4 = new Alimento();
        a4.setNome("Patinho Frito");
        a4.setCarboidratos(2.28);
        a4.setProteinas(14.9);
        a4.setGorduras(12.15);
        a4.setCalorias();
        a4.setPorcao(100.0);
        this.adicionaAlimento(a4);

        Alimento a5 = new Alimento();
        a5.setNome("Ovo Frito (1 Grande)");
        a5.setCarboidratos(0.43);
        a5.setProteinas(6.24);
        a5.setGorduras(6.76);
        a5.setCalorias();
        a5.setPorcao(46.0);
        this.adicionaAlimento(a5);

        Alimento a6 = new Alimento();
        a6.setNome("Ovo Cozido (1 Grande)");
        a6.setCarboidratos(0.56);
        a6.setProteinas(6.26);
        a6.setGorduras(5.28);
        a6.setCalorias();
        a6.setPorcao(50.0);
        this.adicionaAlimento(a6);

        Alimento a7 = new Alimento();
        a7.setNome("Banana Prata (1 Média)");
        a7.setCarboidratos(14.85);
        a7.setProteinas(0.71);
        a7.setGorduras(0.21);
        a7.setCalorias();
        a7.setPorcao(65.0);
        this.adicionaAlimento(a7);

        Alimento a8 = new Alimento();
        a8.setNome("Maçã (1 Média)");
        a8.setCarboidratos(19.06);
        a8.setProteinas(0.36);
        a8.setGorduras(0.23);
        a8.setCalorias();
        a8.setPorcao(72.0);
        this.adicionaAlimento(a8);

        Alimento a9 = new Alimento();
        a9.setNome("Filé de Frango (Grelhado)");
        a9.setCarboidratos(0.0);
        a9.setProteinas(31.02);
        a9.setGorduras(3.57);
        a9.setCalorias();
        a9.setPorcao(100.0);
        this.adicionaAlimento(a9);

        Alimento a10 = new Alimento();
        a10.setNome("Suco de Laranja Natural");
        a10.setCarboidratos(10.4);
        a10.setProteinas(0.7);
        a10.setGorduras(0.2);
        a10.setCalorias();
        a10.setPorcao(100.0);
        this.adicionaAlimento(a10);

        Alimento a11 = new Alimento();
        a11.setNome("Leite Integral");
        a11.setCarboidratos(4.52);
        a11.setProteinas(3.22);
        a11.setGorduras(3.25);
        a11.setCalorias();
        a11.setPorcao(100.0);
        this.adicionaAlimento(a11);

        Alimento a12 = new Alimento();
        a12.setNome("Pão Francês");
        a12.setCarboidratos(51.9);
        a12.setProteinas(8.8);
        a12.setGorduras(3.0);
        a12.setCalorias();
        a12.setPorcao(100.0);
        this.adicionaAlimento(a12);

        Alimento a13 = new Alimento();
        a13.setNome("Pasta de Amendoim Integral");
        a13.setCarboidratos(3.0);
        a13.setProteinas(4.1);
        a13.setGorduras(7.0);
        a13.setCalorias();
        a13.setPorcao(15.0);
        this.adicionaAlimento(a13);

        Alimento a14 = new Alimento();
        a14.setNome("Chocolate Ao Leite (4 quadradinhos)");
        a14.setCarboidratos(14.0);
        a14.setProteinas(1.7);
        a14.setGorduras(8.1);
        a14.setCalorias();
        a14.setPorcao(25.0);
        this.adicionaAlimento(a14);

        Alimento a15 = new Alimento();
        a15.setNome("Barra de Cereal Morango com Chocolate");
        a15.setCarboidratos(16.0);
        a15.setProteinas(1.0);
        a15.setGorduras(1.9);
        a15.setCalorias();
        a15.setPorcao(22.0);
        this.adicionaAlimento(a15);
    }

    public boolean adicionaAlimento(Alimento alimento) {
        int posicaoLivre = this.proximaPosicaoLivre();
        if(posicaoLivre == -1) {
            return false;
        }

        this.alimentos[posicaoLivre] = alimento;

        return true;
    }

    public boolean ehVazio() {
        for(Alimento alimento : this.alimentos) {
            if(alimento != null) return false;
        }
        return true;
    }

    public void mostrarTodos() {
        if(ehVazio()) {
            System.out.println("Não existe alimentos cadastrados");
        } else {
            String builder = "";
            for(Alimento alimento : this.alimentos) {
                if(alimento != null) {
                    builder += "\n===============" +
                            "\nNome: " + alimento.getNome() +
                            "\nCarboidratos: " + alimento.getCarboidratos() + " g" +
                            "\nProteínas: " + alimento.getProteinas() + " g" +
                            "\nGorduras: " + alimento.getGorduras() + " g" +
                            "\nCalorias: " + alimento.getCalorias() + " cal" +
                            "\nPorção: " + alimento.getPorcao() + " g" +
                            "\n===============\n";
                }
            }
            System.out.println(builder);
        }
    }

    private int proximaPosicaoLivre() {
        for(int i = 0; i < this.alimentos.length; i++) {
            if(alimentos[i] == null) return i;
        }
        return -1;
    }
}
