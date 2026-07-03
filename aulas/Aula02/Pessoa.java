package Aula02;

public class Pessoa {
    
    private String nome;
    private String sobrenome;
    private int idade;

    Pessoa( String _nome, String _sobrenome, int _idade ){
        setNome(_nome);
        setSobrenome(_sobrenome);
        setIdade(_idade);
    }

    public void fazAniversario() {
        //this.idade++;
        setIdade( getIdade() + 1 );
    }

    public boolean isMaiorDeIdade() {
        return getIdade() >= 18;
    }

    public void mostraInfo() {
        System.out.println(
            "\n##########\n" +
            "Nome: " + getNome() + "\n" +
            "Sobrenome: " + getSobrenome() + "\n" + 
            "Idade: " + getIdade()
        );
    }

    private void setNome( String _nome ) {
        this.nome = _nome;
    }
    private void setSobrenome( String _sobrenome ){
        this.sobrenome = _sobrenome;
    }
    private void setIdade( int _idade ){
        if( _idade < 0 ){
            this.idade = 0;
        } else {
            this.idade = _idade;
        }
    }

    private String getNome() {
        return this.nome;
    }
    private String getSobrenome() {
        return this.sobrenome;
    }
    private int getIdade() {
        return this.idade;
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

}
