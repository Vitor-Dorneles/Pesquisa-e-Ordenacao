// Data: 26/10/2026
## TRIE e PATRICIA
pesquisa digital com TRIE (vem de *retrieval*) ou PATRICIA (acrônimo), a TRIE compactada
- **Pesquisa digital:** percorre a chave pedaço por pedaço (dígito, letra ou bit); cada pedaço escolhe o ramo. Busca em O(m), m = tamanho da chave (palavra).
  - Diferente da busca binária, não compara a chave inteira a cada passo: olha um dígito por nível.
- **TRIE:** um nó por dígito/caractere. O primeiro dígito costuma ser um nó de colisão, porque muitas chaves começam igual.
  - **Nó de colisão:** nó por onde passa mais de uma chave, porque elas têm o mesmo dígito ali; a árvore precisa descer mais para separá-las.
  - **Fim de palavra (`*`):** marca no nó onde termina uma chave válida; `AMO` existe como caminho dentro de `AMOR`, mas só é palavra se estiver marcado.
- **PATRICIA (TRIE compacta):** junta os nós com um filho só e deixa nó apenas onde as chaves se separam.
  - **Nó de desvio:** não guarda chave; guarda qual caractere/posição testar, o que ajuda na decisão do ramo.
  - **Nó de armazenamento:** folha que guarda a chave inteira. A primeira chave inserida já vira nó de armazenamento; o desvio só aparece quando chega uma chave diferente.
  - **Compactação de caminhos:** um nó pode guardar uma sequência inteira (`"GATO"`) em vez de um caractere; todo nó interno tem pelo menos 2 filhos.
  - Mesma velocidade de busca da TRIE, com menos memória; o custo é inserção e remoção mais complexas.

## Profundidade da árvore
100 == essa palavra teria uma árvore de 3 de profundidade
- Um nível por dígito: raiz → `1` → `0` → `0`. Profundidade = tamanho da chave.
- Exemplo com `100` e `105` na TRIE: `1` e `0` são nós de colisão; as chaves só se separam no 3º dígito.
- As mesmas chaves na PATRICIA: um único nó de desvio ("testa o 3º dígito") com duas folhas, `100` e `105`.

## Gargalo da pesquisa digital
A TRIE simples é pouco usada, pois com palavras muito grandes, temos uma árvore muito grande, algo que dificulta a pesquisa; a PATRICIA (compactada) continua em uso
uma árvore muito grande é um grande gargalo da pesquisa digital
- Um nó por caractere, muitos com um filho só: gasta memória e passos sem decidir nada.
- Implementada com vetor, cada nó reserva um ponteiro para cada filho possível (26 letras, 10 dígitos), e a maioria fica nula.
- Exemplo `AMAR`, `AMOR`, `GATO`: a TRIE usa 10 nós (`G → A → T → O` em linha reta); a PATRICIA usa 4 (`AM`, `AR`, `OR`, `GATO`).
- Visto na Aula 16 (Hash): hash não mantém ordem; a trie mantém e permite busca por prefixo (autocompletar).
  - Busca exata: o caminho precisa existir **e** o último nó estar marcado como fim de palavra.
  - Busca por prefixo: basta o caminho existir (`"AM"` → `AMAR` e `AMOR`).



## Destilado


## Perguntas


## Erro que cometi
