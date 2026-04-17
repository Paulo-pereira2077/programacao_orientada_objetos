package ado1;

import Aula05.Escudo;
import Aula05.Inimigo;

public class Demonion extends Inimigo {
    
    public Demonion() {
        super("Demonion", 500, 120, new Escudo(15) );
    }
    
    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou do mal!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu vou ressucitar.");
    }
    
    
    
}
