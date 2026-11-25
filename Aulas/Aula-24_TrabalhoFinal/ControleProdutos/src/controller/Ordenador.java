package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Produto;

public class Ordenador {
    

    public static void bolha(List<Produto> lista, Comparator<Produto> c) {
        Produto aux;
        boolean houveTroca;
        int i;

        do {
            houveTroca = false;

            for (i = 0; i < lista.size() - 1; i++) {

                if (c.compare(lista.get(i), lista.get(i+1)) > 0 ) {
                    houveTroca = true; //deverá haver, pois o elemento I vem deveria vir depois que o proximo
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                }
            }
        } while (houveTroca);
    }
    
    public static void merge(List<Produto> lista, Comparator<Produto> c) {
        if (lista.size() < 2) {
            return;
        }
        List<Produto> aux = new ArrayList<>(lista);
        mergeRecursivo(lista, aux, 0, lista.size() - 1, c);
    }

    private static void mergeRecursivo(List<Produto> lista, List<Produto> aux, int inicio, int fim,
            Comparator<Produto> c) {
        if (inicio >= fim) {
            return;
        }
        int meio = (fim + inicio) / 2;

        mergeRecursivo(lista, aux, inicio, meio, c);
        mergeRecursivo(lista, aux, meio + 1, fim, c);
        intercala(lista, aux, inicio, meio, fim, c);
    }
    
    private static void intercala(List<Produto> lista, List<Produto> aux, int inicio, int meio, int fim,
            Comparator<Produto> c) {
        for (int k = inicio; k <= fim; k++) {
            aux.set(k, lista.get(k));
        }

        int iESQ = inicio;
        int jDir = meio + 1;
        int k = inicio;

        while (iESQ <= meio && jDir <= fim) {
            if (c.compare(aux.get(iESQ), aux.get(jDir)) <= 0) {
                Produto temp = aux.get(iESQ);
                lista.set(k, temp);
                iESQ++;
                k++;
            } else {
                Produto temp = aux.get(jDir);
                lista.set(k, temp);
                jDir++;
                k++;
            }
        }

        while (iESQ <= meio) {
            Produto temp = aux.get(iESQ);
            lista.set(k, temp);
            iESQ++;
            k++;
        }
        while (jDir <= fim) {
            Produto temp = aux.get(jDir);
            lista.set(k, temp);
            jDir++;
            k++;
        }
    }
    
}
