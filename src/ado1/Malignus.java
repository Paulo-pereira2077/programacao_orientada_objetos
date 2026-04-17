package ado1;

import Aula05.Inimigo;

public class Malignus extends Inimigo {

    public Malignus() {
        super("Malignus", 1000, 50, new DefesaHibrida(20, 20));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu vou te mataaar...");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Nããããããããããão");
    }
    
    
    
}
