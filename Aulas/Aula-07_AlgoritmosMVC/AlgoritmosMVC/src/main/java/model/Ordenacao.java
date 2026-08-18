package main.java.model;

import java.util.List;

public class Ordenacao {

    public static ResultadoOrdenacao bolha(List<Integer> lista) {

        boolean houveTroca;
        long comparacoes = 0;
        long trocas = 0;

        do {
            houveTroca = false;

            for (int i = 0; i < lista.size() - 1; i++) {

                comparacoes++;

                if (lista.get(i) > lista.get(i + 1)) {

                    int auxiliar = lista.get(i);

                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, auxiliar);

                    trocas++;
                    houveTroca = true;
                }
            }

        } while (houveTroca);
        
        // Retornando um novo construtor
        return new ResultadoOrdenacao(comparacoes, trocas);
    }

    public static ResultadoOrdenacao selecao(List<Integer> lista) {

        long comparacoes = 0;
        long trocas = 0;

        for (int i = 0; i < lista.size() - 1; i++) {

            int posMenor = i;

            for (int j = i + 1; j < lista.size(); j++) {

                comparacoes++;

                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }

            if (i != posMenor) {

                int auxiliar = lista.get(i);

                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, auxiliar);

                trocas++;
            }
        }

        return new ResultadoOrdenacao(comparacoes, trocas);
    }

    public static ResultadoOrdenacao insercao(List<Integer> lista) {

        long comparacoes = 0;
        long trocas = 0;

        for (int i = 1; i < lista.size(); i++) {

            int auxiliar = lista.get(i);
            int j = i - 1;

            while (j >= 0) {

                comparacoes++;

                if (auxiliar < lista.get(j)) {

                    lista.set(j + 1, lista.get(j));
                    trocas++;
                    j--;
                } else {
                    break;
                }
            }

            lista.set(j + 1, auxiliar);
        }

        return new ResultadoOrdenacao(comparacoes, trocas);
    }

    public static ResultadoOrdenacao agitacao(List<Integer> lista) {

        boolean houveTroca;
        long comparacoes = 0;
        long trocas = 0;
        int inicio = 0;
        int fim = lista.size() - 1;

        do {
            houveTroca = false;

            for (int i = inicio; i < fim; i++) {

                comparacoes++;

                if (lista.get(i) > lista.get(i + 1)) {

                    int auxiliar = lista.get(i);

                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, auxiliar);

                    trocas++;
                    houveTroca = true;
                }
            }

            fim--;

            if (!houveTroca) {
                break;
            }

            houveTroca = false;

            for (int i = fim; i > inicio; i--) {

                comparacoes++;

                if (lista.get(i) < lista.get(i - 1)) {

                    int auxiliar = lista.get(i);

                    lista.set(i, lista.get(i - 1));
                    lista.set(i - 1, auxiliar);

                    trocas++;
                    houveTroca = true;
                }
            }

            inicio++;

        } while (houveTroca);

        return new ResultadoOrdenacao(comparacoes, trocas);
    }
}
