package ado1;

import java.util.Random;

public class DefesaHibrida extends Defesa {
    private int reducao;
    private int chanceEsquiva;

    public DefesaHibrida(int reducao, int chanceEsquiva) {
        this.reducao = reducao;
        this.chanceEsquiva = chanceEsquiva;
    }

    @Override
    public int danoReduzido(int danoOriginal) {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);

        if (sorteio < chanceEsquiva) {
            System.out.println("Esquivou completamente!");
            return 0;
        }

        int danoFinal = danoOriginal - reducao;
        return Math.max(danoFinal, 0);
    }
}