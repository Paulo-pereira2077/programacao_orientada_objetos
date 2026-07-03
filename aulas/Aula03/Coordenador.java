package Aula03;

public class Coordenador extends Professor {
    private String curso;

    public Coordenador(int cargaHoraria, int salario, int idade, String nome, String curso) {
        super(cargaHoraria, salario, idade, nome);
        this.curso = curso;
        setFuncao("Professor(a) Coordenador(a)");
    }

    public void fazReuniao() {
        System.out.println(
            getFuncao() + " " + getNome() +
            " chama reunião do curso de " + this.curso
        );
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
}
