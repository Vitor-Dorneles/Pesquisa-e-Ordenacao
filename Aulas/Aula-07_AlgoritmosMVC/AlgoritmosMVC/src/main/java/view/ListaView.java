package main.java.view;

import java.util.List;

public class ListaView {

    public void exibirLista(List<Integer> lista) {
        System.out.println(lista);
    }

    public void exibirResultado(String algoritmo, long tempoNano, long comparacoes, long trocas) {
        System.out.println(algoritmo + ":");
        System.out.printf("  Tempo: %.2f ms%n", tempoNano / 1_000_000.0);
        System.out.printf("  Comparações: %,d%n", comparacoes);
        System.out.printf("  Trocas: %,d%n", trocas);
    }
}
