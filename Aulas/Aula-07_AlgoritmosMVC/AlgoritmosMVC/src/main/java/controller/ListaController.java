package main.java.controller;

import java.util.List;

import main.java.model.Ordenacao;
import main.java.model.ResultadoOrdenacao;
import main.java.model.Utilidades;
import main.java.view.ListaView;

public class ListaController {

    private ListaView view;

    public ListaController() {
        view = new ListaView();
    }

    public void executar() {

        List<Integer> listaBolha = Utilidades.popularLista(5000);
        List<Integer> listaSelecao = Utilidades.popularLista(5000);
        List<Integer> listaInsercao = Utilidades.popularLista(5000);
        List<Integer> listaAgitacao = Utilidades.popularLista(5000);
        List<Integer> listaPente = Utilidades.popularLista(5000);

        long inicio = System.nanoTime();
        ResultadoOrdenacao resultadoBolha = Ordenacao.bolha(listaBolha);
        long fim = System.nanoTime();

        view.exibirResultado(
                "Bolha",
                fim - inicio,
                resultadoBolha.getComparacoes(),
                resultadoBolha.getTrocas());

        inicio = System.nanoTime();
        ResultadoOrdenacao resultadoSelecao = Ordenacao.selecao(listaSelecao);
        fim = System.nanoTime();

        view.exibirResultado(
                "Seleção",
                fim - inicio,
                resultadoSelecao.getComparacoes(),
                resultadoSelecao.getTrocas());

        inicio = System.nanoTime();
        ResultadoOrdenacao resultadoInsercao = Ordenacao.insercao(listaInsercao);
        fim = System.nanoTime();

        view.exibirResultado(
                "Inserção",
                fim - inicio,
                resultadoInsercao.getComparacoes(),
                resultadoInsercao.getTrocas());

        inicio = System.nanoTime();
        ResultadoOrdenacao resultadoAgitacao = Ordenacao.agitacao(listaAgitacao);
        fim = System.nanoTime();

        view.exibirResultado(
                "Agitação",
                fim - inicio,
                resultadoAgitacao.getComparacoes(),
                        resultadoAgitacao.getTrocas());
        
                        
        inicio = System.nanoTime();
        ResultadoOrdenacao resultadoPente = Ordenacao.penteOrdenacao(listaPente);
        fim = System.nanoTime();

        view.exibirResultado(
                        "Pente",
                        fim - inicio,
                        resultadoPente.getComparacoes(),
                        resultadoPente.getTrocas());
    }
}
