package praticaFundamentos;

import java.util.List;
import java.util.Scanner;

public class Tela {

    private Scanner ler = new Scanner(System.in);
    private Carrinho carrinho = new Carrinho();

    public void iniciarMenu() {
        int menu = -1;

        while (menu != 0) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Exibir subtotal");
            System.out.println("3. Finalizar compra");
            System.out.println("0. Sair");

            System.out.print("Digite aqui: ");
            menu = ler.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nInforme o Nome:");
                    ler.nextLine();
                    String nome = ler.nextLine();

                    System.out.println("Informe a Quantidade:");
                    int qtd = ler.nextInt();

                    System.out.println("Informe o preco da Unidade:");
                    float preco = ler.nextFloat();

                    Produto novoProduto = new Produto(nome, qtd, preco);

                    carrinho.adicionarProduto(novoProduto);

                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    System.out.println("\n--- ITENS NO CARRINHO ---");

                    List<Produto> itens = carrinho.getListaDeProdutos();
                    for (Produto itemAtual : itens) {
                        System.out.printf("- %s | Qtd: %d | Preço Un: R$ %.2f\n",
                                itemAtual.getProduto(), itemAtual.getQtd(), itemAtual.getPreco());
                    }

                    System.out.println("-------------------------");
                    System.out.printf("(%d itens) - Subtotal: R$ %.2f\n", carrinho.getQtdTotalItens(), carrinho.getSubtotal());
                    System.out.println("Continuar comprando...");
                    break;

                case 3:
                    System.out.printf("(%d itens) - Total: R$ %.2f\n", carrinho.getQtdTotalItens(), carrinho.getSubtotal());
                    System.out.println("Compra finalizada.\nIniciando nova compra...");
                    carrinho.zerarCarrinho();
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}