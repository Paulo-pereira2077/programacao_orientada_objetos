package Aula03;

public class Aula03 {

    public static void main(String args[]){
        
        Pessoa p1 = new Pessoa("Visitante", 35, "Maria");
        portaria(p1);

        Aluno a1 = new Aluno("TADS",23,"Gabriel");
        portaria(a1);
        blackboard(a1, 10);

        Professor prof1 = new Professor( 8, 70000, 33, "Ludovica" );
        portaria(prof1);
        rh(prof1);

        Coordenador c1 = new Coordenador(40, 1000000, 35, "Rogério", "TADS");
        portaria(c1);
        rh(c1);
        coordenacao(c1);
    }

    public static void coordenacao( Coordenador c ){
        c.fazReuniao();
    }

    public static void portaria( Pessoa p ) {
        p.passaCatraca();
    }

    public static void blackboard( Aluno a, int nota ){
        a.fazAvaliacao(nota);
    }

    public static void rh( Professor p ){
        p.recebeSalario();
    }

}