package praticaFundamentos;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private int qtdTotalItens = 0;
    private double subtotal = 0.0;

    private List<Produto> lista = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        this.lista.add(p);
        this.qtdTotalItens += p.getQtd();
        this.subtotal += (p.getQtd() * p.getPreco());
    }

    public int getQtdTotalItens() {
        return qtdTotalItens;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public List<Produto> getListaDeProdutos(){
        return lista;
    }

    public void zerarCarrinho() {
        this.qtdTotalItens = 0;
        this.subtotal = 0.0;
        this.lista.clear();
    }
}