package Aula04;

public class Clinica {

    public void fazOrcamento(Animal a, boolean temExame){

        int total = a.getValorConsulta();

        if(temExame){
            total += a.getValorExame();
        }

        System.out.println(a); // chama o toString do Animal
        System.out.println("Total = R$" + total + ",00");
        System.out.println("#################");
    }

    public void fazOrcamento(Animal a){
        fazOrcamento(a, false);
    }

    public void fazOrcamento(){
        System.out.println("Total = R$0,00");
    }

    public void fazOrcamento(Animal[] animais, boolean temExame){
        int total = 0;

        for(Animal a : animais){
            fazOrcamento(a, temExame);
            total += a.getValorConsulta();

            if(temExame){
                total += a.getValorExame();
            }
        }

        System.out.println("#################\n");
        System.out.println("Total = R$" + total + ",00");
    }
}