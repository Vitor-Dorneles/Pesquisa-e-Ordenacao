package main.java.view;

import java.util.List;

// classe que faz a apresentação para o usuário
public class ListaView {

    public void exibirLista(List<Integer> lista) {
        System.out.println(lista);
    }

    // ela recebera o nome do algoritmo e seu tempo para apresentar
    public void exibirTempo(String algoritmo, long tempo) {
        System.out.println(
                algoritmo + ": " + tempo + " ns");
    }
}