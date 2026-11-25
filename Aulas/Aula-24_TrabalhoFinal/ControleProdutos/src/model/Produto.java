package model;

public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private double preco;
    private int qtdEstoque;

    public Produto(int id, String nome, String categoria, double preco, int qtdEstoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;


    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco
                + ", qtdEstoque=" + qtdEstoque + "]";
    }
}
