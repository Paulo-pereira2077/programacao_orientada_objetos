package Aula03;

public class Aluno extends Pessoa {
    
    private String curso;
    private int periodo = 1;

    public Aluno(String curso, int idade, String nome) {
        super("Aluno(a)", idade, nome);
        this.curso = curso;
    }

    public void fazAvaliacao(double nota){
        if(nota >= 6){
            this.periodo++;
            System.out.println(
                getFuncao() + " " + getNome() + 
                " está aprovado(a) com nota " + nota +
                " e passou para o perído " + this.periodo
            );
        } else {
            System.out.println(
                getFuncao() + " " + getNome() + 
                " está reprovado(a) e permanece no perído" +
                this.periodo
            );
        }
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }



    

    



}