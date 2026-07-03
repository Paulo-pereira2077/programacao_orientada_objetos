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
        aluno = inserirNome("Digite seu nome: ");
        System.out.println("\nDigite suas notas: ");
        nota1 = inserirNotas("Digite sua nota 1: ");
        nota2 = inserirNotas("Digite sua nota 2: ");
        nota3 = inserirNotas("Digite sua nota 3: ");

        float resultadoMedia = calcularMedia(nota1, nota2, nota3);
        String resultadoSituacao = verificarSituacao(resultadoMedia);

        System.out.printf("\nSeus resultados:" +
                "\nNome: %s | Sua média é: %.2f | Situação: %s\n", aluno, resultadoMedia, resultadoSituacao);

        ler.close();
    }

    public static String inserirNome(String msg){
        System.out.print(msg);
        return ler.next();
    }

    public static float inserirNotas(String msg){
        System.out.print(msg);
        return ler.nextFloat();
    }

    public static float calcularMedia(float nota1, float nota2, float nota3){
        return (nota1 + nota2 + nota3) / 3;
    }

    public static String verificarSituacao(float resultadoMedia){
        String situacao;

        if (resultadoMedia >= 8) {
            situacao = "Aprovado com sucesso"; // 2. Guardamos o texto na variável
        } else if (resultadoMedia >= 6 && resultadoMedia < 8) {
            situacao = "Aprovado";
        } else if (resultadoMedia >= 3 && resultadoMedia < 6) {
            situacao = "Recuperação";
        } else if (resultadoMedia < 3 && resultadoMedia >= 0.5) {
            situacao = "Reprovado";
        } else {
            situacao = "Desistente";
        }

        return situacao;
    }

}