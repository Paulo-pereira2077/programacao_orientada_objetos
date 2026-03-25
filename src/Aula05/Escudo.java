package Aula05;

public class Escudo extends Defesa{

    private int reducao;

    public Escudo(int reducao){

        this.reducao = reducao;

    }

    public int danoReduzido(int danoOriginal)
    {

        if(this.reducao > danoOriginal){return 0;}

        return danoOriginal - this.reducao;
    }
}
