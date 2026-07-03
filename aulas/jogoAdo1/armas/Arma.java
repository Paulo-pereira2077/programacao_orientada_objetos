package jogoAdo1.armas;

import jogoAdo1.personagens.Criatura;
import java.util.Random;

public abstract class Arma {
    private String nome;
    private int ataque;
    private int chance;
    private int municao;
    private boolean usaMunicao;

    public Arma(String nome, int ataque, int chance) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.usaMunicao = false;
        this.municao = -1;
    }

    public Arma(String nome, int ataque, int chance, int municao) {
        this.nome = nome;
        this.ataque = ataque;
        this.chance = chance;
        this.municao = municao;
        this.usaMunicao = true;
    }

    public String getNome() {
        return this.nome;
    }

    public int getMunicao() {
        return this.municao;
    }

    public boolean isUsaMunicao() {
        return this.usaMunicao;
    }

    public void descricao() {
        String desc = this.nome + " - Dano=" + this.ataque + " - Chance=" + this.chance + "%";
        if (usaMunicao) {
            desc += " - Munição=" + this.municao;
        }
        System.out.println(desc);
    }

    public void golpe(Criatura alvo) {
        if (usaMunicao && municao <= 0) {
            System.out.println("\n️ Sem munição!");
            alvo.tomaDano(0);
            return;
        }

        if (usaMunicao) {
            municao--;
        }

        Random rd = new Random();
        int sorteio = rd.nextInt(100);

        if (sorteio < this.chance) {
            alvo.tomaDano(this.ataque);
        } else {
            System.out.println("Ataque Falhou.");
        }
    }
}
