package Aula05;

public class Malignus extends Inimigo {

    public Malignus() {
        super("Malignus", 1000, 50);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou o mutante mais forte!");

    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu te odeio");

    }

}

