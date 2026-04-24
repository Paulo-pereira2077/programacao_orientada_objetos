package jogoAdo1.personagens;

import jogoAdo1.defesas.Esquiva;

public class AranhaGigante extends Inimigo {

    public AranhaGigante() {
        super("Aranha Gigante", 500, 70, new Esquiva(40));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Você está preso na minha teia!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("A teia... se desfaz...");
    }
}