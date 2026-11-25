package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.HashMap;

import model.Produto;

public class Medidor {
    public static final int repeticoes = 1000;
    
    public static long medirBolha(List<Produto> lista, Comparator<Produto> c) {
        long tempoInicio = System.nanoTime();
        Ordenador.bolha(lista, c);
        long tempoFim = System.nanoTime();
        return tempoFim - tempoInicio;
    }

    public static long medirMerge(List<Produto> lista, Comparator<Produto> c) {
        long tempoInicio = System.nanoTime();
        Ordenador.merge(lista, c);
        long tempoFim = System.nanoTime();
        return tempoFim - tempoInicio;
    }

    public static long medirBuscaLinear(List<Produto> lista, int id) {
        long tempoInicio = System.nanoTime();
        for (int i = 0; i < repeticoes; i++) {
            Buscador.buscaLinear(lista, id);
        }
        long tempoFim = System.nanoTime();
        return (tempoFim - tempoInicio) / repeticoes;
    }

    public static long medirBuscaBinaria(List<Produto> listaPorID, int id) {
        long tempoInicio = System.nanoTime();
        for (int i = 0; i < repeticoes; i++) {
            Buscador.pesquisaBinaria(listaPorID, id);
        }
        long tempoFim = System.nanoTime();
        return (tempoFim - tempoInicio) / repeticoes;
    }

    public static long medirBuscaHash(HashMap<Integer, Produto> mapa, int id) {
        long tempoInicio = System.nanoTime();
        for (int i = 0; i < repeticoes; i++) {
            Buscador.buscaHash(mapa, id);
        }
        long tempoFim = System.nanoTime();
        return (tempoFim - tempoInicio) / repeticoes;
    }
    
    public static long medirBuscaCategoria(HashMap<String, List<Produto>> mapa, String categoria) {
        long tempoInicio = System.nanoTime();
        for (int i = 0; i < repeticoes; i++) {
            mapa.get(categoria);
        }
        long tempoFim = System.nanoTime();
        return (tempoFim - tempoInicio) / repeticoes;
    }
    

    public static long medirMontaMapa(List<Produto> lista) {
        long tempoInicio = System.nanoTime();
        Buscador.montaMapaId(lista);
        long tempoFim = System.nanoTime();
        return (tempoFim - tempoInicio);
    }
    

}
