package Aula04;

public class Main {

    public static void main(String[] args) {

        Animal a1 = new Viralata("Johny", 12);

        Animal a2 = new Gato ("Isis", 4);

        Clinica c = new Clinica();

        c.fazOrcamento(a1, true);

        c.fazOrcamento(a2);

        Animal[] animais = {

                a1, a2, new Cachorro("Spike", 10), new Gato("Perninha", 3), new Cachorro("Luke", 15),

                new Viralata("Pretinha", 10), new Gato ("Nata", 5)

        };

        c.fazOrcamento(animais, true);

    }

}
