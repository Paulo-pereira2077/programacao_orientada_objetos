import java.util.Scanner;

public class App {
    
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Digite o valor do pedido: ");
        double valor = entrada.nextDouble();

        System.out.print("Digite a quantidade de parcelas: ");
        int parcelas = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Digite o código do cupom: ");
        String cupom = entrada.nextLine();

        Pedido pedido = new Pedido(valor, parcelas, cupom);
        Response resposta = pedido.calcularTotal();

        System.out.println("\n===== RESULTADO DO PEDIDO =====");
        System.out.println("Valor final do pedido: R$ " + resposta.lerValorTotal());
        System.out.println("Valor da parcela: R$ " + resposta.lerValorParcela());
        System.out.println("Total de parcelas: " + resposta.lerParcela());
        System.out.println("Desconto aplicado: R$ " + resposta.lerValorCupom());
    }
}