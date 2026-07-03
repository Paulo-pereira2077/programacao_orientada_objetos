package jogoAdo1.defesas;

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
        if (rd.nextInt(100) < this.chanceEsquiva) {
            System.out.println("Esquivou!");
            return 0;
        }

        if (this.reducao > danoOriginal) {
            return 0;
        }
        return danoOriginal - this.reducao;
    }
}
