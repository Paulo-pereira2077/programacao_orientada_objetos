package Aula04;

public abstract class Animal {

// Cahorro exame: R$2.00 / Kg * adicional de R$30.00 na consulta;

// Gato exame: R$20.00 de desconto;

    private String nome;

    private int peso;

    private String especie;

    private int valorConsulta = 100;

    private int valorExame = 50;

    public Animal(String nome, int peso, String especie) {

        this.nome = nome;

        this.peso = peso;

        this.especie = especie;

    }

    public abstract void fazBarulho();

    public String getNome() {

        return nome;

    }

    public double getPeso() {

        return peso;

    }

    public String getEspecie() {

        return especie;

    }

    public int getValorConsulta() {

        return valorConsulta;

    }

    public int getValorExame() {

        return valorExame;

    }

    @Override

    public String toString() {

        return  "#######################################\n"+

                "Nome = " + nome + "\n" +

                "Peso = " + peso + "\n" +

                "Especie = " + especie + "\n" +

                "ValorConsulta = " + getValorConsulta() +

                " ValorExame = " + getValorExame();

    }

}
