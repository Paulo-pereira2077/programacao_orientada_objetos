package ado1;

import Aula05.Criatura;
import Aula05.Defesa;

public abstract class Inimigo extends Criatura {
    private int ataque;
    private Defesa defesa;
    
    public Inimigo(String nome, int vida, int ataque, DefesaHibrida defesaHibrida) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = new Defesa();
    }
    public Inimigo(String nome, int vida, int ataque, Defesa defesa, DefesaHibrida defesaHibrida, Esquiva esquiva) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    @Override
    public void fazAtaque(Criatura alvo) {
        alvo.tomaDano( this.ataque );
    }
    
    @Override
    public void tomaDano( int dano ){
        int danoReduzido = defesa.danoReduzido(dano);
        super.tomaDano( danoReduzido );
    }
    
    
    
}
