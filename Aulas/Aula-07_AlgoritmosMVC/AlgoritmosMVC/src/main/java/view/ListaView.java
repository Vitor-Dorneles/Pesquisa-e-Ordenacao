package main.java.view;

import java.util.List;

public class ListaView {

    public void exibirLista(List<Integer> lista) {
        System.out.println(lista);
    }

    public void exibirResultado(String algoritmo, long tempoNano, long comparacoes, long trocas) {
        System.out.println(algoritmo + ":");
        System.out.println("  Tempo: " + tempoNano + " nanoS");
        System.out.println("  Comparações: " + comparacoes);
        System.out.println("  Trocas: " + trocas);
    }
}
