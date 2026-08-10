package controller;

import model.ListaNumeros;
import view.MedicaoTempoView;

import java.util.ArrayList;
import java.util.List;

public class MedicaoTempo {

    public void executarProcessamento() {
        long tempoInicio, tempoFim;
        List<Integer> listaAleatoria = new ArrayList<>();
        List<Integer> listaSequencial = new ArrayList<>();

        // Rotina 1: Aleatória
        tempoInicio = System.nanoTime();
        ListaNumeros.popularLista(listaAleatoria, 100000, 100, 100000, true);
        tempoFim = System.nanoTime();
        MedicaoTempoView.exibirTempoExecucao(1, (tempoFim - tempoInicio) / 1000000);

        // Rotina 2: Sequencial
        tempoInicio = System.nanoTime();
        ListaNumeros.popularLista(listaSequencial, 100000, 1, 100000, false);
        tempoFim = System.nanoTime();
        MedicaoTempoView.exibirTempoExecucao(2, (tempoFim - tempoInicio) / 1000000);

        // Descomente se quiser exibir as listas:
        // ExibicaoView.exibirLista(listaAleatoria, "Lista Aleatória:");
    }
}