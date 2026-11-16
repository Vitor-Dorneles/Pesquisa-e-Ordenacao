package servidor.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;


public class TabelaHash {
    private final HashMap<String, Sessao> sessoes = new HashMap<>();

    public void adicionar(Sessao sessao) {
        sessoes.put(sessao.getNumeroCelular(), sessao);
    }

 
    public Optional<Sessao> buscar(String numeroCelular) {
        return Optional.ofNullable(sessoes.get(numeroCelular));
    }

    public void limpar() {
        sessoes.clear();
    }

    public int tamanho() {
        return sessoes.size();
    }

    public Collection<Sessao> todas() {
        return Collections.unmodifiableCollection(sessoes.values());
    }
}
