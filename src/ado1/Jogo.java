package ado1;

import Aula05.Criatura;
import Aula05.Jogador;

import java.util.Scanner;

public class Jogo {
    static Scanner jo = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Digite seu nome:");
        String nome = jo.nextLine();

        Jogador jogador = new Jogador(nome);

        Criatura jogador = new Jogador( "Ludovica" );
        Criatura inimigo = new Demonion();
        
        System.out.println("################");
        System.out.println("A grande batalha");
        System.out.println("################");
        
        jogador.fraseApresentacao();
        inimigo.fraseApresentacao();
        
        int cont = 0;
        while(true){
            cont++;
            System.out.println("Rodada " + cont);
            
            jogador.mostraVida();
            inimigo.mostraVida();
            
            jogador.fazAtaque(inimigo);
            if( inimigo.estaVivo() ){
                inimigo.fazAtaque(jogador);
            }
            
            if( !jogador.estaVivo() ){
                jogador.fraseMorte();
                System.out.println(inimigo.getNome() + " venceu!");
                break;
            } else if ( !inimigo.estaVivo() ){
                inimigo.fraseMorte();
                System.out.println(jogador.getNome() + " venceu!");
                break;
            }
        }
    }
}
