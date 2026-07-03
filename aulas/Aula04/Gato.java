package Aula04;

public class Gato extends Animal{

    public Gato(String nome, int peso){

        super(nome, peso, "Gato");

    }

    @Override

    public void fazBarulho(){

        System.out.println( "Miau" );

    }

    @Override

    public int getValorExame(){

        return super.getValorExame() - 20;

    }

}
