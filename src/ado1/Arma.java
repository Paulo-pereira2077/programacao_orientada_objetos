package ado1;

import java.util.Random;

public abstract class Arma {
    private String nome;
    private int ataque;
    private int chance;
    private int municao;
    private Arma armaCurta;
    private Arma armaLonga;
    
    public Arma( String nome, int ataque, int chance, int municao, Arma armaCurta, Arma armaLonga ){
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.municao = municao;
        this.armaCurta = armaCurta;
        this.armaLonga = armaLonga;
    }
    
    public void descricao() {
        System.out.println(this.nome +
                        " - Dano=" + this.ataque +
                        " - Chance=" + this.chance + "%" +
                        " - Munição=" + this.municao);
    }
    
    public void golpe( Criatura alvo ){
        if (municao == 0) {
            System.out.println("Sem munição!");
            alvo.tomaDano(0);
            return;
        }

        municao--;

        Random rd = new Random();
        int sorteio = rd.nextInt(100);
            
        if( sorteio < this.chance ){
            alvo.tomaDano( this.ataque );
        } else {
            System.out.println("Ataque Falhou.");
        }
    }
}
