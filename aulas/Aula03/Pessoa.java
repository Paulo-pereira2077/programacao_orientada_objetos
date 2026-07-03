package Aula03;

public class Pessoa {

    private String nome;
    private int idade;
    private String funcao;
    
    private boolean dentro = false;

    public void passaCatraca() {
        if( this.dentro ){
            System.out.println( this.funcao + " " + this.nome + " sai." );
        } else {
            System.out.println( this.funcao + " " + this.nome + " entra." );
        }
        this.dentro = !this.dentro;
    }





    public Pessoa(String funcao, int idade, String nome) {
        this.funcao = funcao;
        this.idade = idade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public boolean isDentro() {
        return dentro;
    }

    public void setDentro(boolean dentro) {
        this.dentro = dentro;
    }


    

}