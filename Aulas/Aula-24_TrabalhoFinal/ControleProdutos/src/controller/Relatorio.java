package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import model.ArquivoProduto;
import model.Produto;

public class Relatorio {
    private static String[] medirArquivo(String caminho) {
        ArquivoProduto arquivo = new ArquivoProduto(caminho);
        List<Produto> listaLida = arquivo.leArquivo();

        int idFinal = listaLida.get(listaLida.size() - 1).getId();

        List<Produto> listaPorID = new ArrayList<>(listaLida);
        Ordenador.merge(listaPorID, Comparadores::comparaID);

        HashMap<Integer, Produto> mapa = Buscador.montaMapaId(listaLida);

        long tempoMerge = Medidor.medirMerge(new ArrayList<>(listaLida), Comparadores::comparaPreco);
        long tempoLinear = Medidor.medirBuscaLinear(listaLida, idFinal);
        long tempoBinaria = Medidor.medirBuscaBinaria(listaPorID, idFinal);
        long tempoHash = Medidor.medirBuscaHash(mapa, idFinal);
        long tempoMapa = Medidor.medirMontaMapa(listaLida);

        String[] registroTempos = new String[6];
        
        registroTempos[1] = emMs(tempoMerge);
        registroTempos[2] = emNs(tempoLinear);
        registroTempos[3] = emNs(tempoBinaria);
        registroTempos[4] = emNs(tempoHash);
        registroTempos[5] = emMs(tempoMapa);
        registroTempos[0] = bolhaComLimite(listaLida);

        return registroTempos;
    }

    private static String bolhaComLimite(List<Produto> lista) {
        long[] resultado = new long[1];

        Thread auxiliar = new Thread(() -> resultado[0] = Medidor.medirBolha(new ArrayList<>(lista), Comparadores::comparaPreco));
        
        auxiliar.setDaemon(true);
        auxiliar.start();

        try {
            auxiliar.join(120_000); //maximo de 2 minutos
        } catch (InterruptedException e) {
            return "Thread Interrompida";
        }
        if (auxiliar.isAlive()) {
            return "não concluído (> 2 min)";
        }
        return emMs(resultado[0]);
    }

    private static String emMs(long nanos) {
        return String.format(Locale.US, "%.2f", nanos / 1_000_000.0);
    }

    private static String emNs(long nanos) {
        return String.valueOf(nanos);
    }

    private static void gravarRelatorio(String[] col1000, String[] col10000, String[] col50000) {
        String[] operacoes = {
                "Ordenação Simples (por preço)(ms)",
                "Ordenação mais eficiente (por preço)(ms)",
                "Busca linear por id (média) (ns)",
                "Busca binária por id (média) (ns)",
                "Busca por HashMap (média) (ns)",
                "Construção do HashMap (ms)"
        };

        try {
            FileWriter arqEscrita = new FileWriter("relatorio.txt", StandardCharsets.UTF_8, false);

            BufferedWriter escritor = new BufferedWriter(arqEscrita);

            escritor.write("Operação;1.000;10.000;50.000");
            escritor.newLine();

            for (int i = 0; i < operacoes.length; i++) {
                escritor.write(operacoes[i] + ";" + col1000[i] + ";" + col10000[i] + ";" + col50000[i]);
                escritor.newLine();
            }

            escritor.newLine();
            escritor.write("Análise:");
            escritor.newLine();
            escritor.write("- HashMap e binária foram as mais rápidas, muito mais rápidas que a linear.");
            escritor.newLine();
            escritor.write("- Linear: o tempo cresceu junto com a lista, porque ela compara produto por produto até achar o id.");
            escritor.newLine();
            escritor.write("- Binária: o tempo quase não mudou com a lista maior, porque a cada comparação ela descarta metade da lista ordenada.");
            escritor.newLine();
            escritor.write("- HashMap: o tempo ficou igual nos três tamanhos, porque calcula onde o produto está e vai direto. Mas montar é demorado, o que não compensa se for fazer poucas buscas.");
            escritor.newLine();
            escritor.write("- Vale montar o HashMap quando forem feitas muitas buscas. Para uma busca só, a linear resolve.");
            escritor.newLine();

            escritor.close();
            arqEscrita.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void gerarRelatorio() {
        for (int i = 0; i < 3; i++) {
            medirArquivo("Dados/produtos_1000.txt");
        }
        String[] col1000 = medirArquivo("Dados/produtos_1000.txt");
        String[] col10000 = medirArquivo("Dados/produtos_10000.txt");
        String[] col50000 = medirArquivo("Dados/produtos_50000.txt");
        
        gravarRelatorio(col1000, col10000, col50000);

        
    }
}
