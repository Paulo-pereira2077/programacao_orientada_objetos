package praticaFundamentos;

import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tela {
    private Carrinho carrinho = new Carrinho();
    private Scanner scanner = new Scanner(System.in);

    public void iniciarMenu() {
        if (carrinho.temBackup()) {
            limparTela();
            System.out.println("==== RECUPERAÇÃO DE CARRINHO ====");
            System.out.println("Encontramos itens no seu carrinho da última sessão.");
            System.out.print("Deseja restaurar sua compra anterior? (S/N): ");

            if (scanner.nextLine().trim().toUpperCase().equals("S")) {
                carrinho.carregarBackup();
                System.out.println("\nCarrinho restaurado com sucesso!");
            } else {
                carrinho.apagarBackup();
                System.out.println("\nCarrinho anterior descartado.");
            }
            pausar();
        }

        int menu = -1;
        while (menu != 0) {
            limparTela(); // Limpa a tela a cada repetição
            System.out.println("==== MERCADO ====");
            System.out.println("\n---- Menu ----");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Exibir subtotal");
            System.out.println("3. Finalizar compra (Gerar Recibo)");
            System.out.println("4. Remover produto");
            System.out.println("0. Sair");

            System.out.print("\nDigite aqui: ");

            // Tratamento de erro similar ao TryParse
            try {
                menu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                menu = -1;
            }

            switch (menu) {
                case 1:
                    System.out.print("\nInforme o Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Informe a Quantidade: ");
                    int qtd = 0;
                    while (true) {
                        try {
                            qtd = Integer.parseInt(scanner.nextLine());
                            if (qtd > 0) break;
                        } catch (NumberFormatException e) {}
                        System.out.print("Valor inválido! Digite uma quantidade válida: ");
                    }

                    System.out.print("Informe o preço da Unidade (use ponto para decimais): ");
                    float preco = 0f;
                    while (true) {
                        try {
                            preco = Float.parseFloat(scanner.nextLine());
                            if (preco >= 0) break;
                        } catch (NumberFormatException e) {}
                        System.out.print("Valor inválido! Digite um preço válido: ");
                    }

                    Produto novoProduto = new Produto(qtd, preco, nome);
                    carrinho.adicionarProduto(novoProduto);

                    System.out.println("\nProduto adicionado com sucesso!");
                    pausar();
                    break;

                case 2:
                    System.out.println("\n--- ITENS NO CARRINHO ---");
                    List<Produto> itens = carrinho.getListaDeProdutos();

                    if (itens.isEmpty()) {
                        System.out.println("O carrinho está vazio.");
                    } else {
                        for (Produto itemAtual : itens) {
                            System.out.printf("- %s | Qtd: %d | Preço Un: R$ %.2f\n",
                                    itemAtual.getProduto(), itemAtual.getQtd(), itemAtual.getPreco());
                        }
                    }

                    System.out.println("-------------------------");
                    System.out.printf("(%d itens) - Subtotal: R$ %.2f\n\n", carrinho.getQtdTotalItens(), carrinho.getSubtotal());
                    pausar();
                    break;

                case 3:
                    float total = carrinho.getSubtotal();
                    if (total > 0) {
                        limparTela();
                        System.out.println("\n--- PAGAMENTO ---");
                        System.out.printf("Total a Pagar: R$ %.2f\n\n", total);

                        float valorDesconto = 0f;
                        System.out.print("Você possui um cupom de desconto? (S/N): ");
                        if (scanner.nextLine().trim().toUpperCase().equals("S")) {
                            System.out.print("Digite o código do cupom: ");
                            String cupom = scanner.nextLine().trim().toUpperCase();

                            if (cupom.equals("PROMO10")) {
                                valorDesconto = total * 0.10f;
                                System.out.printf("\nCupom válido! Desconto aplicado: -R$ %.2f\n", valorDesconto);
                            } else {
                                System.out.println("\nCupom inválido ou expirado.");
                            }
                        }

                        float totalComDesconto = total - valorDesconto;
                        System.out.printf("\nTotal a Pagar: R$ %.2f\n\n", totalComDesconto);

                        System.out.println("Formas de Pagamento:");
                        System.out.println("1. Dinheiro");
                        System.out.println("2. Pix");
                        System.out.println("3. Cartão");
                        System.out.print("Escolha a opção (1-3): ");

                        int opcaoPagamento = 0;
                        while (true) {
                            try {
                                opcaoPagamento = Integer.parseInt(scanner.nextLine());
                                if (opcaoPagamento >= 1 && opcaoPagamento <= 3) break;
                            } catch (NumberFormatException e) {}
                            System.out.print("Opção inválida! Escolha 1, 2 ou 3: ");
                        }

                        String formaPagamentoStr = "";
                        float valorEntregue = totalComDesconto;
                        float troco = 0f;

                        if (opcaoPagamento == 1) { // Dinheiro
                            formaPagamentoStr = "Dinheiro";
                            System.out.printf("\nValor entregue pelo cliente (Mínimo R$ %.2f): ", totalComDesconto);

                            while (true) {
                                try {
                                    valorEntregue = Float.parseFloat(scanner.nextLine());
                                    if (valorEntregue >= totalComDesconto) break;
                                } catch (NumberFormatException e) {}
                                System.out.printf("Valor insuficiente! Digite um valor maior ou igual a R$ %.2f: ", totalComDesconto);
                            }

                            troco = valorEntregue - totalComDesconto;
                            System.out.printf("\nTroco a devolver: R$ %.2f\n", troco);
                        } else if (opcaoPagamento == 2) { // Pix
                            formaPagamentoStr = "Pix";
                            System.out.println("\nAguardando pagamento via Pix... Aprovado!");
                        } else { // Cartão
                            formaPagamentoStr = "Cartão";
                            System.out.println("\nProcessando cartão... Aprovado!");
                        }

                        StringBuilder listaItensRecibo = new StringBuilder();
                        for (Produto itemAtual : carrinho.getListaDeProdutos()) {
                            listaItensRecibo.append(String.format("- %s | Qtd: %d | Preço Unitário: R$ %.2f\n",
                                    itemAtual.getProduto(), itemAtual.getQtd(), itemAtual.getPreco()));
                        }

                        LocalDateTime agora = LocalDateTime.now();
                        String dataHoraArquivo = agora.format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
                        String nomeDoArquivo = "Recibo_" + dataHoraArquivo + ".txt";

                        String textoRecibo = String.format(
                                "==== CUPOM FISCAL ====\n" +
                                        "Data: %s\n" +
                                        "Total de Itens: %d\n\n" +
                                        "Itens Comprados:\n" +
                                        "%s\n" +
                                        "Subtotal: R$ %.2f\n" +
                                        "Descontos: -R$ %.2f\n" +
                                        "VALOR TOTAL: R$ %.2f\n\n" +
                                        "Forma de Pagamento: %s\n" +
                                        "Valor Recebido: R$ %.2f\n" +
                                        "Troco: R$ %.2f\n\n" +
                                        "Obrigado pela preferência!",
                                agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                                carrinho.getQtdTotalItens(),
                                listaItensRecibo.toString(),
                                total,
                                valorDesconto,
                                totalComDesconto,
                                formaPagamentoStr,
                                valorEntregue,
                                troco
                        );

                        try {
                            // Salva o recibo
                            Files.writeString(Paths.get(nomeDoArquivo), textoRecibo);
                            System.out.println("\nCompra finalizada com sucesso!");
                            System.out.println("Um arquivo '" + nomeDoArquivo + "' foi salvo no histórico.");
                        } catch (IOException e) {
                            System.out.println("\nErro ao gerar o recibo: " + e.getMessage());
                        }

                        carrinho.zerarCarrinho();
                    } else {
                        System.out.println("\nNão há itens para finalizar a compra.");
                    }

                    pausar();
                    break;

                case 4:
                    System.out.print("\nDigite o nome do produto que deseja remover: ");
                    String nomeRemover = scanner.nextLine();

                    boolean removido = carrinho.removerItem(nomeRemover);
                    if (removido) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado no carrinho.");
                    }

                    pausar();
                    break;

                case 0:
                    System.out.println("\nSaindo do programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    pausar();
                    break;
            }
        }
        scanner.close();
    }

    // Método auxiliar para evitar repetição de código
    private void pausar() {
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    // Método auxiliar para simular o Console.Clear do C#
    private void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}