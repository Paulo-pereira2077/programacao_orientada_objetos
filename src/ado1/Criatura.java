package ado1;

public abstract class Criatura {
    private String nome;
    private int vida;

    public Criatura(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public abstract void fazAtaque( Criatura alvo );
    public abstract void fraseApresentacao();
    public abstract void fraseMorte();
    
    public void tomaDano( int dano ){
        System.out.println(this.nome + " toma dano de " + dano);
        this.vida -= dano;
        if( this.vida < 0 ){
            this.vida = 0;
        }
    }
    public boolean estaVivo() {
        return this.vida > 0;
    }
    public void mostraVida(){
        System.out.println(this.nome + " / Vida = " + this.vida);
    }
}
