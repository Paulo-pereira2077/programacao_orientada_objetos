public class Pedido {
    
    public double valor;
    public int parcelas;
    public String cupom;


    public Pedido(double valor, int parcelas, String cupom) {
        this.valor = valor;
        this.parcelas = parcelas;
        this.cupom = cupom;
    }

    public Response calcularTotal() {
        double desconto = calcularDesconto();
        double valorComDesconto = valor - desconto;

        double valorComJuros = valorComDesconto;

        if (parcelas > 1) {
            valorComJuros = valorComDesconto * 1.05; // juros de 5%
        }

        double valorParcela = valorComJuros / parcelas;

        return new Response(valorComJuros, valorParcela, parcelas, desconto);
    }

    private double calcularDesconto() {
        if (cupom.equalsIgnoreCase("QUERO50")) {
            return 50.0;
        }

        // criar mais cupons
        if (cupom.equalsIgnoreCase("DESCONTO10")) {
            return 10.0;
        }

        return 0;
    }
}