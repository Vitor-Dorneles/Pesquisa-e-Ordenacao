package main.java.model;

import java.util.List;

public class Ordenacao {
    //bubble sort
    public static ResultadoOrdenacao bolha(List<Integer> lista) {

        // Controla se alguma troca aconteceu na última passagem completa pela lista.
        // Serve para parar o algoritmo assim que a lista já estiver ordenada,
        // sem precisar continuar repetindo passagens desnecessárias.
        boolean houveTroca;

        // Contadores usados só para medir o custo do algoritmo (não fazem parte
        // da lógica de ordenação em si).
        long comparacoes = 0;
        long trocas = 0;

        // "do while": a primeira passagem sempre acontece, e o laço só se repete
        // enquanto a passagem anterior tiver realizado ao menos uma troca.
        do {
            houveTroca = false;

            // Percorre a lista comparando cada elemento com o seu vizinho da direita.
            // "size() - 1" evita acessar i + 1 fora dos limites da lista no último elemento.
            for (int i = 0; i < lista.size() - 1; i++) {

                comparacoes++;

                // Se o elemento atual é maior que o seguinte, eles estão fora de ordem.
                if (lista.get(i) > lista.get(i + 1)) {

                    // Troca clássica com variável auxiliar: guarda o valor de i
                    // antes de sobrescrevê-lo, senão ele seria perdido.
                    int auxiliar = lista.get(i);

                    lista.set(i, lista.get(i + 1));
                    //lista.set(indice, valor a trocar)
                    lista.set(i + 1, auxiliar);

                    trocas++;
                    houveTroca = true; // marca que essa passagem não terminou "limpa"
                }
            }

            // Se não houve troca, a lista está ordenada: a condição do while falha
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



    public static ResultadoOrdenacao penteOrdenacao(List<Integer> lista) {

        boolean houveTroca;
        long comparacoes = 0;
        long trocas = 0;
        int gap = lista.size();

        do {
            gap = (int) (gap/1.3);
            if (gap < 1)gap = 1;
            
            houveTroca = false;
            for (int i = 0; i + gap < lista.size(); i++) {
                comparacoes++;

                if (lista.get(i) > lista.get(i + gap)) {
                    
                    int auxiliar = lista.get(i);
                    lista.set(i, lista.get(i + gap)); // o valor de i + gap vai para i
                    lista.set(i + gap, auxiliar);
                    trocas++;
                    houveTroca = true;
                }
            }
         }  while (gap > 1 || houveTroca);

         return new ResultadoOrdenacao(comparacoes, trocas);
        }




}
