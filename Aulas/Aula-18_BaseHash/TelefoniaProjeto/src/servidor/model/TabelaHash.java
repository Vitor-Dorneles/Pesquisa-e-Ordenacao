package servidor.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Tabela hash das sessões de telefonia.
 * Chave: número do celular. Valor: a Sessao daquele número.
 */
public class TabelaHash {
    private final HashMap<String, Sessao> sessoes = new HashMap<>();

    /** Insere a sessão; se o número já existir, a sessão anterior é substituída. */
    public void adicionar(Sessao sessao) {
        sessoes.put(sessao.getNumeroCelular(), sessao);
    }

    public void limpar() {
        sessoes.clear();
    }

    public int tamanho() {
        return sessoes.size();
    }

    /** Todas as sessões, somente leitura. A ordem é a da tabela hash, não a do arquivo. */
    public Collection<Sessao> todas() {
        return Collections.unmodifiableCollection(sessoes.values());
    }
}
