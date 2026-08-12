package main.java.model;

import java.util.List;

// responsável por implementar os algoritmos que vão trabalhar com a lista, a sua ordenaçao
public class Ordenacao {

    public static void bolha(List<Integer> lista) {

        boolean houveTroca;

        do {
            houveTroca = false;

            for (int i = 0; i < lista.size() - 1; i++) {

                if (lista.get(i) > lista.get(i + 1)) {

                    int auxiliar = lista.get(i);

                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, auxiliar);

                    houveTroca = true;
                }
            }

        } while (houveTroca);
    }

    public static void selecao(List<Integer> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {

            int posMenor = i;

            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }

            if (i != posMenor) {

                int auxiliar = lista.get(i);

                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, auxiliar);
            }
        }
    }

    public static void insercao(List<Integer> lista) {

        for (int i = 1; i < lista.size(); i++) {

            int auxiliar = lista.get(i);
            int j = i - 1;

            while (j >= 0 && auxiliar < lista.get(j)) {

                lista.set(j + 1, lista.get(j));
                j--;
            }

            lista.set(j + 1, auxiliar);
        }
    }
}