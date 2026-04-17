package ado1;

import java.util.Random;

public class Sombra extends Inimigo{

    public Sombra() {
        super("Malignus", 1000, 50, new DefesaHibrida(20, 20));
    }

    @Override
    public void fazAtaque(Criatura alvo) {
        Random rd = new Random();
        int chance = rd.nextInt(100);

        if (chance < 30) {
            System.out.println("Sombra errou o ataque!");
        } else {
            System.out.println("Sombra ataca nas sombras!");
            alvo.tomaDano(80);
        }
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Você não pode me ver...");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Desaparecendo nas sombras...");
    }
}
