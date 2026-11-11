package controller;

import java.util.ArrayList;

public class Ordenacao {

    public static ArrayList bolha(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;

        do {
            houveTroca = false;

            for (i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;

                if (lista.get(i) > lista.get(i + 1)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                    qtdTrocas++;                  
                }
            }
        } while (houveTroca);

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);

        return metricas;
    }


    public static ArrayList selecao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, posMenor, aux;

        for (i = 0; i < lista.size(); i++) {
            posMenor = i;

            for (j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;

                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }

            if (posMenor != i) {
                aux = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, aux);

                qtdTrocas++;
            }
        }

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);

        return metricas;
    }


    public static ArrayList insercao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, aux;

        for (i = 1; i < lista.size(); i++) {
            aux = lista.get(i);

            for (j = i - 1; j >= 0 && aux < lista.get(j); j--) {
                qtdComparacoes++;
                qtdTrocas++;
                lista.set(j + 1, lista.get(j));
                
            }

            if (j >= 0) {
                qtdComparacoes++;
            }

            lista.set(j + 1, aux);
        }

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);

        return metricas;
    }


    public static ArrayList pente(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        int distancia = lista.size();

        do {
            distancia = (int) (distancia / 1.3);

            if (distancia <= 0) {
                distancia = 1;
            }

            houveTroca = false;

            for (i = 0; i + distancia < lista.size(); i++) {
                qtdComparacoes++;

                if (lista.get(i) > lista.get(i + distancia)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, aux);
                    qtdTrocas++;
                }
            }

        } while (distancia > 1 || houveTroca);

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);

        return metricas;
    }

    /**
     * Shell Sort: inserção com saltos. Em vez de comparar vizinhos, compara
     * elementos a "distancia" posições; a distância vai diminuindo até 1,
     * quando vira a inserção comum, mas com a lista já quase ordenada.
     * Sequência de distâncias de Knuth: 1, 4, 13, 40, ... (d = 3d + 1).
     */
    public static ArrayList shell(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        int i, j;
        int n = lista.size();
        int distancia = 1;

        int referenciaTamanho = 3;

        // sobe a distância pela sequência 1, 4, 13, 40... até passar do tamanho
        do {
            distancia = referenciaTamanho * distancia + 1;
        } while (distancia < n);

        do {
            distancia = distancia / referenciaTamanho;

            // inserção, mas andando de "distancia" em "distancia"
            for (i = distancia; i < n; i++) {
                aux = lista.get(i);
                for (j = i - distancia; j >= 0; j = j - distancia) {
                    qtdComparacoes++;
                    if (aux < lista.get(j)) {
                        lista.set(j + distancia, lista.get(j));   // desloca para frente
                        qtdTrocas++;
                    } else {
                        break;
                    }
                }
                lista.set(j + distancia, aux);   // encaixa aux no lugar aberto
            }
        } while (distancia > 1);

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);

        return metricas;
    }
}
