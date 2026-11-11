package servidor.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import servidor.model.Sessao;
import servidor.model.TabelaHash;

/**
 * Faz a ponte entre a tela e o modelo: lê o arquivo da base e
 * preenche a TabelaHash. A view não conhece arquivo nem HashMap.
 */
public class ServidorController {
    private static final String SEPARADOR = ";";

    private final TabelaHash tabela = new TabelaHash();

    /**
     * Lê o arquivo (uma sessão por linha, no formato "celular;dados")
     * e substitui o conteúdo da tabela.
     *
     * @param caminho caminho do arquivo da base
     * @return quantidade de sessões carregadas
     * @throws IOException se o arquivo não existir, não puder ser lido
     *                     ou tiver uma linha fora do formato
     */
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

                // limite 2: só o primeiro ';' separa; o resto é dado da sessão
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

    /** Texto com as sessões carregadas, uma por linha, para exibição. */
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
