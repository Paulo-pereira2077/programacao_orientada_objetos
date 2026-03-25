package Aula05;

import java.util.Scanner;

public class Jogador extends Criatura{


    static Scanner ler = new Scanner(System.in);

    private Arma[] armas = {
            new Faca(),
            new Pistola(),
            new Espada(),
            new ArcoEFlecha()

    };

    public Jogador(String nome){
        super(nome, 900);
    }

    @Override
    public void fazAtaque(Criatura alvo) {

        System.out.println("Escolha sua arma: ");
        int n = 0;
        for(Arma arma : armas)
        {
            n++;
            System.out.print(n  + ") ");
            arma.descricao();
        }

        int escolha = ler.nextInt();
        while(escolha < 1 || escolha > n){
            System.out.println("Número inválido, escolha outro:");
            escolha = ler.nextInt();
        }

        armas[escolha - 1].golpe(alvo);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Vou te derrotar seu verme insolente");

    }

    @Override
    public void fraseMorte() {
        System.out.println("Ih alá");

    }
}

