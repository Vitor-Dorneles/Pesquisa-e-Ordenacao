package main.java.model;

public class ResultadoOrdenacao {

    private final long comparacoes;
    private final long trocas;

    public ResultadoOrdenacao(long comparacoes, long trocas) {
        this.comparacoes = comparacoes;
        this.trocas = trocas;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getTrocas() {
        return trocas;
    }
}
