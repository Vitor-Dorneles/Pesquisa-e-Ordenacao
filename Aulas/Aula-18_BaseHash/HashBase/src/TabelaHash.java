import java.util.ArrayList;
import java.util.List;

/**
 * Tabela hash ABERTA (tratamento de colisão por encadeamento).
 *
 * Estrutura: um vetor de tamanho fixo em que cada posição guarda uma LISTA
 * (o "balde"). Todos os nomes que a função hash manda para a mesma posição
 * ficam juntos na lista daquela posição.
 *
 *   posição 0 -> []
 *   posição 1 -> [Ana]
 *   posição 2 -> [Bruno, Carla]   <- colisão: dois nomes, mesma posição
 *   ...
 *
 * Inserir e pesquisar seguem o mesmo roteiro:
 *   1) calcular o endereço com a função hash (vai direto à posição, sem percorrer o vetor);
 *   2) trabalhar só na lista daquela posição.
 * Se a função espalha bem, cada lista é curta e a operação é O(1) na média.
 * Se tudo cai na mesma posição, vira uma lista só e a busca piora para O(n).
 */
public class TabelaHash {

    /*
     * Vetor de listas. Usamos List<List<String>> em vez de List<String>[]
     * porque Java não deixa criar vetor de tipo genérico (new List<String>[n]
     * não compila), e o vetor "cru" (List[]) perde a checagem de tipo.
     */
    private final List<List<String>> tabela;

    /**
     * Cria a tabela com todas as posições já inicializadas com uma lista vazia.
     * Sem isso, cada posição seria null e o primeiro add() daria NullPointerException.
     *
     * @param tamanho quantidade de posições (endereços) do vetor
     */
    public TabelaHash(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("O tamanho da tabela deve ser positivo");
        }
        tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            tabela.add(new ArrayList<>());
        }
    }

    /**
     * FUNÇÃO HASH: transforma a chave (o nome) num endereço entre 0 e tamanho-1.
     *
     * Versão original da aula: nome.length() % tamanho.
     *   Problema: todos os nomes com o mesmo número de letras caem na mesma
     *   posição ("Ana", "Bia" e "Léo" -> 3). Nomes costumam ter 3 a 8 letras,
     *   então quase toda a tabela fica vazia e poucas posições acumulam tudo.
     *
     * Versão atual: soma dos códigos dos caracteres % tamanho.
     *   'A' = 65, 'n' = 110, 'a' = 97 -> "Ana" = 272 -> 272 % 10 = 2
     *   Usa o conteúdo do nome, não só o tamanho, e por isso espalha melhor.
     *   Ainda colide com anagramas: "amor" e "roma" têm as mesmas letras,
     *   a mesma soma e o mesmo endereço. Colisão sempre vai existir; a função
     *   boa só a torna rara. (O hashCode() da String em Java multiplica por 31
     *   a cada letra justamente para a ordem das letras contar.)
     *
     * Regra de ouro: a mesma chave SEMPRE gera o mesmo endereço. É isso que
     * permite achar depois o que foi guardado.
     */
    public int calcularEndereco(String nome) {
        int soma = 0;
        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);   // char vira o seu código numérico (Unicode)
        }
        return soma % tabela.size();
    }

    /**
     * Insere o nome na lista da posição calculada.
     * A chave não se repete: se o nome já está na tabela, não insere de novo
     * (é o mesmo comportamento do HashSet).
     *
     * @return o endereço onde o nome está, ou -1 se ele já existia
     */
    public int inserir(String nome) {
        int endereco = calcularEndereco(nome);
        List<String> balde = tabela.get(endereco);

        if (balde.contains(nome)) {
            return -1;
        }
        balde.add(nome);
        return endereco;
    }

    /**
     * Pesquisa: calcula o endereço de novo e procura SÓ naquela lista.
     * O contains() é uma busca sequencial, mas restrita ao balde, que deve ser
     * pequeno. As outras posições nem são olhadas.
     *
     * @return o endereço onde o nome foi encontrado, ou -1 se não existe
     */
    public int pesquisar(String nome) {
        int endereco = calcularEndereco(nome);

        if (tabela.get(endereco).contains(nome)) {
            return endereco;
        }
        return -1;
    }

    /**
     * Monta um texto com cada posição e o conteúdo da sua lista,
     * para enxergar como os nomes se espalharam e onde houve colisão.
     */
    public String exibir() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < tabela.size(); i++) {
            List<String> balde = tabela.get(i);
            texto.append("posição ").append(i).append(" -> ").append(balde);
            if (balde.size() > 1) {
                texto.append("   (colisão: ").append(balde.size()).append(" nomes)");
            }
            texto.append('\n');
        }
        return texto.toString();
    }
}
