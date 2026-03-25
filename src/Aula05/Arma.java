package Aula05;

import java.util.Random;


public abstract class Arma {

    private String nome;
    private int ataque;
    private int chance;

    public Arma(int ataque, int chance, String nome)
    {
        this.ataque = ataque;
        this.chance = chance;
        this.nome = nome;

    }

    public void descricao(){

        System.out.println( this.nome + "- Dano = " + this.ataque + " - Chance = " + this.chance + "%" );


    }

    public void golpe(Criatura alvo)
    {
        Random rd = new Random();
        int sorteio = rd.nextInt(100);

        if(sorteio < this.chance){
            alvo.tomaDano(this.ataque);
        }
        else{
            System.out.println("Ataque falhou");
        }
    }
}

