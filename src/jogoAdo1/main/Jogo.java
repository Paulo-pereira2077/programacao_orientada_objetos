package jogoAdo1.main;

import jogoAdo1.personagens.*;
import jogoAdo1.armas.*;
import jogoAdo1.batalha.Batalha;
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> relatorio = new ArrayList<>();

        System.out.println("Bem-vindo ao RPG!");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        int opCurta = 0;
        while (opCurta != 1 && opCurta != 2) {
            System.out.println("Escolha sua arma de curta distância:");
            System.out.println("1) Espada");
            System.out.println("2) Faca");
            opCurta = sc.nextInt();
            if (opCurta != 1 && opCurta != 2) {
                System.out.println("Você ainda não selecionou a arma!");
            }
        }
        Arma curta = (opCurta == 1) ? new Espada() : new Faca();

        int opLonga = 0;
        while (opLonga != 1 && opLonga != 2) {
            System.out.println("Escolha sua arma de longa distância:");
            System.out.println("1) Pistola");
            System.out.println("2) Arco e Flecha");
            opLonga = sc.nextInt();
            if (opLonga != 1 && opLonga != 2) {
                System.out.println("Você ainda não selecionou a arma!");
            }
        }
        Arma longa = (opLonga == 1) ? new Pistola() : new ArcoEFlecha();

        Jogador jogador = new Jogador(nome, curta, longa);
        jogador.fraseApresentacao();

        Inimigo[] inimigos = {
                new AranhaGigante(),
                new Ciclope(),
                new GiganteDeGelo()
        };

        for (Inimigo inimigo : inimigos) {
            Batalha batalha = new Batalha();
            boolean venceu = batalha.processar(jogador, inimigo);

            System.out.println(batalha.getResultado());

            relatorio.add(batalha.getResultado());

            if (!venceu) {
                System.out.println("Fim de jogo para você...");
                break;
            } else {
                System.out.println("Você venceu! Recuperando vida para o próximo desafio.");
                jogador.restaurarVida();
            }
        }

        System.out.println("\n===== RELATÓRIO FINAL =====");
        for (String resultado : relatorio) {
            System.out.println(resultado);
        }
        System.out.println("===========================");
    }
}
