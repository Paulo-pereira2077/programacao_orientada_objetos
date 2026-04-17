package ado1;

import Aula05.Defesa;

import java.util.Random;
public class Esquiva extends Defesa {
    private int chance;
    public Esquiva( int chance ){
        this.chance = chance;
    }
    
    @Override
    public int danoReduzido( int danoOriginal ){
        Random rd = new Random();
        int sorteio = rd.nextInt(100);
        if( sorteio < this.chance ){
            return 0;
        }
        return danoOriginal;
    }   
    
}
