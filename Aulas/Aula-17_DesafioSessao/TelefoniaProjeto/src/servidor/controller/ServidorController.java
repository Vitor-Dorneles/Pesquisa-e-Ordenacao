package servidor.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import servidor.model.Sessao;
import servidor.model.TabelaHash;

/**
 * Faz a ligação entre a tela e o model: lê o arquivo da base e
 * preenche a TabelaHash.
 */
public class ServidorController {
    private static final String SEPARADOR = ";";

    private final TabelaHash tabela = new TabelaHash();


    public int carregarArquivo(String caminho) throws IOException {
        tabela.limpar();

        try (BufferedReader leitor = Files.newBufferedReader(Path.of(caminho), StandardCharsets.UTF_8)) {
            String linha;
            int numeroLinha = 0;

            while ((linha = leitor.readLine()) != null) {
                numeroLinha++;
                if (linha.isBlank()) {
                    continue;
                }

                
                String[] campos = linha.split(SEPARADOR, 2);
                if (campos.length < 2) {
                    tabela.limpar();
                    throw new IOException("linha " + numeroLinha + " fora do formato \"celular;dados\"");
                }

                tabela.adicionar(new Sessao(campos[0].trim(), campos[1]));
            }
        }

        return tabela.tamanho();
    }


   
    public Optional<Sessao> buscarSessao(String numeroDigitado) {
        String numero = numeroDigitado.replaceAll("\\D", "");
        return tabela.buscar(numero);
    }

    public boolean baseCarregada() {
        return tabela.tamanho() > 0;
    }

    public String listarSessoes() {
        StringBuilder texto = new StringBuilder();
        for (Sessao sessao : tabela.todas()) {
            texto.append(sessao.getNumeroCelular())
                 .append(SEPARADOR)
                 .append(sessao.getDadosSessao())
                 .append('\n');
        }
        return texto.toString();
    }
}
