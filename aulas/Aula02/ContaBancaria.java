package Aula02;

public class ContaBancaria {
    private String titular;
    private double saldo = 0;
    private boolean contaAberta;

    ContaBancaria( String _titular ){
        this.titular = _titular;
        abreConta();
    }

    public void saca( double valor ){
        if( contaAberta && valor > 0 ){
            if( this.saldo >= valor ){
                System.out.println("Saque de R$" + valor + " realizado.");
                this.saldo -= valor;
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println( "Conta fechada ou valor inválido.");
        }
    }

    public void deposita( double valor ){
        if( contaAberta && valor > 0 ){
            System.out.println("Depósito de R$" + valor + " realizado.");
            this.saldo += valor;
        } else {
            System.out.println("Conta fechada ou valor inválido.");
        }
    }

    public void abreConta() {
        System.out.println( "Conta de " + this.titular + " está aberta." );
        contaAberta = true;
    }
    public void fechaConta() {
        if( this.saldo > 0 ){
            saca( this.saldo );
        }
        System.out.println("Conta de " + this.titular + " está fechada.");
        contaAberta = false;
    }

    public void extrato() {
        System.out.println(
            "Titular: " + this.titular + "\n" +
            "Saldo: " + this.saldo + "\n" +
            "ContaAberta" + this.contaAberta
        );
    }
}