package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// responsável por criar e popular a lista
// fornece os métodos auxiliares que o programa precisa
public class Utilidades {

    public static List<Integer> popularLista(int quantidade) {

        List<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            lista.add(random.nextInt(10000));
        }

        return lista;
    }
}