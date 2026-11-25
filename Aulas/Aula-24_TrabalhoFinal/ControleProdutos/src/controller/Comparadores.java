package controller;

import model.Produto;

public class Comparadores {
    public static int comparaNome(Produto a, Produto b) {
        return a.getNome().compareToIgnoreCase(b.getNome());
    }

    public static int comparaPreco(Produto a, Produto b) {
        return Double.compare(a.getPreco(), b.getPreco());
    }

    public static int comparaID(Produto a, Produto b) {
        return Integer.compare(a.getId(), b.getId());
    }
}
