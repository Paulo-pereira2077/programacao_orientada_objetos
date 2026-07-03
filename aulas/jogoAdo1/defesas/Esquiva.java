package jogoAdo1.defesas;

import java.util.Random;

public class Esquiva extends Defesa {
    private int chance;

    public Esquiva(int chance) {
        this.chance = chance;
    }

    @Override
    public int danoReduzido(int danoOriginal) {
        Random rd = new Random();
        if (rd.nextInt(100) < this.chance) {
            System.out.println("Esquivou!");
            return 0;
        }
        return danoOriginal;
    }
}
