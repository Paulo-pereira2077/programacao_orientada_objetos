package jogoAdo1.personagens;

import jogoAdo1.defesas.DefesaHibrida;

public class GiganteDeGelo extends Inimigo {
    public GiganteDeGelo() {
        super("Gigante de Gelo", 1100, 120, new DefesaHibrida(30, 10));
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Você ousa entrar no meu território congelado?");
    }

    @Override
    public void fraseMorte() {
        System.out.println("O gelo... está derretendo...");
    }
}