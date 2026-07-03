package praticaFundamentos;

import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) { // Adicionado o 'static'

        String aluno;
        float nota1;
        float nota2;
        float nota3;

        System.out.println("===== Exercício da Média =====");

        System.out.print("\nDigite seu nome: "); // Trocado '/n' por '\n'
        aluno = ler.next();

        System.out.println("\nDigite suas notas: ");

        // Removido o 'for' para preencher as variáveis em sequência de forma mais limpa
        System.out.print("Digite sua nota 1: ");
        nota1 = ler.nextFloat(); // Trocado nextInt() por nextFloat()

        System.out.print("Digite sua nota 2: ");
        nota2 = ler.nextFloat();

        System.out.print("Digite sua nota 3: ");
        nota3 = ler.nextFloat();

        float media = (nota1 + nota2 + nota3) / 3;

        String situacao;

        if (media >= 8) {
            situacao = "Aprovado com sucesso"; // 2. Guardamos o texto na variável
        } else if (media >= 6 && media < 8) {
            situacao = "Aprovado";
        } else if (media >= 3 && media < 6) {
            situacao = "Recuperação";
        } else if (media < 3 && media >= 0.5) {
            situacao = "Reprovado";
        } else {
            situacao = "Desistente";
        }

        System.out.printf("\nSeus resultados:" +
                "\nNome: %s | Sua média é: %.2f | Situação: %s\n", aluno, media, situacao);
    }
}