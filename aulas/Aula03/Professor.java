package Aula03;

public class Professor extends Pessoa {
    
    private int salario;
    private int cargaHoraria;

    public Professor(int cargaHoraria, int salario, int idade, String nome) {
        super("Professor(a)", idade, nome);
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
    }

    public void recebeSalario() {
        System.out.println( getFuncao() + " " + getNome() + 
            " recebe salario de R$" + this.salario +
            ",00" );
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }





}