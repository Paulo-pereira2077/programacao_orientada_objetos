package praticaFundamentos;

import praticaFundamentos.Produto;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Carrinho {
    private List<Produto> lista = new ArrayList<>();
    private String caminhoBackup = "carrinho_backup.txt"; // é o arquivo de memória do sistema

    public void adicionarProduto(Produto p) {
        // Verifica se já existe um produto com esse nome no carrinho
        Produto existente = lista.stream()
                .filter(item -> item.getProduto().equalsIgnoreCase(p.getProduto()))
                .findFirst()
                .orElse(null);

        if (existente != null) {
            existente.setQtd(existente.getQtd() + p.getQtd());
        } else {
            this.lista.add(p);
        }

        salvarBackup();
    }

    public boolean removerItem(String nome) {
        Produto produtoEncontrado = lista.stream()
                .filter(p -> p.getProduto().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (produtoEncontrado != null) {
            lista.remove(produtoEncontrado);
            salvarBackup();
            return true;
        }
        return false;
    }

    public int getQtdTotalItens() {
        int total = 0;
        for (Produto p : lista) {
            total += p.getQtd();
        }
        return total;
    }

    public float getSubtotal() {
        float total = 0;
        for (Produto p : lista) {
            total += (p.getQtd() * p.getPreco());
        }
        return total;
    }

    public List<Produto> getListaDeProdutos() {
        return lista;
    }

    public void zerarCarrinho() {
        this.lista.clear();
        apagarBackup();
    }

    private void salvarBackup() {
        List<String> linhas = new ArrayList<>();
        for (Produto p : lista) {
            // Correção da concatenação do texto do backup para o Java
            linhas.add(p.getProduto() + ";" + p.getQtd() + ";" + p.getPreco());
        }
        try {
            Files.write(Paths.get(caminhoBackup), linhas);
        } catch (IOException e) {
            System.out.println("Erro ao salvar backup: " + e.getMessage());
        }
    }

    public void carregarBackup() {
        Path path = Paths.get(caminhoBackup);
        if (Files.exists(path)) {
            try {
                List<String> linhas = Files.readAllLines(path);
                for (String linha : linhas) {
                    String[] dados = linha.split(";");
                    if (dados.length == 3) {
                        String nome = dados[0];
                        int qtd = Integer.parseInt(dados[1]);
                        float preco = Float.parseFloat(dados[2]);
                        Produto p = new Produto(qtd, preco, nome);
                        lista.add(p);
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro ao carregar backup: " + e.getMessage());
            }
        }
    }

    public boolean temBackup() {
        return Files.exists(Paths.get(caminhoBackup));
    }

    public void apagarBackup() {
        try {
            Files.deleteIfExists(Paths.get(caminhoBackup));
        } catch (IOException e) {
            System.out.println("Erro ao apagar backup: " + e.getMessage());
        }
    }
}