package jogoAdo1.personagens;

import jogoAdo1.armas.Arma;
import java.util.Scanner;

public class Jogador extends Criatura {
    private Arma[] arsenal;

    public Jogador(String nome, Arma curta, Arma longa) {
        super(nome, 1000);
        this.arsenal = new Arma[]{curta, longa};
    }

    @Override
    public void fazAtaque(Criatura alvo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEscolha sua arma:");
        for (int i = 0; i < arsenal.length; i++) {
            System.out.print((i + 1) + ") ");
            arsenal[i].descricao();
        }

        int escolha = sc.nextInt();
        while (escolha < 1 || escolha > arsenal.length) {
            System.out.println("Você ainda não selecionou a arma!");
            escolha = sc.nextInt();
        }

        arsenal[escolha - 1].golpe(alvo);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Eu sou " + getNome() + " e vim para vencer!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Meu destino termina aqui...");
    }
}
