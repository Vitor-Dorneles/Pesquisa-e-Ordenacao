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

    public static ArrayList shell(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i, j, n=1;
        int distancia = 1;

        int referenciaTamanho = 3;

        do {
            distancia = referenciaTamanho * distancia +1;
        } while (distancia < n);

        do {
            distancia = (int) (distancia / referenciaTamanho);

            for (i = distancia; i < n; i++) {
                aux = vetor[i];
                for (j = i - distancia; j >= 0; j = j - distancia) {
                    qtdComparacoes++;
                    if (aux < vetor[j]) {
                        vetor[j + distancia] = vetor[j];
                        qtdTrocas++;
                    } else
                        break;
                }
                vetor[j + distancia] = aux;
                qtdTrocas++;
            }
        } while (distancia > 1);        
    }
}
