package Aula02;

public class Aula02 {
    public static void main( String[] args ){

        //--Parte1
        //------------------------

        Pessoa p1 = new Pessoa( "Ludovica", "Azanha", 33 );
        //p1.nome = "Ludovica";
        //p1.sobrenome = "Azanha";
        //p1.idade = 33;
        //p1.setNome("Ludovica");
        //p1.setSobrenome("Azanha");
        //p1.setIdade( -1 );
        p1.mostraInfo();



        Pessoa p2 = new Pessoa("João","Souza",-1);
        p2.mostraInfo();

        Pessoa p3 = new Pessoa("Valentina","Pereira",17);
        p3.mostraInfo();
        System.out.println( p3.isMaiorDeIdade() );

        p3.fazAniversario();
        p3.mostraInfo();
        System.out.println( p3.isMaiorDeIdade() );


        //--Parte2
        //------------------------
        System.out.println("/n#######");
        System.out.println("/n#######");
        System.out.println("Parte 2 \n");

        ContaBancaria c1 = new ContaBancaria("Maria");
        c1.deposita(1000);
        c1.saca(700);
        c1.saca(600);
        c1.extrato();
        c1.fechaConta();
        c1.saca(10);

    }
}
