public class Response {
    
    private double valorFinal;
    private double valorParcela;
    private int parcelas;
    private double valorCupom;

    public Response(double valorFinal, double valorParcela, int parcelas, double valorCupom){
        this.valorFinal = valorFinal;
        this.valorParcela = valorParcela;
        this.parcelas = parcelas;
        this.valorCupom = valorCupom;
    }
    
    public double lerValorTotal(){
        return valorFinal;        
    }

    public double lerValorParcela(){
        return valorParcela;
    }

    public int lerParcela(){
        return parcelas;
    }

    public double lerValorCupom(){
        return valorCupom;
    }

}
