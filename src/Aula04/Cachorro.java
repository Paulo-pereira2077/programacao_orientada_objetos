package Aula04;

public class Cachorro extends Animal {

    public Cachorro(String nome, int peso){
        super(nome, peso, "Cachorro");
    }

    @Override
    public void fazBarulho(){
        System.out.println("Auau");
    }

    @Override
    public int getValorConsulta(){
        return super.getValorConsulta() + 30;
    }

    @Override
    public int getValorExame(){
        return (int)(super.getValorExame() + 2 * getPeso());
    }
}
