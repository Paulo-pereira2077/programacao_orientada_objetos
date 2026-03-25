package Aula05;

public class Devorador extends Inimigo{

    public Devorador()
    {
        super("Devorador", 500, 120, new Escudo(15));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou do mal");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu vou voltar para te devorar!");
    }

}
