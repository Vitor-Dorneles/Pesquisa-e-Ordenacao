import javax.swing.JOptionPane;

/**
 * Interação com o usuário. Não sabe nada de como a tabela funciona por
 * dentro: só pede nomes, chama inserir/pesquisar e mostra o resultado.
 *
 * Fluxo:
 *   1) inserir nomes até digitar SAIR (ou cancelar);
 *   2) mostrar a tabela, posição por posição;
 *   3) pesquisar nomes até digitar SAIR (ou cancelar).
 */
public class Principal {

    /** Poucas posições de propósito, para as colisões aparecerem. */
    private static final int TAMANHO = 10;

    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash(TAMANHO);

        // 1) Inserção
        String nome;
        while ((nome = lerNome("Informe um nome para inserir (SAIR para terminar)")) != null) {
            int endereco = tabelaHash.inserir(nome);
            if (endereco == -1) {
                System.out.println(nome + " já está na tabela, não foi inserido de novo");
            } else {
                System.out.println(nome + " inserido no endereço " + endereco);
            }
        }

        // 2) Exibição: mostra como os nomes se espalharam
        String conteudo = tabelaHash.exibir();
        System.out.println();
        System.out.println(conteudo);
        JOptionPane.showMessageDialog(null, conteudo, "Tabela hash", JOptionPane.INFORMATION_MESSAGE);

        // 3) Pesquisa
        while ((nome = lerNome("Informe um nome para pesquisar (SAIR para terminar)")) != null) {
            int endereco = tabelaHash.pesquisar(nome);
            if (endereco != -1) {
                JOptionPane.showMessageDialog(null, nome + " localizado no endereço " + endereco);
            } else {
                JOptionPane.showMessageDialog(null, nome + " não localizado");
            }
        }
    }

    /**
     * Lê um nome com JOptionPane.
     *
     * Corrige o erro da versão original: ao clicar em Cancelar ou fechar a
     * janela, showInputDialog devolve null, e nome.equalsIgnoreCase("SAIR")
     * dava NullPointerException. Aqui null e "SAIR" significam a mesma coisa.
     * Também pede de novo quando o nome vem vazio.
     *
     * @return o nome sem espaços nas pontas, ou null se o usuário quis sair
     */
    private static String lerNome(String mensagem) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(null, mensagem);

            if (entrada == null || entrada.trim().equalsIgnoreCase("SAIR")) {
                return null;
            }
            if (!entrada.isBlank()) {
                return entrada.trim();
            }
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio");
        }
    }
}
