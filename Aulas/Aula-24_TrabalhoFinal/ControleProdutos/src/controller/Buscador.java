package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Produto;

public class Buscador {
    public static Produto buscaLinear(List<Produto> lista, int id) {
        for (Produto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static Produto pesquisaBinaria(List<Produto> lista, int numero) {
        int ini = 0;
        int fim = lista.size() - 1;
        int meio;

        while (ini <= fim) {
            meio = (ini + fim) / 2;
            Produto temp = lista.get(meio);

            if (numero == temp.getId()) {
                return temp;
            }
            if (numero < temp.getId()) {
                fim = meio - 1;
            } else {
                ini = meio + 1;
            }
        }
        return null;
    }
    
    public static HashMap<Integer, Produto> montaMapaId(List<Produto> lista) {
        HashMap<Integer, Produto> mapa = new HashMap<>();
        for (Produto produto : lista) {
            mapa.put(produto.getId(), produto);
        }
        return mapa;
    }

    public static Produto buscaHash(HashMap<Integer, Produto> mapa, int id) {
        return mapa.get(id);
    }

    public static HashMap<String, List<Produto>> montaMapaCategoria(List<Produto> lista) {
        HashMap<String, List<Produto>> mapa = new HashMap<>();
        for (Produto produto : lista) {
            List<Produto> grupoCategoria = mapa.get(produto.getCategoria());
            if (grupoCategoria == null) {
                grupoCategoria = new ArrayList<>();

                mapa.put(produto.getCategoria(), grupoCategoria);
            }
            grupoCategoria.add(produto);
        }
        return mapa;
    }
}
