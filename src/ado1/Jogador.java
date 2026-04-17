package ado1;

import Aula05.*;

import java.util.Scanner;

public class Jogador extends Criatura {
    private Arma[] armas = {
        new Faca(),
        new Pistola(),
        new Espada(),
        new ArcoEFlecha()
    };

    public Jogador(String nome) {
        super(nome, 900);

        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha arma curta: 1-Espada 2-Faca");
        int escolha1 = sc.nextInt();

        if (escolha1 == 1) armaCurta = new Espada();
        else armaCurta = new Faca();

        System.out.println("Escolha arma longa: 1-Arco 2-Pistola");
        int escolha2 = sc.nextInt();

        if (escolha2 == 1) armaLonga = new ArcoEFlecha();
        else armaLonga = new Pistola();

    }



    @Override
    public void fazAtaque(Criatura alvo) {
        Scanner sc = new Scanner( System.in );
        
        System.out.println("Escolha sua arma: ");
        int n = 0;
        for( Arma arma : armas ){
            n++;
            System.out.print(n + ") ");
            arma.descricao();
        }
        
        int escolha = sc.nextInt();
        while( escolha < 1 || escolha > n ){
            System.out.println("Número inválido, escolha outro:");
            escolha = sc.nextInt();
        }
        
        armas[n-1].golpe(alvo);
    }

    @Override
    public void fraseApresentacao() {
        System.out.println("Não contava com minha astúcia!");
    }

    @Override
    public void fraseMorte() {
        System.out.println("Eu vou voltar pra te arrazar!");
    }
    
    
    
}
