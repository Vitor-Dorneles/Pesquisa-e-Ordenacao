package main.java.controller;

import java.util.List;

import main.java.model.Ordenacao;
import main.java.model.Utilidades;
import main.java.view.ListaView;

//controla o fluxo do programa, é a classe que faz as chamadas para as outras
public class ListaController {

    private ListaView view;

    public ListaController() {
        view = new ListaView();
    }

    public void executar() {

        // Criação das listas
        List<Integer> listaBolha = Utilidades.popularLista(5000);

        List<Integer> listaSelecao = Utilidades.popularLista(5000);

        List<Integer> listaInsercao = Utilidades.popularLista(5000);

        
        // BOLHA
        long inicio = System.nanoTime();

        Ordenacao.bolha(listaBolha);

        long fim = System.nanoTime();

        view.exibirTempo(
                "Bolha",
                fim - inicio);


        // SELEÇÃO
        inicio = System.nanoTime();

        Ordenacao.selecao(listaSelecao);

        fim = System.nanoTime();

        view.exibirTempo(
                "Seleção",
                fim - inicio);


        // INSERÇÃO
        inicio = System.nanoTime();

        Ordenacao.insercao(listaInsercao);

        fim = System.nanoTime();

        view.exibirTempo(
                "Inserção",
                fim - inicio);
    }
}