package praticaFundamentos;

public class Produto {

    private String produto;
    private int qtd;
    private float preco;

    public Produto(String produto, int qtd, float preco) {
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
