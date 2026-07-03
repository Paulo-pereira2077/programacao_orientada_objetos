package jogoAdo1.defesas;

public class Escudo extends Defesa {
    private int reducao;

    public Escudo(int reducao) {
        this.reducao = reducao;
    }

    @Override
    public int danoReduzido(int danoOriginal) {
        if (this.reducao > danoOriginal) {
            return 0;
        }
        return danoOriginal - this.reducao;
    }
}
