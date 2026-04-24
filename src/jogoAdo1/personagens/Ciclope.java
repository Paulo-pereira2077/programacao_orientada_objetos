package jogoAdo1.personagens;

import jogoAdo1.defesas.Escudo;
import java.util.Random;

public class Ciclope extends Inimigo {

    public Ciclope() {
        super("Ciclope", 800, 120, new Escudo(15));
    }

    @Override
    public void fazAtaque(Criatura alvo) {
        Random rd = new Random();
        int dano = getAtaque();

        if (rd.nextInt(100) < 25) {
            System.out.println("Golpe esmagador do Ciclope!");
            dano *= 2;
        }

        alvo.tomaDano(dano);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu vou te esmagar com um só golpe!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Meu olho... não consigo ver...");
    }
}