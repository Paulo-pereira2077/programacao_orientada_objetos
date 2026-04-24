package jogoAdo1.personagens;

import jogoAdo1.defesas.Defesa;

public abstract class Inimigo extends Criatura {
    private int ataque;
    private Defesa defesa;

    public Inimigo(String nome, int vida, int ataque, Defesa defesa) {
        super(nome, vida);
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getAtaque() {
        return this.ataque;
    }

    @Override
    public void fazAtaque(Criatura alvo) {
        alvo.tomaDano(this.ataque);
    }

    @Override
    public void tomaDano(int dano) {
        int danoReduzido = defesa.danoReduzido(dano);
        super.tomaDano(danoReduzido);
    }
}
