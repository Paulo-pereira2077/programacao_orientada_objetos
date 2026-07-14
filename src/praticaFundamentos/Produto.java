package praticaFundamentos;

public class Produto {
    private int qtd;
    private String produto;
    private float preco;

    public Produto(int qtd, float preco, String produto) {
        this.produto = produto;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
